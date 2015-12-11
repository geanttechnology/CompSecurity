// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

// Referenced classes of package com.amazon.mShop.ui:
//            DrawableFactory

public static interface 
{

    public abstract Drawable createDrawable(Resources resources, Bitmap bitmap, com.amazon.mShop.net. );

    public abstract Drawable getDefaultDrawable(Resources resources);

    public abstract void resetDefaultImage();
}
