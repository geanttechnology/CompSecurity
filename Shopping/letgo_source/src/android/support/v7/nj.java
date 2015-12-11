// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package android.support.v7:
//            nk, nm

public abstract class nj
{

    private final String a;
    private final Object b;

    private nj(String s, Object obj)
    {
        a = s;
        b = obj;
        zzp.zzbF().a(this);
    }


    public static nj a(String s)
    {
        s = a(s, (String)null);
        zzp.zzbF().b(s);
        return s;
    }

    public static nj a(String s, int i)
    {
        return new nj(s, Integer.valueOf(i)) {

            public Object a(SharedPreferences sharedpreferences)
            {
                return b(sharedpreferences);
            }

            public Integer b(SharedPreferences sharedpreferences)
            {
                return Integer.valueOf(sharedpreferences.getInt(a(), ((Integer)b()).intValue()));
            }

        };
    }

    public static nj a(String s, long l)
    {
        return new nj(s, Long.valueOf(l)) {

            public Object a(SharedPreferences sharedpreferences)
            {
                return b(sharedpreferences);
            }

            public Long b(SharedPreferences sharedpreferences)
            {
                return Long.valueOf(sharedpreferences.getLong(a(), ((Long)b()).longValue()));
            }

        };
    }

    public static nj a(String s, Boolean boolean1)
    {
        return new nj(s, boolean1) {

            public Object a(SharedPreferences sharedpreferences)
            {
                return b(sharedpreferences);
            }

            public Boolean b(SharedPreferences sharedpreferences)
            {
                return Boolean.valueOf(sharedpreferences.getBoolean(a(), ((Boolean)b()).booleanValue()));
            }

        };
    }

    public static nj a(String s, String s1)
    {
        return new nj(s, s1) {

            public Object a(SharedPreferences sharedpreferences)
            {
                return b(sharedpreferences);
            }

            public String b(SharedPreferences sharedpreferences)
            {
                return sharedpreferences.getString(a(), (String)b());
            }

        };
    }

    public static nj b(String s)
    {
        s = a(s, (String)null);
        zzp.zzbF().c(s);
        return s;
    }

    protected abstract Object a(SharedPreferences sharedpreferences);

    public String a()
    {
        return a;
    }

    public Object b()
    {
        return b;
    }

    public Object c()
    {
        return zzp.zzbG().a(this);
    }
}
