// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.extension.medialets;

import android.app.Activity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tv.freewheel.ad.AdInstance;
import tv.freewheel.ad.CreativeRendition;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.ad.slot.Slot;
import tv.freewheel.extension.IExtension;
import tv.freewheel.utils.Logger;

public class MedialetsExtension
    implements IExtension
{
    private static final class MedialetsAdmanagerState extends Enum
    {

        private static final MedialetsAdmanagerState $VALUES[];
        public static final MedialetsAdmanagerState RESUME;
        public static final MedialetsAdmanagerState START;
        public static final MedialetsAdmanagerState STOP;

        public static MedialetsAdmanagerState valueOf(String s)
        {
            return (MedialetsAdmanagerState)Enum.valueOf(tv/freewheel/extension/medialets/MedialetsExtension$MedialetsAdmanagerState, s);
        }

        public static MedialetsAdmanagerState[] values()
        {
            return (MedialetsAdmanagerState[])$VALUES.clone();
        }

        static 
        {
            START = new MedialetsAdmanagerState("START", 0);
            RESUME = new MedialetsAdmanagerState("RESUME", 1);
            STOP = new MedialetsAdmanagerState("STOP", 2);
            $VALUES = (new MedialetsAdmanagerState[] {
                START, RESUME, STOP
            });
        }

        private MedialetsAdmanagerState(String s, int i)
        {
            super(s, i);
        }
    }


    private static int sAdContextCounter = 0;
    private static boolean sFailedToBuildReflection = false;
    private static int sPauseCounter = 0;
    private static boolean sServiceConnected = false;
    private IEventListener activityStateChangedEventListener;
    private IAdContext adContext;
    private IConstants constants;
    private Logger logger;
    private Object medialetsAdmanager;
    private Class medialetsAdmanagerClass;
    private Class medialetsAdmanagerServiceListenerInterface;
    private Object medialetsAdmanagerServiceProxy;
    private IEventListener requestCompleteListener;
    private Method setServiceListenerMethod;

    public MedialetsExtension()
    {
        requestCompleteListener = null;
        activityStateChangedEventListener = new IEventListener() {

            final MedialetsExtension this$0;

            public void run(IEvent ievent)
            {
                ievent = (Integer)ievent.getData().get(constants.INFO_KEY_ACTIVITY_STATE());
                logger.debug((new StringBuilder()).append("EVENT_ACTIVITY_STATE_CHANGED, state=").append(ievent).toString());
                if (ievent.intValue() == constants.ACTIVITY_CALLBACK_PAUSE())
                {
                    logger.debug("The activity paused.");
                    int i = StringBuilder;
                } else
                if (ievent.intValue() == constants.ACTIVITY_CALLBACK_RESUME())
                {
                    logger.debug("The activity resumed.");
                    int i = StringBuilder;
                    if (MedialetsExtension.sPauseCounter == 0)
                    {
                        preformMethod(MedialetsAdmanagerState.RESUME);
                    }
                    if (MedialetsExtension.sPauseCounter < 0)
                    {
                        MedialetsExtension.sPauseCounter = 0;
                        return;
                    }
                }
            }

            
            {
                this$0 = MedialetsExtension.this;
                super();
            }
        };
        logger = Logger.getLogger(this);
    }

    private boolean anyMedialetsAdInResponse()
    {
        Object obj = new ArrayList();
        ((ArrayList) (obj)).addAll(adContext.getSiteSectionNonTemporalSlots());
        ((ArrayList) (obj)).addAll(adContext.getVideoPlayerNonTemporalSlots());
        ((ArrayList) (obj)).addAll(adContext.getTemporalSlots());
        obj = ((ArrayList) (obj)).iterator();
label0:
        do
        {
            if (((Iterator) (obj)).hasNext())
            {
                Iterator iterator = ((Slot)(ISlot)((Iterator) (obj)).next()).getAdInstancesInPlayPlan().iterator();
                CreativeRendition creativerendition;
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    creativerendition = ((AdInstance)iterator.next()).getActiveCreativeRendition();
                } while (creativerendition == null || !"external/medialets".equals(creativerendition.getContentType()));
                break;
            } else
            {
                return false;
            }
        } while (true);
        return true;
    }

    private void onServiceConnected()
    {
        logger.debug("onServiceConnected");
        adContext.getActivity().runOnUiThread(new Runnable() {

            final MedialetsExtension this$0;

            public void run()
            {
                performListener(false);
                MedialetsExtension.sServiceConnected = true;
                turnOnServiceConnected();
                adContext.addEventListener(constants.EVENT_ACTIVITY_STATE_CHANGED(), activityStateChangedEventListener);
            }

            
            {
                this$0 = MedialetsExtension.this;
                super();
            }
        });
    }

    private void performListener(boolean flag)
    {
        Object aobj[];
        String s1;
        boolean flag1;
        aobj = new Object[1];
        aobj[0] = null;
        if (flag)
        {
            aobj = new Object[1];
            aobj[0] = medialetsAdmanagerServiceProxy;
        }
        s1 = "";
        flag1 = false;
        setServiceListenerMethod.invoke(medialetsAdmanager, aobj);
        String s;
        flag1 = true;
        s = s1;
_L2:
        if (!flag1)
        {
            logger.error(s);
        }
        return;
        Object obj;
        obj;
        obj = ((IllegalArgumentException) (obj)).toString();
        continue; /* Loop/switch isn't completed */
        obj;
        obj = ((IllegalAccessException) (obj)).toString();
        continue; /* Loop/switch isn't completed */
        obj;
        obj = ((InvocationTargetException) (obj)).toString();
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void preformMethod(MedialetsAdmanagerState medialetsadmanagerstate)
    {
        Activity activity;
        logger.debug((new StringBuilder()).append("preformMethod(").append(medialetsadmanagerstate.toString()).append(")").toString());
        activity = adContext.getActivity();
        if (activity != null) goto _L2; else goto _L1
_L1:
        logger.error("The activity is not set in ad context");
_L8:
        return;
_L2:
        Object obj;
        String s;
        boolean flag;
        flag = false;
        s = "";
        obj = null;
        static class _cls5
        {

            static final int $SwitchMap$tv$freewheel$extension$medialets$MedialetsExtension$MedialetsAdmanagerState[];

            static 
            {
                $SwitchMap$tv$freewheel$extension$medialets$MedialetsExtension$MedialetsAdmanagerState = new int[MedialetsAdmanagerState.values().length];
                try
                {
                    $SwitchMap$tv$freewheel$extension$medialets$MedialetsExtension$MedialetsAdmanagerState[MedialetsAdmanagerState.START.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$tv$freewheel$extension$medialets$MedialetsExtension$MedialetsAdmanagerState[MedialetsAdmanagerState.RESUME.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$tv$freewheel$extension$medialets$MedialetsExtension$MedialetsAdmanagerState[MedialetsAdmanagerState.STOP.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        int i = _cls5..SwitchMap.tv.freewheel.extension.medialets.MedialetsExtension.MedialetsAdmanagerState[medialetsadmanagerstate.ordinal()];
        i;
        JVM INSTR tableswitch 1 3: default 108
    //                   1 217
    //                   2 240
    //                   3 263;
           goto _L3 _L4 _L5 _L6
_L3:
        if (MedialetsAdmanagerState.START == medialetsadmanagerstate)
        {
            logger.debug((new StringBuilder()).append("setCurrentActivity, at state ").append(medialetsadmanagerstate.toString()).toString());
            medialetsAdmanagerClass.getMethod("setCurrentActivity", new Class[] {
                android/app/Activity
            }).invoke(medialetsAdmanager, new Object[] {
                activity
            });
        }
        ((Method) (obj)).invoke(medialetsAdmanager, new Object[] {
            activity
        });
        flag = true;
        medialetsadmanagerstate = s;
_L9:
        if (flag) goto _L8; else goto _L7
_L7:
        logger.error(medialetsadmanagerstate);
        return;
_L4:
        obj = medialetsAdmanagerClass.getMethod("start", new Class[] {
            android/app/Activity
        });
          goto _L3
_L5:
        obj = medialetsAdmanagerClass.getMethod("resume", new Class[] {
            android/app/Activity
        });
          goto _L3
_L6:
        obj = medialetsAdmanagerClass.getMethod("stop", new Class[] {
            android/app/Activity
        });
          goto _L3
        Object obj1;
        obj1;
        obj1 = ((IllegalArgumentException) (obj1)).toString();
        medialetsadmanagerstate = ((MedialetsAdmanagerState) (obj1));
          goto _L9
        obj1;
        obj1 = ((IllegalAccessException) (obj1)).toString();
        medialetsadmanagerstate = ((MedialetsAdmanagerState) (obj1));
          goto _L9
        obj1;
        obj1 = ((InvocationTargetException) (obj1)).toString();
        medialetsadmanagerstate = ((MedialetsAdmanagerState) (obj1));
          goto _L9
        medialetsadmanagerstate;
        medialetsadmanagerstate = medialetsadmanagerstate.toString();
          goto _L9
        obj1;
        medialetsadmanagerstate = (new StringBuilder()).append(medialetsadmanagerstate.toString()).append(" method is not available , exception:").append(((NoSuchMethodException) (obj1)).toString()).toString();
          goto _L9
    }

    private void turnOnServiceConnected()
    {
        adContext.setParameter("extension.medialets.service_connected", "true", constants.PARAMETER_LEVEL_OVERRIDE());
    }

    public void init(IAdContext iadcontext)
    {
        logger.debug("init");
        adContext = iadcontext;
        constants = iadcontext.getConstants();
        sAdContextCounter++;
        if (sAdContextCounter != 1)
        {
            if (sServiceConnected)
            {
                turnOnServiceConnected();
            }
            return;
        }
        iadcontext = "";
        Object obj;
        medialetsAdmanagerClass = Class.forName("com.medialets.advertising.AdManager");
        medialetsAdmanagerServiceListenerInterface = Class.forName("com.medialets.advertising.AdManager$ServiceListener");
        obj = medialetsAdmanagerClass.getMethod("getInstance", (Class[])null);
        setServiceListenerMethod = medialetsAdmanagerClass.getMethod("setServiceListener", new Class[] {
            medialetsAdmanagerServiceListenerInterface
        });
        medialetsAdmanager = ((Method) (obj)).invoke(this, (Object[])null);
        obj = medialetsAdmanagerServiceListenerInterface.getClassLoader();
        Class class1 = medialetsAdmanagerServiceListenerInterface;
        InvocationHandler invocationhandler = new InvocationHandler() {

            final MedialetsExtension this$0;

            public Object invoke(Object obj1, Method method, Object aobj[])
                throws Throwable
            {
                if (method.getName().equals("onServiceConnected"))
                {
                    logger.debug("The Proxy is called back to launch onServiceConnected");
                    onServiceConnected();
                }
                return null;
            }

            
            {
                this$0 = MedialetsExtension.this;
                super();
            }
        };
        medialetsAdmanagerServiceProxy = Proxy.newProxyInstance(((ClassLoader) (obj)), new Class[] {
            class1
        }, invocationhandler);
        sFailedToBuildReflection = false;
_L1:
        if (sFailedToBuildReflection)
        {
            logger.debug(iadcontext);
            return;
        } else
        {
            requestCompleteListener = new IEventListener() {

                final MedialetsExtension this$0;

                public void run(IEvent ievent)
                {
                    logger.debug("EVENT_REQUEST_COMPLETE");
                    if ("false".equalsIgnoreCase((String)(String)ievent.getData().get(constants.INFO_KEY_SUCCESS())))
                    {
                        logger.error("The Request failed.");
                        return;
                    }
                    if (adContext.getActivity() == null)
                    {
                        logger.error("The activity is not set in the ad context.");
                        return;
                    }
                    if (!anyMedialetsAdInResponse())
                    {
                        logger.info("There is NO any Medialets ad found, The extension will NOT start Medialets AdManager Service.");
                        return;
                    } else
                    {
                        performListener(true);
                        preformMethod(MedialetsAdmanagerState.START);
                        return;
                    }
                }

            
            {
                this$0 = MedialetsExtension.this;
                super();
            }
            };
            adContext.addEventListener(constants.EVENT_REQUEST_COMPLETE(), requestCompleteListener);
            return;
        }
        iadcontext;
        try
        {
            iadcontext = iadcontext.toString();
        }
        // Misplaced declaration of an exception variable
        catch (IAdContext iadcontext)
        {
            iadcontext = (new StringBuilder()).append("com.medialets.advertising.AdManager is not available , exception:").append(iadcontext.toString()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (IAdContext iadcontext)
        {
            iadcontext = iadcontext.toString();
        }
        // Misplaced declaration of an exception variable
        catch (IAdContext iadcontext)
        {
            iadcontext = (new StringBuilder()).append("getInstance is not available , exception:").append(iadcontext.toString()).toString();
        }
          goto _L1
        iadcontext;
        iadcontext = iadcontext.toString();
          goto _L1
        iadcontext;
        iadcontext = iadcontext.toString();
          goto _L1
    }

    static 
    {
        sFailedToBuildReflection = true;
    }




/*
    static boolean access$102(boolean flag)
    {
        sServiceConnected = flag;
        return flag;
    }

*/








/*
    static int access$702(int i)
    {
        sPauseCounter = i;
        return i;
    }

*/


/*
    static int access$708()
    {
        int i = sPauseCounter;
        sPauseCounter = i + 1;
        return i;
    }

*/


/*
    static int access$710()
    {
        int i = sPauseCounter;
        sPauseCounter = i - 1;
        return i;
    }

*/


}
