// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public final class cds
    implements cpu, Serializable
{

    public Date a;
    public Date b;
    public cdt c;
    public Uri d;
    public ced e;

    public cds()
    {
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        a = (Date)objectinputstream.readObject();
        b = (Date)objectinputstream.readObject();
        c = (cdt)objectinputstream.readObject();
        d = a.p((String)objectinputstream.readObject());
        e = (ced)objectinputstream.readObject();
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
        objectoutputstream.writeObject(a.a(d));
        objectoutputstream.writeObject(e);
    }

    public final cdr a()
    {
        return new cdr(a, b, c, d, e);
    }

    public final Object b()
    {
        return a();
    }

    public final String toString()
    {
        String s = String.valueOf(a);
        String s1 = String.valueOf(b);
        String s2 = String.valueOf(c);
        String s3 = String.valueOf(e);
        return (new StringBuilder(String.valueOf(s).length() + 53 + String.valueOf(s1).length() + String.valueOf(s2).length() + String.valueOf(s3).length())).append("Live Event [start = '").append(s).append(", end='").append(s1).append("', status: '").append(s2).append("', video: '").append(s3).append("']").toString();
    }
}
