// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.beautyui.newui.FotoBeautySimpleActivity;

public class tf
    implements uy
{

    final Bitmap a;
    final FotoBeautySimpleActivity b;

    public tf(FotoBeautySimpleActivity fotobeautysimpleactivity, Bitmap bitmap)
    {
        b = fotobeautysimpleactivity;
        a = bitmap;
        super();
    }

    public void a()
    {
        if (b != null)
        {
            b.runOnUiThread(new tg(this));
        }
    }
}
