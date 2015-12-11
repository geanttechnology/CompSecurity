// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.ax;
import android.support.v7.i;
import android.support.v7.t;
import android.support.v7.u;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v7.internal.widget:
//            o, m

public final class p
{
    private static class a extends ax
    {

        private static int b(int i1, android.graphics.PorterDuff.Mode mode)
        {
            return (i1 + 31) * 31 + mode.hashCode();
        }

        PorterDuffColorFilter a(int i1, android.graphics.PorterDuff.Mode mode)
        {
            return (PorterDuffColorFilter)a(Integer.valueOf(b(i1, mode)));
        }

        PorterDuffColorFilter a(int i1, android.graphics.PorterDuff.Mode mode, PorterDuffColorFilter porterduffcolorfilter)
        {
            return (PorterDuffColorFilter)a(Integer.valueOf(b(i1, mode)), porterduffcolorfilter);
        }

        public a(int i1)
        {
            super(i1);
        }
    }


    public static final boolean a;
    private static final android.graphics.PorterDuff.Mode b;
    private static final WeakHashMap c = new WeakHashMap();
    private static final a d = new a(6);
    private static final int e[];
    private static final int f[];
    private static final int g[];
    private static final int h[];
    private static final int i[];
    private static final int j[];
    private final WeakReference k;
    private SparseArray l;
    private ColorStateList m;

    private p(Context context)
    {
        k = new WeakReference(context);
    }

    public static Drawable a(Context context, int i1)
    {
        if (d(i1))
        {
            return a(context).a(i1);
        } else
        {
            return android.support.v7.i.a(context, i1);
        }
    }

    public static p a(Context context)
    {
        p p2 = (p)c.get(context);
        p p1 = p2;
        if (p2 == null)
        {
            p1 = new p(context);
            c.put(context, p1);
        }
        return p1;
    }

    private static void a(Drawable drawable, int i1, android.graphics.PorterDuff.Mode mode)
    {
        android.graphics.PorterDuff.Mode mode1 = mode;
        if (mode == null)
        {
            mode1 = b;
        }
        PorterDuffColorFilter porterduffcolorfilter = d.a(i1, mode1);
        mode = porterduffcolorfilter;
        if (porterduffcolorfilter == null)
        {
            mode = new PorterDuffColorFilter(i1, mode1);
            d.a(i1, mode1, mode);
        }
        drawable.setColorFilter(mode);
    }

    public static void a(View view, o o1)
    {
        Drawable drawable = view.getBackground();
        if (o1.d)
        {
            int i1 = o1.a.getColorForState(view.getDrawableState(), o1.a.getDefaultColor());
            if (o1.c)
            {
                o1 = o1.b;
            } else
            {
                o1 = null;
            }
            a(drawable, i1, ((android.graphics.PorterDuff.Mode) (o1)));
        } else
        {
            drawable.clearColorFilter();
        }
        if (android.os.Build.VERSION.SDK_INT <= 10)
        {
            view.invalidate();
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

    private ColorStateList b(Context context)
    {
        if (m == null)
        {
            int i1 = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorControlNormal);
            int j1 = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorControlActivated);
            int ai[] = m.a;
            int k1 = android.support.v7.internal.widget.m.c(context, android.support.v7.br.a.colorControlNormal);
            m = new ColorStateList(new int[][] {
                ai, m.b, m.c, m.d, m.e, m.f, m.h
            }, new int[] {
                k1, j1, j1, j1, j1, j1, i1
            });
        }
        return m;
    }

    private ColorStateList c(Context context)
    {
        int ai[] = m.a;
        int i1 = android.support.v7.internal.widget.m.c(context, android.support.v7.br.a.colorControlNormal);
        int ai1[] = m.e;
        int j1 = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorControlActivated);
        int ai2[] = m.h;
        int k1 = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorControlNormal);
        return new ColorStateList(new int[][] {
            ai, ai1, ai2
        }, new int[] {
            i1, j1, k1
        });
    }

    private ColorStateList d(Context context)
    {
        int ai[] = m.a;
        int i1 = android.support.v7.internal.widget.m.a(context, 0x1010030, 0.1F);
        int ai1[] = m.e;
        int j1 = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorControlActivated, 0.3F);
        int ai2[] = m.h;
        int k1 = android.support.v7.internal.widget.m.a(context, 0x1010030, 0.3F);
        return new ColorStateList(new int[][] {
            ai, ai1, ai2
        }, new int[] {
            i1, j1, k1
        });
    }

    private static boolean d(int i1)
    {
        return a(f, i1) || a(e, i1) || a(g, i1) || a(i, i1) || a(h, i1) || a(j, i1) || i1 == android.support.v7.br.e.abc_cab_background_top_material;
    }

    private ColorStateList e(Context context)
    {
        int ai[][] = new int[3][];
        int ai1[] = new int[3];
        ColorStateList colorstatelist = android.support.v7.internal.widget.m.b(context, android.support.v7.br.a.colorSwitchThumbNormal);
        if (colorstatelist != null && colorstatelist.isStateful())
        {
            ai[0] = m.a;
            ai1[0] = colorstatelist.getColorForState(ai[0], 0);
            ai[1] = m.e;
            ai1[1] = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorControlActivated);
            ai[2] = m.h;
            ai1[2] = colorstatelist.getDefaultColor();
        } else
        {
            ai[0] = m.a;
            ai1[0] = android.support.v7.internal.widget.m.c(context, android.support.v7.br.a.colorSwitchThumbNormal);
            ai[1] = m.e;
            ai1[1] = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorControlActivated);
            ai[2] = m.h;
            ai1[2] = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorSwitchThumbNormal);
        }
        return new ColorStateList(ai, ai1);
    }

    private ColorStateList f(Context context)
    {
        int ai[] = m.a;
        int i1 = android.support.v7.internal.widget.m.c(context, android.support.v7.br.a.colorControlNormal);
        int ai1[] = m.g;
        int j1 = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorControlNormal);
        int ai2[] = m.h;
        int k1 = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorControlActivated);
        return new ColorStateList(new int[][] {
            ai, ai1, ai2
        }, new int[] {
            i1, j1, k1
        });
    }

    private ColorStateList g(Context context)
    {
        int i1 = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorButtonNormal);
        int l1 = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorControlHighlight);
        int ai[] = m.a;
        int j1 = android.support.v7.internal.widget.m.c(context, android.support.v7.br.a.colorButtonNormal);
        context = m.d;
        int k1 = t.a(l1, i1);
        int ai1[] = m.b;
        l1 = t.a(l1, i1);
        return new ColorStateList(new int[][] {
            ai, context, ai1, m.h
        }, new int[] {
            j1, k1, l1, i1
        });
    }

    private ColorStateList h(Context context)
    {
        int ai[] = m.a;
        int i1 = android.support.v7.internal.widget.m.c(context, android.support.v7.br.a.colorControlNormal);
        int ai1[] = m.g;
        int j1 = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorControlNormal);
        int ai2[] = m.h;
        int k1 = android.support.v7.internal.widget.m.a(context, android.support.v7.br.a.colorControlActivated);
        return new ColorStateList(new int[][] {
            ai, ai1, ai2
        }, new int[] {
            i1, j1, k1
        });
    }

    public Drawable a(int i1)
    {
        return a(i1, false);
    }

    public Drawable a(int i1, boolean flag)
    {
        Object obj;
        Drawable drawable1;
        obj = (Context)k.get();
        if (obj == null)
        {
            return null;
        }
        drawable1 = android.support.v7.i.a(((Context) (obj)), i1);
        obj = drawable1;
        if (drawable1 == null) goto _L2; else goto _L1
_L1:
        Drawable drawable;
        drawable = drawable1;
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            drawable = drawable1.mutate();
        }
        obj = c(i1);
        if (obj == null) goto _L4; else goto _L3
_L3:
        drawable = u.c(drawable);
        u.a(drawable, ((ColorStateList) (obj)));
        android.graphics.PorterDuff.Mode mode = b(i1);
        obj = drawable;
        if (mode != null)
        {
            u.a(drawable, mode);
            obj = drawable;
        }
_L2:
        return ((Drawable) (obj));
_L4:
        if (i1 == android.support.v7.br.e.abc_cab_background_top_material)
        {
            return new LayerDrawable(new Drawable[] {
                a(android.support.v7.br.e.abc_cab_background_internal_bg), a(android.support.v7.br.e.abc_cab_background_top_mtrl_alpha)
            });
        }
        obj = drawable;
        if (!a(i1, drawable))
        {
            obj = drawable;
            if (flag)
            {
                obj = null;
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final boolean a(int i1, Drawable drawable)
    {
        Context context = (Context)k.get();
        if (context == null)
        {
            return false;
        }
        android.graphics.PorterDuff.Mode mode;
        int j1;
        boolean flag;
        if (a(e, i1))
        {
            j1 = android.support.v7.br.a.colorControlNormal;
            mode = null;
            flag = true;
            i1 = -1;
        } else
        if (a(g, i1))
        {
            j1 = android.support.v7.br.a.colorControlActivated;
            mode = null;
            flag = true;
            i1 = -1;
        } else
        if (a(h, i1))
        {
            mode = android.graphics.PorterDuff.Mode.MULTIPLY;
            flag = true;
            j1 = 0x1010031;
            i1 = -1;
        } else
        if (i1 == android.support.v7.br.e.abc_list_divider_mtrl_alpha)
        {
            j1 = 0x1010030;
            i1 = Math.round(40.8F);
            mode = null;
            flag = true;
        } else
        {
            i1 = -1;
            j1 = 0;
            mode = null;
            flag = false;
        }
        if (flag)
        {
            a(drawable, android.support.v7.internal.widget.m.a(context, j1), mode);
            if (i1 != -1)
            {
                drawable.setAlpha(i1);
            }
            return true;
        } else
        {
            return false;
        }
    }

    final android.graphics.PorterDuff.Mode b(int i1)
    {
        android.graphics.PorterDuff.Mode mode = null;
        if (i1 == android.support.v7.br.e.abc_switch_thumb_material)
        {
            mode = android.graphics.PorterDuff.Mode.MULTIPLY;
        }
        return mode;
    }

    public final ColorStateList c(int i1)
    {
        ColorStateList colorstatelist = null;
        Object obj = (Context)k.get();
        if (obj == null)
        {
            obj = null;
        } else
        {
            if (l != null)
            {
                colorstatelist = (ColorStateList)l.get(i1);
            }
            if (colorstatelist == null)
            {
                if (i1 == android.support.v7.br.e.abc_edit_text_material)
                {
                    colorstatelist = f(((Context) (obj)));
                } else
                if (i1 == android.support.v7.br.e.abc_switch_track_mtrl_alpha)
                {
                    colorstatelist = d(((Context) (obj)));
                } else
                if (i1 == android.support.v7.br.e.abc_switch_thumb_material)
                {
                    colorstatelist = e(((Context) (obj)));
                } else
                if (i1 == android.support.v7.br.e.abc_btn_default_mtrl_shape || i1 == android.support.v7.br.e.abc_btn_borderless_material)
                {
                    colorstatelist = g(((Context) (obj)));
                } else
                if (i1 == android.support.v7.br.e.abc_spinner_mtrl_am_alpha || i1 == android.support.v7.br.e.abc_spinner_textfield_background_material)
                {
                    colorstatelist = h(((Context) (obj)));
                } else
                if (a(f, i1))
                {
                    colorstatelist = android.support.v7.internal.widget.m.b(((Context) (obj)), android.support.v7.br.a.colorControlNormal);
                } else
                if (a(i, i1))
                {
                    colorstatelist = b(((Context) (obj)));
                } else
                if (a(j, i1))
                {
                    colorstatelist = c(((Context) (obj)));
                }
                obj = colorstatelist;
                if (colorstatelist != null)
                {
                    if (l == null)
                    {
                        l = new SparseArray();
                    }
                    l.append(i1, colorstatelist);
                    return colorstatelist;
                }
            } else
            {
                return colorstatelist;
            }
        }
        return ((ColorStateList) (obj));
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
        b = android.graphics.PorterDuff.Mode.SRC_IN;
        e = (new int[] {
            android.support.v7.br.e.abc_textfield_search_default_mtrl_alpha, android.support.v7.br.e.abc_textfield_default_mtrl_alpha, android.support.v7.br.e.abc_ab_share_pack_mtrl_alpha
        });
        f = (new int[] {
            android.support.v7.br.e.abc_ic_ab_back_mtrl_am_alpha, android.support.v7.br.e.abc_ic_go_search_api_mtrl_alpha, android.support.v7.br.e.abc_ic_search_api_mtrl_alpha, android.support.v7.br.e.abc_ic_commit_search_api_mtrl_alpha, android.support.v7.br.e.abc_ic_clear_mtrl_alpha, android.support.v7.br.e.abc_ic_menu_share_mtrl_alpha, android.support.v7.br.e.abc_ic_menu_copy_mtrl_am_alpha, android.support.v7.br.e.abc_ic_menu_cut_mtrl_alpha, android.support.v7.br.e.abc_ic_menu_selectall_mtrl_alpha, android.support.v7.br.e.abc_ic_menu_paste_mtrl_am_alpha, 
            android.support.v7.br.e.abc_ic_menu_moreoverflow_mtrl_alpha, android.support.v7.br.e.abc_ic_voice_search_api_mtrl_alpha
        });
        g = (new int[] {
            android.support.v7.br.e.abc_textfield_activated_mtrl_alpha, android.support.v7.br.e.abc_textfield_search_activated_mtrl_alpha, android.support.v7.br.e.abc_cab_background_top_mtrl_alpha, android.support.v7.br.e.abc_text_cursor_mtrl_alpha
        });
        h = (new int[] {
            android.support.v7.br.e.abc_popup_background_mtrl_mult, android.support.v7.br.e.abc_cab_background_internal_bg, android.support.v7.br.e.abc_menu_hardkey_panel_mtrl_mult
        });
        i = (new int[] {
            android.support.v7.br.e.abc_edit_text_material, android.support.v7.br.e.abc_tab_indicator_material, android.support.v7.br.e.abc_textfield_search_material, android.support.v7.br.e.abc_spinner_mtrl_am_alpha, android.support.v7.br.e.abc_spinner_textfield_background_material, android.support.v7.br.e.abc_ratingbar_full_material, android.support.v7.br.e.abc_switch_track_mtrl_alpha, android.support.v7.br.e.abc_switch_thumb_material, android.support.v7.br.e.abc_btn_default_mtrl_shape, android.support.v7.br.e.abc_btn_borderless_material
        });
        j = (new int[] {
            android.support.v7.br.e.abc_btn_check_material, android.support.v7.br.e.abc_btn_radio_material
        });
    }
}
