// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.view.View;

// Referenced classes of package com.bumptech.glide.request.animation:
//            GlideAnimation

public static interface 
{

    public abstract Drawable getCurrentDrawable();

    public abstract View getView();

    public abstract void setDrawable(Drawable drawable);
}
