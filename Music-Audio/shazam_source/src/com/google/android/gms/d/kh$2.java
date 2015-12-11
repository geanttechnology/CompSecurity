// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.e.aj;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.d:
//            kh

final class b
    implements Runnable
{

    final String a;
    final byte b[];
    final kh c;

    public final void run()
    {
        Object obj;
        Object obj1;
        File file;
        obj1 = c;
        obj = a;
        byte abyte0[] = b;
        file = ((kh) (obj1)).b(((String) (obj)));
        try
        {
            obj1 = new FileOutputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            aj.a("Error opening resource file for writing");
            return;
        }
        ((FileOutputStream) (obj1)).write(abyte0);
        try
        {
            ((FileOutputStream) (obj1)).close();
            (new StringBuilder("Resource ")).append(((String) (obj))).append(" saved on Disk.");
            aj.d();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            aj.a("Error closing stream for writing resource to disk");
        }
        return;
        Object obj2;
        obj2;
        aj.a("Error writing resource to disk. Removing resource from disk");
        file.delete();
        try
        {
            ((FileOutputStream) (obj1)).close();
            (new StringBuilder("Resource ")).append(((String) (obj))).append(" saved on Disk.");
            aj.d();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            aj.a("Error closing stream for writing resource to disk");
        }
        return;
        obj2;
        try
        {
            ((FileOutputStream) (obj1)).close();
            (new StringBuilder("Resource ")).append(((String) (obj))).append(" saved on Disk.");
            aj.d();
        }
        catch (IOException ioexception)
        {
            aj.a("Error closing stream for writing resource to disk");
        }
        throw obj2;
    }

    (kh kh1, String s, byte abyte0[])
    {
        c = kh1;
        a = s;
        b = abyte0;
        super();
    }
}
