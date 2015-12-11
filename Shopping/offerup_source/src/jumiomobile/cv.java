// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;

// Referenced classes of package jumiomobile:
//            ax

public class cv
{

    public static int a(Context context, String s, String s1)
    {
        int i;
        try
        {
            i = context.getResources().getIdentifier(s, s1, context.getPackageName());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return 0;
        }
        return i;
    }

    public static Bitmap a(String s)
    {
        return ax.a("http://mobile-sdk-resources.jumio.com/android/", s);
    }

    public static Bitmap a(String s, android.graphics.BitmapFactory.Options options)
    {
        return ax.a("http://mobile-sdk-resources.jumio.com/android/", s, options);
    }

    public static boolean a(String s, ClassLoader classloader)
    {
        try
        {
            Class.forName(s, false, classloader);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }
}
