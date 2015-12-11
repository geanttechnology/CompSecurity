// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.facebook.d;
import com.facebook.f;
import com.facebook.h;
import com.facebook.k;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            kc, kb, jp, jn, 
//            ji

public abstract class jq
{
    protected abstract class a
    {

        final jq a;

        public Object a()
        {
            return jq.a;
        }

        public abstract boolean a(Object obj);

        public abstract ji b(Object obj);

        protected a()
        {
            a = jq.this;
            super();
        }
    }


    protected static final Object a = new Object();
    private final Activity b;
    private final Fragment c = null;
    private List d;
    private int e;

    protected jq(Activity activity, int i)
    {
        kc.a(activity, "activity");
        b = activity;
        e = i;
    }

    private ji b(Object obj, Object obj1)
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
        iterator = e().iterator();
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        a1 = (a)iterator.next();
        if (!flag && !kb.a(a1.a(), obj1) || !a1.a(obj))
        {
            break MISSING_BLOCK_LABEL_20;
        }
        try
        {
            obj = a1.b(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            obj = d();
            jp.a(((ji) (obj)), ((h) (obj1)));
        }
_L4:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = d();
            jp.a(((ji) (obj1)));
        }
        return ((ji) (obj1));
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private List e()
    {
        if (d == null)
        {
            d = c();
        }
        return d;
    }

    public int a()
    {
        return e;
    }

    protected abstract void a(jn jn1, f f);

    public final void a(d d1, f f)
    {
        if (!(d1 instanceof jn))
        {
            throw new h("Unexpected CallbackManager, please use the provided Factory.");
        } else
        {
            a((jn)d1, f);
            return;
        }
    }

    public void a(Object obj)
    {
        a(obj, a);
    }

    protected void a(Object obj, Object obj1)
    {
        obj = b(obj, obj1);
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (c == null) goto _L4; else goto _L3
_L3:
        jp.a(((ji) (obj)), c);
_L6:
        return;
_L4:
        jp.a(((ji) (obj)), b);
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

    protected Activity b()
    {
        if (b != null)
        {
            return b;
        }
        if (c != null)
        {
            return c.j();
        } else
        {
            return null;
        }
    }

    protected abstract List c();

    protected abstract ji d();

}
