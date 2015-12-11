// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.os.ConditionVariable;
import java.io.IOException;
import org.json.JSONArray;

// Referenced classes of package crittercism.android:
//            bq, dg, cr, dh

public final class br
    implements bq
{

    private String a[];

    public br()
    {
        String s;
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            s = "logcat -t 100 -v time";
        } else
        {
            s = "logcat -d -v time";
        }
        a = s.split("\\s+");
    }

    private static JSONArray a(String as[])
    {
        Object obj = null;
        JSONArray jsonarray = obj;
        if (as != null)
        {
            jsonarray = obj;
            if (as.length > 0)
            {
                int i = 0;
                if (as.length > 200)
                {
                    i = as.length - 200;
                }
                jsonarray = new JSONArray();
                for (; i < as.length; i++)
                {
                    jsonarray.put(as[i]);
                }

            }
        }
        return jsonarray;
    }

    private Process b()
    {
        String as[] = a;
        Process process;
        try
        {
            process = (new ProcessBuilder(new String[0])).command(a).start();
        }
        catch (IOException ioexception)
        {
            (new StringBuilder("IOException in createProcess(): ")).append(ioexception.getMessage());
            dg.b();
            dg.c();
            return null;
        }
        return process;
    }

    public final JSONArray a()
    {
        Object obj;
        ConditionVariable conditionvariable;
        cr cr1;
        cr cr2;
        try
        {
            obj = b();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            (new StringBuilder("Unanticipated throwable in getLogcat: ")).append(((Throwable) (obj)).getMessage());
            dg.b();
            dg.c();
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        conditionvariable = new ConditionVariable();
        cr1 = new cr(((Process) (obj)), conditionvariable, cr.a.a);
        cr2 = new cr(((Process) (obj)), null, cr.a.b);
        (new dh(cr1)).start();
        (new dh(cr2)).start();
        conditionvariable.block(250L);
        ((Process) (obj)).destroy();
        obj = cr1.b();
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((StringBuilder) (obj)).toString();
        if (((String) (obj)).length() <= 0) goto _L2; else goto _L3
_L3:
        obj = ((String) (obj)).split("\n");
_L4:
        obj = a(((String []) (obj)));
_L5:
        dg.b();
        return ((JSONArray) (obj));
_L2:
        obj = null;
          goto _L4
        obj = null;
          goto _L5
    }
}
