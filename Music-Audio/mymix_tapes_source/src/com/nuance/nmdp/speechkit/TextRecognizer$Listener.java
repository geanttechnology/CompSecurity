// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            TextRecognizer, SpeechError, GenericRecognition

public static interface 
{

    public abstract void onError(TextRecognizer textrecognizer, SpeechError speecherror);

    public abstract void onResults(TextRecognizer textrecognizer, GenericRecognition genericrecognition);
}
