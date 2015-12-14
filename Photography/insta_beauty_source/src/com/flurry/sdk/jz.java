// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package com.flurry.sdk:
//            kz, ld, kg, lb, 
//            lt, ls, le

public class jz
{

    private static final String a = com/flurry/sdk/jz.getSimpleName();
    private final File b;
    private final lb c;

    public jz(File file, String s, int i, le le)
    {
        b = file;
        c = new kz(new ld(s, i, le));
    }

    public Object a()
    {
        Object obj1;
        Object obj4;
        obj4 = null;
        obj1 = null;
        if (b != null) goto _L2; else goto _L1
_L1:
        return obj1;
_L2:
        boolean flag;
        if (!b.exists())
        {
            kg.a(5, a, (new StringBuilder()).append("No data to read for file:").append(b.getName()).toString());
            return null;
        }
        flag = false;
        obj1 = new FileInputStream(b);
        Object obj = obj1;
        Object obj2 = c.b(((java.io.InputStream) (obj1)));
        obj = obj2;
        lt.a(((java.io.Closeable) (obj1)));
_L4:
        obj1 = obj;
        if (flag)
        {
            kg.a(3, a, (new StringBuilder()).append("Deleting data file:").append(b.getName()).toString());
            b.delete();
            return obj;
        }
        if (true) goto _L1; else goto _L3
_L3:
        Object obj3;
        obj3;
        obj1 = null;
_L7:
        obj = obj1;
        kg.a(3, a, (new StringBuilder()).append("Error reading data file:").append(b.getName()).toString(), ((Throwable) (obj3)));
        flag = true;
        lt.a(((java.io.Closeable) (obj1)));
        obj = obj4;
          goto _L4
        obj;
        obj3 = null;
        obj1 = obj;
_L6:
        lt.a(((java.io.Closeable) (obj3)));
        throw obj1;
        obj1;
        obj3 = obj;
        if (true) goto _L6; else goto _L5
_L5:
        obj3;
          goto _L7
    }

    public void a(Object obj)
    {
        Object obj2;
        Object obj3;
        boolean flag;
        flag = false;
        obj2 = null;
        obj3 = null;
        if (obj != null) goto _L2; else goto _L1
_L1:
        kg.a(3, a, (new StringBuilder()).append("No data to write for file:").append(b.getName()).toString());
        flag = true;
_L5:
        if (flag)
        {
            kg.a(3, a, (new StringBuilder()).append("Deleting data file:").append(b.getName()).toString());
            b.delete();
        }
        return;
_L2:
        Object obj1 = obj2;
        if (ls.a(b)) goto _L4; else goto _L3
_L3:
        obj1 = obj2;
        try
        {
            throw new IOException("Cannot create parent directory!");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            obj = obj3;
        }
        finally { }
_L8:
        obj1 = obj;
        kg.a(3, a, (new StringBuilder()).append("Error writing data file:").append(b.getName()).toString(), ((Throwable) (obj2)));
        lt.a(((java.io.Closeable) (obj)));
        flag = true;
          goto _L5
_L4:
        obj1 = obj2;
        obj2 = new FileOutputStream(b);
        c.a(((java.io.OutputStream) (obj2)), obj);
        lt.a(((java.io.Closeable) (obj2)));
          goto _L5
_L7:
        lt.a(((java.io.Closeable) (obj1)));
        throw obj;
        obj;
        obj1 = obj2;
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
        obj = obj2;
        obj2 = exception;
          goto _L8
    }

    public boolean b()
    {
        if (b == null)
        {
            return false;
        } else
        {
            return b.delete();
        }
    }

}
