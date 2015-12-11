// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

public final class cdm
    implements Serializable
{

    private String a;
    private Uri b;
    private cdn c;
    private String d;
    private ced e;
    private String f;
    private Date g;
    private String h;

    public cdm(String s, Uri uri, cdn cdn1, String s1, ced ced, String s2, Date date, 
            String s3)
    {
        a = s;
        b = uri;
        c = cdn1;
        d = s1;
        e = ced;
        g = date;
        if (cdn1 != null && !cdn1.k && TextUtils.isEmpty(s2))
        {
            f = s1;
        } else
        {
            f = s2;
        }
        h = s3;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        throw new InvalidObjectException("builder required");
    }

    private Object writeReplace()
    {
        cdo cdo1 = new cdo();
        cdo1.a = a;
        cdo1.b = b;
        cdo1.c = c;
        cdo1.d = d;
        cdo1.e = e;
        cdo1.f = f;
        cdo1.g = g;
        cdo1.h = h;
        return cdo1;
    }

    public final String toString()
    {
        String s1 = a;
        String s;
        String s2;
        if (c != null)
        {
            s = c.toString();
        } else
        {
            s = "";
        }
        s = String.valueOf(s.toLowerCase(Locale.US));
        s2 = d;
        return (new StringBuilder(String.valueOf(s1).length() + 2 + String.valueOf(s).length() + String.valueOf(s2).length())).append(s1).append(" ").append(s).append(" ").append(s2).toString();
    }
}
