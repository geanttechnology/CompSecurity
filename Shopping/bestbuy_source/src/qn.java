// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.g;
import com.google.android.gms.internal.jg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class qn
{

    private String a;
    private final Set b = new HashSet();
    private int c;
    private View d;
    private String e;
    private final Context f;
    private final Map g = new HashMap();
    private FragmentActivity h;
    private int i;
    private qp j;
    private Looper k;
    private final Set l = new HashSet();
    private final Set m = new HashSet();

    public qn(Context context)
    {
        i = -1;
        f = context;
        k = context.getMainLooper();
        e = context.getPackageName();
    }

    private qm c()
    {
        g g1 = com.google.android.gms.common.api.g.a(h);
        qm qm = g1.a(i);
        Object obj = qm;
        if (qm == null)
        {
            obj = new qw(f.getApplicationContext(), k, a(), g, l, m, i);
        }
        g1.a(i, ((qm) (obj)), j);
        return ((qm) (obj));
    }

    public jg a()
    {
        return new jg(a, b, c, d, e);
    }

    public qn a(px px1)
    {
        g.put(px1, null);
        px1 = px1.b();
        int j1 = px1.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            b.add(((Scope)px1.get(i1)).a());
        }

        return this;
    }

    public qn a(qo qo)
    {
        l.add(qo);
        return this;
    }

    public qn a(qp qp)
    {
        m.add(qp);
        return this;
    }

    public qm b()
    {
        boolean flag;
        if (!g.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ady.b(flag, "must call addApi() to add at least one API");
        if (i >= 0)
        {
            return c();
        } else
        {
            return new qw(f, k, a(), g, l, m, -1);
        }
    }
}
