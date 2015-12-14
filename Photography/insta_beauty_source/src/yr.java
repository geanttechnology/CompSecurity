// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

class yr extends BitmapDrawable
{

    private final WeakReference a;

    public yr(Resources resources, Bitmap bitmap, ys ys1)
    {
        super(resources, bitmap);
        a = new WeakReference(ys1);
    }

    public ys a()
    {
        return (ys)a.get();
    }
}
