// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class ced
    implements Serializable
{

    private ceg A;
    private Map B;
    private String C;
    private String D;
    private ceh E;
    private boolean F;
    private boolean G;
    private boolean H;
    private Set I;
    private Uri J;
    private boolean K;
    public final Set a;
    public final String b;
    public final Uri c;
    public final Uri d;
    public final Uri e;
    public final String f;
    public final int g;
    public final long h;
    public final long i;
    public final long j;
    public final String k;
    public final Date l;
    public final String m;
    public final boolean n;
    public final boolean o;
    public final String p;
    private Uri q;
    private Uri r;
    private Uri s;
    private Uri t;
    private String u;
    private Uri v;
    private Date w;
    private String x;
    private String y;
    private String z;

    ced(String s1, Set set, Uri uri, Uri uri1, Uri uri2, Uri uri3, Uri uri4, 
            Uri uri5, Uri uri6, String s2, int i1, long l1, long l2, long l3, String s3, Uri uri7, Date date, Date date1, 
            String s4, String s5, String s6, String s7, ceg ceg, Map map, String s8, 
            String s9, boolean flag, ceh ceh1, boolean flag1, Set set1, boolean flag2, boolean flag3, 
            Uri uri8, boolean flag4, String s10, boolean flag5, String s11)
    {
        b = b.a(s1, "youTubeId can't be empty");
        a = a.a((Set)b.a(set));
        q = uri;
        r = uri1;
        c = uri2;
        d = uri3;
        e = uri4;
        s = uri5;
        t = uri6;
        f = s2;
        g = i1;
        h = l1;
        i = l2;
        j = l3;
        u = s3;
        v = uri7;
        l = date;
        w = date1;
        x = s4;
        y = s5;
        z = s6;
        m = s7;
        A = ceg;
        B = map;
        C = s8;
        D = s9;
        F = flag;
        E = (ceh)b.a(ceh1);
        H = flag1;
        if (set1 == null)
        {
            s1 = null;
        } else
        {
            s1 = a.a(a.b(set1));
        }
        I = s1;
        if (s6 != null)
        {
            s6.contains("yt:cc=alwayson");
        }
        n = flag2;
        o = flag3;
        J = uri8;
        G = flag4;
        if (!TextUtils.isEmpty(s10))
        {
            s3 = s10;
        }
        k = s3;
        K = flag5;
        p = s11;
    }

    private Object writeReplace()
    {
        cef cef1 = new cef();
        cef1.a = b;
        cef1.b = new HashSet(a);
        cef1.c = q;
        cef1.d = r;
        cef1.e = c;
        cef1.f = d;
        cef1.g = e;
        cef1.h = s;
        cef1.i = t;
        cef1.j = f;
        cef1.k = g;
        cef1.l = h;
        cef1.m = i;
        cef1.n = j;
        cef1.o = u;
        cef1.p = v;
        cef1.q = l;
        cef1.r = w;
        cef1.s = x;
        cef1.t = y;
        cef1.u = z;
        cef1.v = m;
        cef1 = cef1.a(A);
        cef1.w = B;
        cef1.x = C;
        cef1.y = D;
        cef1.z = F;
        cef1 = cef1.a(E);
        cef1.A = H;
        cef1.B = I;
        cef1.C = n;
        cef1.D = o;
        cef1.E = J;
        cef1.F = G;
        cef1.G = k;
        cef1.H = K;
        cef1.I = p;
        return cef1;
    }

    public final boolean a()
    {
        if (!K)
        {
            switch (cee.a[E.ordinal()])
            {
            default:
                return false;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
                return true;

            case 4: // '\004'
                break;
            }
            if (J != null && E != ceh.a)
            {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof ced))
        {
            return false;
        } else
        {
            obj = (ced)obj;
            return b.equals(((ced) (obj)).b);
        }
    }

    public final int hashCode()
    {
        return b.hashCode();
    }

    public final String toString()
    {
        String s1 = b;
        String s2 = f;
        return (new StringBuilder(String.valueOf(s1).length() + 24 + String.valueOf(s2).length())).append("Video[id = '").append(s1).append("', title='").append(s2).append("']").toString();
    }

    static 
    {
        Pattern.compile("yt:cc_default_lang=([a-zA-Z]{2})");
    }
}
