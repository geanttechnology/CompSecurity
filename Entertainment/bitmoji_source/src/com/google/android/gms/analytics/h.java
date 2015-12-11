// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

// Referenced classes of package com.google.android.gms.analytics:
//            m, aa

class h
    implements m
{

    private static final Object qI = new Object();
    private static h qW;
    private final Context mContext;
    private String qX;
    private boolean qY;
    private final Object qZ = new Object();

    protected h(Context context)
    {
        qY = false;
        mContext = context;
        bx();
    }

    static Object a(h h1)
    {
        return h1.qZ;
    }

    static String a(h h1, String s)
    {
        h1.qX = s;
        return s;
    }

    static boolean a(h h1, boolean flag)
    {
        h1.qY = flag;
        return flag;
    }

    public static h bu()
    {
        h h1;
        synchronized (qI)
        {
            h1 = qW;
        }
        return h1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private String bv()
    {
        if (qY) goto _L2; else goto _L1
_L1:
        Object obj = qZ;
        obj;
        JVM INSTR monitorenter ;
        if (qY) goto _L2; else goto _L3
_L3:
        aa.v("Waiting for clientId to load");
_L7:
        qZ.wait();
_L5:
        if (!qY)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        aa.v("Loaded clientId");
        return qX;
        Object obj1;
        obj1;
        aa.t((new StringBuilder()).append("Exception while waiting for clientId: ").append(obj1).toString());
        if (true) goto _L5; else goto _L4
_L4:
        if (true) goto _L7; else goto _L6
_L6:
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    private void bx()
    {
        (new Thread("client_id_fetcher") {

            final h ra;

            public void run()
            {
                synchronized (h.a(ra))
                {
                    h.a(ra, ra.by());
                    h.a(ra, true);
                    h.a(ra).notifyAll();
                }
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                ra = h.this;
                super(s);
            }
        }).start();
    }

    public static void n(Context context)
    {
        synchronized (qI)
        {
            if (qW == null)
            {
                qW = new h(context);
            }
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private boolean y(String s)
    {
        try
        {
            aa.v("Storing clientId.");
            FileOutputStream fileoutputstream = mContext.openFileOutput("gaClientId", 0);
            fileoutputstream.write(s.getBytes());
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aa.t("Error creating clientId file.");
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aa.t("Error writing to clientId file.");
            return false;
        }
        return true;
    }

    protected String bw()
    {
        String s;
        String s1;
        s1 = UUID.randomUUID().toString().toLowerCase();
        s = s1;
        if (!y(s1))
        {
            s = "0";
        }
        return s;
        Exception exception;
        exception;
        return null;
    }

    String by()
    {
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        Object obj;
        FileInputStream fileinputstream;
        int i;
        fileinputstream = mContext.openFileInput("gaClientId");
        obj = new byte[128];
        i = fileinputstream.read(((byte []) (obj)), 0, 128);
        if (fileinputstream.available() <= 0) goto _L2; else goto _L1
_L1:
        aa.t("clientId file seems corrupted, deleting it.");
        fileinputstream.close();
        mContext.deleteFile("gaClientId");
        obj = obj1;
_L4:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = bw();
        }
        return ((String) (obj1));
_L2:
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        aa.t("clientId file seems empty, deleting it.");
        fileinputstream.close();
        mContext.deleteFile("gaClientId");
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
        break MISSING_BLOCK_LABEL_129;
        obj;
        obj = obj2;
        aa.t("Error reading clientId file, deleting it.");
        mContext.deleteFile("gaClientId");
        continue; /* Loop/switch isn't completed */
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        filenotfoundexception = ((FileNotFoundException) (obj1));
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getValue(String s)
    {
        if ("&cid".equals(s))
        {
            return bv();
        } else
        {
            return null;
        }
    }

    public boolean x(String s)
    {
        return "&cid".equals(s);
    }

}
