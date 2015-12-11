// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.text.style.ForegroundColorSpan;

// Referenced classes of package co.vine.android.api:
//            VineEntity

public static class span
{

    public VineEntity entity;
    public ForegroundColorSpan span;
    public int upper;

    public n(int i, VineEntity vineentity, ForegroundColorSpan foregroundcolorspan)
    {
        upper = i;
        entity = vineentity;
        span = foregroundcolorspan;
    }
}
