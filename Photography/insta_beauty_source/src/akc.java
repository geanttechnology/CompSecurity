// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

public class akc
    implements akj
{

    final com.fotoable.fotoproedit.activity.font.FontStyleGridView.FontStyleGridViewAdapter a;

    public akc(com.fotoable.fotoproedit.activity.font.FontStyleGridView.FontStyleGridViewAdapter fontstylegridviewadapter)
    {
        a = fontstylegridviewadapter;
        super();
    }

    public void a(Bitmap bitmap, int i)
    {
        Object obj = a.GetViewByPosition(i);
        if (obj != null)
        {
            obj = (akd)((View) (obj)).getTag();
            if (obj != null && ((akd) (obj)).a != null)
            {
                ((akd) (obj)).a.setImageBitmap(bitmap);
                ((akd) (obj)).a.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            }
        }
    }
}
