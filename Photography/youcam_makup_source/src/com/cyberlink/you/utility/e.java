// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.content.Context;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.utility:
//            f, g

public class e
{

    private static Object a = new Object();
    private static final Map b = new HashMap();

    public e()
    {
    }

    static Object a()
    {
        return a;
    }

    public static boolean a(String s, String s1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (s != null && s1 != null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        boolean flag;
        s = (new StringBuilder()).append(s).append(s1).toString();
        flag = b.containsKey(s);
        obj;
        JVM INSTR monitorexit ;
        return flag;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static Map b()
    {
        return b;
    }

    public boolean a(Context context, String s, String s1, g g)
    {
        return a(context, null, s, s1, g);
    }

    public boolean a(Context context, String s, String s1, String s2, g g)
    {
        String s3;
label0:
        {
            synchronized (a)
            {
                s3 = (new StringBuilder()).append(s1).append(s2).toString();
                if (a(s1, s2))
                {
                    break label0;
                }
                Log.d("DownloadMediaHelper", (new StringBuilder()).append("start download=").append(s1).toString());
                f f1 = new f(this);
                f.a(f1, s2);
                f.a(f1, s, g);
                f1.execute(new String[] {
                    s1
                });
                b.put(s3, f1);
            }
            return false;
        }
        s1 = (f)b.get(s3);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        f.a(s1, s, g);
_L1:
        context;
        JVM INSTR monitorexit ;
        return true;
        Log.d("DownloadMediaHelper", "the url is downloaded");
          goto _L1
        s;
        context;
        JVM INSTR monitorexit ;
        throw s;
    }

}
