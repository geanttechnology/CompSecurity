// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public final class k
    implements Runnable
{

    private ImageView a;
    private Drawable b;

    public k(ImageView imageview, Drawable drawable)
    {
        a = imageview;
        b = drawable;
        super();
    }

    public final void run()
    {
        a.setImageDrawable(b);
    }
}
