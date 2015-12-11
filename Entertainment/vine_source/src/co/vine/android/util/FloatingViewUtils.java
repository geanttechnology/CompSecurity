// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

// Referenced classes of package co.vine.android.util:
//            ViewUtil

public class FloatingViewUtils
{

    public FloatingViewUtils()
    {
    }

    public static Bitmap buildFloatingViewFor(Context context, View view, View view1, int i, int j, int k)
    {
        android.content.res.Resources resources = context.getResources();
        int l = view.getMeasuredHeight();
        view.setDrawingCacheQuality(0x100000);
        view.setDrawingCacheEnabled(true);
        context = Bitmap.createBitmap(view.getDrawingCache(true));
        view.setDrawingCacheEnabled(false);
        ViewUtil.setBackground(view1, new BitmapDrawable(resources, context));
        view = (android.widget.RelativeLayout.LayoutParams)view1.getLayoutParams();
        view.width = i;
        view.height = l;
        view.leftMargin = j;
        view.topMargin = k;
        view1.setLayoutParams(view);
        return context;
    }
}
