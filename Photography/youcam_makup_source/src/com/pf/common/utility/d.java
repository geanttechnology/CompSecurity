// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import android.graphics.Bitmap;
import com.pf.common.io.IO;
import com.pf.common.io.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.pf.common.utility:
//            c, a, f, g

public abstract class d
    implements c
{

    public static final d c;
    public static final d d;
    public static final d e;
    public static final d f;
    public static final d g;
    public static final d h;
    public static final d i;
    public static final d j;
    public static final d k;
    public static final d l;

    public d()
    {
    }

    public final Bitmap a(File file, android.graphics.BitmapFactory.Options options)
    {
        try
        {
            file = a(((InputStream) (new FileInputStream(file))), options, true);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw com.cyberlink.uma.internal.a.a(file);
        }
        return file;
    }

    public final Bitmap a(InputStream inputstream, android.graphics.BitmapFactory.Options options, boolean flag)
    {
        options = a(inputstream, options);
        if (flag)
        {
            IO.a(inputstream);
        }
        return options;
        options;
        if (flag)
        {
            IO.a(inputstream);
        }
        throw options;
    }

    public final void a(Bitmap bitmap, File file)
    {
        try
        {
            a(bitmap, ((OutputStream) (new FileOutputStream(file))), true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            throw com.cyberlink.uma.internal.a.a(bitmap);
        }
    }

    public final void a(Bitmap bitmap, OutputStream outputstream, boolean flag)
    {
        a(bitmap, outputstream);
        if (flag)
        {
            IO.a(outputstream);
        }
        return;
        bitmap;
        if (flag)
        {
            IO.a(outputstream);
        }
        throw bitmap;
    }

    static 
    {
        c = com.pf.common.utility.a.a(android.graphics.Bitmap.CompressFormat.PNG, 100);
        d = com.pf.common.utility.a.a(android.graphics.Bitmap.CompressFormat.JPEG, 90);
        e = com.pf.common.utility.a.a(android.graphics.Bitmap.CompressFormat.JPEG, 80);
        f = com.pf.common.utility.a.a(android.graphics.Bitmap.CompressFormat.JPEG, 50);
        g = com.pf.common.utility.Bitmaps.Raw.a;
        h = new f(a.a);
        i = new f(a.b);
        j = new f(a.c);
        k = com.pf.common.utility.g.a;
        l = c;
    }
}
