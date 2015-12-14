// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            DataUploadCommand, SpeechError, DataUploadResult

public static interface 
{

    public abstract void onError(DataUploadCommand datauploadcommand, SpeechError speecherror);

    public abstract void onResults(DataUploadCommand datauploadcommand, DataUploadResult datauploadresult);
}
