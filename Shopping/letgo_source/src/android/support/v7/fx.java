// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;

// Referenced classes of package android.support.v7:
//            ff, dk, gf

public class fx extends ff
{

    public fx()
    {
    }

    protected gf a(int i, Context context, CountryCurrencyInfo countrycurrencyinfo, String s, String s1, String s2)
    {
        s = (new dk(s)).a(s2, 20, i, s1);
        if (s == null)
        {
            return null;
        } else
        {
            return a(((java.util.List) (s)), context, countrycurrencyinfo, null, null, i);
        }
    }

    protected gf a(Context context, CountryCurrencyInfo countrycurrencyinfo, String s, String s1)
    {
        s = (new dk(s)).a(s1);
        if (s == null)
        {
            return null;
        } else
        {
            return a(((java.util.List) (s)), context, countrycurrencyinfo, null, null, 1);
        }
    }

    protected gf b(int i, Context context, CountryCurrencyInfo countrycurrencyinfo, String s, String s1, String s2)
    {
        return a(i, context, countrycurrencyinfo, s, "selling", s1);
    }

    protected gf c(int i, Context context, CountryCurrencyInfo countrycurrencyinfo, String s, String s1, String s2)
    {
        return a(i, context, countrycurrencyinfo, s, "sold", s1);
    }
}
