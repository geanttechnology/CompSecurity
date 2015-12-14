// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.NewSecBeautyToolBar;
import com.fotoable.beautyui.newui.MSlimBodyFragment;

public class ww
    implements jv
{

    final MSlimBodyFragment a;

    public ww(MSlimBodyFragment mslimbodyfragment)
    {
        a = mslimbodyfragment;
        super();
    }

    public void a()
    {
        if (MSlimBodyFragment.e(a) == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.QuBan && !MSlimBodyFragment.h(a).c())
        {
            FlurryAgent.logEvent("qudoubar_undoclicked");
            adg adg1 = new adg();
            for (int i = 0; (long)i < MSlimBodyFragment.h(a).b() - 1L; i++)
            {
                adg1.a(MSlimBodyFragment.h(a).a(i));
            }

            MSlimBodyFragment.h(a).d();
            MSlimBodyFragment.a(a, adg1);
            if (MSlimBodyFragment.h(a).c())
            {
                MSlimBodyFragment.i(a).updateUiUndo(false);
            }
            MSlimBodyFragment.g(a);
        }
    }

    public void a(int i)
    {
        if (a.getActivity() == null)
        {
            return;
        } else
        {
            MSlimBodyFragment.a(a, i, true);
            return;
        }
    }

    public void a(boolean flag)
    {
        a.a = flag;
        if (MSlimBodyFragment.e(a) == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.QuBan)
        {
            FlurryAgent.logEvent("autoblemishClicked");
        }
        MSlimBodyFragment.g(a);
    }

    public void b()
    {
        int j = 0x7f060141;
        int i = 0x7f020328;
        if (MSlimBodyFragment.e(a) == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.QuBan)
        {
            j = 0x7f060142;
            i = 0x7f020329;
            FlurryAgent.logEvent("qudou_helphint_clicked");
        }
        MSlimBodyFragment.a(a, j, i);
    }
}
