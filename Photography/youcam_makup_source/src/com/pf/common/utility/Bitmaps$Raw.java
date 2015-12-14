// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import android.graphics.Bitmap;
import com.cyberlink.uma.internal.a;
import com.pf.common.io.IO;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

// Referenced classes of package com.pf.common.utility:
//            j, i, Bitmaps

public final class nel
{

    public static final j a = new j(null);

    public static Bitmap a(InputStream inputstream, boolean flag)
    {
        Bitmap bitmap = a(IO.a(inputstream), flag);
        IO.a(inputstream);
        return bitmap;
        Exception exception;
        exception;
        IO.a(inputstream);
        throw exception;
    }

    public static Bitmap a(ReadableByteChannel readablebytechannel, boolean flag)
    {
        Bitmap bitmap;
        java.nio.ByteBuffer bytebuffer;
        bitmap = com.pf.common.utility.i.a(readablebytechannel).a();
        bytebuffer = Bitmaps.lockPixels(bitmap);
        IO.a(readablebytechannel, bytebuffer);
        Bitmaps.unlockPixels(bitmap);
        if (flag)
        {
            IO.a(readablebytechannel);
        }
        return bitmap;
        Exception exception;
        exception;
        Bitmaps.unlockPixels(bitmap);
        throw exception;
        Object obj;
        obj;
        throw com.cyberlink.uma.internal.a.a(((Throwable) (obj)));
        obj;
        if (flag)
        {
            IO.a(readablebytechannel);
        }
        throw obj;
    }

    public static void a(Bitmap bitmap, OutputStream outputstream, boolean flag)
    {
        a(bitmap, IO.a(outputstream), flag);
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

    public static void a(Bitmap bitmap, WritableByteChannel writablebytechannel, boolean flag)
    {
        java.nio.ByteBuffer bytebuffer;
        IO.a(writablebytechannel, (new i(bitmap)).b());
        bytebuffer = Bitmaps.lockPixels(bitmap);
        IO.a(writablebytechannel, bytebuffer);
        Bitmaps.unlockPixels(bitmap);
        if (flag)
        {
            IO.a(writablebytechannel);
        }
        return;
        Exception exception;
        exception;
        try
        {
            Bitmaps.unlockPixels(bitmap);
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap) { }
        finally
        {
            if (!flag) goto _L0; else goto _L0
        }
        throw com.cyberlink.uma.internal.a.a(bitmap);
        IO.a(writablebytechannel);
        throw bitmap;
    }

}
