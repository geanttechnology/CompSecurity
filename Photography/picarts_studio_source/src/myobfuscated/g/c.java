// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.g;

import bo.app.bx;
import bo.app.ct;
import bo.app.ec;
import bo.app.ed;
import bo.app.eo;
import bo.app.ep;
import com.appboy.enums.CardCategory;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;
import myobfuscated.f.e;
import myobfuscated.i.a;
import org.json.JSONArray;
import org.json.JSONObject;

public class c extends Observable
    implements e
{

    private static final String a = String.format("%s.%s", new Object[] {
        "Appboy", myobfuscated/g/c.getName()
    });
    private JSONObject b;
    private final bx c;
    private final ec d;
    protected final String g;
    protected boolean h;
    public boolean i;
    protected final long j;
    protected final long k;
    public long l;
    public EnumSet m;

    public c(JSONObject jsonobject, bx bx1, ec ec1)
    {
        b = jsonobject;
        eo.a(jsonobject.optJSONObject("extras"), new HashMap());
        c = bx1;
        d = ec1;
        g = jsonobject.getString("id");
        h = jsonobject.getBoolean("viewed");
        i = h;
        j = jsonobject.getLong("created");
        k = jsonobject.getLong("updated");
        l = jsonobject.optLong("expires_at", -1L);
        jsonobject = jsonobject.optJSONArray("categories");
        if (jsonobject == null || jsonobject.length() == 0)
        {
            m = EnumSet.of(CardCategory.NO_CATEGORY);
        } else
        {
            m = EnumSet.noneOf(com/appboy/enums/CardCategory);
            int i1 = 0;
            while (i1 < jsonobject.length()) 
            {
                bx1 = CardCategory.get(jsonobject.getString(i1));
                if (bx1 != null)
                {
                    m.add(bx1);
                }
                i1++;
            }
        }
    }

    private boolean h()
    {
        if (ep.c(g))
        {
            myobfuscated.i.a.c(a, "Card ID cannot be null");
            return false;
        } else
        {
            return true;
        }
    }

    public final boolean a()
    {
        if (c == null || d == null || !h())
        {
            break MISSING_BLOCK_LABEL_62;
        }
        c.a(ct.c(g));
        d.a(g);
        return true;
        Exception exception;
        exception;
        myobfuscated.i.a.b(a, "Failed to log feed card impression.", exception);
        return false;
    }

    public final boolean a(EnumSet enumset)
    {
        for (enumset = enumset.iterator(); enumset.hasNext();)
        {
            CardCategory cardcategory = (CardCategory)enumset.next();
            if (m.contains(cardcategory))
            {
                return true;
            }
        }

        return false;
    }

    public final boolean a(c c1)
    {
        return g.equals(c1.g) && k == c1.k && c == c1.c;
    }

    public final boolean b()
    {
        if (c == null || !h())
        {
            break MISSING_BLOCK_LABEL_44;
        }
        c.a(ct.d(g));
        return true;
        Exception exception;
        exception;
        myobfuscated.i.a.b(a, "Failed to log feed card clicked.", exception);
        return false;
    }

    public final String c()
    {
        return g;
    }

    public final boolean d()
    {
        return h;
    }

    public final void e()
    {
        h = true;
    }

    public final void f()
    {
        i = true;
        setChanged();
        notifyObservers();
        try
        {
            ec ec1 = d;
            String s = g;
            if (!ec1.d.contains(s))
            {
                ec1.d.add(s);
                ec1.a(ec1.d, ed.a);
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public volatile Object forJsonPut()
    {
        return b;
    }

    public final long g()
    {
        return k;
    }

}
