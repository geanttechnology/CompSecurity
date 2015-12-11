// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.extension.pausead;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.extension.IExtension;
import tv.freewheel.extension.ParamParser;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.events.Event;

public class PauseAdExtension
    implements IExtension
{

    private IAdContext adContext;
    IEventListener adErrorListener;
    IEventListener adImpressionListener;
    private IConstants constants;
    private String currentPlayingPauseSlotCustomId;
    private Boolean enabled;
    private HashMap linearSlotToPauseSlotsMap;
    private Logger logger;
    private Boolean needDispatchContentResumeEvent;
    IEventListener requestCompleteListener;
    IEventListener slotEndedListener;
    IEventListener slotStartedListener;
    private String toBePlayedPauseSlotCustomId;
    IEventListener userActionNotified;

    public PauseAdExtension()
    {
        needDispatchContentResumeEvent = Boolean.valueOf(false);
        requestCompleteListener = new IEventListener() {

            final PauseAdExtension this$0;

            public void run(IEvent ievent)
            {
                if ("false".equalsIgnoreCase((String)(String)ievent.getData().get(constants.INFO_KEY_SUCCESS())))
                {
                    logger.debug("RequestComplete: false, return.");
                } else
                if (adContext != null)
                {
                    ievent = new ParamParser(adContext, "extension.pausead");
                    enabled = ievent.parseBoolean("enable", Boolean.valueOf(true));
                    if (!enabled.booleanValue())
                    {
                        logger.debug("PauseAdExtension is not enabled, return.");
                        return;
                    }
                    logger.debug("requestCompleteListener()");
                    Object obj = adContext.getTemporalSlots();
                    ievent = adContext.getSlotsByTimePositionClass(constants.TIME_POSITION_CLASS_PAUSE_MIDROLL());
                    obj = ((ArrayList) (obj)).iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        ISlot islot1 = (ISlot)((Iterator) (obj)).next();
                        if (islot1.getTimePositionClass() == constants.TIME_POSITION_CLASS_PREROLL() || islot1.getTimePositionClass() == constants.TIME_POSITION_CLASS_MIDROLL())
                        {
                            ArrayList arraylist = new ArrayList();
                            for (int i = 0; i < ievent.size(); i++)
                            {
                                ISlot islot2 = (ISlot)ievent.get(i);
                                if (islot2.getTimePosition() == islot1.getTimePosition())
                                {
                                    arraylist.add(islot2.getCustomId());
                                }
                            }

                            if (arraylist.size() > 0)
                            {
                                linearSlotToPauseSlotsMap.put(islot1.getCustomId(), arraylist);
                            }
                        }
                    } while (true);
                    ievent = ievent.iterator();
                    do
                    {
                        if (!ievent.hasNext())
                        {
                            break;
                        }
                        ISlot islot = (ISlot)ievent.next();
                        if (islot.getTimePosition() != 0.0D)
                        {
                            continue;
                        }
                        toBePlayedPauseSlotCustomId = islot.getCustomId();
                        break;
                    } while (true);
                    logger.debug((new StringBuilder()).append("toBePlayedPauseSlotCustomId:").append(toBePlayedPauseSlotCustomId).toString());
                    adContext.addEventListener(constants.EVENT_USER_ACTION_NOTIFIED(), userActionNotified);
                    adContext.addEventListener(constants.EVENT_SLOT_STARTED(), slotStartedListener);
                    adContext.addEventListener(constants.EVENT_SLOT_ENDED(), slotEndedListener);
                    adContext.addEventListener(constants.EVENT_AD_IMPRESSION(), adImpressionListener);
                    adContext.addEventListener(constants.EVENT_ERROR(), adErrorListener);
                    return;
                }
            }

            
            {
                this$0 = PauseAdExtension.this;
                super();
            }
        };
        userActionNotified = new IEventListener() {

            final PauseAdExtension this$0;

            public void run(IEvent ievent)
            {
                int i = ((Integer)ievent.getData().get(constants.INFO_KEY_USER_ACTION())).intValue();
                if (i == constants.USER_ACTION_PAUSE_BUTTON_CLICKED())
                {
                    logger.debug("pauseButtonClicked");
                    if (toBePlayedPauseSlotCustomId != null)
                    {
                        ievent = adContext.getSlotByCustomId(toBePlayedPauseSlotCustomId);
                        if (ievent != null)
                        {
                            logger.debug((new StringBuilder()).append("play slot:").append(toBePlayedPauseSlotCustomId).toString());
                            ievent.play();
                        }
                    }
                } else
                if (i == constants.USER_ACTION_RESUME_BUTTON_CLICKED())
                {
                    logger.debug("resumeButtonClicked");
                    if (currentPlayingPauseSlotCustomId != null)
                    {
                        ievent = adContext.getSlotByCustomId(currentPlayingPauseSlotCustomId);
                        if (ievent != null)
                        {
                            logger.debug((new StringBuilder()).append("stop slot:").append(currentPlayingPauseSlotCustomId).toString());
                            needDispatchContentResumeEvent = Boolean.valueOf(false);
                            currentPlayingPauseSlotCustomId = null;
                            ievent.stop();
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = PauseAdExtension.this;
                super();
            }
        };
        slotStartedListener = new IEventListener() {

            final PauseAdExtension this$0;

            public void run(IEvent ievent)
            {
                logger.debug("slotStartedListener");
                ievent = adContext.getSlotByCustomId((String)(String)ievent.getData().get(constants.INFO_KEY_CUSTOM_ID()));
                if (linearSlotToPauseSlotsMap.containsKey(ievent.getCustomId()))
                {
                    ievent = (ArrayList)linearSlotToPauseSlotsMap.get(ievent.getCustomId());
                    toBePlayedPauseSlotCustomId = (String)ievent.get((int)Math.floor(Math.random() * (double)ievent.size()));
                    logger.debug((new StringBuilder()).append("slotStartedListener, toBePlayedPauseSlotCustomId:").append(toBePlayedPauseSlotCustomId).toString());
                } else
                if (ievent.getTimePositionClass() == constants.TIME_POSITION_CLASS_PAUSE_MIDROLL())
                {
                    currentPlayingPauseSlotCustomId = ievent.getCustomId();
                    logger.debug((new StringBuilder()).append("slotStartedListener, currentPlayingPauseSlotCustomId:").append(currentPlayingPauseSlotCustomId).toString());
                    return;
                }
            }

            
            {
                this$0 = PauseAdExtension.this;
                super();
            }
        };
        slotEndedListener = new IEventListener() {

            final PauseAdExtension this$0;

            public void run(IEvent ievent)
            {
                logger.debug("slotEndedListener");
                if (needDispatchContentResumeEvent.booleanValue() && isEventFromCurrentPlayingPauseSlot(ievent).booleanValue())
                {
                    logger.debug("slotEndedListener, post EVENT_REQUEST_CONTENT_VIDEO_RESUME");
                    ievent = new HashMap();
                    ievent.put(constants.INFO_KEY_MESSAGE(), toBePlayedPauseSlotCustomId);
                    ievent.put(constants.INFO_KEY_CUSTOM_ID(), toBePlayedPauseSlotCustomId);
                    adContext.dispatchEvent(new Event(constants.EVENT_REQUEST_CONTENT_VIDEO_RESUME(), ievent));
                    needDispatchContentResumeEvent = Boolean.valueOf(false);
                    currentPlayingPauseSlotCustomId = null;
                }
            }

            
            {
                this$0 = PauseAdExtension.this;
                super();
            }
        };
        adImpressionListener = new IEventListener() {

            final PauseAdExtension this$0;

            public void run(IEvent ievent)
            {
                logger.debug("adImpressionListener");
                if (isEventFromCurrentPlayingPauseSlot(ievent).booleanValue())
                {
                    logger.debug("adImpressionListener, ad played successfully");
                    needDispatchContentResumeEvent = Boolean.valueOf(true);
                }
            }

            
            {
                this$0 = PauseAdExtension.this;
                super();
            }
        };
        adErrorListener = new IEventListener() {

            final PauseAdExtension this$0;

            public void run(IEvent ievent)
            {
                logger.debug("adErrorListener");
                if (isEventFromCurrentPlayingPauseSlot(ievent).booleanValue())
                {
                    logger.debug("adErrorListener, ad failed");
                    needDispatchContentResumeEvent = Boolean.valueOf(false);
                }
            }

            
            {
                this$0 = PauseAdExtension.this;
                super();
            }
        };
    }

    private Boolean isEventFromCurrentPlayingPauseSlot(IEvent ievent)
    {
        if (currentPlayingPauseSlotCustomId != null && currentPlayingPauseSlotCustomId.equals(ievent.getData().get(constants.INFO_KEY_CUSTOM_ID())))
        {
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    public void init(IAdContext iadcontext)
    {
        adContext = iadcontext;
        constants = iadcontext.getConstants();
        logger = Logger.getLogger(this);
        logger.debug("init");
        linearSlotToPauseSlotsMap = new HashMap();
        adContext.addEventListener(constants.EVENT_REQUEST_COMPLETE(), requestCompleteListener);
    }






/*
    static Boolean access$302(PauseAdExtension pauseadextension, Boolean boolean1)
    {
        pauseadextension.enabled = boolean1;
        return boolean1;
    }

*/




/*
    static String access$502(PauseAdExtension pauseadextension, String s)
    {
        pauseadextension.toBePlayedPauseSlotCustomId = s;
        return s;
    }

*/



/*
    static String access$602(PauseAdExtension pauseadextension, String s)
    {
        pauseadextension.currentPlayingPauseSlotCustomId = s;
        return s;
    }

*/



/*
    static Boolean access$702(PauseAdExtension pauseadextension, Boolean boolean1)
    {
        pauseadextension.needDispatchContentResumeEvent = boolean1;
        return boolean1;
    }

*/

}
