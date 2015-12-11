// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class bcn
{

    final View a;
    public boolean b;
    bcu c;
    private final bcs d;
    private Handler e;
    private boolean f;
    private bcq g;

    public bcn(View view, bcs bcs1)
    {
        this(view, bcs1, new bcq(), new bcu());
    }

    private bcn(View view, bcs bcs1, bcq bcq1, bcu bcu1)
    {
        a = view;
        d = bcs1;
        g = bcq1;
        c = bcu1;
        e = new Handler(view.getContext().getMainLooper(), new bcr(this));
        a.addOnLayoutChangeListener(new bco(this));
    }

    private double c()
    {
        View view1 = a;
_L6:
        if (view1.getVisibility() == 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        if (i != 0)
        {
            Rect rect = new Rect();
            if (a.getLocalVisibleRect(rect))
            {
                i = rect.height();
                return (double)(rect.width() * i) / (double)(a.getHeight() * a.getWidth());
            }
        }
        break MISSING_BLOCK_LABEL_101;
_L2:
        View view;
        if (view1.getParent() instanceof View)
        {
            view = (View)view1.getParent();
        } else
        {
            view = null;
        }
        view1 = view;
        if (view != null)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 1;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
        return 0.0D;
    }

    public final String a()
    {
        Object obj = c;
        Object obj1 = new LinkedHashMap();
        ((Map) (obj1)).put("sdk", "a");
        ((Map) (obj1)).put("a", bcu.b.format(((bcu) (obj)).n));
        ((Map) (obj1)).put("c", bcu.a.format(((bcu) (obj)).d));
        ((Map) (obj1)).put("tos", TextUtils.join(",", ((bcu) (obj)).g));
        ((Map) (obj1)).put("ctos", TextUtils.join(",", ((bcu) (obj)).h));
        ((Map) (obj1)).put("mtos", TextUtils.join(",", ((bcu) (obj)).i));
        ((Map) (obj1)).put("pt", TextUtils.join(",", ((bcu) (obj)).j));
        if (((bcu) (obj)).k != null)
        {
            ((Map) (obj1)).put("p", String.format("%d,%d,%d,%d", new Object[] {
                Integer.valueOf(((bcu) (obj)).k.top), Integer.valueOf(((bcu) (obj)).k.left), Integer.valueOf(((bcu) (obj)).k.bottom), Integer.valueOf(((bcu) (obj)).k.right)
            }));
            ((Map) (obj1)).put("ps", String.format("%d,%d", new Object[] {
                Integer.valueOf(((bcu) (obj)).m), Integer.valueOf(((bcu) (obj)).l)
            }));
        }
        obj = new ArrayList();
        java.util.Map.Entry entry;
        for (obj1 = ((Map) (obj1)).entrySet().iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(String.format("%s=%s", new Object[] {
    entry.getKey(), entry.getValue()
})))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
        }

        return TextUtils.join("&", ((Iterable) (obj)));
    }

    public final void a(bct bct1)
    {
        switch (bcp.a[bct1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            c.c = g.a();
            c.a(c(), bct.a);
            a(false);
            return;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            c.a(c(), bct1);
            a(false);
            return;

        case 5: // '\005'
            c.a(c(), bct.e);
            a(true);
            return;

        case 6: // '\006'
            a(true);
            c.e = true;
            return;

        case 7: // '\007'
            a(false);
            c.e = false;
            return;

        case 8: // '\b'
            a(true);
            c.f = true;
            return;

        case 9: // '\t'
        case 10: // '\n'
            a(false);
            break;
        }
    }

    final void a(boolean flag)
    {
        b();
        if (!b) goto _L2; else goto _L1
_L1:
        return;
_L2:
        double d1;
        Object obj;
        int i;
        long l;
        obj = c;
        AudioManager audiomanager = (AudioManager)a.getContext().getSystemService("audio");
        i = audiomanager.getStreamMaxVolume(3);
        if (i <= 0)
        {
            d1 = 0.0D;
        } else
        {
            d1 = (double)audiomanager.getStreamVolume(3) / (double)i;
        }
        obj.n = d1;
        obj = c;
        l = g.a();
        d1 = c();
        if (((bcu) (obj)).c > 0L && !((bcu) (obj)).f) goto _L4; else goto _L3
_L3:
        obj = c;
        i = bcv.c.ordinal();
        bcv bcv1;
        Long along[];
        long l1;
        if (Math.max(((bcu) (obj)).h[i].longValue(), ((bcu) (obj)).i[i].longValue()) >= 2000L)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0 && !f)
        {
            obj = d;
            a();
            ((bcs) (obj)).a();
            f = true;
        }
        if (!flag)
        {
            e.sendEmptyMessageDelayed(0, 250L);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        l1 = l - ((bcu) (obj)).c;
        if (l1 > 0L)
        {
            if (!((bcu) (obj)).e)
            {
                bcv1 = bcu.a(d1);
                if (bcv1 != null)
                {
                    i = bcv1.ordinal();
                    along = ((bcu) (obj)).g;
                    along[i] = Long.valueOf(along[i].longValue() + l1);
                    do
                    {
                        along = ((bcu) (obj)).h;
                        if (i >= 5)
                        {
                            break;
                        }
                        along = ((bcu) (obj)).h;
                        along[i] = Long.valueOf(along[i].longValue() + l1);
                        if (((bcu) (obj)).h[i].longValue() > ((bcu) (obj)).i[i].longValue())
                        {
                            ((bcu) (obj)).i[i] = ((bcu) (obj)).h[i];
                        }
                        i++;
                    } while (true);
                }
                i = 0;
                do
                {
                    along = ((bcu) (obj)).h;
                    if (i >= 5)
                    {
                        break;
                    }
                    if (bcv1 == null || i < bcv1.ordinal() || flag)
                    {
                        ((bcu) (obj)).h[i] = Long.valueOf(0L);
                    }
                    i++;
                } while (true);
            }
            obj.c = l;
            obj.d = d1;
        }
          goto _L3
    }

    public void b()
    {
        e.removeMessages(0);
    }
}
