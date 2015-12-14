// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;

// Referenced classes of package com.google.android.gms.vision:
//            Tracker, Detector

public abstract class FocusingProcessor
    implements Detector.Processor
{

    private Detector zzaUK;
    private Tracker zzaVa;
    private boolean zzaVb;
    private int zzaVc;

    public FocusingProcessor(Detector detector, Tracker tracker)
    {
        zzaVb = false;
        zzaUK = detector;
        zzaVa = tracker;
    }

    public void receiveDetections(Detector.Detections detections)
    {
        Object obj = detections.getDetectedItems();
        if (((SparseArray) (obj)).size() == 0)
        {
            zzaVa.onMissing(detections);
            return;
        }
        if (zzaVb)
        {
            Object obj1 = ((SparseArray) (obj)).get(zzaVc);
            if (obj1 != null)
            {
                zzaVa.onUpdate(detections, obj1);
                return;
            }
            zzaVa.onDone();
            zzaVb = false;
        }
        int i = selectFocus(detections);
        obj = ((SparseArray) (obj)).get(i);
        if (obj == null)
        {
            Log.w("FocusingProcessor", (new StringBuilder()).append("Invalid focus selected: ").append(i).toString());
            return;
        } else
        {
            zzaVb = true;
            zzaVc = i;
            zzaUK.setFocus(zzaVc);
            zzaVa.onNewItem(zzaVc, obj);
            zzaVa.onUpdate(detections, obj);
            return;
        }
    }

    public void release()
    {
        zzaVa.onDone();
    }

    public abstract int selectFocus(Detector.Detections detections);
}
