// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.text.TextUtils;

public final class bye
{

    private static int a[] = new int[0];

    public static void a(SharedPreferences sharedpreferences, String s)
    {
        sharedpreferences = sharedpreferences.edit();
        sharedpreferences.putString("experiment_ids", s);
        sharedpreferences.commit();
    }

    public static boolean a(String s)
    {
        return TextUtils.isEmpty(s) || s.trim().matches("\\d+(\\s*,\\s*\\d+)*");
    }

    public static int[] a(SharedPreferences sharedpreferences)
    {
        return b(b(sharedpreferences));
    }

    public static String b(SharedPreferences sharedpreferences)
    {
        return sharedpreferences.getString("experiment_ids", null);
    }

    private static int[] b(String s)
    {
        int i = 0;
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s = a;
_L4:
        return s;
_L2:
        String as[] = s.trim().split("\\s*,\\s*");
        int ai[] = new int[as.length];
        int k = as.length;
        int j = 0;
        do
        {
            s = ai;
            if (i >= k)
            {
                continue; /* Loop/switch isn't completed */
            }
            s = as[i];
            try
            {
                ai[j] = Integer.parseInt(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                bmo.b("Improperly formatted experiment ID string encountered.");
                return a;
            }
            j++;
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

}
