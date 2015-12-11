// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;


// Referenced classes of package com.digimarc.dms:
//            DMSMessage

public interface DMSIListener
{

    public abstract void onAudioWatermarkDetected(DMSMessage dmsmessage);

    public abstract void onError(int i);

    public abstract void onImageBarcodeDetected(DMSMessage dmsmessage);

    public abstract void onImageQRCodeDetected(DMSMessage dmsmessage);

    public abstract void onImageWatermarkDetected(DMSMessage dmsmessage);

    public abstract void onStatus(int i);

    public abstract void onWarning(int i);
}
