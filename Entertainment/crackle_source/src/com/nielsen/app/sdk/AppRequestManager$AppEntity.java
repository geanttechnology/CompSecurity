// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nielsen.app.sdk;

import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

// Referenced classes of package com.nielsen.app.sdk:
//            AppRequestManager, h, c

private class c
    implements HttpEntity
{
    public class FeedbackOutputStream extends FilterOutputStream
    {

        final AppRequestManager.AppEntity a;
        private int b;
        private String c;
        private int d;
        private int e;
        private int f;

        public void write(int i)
            throws IOException
        {
            out.write(i);
            b = b + 4;
            int j = b - d;
            i = j;
            if (j > e)
            {
                f = f + 1;
                d = d + e;
                if (AppRequestManager.AppEntity.a(a) != null && f < AppRequestManager.AppEntity.a(a).length)
                {
                    c = AppRequestManager.AppEntity.a(a)[f];
                }
                if (AppRequestManager.AppEntity.b(a) != null && f < AppRequestManager.AppEntity.b(a).length)
                {
                    e = AppRequestManager.AppEntity.b(a)[f];
                }
                i = b - d;
            }
            if (AppRequestManager.AppEntity.c(a) == null)
            {
                break MISSING_BLOCK_LABEL_225;
            }
            long l = h.g();
            AppRequestManager.b b1 = new AppRequestManager.b(a.a, 3, AppRequestManager.AppEntity.d(a), AppRequestManager.AppEntity.e(a), l, i, e, c, null);
            AppRequestManager.AppEntity.c(a).put(b1);
            return;
            InterruptedException interruptedexception;
            interruptedexception;
            com.nielsen.app.sdk.c.a(interruptedexception, true, 9, 'E', (new StringBuilder()).append("Request ").append(AppRequestManager.AppEntity.e(a)).append(" was interrupted while waiting to add data to the messaging queue. VERY unliquely event").toString(), new Object[0]);
            return;
        }

        public void write(byte abyte0[], int i, int j)
            throws IOException
        {
            out.write(abyte0, i, j);
            b = b + j;
            j = b - d;
            i = j;
            if (j > e)
            {
                f = f + 1;
                d = d + e;
                if (AppRequestManager.AppEntity.a(a) != null && f < AppRequestManager.AppEntity.a(a).length)
                {
                    c = AppRequestManager.AppEntity.a(a)[f];
                }
                if (AppRequestManager.AppEntity.b(a) != null && f < AppRequestManager.AppEntity.b(a).length)
                {
                    e = AppRequestManager.AppEntity.b(a)[f];
                }
                i = b - d;
            }
            if (AppRequestManager.AppEntity.c(a) == null)
            {
                break MISSING_BLOCK_LABEL_227;
            }
            long l = h.g();
            abyte0 = new AppRequestManager.b(a.a, 3, AppRequestManager.AppEntity.d(a), AppRequestManager.AppEntity.e(a), l, i, e, c, null);
            AppRequestManager.AppEntity.c(a).put(abyte0);
            return;
            abyte0;
            com.nielsen.app.sdk.c.a(abyte0, true, 9, 'E', (new StringBuilder()).append("Request ").append(AppRequestManager.AppEntity.e(a)).append(" was interrupted while waiting to add data to the messaging queue. VERY unliquely event").toString(), new Object[0]);
            return;
        }

        public FeedbackOutputStream(OutputStream outputstream)
        {
            a = AppRequestManager.AppEntity.this;
            super(outputstream);
            c = "";
            d = 0;
            e = 0;
            f = 0;
            b = 0;
            d = 0;
            if (AppRequestManager.AppEntity.a(AppRequestManager.AppEntity.this) != null && AppRequestManager.AppEntity.a(AppRequestManager.AppEntity.this).length < 0 && f >= 0)
            {
                c = AppRequestManager.AppEntity.a(AppRequestManager.AppEntity.this)[f];
                e = AppRequestManager.AppEntity.b(AppRequestManager.AppEntity.this)[f];
            }
        }
    }


    final AppRequestManager a;
    private int b[];
    private String c[];
    private String d;
    private BlockingQueue e;
    private int f;

    static String[] a(FeedbackOutputStream.a a1)
    {
        return a1.c;
    }

    static int[] b(c c1)
    {
        return c1.b;
    }

    static BlockingQueue c(b b1)
    {
        return b1.e;
    }

    static int d(e e1)
    {
        return e1.f;
    }

    static String e(f f1)
    {
        return f1.d;
    }

    public void consumeContent()
        throws IOException
    {
    }

    public InputStream getContent()
        throws IOException, IllegalStateException
    {
        return null;
    }

    public Header getContentEncoding()
    {
        return null;
    }

    public long getContentLength()
    {
        return 0L;
    }

    public Header getContentType()
    {
        return null;
    }

    public boolean isChunked()
    {
        return false;
    }

    public boolean isRepeatable()
    {
        return false;
    }

    public boolean isStreaming()
    {
        return false;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
    }

    public FeedbackOutputStream.f(AppRequestManager apprequestmanager, String s, int i, BlockingQueue blockingqueue, List list)
        throws InterruptedException
    {
        a = apprequestmanager;
        super();
        b = null;
        c = null;
        d = "";
        e = null;
        f = 0;
        int j;
        f = i;
        d = s;
        e = blockingqueue;
        j = list.size();
        b = new int[j];
        c = new String[j];
        i = 0;
_L7:
        if (i >= j) goto _L2; else goto _L1
_L1:
        int k;
        blockingqueue = (c)list.get(i);
        k = blockingqueue.c();
        s = blockingqueue.c();
        blockingqueue = blockingqueue.c();
        k;
        JVM INSTR tableswitch 1 2: default 276
    //                   1 228
    //                   2 228;
           goto _L3 _L4 _L4
_L3:
        if (e != null)
        {
            long l = h.g();
            s = (new StringBuilder()).append("Ignoring part <name, value> = <").append(blockingqueue).append(", ").append(s).append("> on a HTTP POST multipart request").toString();
            s = new e(apprequestmanager, 3, f, d, l, 0L, 0L, s, null);
            e.put(s);
        }
          goto _L5
_L4:
        s = new File(s);
        b[i] = (int)s.length();
        c[i] = s.getName();
          goto _L5
        apprequestmanager;
        com.nielsen.app.sdk.c.a(apprequestmanager, true, 'E', "Failed to instantiate the App SDK entity object", new Object[0]);
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
