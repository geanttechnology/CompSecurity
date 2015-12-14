// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android;

import android.os.SystemClock;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

// Referenced classes of package io.fabric.sdk.android:
//            Fabric, Logger, KitInfo

class FabricKitsFinder
    implements Callable
{

    private static final String FABRIC_BUILD_TYPE_KEY = "fabric-build-type";
    static final String FABRIC_DIR = "fabric/";
    private static final String FABRIC_IDENTIFIER_KEY = "fabric-identifier";
    private static final String FABRIC_VERSION_KEY = "fabric-version";
    final String apkFileName;

    FabricKitsFinder(String s)
    {
        apkFileName = s;
    }

    private KitInfo loadKitInfo(ZipEntry zipentry, ZipFile zipfile)
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
        Fabric.getLogger().e("Fabric", (new StringBuilder()).append("Error when parsing fabric properties ").append(zipentry.getName()).toString(), ((Throwable) (obj)));
        CommonUtils.closeQuietly(inputstream);
        return null;
_L3:
        zipfile = inputstream;
        obj = new KitInfo(((String) (obj)), s, ((String) (obj1)));
        CommonUtils.closeQuietly(inputstream);
        return ((KitInfo) (obj));
        zipentry;
        zipfile = null;
        CommonUtils.closeQuietly(zipfile);
        throw zipentry;
        obj;
        inputstream = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public volatile Object call()
    {
        return call();
    }

    public Map call()
    {
        HashMap hashmap = new HashMap();
        long l = SystemClock.elapsedRealtime();
        ZipFile zipfile = loadApkFile();
        Enumeration enumeration = zipfile.entries();
        int i;
        for (i = 0; enumeration.hasMoreElements(); i++)
        {
            Object obj = (ZipEntry)enumeration.nextElement();
            if (!((ZipEntry) (obj)).getName().startsWith("fabric/") || ((ZipEntry) (obj)).getName().length() <= "fabric/".length())
            {
                continue;
            }
            obj = loadKitInfo(((ZipEntry) (obj)), zipfile);
            if (obj != null)
            {
                hashmap.put(((KitInfo) (obj)).getIdentifier(), obj);
                Fabric.getLogger().v("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[] {
                    ((KitInfo) (obj)).getIdentifier(), ((KitInfo) (obj)).getVersion()
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
        Fabric.getLogger().v("Fabric", (new StringBuilder()).append("finish scanning in ").append(SystemClock.elapsedRealtime() - l).append(" reading:").append(i).toString());
        return hashmap;
    }

    protected ZipFile loadApkFile()
    {
        return new ZipFile(apkFileName);
    }
}
