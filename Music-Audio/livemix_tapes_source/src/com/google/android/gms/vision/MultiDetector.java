// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.vision:
//            Detector, Frame

public class MultiDetector extends Detector
{
    public static class Builder
    {

        private MultiDetector zzaVk;

        public Builder add(Detector detector)
        {
            MultiDetector.zza(zzaVk).add(detector);
            return this;
        }

        public MultiDetector build()
        {
            if (MultiDetector.zza(zzaVk).size() == 0)
            {
                throw new RuntimeException("No underlying detectors added to MultiDetector.");
            } else
            {
                return zzaVk;
            }
        }

        public Builder()
        {
            zzaVk = new MultiDetector();
        }
    }


    private List zzaVj;

    private MultiDetector()
    {
        zzaVj = new ArrayList();
    }


    static List zza(MultiDetector multidetector)
    {
        return multidetector.zzaVj;
    }

    public SparseArray detect(Frame frame)
    {
        SparseArray sparsearray = new SparseArray();
        for (Iterator iterator = zzaVj.iterator(); iterator.hasNext();)
        {
            SparseArray sparsearray1 = ((Detector)iterator.next()).detect(frame);
            int i = 0;
            while (i < sparsearray1.size()) 
            {
                int j = sparsearray1.keyAt(i);
                if (sparsearray.get(j) != null)
                {
                    throw new IllegalStateException((new StringBuilder()).append("Detection ID overlap for id = ").append(j).append(".  ").append("This means that one of the detectors is not using global IDs.").toString());
                }
                sparsearray.append(j, sparsearray1.valueAt(i));
                i++;
            }
        }

        return sparsearray;
    }

    public boolean isOperational()
    {
        for (Iterator iterator = zzaVj.iterator(); iterator.hasNext();)
        {
            if (!((Detector)iterator.next()).isOperational())
            {
                return false;
            }
        }

        return true;
    }

    public void receiveFrame(Frame frame)
    {
        for (Iterator iterator = zzaVj.iterator(); iterator.hasNext(); ((Detector)iterator.next()).receiveFrame(frame)) { }
    }

    public void release()
    {
        for (Iterator iterator = zzaVj.iterator(); iterator.hasNext(); ((Detector)iterator.next()).release()) { }
        zzaVj.clear();
    }

    public void setProcessor(Detector.Processor processor)
    {
        throw new UnsupportedOperationException("MultiDetector.setProcessor is not supported.  You should set a processor instance on each underlying detector instead.");
    }
}
