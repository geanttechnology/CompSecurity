// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.graphics.PorterDuffColorFilter;
import android.support.v4.f.f;

// Referenced classes of package android.support.v7.internal.widget:
//            r

private static class  extends f
{

    private static int b(int i, android.graphics.erDuff.Mode mode)
    {
        return (i + 31) * 31 + mode.hashCode();
    }

    PorterDuffColorFilter a(int i, android.graphics.erDuff.Mode mode)
    {
        return (PorterDuffColorFilter)a(Integer.valueOf(b(i, mode)));
    }

    PorterDuffColorFilter a(int i, android.graphics.erDuff.Mode mode, PorterDuffColorFilter porterduffcolorfilter)
    {
        return (PorterDuffColorFilter)a(Integer.valueOf(b(i, mode)), porterduffcolorfilter);
    }

    public (int i)
    {
        super(i);
    }
}
