// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.fotoable.fotovariant.fotoads.FotoAdBanner;
import com.fotoable.fotovariant.nativeAds.FotoNativeBaseWall;
import com.fotoable.fotovariant.nativeAds.FotoNativeIcon;
import java.lang.reflect.Constructor;

public class anq
{

    private static anp a()
    {
        anp anp1;
        try
        {
            anp1 = (anp)Class.forName("aao").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return anp1;
    }

    public static ant a(anu anu)
    {
        anp anp1 = a();
        if (anp1 == null)
        {
            return null;
        } else
        {
            return anp1.a(anu);
        }
    }

    public static aoa a(anz anz)
    {
        anp anp1 = a();
        if (anp1 == null)
        {
            return null;
        } else
        {
            return anp1.a(anz);
        }
    }

    public static FotoAdBanner a(Context context)
    {
        anp anp1 = a();
        if (anp1 == null)
        {
            return null;
        } else
        {
            return anp1.a(context);
        }
    }

    public static FotoNativeBaseWall a(Context context, anv anv)
    {
        anp anp1 = a();
        if (anp1 == null)
        {
            return null;
        } else
        {
            return anp1.a(context, anv);
        }
    }

    public static FotoNativeIcon b(Context context)
    {
        anp anp1 = a();
        if (anp1 == null)
        {
            return null;
        } else
        {
            return anp1.b(context);
        }
    }

    public static anx c(Context context)
    {
        anp anp1 = a();
        if (anp1 == null)
        {
            return null;
        } else
        {
            return anp1.c(context);
        }
    }

    public static ans d(Context context)
    {
        anp anp1 = a();
        if (anp1 == null)
        {
            return null;
        } else
        {
            return anp1.d(context);
        }
    }
}
