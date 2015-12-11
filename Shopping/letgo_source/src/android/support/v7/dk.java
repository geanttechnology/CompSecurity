// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.GetProductsService;
import com.abtnprojects.ambatana.datasource.api.c;
import java.util.List;
import retrofit.RetrofitError;

// Referenced classes of package android.support.v7:
//            aqo

public class dk
{

    private final GetProductsService a;
    private boolean b;
    private boolean c;

    public dk(String s)
    {
        a = com.abtnprojects.ambatana.datasource.api.c.f(s);
    }

    public List a(String s)
    {
        Object obj = null;
        if (c)
        {
            return null;
        }
        c = true;
        try
        {
            s = a.getFavorites(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aqo.a(s, "Error getFavorites", new Object[0]);
            s = obj;
        }
        c = false;
        return s;
    }

    public List a(String s, double d, double d1, String s1, Float float1, 
            Float float2, String s2, Integer integer, int i, int j, String s3, String s4)
    {
        if (b)
        {
            return null;
        }
        b = true;
        try
        {
            s = a.getProducts(s, d, d1, s1, float1, float2, s2, integer, Integer.valueOf(i), Integer.valueOf(j), s3, s4);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            android.support.v7.aqo.c(s.getMessage(), new Object[0]);
            s = null;
        }
        b = false;
        return s;
    }

    public List a(String s, int i, int j, String s1)
    {
        try
        {
            s = a.getUserProducts(s, Integer.valueOf(i), Integer.valueOf(j), s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aqo.b(s, "Error getProducts %s", new Object[] {
                s.getUrl()
            });
            return null;
        }
        return s;
    }
}
