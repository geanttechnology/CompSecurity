// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.RecognitionListener;
import android.speech.tts.UtteranceProgressListener;
import com.comcast.cim.android.view.common.BaseActivity;
import com.comcast.cim.android.view.common.OrientationStrategy;
import com.comcast.cim.container.CALContainer;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            SpeechActions, TalkDelegate, SpeechPresentationMode, AlternateInterfaceUtil

public abstract class SpeechRecognizer extends BaseActivity
    implements RecognitionListener
{

    protected final AlternateInterfaceUtil alternateInterfaceUtil = CALContainer.getInstance().getAlternateInterfaceUtil();
    Handler handler;
    private String prompt;
    private android.speech.SpeechRecognizer sr;
    UtteranceProgressListener utteranceProgressListener;

    public SpeechRecognizer()
    {
        handler = new Handler() {

            final SpeechRecognizer this$0;

            public void handleMessage(Message message)
            {
                if (message.what == 8)
                {
                    getTalkDelegate().speak(getString(com.comcast.cim.android.R.string.speech_dialog_timeout));
                    finish();
                    return;
                }
                if (message.what == 9)
                {
                    getTalkDelegate().speak(getString(com.comcast.cim.android.R.string.speech_dialog_timeout_service_unavail));
                    finish();
                    return;
                } else
                {
                    super.handleMessage(message);
                    return;
                }
            }

            
            {
                this$0 = SpeechRecognizer.this;
                super();
            }
        };
        utteranceProgressListener = new UtteranceProgressListener() {

            final SpeechRecognizer this$0;

            public void onDone(String s)
            {
                if (s.equals((new StringBuilder()).append(DefaultTalkDelegate.UtteranceID.FOLLOWUP_WITH_LISTEN).append("").toString()))
                {
                    listen();
                }
            }

            public void onError(String s)
            {
            }

            public void onStart(String s)
            {
            }

            
            {
                this$0 = SpeechRecognizer.this;
                super();
            }
        };
    }

    private boolean isLaunchByNumberFollowedByItemThenNumber(String as[], SpeechActions speechactions)
    {
        return (speechactions == SpeechActions.OPEN || speechactions == SpeechActions.PLAY) && as.length > 1 && as[1].equals("item");
    }

    private boolean isSearchFollowedByTheWordFor(String as[], SpeechActions speechactions)
    {
        return speechactions == SpeechActions.SEARCH && as.length > 1 && as[1].equals("for");
    }

    public abstract void attemptSearch(String as[], SpeechPresentationMode speechpresentationmode);

    protected void cleanup()
    {
        sr.stopListening();
        sr.destroy();
    }

    protected void closeWithIgnore()
    {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_ACTION", (new StringBuilder()).append(SpeechActions.IGNORE_REENTRY).append("").toString());
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    protected String[] filterTerms(String as[], SpeechActions speechactions)
    {
        byte byte0 = 1;
        if (isSearchFollowedByTheWordFor(as, speechactions) || isLaunchByNumberFollowedByItemThenNumber(as, speechactions))
        {
            byte0 = 2;
        }
        return (String[])Arrays.copyOfRange(as, byte0, as.length);
    }

    public OrientationStrategy getOrientationStrategy()
    {
        return new OrientationStrategy() {

            final SpeechRecognizer this$0;

            public int getAppropriateOrientation()
            {
                return -1;
            }

            
            {
                this$0 = SpeechRecognizer.this;
                super();
            }
        };
    }

    public void getSpeech()
    {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        sr.startListening(intent);
    }

    public void listen()
    {
        handler.postDelayed(new Runnable() {

            final SpeechRecognizer this$0;

            public void run()
            {
                getSpeech();
            }

            
            {
                this$0 = SpeechRecognizer.this;
                super();
            }
        }, 10L);
    }

    public void onBeginningOfSpeech()
    {
        handler.removeMessages(8);
    }

    public void onBufferReceived(byte abyte0[])
    {
    }

    public void onCreate(Bundle bundle)
    {
        setupTalkDelegateDefault();
        setTitle("");
        sr = android.speech.SpeechRecognizer.createSpeechRecognizer(this);
        sr.setRecognitionListener(this);
        if (getIntent() != null)
        {
            prompt = getIntent().getExtras().getString("android.speech.extra.PROMPT", getString(com.comcast.cim.android.R.string.speech_dialog_caption_default));
        } else
        {
            prompt = getString(com.comcast.cim.android.R.string.speech_dialog_caption_default);
        }
        super.onCreate(bundle);
        setContentView(com.comcast.cim.android.R.layout.speech_recognizer_shell);
        getTalkDelegate().setUtteranceListener(utteranceProgressListener);
        handler.sendEmptyMessageDelayed(9, 3000L);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        handler.removeMessages(8);
    }

    public void onEndOfSpeech()
    {
    }

    public void onError(int i)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("~ERROR~");
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("results_recognition", arraylist);
        onResults(bundle);
    }

    public void onEvent(int i, Bundle bundle)
    {
    }

    public void onPartialResults(Bundle bundle)
    {
    }

    protected void onPause()
    {
        super.onPause();
        cleanup();
        closeWithIgnore();
    }

    public void onReadyForSpeech(Bundle bundle)
    {
        handler.removeMessages(9);
        handler.sendEmptyMessageDelayed(8, 5000L);
    }

    public void onResults(Bundle bundle)
    {
        cleanup();
        translateCommand(bundle.getStringArrayList("results_recognition"));
    }

    public void onRmsChanged(float f)
    {
    }

    public void talk()
    {
        handler.postDelayed(new Runnable() {

            final SpeechRecognizer this$0;

            public void run()
            {
                getTalkDelegate().speakThenListen(prompt);
            }

            
            {
                this$0 = SpeechRecognizer.this;
                super();
            }
        }, 500L);
    }

    protected void translateCommand(ArrayList arraylist)
    {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        String as[] = new String[1];
        as[0] = "~UNRECOGNIZED~";
        if (arraylist.size() > 0)
        {
            as = ((String)arraylist.get(0)).toLowerCase().split(" ");
        }
        String s = as[0];
        if (s.equals("~UNRECOGNIZED~"))
        {
            arraylist = SpeechActions.UNRECOGNIZED;
        } else
        {
            if (s.equals("search"))
            {
                attemptSearch(filterTerms(as, SpeechActions.SEARCH), SpeechPresentationMode.SEARCH);
                return;
            }
            if (s.equals("open") || s.equals("show") || s.equals("item"))
            {
                attemptSearch(filterTerms(as, SpeechActions.OPEN), SpeechPresentationMode.OPEN);
                return;
            }
            if (s.equals("play") || s.equals("watch") || s.equals("resume"))
            {
                if (as.length == 1)
                {
                    arraylist = SpeechActions.PLAY;
                } else
                {
                    attemptSearch(filterTerms(as, SpeechActions.PLAY), SpeechPresentationMode.PLAY);
                    return;
                }
            } else
            if (s.equals("pause") || s.equals("paws"))
            {
                arraylist = SpeechActions.PAUSE;
            } else
            if (s.equals("skip") || s.equals("forward") || s.equals("seek"))
            {
                arraylist = SpeechActions.SEEK;
            } else
            if (s.equals("repeat"))
            {
                arraylist = SpeechActions.REPEAT;
            } else
            if (s.equals("clear"))
            {
                arraylist = SpeechActions.CLEAR;
            } else
            if (s.equals("close"))
            {
                arraylist = SpeechActions.CLOSE;
            } else
            if (s.equals("shush") || s.equals("cancel"))
            {
                arraylist = SpeechActions.CANCEL;
            } else
            if (s.equals("less"))
            {
                arraylist = SpeechActions.LESS;
            } else
            if (s.equals("back") || s.equals("rewind"))
            {
                arraylist = SpeechActions.REWIND;
            } else
            if (s.equals("more") || s.equals("next"))
            {
                arraylist = SpeechActions.MORE;
            } else
            {
                int i = alternateInterfaceUtil.interpretIfNumber(s);
                if (i > 0)
                {
                    SpeechActions speechactions = SpeechActions.JUST_A_NUMBER;
                    arraylist.clear();
                    arraylist.add("dummy");
                    arraylist.add((new StringBuilder()).append(i).append("").toString());
                    arraylist = speechactions;
                } else
                {
                    arraylist = SpeechActions.UNRECOGNIZED;
                }
            }
        }
        bundle.putStringArray("KEY_TERMS", filterTerms(as, SpeechActions.UNRECOGNIZED));
        bundle.putString("KEY_ACTION", (new StringBuilder()).append(arraylist).append("").toString());
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

}
