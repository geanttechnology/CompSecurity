// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            mu, ox, mt

public class mv
    implements mu
{

    private final mt a;
    private final HashSet b = new HashSet();

    public mv(mt mt1)
    {
        a = mt1;
    }

    public void a()
    {
        java.util.AbstractMap.SimpleEntry simpleentry;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); a.b((String)simpleentry.getKey(), (ox)simpleentry.getValue()))
        {
            simpleentry = (java.util.AbstractMap.SimpleEntry)iterator.next();
            zzb.v((new StringBuilder()).append("Unregistering eventhandler: ").append(((ox)simpleentry.getValue()).toString()).toString());
        }

        b.clear();
    }

    public void a(String s, ox ox1)
    {
        a.a(s, ox1);
        b.add(new java.util.AbstractMap.SimpleEntry(s, ox1));
    }

    public void a(String s, String s1)
    {
        a.a(s, s1);
    }

    public void a(String s, JSONObject jsonobject)
    {
        a.a(s, jsonobject);
    }

    public void b(String s, ox ox1)
    {
        a.b(s, ox1);
        b.remove(new java.util.AbstractMap.SimpleEntry(s, ox1));
    }

    public void b(String s, JSONObject jsonobject)
    {
        a.b(s, jsonobject);
    }
}
