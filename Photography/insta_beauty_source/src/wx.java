// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.NewOneBeautyToolBar;
import com.fotoable.beautyui.NewSecBeautyToolBar;
import com.fotoable.beautyui.newui.MSlimBodyFragment;

public class wx
    implements jk
{

    final MSlimBodyFragment a;

    public wx(MSlimBodyFragment mslimbodyfragment)
    {
        a = mslimbodyfragment;
        super();
    }

    public void a()
    {
        if ((MSlimBodyFragment.e(a) == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.SlimFace || MSlimBodyFragment.e(a) == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.SlimNose) && !MSlimBodyFragment.j(a).c())
        {
            ado ado1;
            if (MSlimBodyFragment.e(a) == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.SlimFace)
            {
                FlurryAgent.logEvent("slimfacebar_undoclicked");
            } else
            {
                FlurryAgent.logEvent("slimnosebar_undo_clicked");
            }
            ado1 = new ado();
            for (int i = 0; (long)i < MSlimBodyFragment.j(a).b() - 1L; i++)
            {
                ado1.a(MSlimBodyFragment.j(a).a(i));
            }

            MSlimBodyFragment.a(a, ado1);
            if (MSlimBodyFragment.j(a).c())
            {
                MSlimBodyFragment.k(a).updateUiUndo(false);
            }
            MSlimBodyFragment.g(a);
        }
        if (MSlimBodyFragment.e(a) == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.BigEye && !MSlimBodyFragment.l(a).c())
        {
            FlurryAgent.logEvent("bigeyebar_undo_clicked");
            adn adn1 = new adn();
            for (int j = 0; (long)j < MSlimBodyFragment.l(a).b() - 1L; j++)
            {
                adn1.a(MSlimBodyFragment.l(a).a(j));
            }

            MSlimBodyFragment.a(a, adn1);
            if (MSlimBodyFragment.l(a).c())
            {
                MSlimBodyFragment.k(a).updateUiUndo(false);
            }
            MSlimBodyFragment.g(a);
        }
        if (MSlimBodyFragment.e(a) == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.EyeBag && !MSlimBodyFragment.m(a).c())
        {
            FlurryAgent.logEvent("eyebagbar_undo_clicked");
            adj adj1 = new adj();
            for (int k = 0; (long)k < MSlimBodyFragment.m(a).b() - 1L; k++)
            {
                adj1.a(MSlimBodyFragment.m(a).a(k));
            }

            MSlimBodyFragment.m(a).d();
            MSlimBodyFragment.a(a, adj1);
            if (MSlimBodyFragment.m(a).c())
            {
                MSlimBodyFragment.i(a).updateUiUndo(false);
            }
            MSlimBodyFragment.g(a);
        }
    }

    public void a(float f)
    {
        MSlimBodyFragment.a(a, f);
        MSlimBodyFragment.g(a);
    }

    public void a(int i)
    {
        MSlimBodyFragment.a(a, i, true);
    }

    public void b()
    {
        int l = 0x7f060141;
        int k = 0x7f020328;
        int i;
        int j;
        if (MSlimBodyFragment.e(a) == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.SlimFace)
        {
            i = 0x7f06013f;
            j = 0x7f02032a;
            FlurryAgent.logEvent("slimfacebar_helphintclicked");
        } else
        {
            j = 0x7f020328;
            i = 0x7f060141;
        }
        if (MSlimBodyFragment.e(a) == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.SlimNose)
        {
            i = 0x7f060140;
            j = 0x7f02032b;
            FlurryAgent.logEvent("slimnosebar_helphint_clicked");
        }
        if (MSlimBodyFragment.e(a) == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.BigEye)
        {
            j = 0x7f020327;
            FlurryAgent.logEvent("bigeyebar_helphint_clicked");
            i = l;
        }
        if (MSlimBodyFragment.e(a) == com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState.EyeBag)
        {
            i = 0x7f06013e;
            FlurryAgent.logEvent("eyebagbar_helphint_clicked");
            j = k;
        }
        MSlimBodyFragment.a(a, i, j);
    }
}
