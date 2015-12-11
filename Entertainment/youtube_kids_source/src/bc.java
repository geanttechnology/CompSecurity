// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Notification;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

class bc extends aw
{

    bc()
    {
    }

    public Notification a(au au1)
    {
        Object obj = new bk(au1.a, au1.i, null, null, null, null, 0, au1.b, null, null, 0, 0, false, false, 0, null, false, null, null, false, null);
        aq.a(((ao) (obj)), au1.e);
        aq.a(((ap) (obj)), null);
        au1 = ((bk) (obj)).a.build();
        Bundle bundle = bj.a(au1);
        Bundle bundle1 = new Bundle(((bk) (obj)).b);
        Iterator iterator = ((bk) (obj)).b.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (bundle.containsKey(s))
            {
                bundle1.remove(s);
            }
        } while (true);
        bundle.putAll(bundle1);
        obj = bj.a(((bk) (obj)).c);
        if (obj != null)
        {
            bj.a(au1).putSparseParcelableArray("android.support.actionExtras", ((android.util.SparseArray) (obj)));
        }
        return au1;
    }
}
