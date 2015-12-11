// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

// Referenced classes of package com.medialets.advertising:
//            d, ae, AdManager, AdManagerService, 
//            a, aa

final class w
{

    private ae a;

    public w(ae ae1)
    {
        a = ae1;
    }

    private boolean b()
    {
        d d1;
        String s;
        Object obj;
        String s1;
        Object obj1;
        d1 = com.medialets.advertising.d.a(d.DEFAULT_USERAGENT, true);
        obj1 = new HttpGet(a.s().trim());
        s = a.s();
        obj = s.substring(s.lastIndexOf("/") + 1);
        s1 = String.format("%s/%s", new Object[] {
            AdManager.getInstance().mService.getFilesDir(), "medialytics"
        });
        com.medialets.advertising.a.d((new StringBuilder()).append("Fetching bundle: ").append(s).toString());
        int i;
        obj1 = d1.execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)));
        i = ((HttpResponse) (obj1)).getStatusLine().getStatusCode();
        if (i == 200)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        com.medialets.advertising.a.c((new StringBuilder()).append("Error downloading bundle: ").append(i).toString());
        d1.a();
        return false;
        try
        {
            File file = new File(s1);
            if (!file.exists() && !file.mkdirs())
            {
                throw new IOException("Could not create local cache dir");
            }
            break MISSING_BLOCK_LABEL_235;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            d1.a();
            throw exception;
        }
        com.medialets.advertising.a.c((new StringBuilder()).append("Error downloading bundle: ").append(s).append(": ").append(((Exception) (obj)).toString()).toString());
        d1.a();
        return false;
        aa.a(new BufferedInputStream(((HttpResponse) (obj1)).getEntity().getContent(), 8192), new RandomAccessFile(String.format("%s/%s", new Object[] {
            s1, obj
        }), "rws"), 8192);
        d1.a();
        return true;
    }

    private boolean c()
    {
        Object obj;
        Object obj2;
        String s;
        obj = AdManager.getInstance().mService.getFilesDir();
        s = a.s();
        obj2 = new File(String.format("%s/%s/%s", new Object[] {
            obj, "medialytics", s.substring(s.lastIndexOf("/") + 1)
        }));
        Object obj1 = new ZipFile(((File) (obj2)));
        Enumeration enumeration = ((ZipFile) (obj1)).entries();
_L4:
        if (!enumeration.hasMoreElements()) goto _L2; else goto _L1
_L1:
        Object obj3 = (ZipEntry)enumeration.nextElement();
        if (((ZipEntry) (obj3)).getName().contains("MACOSX")) goto _L4; else goto _L3
_L3:
        if (!((ZipEntry) (obj3)).isDirectory()) goto _L6; else goto _L5
_L5:
        obj3 = new File(String.format("%s/%s/%s", new Object[] {
            obj, "medialytics", ((ZipEntry) (obj3)).getName()
        }));
        if (!((File) (obj3)).exists() && !((File) (obj3)).mkdirs())
        {
            throw new IOException((new StringBuilder()).append("Could not create dir:").append(obj3).toString());
        }
          goto _L4
        obj2;
        obj = obj1;
        obj1 = obj2;
_L9:
        com.medialets.advertising.a.c((new StringBuilder()).append("Error unzipping the creative bundle: ").append(s).append(": ").append(((Exception) (obj1)).toString()).toString());
        if (obj != null)
        {
            try
            {
                ((ZipFile) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.medialets.advertising.a.c((new StringBuilder()).append("Problem closing file resources:").append(((Exception) (obj)).toString()).toString());
            }
        }
        return false;
_L6:
        aa.a(new BufferedInputStream(((ZipFile) (obj1)).getInputStream(((ZipEntry) (obj3))), 8192), new RandomAccessFile(String.format("%s/%s/%s", new Object[] {
            obj, "medialytics", ((ZipEntry) (obj3)).getName()
        }), "rws"));
          goto _L4
        obj;
_L8:
        if (obj1 != null)
        {
            try
            {
                ((ZipFile) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                com.medialets.advertising.a.c((new StringBuilder()).append("Problem closing file resources:").append(((Exception) (obj1)).toString()).toString());
            }
        }
        throw obj;
_L2:
        if (!((File) (obj2)).delete())
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Could not delete zipped bundle: ").append(obj2).toString());
        }
        try
        {
            ((ZipFile) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Problem closing file resources:").append(((Exception) (obj)).toString()).toString());
        }
        return true;
        obj;
        obj1 = null;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
        if (true) goto _L8; else goto _L7
_L7:
        obj1;
        obj = null;
          goto _L9
    }

    private boolean d()
    {
        AdManagerService admanagerservice = AdManager.getInstance().mService;
        String s = a.d();
        try
        {
            aa.a(admanagerservice.getAssets().open("mmbridge.js"), new RandomAccessFile(String.format("%s/%s/%s/mmbridge.js", new Object[] {
                admanagerservice.getFilesDir(), "medialytics", s
            }), "rws"));
        }
        catch (Exception exception)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Error writing bridge file to creative: ").append(s).append(": ").append(exception.toString()).toString());
            return false;
        }
        return true;
    }

    public final void a()
    {
        if (b() && c())
        {
            d();
            a.a(true);
        }
    }
}
