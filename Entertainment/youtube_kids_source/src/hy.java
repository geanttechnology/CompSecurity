// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

public class hy
{

    static final android.graphics.PorterDuff.Mode a;
    private static final hz b = new hz(6);
    private static final int c[] = {
        0x7f02000e, 0x7f020011, 0x7f020018, 0x7f020010, 0x7f02000f, 0x7f020017, 0x7f020012, 0x7f020013, 0x7f020016, 0x7f020015, 
        0x7f020014, 0x7f020019, 0x7f020031, 0x7f02002f
    };
    private static final int d[] = {
        0x7f02002e, 0x7f020030, 0x7f02000c
    };
    private static final int e[] = {
        0x7f020028, 0x7f02000a, 0x7f020027
    };
    private static final int f[] = {
        0x7f02000d, 0x7f02002c, 0x7f020032, 0x7f020029, 0x7f020002, 0x7f020005
    };
    private static final int g[] = {
        0x7f02000b
    };
    private final Context h;
    private final Resources i;
    private final TypedValue j = new TypedValue();
    private ColorStateList k;
    private ColorStateList l;
    private ColorStateList m;

    public hy(Context context)
    {
        h = context;
        i = new ia(context.getResources(), this);
    }

    private int a(int i1, float f1)
    {
        i1 = b(i1);
        return i1 & 0xffffff | Math.round((float)Color.alpha(i1) * f1) << 24;
    }

    public static Drawable a(Context context, int i1)
    {
        boolean flag;
        if (a(e, i1) || a(c, i1) || a(d, i1) || a(f, i1) || a(g, i1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return (new hy(context)).a(i1);
        } else
        {
            return aw.a(context, i1);
        }
    }

    private static boolean a(int ai[], int i1)
    {
        boolean flag1 = false;
        int k1 = ai.length;
        int j1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (j1 < k1)
                {
                    if (ai[j1] != i1)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            j1++;
        } while (true);
    }

    private int b(int i1)
    {
        if (h.getTheme().resolveAttribute(i1, j, true))
        {
            if (j.type >= 16 && j.type <= 31)
            {
                return j.data;
            }
            if (j.type == 3)
            {
                return i.getColor(j.resourceId);
            }
        }
        return 0;
    }

    private int c(int i1)
    {
        h.getTheme().resolveAttribute(0x1010033, j, true);
        return a(i1, j.getFloat());
    }

    public final Drawable a(int i1)
    {
        Drawable drawable = aw.a(h, i1);
        if (drawable != null)
        {
            if (a(f, i1))
            {
                if (k == null)
                {
                    i1 = b(0x7f0100cf);
                    int j1 = b(0x7f0100d0);
                    int ai[] = {
                        0xfefeff62
                    };
                    int i2 = c(0x7f0100cf);
                    k = new ColorStateList(new int[][] {
                        ai, new int[] {
                            0x101009c
                        }, new int[] {
                            0x10102fe
                        }, new int[] {
                            0x10100a7
                        }, new int[] {
                            0x10100a0
                        }, new int[] {
                            0x10100a1
                        }, new int[0]
                    }, new int[] {
                        i2, j1, j1, j1, j1, j1, i1
                    });
                }
                return new hx(drawable, k);
            }
            if (i1 == 0x7f02002b)
            {
                if (m == null)
                {
                    int ai1[] = {
                        0xfefeff62
                    };
                    i1 = a(0x1010030, 0.1F);
                    int ai3[] = {
                        0x10100a0
                    };
                    int k1 = a(0x7f0100d0, 0.3F);
                    int j2 = a(0x1010030, 0.3F);
                    m = new ColorStateList(new int[][] {
                        ai1, ai3, new int[0]
                    }, new int[] {
                        i1, k1, j2
                    });
                }
                return new hx(drawable, m);
            }
            if (i1 == 0x7f02002a)
            {
                if (l == null)
                {
                    int ai2[] = {
                        0xfefeff62
                    };
                    i1 = c(0x7f0100d3);
                    int l1 = b(0x7f0100d0);
                    int k2 = b(0x7f0100d3);
                    l = new ColorStateList(new int[][] {
                        ai2, new int[] {
                            0x10100a0
                        }, new int[0]
                    }, new int[] {
                        i1, l1, k2
                    });
                }
                return new hx(drawable, l, android.graphics.PorterDuff.Mode.MULTIPLY);
            }
            if (a(g, i1))
            {
                return i.getDrawable(i1);
            }
            a(i1, drawable);
        }
        return drawable;
    }

    final void a(int i1, Drawable drawable)
    {
        Object obj;
        int j1;
        int k1;
        if (a(c, i1))
        {
            i1 = 1;
            j1 = 0x7f0100cf;
            obj = null;
            k1 = -1;
        } else
        if (a(d, i1))
        {
            i1 = 1;
            j1 = 0x7f0100d0;
            obj = null;
            k1 = -1;
        } else
        if (a(e, i1))
        {
            obj = android.graphics.PorterDuff.Mode.MULTIPLY;
            k1 = -1;
            i1 = 1;
            j1 = 0x1010031;
        } else
        if (i1 == 0x7f02001c)
        {
            k1 = Math.round(40.8F);
            obj = null;
            j1 = 0x1010030;
            i1 = 1;
        } else
        {
            j1 = 0;
            i1 = 0;
            obj = null;
            k1 = -1;
        }
        if (i1 != 0)
        {
            if (obj == null)
            {
                obj = a;
            }
            i1 = b(j1);
            PorterDuffColorFilter porterduffcolorfilter1 = (PorterDuffColorFilter)b.a(Integer.valueOf(hz.a(i1, ((android.graphics.PorterDuff.Mode) (obj)))));
            PorterDuffColorFilter porterduffcolorfilter = porterduffcolorfilter1;
            if (porterduffcolorfilter1 == null)
            {
                porterduffcolorfilter = new PorterDuffColorFilter(i1, ((android.graphics.PorterDuff.Mode) (obj)));
                obj = (PorterDuffColorFilter)b.a(Integer.valueOf(hz.a(i1, ((android.graphics.PorterDuff.Mode) (obj)))), porterduffcolorfilter);
            }
            drawable.setColorFilter(porterduffcolorfilter);
            if (k1 != -1)
            {
                drawable.setAlpha(k1);
            }
        }
    }

    static 
    {
        hy.getSimpleName();
        a = android.graphics.PorterDuff.Mode.SRC_IN;
    }
}
