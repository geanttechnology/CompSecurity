// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;

final class aey
    implements aga
{

    private aew a;

    aey(aew aew1)
    {
        a = aew1;
        super();
    }

    public final void a()
    {
        android.graphics.drawable.Drawable drawable = aew.c(a).getBackground();
        aew.c(a).setBackgroundResource(0);
        if (drawable != null && (drawable instanceof BitmapDrawable))
        {
            Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
            if (bitmap != null)
            {
                bitmap.recycle();
            }
        }
        if (drawable != null && aew.a(a) != null)
        {
            aew.a(a).a();
        }
        aew.d(a).setImageDrawable(null);
    }
}
