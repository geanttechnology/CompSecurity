// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.graphics.drawable.Drawable;

interface ShadowViewDelegate
{

    public abstract float getRadius();

    public abstract void setBackgroundDrawable(Drawable drawable);

    public abstract void setShadowPadding(int i, int j, int k, int l);
}
