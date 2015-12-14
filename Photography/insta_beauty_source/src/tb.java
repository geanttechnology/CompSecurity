// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.fotoable.beautyui.NewFilterContainer;
import com.fotoable.beautyui.newui.FotoBeautySimpleActivity;

class tb
    implements Runnable
{

    final ta a;

    tb(ta ta1)
    {
        a = ta1;
        super();
    }

    public void run()
    {
        Bitmap bitmap = FotoBeautySimpleActivity.d(a.a).copy(FotoBeautySimpleActivity.d(a.a).getConfig(), true);
        FotoBeautySimpleActivity.g(a.a).a(bitmap);
        FotoBeautySimpleActivity.a(a.a, bitmap);
        FotoBeautySimpleActivity.e(a.a).setBtnFindState(a.a.a());
        FotoBeautySimpleActivity.i(a.a).setImageBitmap(FotoBeautySimpleActivity.d(a.a));
        FotoBeautySimpleActivity.a(a.a).setImageBitmap(FotoBeautySimpleActivity.d(a.a));
        FotoBeautySimpleActivity.j(a.a);
        FotoBeautySimpleActivity.k(a.a);
    }
}
