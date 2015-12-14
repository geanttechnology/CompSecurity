// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.c;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

// Referenced classes of package com.nostra13.universalimageloader.core.c:
//            a

public class c
    implements a
{

    protected final String a;
    protected final com.nostra13.universalimageloader.core.assist.c b;
    protected final ViewScaleType c;

    public c(String s, com.nostra13.universalimageloader.core.assist.c c1, ViewScaleType viewscaletype)
    {
        if (c1 == null)
        {
            throw new IllegalArgumentException("imageSize must not be null");
        }
        if (viewscaletype == null)
        {
            throw new IllegalArgumentException("scaleType must not be null");
        } else
        {
            a = s;
            b = c1;
            c = viewscaletype;
            return;
        }
    }

    public int a()
    {
        return b.a();
    }

    public boolean a(Bitmap bitmap)
    {
        return true;
    }

    public boolean a(Drawable drawable)
    {
        return true;
    }

    public int b()
    {
        return b.b();
    }

    public ViewScaleType c()
    {
        return c;
    }

    public View d()
    {
        return null;
    }

    public boolean e()
    {
        return false;
    }

    public int f()
    {
        if (TextUtils.isEmpty(a))
        {
            return super.hashCode();
        } else
        {
            return a.hashCode();
        }
    }
}
