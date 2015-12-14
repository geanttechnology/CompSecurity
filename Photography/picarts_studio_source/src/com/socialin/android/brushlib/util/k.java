// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.util;

import com.socialin.android.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class k
{

    private static final String a = com/socialin/android/brushlib/util/k.getSimpleName();

    private k()
    {
    }

    public static Object a(File file)
    {
        Object obj2 = null;
        Object obj = new ObjectInputStream(new FileInputStream(file));
        Object obj1 = obj;
        file = ((File) (((ObjectInputStream) (obj)).readObject()));
        try
        {
            ((ObjectInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
            });
            return file;
        }
_L2:
        return file;
        file;
        obj = null;
_L5:
        obj1 = obj;
        d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(file.getMessage()).toString()
        });
        file = obj2;
        if (obj == null) goto _L2; else goto _L1
_L1:
        try
        {
            ((ObjectInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(file.getMessage()).toString()
            });
            return null;
        }
        return null;
        file;
        obj1 = null;
_L4:
        if (obj1 != null)
        {
            try
            {
                ((ObjectInputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
                });
            }
        }
        throw file;
        file;
        if (true) goto _L4; else goto _L3
_L3:
        file;
          goto _L5
        file;
        obj = null;
          goto _L5
        file;
          goto _L5
    }

    public static void a(File file, Serializable serializable)
    {
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(new FileOutputStream(file));
        file = objectoutputstream;
        objectoutputstream.writeObject(serializable);
        objectoutputstream.close();
_L2:
        return;
        file;
        d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(file.getMessage()).toString()
        });
        return;
        IOException ioexception;
        ioexception;
        serializable = null;
_L5:
        file = serializable;
        d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
        });
        if (serializable == null) goto _L2; else goto _L1
_L1:
        try
        {
            serializable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(file.getMessage()).toString()
            });
        }
        return;
        serializable;
        file = null;
_L4:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(file.getMessage()).toString()
                });
            }
        }
        throw serializable;
        serializable;
        if (true) goto _L4; else goto _L3
_L3:
        ioexception;
        serializable = objectoutputstream;
          goto _L5
    }

}
