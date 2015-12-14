// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.beautyui.ImageDetailView;
import com.fotoable.beautyui.NewOneBeautyToolBar;
import com.fotoable.beautyui.NewSecBeautyToolBar;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.newui.FlexibleThumbSeekbar;
import com.fotoable.beautyui.newui.MSlimBodyFragment;

class wr
    implements Runnable
{

    final wq a;

    wr(wq wq1)
    {
        a = wq1;
        super();
    }

    public void run()
    {
        MSlimBodyFragment.k(a.a).updateUiSeekbar(MSlimBodyFragment.aa(a.a));
        MSlimBodyFragment.k(a.a).updateUiPenSize(2);
        MSlimBodyFragment.i(a.a).updateUiPensize(2);
        MSlimBodyFragment.a(a.a, 2, false);
        MSlimBodyFragment.ab(a.a).setProgress((int)(MSlimBodyFragment.aa(a.a) * 100F));
        Bitmap bitmap = MSlimBodyFragment.f(a.a).copy(MSlimBodyFragment.f(a.a).getConfig(), true);
        MSlimBodyFragment.Q(a.a).a(bitmap);
        MSlimBodyFragment.a(a.a, bitmap);
        MSlimBodyFragment.x(a.a).setImageBitmap(MSlimBodyFragment.f(a.a));
        MSlimBodyFragment.a(a.a).setImageBitmap(MSlimBodyFragment.f(a.a));
        MSlimBodyFragment.c(a.a).setImage(MSlimBodyFragment.f(a.a));
        MSlimBodyFragment.S(a.a);
    }
}
