// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Set;

public final class bwb
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new bwc();
    public final dla a;
    public final long b;
    private final String c;
    private final Uri d;
    private Uri e;

    public bwb(dla dla1, String s, long l)
    {
        a = dla1;
        c = s;
        b = l;
        d = Uri.parse(dla1.c);
    }

    public static bwb a(Uri uri, String s, long l)
    {
        dla dla1 = new dla();
        dla1.b = 93;
        dla1.d = "application/x-mpegURL";
        dla1.c = uri.toString();
        return new bwb(dla1, s, l);
    }

    public final Uri a(String s)
    {
        if (s == null)
        {
            return b();
        } else
        {
            return bnf.a(b()).a("cpn", s).a.build();
        }
    }

    public final dla a()
    {
        dla dla1;
        try
        {
            dla1 = (dla)eun.a(new dla(), eun.a(a));
        }
        catch (eum eum1)
        {
            throw new RuntimeException(eum1);
        }
        return dla1;
    }

    public final Uri b()
    {
        if (e == null)
        {
            if (c != null)
            {
                e = bnf.a(d).a("dnc", "1").a.build();
            } else
            {
                e = d;
            }
        }
        return e;
    }

    public final aqr b(String s)
    {
        bxa bxa1 = new bxa(a.b, a.q, a.d, a.f, a.g, 0, 0, a.e, null, a.o, a.p);
        long l = b;
        String s1 = c;
        long l1 = a.j;
        s = a(s);
        long l2 = a.h.a;
        long l3 = a.h.b;
        long l4 = a.i.a;
        long l5 = a.i.b;
        long l6 = a.k;
        return new aqr(0L, l, s1, l1, bxa1, new aqx(new aqo(s, null, l2, (l3 - l2) + 1L), 1L, 0L, s, l4, (l5 - l4) + 1L), l6);
    }

    public final int c()
    {
        char c2 = '\220';
        if (!f()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = a.f;
        j = a.g;
        if (i <= 3840 && j <= 2160) goto _L4; else goto _L3
_L3:
        char c1 = '\uFFFF';
_L6:
        return c1;
_L4:
        if (i > 2560 || j > 1440)
        {
            return 2160;
        }
        if (i > 1920 || j > 1080)
        {
            return 1440;
        }
        if (i > 1280 || j > 720)
        {
            return 1080;
        }
        if (i > 854 || j > 480)
        {
            return 720;
        }
        if (i > 640 || j > 360)
        {
            return 480;
        }
        if (i > 426 || j > 240)
        {
            return 360;
        }
        if (i > 256 || j > 144)
        {
            return 240;
        }
        c1 = c2;
        if (i > 0) goto _L6; else goto _L5
_L5:
        c1 = c2;
        if (j > 0) goto _L6; else goto _L7
_L7:
        return -1;
_L2:
        if (g() && bwd.k().contains(Integer.valueOf(a.b)))
        {
            return 1;
        }
        if (true) goto _L7; else goto _L8
_L8:
    }

    public final boolean d()
    {
        Uri uri = d;
        return "127.0.0.1".equals(uri.getHost()) || "localhost".equals(uri.getHost());
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean e()
    {
        boolean flag1 = false;
        int ai[] = a.r;
        int j = ai.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (ai[i] != 4)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (bwb)obj;
            if (b != ((bwb) (obj)).b || !b.a(c, ((bwb) (obj)).c) || !eun.a(a, ((bwb) (obj)).a))
            {
                return false;
            }
        }
        return true;
    }

    public final boolean f()
    {
        return a.d.startsWith("video");
    }

    public final boolean g()
    {
        return a.d.startsWith("audio");
    }

    public final int hashCode()
    {
        int j = 0;
        int k = (int)(b ^ b >>> 32);
        int i;
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        if (a != null)
        {
            j = Arrays.hashCode(eun.a(a));
        }
        return (i + (k + 31) * 31) * 31 + j;
    }

    public final String toString()
    {
        return String.format("v:{%s} t:{%d} i:{%d} s:{%dx%d} m:{%s} e:{%s} u:{%s}", new Object[] {
            c, Long.valueOf(b), Integer.valueOf(a.b), Integer.valueOf(a.f), Integer.valueOf(a.g), a.d, Arrays.toString(a.r), d.toString()
        });
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        a.a(parcel, a);
        parcel.writeString(c);
        parcel.writeLong(b);
    }

}
