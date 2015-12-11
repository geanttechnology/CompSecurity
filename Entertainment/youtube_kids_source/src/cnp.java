// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;

public final class cnp extends dd
    implements bn
{

    private cnp(int i)
    {
        super(i);
    }

    public cnp(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        int i = ((DisplayMetrics) (context)).widthPixels;
        this((((DisplayMetrics) (context)).heightPixels * i << 2) * 3);
    }

    protected final int b(Object obj, Object obj1)
    {
        obj = (Bitmap)obj1;
        return ((Bitmap) (obj)).getRowBytes() * ((Bitmap) (obj)).getHeight();
    }
}
