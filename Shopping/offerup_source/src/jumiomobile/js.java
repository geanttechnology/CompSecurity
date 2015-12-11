// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.clientlib.impl.livenessAndTM.FrameProcessorTemplateMatcher;
import com.jumio.clientlib.impl.livenessAndTM.LibImage;
import com.jumio.clientlib.impl.livenessAndTM.PixelFormatType;

// Referenced classes of package jumiomobile:
//            jk, ab, ao, l, 
//            n

class js extends Thread
{

    final jk a;

    public js(jk jk1, byte abyte0[])
    {
        a = jk1;
        super();
        setName("TM Task");
        try
        {
            jk.a(jk1, new byte[abyte0.length]);
            if (jk.c(jk1) == null || jk.c(jk1).length != abyte0.length)
            {
                throw new IllegalStateException("dataBuffer may not be null and must match data in size!");
            }
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            jk1.d();
            ab.a(abyte0);
            return;
        }
        System.arraycopy(abyte0, 0, jk.c(jk1), 0, abyte0.length);
        return;
    }

    public void run()
    {
        int i;
        int j;
        if (jk.d(a).f())
        {
            i = jk.e(a).c.b;
            j = jk.f(a).c.a;
        } else
        {
            i = jk.g(a).c.a;
            j = jk.h(a).c.b;
        }
        a.b(jk.c(a), i, j, false);
        try
        {
            LibImage libimage = new LibImage(jk.c(a), PixelFormatType.PIXEL_FORMAT_YUV420_NV21, i, j, i, 1, 1, jk.i(a), 0);
            jk.j(a).pushFrame(libimage);
            return;
        }
        catch (Exception exception)
        {
            ab.a((new StringBuilder("Error pushing Frame to TemplateMatcherEngine: ")).append(exception.getMessage()).toString());
            ab.a(exception);
            return;
        }
    }
}
