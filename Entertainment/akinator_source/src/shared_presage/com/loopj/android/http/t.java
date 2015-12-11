// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            ResponseHandlerInterface

final class t
    implements HttpEntity
{
    private final class a
    {

        public File a;
        public byte b[];
        final t c;

        private byte[] a(String s, String s1, String s2)
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            try
            {
                bytearrayoutputstream.write(t.a(c));
                t t1 = c;
                bytearrayoutputstream.write(t.b(s, s1));
                s = c;
                bytearrayoutputstream.write(t.a(s2));
                bytearrayoutputstream.write(t.a());
                bytearrayoutputstream.write(t.b());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("SimpleMultipartEntity", "createHeader ByteArrayOutputStream exception", s);
            }
            return bytearrayoutputstream.toByteArray();
        }

        public a(String s, File file, String s1)
        {
            c = t.this;
            super();
            b = a(s, file.getName(), s1);
            a = file;
        }
    }


    private static final byte a[] = "\r\n".getBytes();
    private static final byte b[] = "Content-Transfer-Encoding: binary\r\n".getBytes();
    private static final char c[] = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String d;
    private byte e[];
    private byte f[];
    private boolean g;
    private List h;
    private ByteArrayOutputStream i;
    private ResponseHandlerInterface j;
    private int k;
    private int l;

    public t(ResponseHandlerInterface responsehandlerinterface)
    {
        int i1 = 0;
        super();
        g = false;
        h = new ArrayList();
        i = new ByteArrayOutputStream();
        StringBuilder stringbuilder = new StringBuilder();
        Random random = new Random();
        for (; i1 < 30; i1++)
        {
            stringbuilder.append(c[random.nextInt(c.length)]);
        }

        d = stringbuilder.toString();
        e = (new StringBuilder("--")).append(d).append("\r\n").toString().getBytes();
        f = (new StringBuilder("--")).append(d).append("--\r\n").toString().getBytes();
        j = responsehandlerinterface;
    }

    private void a(int i1)
    {
        k = k + i1;
        j.sendProgressMessage(k, l);
    }

    static byte[] a()
    {
        return b;
    }

    static byte[] a(String s)
    {
        return b(s);
    }

    static byte[] a(t t1)
    {
        return t1.e;
    }

    static byte[] b()
    {
        return a;
    }

    private static byte[] b(String s)
    {
        return (new StringBuilder("Content-Type: ")).append(s).append("\r\n").toString().getBytes();
    }

    static byte[] b(String s, String s1)
    {
        return c(s, s1);
    }

    private static byte[] c(String s, String s1)
    {
        return (new StringBuilder("Content-Disposition: form-data; name=\"")).append(s).append("\"; filename=\"").append(s1).append("\"\r\n").toString().getBytes();
    }

    public final void a(String s, File file, String s1)
    {
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "application/octet-stream";
        }
        h.add(new a(s, file, s2));
    }

    public final void a(String s, String s1)
    {
        try
        {
            i.write(e);
            i.write((new StringBuilder("Content-Disposition: form-data; name=\"")).append(s).append("\"\r\n").toString().getBytes());
            i.write(b("text/plain; charset=UTF-8"));
            i.write(a);
            i.write(s1.getBytes());
            i.write(a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("SimpleMultipartEntity", "addPart ByteArrayOutputStream exception", s);
        }
    }

    public final void a(String s, String s1, InputStream inputstream, String s2)
    {
        String s3 = s2;
        if (s2 == null)
        {
            s3 = "application/octet-stream";
        }
        i.write(e);
        i.write(c(s, s1));
        i.write(b(s3));
        i.write(b);
        i.write(a);
        s = new byte[4096];
        do
        {
            int i1 = inputstream.read(s);
            if (i1 == -1)
            {
                break;
            }
            i.write(s, 0, i1);
        } while (true);
        i.write(a);
        i.flush();
        try
        {
            inputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("SimpleMultipartEntity", "Cannot close input stream", s);
        }
    }

    public final void a(boolean flag)
    {
        g = flag;
    }

    public final void consumeContent()
    {
        if (isStreaming())
        {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        } else
        {
            return;
        }
    }

    public final InputStream getContent()
    {
        throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
    }

    public final Header getContentEncoding()
    {
        return null;
    }

    public final long getContentLength()
    {
        long l1 = i.size();
        for (Iterator iterator = h.iterator(); iterator.hasNext();)
        {
            a a1 = (a)iterator.next();
            long l2 = a1.a.length();
            l2 = (long)a1.b.length + l2;
            if (l2 < 0L)
            {
                return -1L;
            }
            l1 = l2 + l1;
        }

        return (long)f.length + l1;
    }

    public final Header getContentType()
    {
        return new BasicHeader("Content-Type", (new StringBuilder("multipart/form-data; boundary=")).append(d).toString());
    }

    public final boolean isChunked()
    {
        return false;
    }

    public final boolean isRepeatable()
    {
        return g;
    }

    public final boolean isStreaming()
    {
        return false;
    }

    public final void writeTo(OutputStream outputstream)
    {
        k = 0;
        l = (int)getContentLength();
        i.writeTo(outputstream);
        a(i.size());
        for (Iterator iterator = h.iterator(); iterator.hasNext();)
        {
            a a1 = (a)iterator.next();
            outputstream.write(a1.b);
            a1.c.a(a1.b.length);
            FileInputStream fileinputstream = new FileInputStream(a1.a);
            byte abyte0[] = new byte[4096];
            do
            {
                int i1 = fileinputstream.read(abyte0);
                if (i1 == -1)
                {
                    break;
                }
                outputstream.write(abyte0, 0, i1);
                a1.c.a(i1);
            } while (true);
            outputstream.write(a);
            a1.c.a(a.length);
            outputstream.flush();
            try
            {
                fileinputstream.close();
            }
            catch (IOException ioexception)
            {
                Log.w("SimpleMultipartEntity", "Cannot close input stream", ioexception);
            }
        }

        outputstream.write(f);
        a(f.length);
    }

}
