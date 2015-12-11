// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public final class cdr
    implements Serializable
{

    public final cdt a;
    public final Uri b;
    public final ced c;
    private Date d;
    private Date e;

    public cdr(Date date, Date date1, cdt cdt, Uri uri, ced ced1)
    {
        d = (Date)b.a(date);
        e = date1;
        a = cdt;
        b = (Uri)b.a(uri);
        c = (ced)b.a(ced1);
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        throw new InvalidObjectException("builder required");
    }

    private Object writeReplace()
    {
        cds cds1 = new cds();
        cds1.a = d;
        cds1.b = e;
        cds1.c = a;
        cds1.d = b;
        cds1.e = c;
        return cds1;
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof cdr))
        {
            return false;
        } else
        {
            obj = (cdr)obj;
            return b.equals(((cdr) (obj)).b);
        }
    }

    public final int hashCode()
    {
        return b.hashCode();
    }

    public final String toString()
    {
        String s = c.b;
        String s1 = c.f;
        String s2 = String.valueOf(a);
        String s3 = String.valueOf(d);
        return (new StringBuilder(String.valueOf(s).length() + 52 + String.valueOf(s1).length() + String.valueOf(s2).length() + String.valueOf(s3).length())).append("Live Event [id = '").append(s).append(", title='").append(s1).append("', status: '").append(s2).append("', start: '").append(s3).append("']").toString();
    }
}
