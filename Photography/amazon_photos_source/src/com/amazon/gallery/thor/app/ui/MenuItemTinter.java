// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui;

import android.graphics.drawable.Drawable;

public class MenuItemTinter
{

    public static void applyTint(Drawable drawable, int i)
    {
        if (drawable != null)
        {
            drawable.mutate();
            drawable.setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_ATOP);
        }
    }
}
