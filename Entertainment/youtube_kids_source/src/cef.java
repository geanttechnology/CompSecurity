// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public final class cef
    implements cpu, Serializable
{

    public boolean A;
    public Set B;
    public boolean C;
    public boolean D;
    public Uri E;
    public boolean F;
    public String G;
    boolean H;
    String I;
    private ceg J;
    private ceh K;
    public String a;
    public Set b;
    public Uri c;
    public Uri d;
    public Uri e;
    public Uri f;
    public Uri g;
    public Uri h;
    public Uri i;
    public String j;
    public int k;
    public long l;
    public long m;
    public long n;
    public String o;
    public Uri p;
    public Date q;
    public Date r;
    public String s;
    public String t;
    public String u;
    public String v;
    public Map w;
    public String x;
    public String y;
    public boolean z;

    public cef()
    {
        K = ceh.a;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        a = (String)objectinputstream.readObject();
        b = (Set)objectinputstream.readObject();
        c = a.p((String)objectinputstream.readObject());
        d = a.p((String)objectinputstream.readObject());
        e = a.p((String)objectinputstream.readObject());
        f = a.p((String)objectinputstream.readObject());
        g = a.p((String)objectinputstream.readObject());
        h = a.p((String)objectinputstream.readObject());
        i = a.p((String)objectinputstream.readObject());
        j = (String)objectinputstream.readObject();
        k = objectinputstream.readInt();
        l = objectinputstream.readLong();
        m = objectinputstream.readLong();
        n = objectinputstream.readLong();
        o = (String)objectinputstream.readObject();
        p = a.p((String)objectinputstream.readObject());
        q = (Date)objectinputstream.readObject();
        r = (Date)objectinputstream.readObject();
        s = (String)objectinputstream.readObject();
        t = (String)objectinputstream.readObject();
        u = (String)objectinputstream.readObject();
        v = (String)objectinputstream.readObject();
        J = (ceg)objectinputstream.readObject();
        w = (Map)objectinputstream.readObject();
        x = (String)objectinputstream.readObject();
        y = (String)objectinputstream.readObject();
        z = objectinputstream.readBoolean();
        K = (ceh)objectinputstream.readObject();
        A = objectinputstream.readBoolean();
        B = (Set)objectinputstream.readObject();
        C = objectinputstream.readBoolean();
        D = objectinputstream.readBoolean();
        E = a.p((String)objectinputstream.readObject());
        F = objectinputstream.readBoolean();
        G = (String)objectinputstream.readObject();
        H = objectinputstream.readBoolean();
        I = (String)objectinputstream.readObject();
    }

    private Object readResolve()
    {
        return a();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeObject(a);
        objectoutputstream.writeObject(b);
        objectoutputstream.writeObject(a.a(c));
        objectoutputstream.writeObject(a.a(d));
        objectoutputstream.writeObject(a.a(e));
        objectoutputstream.writeObject(a.a(f));
        objectoutputstream.writeObject(a.a(g));
        objectoutputstream.writeObject(a.a(h));
        objectoutputstream.writeObject(a.a(i));
        objectoutputstream.writeObject(j);
        objectoutputstream.writeInt(k);
        objectoutputstream.writeLong(l);
        objectoutputstream.writeLong(m);
        objectoutputstream.writeLong(n);
        objectoutputstream.writeObject(o);
        objectoutputstream.writeObject(a.a(p));
        objectoutputstream.writeObject(q);
        objectoutputstream.writeObject(r);
        objectoutputstream.writeObject(s);
        objectoutputstream.writeObject(t);
        objectoutputstream.writeObject(u);
        objectoutputstream.writeObject(v);
        objectoutputstream.writeObject(J);
        objectoutputstream.writeObject(w);
        objectoutputstream.writeObject(x);
        objectoutputstream.writeObject(y);
        objectoutputstream.writeBoolean(z);
        objectoutputstream.writeObject(K);
        objectoutputstream.writeBoolean(A);
        objectoutputstream.writeObject(B);
        objectoutputstream.writeBoolean(C);
        objectoutputstream.writeBoolean(D);
        objectoutputstream.writeObject(a.a(E));
        objectoutputstream.writeBoolean(F);
        objectoutputstream.writeObject(G);
        objectoutputstream.writeBoolean(H);
        objectoutputstream.writeObject(I);
    }

    public final ced a()
    {
        Set set;
        if (b != null)
        {
            set = b;
        } else
        {
            set = Collections.emptySet();
        }
        b = set;
        return new ced(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, J, w, x, y, z, K, A, B, C, D, E, F, G, H, I);
    }

    public final cef a(ceg ceg1)
    {
        if (J != ceg.c)
        {
            J = ceg1;
        }
        return this;
    }

    public final cef a(ceh ceh1)
    {
        K = (ceh)b.a(ceh1);
        return this;
    }

    public final Object b()
    {
        return a();
    }
}
