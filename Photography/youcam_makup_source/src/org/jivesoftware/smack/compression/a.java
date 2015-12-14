// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.compression;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

// Referenced classes of package org.jivesoftware.smack.compression:
//            XMPPInputOutputStream

public class a extends XMPPInputOutputStream
{

    private static final Method c;
    private static final boolean d;

    public a()
    {
        b = "zlib";
    }

    static boolean b()
    {
        return d;
    }

    static Method c()
    {
        return c;
    }

    public InputStream a(InputStream inputstream)
    {
        return new InflaterInputStream(inputstream, new Inflater(), 512) {

            final a a;

            public int available()
            {
                if (inf.needsInput())
                {
                    return 0;
                } else
                {
                    return super.available();
                }
            }

            
            {
                a = a.this;
                super(inputstream, inflater, i);
            }
        };
    }

    public OutputStream a(OutputStream outputstream)
    {
        byte byte0;
        if (a == XMPPInputOutputStream.FlushMethod.b)
        {
            byte0 = 2;
        } else
        {
            byte0 = 3;
        }
        return new DeflaterOutputStream(outputstream, new Deflater(-1), byte0) {

            final int a;
            final a b;

            public void flush()
            {
                if (!a.b())
                {
                    super.flush();
                    return;
                }
_L1:
                int i;
                try
                {
                    i = ((Integer)a.c().invoke(def, new Object[] {
                        buf, Integer.valueOf(0), Integer.valueOf(buf.length), Integer.valueOf(a)
                    })).intValue();
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    throw new IOException("Can't flush");
                }
                catch (IllegalAccessException illegalaccessexception)
                {
                    throw new IOException("Can't flush");
                }
                catch (InvocationTargetException invocationtargetexception)
                {
                    throw new IOException("Can't flush");
                }
                if (i == 0)
                {
                    break MISSING_BLOCK_LABEL_120;
                }
                out.write(buf, 0, i);
                  goto _L1
                super.flush();
                return;
            }

            
            {
                b = a.this;
                a = i;
                super(outputstream, deflater);
            }
        };
    }

    public boolean a()
    {
        return d;
    }

    static 
    {
        Method method = null;
        Method method1 = java/util/zip/Deflater.getMethod("deflate", new Class[] {
            [B, Integer.TYPE, Integer.TYPE, Integer.TYPE
        });
        method = method1;
_L2:
        c = method;
        boolean flag;
        if (c != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
        return;
        Object obj;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
