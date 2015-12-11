// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import c.a.a.a.a.b.l;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

// Referenced classes of package c.a.a.a:
//            e, q, p

final class j
    implements Callable
{

    private String a;

    j(String s)
    {
        a = s;
    }

    private static p a(ZipEntry zipentry, ZipFile zipfile)
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
            throw new IllegalStateException((new StringBuilder("Invalid format of fabric file,")).append(zipentry.getName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally { }
_L5:
        zipfile = inputstream;
        e.d().c("Fabric", (new StringBuilder("Error when parsing fabric properties ")).append(zipentry.getName()).toString(), ((Throwable) (obj)));
        l.a(inputstream);
        return null;
_L3:
        zipfile = inputstream;
        obj = new p(((String) (obj)), s, ((String) (obj1)));
        l.a(inputstream);
        return ((p) (obj));
        zipentry;
        zipfile = null;
        l.a(zipfile);
        throw zipentry;
        obj;
        inputstream = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private Map a()
    {
        HashMap hashmap = new HashMap();
        long l1 = SystemClock.elapsedRealtime();
        ZipFile zipfile = new ZipFile(a);
        Enumeration enumeration = zipfile.entries();
        int i;
        for (i = 0; enumeration.hasMoreElements(); i++)
        {
            Object obj = (ZipEntry)enumeration.nextElement();
            if (!((ZipEntry) (obj)).getName().startsWith("fabric/") || ((ZipEntry) (obj)).getName().length() <= 7)
            {
                continue;
            }
            obj = a(((ZipEntry) (obj)), zipfile);
            if (obj != null)
            {
                hashmap.put(((p) (obj)).a(), obj);
                e.d().b("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[] {
                    ((p) (obj)).a(), ((p) (obj)).b()
                }));
            }
        }

        try
        {
            zipfile.close();
        }
        catch (IOException ioexception) { }
        e.d().b("Fabric", (new StringBuilder("finish scanning in ")).append(SystemClock.elapsedRealtime() - l1).append(" reading:").append(i).toString());
        return hashmap;
    }

    public final Object call()
    {
        return a();
    }
}
