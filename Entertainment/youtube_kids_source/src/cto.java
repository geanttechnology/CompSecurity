// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

public final class cto
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ctp();
    private static String c = "";
    private static String d = "";
    public final ams a;
    public final ctq b;

    public cto(ams ams1)
    {
        b.a(ams1);
        a = ams1;
        b = (ctq)b.a(h());
    }

    public cto(dre dre1)
    {
        b.a(dre1);
        a = new ams();
        ams ams1;
        if (dre1.e != null)
        {
            eda eda1 = dre1.e;
            a.a(eda1.a);
            a.b(eda1.b);
            a.a(a(eda1.c, eda1.b));
            a.c(eda1.d);
            a.d(eda1.g);
            a.b(eda1.e);
            a.a(false);
            a.c((int)(eda1.f * 1000F));
            if (eda1.i != null && eda1.i.a != null)
            {
                a.e(eda1.i.a.a);
            }
            int i = eda1.h;
        } else
        if (dre1.h != null)
        {
            edg edg1 = dre1.h;
            a.a("");
            a.b(edg1.a);
            a.a(edg1.b);
            a.c(edg1.c);
            a.d("");
            a.b(false);
            a.a(false);
            a.c(0);
        } else
        if (dre1.i != null)
        {
            dsd dsd1 = dre1.i;
            a.a(dsd1.a);
            a.b(dsd1.b);
            a.a(a(dsd1.c, dsd1.b));
            a.c(dsd1.d);
            a.d("");
            a.b(false);
            a.a(true);
            a.c(0);
        } else
        {
            throw new IllegalArgumentException("Navigation endpoint does not contain watch data");
        }
        ams1 = a;
        if (dre1.a != null)
        {
            dre1 = euc.a(dre1.a);
        } else
        {
            dre1 = euc.b;
        }
        ams1.a(dre1);
        a.c(true);
        a.b(ctn.a.ordinal());
        b = (ctq)b.a(h());
    }

    public cto(String s, String s1, int i, int j)
    {
        this(s, s1, i, j, ctn.a);
    }

    private cto(String s, String s1, int i, int j, ctn ctn1)
    {
        b.a(ctn1);
        a = new ams();
        ams ams1 = a;
        if (s == null)
        {
            s = c;
        }
        ams1.a(s);
        s = a;
        if (s1 == null)
        {
            s1 = d;
        }
        s.b(s1);
        a.a(i);
        a.c(j);
        a.c("");
        a.d("");
        a.a(euc.b);
        a.b(false);
        a.a(false);
        a.b(ctn1.ordinal());
        b = (ctq)b.a(h());
    }

    private static int a(int i, String s)
    {
        int j = i;
        if (i == 0)
        {
            j = i;
            if (TextUtils.isEmpty(s))
            {
                j = -1;
            }
        }
        return j;
    }

    private ctq h()
    {
        if (d() != null)
        {
            if (TextUtils.isEmpty(a.a) && TextUtils.isEmpty(a.c))
            {
                return ctq.c;
            }
        } else
        {
            if (!TextUtils.isEmpty(a.c))
            {
                return ctq.b;
            }
            if (!TextUtils.isEmpty(a.a))
            {
                return ctq.a;
            }
        }
        String s = String.valueOf(toString());
        if (s.length() != 0)
        {
            s = "Invalid PlaybackStartDescriptor\n".concat(s);
        } else
        {
            s = new String("Invalid PlaybackStartDescriptor\n");
        }
        bmo.b(s);
        return null;
    }

    public final String a()
    {
        return a.a;
    }

    public final String b()
    {
        return a.c;
    }

    public final int c()
    {
        return a.d;
    }

    public final List d()
    {
        if (a.b.size() > 0)
        {
            return a.b;
        } else
        {
            return null;
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    public final byte[] e()
    {
        return a.f.b();
    }

    public final Uri f()
    {
        if (a.p && !TextUtils.isEmpty(a.q))
        {
            return Uri.parse(a.q);
        } else
        {
            return null;
        }
    }

    public final ctn g()
    {
        return ctn.a(a.j);
    }

    public final String toString()
    {
        String s1 = a();
        String s2 = b();
        int i = c();
        String s;
        if (d() != null)
        {
            s = d().toString();
        } else
        {
            s = "";
        }
        return String.format("PlaybackStartDescriptor:\n  VideoId:%s\n  PlaylistId:%s\n  Index:%d\n  VideoIds:%s", new Object[] {
            s1, s2, Integer.valueOf(i), s
        });
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        a.a(parcel, a);
    }

}
