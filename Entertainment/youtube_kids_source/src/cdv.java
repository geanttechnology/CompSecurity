// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class cdv
    implements cpu, Serializable
{

    public String a;
    public String b;
    public String c;
    public String d;
    public Date e;
    public Uri f;
    public Uri g;
    public Uri h;
    public Uri i;
    public Uri j;
    public Uri k;
    public int l;
    public boolean m;
    boolean n;

    public cdv()
    {
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        a = (String)objectinputstream.readObject();
        b = (String)objectinputstream.readObject();
        c = (String)objectinputstream.readObject();
        d = (String)objectinputstream.readObject();
        e = (Date)objectinputstream.readObject();
        f = a.p((String)objectinputstream.readObject());
        g = a.p((String)objectinputstream.readObject());
        h = a.p((String)objectinputstream.readObject());
        i = a.p((String)objectinputstream.readObject());
        j = a.p((String)objectinputstream.readObject());
        k = a.p((String)objectinputstream.readObject());
        l = objectinputstream.readInt();
        n = objectinputstream.readBoolean();
        try
        {
            m = objectinputstream.readBoolean();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            return;
        }
    }

    private Object readResolve()
    {
        return a();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeObject(a);
        objectoutputstream.writeObject(b);
        objectoutputstream.writeObject(c);
        objectoutputstream.writeObject(d);
        objectoutputstream.writeObject(e);
        objectoutputstream.writeObject(a.a(f));
        objectoutputstream.writeObject(a.a(g));
        objectoutputstream.writeObject(a.a(h));
        objectoutputstream.writeObject(a.a(i));
        objectoutputstream.writeObject(a.a(j));
        objectoutputstream.writeObject(a.a(k));
        objectoutputstream.writeInt(l);
        objectoutputstream.writeBoolean(n);
        objectoutputstream.writeBoolean(m);
    }

    public final cdu a()
    {
        return new cdu(a, b, c, d, e, f, g, h, i, j, k, l, m, n);
    }

    public final Object b()
    {
        return a();
    }
}
