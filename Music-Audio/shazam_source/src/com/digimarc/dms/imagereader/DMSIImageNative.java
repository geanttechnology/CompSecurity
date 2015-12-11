// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.imagereader;


// Referenced classes of package com.digimarc.dms.imagereader:
//            ReaderCpm, CpmImage

public class DMSIImageNative
{

    private ReaderCpm watermarkReader;

    public DMSIImageNative()
    {
        watermarkReader = null;
        try
        {
            watermarkReader = new ReaderCpm();
            return;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            throw unsatisfiedlinkerror;
        }
        catch (SecurityException securityexception)
        {
            throw securityexception;
        }
    }

    public CpmImage readImageSynchronous(byte abyte0[], int i, int j)
    {
        return watermarkReader.readImageSynchronous(abyte0, i, j);
    }

    public void setChromaWatermarksSupported(boolean flag)
    {
        watermarkReader.setChromaWatermarksSupported(flag);
    }

    public void setClassicWatermarksSupported(boolean flag)
    {
        watermarkReader.setClassicWatermarksSupported(flag);
    }
}
