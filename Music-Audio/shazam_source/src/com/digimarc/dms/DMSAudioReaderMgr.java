// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import com.digimarc.dms.audioreader.DMSIAudioNative;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.digimarc.dms:
//            DMSIBase, DMSAudioReader

public class DMSAudioReaderMgr extends DMSIBase
{

    private static List Readers = new ArrayList();
    private static final String TAG = "DMSAudioReaderMgr";
    private final int bytesPerSample = 2;

    public DMSAudioReaderMgr()
    {
    }

    private DMSIBase.DMS_PROFILES getCurrentProfile()
    {
        this;
        JVM INSTR monitorenter ;
        DMSIBase.DMS_PROFILES dms_profiles = super.getAudioProfile();
        this;
        JVM INSTR monitorexit ;
        return dms_profiles;
        Exception exception;
        exception;
        throw exception;
    }

    public void queueAudioBuffer(byte abyte0[], int i)
    {
        if (!Readers.isEmpty())
        {
            DMSIAudioNative.incomingAudioBuffer(abyte0, i * 2);
        }
        abyte0 = Readers.iterator();
        do
        {
            if (!abyte0.hasNext())
            {
                break;
            }
            DMSAudioReader dmsaudioreader = (DMSAudioReader)abyte0.next();
            if (dmsaudioreader.masterEnable && dmsaudioreader.isOpen)
            {
                int j = dmsaudioreader.calcIncrement(i);
                if (j > 0)
                {
                    dmsaudioreader.incrementSessionCount(j);
                    dmsaudioreader.scheduleForDispatch();
                }
                dmsaudioreader.dispatch();
            }
        } while (true);
    }

    public void queueAudioBufferBytes(byte abyte0[], int i)
    {
        queueAudioBuffer(abyte0, i / 2);
    }

    public void registerReader(DMSAudioReader dmsaudioreader)
    {
        Readers.add(dmsaudioreader);
    }

    public void removeAllReaders()
    {
        for (Iterator iterator = Readers.iterator(); iterator.hasNext(); ((DMSAudioReader)iterator.next()).stop()) { }
        Readers.clear();
    }

    public void setCurrentProfile(DMSIBase.DMS_PROFILES dms_profiles)
    {
        this;
        JVM INSTR monitorenter ;
        super.setAudioProfile(dms_profiles);
        for (Iterator iterator = Readers.iterator(); iterator.hasNext(); ((DMSAudioReader)iterator.next()).setAudioProfile(dms_profiles)) { }
        break MISSING_BLOCK_LABEL_46;
        dms_profiles;
        throw dms_profiles;
        this;
        JVM INSTR monitorexit ;
    }

    public void start()
    {
        for (Iterator iterator = Readers.iterator(); iterator.hasNext(); ((DMSAudioReader)iterator.next()).start()) { }
    }

    public void stop()
    {
        removeAllReaders();
    }

}
