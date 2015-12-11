// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package cn.jpush.android.util:
//            n, p, x

final class o
    implements Runnable
{

    final String a;
    final String b;
    final p c;

    o(String s, String s1, p p1)
    {
        a = s;
        b = s1;
        c = p1;
        super();
    }

    public final void run()
    {
        Object obj;
        Object obj1;
        byte abyte0[];
        abyte0 = null;
        obj = n.a();
        obj1 = new HttpGet(a);
        obj = ((DefaultHttpClient) (obj)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)));
        if (((HttpResponse) (obj)).getStatusLine().getStatusCode() != 200) goto _L2; else goto _L1
_L1:
        long l;
        l = ((HttpResponse) (obj)).getEntity().getContentLength();
        int i = a.lastIndexOf("/");
        obj1 = a.substring(i + 1);
        obj1 = new File(b, ((String) (obj1)));
        if (!((File) (obj1)).exists()) goto _L4; else goto _L3
_L3:
        Object obj2;
        Object obj3;
        if (((File) (obj1)).length() == l && l != 0L)
        {
            int j;
            try
            {
                c.a(true, ((File) (obj1)).getAbsolutePath());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = null;
            }
            finally
            {
                obj3 = null;
            }
            obj1 = null;
            obj2 = abyte0;
            continue; /* Loop/switch isn't completed */
        }
        ((File) (obj1)).delete();
        ((File) (obj1)).createNewFile();
_L13:
        obj = ((HttpResponse) (obj)).getEntity().getContent();
        try
        {
            obj3 = new BufferedInputStream(((InputStream) (obj)));
        }
        catch (Exception exception)
        {
            obj3 = null;
            exception = ((Exception) (obj));
            obj2 = abyte0;
            obj = obj3;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj3 = null;
            obj2 = null;
            continue; /* Loop/switch isn't completed */
        }
        obj2 = new FileOutputStream(((File) (obj1)));
        abyte0 = new byte[1024];
_L7:
        j = ((BufferedInputStream) (obj3)).read(abyte0);
        if (j == -1) goto _L6; else goto _L5
_L5:
        ((FileOutputStream) (obj2)).write(abyte0, 0, j);
          goto _L7
        obj1;
        obj1 = obj;
        obj = obj3;
_L11:
        x.h();
        c.a(false, "");
        if (obj2 != null)
        {
            try
            {
                ((FileOutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2) { }
        }
        if (obj != null)
        {
            try
            {
                ((BufferedInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
        }
        break; /* Loop/switch isn't completed */
_L4:
        obj2 = new File(b);
        if (!((File) (obj2)).exists())
        {
            ((File) (obj2)).mkdirs();
        }
        ((File) (obj1)).createNewFile();
        continue; /* Loop/switch isn't completed */
_L6:
        ((FileOutputStream) (obj2)).flush();
        c.a(true, ((File) (obj1)).getAbsolutePath());
        if (obj2 != null)
        {
            try
            {
                ((FileOutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        if (obj3 != null)
        {
            try
            {
                ((BufferedInputStream) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
        }
        break; /* Loop/switch isn't completed */
_L2:
        c.a(false, "");
        return;
        obj = null;
        obj2 = null;
_L9:
        if (obj2 != null)
        {
            try
            {
                ((FileOutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2) { }
        }
        if (obj3 != null)
        {
            try
            {
                ((BufferedInputStream) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2) { }
        }
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw obj1;
        obj1;
        obj2 = null;
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        obj3;
        abyte0 = ((byte []) (obj1));
        obj1 = obj3;
        obj3 = obj;
        obj = abyte0;
        if (true) goto _L9; else goto _L8
_L8:
        break MISSING_BLOCK_LABEL_162;
        Exception exception1;
        exception1;
        exception1 = ((Exception) (obj));
        obj2 = abyte0;
        obj = obj3;
        if (true) goto _L11; else goto _L10
_L10:
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }
}
