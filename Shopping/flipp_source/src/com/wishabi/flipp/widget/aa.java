// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.graphics.RectF;
import android.support.v7.widget.an;
import android.support.v7.widget.bi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.wishabi.flipp.content.FormattedString;
import com.wishabi.flipp.content.ab;
import com.wishabi.flipp.content.ag;
import com.wishabi.flipp.content.b;
import com.wishabi.flipp.content.c;
import com.wishabi.flipp.content.o;
import com.wishabi.flipp.util.i;
import com.wishabi.flipp.util.j;
import com.wishabi.flipp.util.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.widget:
//            af, ab, ch, ItemCellSmall, 
//            ae

public final class aa extends an
{

    private final Context c;
    private final List d;
    private final HashMap e;
    private final HashMap f;
    private final ae g;

    public aa(Context context, List list, HashMap hashmap, HashMap hashmap1, ae ae)
    {
        c = context;
        d = list;
        e = hashmap;
        f = hashmap1;
        g = ae;
    }

    public final int a()
    {
        return d.size();
    }

    public final int a(int k)
    {
        return 0;
    }

    public final bi a(ViewGroup viewgroup, int k)
    {
        viewgroup = new af(c);
        viewgroup.a();
        return new com.wishabi.flipp.widget.ab(viewgroup, g);
    }

    public final void a(bi bi, int k)
    {
label0:
        {
            com.wishabi.flipp.widget.ab ab1 = (com.wishabi.flipp.widget.ab)bi;
            c c1 = d(k);
            if (c1 != null)
            {
                ArrayList arraylist;
                b b1;
                Context context;
                String s1;
                String s2;
                boolean flag;
                if (e != null)
                {
                    arraylist = (ArrayList)e.get(Integer.valueOf(c1.a));
                } else
                {
                    arraylist = null;
                }
                b1 = (b)f.get(Integer.valueOf(c1.a));
                context = c;
                ab1.k.setImage(c1.m);
                ab1.k.setBrandName(c1.g);
                ab1.k.setBrandImage(c1.h);
                if (c1.b != null && c1.b.equals(Integer.valueOf(3563)))
                {
                    ab1.k.setMerchant(null);
                } else
                {
                    ab1.k.setMerchant(c1.c);
                }
                bi = c1.a();
                ab1.k.a(bi[0], bi[1], bi[2]);
                bi = c1.i;
                ab1.k.setPromoText(bi);
                s1 = c1.k;
                bi = c1.l;
                s1 = q.e(s1);
                s2 = q.e(bi);
                bi = null;
                if (!TextUtils.isEmpty(s1))
                {
                    if (TextUtils.isEmpty(s2))
                    {
                        bi = (new FormattedString(new com.wishabi.flipp.content.FormattedString.Part[] {
                            new com.wishabi.flipp.content.FormattedString.Part((new StringBuilder()).append(context.getString(0x7f0e007b)).append(" ").append(s1).toString(), new com.wishabi.flipp.content.FormattedString.Format[] {
                                new com.wishabi.flipp.content.FormattedString.Format(ab.b)
                            })
                        })).a();
                    } else
                    {
                        bi = (new FormattedString(new com.wishabi.flipp.content.FormattedString.Part[] {
                            new com.wishabi.flipp.content.FormattedString.Part((new StringBuilder()).append(context.getString(0x7f0e007a)).append("\n").toString(), new com.wishabi.flipp.content.FormattedString.Format[] {
                                new com.wishabi.flipp.content.FormattedString.Format(ab.b)
                            }), new com.wishabi.flipp.content.FormattedString.Part((new StringBuilder()).append(s1).append(" ").append(context.getString(0x7f0e007c)).append(" ").append(s2).toString(), new com.wishabi.flipp.content.FormattedString.Format[] {
                                new com.wishabi.flipp.content.FormattedString.Format(ab.a)
                            })
                        })).a();
                    }
                }
                if (TextUtils.isEmpty(bi))
                {
                    ab1.k.setValidity(null);
                } else
                {
                    ab1.k.setValidity(bi);
                }
                ab1.k.setIsClipped(c1.q);
                ab1.k.setIsSent(c1.r);
                bi = ab1.k;
                if (!TextUtils.isEmpty(c1.n))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                bi.setHasBarcode(flag);
                ab1.k.setListener(ab1.m);
                if (arraylist == null || arraylist.isEmpty())
                {
                    ab1.k.a();
                } else
                {
                    ab1.k.b.setVisibility(0);
                    ab1.k.b();
                    int l = arraylist.size();
                    k = 0;
                    while (k < l) 
                    {
                        bi = ab1.k.c.getChildAt(k);
                        Integer integer;
                        o o1;
                        int i1;
                        int j1;
                        int k1;
                        if (bi == null)
                        {
                            bi = new ch(context);
                            bi.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
                            ab1.k.c.addView(bi);
                        } else
                        {
                            bi = (ch)bi;
                        }
                        o1 = (o)arraylist.get(k);
                        j1 = i.a(70);
                        k1 = (int)((double)j1 * 0.59999999999999998D);
                        i1 = i.a(60);
                        j1 = (int)j.a(((float)i1 / o1.d.width()) * o1.d.height(), j1, k1);
                        ((ch) (bi)).a.getLayoutParams().width = i1;
                        ((ch) (bi)).a.getLayoutParams().height = j1;
                        bi.setItemMatchupImage(o1.h);
                        integer = o1.m;
                        if (integer != null && ag.b(integer.intValue()))
                        {
                            bi.setItemMatchupLabel(context.getString(0x7f0e0085, new Object[] {
                                q.a()
                            }));
                            bi.setItemMatchupMerchant(null);
                        } else
                        {
                            String s;
                            if (o1.j != null && o1.l)
                            {
                                s = context.getString(0x7f0e0074, new Object[] {
                                    q.a(o1.j.floatValue())
                                });
                            } else
                            {
                                s = context.getString(0x7f0e0073);
                            }
                            bi.setItemMatchupLabel(s);
                            bi.setItemMatchupMerchant(o1.n);
                        }
                        bi.setOnClickListener(ab1.n);
                        bi = ab1.k.c.getChildAt(k);
                        if (bi != null)
                        {
                            bi.setVisibility(0);
                        }
                        k++;
                    }
                }
                if (b1 != null)
                {
                    break label0;
                }
                ab1.k.setDisclaimer(null);
            }
            return;
        }
        ab1.k.setDisclaimer(b1.b);
    }

    public final long b(int k)
    {
        c c1 = d(k);
        if (c1 == null)
        {
            return -1L;
        } else
        {
            return (long)c1.a;
        }
    }

    public final c d(int k)
    {
        if (k >= d.size())
        {
            return null;
        } else
        {
            return (c)d.get(k);
        }
    }
}
