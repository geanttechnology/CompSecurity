// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ScrollerRunnable

public static interface 
{

    public abstract int getMaxX();

    public abstract int getMinX();

    public abstract boolean post(Runnable runnable);

    public abstract boolean removeCallbacks(Runnable runnable);

    public abstract void scrollIntoSlots();

    public abstract void trackMotionScroll(int i);
}
