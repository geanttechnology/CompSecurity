// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class cxl
    implements bhv
{

    public boolean a;
    public String b;
    private final Handler c;
    private final SharedPreferences d;
    private final cxm e;
    private final cxn f;
    private final String g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private String l;
    private List m;
    private bhx n;

    public cxl(Handler handler, SharedPreferences sharedpreferences, cxm cxm1, cxn cxn1, String s)
    {
        c = (Handler)b.a(handler);
        d = (SharedPreferences)b.a(sharedpreferences);
        f = (cxn)b.a(cxn1);
        e = (cxm)b.a(cxm1);
        g = s;
    }

    private void c()
    {
        if (!j)
        {
            j = true;
            e.a();
        }
    }

    private void d()
    {
        if (j)
        {
            j = false;
            e.b();
        }
    }

    private void e()
    {
        Object obj = m;
        if (k != 3 && !TextUtils.isEmpty(g))
        {
            obj = new ArrayList(((java.util.Collection) (obj)));
            ((List) (obj)).add(0, cxu.a(g));
        }
        e.a(((List) (obj)));
    }

    private void f()
    {
        i = false;
        d();
        if (a)
        {
            e.c();
        }
    }

    public void a()
    {
label0:
        {
            if (!i)
            {
                if (m == null)
                {
                    break label0;
                }
                e();
            }
            return;
        }
        i = true;
        n = bhx.a(this);
        f.a(b, bhy.a(c, n));
    }

    public final void a(bxb bxb1)
    {
        Object obj = null;
        b.a(bxb1);
        b();
        b = bxb.a(bxb1.a);
        int i1;
        if (bxb1.a.f != null)
        {
            bxb1 = bxb1.a.f.a;
        } else
        {
            bxb1 = null;
        }
        if (TextUtils.isEmpty(b) || bxb1 == null) goto _L2; else goto _L1
_L1:
        k = ((dtq) (bxb1)).a;
        i1 = k;
        bxb1 = obj;
        i1;
        JVM INSTR tableswitch 0 3: default 104
    //                   0 133
    //                   1 146
    //                   2 175
    //                   3 175;
           goto _L3 _L4 _L5 _L6 _L6
_L5:
        break MISSING_BLOCK_LABEL_146;
_L3:
        throw new IllegalStateException(String.format("Captions visibility %d is not supported.", new Object[] {
            Integer.valueOf(i1)
        }));
_L4:
        bxb1 = d.getString("subtitles_language_code", null);
_L8:
        l = bxb1;
        c();
        if (!TextUtils.isEmpty(l))
        {
            h = true;
            a();
        }
_L2:
        return;
_L6:
        String s = d.getString("subtitles_language_code", null);
        bxb1 = s;
        if (TextUtils.isEmpty(s))
        {
            bxb1 = Locale.getDefault().getLanguage();
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void a(Object obj, Exception exception)
    {
        bmo.a("error retrieving subtitle tracks", exception);
        f();
    }

    public final void a(Object obj, Object obj1)
    {
        Object obj2 = null;
        obj = (List)obj1;
        i = false;
        if (((List) (obj)).isEmpty())
        {
            bmo.c("SubtitleTrack response was empty");
            f();
        } else
        {
            if (k != 3 || ((List) (obj)).size() > 1)
            {
                c();
            }
            m = ((List) (obj));
            if (h)
            {
                h = false;
                Iterator iterator = m.iterator();
                obj = null;
                obj1 = obj2;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    cxu cxu1 = (cxu)iterator.next();
                    if (cxu1.a.equals(l))
                    {
                        obj = cxu1;
                    } else
                    if (obj1 == null && "en".equals(cxu1.a))
                    {
                        obj1 = cxu1;
                    }
                } while (true);
                obj1 = obj;
                if (obj == null)
                {
                    obj1 = obj;
                    if (k == 3)
                    {
                        obj1 = (cxu)m.get(0);
                    }
                }
                if (obj1 != null)
                {
                    e.a(((cxu) (obj1)));
                }
            }
            if (a)
            {
                a = false;
                e();
                return;
            }
        }
    }

    public final void b()
    {
        b = null;
        k = 0;
        m = null;
        a = false;
        h = false;
        i = false;
        d();
        if (n != null)
        {
            n.a = true;
            n = null;
        }
    }
}
