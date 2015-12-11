// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ail extends ii
{

    final Map i = new ConcurrentHashMap();
    final chq j;
    public final amq k;
    boolean l;
    int m;
    private ami n;
    private amd o;
    private boolean p;
    private aio q;
    private ain r;

    public ail(Context context, bje bje1, bje bje2, ami ami1, amd amd1, amq amq1, chq chq)
    {
        super(context);
        n = (ami)b.a(ami1);
        o = (amd)b.a(amd1);
        k = (amq)b.a(amq1);
        j = chq;
        p = false;
        l = false;
        q = new aio(this);
        bje1.a(q);
        r = new ain(this);
        bje2.a(r);
    }

    static void a(ail ail1)
    {
        ail1.c();
    }

    private void c()
    {
        if (p && !l)
        {
            n.b(a());
            return;
        } else
        {
            n.a(a());
            return;
        }
    }

    protected abstract Bundle a(ame ame1);

    protected abstract String a();

    protected final void b()
    {
        i.clear();
        io io1 = new io();
        ame ame1;
        Object obj;
        for (Iterator iterator = n.a().iterator(); iterator.hasNext(); i.put(((if) (obj)).a(), ame1))
        {
            ame1 = (ame)iterator.next();
            obj = new IntentFilter();
            ((IntentFilter) (obj)).addCategory(a());
            obj = (new ig(String.valueOf(ame1.a().hashCode()), ame1.b())).a(((IntentFilter) (obj))).a(1).e(1).a(true).d(100);
            if (!TextUtils.isEmpty(""))
            {
                ((ig) (obj)).a("");
            }
            Bundle bundle = a(ame1);
            ((ig) (obj)).a.putBundle("extras", bundle);
            if (o.a(ame1))
            {
                ((ig) (obj)).c(m);
            }
            obj = ((ig) (obj)).a();
            io1.a(((if) (obj)));
        }

        a(io1.a());
    }

    public final void b(ih ih1)
    {
        Object obj = j;
        obj = String.valueOf(ih1);
        (new StringBuilder(String.valueOf(obj).length() + 26)).append("discoveryRequestChanged : ").append(((String) (obj)));
        obj = a();
        if (ih1 != null)
        {
            ih1 = ih1.a();
            if (ih1 != null && ih1.a().contains(obj))
            {
                p = true;
                c();
                b();
                return;
            }
        }
        p = false;
        c();
    }
}
