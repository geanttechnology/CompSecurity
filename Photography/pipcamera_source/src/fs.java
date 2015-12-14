// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

class fs extends BitmapDrawable
{

    private final WeakReference a;

    public fs(Resources resources, Bitmap bitmap, ft ft1)
    {
        super(resources, bitmap);
        a = new WeakReference(ft1);
    }

    public ft a()
    {
        return (ft)a.get();
    }
}
