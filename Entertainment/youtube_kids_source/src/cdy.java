// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class cdy
    implements Serializable
{

    public int a;
    public Uri b;
    int c;
    public String d;
    long e;
    String f;

    public cdy()
    {
        a = 0;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        a = objectinputstream.readInt();
        b = a.p((String)objectinputstream.readObject());
        f = (String)objectinputstream.readObject();
        c = objectinputstream.readInt();
        d = (String)objectinputstream.readObject();
        e = objectinputstream.readLong();
    }

    private Object readResolve()
    {
        return a();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeInt(a);
        objectoutputstream.writeObject(a.a(b));
        objectoutputstream.writeObject(f);
        objectoutputstream.writeInt(c);
        objectoutputstream.writeObject(d);
        objectoutputstream.writeLong(e);
    }

    public final cdw a()
    {
        return new cdw(a, b, f, c, d, e);
    }
}
