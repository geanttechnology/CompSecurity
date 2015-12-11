// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;


// Referenced classes of package com.comcast.cim.android.accessibility:
//            SpeechListener

public class DefaultSpeechListener
    implements SpeechListener
{

    public DefaultSpeechListener()
    {
    }

    public boolean onSpeechResponseCancel()
    {
        return false;
    }

    public boolean onSpeechResponseClear()
    {
        return false;
    }

    public boolean onSpeechResponseClose()
    {
        return false;
    }

    public boolean onSpeechResponseFeedback(String s)
    {
        return false;
    }

    public boolean onSpeechResponseIgnoreReentry()
    {
        return true;
    }

    public boolean onSpeechResponseLess()
    {
        return false;
    }

    public boolean onSpeechResponseMore()
    {
        return false;
    }

    public boolean onSpeechResponseOpen(String as[])
    {
        return false;
    }

    public boolean onSpeechResponsePause()
    {
        return false;
    }

    public boolean onSpeechResponsePlay(String as[])
    {
        return false;
    }

    public boolean onSpeechResponseRepeat()
    {
        return false;
    }

    public boolean onSpeechResponseSearch(String as[])
    {
        return false;
    }

    public boolean onSpeechResponseSeek(String as[])
    {
        return false;
    }
}
