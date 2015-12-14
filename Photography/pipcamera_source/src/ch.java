// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.PorterDuffColorFilter;
import android.support.v4.util.LruCache;

class ch extends LruCache
{

    public ch(int i)
    {
        super(i);
    }

    private static int b(int i, android.graphics.PorterDuff.Mode mode)
    {
        return (i + 31) * 31 + mode.hashCode();
    }

    PorterDuffColorFilter a(int i, android.graphics.PorterDuff.Mode mode)
    {
        return (PorterDuffColorFilter)get(Integer.valueOf(b(i, mode)));
    }

    PorterDuffColorFilter a(int i, android.graphics.PorterDuff.Mode mode, PorterDuffColorFilter porterduffcolorfilter)
    {
        return (PorterDuffColorFilter)put(Integer.valueOf(b(i, mode)), porterduffcolorfilter);
    }
}
