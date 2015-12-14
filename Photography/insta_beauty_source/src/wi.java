// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.NewOneBeautyToolBar;
import com.fotoable.beautyui.NewSecBeautyToolBar;
import com.fotoable.beautyui.newui.MNewTextItemView;
import com.fotoable.beautyui.newui.MSlimBodyFragment;

public class wi
    implements android.view.View.OnClickListener
{

    final MSlimBodyFragment a;

    public wi(MSlimBodyFragment mslimbodyfragment)
    {
        a = mslimbodyfragment;
        super();
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 4: default 48
    //                   2131558603: 197
    //                   2131558662: 205
    //                   2131558933: 143
    //                   2131558934: 49;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L5:
        if (MSlimBodyFragment.q(a))
        {
            MSlimBodyFragment.a(a, false);
            MSlimBodyFragment.k(a).setIsManual(false);
            MSlimBodyFragment.i(a).setIsMunal(false);
            MSlimBodyFragment.r(a).setSelected(false);
            MSlimBodyFragment.s(a).setSelected(true);
            return;
        }
        if (MSlimBodyFragment.d(a) != null)
        {
            MSlimBodyFragment.d(a).b(MSlimBodyFragment.e(a));
            return;
        }
          goto _L1
_L4:
        MSlimBodyFragment.a(a, true);
        MSlimBodyFragment.r(a).setSelected(true);
        MSlimBodyFragment.s(a).setSelected(false);
        MSlimBodyFragment.k(a).setIsManual(true);
        MSlimBodyFragment.i(a).setIsMunal(true);
        return;
_L2:
        MSlimBodyFragment.t(a);
        return;
_L3:
        MSlimBodyFragment.u(a);
        return;
    }
}
