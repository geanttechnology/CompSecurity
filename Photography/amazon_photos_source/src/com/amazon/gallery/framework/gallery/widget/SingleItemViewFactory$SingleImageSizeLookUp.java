// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ThumbnailSizeLookUp, SingleItemViewFactory

public static class context
    implements ThumbnailSizeLookUp
{

    private final Context context;
    private int orientation;
    private final Point size = new Point();

    private void updateScreenSize()
    {
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getSize(size);
    }

    private void updateScreenSizeIfNeeded()
    {
        int i = context.getResources().getConfiguration().orientation;
        if (orientation != i)
        {
            orientation = i;
            updateScreenSize();
        }
    }

    public int getHeight(int i)
    {
        updateScreenSizeIfNeeded();
        return size.y;
    }

    public int getWidth(int i)
    {
        updateScreenSizeIfNeeded();
        return size.x;
    }

    public (Context context1)
    {
        orientation = 0;
        context = context1;
    }
}
