// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import com.digimarc.dms.imagereader.DMSCameraOptimizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.digimarc.dms:
//            DMSIBase, DMSIImageReader, DMSPayload

public class DMSImageReaderMgr extends DMSIBase
{

    private static List Readers = new ArrayList();
    private static final String TAG = "DMSImageReaderMgr";

    public DMSImageReaderMgr()
    {
    }

    public android.hardware.Camera.Parameters getBestCameraParameters(android.hardware.Camera.Parameters parameters)
    {
        return DMSCameraOptimizer.getBestCameraParameters(mAppContext, parameters);
    }

    public DMSPayload queueImageData(byte abyte0[], int i, int j, boolean flag)
    {
        Object obj;
label0:
        {
            DMSPayload dmspayload = null;
            for (Iterator iterator = Readers.iterator(); iterator.hasNext();)
            {
                obj = (DMSIImageReader)iterator.next();
                if (((DMSIImageReader) (obj)).isOpen)
                {
                    ((DMSIImageReader) (obj)).incrementSessionCount(1);
                    if (((DMSIImageReader) (obj)).readyToRunAtSessionCounter(getImageProfile()))
                    {
                        if (flag)
                        {
                            ((DMSIImageReader) (obj)).queueImageData(abyte0, i, j, true);
                        } else
                        {
                            dmspayload = ((DMSIImageReader) (obj)).queueImageData(abyte0, i, j, false);
                            obj = dmspayload;
                            if (dmspayload != null)
                            {
                                break label0;
                            }
                        }
                    }
                }
            }

            obj = dmspayload;
        }
        return ((DMSPayload) (obj));
    }

    public void registerReader(DMSIImageReader dmsiimagereader)
    {
        Readers.add(dmsiimagereader);
    }

    public void removeAllReaders()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = Readers.iterator(); iterator.hasNext();)
        {
            DMSIImageReader dmsiimagereader = (DMSIImageReader)iterator.next();
            dmsiimagereader.stop();
            dmsiimagereader.isOpen = false;
        }

        break MISSING_BLOCK_LABEL_47;
        Exception exception;
        exception;
        throw exception;
        Readers.clear();
        this;
        JVM INSTR monitorexit ;
    }

    public void setCurrentProfile(DMSIBase.DMS_PROFILES dms_profiles)
    {
        this;
        JVM INSTR monitorenter ;
        setImageProfile(dms_profiles);
        for (Iterator iterator = Readers.iterator(); iterator.hasNext(); ((DMSIImageReader)iterator.next()).setImageProfile(dms_profiles)) { }
        break MISSING_BLOCK_LABEL_46;
        dms_profiles;
        throw dms_profiles;
        this;
        JVM INSTR monitorexit ;
    }

    public void start()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = Readers.iterator(); iterator.hasNext();)
        {
            DMSIImageReader dmsiimagereader = (DMSIImageReader)iterator.next();
            dmsiimagereader.start();
            dmsiimagereader.isOpen = true;
        }

        break MISSING_BLOCK_LABEL_47;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void stop()
    {
        this;
        JVM INSTR monitorenter ;
        removeAllReaders();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
