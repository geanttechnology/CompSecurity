// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;


// Referenced classes of package com.comcast.cim.android.accessibility:
//            SpeechRecognizer, TalkDelegate

class this._cls0
    implements Runnable
{

    final SpeechRecognizer this$0;

    public void run()
    {
        getTalkDelegate().speakThenListen(SpeechRecognizer.access$000(SpeechRecognizer.this));
    }

    ()
    {
        this$0 = SpeechRecognizer.this;
        super();
    }
}
