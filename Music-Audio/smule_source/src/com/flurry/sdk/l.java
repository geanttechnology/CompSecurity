// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            hp, gx, gd

public final class l
{

    private static final String a = com/flurry/sdk/l.getSimpleName();

    public l()
    {
    }

    public static List a(File file)
    {
        Object obj;
        Object obj1;
        obj = null;
        if (file == null || !file.exists())
        {
            return Collections.emptyList();
        }
        az.b b1 = new az.b();
        ArrayList arraylist = new ArrayList();
        Object obj2;
        short word0;
        try
        {
            obj1 = new FileInputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            file = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            file = null;
            obj1 = null;
        }
        file = new DataInputStream(((java.io.InputStream) (obj1)));
_L1:
        word0 = file.readShort();
        if (1 != word0)
        {
            hp.a(file);
            hp.a(((java.io.Closeable) (obj1)));
            return arraylist;
        }
        arraylist.add(b1.b(file));
          goto _L1
        obj2;
        obj = obj1;
        obj1 = obj2;
_L5:
        gd.a(3, a, "Error loading legacy FreqCap data.", ((Throwable) (obj1)));
        hp.a(file);
        hp.a(((java.io.Closeable) (obj)));
        return arraylist;
_L3:
        hp.a(file);
        hp.a(((java.io.Closeable) (obj1)));
        throw obj;
        obj;
        file = null;
        continue; /* Loop/switch isn't completed */
        obj;
        continue; /* Loop/switch isn't completed */
        obj2;
        obj1 = obj;
        obj = obj2;
        if (true) goto _L3; else goto _L2
_L2:
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        file = null;
        obj = obj1;
        obj1 = exception;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static List b(File file)
    {
        Object obj;
        Object obj1;
        obj = null;
        if (file == null || !file.exists())
        {
            return Collections.emptyList();
        }
        Object obj2 = new at.a(new as.a());
        ArrayList arraylist = new ArrayList();
        Exception exception;
        short word0;
        try
        {
            obj1 = new FileInputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            file = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            file = null;
            obj1 = null;
        }
        file = new DataInputStream(((java.io.InputStream) (obj1)));
        if (46586 != file.readUnsignedShort())
        {
            throw new IOException("Unexpected data format");
        }
          goto _L1
        obj2;
        obj = obj1;
        obj1 = obj2;
_L7:
        gd.a(3, a, "Error loading legacy AdLog data.", ((Throwable) (obj1)));
        hp.a(file);
        hp.a(((java.io.Closeable) (obj)));
        return arraylist;
_L3:
        arraylist.add(((gx) (obj2)).b(file));
_L1:
        word0 = file.readShort();
        if (1 == word0) goto _L3; else goto _L2
_L2:
        hp.a(file);
        hp.a(((java.io.Closeable) (obj1)));
        return arraylist;
_L5:
        hp.a(file);
        hp.a(((java.io.Closeable) (obj1)));
        throw obj;
        obj;
        file = null;
        continue; /* Loop/switch isn't completed */
        obj;
        continue; /* Loop/switch isn't completed */
        exception;
        obj1 = obj;
        obj = exception;
        if (true) goto _L5; else goto _L4
_L4:
        break MISSING_BLOCK_LABEL_50;
        Exception exception1;
        exception1;
        file = null;
        obj = obj1;
        obj1 = exception1;
        if (true) goto _L7; else goto _L6
_L6:
    }

}
