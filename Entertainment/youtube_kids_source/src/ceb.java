// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class ceb
    implements cpu, Serializable
{

    private String A;
    public Uri a;
    public Uri b;
    public Uri c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h;
    public cec i;
    public String j;
    public Uri k;
    public boolean l;
    public boolean m;
    public Uri n;
    public int o;
    public Uri p;
    public int q;
    public Uri r;
    public int s;
    public Uri t;
    public Uri u;
    public Uri v;
    public Uri w;
    public long x;
    public long y;
    public int z;

    public ceb()
    {
        h = -1;
        i = cec.c;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        a = a.p((String)objectinputstream.readObject());
        b = a.p((String)objectinputstream.readObject());
        c = a.p((String)objectinputstream.readObject());
        d = (String)objectinputstream.readObject();
        A = (String)objectinputstream.readObject();
        f = (String)objectinputstream.readObject();
        e = (String)objectinputstream.readObject();
        g = (String)objectinputstream.readObject();
        h = objectinputstream.readInt();
        i = (cec)objectinputstream.readObject();
        j = (String)objectinputstream.readObject();
        k = a.p((String)objectinputstream.readObject());
        l = objectinputstream.readBoolean();
        m = objectinputstream.readBoolean();
        n = a.p((String)objectinputstream.readObject());
        o = objectinputstream.readInt();
        p = a.p((String)objectinputstream.readObject());
        q = objectinputstream.readInt();
        r = a.p((String)objectinputstream.readObject());
        s = objectinputstream.readInt();
        t = a.p((String)objectinputstream.readObject());
        u = a.p((String)objectinputstream.readObject());
        v = a.p((String)objectinputstream.readObject());
        w = a.p((String)objectinputstream.readObject());
        x = objectinputstream.readLong();
        y = objectinputstream.readLong();
        z = objectinputstream.readInt();
    }

    private Object readResolve()
    {
        return a();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeObject(a.a(a));
        objectoutputstream.writeObject(a.a(b));
        objectoutputstream.writeObject(a.a(c));
        objectoutputstream.writeObject(d);
        objectoutputstream.writeObject(A);
        objectoutputstream.writeObject(f);
        objectoutputstream.writeObject(e);
        objectoutputstream.writeObject(g);
        objectoutputstream.writeInt(h);
        objectoutputstream.writeObject(i);
        objectoutputstream.writeObject(j);
        objectoutputstream.writeObject(a.a(k));
        objectoutputstream.writeBoolean(l);
        objectoutputstream.writeBoolean(m);
        objectoutputstream.writeObject(a.a(n));
        objectoutputstream.writeInt(o);
        objectoutputstream.writeObject(a.a(p));
        objectoutputstream.writeInt(q);
        objectoutputstream.writeObject(a.a(r));
        objectoutputstream.writeInt(s);
        objectoutputstream.writeObject(a.a(t));
        objectoutputstream.writeObject(a.a(u));
        objectoutputstream.writeObject(a.a(v));
        objectoutputstream.writeObject(a.a(w));
        objectoutputstream.writeLong(x);
        objectoutputstream.writeLong(y);
        objectoutputstream.writeInt(z);
    }

    public final cea a()
    {
        return new cea(a, b, c, d, e, A, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
    }

    public final ceb a(String s1)
    {
        A = (String)b.a(s1);
        return this;
    }

    public final Object b()
    {
        return a();
    }
}
