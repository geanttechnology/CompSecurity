// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.facebook.h;
import com.facebook.k;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.facebook.b:
//            u, t, h, a

public abstract class i
{
    protected abstract class a
    {

        final i a;

        public static Object a()
        {
            return i.a;
        }

        public abstract com.facebook.b.a a(Object obj);

        public abstract boolean b();

        public a()
        {
            a = i.this;
            super();
        }
    }


    protected static final Object a = new Object();
    public int b;
    private final Activity c;
    private final Fragment d = null;
    private List e;

    public i(Activity activity, int j)
    {
        u.a(activity, "activity");
        c = activity;
        b = j;
    }

    private com.facebook.b.a a(Object obj, Object obj1)
    {
        Iterator iterator;
        a a1;
        boolean flag;
        if (obj1 == a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (e == null)
        {
            e = a();
        }
        iterator = e.iterator();
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        a1 = (a)iterator.next();
        if (!flag && !t.a(a.a(), obj1) || !a1.b())
        {
            break MISSING_BLOCK_LABEL_35;
        }
        try
        {
            obj = a1.a(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            obj = b();
            h.a(((com.facebook.b.a) (obj)), ((h) (obj1)));
        }
_L4:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = b();
            h.a(((com.facebook.b.a) (obj1)), new h("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
        }
        return ((com.facebook.b.a) (obj1));
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public abstract List a();

    public final void a(Object obj)
    {
        obj = a(obj, a);
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (d == null) goto _L4; else goto _L3
_L3:
        d.startActivityForResult(((com.facebook.b.a) (obj)).b, ((com.facebook.b.a) (obj)).c);
        com.facebook.b.a.a(((com.facebook.b.a) (obj)));
_L6:
        return;
_L4:
        c.startActivityForResult(((com.facebook.b.a) (obj)).b, ((com.facebook.b.a) (obj)).c);
        com.facebook.b.a.a(((com.facebook.b.a) (obj)));
        return;
_L2:
        Log.e("FacebookDialog", "No code path should ever result in a null appCall");
        if (k.b())
        {
            throw new IllegalStateException("No code path should ever result in a null appCall");
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public abstract com.facebook.b.a b();

}
