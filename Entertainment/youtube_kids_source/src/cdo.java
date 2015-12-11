// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public final class cdo
    implements cpu, Serializable
{

    public String a;
    public Uri b;
    public cdn c;
    public String d;
    public ced e;
    public String f;
    public Date g;
    public String h;

    public cdo()
    {
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        a = (String)objectinputstream.readObject();
        b = a.p((String)objectinputstream.readObject());
        c = (cdn)objectinputstream.readObject();
        d = (String)objectinputstream.readObject();
        e = (ced)objectinputstream.readObject();
        f = (String)objectinputstream.readObject();
        g = (Date)objectinputstream.readObject();
        h = (String)objectinputstream.readObject();
    }

    private Object readResolve()
    {
        return a();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeObject(a);
        objectoutputstream.writeObject(a.a(b));
        objectoutputstream.writeObject(c);
        objectoutputstream.writeObject(d);
        objectoutputstream.writeObject(e);
        objectoutputstream.writeObject(f);
        objectoutputstream.writeObject(g);
        objectoutputstream.writeObject(h);
    }

    public final cdm a()
    {
        return new cdm(a, b, c, d, e, f, g, h);
    }

    public final Object b()
    {
        return a();
    }
}
