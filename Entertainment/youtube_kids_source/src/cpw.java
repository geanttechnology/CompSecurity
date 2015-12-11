// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class cpw
    implements cpu, Serializable
{

    public int a;
    public int b;
    public int c;
    public Uri d;
    public Uri e;
    private List f;

    public cpw()
    {
        f = new LinkedList();
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        a = objectinputstream.readInt();
        b = objectinputstream.readInt();
        c = objectinputstream.readInt();
        d = a.p((String)objectinputstream.readObject());
        e = a.p((String)objectinputstream.readObject());
        f = (List)objectinputstream.readObject();
    }

    private Object readResolve()
    {
        return a();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeInt(a);
        objectoutputstream.writeInt(b);
        objectoutputstream.writeInt(c);
        objectoutputstream.writeObject(a.a(d));
        objectoutputstream.writeObject(a.a(e));
        objectoutputstream.writeObject(f);
    }

    public final cpv a()
    {
        return new cpv(a, b, c, d, e, f);
    }

    public final cpw a(Object obj)
    {
        f.add(obj);
        return this;
    }

    public final cpw a(List list)
    {
        b.a(list);
        f.addAll(list);
        return this;
    }

    public final Object b()
    {
        return a();
    }
}
