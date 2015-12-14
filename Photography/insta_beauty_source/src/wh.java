// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import com.fotoable.beautyui.ImageDetailView;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.newui.MSlimBodyFragment;

public class wh
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final MSlimBodyFragment a;

    public wh(MSlimBodyFragment mslimbodyfragment)
    {
        a = mslimbodyfragment;
        super();
    }

    public void onGlobalLayout()
    {
        android.widget.FrameLayout.LayoutParams layoutparams;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            MSlimBodyFragment.a(a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else
        {
            MSlimBodyFragment.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        MSlimBodyFragment.a(a, MSlimBodyFragment.b(a), yp.a(a.getActivity(), 90F), 0, 300L, true);
        layoutparams = (android.widget.FrameLayout.LayoutParams)MSlimBodyFragment.c(a).getLayoutParams();
        layoutparams.width = a.getResources().getDisplayMetrics().widthPixels / 3;
        layoutparams.height = a.getResources().getDisplayMetrics().widthPixels / 3;
        layoutparams.gravity = 51;
        MSlimBodyFragment.c(a).setLayoutParams(layoutparams);
    }
}
