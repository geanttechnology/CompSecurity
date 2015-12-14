// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.crashlytics.android.Crashlytics;

public class aoo
{

    private static aoo a = null;

    private aoo()
    {
    }

    public static aoo a()
    {
        if (a == null)
        {
            a = new aoo();
        }
        return a;
    }

    public static boolean b()
    {
        boolean flag = false;
        aoa aoa1 = anq.a(null);
        if (aoa1 != null)
        {
            flag = aoa1.a();
        }
        return flag;
    }

    public String a(Context context)
    {
        String s = "";
        aoa aoa1;
        try
        {
            aoa1 = anq.a(null);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            Crashlytics.logException(context);
            return "";
        }
        if (aoa1 == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        s = aoa1.a(context);
        return s;
    }

    public void a(Context context, anz anz, String s)
    {
        try
        {
            anz = anq.a(anz);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Crashlytics.logException(context);
            return;
        }
        if (anz == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        anz.a(context, s);
    }

}
