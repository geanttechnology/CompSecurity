// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.pf.common.utility.m;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.PrintWriter;

public class d
{

    public static String a(Throwable throwable)
    {
        Object obj;
        String s;
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        obj = null;
        s = null;
        Object obj1 = new PrintWriter(bytearrayoutputstream);
        throwable.printStackTrace(((PrintWriter) (obj1)));
        ((PrintWriter) (obj1)).flush();
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        ((PrintWriter) (obj1)).close();
        if (!((PrintWriter) (obj1)).checkError()) goto _L2; else goto _L3
_L3:
        obj = throwable.toString();
_L5:
        return ((String) (obj));
        obj;
        obj1 = s;
_L9:
        obj = obj1;
        s = throwable.toString();
        obj = s;
        if (obj1 == null) goto _L5; else goto _L4
_L4:
        ((PrintWriter) (obj1)).close();
        obj = s;
        if (!((PrintWriter) (obj1)).checkError()) goto _L5; else goto _L6
_L6:
        return throwable.toString();
        Exception exception1;
        exception1;
        obj1 = obj;
        obj = exception1;
_L8:
        if (obj1 != null)
        {
            ((PrintWriter) (obj1)).close();
            if (((PrintWriter) (obj1)).checkError())
            {
                return throwable.toString();
            }
        }
        throw obj;
_L2:
        return bytearrayoutputstream.toString();
        obj;
        if (true) goto _L8; else goto _L7
_L7:
        Exception exception;
        exception;
          goto _L9
    }

    public static boolean a(Closeable closeable)
    {
        if (closeable != null)
        {
            try
            {
                closeable.close();
            }
            // Misplaced declaration of an exception variable
            catch (Closeable closeable)
            {
                m.e("AssetUtils", a(((Throwable) (closeable))));
                return false;
            }
        }
        return true;
    }
}
