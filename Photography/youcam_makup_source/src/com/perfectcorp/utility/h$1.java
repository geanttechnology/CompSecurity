// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// Referenced classes of package com.perfectcorp.utility:
//            j, h, i, e

final class nit> extends j
{

    final Context a;

    protected volatile Object a(Object obj)
    {
        return a((i)obj);
    }

    protected String a(i k)
    {
        File file = new File(k.b);
        if (!file.isDirectory())
        {
            file.mkdirs();
        }
        if (!k.a.startsWith("assets://")) goto _L2; else goto _L1
_L1:
        Object obj = a.getAssets().open(h.a(k.a));
_L6:
        byte abyte0[];
        obj = new ZipInputStream(((java.io.InputStream) (obj)));
        abyte0 = new byte[1024];
_L5:
        Object obj1 = ((ZipInputStream) (obj)).getNextEntry();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        String s;
        e.a(new Object[] {
            ((ZipEntry) (obj1)).getName()
        });
        s = h.a(new String[] {
            k.b, ((ZipEntry) (obj1)).getName()
        });
        if (!((ZipEntry) (obj1)).isDirectory()) goto _L4; else goto _L3
_L3:
        obj1 = new File(s);
        if (!((File) (obj1)).isDirectory())
        {
            ((File) (obj1)).mkdirs();
        }
          goto _L5
        try
        {
            ((ZipInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            e.e(new Object[] {
                obj
            });
        }
        return k.b;
_L2:
        obj = new FileInputStream(k.a);
          goto _L6
_L4:
        l = s.lastIndexOf(File.separatorChar);
        obj2 = s.substring(0, l);
        s = s.substring(l);
        obj2 = new File(((String) (obj2)));
        ((File) (obj2)).mkdirs();
        l1 = ((ZipEntry) (obj1)).getSize();
        obj1 = new FileOutputStream(new File(((File) (obj2)), s));
_L8:
        if (l1 <= 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        l = ((ZipInputStream) (obj)).read(abyte0, 0, (int)Math.min(l1, abyte0.length));
        ((FileOutputStream) (obj1)).write(abyte0, 0, l);
        l1 -= l;
        if (true) goto _L8; else goto _L7
_L7:
        ((ZipInputStream) (obj)).closeEntry();
        ((FileOutputStream) (obj1)).close();
          goto _L5
    }

    (Context context)
    {
        a = context;
        super();
    }
}
