// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;


// Referenced classes of package com.digimarc.dms:
//            DMSIBaseReader, DMSPayload

public abstract class DMSIImageReader extends DMSIBaseReader
{

    public DMSIImageReader()
    {
    }

    public android.hardware.Camera.Parameters getBestCameraParameters(android.hardware.Camera.Parameters parameters)
    {
        return null;
    }

    public DMSPayload queueImageData(byte abyte0[], int i, int j, boolean flag)
    {
        return null;
    }
}
