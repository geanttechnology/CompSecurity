// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.face;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.FocusingProcessor;
import com.google.android.gms.vision.Tracker;

// Referenced classes of package com.google.android.gms.vision.face:
//            Face

public class LargestFaceFocusingProcessor extends FocusingProcessor
{

    public LargestFaceFocusingProcessor(Detector detector, Tracker tracker)
    {
        super(detector, tracker);
    }

    public int selectFocus(com.google.android.gms.vision.Detector.Detections detections)
    {
        detections = detections.getDetectedItems();
        if (detections.size() == 0)
        {
            throw new IllegalArgumentException("No faces for selectFocus.");
        }
        int j = detections.keyAt(0);
        float f = ((Face)detections.valueAt(0)).getWidth();
        for (int i = 1; i < detections.size();)
        {
            int k = detections.keyAt(i);
            float f2 = ((Face)detections.valueAt(i)).getWidth();
            float f1 = f;
            if (f2 > f)
            {
                f1 = f2;
                j = k;
            }
            i++;
            f = f1;
        }

        return j;
    }
}
