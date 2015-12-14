// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.crashlytics.android.Crashlytics;

public class jj
{

    private static jj a = null;

    private jj()
    {
    }

    public static jj a()
    {
        if (a == null)
        {
            a = new jj();
        }
        return a;
    }

    public static boolean b()
    {
        boolean flag = false;
        je je1 = ix.a(null);
        if (je1 != null)
        {
            flag = je1.a();
        }
        return flag;
    }

    public String a(Context context)
    {
        String s = "";
        je je1;
        try
        {
            je1 = ix.a(null);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            Crashlytics.logException(context);
            return "";
        }
        if (je1 == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        s = je1.a(context);
        return s;
    }

    public void a(Context context, jd jd, String s)
    {
        try
        {
            jd = ix.a(jd);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Crashlytics.logException(context);
            return;
        }
        if (jd == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        jd.a(context, s);
    }

}
