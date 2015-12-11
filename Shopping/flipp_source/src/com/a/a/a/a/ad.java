// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.b.a;
import com.a.a.a.b.q;
import com.a.a.a.b.x;
import com.a.a.b;
import com.a.a.r;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.a.a.a.a:
//            ae, af, h, x, 
//            u, v, z, ab

public final class ad
    implements ae
{

    private final h a;
    private final q b;
    private x c;

    public ad(h h1, q q1)
    {
        a = h1;
        b = q1;
    }

    public final InputStream a(CacheRequest cacherequest)
    {
        return new af(c.e, cacherequest, a);
    }

    public final OutputStream a()
    {
        c();
        return c.d();
    }

    public final void a(ab ab)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean a(boolean flag, OutputStream outputstream, InputStream inputstream)
    {
label0:
        {
            if (flag)
            {
                if (c == null)
                {
                    break label0;
                }
                c.b(a.l);
            }
            return true;
        }
        return false;
    }

    public final void b()
    {
        c.d().close();
    }

    public final void c()
    {
        Object obj;
        Object obj2;
        Object obj3;
        String s;
        boolean flag;
        if (c != null)
        {
            return;
        }
        a.b();
        v v1 = a.i.a;
        Object obj1;
        int i;
        if (a.d.j == 1)
        {
            obj = "HTTP/1.1";
        } else
        {
            obj = "HTTP/1.0";
        }
        obj3 = a.a.getURL();
        obj1 = a.c;
        obj2 = com.a.a.a.a.h.a(((java.net.URL) (obj3)));
        obj3 = com.a.a.a.a.h.b(((java.net.URL) (obj3)));
        s = a.h.getScheme();
        v1.a(":method", ((String) (obj1)));
        v1.a(":scheme", s);
        v1.a(":path", ((String) (obj2)));
        v1.a(":version", ((String) (obj)));
        v1.a(":host", ((String) (obj3)));
        flag = a.c();
        obj = b;
        obj1 = new HashSet();
        obj2 = new ArrayList();
        i = 0;
        if (i >= v1.a.size())
        {
            break MISSING_BLOCK_LABEL_406;
        }
        obj3 = ((String)v1.a.get(i)).toLowerCase(Locale.US);
        s = (String)v1.a.get(i + 1);
        if (!((String) (obj3)).equals("connection") && !((String) (obj3)).equals("host") && !((String) (obj3)).equals("keep-alive") && !((String) (obj3)).equals("proxy-connection") && !((String) (obj3)).equals("transfer-encoding"))
        {
            if (!((Set) (obj1)).add(obj3))
            {
                break; /* Loop/switch isn't completed */
            }
            ((List) (obj2)).add(obj3);
            ((List) (obj2)).add(s);
        }
_L6:
        i += 2;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_163;
_L1:
        int j = 0;
_L4:
        if (j < ((List) (obj2)).size())
        {
label0:
            {
                if (!((String) (obj3)).equals(((List) (obj2)).get(j)))
                {
                    break label0;
                }
                ((List) (obj2)).set(j + 1, (new StringBuilder()).append((String)((List) (obj2)).get(j + 1)).append("\0").append(s).toString());
            }
        }
        continue; /* Loop/switch isn't completed */
        j += 2;
        if (true) goto _L4; else goto _L3
_L3:
        c = ((q) (obj)).a(((List) (obj2)), flag);
        c.c = a.b.m;
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final z d()
    {
        Object obj = com.a.a.a.a.v.a(c.c());
        a.a(((v) (obj)));
        obj = new z(a.h, ((v) (obj)));
        ((z) (obj)).a("spdy/3");
        return ((z) (obj));
    }
}
