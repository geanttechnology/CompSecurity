// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.facebook.internal.Logger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

// Referenced classes of package com.facebook:
//            Request

class logger
    implements ializer
{

    private boolean firstWrite;
    private final Logger logger;
    private final BufferedOutputStream outputStream;

    public transient void write(String s, Object aobj[])
    {
        if (firstWrite)
        {
            outputStream.write("--".getBytes());
            outputStream.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
            outputStream.write("\r\n".getBytes());
            firstWrite = false;
        }
        outputStream.write(String.format(s, aobj).getBytes());
    }

    public void writeBitmap(String s, Bitmap bitmap)
    {
        writeContentDisposition(s, s, "image/png");
        bitmap.compress(android.graphics.at.PNG, 100, outputStream);
        writeLine("", new Object[0]);
        writeRecordBoundary();
        logger.appendKeyValue((new StringBuilder()).append("    ").append(s).toString(), "<Image>");
    }

    public void writeBytes(String s, byte abyte0[])
    {
        writeContentDisposition(s, s, "content/unknown");
        outputStream.write(abyte0);
        writeLine("", new Object[0]);
        writeRecordBoundary();
        logger.appendKeyValue((new StringBuilder()).append("    ").append(s).toString(), String.format("<Data: %d>", new Object[] {
            Integer.valueOf(abyte0.length)
        }));
    }

    public void writeContentDisposition(String s, String s1, String s2)
    {
        write("Content-Disposition: form-data; name=\"%s\"", new Object[] {
            s
        });
        if (s1 != null)
        {
            write("; filename=\"%s\"", new Object[] {
                s1
            });
        }
        writeLine("", new Object[0]);
        if (s2 != null)
        {
            writeLine("%s: %s", new Object[] {
                "Content-Type", s2
            });
        }
        writeLine("", new Object[0]);
    }

    public void writeFile(String s, ParcelFileDescriptor parcelfiledescriptor)
    {
        Object obj;
        obj = null;
        writeContentDisposition(s, s, "content/unknown");
        parcelfiledescriptor = new android.os.r.AutoCloseInputStream(parcelfiledescriptor);
        BufferedInputStream bufferedinputstream = new BufferedInputStream(parcelfiledescriptor);
        obj = new byte[8192];
        int i = 0;
_L2:
        int j = bufferedinputstream.read(((byte []) (obj)));
        if (j == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        outputStream.write(((byte []) (obj)), 0, j);
        i += j;
        if (true) goto _L2; else goto _L1
_L1:
        bufferedinputstream.close();
        parcelfiledescriptor.close();
        writeLine("", new Object[0]);
        writeRecordBoundary();
        logger.appendKeyValue((new StringBuilder()).append("    ").append(s).toString(), String.format("<Data: %d>", new Object[] {
            Integer.valueOf(i)
        }));
        return;
        s;
        parcelfiledescriptor = null;
_L4:
        if (parcelfiledescriptor != null)
        {
            parcelfiledescriptor.close();
        }
        if (obj != null)
        {
            ((android.os.r.AutoCloseInputStream) (obj)).close();
        }
        throw s;
        s;
        bufferedinputstream = null;
        obj = parcelfiledescriptor;
        parcelfiledescriptor = bufferedinputstream;
        continue; /* Loop/switch isn't completed */
        s;
        obj = parcelfiledescriptor;
        parcelfiledescriptor = bufferedinputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public transient void writeLine(String s, Object aobj[])
    {
        write(s, aobj);
        write("\r\n", new Object[0]);
    }

    public void writeObject(String s, Object obj)
    {
        if (Request.access$100(obj))
        {
            writeString(s, Request.access$200(obj));
            return;
        }
        if (obj instanceof Bitmap)
        {
            writeBitmap(s, (Bitmap)obj);
            return;
        }
        if (obj instanceof byte[])
        {
            writeBytes(s, (byte[])obj);
            return;
        }
        if (obj instanceof ParcelFileDescriptor)
        {
            writeFile(s, (ParcelFileDescriptor)obj);
            return;
        } else
        {
            throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
        }
    }

    public void writeRecordBoundary()
    {
        writeLine("--%s", new Object[] {
            "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
        });
    }

    public void writeString(String s, String s1)
    {
        writeContentDisposition(s, null, null);
        writeLine("%s", new Object[] {
            s1
        });
        writeRecordBoundary();
        if (logger != null)
        {
            logger.appendKeyValue((new StringBuilder()).append("    ").append(s).toString(), s1);
        }
    }

    public on(BufferedOutputStream bufferedoutputstream, Logger logger1)
    {
        firstWrite = true;
        outputStream = bufferedoutputstream;
        logger = logger1;
    }
}
