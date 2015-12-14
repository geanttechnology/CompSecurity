// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;

import android.net.http.AndroidHttpClient;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ax;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a:
//            l

public class k extends ax
{

    private static final String a = com/cyberlink/youcammakeup/kernelctrl/networkmanager/a/k.getSimpleName();
    protected AtomicBoolean b;
    private final NetworkManager c;
    private final URI d;
    private final File e;
    private final l f;

    public k(NetworkManager networkmanager, URI uri, File file, l l1)
    {
        b = new AtomicBoolean(false);
        c = networkmanager;
        d = uri;
        e = file;
        f = l1;
    }

    public void a()
    {
        Object obj3;
        Object obj4;
        int i;
        i = 0;
        obj4 = null;
        obj3 = null;
        Object obj;
        long l1;
        obj = c.G();
        HttpGet httpget = new HttpGet();
        httpget.setURI(d);
        obj = ((AndroidHttpClient) (obj)).execute(httpget).getEntity();
        l1 = ((HttpEntity) (obj)).getContentLength();
        obj = ((HttpEntity) (obj)).getContent();
        int j = (int)l1;
        Object obj2;
        byte abyte0[];
        abyte0 = new byte[Math.max(Math.min(4096, j / 100), 512)];
        obj2 = new FileOutputStream(e);
        Object obj1 = new BufferedOutputStream(((java.io.OutputStream) (obj2)));
_L7:
        if (!b.get()) goto _L2; else goto _L1
_L1:
        f.c(null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        ((InputStream) (obj)).close();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        ((BufferedOutputStream) (obj1)).close();
        if (obj2 != null)
        {
            try
            {
                ((FileOutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        if (b.get())
        {
            e.delete();
        }
_L6:
        return;
_L2:
        j = ((InputStream) (obj)).read(abyte0);
        if (j >= 0) goto _L4; else goto _L3
_L3:
        ((BufferedOutputStream) (obj1)).flush();
        ((BufferedOutputStream) (obj1)).close();
        ((FileOutputStream) (obj2)).close();
        ((InputStream) (obj)).close();
        f.a(e);
        if (false)
        {
            a a1;
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
            continue; /* Loop/switch isn't completed */
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        throw new NullPointerException();
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
        throw new NullPointerException();
        if (!b.get()) goto _L6; else goto _L5
_L5:
        e.delete();
        return;
_L4:
        ((BufferedOutputStream) (obj1)).write(abyte0, 0, j);
        i += j;
        a1 = new a(i, l1);
        f.d(a1);
        if (j > 0) goto _L7; else goto _L3
        obj2;
        obj = null;
        obj1 = null;
_L11:
        e.delete();
        f.b(new bn(null, ((Exception) (obj2))));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        ((InputStream) (obj1)).close();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        ((BufferedOutputStream) (obj)).close();
        if (obj3 != null)
        {
            try
            {
                ((FileOutputStream) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        if (!b.get()) goto _L6; else goto _L8
_L8:
        e.delete();
        return;
        obj1;
        obj2 = null;
        obj = null;
        obj3 = obj4;
_L10:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_432;
        }
        ((InputStream) (obj)).close();
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_442;
        }
        ((BufferedOutputStream) (obj3)).close();
        if (obj2 != null)
        {
            try
            {
                ((FileOutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        if (b.get())
        {
            e.delete();
        }
        throw obj1;
        obj1;
        obj2 = null;
        obj3 = obj4;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj3 = obj4;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj3 = obj1;
        obj1 = exception;
        continue; /* Loop/switch isn't completed */
        Object obj8;
        obj8;
        Object obj5 = obj1;
        obj2 = obj3;
        obj1 = obj8;
        obj3 = obj;
        obj = obj5;
        if (true) goto _L10; else goto _L9
_L9:
        obj2;
        Object obj6 = null;
        obj1 = obj;
        obj = obj6;
          goto _L11
        obj8;
        Object obj7 = null;
        obj3 = obj2;
        obj1 = obj;
        obj2 = obj8;
        obj = obj7;
          goto _L11
        obj8;
        obj3 = obj2;
        InputStream inputstream = ((InputStream) (obj));
        obj2 = obj8;
        obj = obj1;
        obj1 = inputstream;
          goto _L11
    }

    public void a(bn bn1)
    {
        f.b(bn1);
    }

    public void d()
    {
        b.set(true);
    }

}
