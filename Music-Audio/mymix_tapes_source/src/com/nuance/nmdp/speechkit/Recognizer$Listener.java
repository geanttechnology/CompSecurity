// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            Recognizer, SpeechError, Recognition

public static interface 
{

    public abstract void onError(Recognizer recognizer, SpeechError speecherror);

    public abstract void onRecordingBegin(Recognizer recognizer);

    public abstract void onRecordingDone(Recognizer recognizer);

    public abstract void onResults(Recognizer recognizer, Recognition recognition);
}
