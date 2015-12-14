// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.fotoable.fotovariant.fotoads.FotoAdBanner;
import com.fotoable.fotovariant.nativeAds.FotoNativeBaseWall;
import com.fotoable.fotovariant.nativeAds.FotoNativeIcon;
import java.lang.reflect.Constructor;

public class ix
{

    public static FotoAdBanner a(Context context)
    {
        iw iw1 = a();
        if (iw1 == null)
        {
            return null;
        } else
        {
            return iw1.a(context);
        }
    }

    public static FotoNativeBaseWall a(Context context, iz iz)
    {
        iw iw1 = a();
        if (iw1 == null)
        {
            return null;
        } else
        {
            return iw1.a(context, iz);
        }
    }

    private static iw a()
    {
        iw iw1;
        try
        {
            iw1 = (iw)Class.forName("gf").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return iw1;
    }

    public static je a(jd jd)
    {
        iw iw1 = a();
        if (iw1 == null)
        {
            return null;
        } else
        {
            return iw1.a(jd);
        }
    }

    public static FotoNativeIcon b(Context context)
    {
        iw iw1 = a();
        if (iw1 == null)
        {
            return null;
        } else
        {
            return iw1.b(context);
        }
    }

    public static jb c(Context context)
    {
        iw iw1 = a();
        if (iw1 == null)
        {
            return null;
        } else
        {
            return iw1.c(context);
        }
    }

    public static iy d(Context context)
    {
        iw iw1 = a();
        if (iw1 == null)
        {
            return null;
        } else
        {
            return iw1.d(context);
        }
    }
}
