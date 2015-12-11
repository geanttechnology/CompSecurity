// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import com.digimarc.dms.imagereader.CpmImage;
import com.digimarc.dms.imagereader.DMSCameraOptimizer;
import com.digimarc.dms.imagereader.DMSIImageNative;

// Referenced classes of package com.digimarc.dms:
//            DMSIImageReader, DMSPayload, DMSMessage

public class DMSReaderWatermark extends DMSIImageReader
{

    private DMSIImageNative readerInstance;

    DMSReaderWatermark(String s)
    {
        readerInstance = null;
        name = s;
        getReaderInstance();
    }

    private DMSIImageNative getReaderInstance()
    {
        if (readerInstance == null)
        {
            readerInstance = new DMSIImageNative();
            setReaderProperties();
        }
        return readerInstance;
    }

    private void setReaderProperties()
    {
        readerInstance.setChromaWatermarksSupported(true);
        readerInstance.setClassicWatermarksSupported(true);
    }

    public android.hardware.Camera.Parameters getBestCameraParameters(android.hardware.Camera.Parameters parameters)
    {
        return DMSCameraOptimizer.getBestCameraParameters(mAppContext, parameters);
    }

    public DMSPayload queueImageData(byte abyte0[], int i, int j, boolean flag)
    {
        DMSPayload dmspayload = null;
        try
        {
            abyte0 = getReaderInstance().readImageSynchronous(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            abyte0 = null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            abyte0 = null;
        }
        if (abyte0.getWatermarkFound())
        {
            abyte0 = new DMSPayload(abyte0.getCpmPath());
            DMSMessage dmsmessage = new DMSMessage(abyte0, name, 0);
            dmspayload = abyte0;
            if (flag)
            {
                DMS_Notify_Marks(101, dmsmessage);
                dmspayload = abyte0;
            }
        }
        return dmspayload;
    }

    public void start()
    {
    }

    public void stop()
    {
    }
}
