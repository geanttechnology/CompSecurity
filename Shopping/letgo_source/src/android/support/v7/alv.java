// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

// Referenced classes of package android.support.v7:
//            alt, amc, amq, amb

class alv
    implements Callable
{

    final String a;

    alv(String s)
    {
        a = s;
    }

    private amb a(ZipEntry zipentry, ZipFile zipfile)
    {
        java.io.InputStream inputstream = zipfile.getInputStream(zipentry);
        zipfile = inputstream;
        Object obj1 = new Properties();
        zipfile = inputstream;
        ((Properties) (obj1)).load(inputstream);
        zipfile = inputstream;
        Object obj = ((Properties) (obj1)).getProperty("fabric-identifier");
        zipfile = inputstream;
        String s = ((Properties) (obj1)).getProperty("fabric-version");
        zipfile = inputstream;
        obj1 = ((Properties) (obj1)).getProperty("fabric-build-type");
        zipfile = inputstream;
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L2; else goto _L1
_L1:
        zipfile = inputstream;
        if (!TextUtils.isEmpty(s)) goto _L3; else goto _L2
_L2:
        zipfile = inputstream;
        try
        {
            throw new IllegalStateException((new StringBuilder()).append("Invalid format of fabric file,").append(zipentry.getName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally { }
_L5:
        zipfile = inputstream;
        alt.h().e("Fabric", (new StringBuilder()).append("Error when parsing fabric properties ").append(zipentry.getName()).toString(), ((Throwable) (obj)));
        amq.a(inputstream);
        return null;
_L3:
        zipfile = inputstream;
        obj = new amb(((String) (obj)), s, ((String) (obj1)));
        amq.a(inputstream);
        return ((amb) (obj));
        zipentry;
        zipfile = null;
        amq.a(zipfile);
        throw zipentry;
        obj;
        inputstream = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public Map a()
        throws Exception
    {
        HashMap hashmap = new HashMap();
        long l = SystemClock.elapsedRealtime();
        ZipFile zipfile = b();
        Enumeration enumeration = zipfile.entries();
        int i;
        for (i = 0; enumeration.hasMoreElements(); i++)
        {
            Object obj = (ZipEntry)enumeration.nextElement();
            if (!((ZipEntry) (obj)).getName().startsWith("fabric/") || ((ZipEntry) (obj)).getName().length() <= "fabric/".length())
            {
                continue;
            }
            obj = a(((ZipEntry) (obj)), zipfile);
            if (obj != null)
            {
                hashmap.put(((amb) (obj)).a(), obj);
                alt.h().b("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[] {
                    ((amb) (obj)).a(), ((amb) (obj)).b()
                }));
            }
        }

        if (zipfile != null)
        {
            try
            {
                zipfile.close();
            }
            catch (IOException ioexception) { }
        }
        alt.h().b("Fabric", (new StringBuilder()).append("finish scanning in ").append(SystemClock.elapsedRealtime() - l).append(" reading:").append(i).toString());
        return hashmap;
    }

    protected ZipFile b()
        throws IOException
    {
        return new ZipFile(a);
    }

    public Object call()
        throws Exception
    {
        return a();
    }
}
