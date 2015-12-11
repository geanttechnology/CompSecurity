// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.RectF;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.o;
import com.wishabi.flipp.b.p;
import com.wishabi.flipp.content.FormattedString;
import com.wishabi.flipp.content.ab;
import com.wishabi.flipp.content.ag;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.util.q;
import com.wishabi.flipp.widget.FlyerViewGroup;
import com.wishabi.flipp.widget.bi;
import com.wishabi.flipp.widget.bt;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.wishabi.flipp.app:
//            bo, bu, bt, bs, 
//            FlippApplication, fq, fp

final class br
    implements bt
{

    final Activity a;
    final bo b;

    br(bo bo1, Activity activity)
    {
        b = bo1;
        a = activity;
        super();
    }

    public final void a()
    {
        a.a.a(bo.f(b));
    }

    public final void a(FlyerViewGroup flyerviewgroup)
    {
        if (bo.c(b) != null)
        {
            bu bu1 = bo.c(b);
            bo.d(b);
            bu1.a();
        }
        if (bo.e(b))
        {
            a.a.a(bo.f(b), flyerviewgroup.getVisibleRect(), flyerviewgroup.getZoomScale());
        }
    }

    public final void a(FlyerViewGroup flyerviewgroup, int j, int k)
    {
        float f1 = flyerviewgroup.getZoomScale();
        float f = flyerviewgroup.getMinZoomScale();
        if (f1 > f)
        {
            float f2 = j;
            float f3 = ((float)flyerviewgroup.getWidth() * 0.5F) / f;
            float f4 = k;
            float f5 = ((float)flyerviewgroup.getHeight() * 0.5F) / f;
            float f6 = j;
            float f7 = ((float)flyerviewgroup.getWidth() * 0.5F) / f;
            float f8 = k;
            flyerviewgroup.a(new RectF(f2 - f3, f4 - f5, f6 + f7, ((float)flyerviewgroup.getHeight() * 0.5F) / f + f8), true, true);
        } else
        {
            flyerviewgroup.a(new RectF(j - 250, k - 250, j + 250, k + 250), true, true);
        }
        a.a.a(bo.f(b));
    }

    public final void a(FlyerViewGroup flyerviewgroup, long l)
    {
        flyerviewgroup.playSoundEffect(0);
        flyerviewgroup.sendAccessibilityEvent(1);
        com.wishabi.flipp.app.bo.a(b, l);
    }

    public final void a(FlyerViewGroup flyerviewgroup, bi bi1)
    {
        Activity activity;
        android.app.FragmentManager fragmentmanager;
        activity = b.getActivity();
        fragmentmanager = b.getFragmentManager();
        if (activity != null && bi1 != null && fragmentmanager != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        flyerviewgroup.performHapticFeedback(0);
        com.wishabi.flipp.app.bt bt1 = (com.wishabi.flipp.app.bt)bi1.c;
        ag ag1 = ag.a(bt1.o);
        flyerviewgroup = ag1;
        if (ag1 == null)
        {
            flyerviewgroup = ag.a;
        }
        switch (com.wishabi.flipp.app.bs.a[flyerviewgroup.ordinal()])
        {
        default:
            if (!ag.b(((ag) (flyerviewgroup)).w) || !com.wishabi.flipp.app.bo.a(b, bt1.a))
            {
                com.wishabi.flipp.app.bo.a(b, bi1);
                a.a.a(bo.f(b), bt1.a, o.a);
                return;
            }
            break;

        case 1: // '\001'
            com.wishabi.flipp.app.bo.a(b, bt1);
            return;

        case 2: // '\002'
            bo.b(b, bt1);
            return;

        case 3: // '\003'
            bo.c(b, bt1);
            return;

        case 4: // '\004'
            bo.d(b, bt1);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void b(FlyerViewGroup flyerviewgroup, bi bi1)
    {
        if (bi1 != null) goto _L2; else goto _L1
_L1:
        if (bo.g(b))
        {
            com.wishabi.flipp.app.bo.a(b, a.getString(0x7f0e00d9));
            a.a.a(bo.f(b), "loading");
        } else
        if (!bo.h(b))
        {
            com.wishabi.flipp.app.bo.a(b, a.getString(0x7f0e00f7));
            a.a.a(bo.f(b), "no items");
        } else
        {
            com.wishabi.flipp.app.bo.a(b, a.getString(0x7f0e000b));
            a.a.a(bo.f(b), "no box");
        }
        if (bo.c(b) != null)
        {
            bo.c(b).a(false, null, -1);
        }
_L4:
        return;
_L2:
        com.wishabi.flipp.app.bt bt1;
        flyerviewgroup.playSoundEffect(0);
        flyerviewgroup.sendAccessibilityEvent(1);
        bt1 = (com.wishabi.flipp.app.bt)bi1.c;
        if (bt1.o != ag.c.w)
        {
            break; /* Loop/switch isn't completed */
        }
        com.wishabi.flipp.app.bo.a(b, bt1);
        if (bo.c(b) != null)
        {
            bo.c(b).a(false, null, -1);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (bt1.o != ag.d.w)
        {
            break; /* Loop/switch isn't completed */
        }
        bo.b(b, bt1);
        if (bo.c(b) != null)
        {
            bo.c(b).a(false, null, -1);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (bt1.o != ag.l.w)
        {
            break; /* Loop/switch isn't completed */
        }
        bo.c(b, bt1);
        if (bo.c(b) != null)
        {
            bo.c(b).a(false, null, -1);
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (bt1.o != ag.e.w)
        {
            break; /* Loop/switch isn't completed */
        }
        bo.d(b, bt1);
        if (bo.c(b) != null)
        {
            bo.c(b).a(false, null, -1);
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
        if (com.wishabi.flipp.app.bo.i(b) != null)
        {
            flyerviewgroup = (ArrayList)com.wishabi.flipp.app.bo.i(b).get(Long.valueOf(bt1.a));
        } else
        {
            flyerviewgroup = null;
        }
        bi1 = a.getContentResolver().query(i.g, null, "_id = ?", new String[] {
            Long.toString(bt1.a)
        }, null);
        if (bi1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!bi1.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        a.getContentResolver().delete(i.g, "_id = ?", new String[] {
            Long.toString(bt1.a)
        });
        if (!ag.b(bt1.o) || flyerviewgroup == null)
        {
            break MISSING_BLOCK_LABEL_502;
        }
        com.wishabi.flipp.content.a.a(flyerviewgroup, false, p.a, true);
        if (bo.c(b) != null)
        {
            bo.c(b).a(false, null, -1);
        }
        if (bi1 != null)
        {
            bi1.close();
            return;
        }
        if (true) goto _L4; else goto _L8
_L8:
        if (bi1 != null)
        {
            bi1.close();
        }
        if (!ag.b(bt1.o)) goto _L10; else goto _L9
_L9:
        if (!bo.b(b, bt1.a)) goto _L12; else goto _L11
_L11:
        com.wishabi.flipp.content.a.a(flyerviewgroup, false, p.a, true);
        if (bo.c(b) == null) goto _L4; else goto _L13
_L13:
        bo.c(b).a(false, null, -1);
        return;
        flyerviewgroup;
        bi1 = null;
_L15:
        if (bi1 != null)
        {
            bi1.close();
        }
        throw flyerviewgroup;
_L12:
        if (flyerviewgroup == null || flyerviewgroup.isEmpty()) goto _L10; else goto _L14
_L14:
        com.wishabi.flipp.content.a.a(flyerviewgroup, true, p.a, true);
        if (bo.c(b) != null)
        {
            bi1 = bt1.k;
            flyerviewgroup = bi1;
            if (bi1 != null)
            {
                flyerviewgroup = bi1;
                if (bi1.equalsIgnoreCase("null"))
                {
                    flyerviewgroup = null;
                }
            }
            bo.c(b).a(true, flyerviewgroup, bt1.o);
            return;
        }
          goto _L4
_L10:
        bi1 = new ContentValues();
        bi1.put("_id", Long.valueOf(bt1.a));
        bi1.put("flyer_id", Integer.valueOf(bt1.b));
        bi1.put("bottom", Float.valueOf(bt1.c));
        bi1.put("top", Float.valueOf(bt1.d));
        bi1.put("left", Float.valueOf(bt1.e));
        bi1.put("right", Float.valueOf(bt1.f));
        bi1.put("merchant", bt1.g);
        bi1.put("merchant_logo", bt1.h);
        bi1.put("name", bt1.j);
        bi1.put("premium", Boolean.valueOf(bt1.i));
        bi1.put("price", bt1.l);
        bi1.put("thumbnail", bt1.m);
        bi1.put("valid_to", bt1.n);
        a.getContentResolver().insert(i.g, bi1);
        double d;
        if (flyerviewgroup != null && !flyerviewgroup.isEmpty())
        {
            com.wishabi.flipp.content.a.a(flyerviewgroup, true, p.a, true);
            if (b.isResumed())
            {
                flyerviewgroup = b.getFragmentManager();
                bi1 = FlippApplication.b();
                int j;
                if (bi1 == null)
                {
                    j = fq.c;
                } else
                {
                    com.wishabi.flipp.app.fp.a(flyerviewgroup, null, "tutorial_showed_after_clipping", new FormattedString(new com.wishabi.flipp.content.FormattedString.Part[] {
                        new com.wishabi.flipp.content.FormattedString.Part(bi1.getString(0x7f0e0144), new com.wishabi.flipp.content.FormattedString.Format[] {
                            new com.wishabi.flipp.content.FormattedString.Format(ab.a)
                        }), new com.wishabi.flipp.content.FormattedString.Part(bi1.getString(0x7f0e0145), new com.wishabi.flipp.content.FormattedString.Format[] {
                            new com.wishabi.flipp.content.FormattedString.Format(ab.b)
                        })
                    }), 0x7f0200f3, 0x7f0200f1, null);
                }
            }
        }
        if (bo.c(b) != null)
        {
            bi1 = bt1.k;
            flyerviewgroup = bi1;
            if (bi1 != null)
            {
                flyerviewgroup = bi1;
                if (bi1.equalsIgnoreCase("null"))
                {
                    flyerviewgroup = null;
                }
            }
            bo.c(b).a(true, flyerviewgroup, bt1.o);
        }
        com.wishabi.flipp.app.bo.a(b, a.getString(0x7f0e00ca));
        if (bt1.l != null && q.c(bt1.l))
        {
            d = Double.parseDouble(bt1.l);
        } else
        {
            d = 0.0D;
        }
        a.a.a(bo.f(b));
        a.a.a(bo.f(b), bt1.a, o.e, d);
        return;
        flyerviewgroup;
          goto _L15
    }
}
