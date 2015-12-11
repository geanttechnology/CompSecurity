// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.content.res.Resources;
import java.util.HashMap;

// Referenced classes of package jumiomobile:
//            co

public abstract class cl
{

    private static cl c;
    private static co d;
    protected HashMap a;
    protected String b;

    public cl()
    {
        a = new HashMap();
    }

    public static String a(Context context, String s)
    {
        int i;
        try
        {
            i = context.getResources().getIdentifier((new StringBuilder()).append(a().b).append(s).toString(), "string", context.getPackageName());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return a(s);
        }
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        return a(s);
        context = context.getString(i);
        return context;
    }

    private static String a(String s)
    {
        if (a().b() != null)
        {
            return (String)a().b().get(s);
        } else
        {
            return "";
        }
    }

    public static cl a()
    {
        jumiomobile/cl;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            throw new IllegalStateException("need to call Strings.setFactory()!");
        }
        break MISSING_BLOCK_LABEL_25;
        Exception exception;
        exception;
        jumiomobile/cl;
        JVM INSTR monitorexit ;
        throw exception;
        cl cl1;
        if (c == null)
        {
            c = d.a();
        }
        cl1 = c;
        jumiomobile/cl;
        JVM INSTR monitorexit ;
        return cl1;
    }

    public static void a(co co1)
    {
        jumiomobile/cl;
        JVM INSTR monitorenter ;
        c = null;
        d = co1;
        jumiomobile/cl;
        JVM INSTR monitorexit ;
        return;
        co1;
        throw co1;
    }

    private HashMap b()
    {
        return a;
    }
}
