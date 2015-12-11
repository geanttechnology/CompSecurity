// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            SpeechActions, SpeechListener

public class SpeechDelegate
{

    private final Activity activity;
    private boolean isTriggered;
    private HashSet speechListeners;

    public SpeechDelegate(Activity activity1)
    {
        isTriggered = false;
        speechListeners = new HashSet();
        activity = activity1;
    }

    private boolean onSpeechResponse(String s, String as[])
    {
        s = SpeechActions.valueOf(s);
        boolean flag1 = false;
        Iterator iterator = speechListeners.iterator();
label0:
        do
        {
            SpeechListener speechlistener;
            boolean flag;
            do
            {
                flag = flag1;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                speechlistener = (SpeechListener)iterator.next();
                if (SpeechActions.SEARCH != s)
                {
                    break;
                }
                speechlistener.onSpeechResponseSearch(as);
                flag1 = true;
            } while (true);
            if (SpeechActions.CLEAR == s)
            {
                flag = speechlistener.onSpeechResponseClear();
            } else
            if (SpeechActions.CLOSE == s)
            {
                flag = speechlistener.onSpeechResponseClose();
            } else
            if (SpeechActions.CANCEL == s)
            {
                flag = speechlistener.onSpeechResponseCancel();
            } else
            if (SpeechActions.REPEAT == s)
            {
                flag = speechlistener.onSpeechResponseRepeat();
            } else
            if (SpeechActions.MORE == s)
            {
                flag = speechlistener.onSpeechResponseMore();
            } else
            if (SpeechActions.LESS == s)
            {
                flag = speechlistener.onSpeechResponseLess();
            } else
            if (SpeechActions.PLAY == s)
            {
                flag = speechlistener.onSpeechResponsePlay(as);
            } else
            if (SpeechActions.OPEN == s)
            {
                flag = speechlistener.onSpeechResponseOpen(as);
            } else
            if (SpeechActions.PAUSE == s)
            {
                flag = speechlistener.onSpeechResponsePause();
            } else
            if (SpeechActions.SEEK == s)
            {
                flag = speechlistener.onSpeechResponseSeek(as);
            } else
            {
                flag = flag1;
                if (SpeechActions.REWIND != s)
                {
                    if (SpeechActions.IGNORE_REENTRY == s)
                    {
                        flag = speechlistener.onSpeechResponseIgnoreReentry();
                    } else
                    {
                        flag = flag1;
                        if (SpeechActions.FEEDBACK == s)
                        {
                            flag = speechlistener.onSpeechResponseFeedback("todo: jva - add message here");
                        }
                    }
                }
            }
            flag1 = flag;
        } while (!flag);
        flag1 = flag;
        if (!flag)
        {
            s = speechListeners.iterator();
            do
            {
                flag1 = flag;
                if (!s.hasNext())
                {
                    break;
                }
                flag1 = ((SpeechListener)s.next()).onSpeechResponseFeedback(activity.getString(com.comcast.cim.android.R.string.command_not_avail));
                flag = flag1;
            } while (!flag1);
        }
        return flag1;
    }

    public void addSpeechListener(SpeechListener speechlistener)
    {
        speechListeners.add(speechlistener);
    }

    public void getSpeechInput(Class class1)
    {
        getSpeechInput(class1, new Bundle());
    }

    public void getSpeechInput(Class class1, Bundle bundle)
    {
        if (!isTriggered)
        {
            isTriggered = true;
            getSpeechInputHandMade(class1, bundle);
        }
    }

    protected void getSpeechInputHandMade(Class class1, Bundle bundle)
    {
        class1 = new Intent(activity, class1);
        bundle.putString("android.speech.extra.PROMPT", activity.getString(com.comcast.cim.android.R.string.speech_dialog_caption_default));
        class1.putExtras(bundle);
        activity.startActivityForResult(class1, 10001);
    }

    public boolean onActivityResult(int i, int j, Intent intent)
    {
        boolean flag1 = false;
        if (i == 10001)
        {
            isTriggered = false;
        }
        boolean flag = flag1;
        if (i == 10001)
        {
            flag = flag1;
            if (j == -1)
            {
                onSpeechResponse(intent.getStringExtra("KEY_ACTION"), intent.getStringArrayExtra("KEY_TERMS"));
                flag = true;
            }
        }
        return flag;
    }

    public void removeSpeechListener(SpeechListener speechlistener)
    {
        speechListeners.remove(speechlistener);
    }

    public void startSearch(Class class1, String as[])
    {
        class1 = new Intent(activity, class1);
        class1.setAction((new StringBuilder()).append(SpeechActions.SEARCH).append("").toString());
        class1.putExtra("KEY_TERMS", as);
        activity.startActivity(class1);
    }
}
