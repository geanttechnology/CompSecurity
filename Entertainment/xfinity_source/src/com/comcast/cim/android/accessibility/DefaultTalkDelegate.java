// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            TalkDelegate

public class DefaultTalkDelegate
    implements android.speech.tts.TextToSpeech.OnInitListener, TalkDelegate
{
    public static final class UtteranceID extends Enum
    {

        private static final UtteranceID $VALUES[];
        public static final UtteranceID DO_NOTHING;
        public static final UtteranceID FOLLOWUP_WITH_LISTEN;

        public static UtteranceID valueOf(String s)
        {
            return (UtteranceID)Enum.valueOf(com/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID, s);
        }

        public static UtteranceID[] values()
        {
            return (UtteranceID[])$VALUES.clone();
        }

        static 
        {
            FOLLOWUP_WITH_LISTEN = new UtteranceID("FOLLOWUP_WITH_LISTEN", 0);
            DO_NOTHING = new UtteranceID("DO_NOTHING", 1);
            $VALUES = (new UtteranceID[] {
                FOLLOWUP_WITH_LISTEN, DO_NOTHING
            });
        }

        private UtteranceID(String s, int i)
        {
            super(s, i);
        }
    }


    private final Logger LOG;
    protected final Activity context;
    protected Toast currentToast;
    protected Handler handler = new Handler() {

        final DefaultTalkDelegate this$0;

        public void handleMessage(Message message)
        {
            if (message.what == com.comcast.cim.android.R.id.ACCESSIBILITY_ANNOUNCE_LOADED)
            {
                speak(context.getString(com.comcast.cim.android.R.string.speech_loaded_x, new Object[] {
                    spokenTitle
                }));
            } else
            {
                speak(message.what);
                handler.sendEmptyMessageDelayed(message.what, 5000L);
            }
            super.handleMessage(message);
        }

            
            {
                this$0 = DefaultTalkDelegate.this;
                super();
            }
    };
    private boolean ignoreAnnounceTitle;
    private String spokenTitle;
    protected TextToSpeech tts;

    public DefaultTalkDelegate(Activity activity)
    {
        currentToast = null;
        spokenTitle = null;
        ignoreAnnounceTitle = false;
        LOG = LoggerFactory.getLogger(com/comcast/cim/android/accessibility/DefaultTalkDelegate);
        context = activity;
        tts = new TextToSpeech(activity, this);
    }

    public DefaultTalkDelegate(Activity activity, boolean flag)
    {
        currentToast = null;
        spokenTitle = null;
        ignoreAnnounceTitle = false;
        LOG = LoggerFactory.getLogger(com/comcast/cim/android/accessibility/DefaultTalkDelegate);
        context = activity;
        if (!flag)
        {
            tts = new TextToSpeech(activity, this);
        }
    }

    public void announceTitle()
    {
        if (spokenTitle == null)
        {
            spokenTitle = context.getTitle().toString();
        }
        if (ignoreAnnounceTitle)
        {
            ignoreAnnounceTitle = false;
            return;
        } else
        {
            speak(spokenTitle);
            return;
        }
    }

    public void cancelAllMessages()
    {
        handler.removeCallbacksAndMessages(null);
    }

    public void ignoreAnnounceTitleOnce()
    {
        ignoreAnnounceTitle = true;
    }

    public void onDestroy()
    {
        handler.removeCallbacksAndMessages(null);
        if (tts != null)
        {
            tts.stop();
            tts.shutdown();
        }
    }

    public void onInit(int i)
    {
        if (i == 0)
        {
            i = tts.setLanguage(Locale.US);
            if (i != -1 && i != -2)
            {
                speak("");
            }
        }
    }

    public void setTitle(String s)
    {
        spokenTitle = s;
    }

    public void setUtteranceListener(UtteranceProgressListener utteranceprogresslistener)
    {
        tts.setOnUtteranceProgressListener(utteranceprogresslistener);
    }

    public void speak(int i)
    {
        speak(context.getString(i));
    }

    public void speak(String s)
    {
        speak(s, 1);
    }

    public void speak(String s, int i)
    {
        if (tts != null)
        {
            tts.speak(s, i, null);
        }
    }

    public void speakManagedMessage(int i)
    {
        cancelAllMessages();
        handler.sendEmptyMessage(i);
    }

    public void speakThenListen(String s)
    {
        HashMap hashmap = null;
        if (s.length() > 0)
        {
            hashmap = new HashMap();
            hashmap.put("utteranceId", UtteranceID.FOLLOWUP_WITH_LISTEN.toString());
        }
        if (tts != null)
        {
            tts.speak(s, 0, hashmap);
        }
    }

    public void stopSpeaking()
    {
        if (tts != null)
        {
            tts.stop();
        }
        if (currentToast != null)
        {
            currentToast.cancel();
        }
    }

}
