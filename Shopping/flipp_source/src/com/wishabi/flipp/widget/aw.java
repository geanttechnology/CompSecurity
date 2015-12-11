// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.database.Cursor;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import b.a.a.b;
import b.a.a.f;
import com.wishabi.flipp.app.dn;
import com.wishabi.flipp.content.c;
import com.wishabi.flipp.content.n;
import com.wishabi.flipp.content.o;
import com.wishabi.flipp.util.g;
import com.wishabi.flipp.util.i;
import com.wishabi.flipp.util.j;
import com.wishabi.flipp.util.q;
import java.util.ArrayList;

// Referenced classes of package com.wishabi.flipp.widget:
//            a, b, c, d, 
//            e, CouponCell, v, w, 
//            x, y, ItemCellSmall, cd, 
//            z, ce, cf

public class aw
{

    public static final String a = com/wishabi/flipp/widget/aw.getSimpleName();

    public aw()
    {
    }

    public static void a(Context context, a a1, b b1, String s, String s1, String s2, String s3, int k, 
            int l, ArrayList arraylist, dn dn)
    {
        boolean flag1;
        b b2 = b.a(g.a);
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        long l1 = f.a(b1);
        boolean flag;
        if (b2.a() > l1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        flag1 = true;
_L1:
        a1.setExpired(flag1);
        a1.setSelectionState$448952c2(l);
        a1.setImageUrl(s);
        a1.setContentDescription(s1);
        if (dn == null)
        {
            a1.a.setOnClickListener(null);
            a1.a.setClickable(false);
            a1.a.setOnLongClickListener(null);
            a1.a.setLongClickable(false);
            a1.b.setOnClickListener(null);
            a1.b.setClickable(false);
            a1.b.setOnLongClickListener(null);
            a1.b.setLongClickable(false);
        } else
        {
            a1.a.setOnClickListener(new com.wishabi.flipp.widget.b(a1, k));
            a1.a.setOnLongClickListener(new com.wishabi.flipp.widget.c(a1, k));
            a1.b.setOnClickListener(new d(a1, k));
            a1.b.setOnLongClickListener(new e(a1, k));
        }
        a1.h = dn;
        if (TextUtils.isEmpty(s2) || s2.equals("/images/bg/logo_bg.gif"))
        {
            a1.setMerchantFallback(s3);
        } else
        {
            a1.setMerchantLogoUrl(s2);
        }
        if (arraylist == null || !a(arraylist))
        {
            a1.setShowCouponMatchup(false);
            a1.refreshDrawableState();
            return;
        }
        break MISSING_BLOCK_LABEL_277;
        flag1 = false;
          goto _L1
        a1.setShowCouponMatchup(true);
        a1.setCouponMatchupHeight(i.a(55));
        if (arraylist.size() > 1)
        {
            a1.setCouponMatchupAvailable(context.getString(0x7f0e0033, new Object[] {
                Integer.valueOf(arraylist.size())
            }));
            a1.refreshDrawableState();
            return;
        }
        b1 = ((c)arraylist.get(0)).a();
        if (!TextUtils.isEmpty(b1[0]) || !TextUtils.isEmpty(b1[1]) || !TextUtils.isEmpty(b1[2])) goto _L3; else goto _L2
_L2:
        a1.setCouponMatchupAvailable(context.getString(0x7f0e0033, new Object[] {
            Integer.valueOf(1)
        }));
_L5:
        a1.refreshDrawableState();
        return;
_L3:
        s1 = b1[0];
        s = b1[1];
        b1 = b1[2];
        context = null;
        l = 0;
        k = 0;
        if (TextUtils.isEmpty(s1))
        {
            a1.d.setText(null);
            a1.d.setVisibility(8);
        } else
        {
            a1.d.setText(s1);
            a1.d.setVisibility(0);
            a1.d.setSingleLine();
            context = a1.d;
            l = 1;
            k = 1;
        }
        if (TextUtils.isEmpty(s))
        {
            a1.e.setText(null);
            a1.e.setVisibility(8);
        } else
        {
            a1.e.setText(s);
            a1.e.setVisibility(0);
            a1.e.setSingleLine();
            context = a1.e;
            l++;
            k = 1;
        }
        if (TextUtils.isEmpty(b1))
        {
            a1.f.setText(null);
            a1.f.setVisibility(8);
        } else
        {
            a1.f.setText(b1);
            a1.f.setVisibility(0);
            a1.f.setSingleLine();
            context = a1.f;
            l++;
            k = 1;
        }
        if (k != 0)
        {
            a1.c.setVisibility(0);
            a1.g.setVisibility(8);
            if (l == 1)
            {
                context.setSingleLine(false);
                context.setMaxLines(2);
            }
        } else
        {
            a1.c.setVisibility(8);
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void a(Context context, String s, CouponCell couponcell, int k, Cursor cursor, boolean flag, boolean flag1, int l, 
            int i1, ArrayList arraylist, dn dn)
    {
        a(context, s, couponcell, k, new c(cursor), flag, flag1, l, true, i1, arraylist, dn);
    }

    public static void a(Context context, String s, CouponCell couponcell, int k, c c1, boolean flag, boolean flag1, int l, 
            boolean flag2, int i1, ArrayList arraylist, dn dn)
    {
        boolean flag3;
        if (flag && c1.q)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        couponcell.setIsClipped(flag);
        if (flag1 && !c1.a(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        couponcell.setIsUnavailable(flag);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        if (c1.p && c1.a(s))
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (!flag3)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        flag = true;
_L1:
        couponcell.setIsExpired(flag);
        if (flag1 && c1.r)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        couponcell.setIsSent(flag);
        couponcell.setSelectionState$5470411a(l);
        couponcell.setCouponImage(c1.m);
        if (dn == null)
        {
            couponcell.c.setOnClickListener(null);
            couponcell.c.setClickable(false);
            couponcell.c.setOnLongClickListener(null);
            couponcell.c.setLongClickable(false);
            couponcell.b.setOnClickListener(null);
            couponcell.b.setClickable(false);
            couponcell.b.setOnLongClickListener(null);
            couponcell.b.setLongClickable(false);
        } else
        {
            couponcell.c.setOnClickListener(new v(couponcell, k));
            couponcell.c.setOnLongClickListener(new w(couponcell, k));
            couponcell.b.setOnClickListener(new x(couponcell, k));
            couponcell.b.setOnLongClickListener(new y(couponcell, k));
        }
        couponcell.e = dn;
        s = c1.a();
        couponcell.a(s[0], s[1], s[2]);
        couponcell.setCouponPromoText(c1.i);
        if (TextUtils.isEmpty(c1.d))
        {
            couponcell.setMerchantFallback(c1.c);
        } else
        {
            couponcell.setMerchantLogoUrl(c1.d);
        }
        if (arraylist == null || arraylist.isEmpty())
        {
            couponcell.a(false, flag2);
            couponcell.setContainerHeight(i1);
            couponcell.refreshDrawableState();
            return;
        }
        break MISSING_BLOCK_LABEL_384;
        flag = false;
          goto _L1
        s = (o)arraylist.get(0);
        l = i.a(60);
        i1 = (int)((double)l * 0.59999999999999998D);
        k = i.a(50);
        l = (int)j.a(((float)k / ((o) (s)).d.width()) * ((o) (s)).d.height(), l, i1);
        couponcell.d.getLayoutParams().width = k;
        couponcell.d.getLayoutParams().height = l;
        couponcell.setContainerHeight(i.a(260));
        couponcell.a(true, flag2);
        couponcell.setItemMatchupHeight(i.a(50));
        couponcell.setItemMatchupImage(((o) (s)).h);
        couponcell.setItemMatchupMerchant(((o) (s)).n);
        if (((o) (s)).j != null && ((o) (s)).l)
        {
            context = context.getString(0x7f0e0074, new Object[] {
                q.a(((o) (s)).j.floatValue())
            });
        } else
        {
            context = context.getString(0x7f0e0073);
        }
        couponcell.setItemMatchupLabel(context);
        couponcell.refreshDrawableState();
        return;
    }

    public static void a(Context context, String s, cd cd1, int k, c c1, int l, ArrayList arraylist, dn dn)
    {
        a(context, s, cd1.getCouponCell(), k, c1, true, true, z.a, false, l, null, null);
        if (arraylist != null && !arraylist.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!(s = (o)arraylist.get(0)).b()) goto _L1; else goto _L3
_L3:
        if (dn == null)
        {
            cd1.b.setOnClickListener(null);
            cd1.b.setClickable(false);
            cd1.a.setOnClickListener(null);
            cd1.a.setClickable(false);
        } else
        {
            cd1.b.setOnClickListener(new ce(cd1, k));
            cd1.a.setOnClickListener(new cf(cd1, k));
        }
        cd1.d = dn;
        k = i.a(50);
        l = i.a(60);
        cd1.c.getLayoutParams().width = k;
        cd1.c.getLayoutParams().height = l;
        cd1.setItemMatchupImage(((o) (s)).h);
        cd1.setItemMatchupLabel(context.getString(0x7f0e0073));
        cd1.setItemMatchupMerchant(((o) (s)).n);
        if (((o) (s)).p != n.a) goto _L5; else goto _L4
_L4:
        cd1.setItemOriginalPrice(q.a(((o) (s)).f.floatValue()));
        cd1.setItemDiscountPrice((new StringBuilder("-")).append(q.a(((o) (s)).g.floatValue())).toString());
_L7:
        cd1.setItemCouponPrice((new StringBuilder("-")).append(q.a(((o) (s)).i.floatValue())).toString());
        cd1.setItemFinalPrice(q.a(((o) (s)).j.floatValue()));
        cd1.setBadgeText((new StringBuilder()).append((int)(((o) (s)).k.floatValue() * 100F)).append("% ").append(context.getString(0x7f0e011b)).toString());
        return;
_L5:
        if (((o) (s)).p == n.b)
        {
            cd1.setItemCurrentPrice(q.a(((o) (s)).e.floatValue()));
            cd1.setItemDiscountPrice(null);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static boolean a(ArrayList arraylist)
    {
        if (arraylist == null || arraylist.isEmpty())
        {
            return false;
        }
        if (arraylist.size() == 1)
        {
            arraylist = (c)arraylist.get(0);
            if (arraylist == null)
            {
                return false;
            }
            if (arraylist.a() == null)
            {
                return false;
            }
        }
        return true;
    }

}
