// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class JudgeVerdictOnModule extends Enum
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


    private static final JudgeVerdictOnModule $VALUES[];
    public static final JudgeVerdictOnModule FrameApprovedBecauseAffineCanvasImageIsSufficientlyNovel;
    public static final JudgeVerdictOnModule FrameApprovedBecauseEnoughTimeExpired;
    public static final JudgeVerdictOnModule FrameApprovedBecauseFocusHasImproved;
    public static final JudgeVerdictOnModule FrameApprovedBecauseHistogramSufficientlyDifferentFromLastRun;
    public static final JudgeVerdictOnModule FrameApprovedBecauseImageScaleHasChanged;
    public static final JudgeVerdictOnModule FrameApprovedBecauseModuleNeverRun;
    public static final JudgeVerdictOnModule FrameApprovedBecauseObjectModuleIsActive;
    public static final JudgeVerdictOnModule FrameApprovedBecauseTrackerHasDetectedSufficientMotion;
    public static final JudgeVerdictOnModule FrameStatusIsUnknown;
    public static final JudgeVerdictOnModule FrameVetoedBecauseAlreadyRun;
    public static final JudgeVerdictOnModule FrameVetoedBecauseCachedImageIsBetter;
    public static final JudgeVerdictOnModule FrameVetoedBecauseCherryPickedFrameUnexpectedlyNull;
    public static final JudgeVerdictOnModule FrameVetoedBecauseFrameUnexpectedlyNull;
    public static final JudgeVerdictOnModule FrameVetoedBecauseNoApprovalTestsSucceeded;
    public static final JudgeVerdictOnModule FrameVetoedBecauseOfUnexpectedError;
    public static final JudgeVerdictOnModule NUM_FRAME_JUDGE_VERVICTS;
    private final int swigValue;

    private JudgeVerdictOnModule(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private JudgeVerdictOnModule(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private JudgeVerdictOnModule(String s, int i, JudgeVerdictOnModule judgeverdictonmodule)
    {
        Enum(s, i);
        swigValue = judgeverdictonmodule.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static JudgeVerdictOnModule swigToEnum(int i)
    {
        JudgeVerdictOnModule ajudgeverdictonmodule[] = (JudgeVerdictOnModule[])com/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule.getEnumConstants();
        if (i >= ajudgeverdictonmodule.length || i < 0 || ajudgeverdictonmodule[i].swigValue != i) goto _L2; else goto _L1
_L1:
        JudgeVerdictOnModule judgeverdictonmodule = ajudgeverdictonmodule[i];
_L4:
        return judgeverdictonmodule;
_L2:
        int k = ajudgeverdictonmodule.length;
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
                JudgeVerdictOnModule judgeverdictonmodule1 = ajudgeverdictonmodule[j];
                judgeverdictonmodule = judgeverdictonmodule1;
                if (judgeverdictonmodule1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule).append(" with value ").append(i).toString());
    }

    public static JudgeVerdictOnModule valueOf(String s)
    {
        return (JudgeVerdictOnModule)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule, s);
    }

    public static JudgeVerdictOnModule[] values()
    {
        return (JudgeVerdictOnModule[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        FrameVetoedBecauseFrameUnexpectedlyNull = new JudgeVerdictOnModule("FrameVetoedBecauseFrameUnexpectedlyNull", 0, 0);
        FrameVetoedBecauseCherryPickedFrameUnexpectedlyNull = new JudgeVerdictOnModule("FrameVetoedBecauseCherryPickedFrameUnexpectedlyNull", 1);
        FrameVetoedBecauseOfUnexpectedError = new JudgeVerdictOnModule("FrameVetoedBecauseOfUnexpectedError", 2);
        FrameVetoedBecauseAlreadyRun = new JudgeVerdictOnModule("FrameVetoedBecauseAlreadyRun", 3);
        FrameVetoedBecauseNoApprovalTestsSucceeded = new JudgeVerdictOnModule("FrameVetoedBecauseNoApprovalTestsSucceeded", 4);
        FrameVetoedBecauseCachedImageIsBetter = new JudgeVerdictOnModule("FrameVetoedBecauseCachedImageIsBetter", 5);
        FrameApprovedBecauseModuleNeverRun = new JudgeVerdictOnModule("FrameApprovedBecauseModuleNeverRun", 6);
        FrameApprovedBecauseObjectModuleIsActive = new JudgeVerdictOnModule("FrameApprovedBecauseObjectModuleIsActive", 7);
        FrameApprovedBecauseEnoughTimeExpired = new JudgeVerdictOnModule("FrameApprovedBecauseEnoughTimeExpired", 8);
        FrameApprovedBecauseHistogramSufficientlyDifferentFromLastRun = new JudgeVerdictOnModule("FrameApprovedBecauseHistogramSufficientlyDifferentFromLastRun", 9);
        FrameApprovedBecauseTrackerHasDetectedSufficientMotion = new JudgeVerdictOnModule("FrameApprovedBecauseTrackerHasDetectedSufficientMotion", 10);
        FrameApprovedBecauseFocusHasImproved = new JudgeVerdictOnModule("FrameApprovedBecauseFocusHasImproved", 11);
        FrameApprovedBecauseImageScaleHasChanged = new JudgeVerdictOnModule("FrameApprovedBecauseImageScaleHasChanged", 12);
        FrameApprovedBecauseAffineCanvasImageIsSufficientlyNovel = new JudgeVerdictOnModule("FrameApprovedBecauseAffineCanvasImageIsSufficientlyNovel", 13);
        FrameStatusIsUnknown = new JudgeVerdictOnModule("FrameStatusIsUnknown", 14);
        NUM_FRAME_JUDGE_VERVICTS = new JudgeVerdictOnModule("NUM_FRAME_JUDGE_VERVICTS", 15);
        $VALUES = (new JudgeVerdictOnModule[] {
            FrameVetoedBecauseFrameUnexpectedlyNull, FrameVetoedBecauseCherryPickedFrameUnexpectedlyNull, FrameVetoedBecauseOfUnexpectedError, FrameVetoedBecauseAlreadyRun, FrameVetoedBecauseNoApprovalTestsSucceeded, FrameVetoedBecauseCachedImageIsBetter, FrameApprovedBecauseModuleNeverRun, FrameApprovedBecauseObjectModuleIsActive, FrameApprovedBecauseEnoughTimeExpired, FrameApprovedBecauseHistogramSufficientlyDifferentFromLastRun, 
            FrameApprovedBecauseTrackerHasDetectedSufficientMotion, FrameApprovedBecauseFocusHasImproved, FrameApprovedBecauseImageScaleHasChanged, FrameApprovedBecauseAffineCanvasImageIsSufficientlyNovel, FrameStatusIsUnknown, NUM_FRAME_JUDGE_VERVICTS
        });
    }
}
