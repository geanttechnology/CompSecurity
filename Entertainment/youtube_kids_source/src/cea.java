// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class cea
    implements Serializable
{

    private int A;
    private Uri a;
    private Uri b;
    private Uri c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private int i;
    private cec j;
    private String k;
    private Uri l;
    private boolean m;
    private boolean n;
    private Uri o;
    private int p;
    private Uri q;
    private int r;
    private Uri s;
    private int t;
    private Uri u;
    private Uri v;
    private Uri w;
    private Uri x;
    private long y;
    private long z;

    public cea(Uri uri, Uri uri1, Uri uri2, String s1, String s2, String s3, String s4, 
            String s5, int i1, cec cec, String s6, Uri uri3, boolean flag, boolean flag1, 
            Uri uri4, int j1, Uri uri5, int k1, Uri uri6, int l1, Uri uri7, 
            Uri uri8, Uri uri9, Uri uri10, long l2, long l3, 
            int i2)
    {
        a = uri;
        b = uri1;
        c = uri2;
        if (s1 != null)
        {
            uri = s1;
        } else
        {
            uri = s5;
        }
        d = uri;
        if (!TextUtils.isEmpty(s2))
        {
            s1 = s2;
        }
        e = s1;
        f = s3;
        g = s4;
        h = s5;
        i = i1;
        j = cec;
        k = s6;
        l = uri3;
        m = flag;
        n = flag1;
        o = uri4;
        p = j1;
        q = uri5;
        r = k1;
        s = uri6;
        t = l1;
        u = uri7;
        v = uri8;
        w = uri9;
        x = uri10;
        y = l2;
        z = l3;
        A = i2;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        throw new InvalidObjectException("builder required");
    }

    private Object writeReplace()
    {
        ceb ceb1 = new ceb();
        ceb1.a = a;
        ceb1.b = b;
        ceb1.c = c;
        ceb1.d = d;
        ceb1.e = e;
        ceb1 = ceb1.a(f);
        ceb1.f = g;
        ceb1.g = h;
        ceb1.h = i;
        ceb1.i = j;
        ceb1.j = k;
        ceb1.k = l;
        ceb1.l = m;
        ceb1.m = n;
        ceb1.n = o;
        ceb1.o = p;
        ceb1.p = q;
        ceb1.q = r;
        ceb1.r = s;
        ceb1.s = t;
        ceb1.t = u;
        ceb1.u = v;
        ceb1.v = w;
        ceb1.w = x;
        ceb1.x = y;
        ceb1.y = z;
        ceb1.z = A;
        return ceb1;
    }

    public final String toString()
    {
        if (d != null)
        {
            return d;
        } else
        {
            return h;
        }
    }
}
