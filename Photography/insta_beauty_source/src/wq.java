// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.app.FragmentActivity;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.newui.MSlimBodyFragment;

public class wq
    implements Runnable
{

    final MSlimBodyFragment a;

    public wq(MSlimBodyFragment mslimbodyfragment)
    {
        a = mslimbodyfragment;
        super();
    }

    public void run()
    {
        try
        {
            if (a.getActivity() == null)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            exception.printStackTrace();
            return;
        }
        MSlimBodyFragment.Q(a).b(a.getActivity().getAssets(), MSlimBodyFragment.f(a));
        if (MSlimBodyFragment.e(a) != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.QuBan) goto _L2; else goto _L1
_L1:
        MSlimBodyFragment.T(a);
_L3:
        if (a.getActivity() != null)
        {
            a.getActivity().runOnUiThread(new wr(this));
            return;
        }
        break MISSING_BLOCK_LABEL_235;
_L2:
label0:
        {
            if (MSlimBodyFragment.e(a) != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.BigEye)
            {
                break label0;
            }
            MSlimBodyFragment.U(a);
        }
          goto _L3
label1:
        {
            if (MSlimBodyFragment.e(a) != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.SlimFace)
            {
                break label1;
            }
            MSlimBodyFragment.V(a);
        }
          goto _L3
label2:
        {
            if (MSlimBodyFragment.e(a) != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.SlimNose)
            {
                break label2;
            }
            MSlimBodyFragment.W(a);
        }
          goto _L3
label3:
        {
            if (MSlimBodyFragment.e(a) != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.ClearEye)
            {
                break label3;
            }
            MSlimBodyFragment.X(a);
        }
          goto _L3
        if (MSlimBodyFragment.e(a) != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.EnhanceNose) goto _L5; else goto _L4
_L4:
        MSlimBodyFragment.Y(a);
          goto _L3
_L5:
        if (MSlimBodyFragment.e(a) != com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.EyeBag) goto _L3; else goto _L6
_L6:
        MSlimBodyFragment.Z(a);
          goto _L3
    }
}
