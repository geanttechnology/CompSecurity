// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

// Referenced classes of package com.google.analytics.tracking.android:
//            o, l, an

final class k
    implements o
{

    private static k a;
    private static final Object b = new Object();
    private final Context c;
    private String d;
    private boolean e;
    private final Object f = new Object();

    private k(Context context)
    {
        e = false;
        c = context;
        (new l(this, "client_id_fetcher")).start();
    }

    public static k a()
    {
        k k1;
        synchronized (b)
        {
            k1 = a;
        }
        return k1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static Object a(k k1)
    {
        return k1.f;
    }

    static String a(k k1, String s)
    {
        k1.d = s;
        return s;
    }

    public static void a(Context context)
    {
        synchronized (b)
        {
            if (a == null)
            {
                a = new k(context);
            }
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static boolean b(k k1)
    {
        k1.e = true;
        return true;
    }

    private boolean b(String s)
    {
        try
        {
            an.c("Storing clientId.");
            FileOutputStream fileoutputstream = c.openFileOutput("gaClientId", 0);
            fileoutputstream.write(s.getBytes());
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            an.a("Error creating clientId file.");
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            an.a("Error writing to clientId file.");
            return false;
        }
        return true;
    }

    private String c()
    {
        if (e) goto _L2; else goto _L1
_L1:
        Object obj = f;
        obj;
        JVM INSTR monitorenter ;
        if (e) goto _L2; else goto _L3
_L3:
        an.c("Waiting for clientId to load");
_L7:
        f.wait();
_L5:
        if (!e)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        an.c("Loaded clientId");
        return d;
        Object obj1;
        obj1;
        an.a((new StringBuilder("Exception while waiting for clientId: ")).append(obj1).toString());
        if (true) goto _L5; else goto _L4
_L4:
        if (true) goto _L7; else goto _L6
_L6:
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public final String a(String s)
    {
        if ("&cid".equals(s))
        {
            return c();
        } else
        {
            return null;
        }
    }

    final String b()
    {
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        Object obj;
        FileInputStream fileinputstream;
        int i;
        fileinputstream = c.openFileInput("gaClientId");
        obj = new byte[128];
        i = fileinputstream.read(((byte []) (obj)), 0, 128);
        if (fileinputstream.available() <= 0) goto _L2; else goto _L1
_L1:
        an.a("clientId file seems corrupted, deleting it.");
        fileinputstream.close();
        c.deleteFile("gaClientId");
        obj = obj1;
_L4:
        obj1 = obj;
        if (obj == null)
        {
            obj = UUID.randomUUID().toString().toLowerCase();
            obj1 = obj;
            if (!b(((String) (obj))))
            {
                obj1 = "0";
            }
        }
        return ((String) (obj1));
_L2:
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        an.a("clientId file seems empty, deleting it.");
        fileinputstream.close();
        c.deleteFile("gaClientId");
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        obj = new String(((byte []) (obj)), 0, i);
        try
        {
            fileinputstream.close();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        break MISSING_BLOCK_LABEL_147;
        obj;
        obj = obj2;
        an.a("Error reading clientId file, deleting it.");
        c.deleteFile("gaClientId");
        continue; /* Loop/switch isn't completed */
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        filenotfoundexception = ((FileNotFoundException) (obj1));
        if (true) goto _L4; else goto _L3
_L3:
    }

}
