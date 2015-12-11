// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class CameraStabilityIssue extends Enum
{
    private static class SwigNext
    {

        private static int next = 0;



/*
        static int access$002(int i)
        {
            next = i;
            return i;
        }

*/


/*
        static int access$008()
        {
            int i = next;
            next = i + 1;
            return i;
        }

*/

        private SwigNext()
        {
        }
    }


    private static final CameraStabilityIssue $VALUES[];
    public static final CameraStabilityIssue CameraHasStabilized;
    public static final CameraStabilityIssue CameraHistogramIsChangingTooMuch;
    public static final CameraStabilityIssue CameraHistogramSuggestsTooLittleContrast;
    public static final CameraStabilityIssue CameraPoseHasNotStabilized;
    public static final CameraStabilityIssue NUM_CAMERA_STATUS;
    public static final CameraStabilityIssue TrackerHasFailedOrTranslatedTooMuch;
    public static final CameraStabilityIssue UnknownStabilityError;
    private final int swigValue;

    private CameraStabilityIssue(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private CameraStabilityIssue(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private CameraStabilityIssue(String s, int i, CameraStabilityIssue camerastabilityissue)
    {
        Enum(s, i);
        swigValue = camerastabilityissue.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static CameraStabilityIssue swigToEnum(int i)
    {
        CameraStabilityIssue acamerastabilityissue[] = (CameraStabilityIssue[])com/a9/vs/mobile/library/impl/jni/CameraStabilityIssue.getEnumConstants();
        if (i >= acamerastabilityissue.length || i < 0 || acamerastabilityissue[i].swigValue != i) goto _L2; else goto _L1
_L1:
        CameraStabilityIssue camerastabilityissue = acamerastabilityissue[i];
_L4:
        return camerastabilityissue;
_L2:
        int k = acamerastabilityissue.length;
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= k)
                {
                    break label1;
                }
                CameraStabilityIssue camerastabilityissue1 = acamerastabilityissue[j];
                camerastabilityissue = camerastabilityissue1;
                if (camerastabilityissue1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/CameraStabilityIssue).append(" with value ").append(i).toString());
    }

    public static CameraStabilityIssue valueOf(String s)
    {
        return (CameraStabilityIssue)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/CameraStabilityIssue, s);
    }

    public static CameraStabilityIssue[] values()
    {
        return (CameraStabilityIssue[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        CameraHasStabilized = new CameraStabilityIssue("CameraHasStabilized", 0, 0);
        CameraHistogramSuggestsTooLittleContrast = new CameraStabilityIssue("CameraHistogramSuggestsTooLittleContrast", 1);
        CameraHistogramIsChangingTooMuch = new CameraStabilityIssue("CameraHistogramIsChangingTooMuch", 2);
        TrackerHasFailedOrTranslatedTooMuch = new CameraStabilityIssue("TrackerHasFailedOrTranslatedTooMuch", 3);
        CameraPoseHasNotStabilized = new CameraStabilityIssue("CameraPoseHasNotStabilized", 4);
        UnknownStabilityError = new CameraStabilityIssue("UnknownStabilityError", 5);
        NUM_CAMERA_STATUS = new CameraStabilityIssue("NUM_CAMERA_STATUS", 6);
        $VALUES = (new CameraStabilityIssue[] {
            CameraHasStabilized, CameraHistogramSuggestsTooLittleContrast, CameraHistogramIsChangingTooMuch, TrackerHasFailedOrTranslatedTooMuch, CameraPoseHasNotStabilized, UnknownStabilityError, NUM_CAMERA_STATUS
        });
    }
}
