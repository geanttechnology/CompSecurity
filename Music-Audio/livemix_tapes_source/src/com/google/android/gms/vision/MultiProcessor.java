// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;

import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.vision:
//            Tracker

public class MultiProcessor
    implements Detector.Processor
{
    public static class Builder
    {

        private MultiProcessor zzaVo;

        public MultiProcessor build()
        {
            return zzaVo;
        }

        public Builder setMaxGapFrames(int i)
        {
            if (i < 0)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid max gap: ").append(i).toString());
            } else
            {
                MultiProcessor.zza(zzaVo, i);
                return this;
            }
        }

        public Builder(Factory factory)
        {
            zzaVo = new MultiProcessor();
            if (factory == null)
            {
                throw new IllegalArgumentException("No factory supplied.");
            } else
            {
                MultiProcessor.zza(zzaVo, factory);
                return;
            }
        }
    }

    public static interface Factory
    {

        public abstract Tracker create(Object obj);
    }

    private class zza
    {

        private Tracker zzaVa;
        private int zzaVp;
        final MultiProcessor zzaVq;

        static Tracker zza(zza zza1)
        {
            return zza1.zzaVa;
        }

        static Tracker zza(zza zza1, Tracker tracker)
        {
            zza1.zzaVa = tracker;
            return tracker;
        }

        static int zzb(zza zza1)
        {
            int i = zza1.zzaVp;
            zza1.zzaVp = i + 1;
            return i;
        }

        static int zzc(zza zza1)
        {
            return zza1.zzaVp;
        }

        private zza()
        {
            zzaVq = MultiProcessor.this;
            super();
            zzaVp = 0;
        }

    }


    private Factory zzaVl;
    private SparseArray zzaVm;
    private int zzaVn;

    private MultiProcessor()
    {
        zzaVm = new SparseArray();
        zzaVn = 3;
    }


    static int zza(MultiProcessor multiprocessor, int i)
    {
        multiprocessor.zzaVn = i;
        return i;
    }

    static Factory zza(MultiProcessor multiprocessor, Factory factory)
    {
        multiprocessor.zzaVl = factory;
        return factory;
    }

    private void zza(Detector.Detections detections)
    {
        detections = detections.getDetectedItems();
        for (int i = 0; i < detections.size(); i++)
        {
            int j = detections.keyAt(i);
            Object obj = detections.valueAt(i);
            if (zzaVm.get(j) == null)
            {
                zza zza1 = new zza();
                zza.zza(zza1, zzaVl.create(obj));
                zza.zza(zza1).onNewItem(j, obj);
                zzaVm.append(j, zza1);
            }
        }

    }

    private void zzb(Detector.Detections detections)
    {
        detections = detections.getDetectedItems();
        Object obj = new HashSet();
        for (int i = 0; i < zzaVm.size(); i++)
        {
            int j = zzaVm.keyAt(i);
            if (detections.get(j) != null)
            {
                continue;
            }
            zza zza1 = (zza)zzaVm.valueAt(i);
            zza.zzb(zza1);
            if (zza.zzc(zza1) == zzaVn)
            {
                zza.zza(zza1).onDone();
                ((Set) (obj)).add(Integer.valueOf(j));
            }
        }

        for (detections = ((Set) (obj)).iterator(); detections.hasNext(); zzaVm.delete(((Integer) (obj)).intValue()))
        {
            obj = (Integer)detections.next();
        }

    }

    private void zzc(Detector.Detections detections)
    {
        SparseArray sparsearray = detections.getDetectedItems();
        for (int i = 0; i < sparsearray.size(); i++)
        {
            int j = sparsearray.keyAt(i);
            Object obj = sparsearray.valueAt(i);
            zza.zza((zza)zzaVm.get(j)).onUpdate(detections, obj);
        }

    }

    public void receiveDetections(Detector.Detections detections)
    {
        zza(detections);
        zzb(detections);
        zzc(detections);
    }

    public void release()
    {
        for (int i = 0; i < zzaVm.size(); i++)
        {
            zza.zza((zza)zzaVm.valueAt(i)).onDone();
        }

        zzaVm.clear();
    }
}
