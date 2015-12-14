// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.fotoable.beautyui.NewFilterContainer;
import com.fotoable.beautyui.newui.FotoBeautySimpleActivity;

class ti
    implements Runnable
{

    final FotoBeautySimpleActivity a;
    final Bitmap b;
    final th c;

    ti(th th1, FotoBeautySimpleActivity fotobeautysimpleactivity, Bitmap bitmap)
    {
        c = th1;
        a = fotobeautysimpleactivity;
        b = bitmap;
        super();
    }

    public void run()
    {
        if (a == null)
        {
            return;
        } else
        {
            FotoBeautySimpleActivity.a(a).setImageBitmap(b);
            FotoBeautySimpleActivity.a(a, FotoBeautySimpleActivity.a(a), FotoBeautySimpleActivity.l(c.a));
            FotoBeautySimpleActivity.e(a).setFilterValue(FotoBeautySimpleActivity.l(c.a));
            FotoBeautySimpleActivity.j(a);
            FotoBeautySimpleActivity.e(a).needScrollView();
            return;
        }
    }
}
