// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            NluRecognizer, SpeechError, GenericRecognition

public static interface 
{

    public abstract void onError(NluRecognizer nlurecognizer, SpeechError speecherror);

    public abstract void onRecordingBegin(NluRecognizer nlurecognizer);

    public abstract void onRecordingDone(NluRecognizer nlurecognizer);

    public abstract void onResults(NluRecognizer nlurecognizer, GenericRecognition genericrecognition);
}
