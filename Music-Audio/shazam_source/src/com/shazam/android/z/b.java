// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.z;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.shazam.b.c.a;
import com.shazam.h.i;
import com.shazam.h.j;
import com.shazam.h.o;
import java.io.BufferedInputStream;
import java.net.URL;
import java.util.concurrent.Callable;

public final class b
    implements Callable
{

    private final i a;
    private final String b;

    public b(i k, String s)
    {
        a = k;
        b = s;
    }

    private Bitmap a()
    {
        Object obj1;
        Object obj2;
        URL url;
        obj2 = null;
        obj1 = null;
        url = com.shazam.b.c.a.a(b);
        Object obj = a.a(url).b;
        Exception exception;
        try
        {
            obj1 = new BufferedInputStream(((java.io.InputStream) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            Object obj3 = null;
            obj1 = obj;
            obj = obj3;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj1 = null;
            obj2 = obj;
            obj = exception;
            continue; /* Loop/switch isn't completed */
        }
        obj2 = BitmapFactory.decodeStream(((java.io.InputStream) (obj1)));
        org.a.a.a.b.a(((java.io.InputStream) (obj1)));
        org.a.a.a.b.a(((java.io.InputStream) (obj)));
        return ((Bitmap) (obj2));
        obj2;
        obj = null;
_L4:
        throw new com.shazam.f.f.a((new StringBuilder("Failed to get image from ")).append(url.toString()).toString(), ((Throwable) (obj2)));
        exception;
        obj2 = obj1;
        obj1 = obj;
        obj = exception;
_L2:
        org.a.a.a.b.a(((java.io.InputStream) (obj1)));
        org.a.a.a.b.a(((java.io.InputStream) (obj2)));
        throw obj;
        obj;
        obj1 = null;
        continue; /* Loop/switch isn't completed */
        exception;
        obj2 = obj;
        obj = exception;
        if (true) goto _L2; else goto _L1
_L1:
        break MISSING_BLOCK_LABEL_37;
        obj2;
        Object obj4 = obj;
        obj = obj1;
        obj1 = obj4;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final Object call()
    {
        return a();
    }
}
