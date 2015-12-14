// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.i;

import android.content.Context;
import com.appboy.Constants;

// Referenced classes of package myobfuscated.i:
//            a

public class d
{

    private static final String a;

    public d()
    {
    }

    public static boolean a(Context context, String s)
    {
        int i;
        try
        {
            i = context.checkCallingOrSelfPermission(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            myobfuscated.i.a.c(a, String.format("Failure checking permission %s", new Object[] {
                s
            }), context);
            return false;
        }
        return i == 0;
    }

    static 
    {
        a = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, myobfuscated/i/d.getName()
        });
    }
}
