// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public final class cdu
    implements Serializable
{

    public final String a;
    public final String b;
    public final Uri c;
    public final boolean d;
    private String e;
    private String f;
    private Date g;
    private Uri h;
    private Uri i;
    private Uri j;
    private Uri k;
    private Uri l;
    private int m;
    private boolean n;

    public cdu(String s, String s1, String s2, String s3, Date date, Uri uri, Uri uri1, 
            Uri uri2, Uri uri3, Uri uri4, Uri uri5, int i1, boolean flag, boolean flag1)
    {
        a = (String)b.a(s);
        b = s1;
        e = s2;
        f = s3;
        g = date;
        c = uri;
        h = uri1;
        i = uri2;
        j = uri3;
        k = uri4;
        l = uri5;
        m = i1;
        d = flag;
        n = flag1;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        throw new InvalidObjectException("builder required");
    }

    private Object writeReplace()
    {
        cdv cdv1 = new cdv();
        cdv1.a = a;
        cdv1.b = b;
        cdv1.c = e;
        cdv1.d = f;
        cdv1.e = g;
        cdv1.f = c;
        cdv1.g = h;
        cdv1.h = i;
        cdv1.i = j;
        cdv1.j = k;
        cdv1.k = l;
        cdv1.l = m;
        cdv1.m = d;
        cdv1.n = n;
        return cdv1;
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof cdu))
        {
            return false;
        } else
        {
            obj = (cdu)obj;
            return a.equals(((cdu) (obj)).a);
        }
    }

    public final int hashCode()
    {
        return a.hashCode();
    }

    public final String toString()
    {
        return b;
    }
}
