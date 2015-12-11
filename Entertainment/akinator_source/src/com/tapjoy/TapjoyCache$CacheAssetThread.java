// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;
import java.util.concurrent.Callable;

// Referenced classes of package com.tapjoy:
//            TapjoyCache, TapjoyCacheMap, TapjoyCachedAssetData, TapjoyLog, 
//            TapjoyUtil

public class b
    implements Callable
{

    final TapjoyCache a;
    private URL b;
    private String c;
    private long d;

    public Boolean call()
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        TapjoyCache tapjoycache1;
        tapjoycache1 = null;
        obj2 = null;
        obj3 = null;
        obj1 = null;
        obj = a;
        obj = TapjoyCache.a(b.toString());
        if (!TapjoyCache.c(a).containsKey(obj)) goto _L2; else goto _L1
_L1:
        if (!(new File(((TapjoyCachedAssetData)TapjoyCache.c(a).get(obj)).getLocalFilePath())).exists()) goto _L4; else goto _L3
_L3:
        if (d != 0L)
        {
            ((TapjoyCachedAssetData)TapjoyCache.c(a).get(obj)).resetTimeToLive(d);
        } else
        {
            ((TapjoyCachedAssetData)TapjoyCache.c(a).get(obj)).resetTimeToLive(0x15180L);
        }
        if (TapjoyCache.a(a))
        {
            TapjoyLog.i("TapjoyCache", (new StringBuilder("Reseting time to live for ")).append(b.toString()).toString());
        }
        obj = TapjoyCache.b(a);
        obj1 = a;
        ((Vector) (obj)).remove(TapjoyCache.a(b.toString()));
        obj2 = Boolean.valueOf(true);
_L5:
        return ((Boolean) (obj2));
_L4:
        TapjoyCache.getInstance().removeAssetFromCache(((String) (obj)));
_L2:
        File file;
        long l = System.currentTimeMillis() / 1000L;
        try
        {
            obj = (new StringBuilder()).append(TapjoyCache.d(a)).append("/");
            TapjoyCache tapjoycache = a;
            file = new File(((StringBuilder) (obj)).append(TapjoyUtil.SHA256(TapjoyCache.a(b.toString()))).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = TapjoyCache.b(a);
            obj1 = a;
            ((Vector) (obj)).remove(TapjoyCache.a(b.toString()));
            return Boolean.valueOf(false);
        }
        if (TapjoyCache.a(a))
        {
            TapjoyLog.i("TapjoyCache", (new StringBuilder("Downloading and caching asset from: ")).append(b).append(" to ").append(file).toString());
        }
        obj = b.openConnection();
        ((URLConnection) (obj)).setConnectTimeout(15000);
        ((URLConnection) (obj)).setReadTimeout(30000);
        ((URLConnection) (obj)).connect();
        obj = new BufferedInputStream(((URLConnection) (obj)).getInputStream());
        obj2 = obj3;
        obj3 = obj;
        obj1 = new BufferedOutputStream(new FileOutputStream(file));
        TapjoyUtil.writeFileToDevice(((BufferedInputStream) (obj)), ((java.io.OutputStream) (obj1)));
        Exception exception1;
        Vector vector;
        try
        {
            ((BufferedInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        try
        {
            ((BufferedOutputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        obj = new TapjoyCachedAssetData(b.toString(), file.getAbsolutePath(), d);
        if (c != null)
        {
            ((TapjoyCachedAssetData) (obj)).setOfferID(c);
        }
        obj1 = TapjoyCache.c(a);
        obj2 = a;
        ((TapjoyCacheMap) (obj1)).put(TapjoyCache.a(b.toString()), ((TapjoyCachedAssetData) (obj)));
        if (TapjoyCache.a(a))
        {
            TapjoyLog.i("TapjoyCache", "------------ Asset Cached ------------");
            TapjoyLog.i("TapjoyCache", (new StringBuilder("URL: ")).append(b).toString());
            TapjoyLog.i("TapjoyCache", (new StringBuilder("File location: ")).append(file).toString());
            TapjoyLog.i("TapjoyCache", (new StringBuilder("File size: ")).append(file.length()).toString());
            TapjoyLog.i("TapjoyCache", (new StringBuilder("Downloaded from: ")).append(((TapjoyCachedAssetData) (obj)).getAssetURL()).toString());
            TapjoyLog.i("TapjoyCache", (new StringBuilder("Cached in: ")).append(System.currentTimeMillis() / 1000L - l).append(" seconds").toString());
            TapjoyLog.i("TapjoyCache", (new StringBuilder("Timestamp: ")).append(((TapjoyCachedAssetData) (obj)).getTimestampInSeconds()).toString());
            TapjoyLog.i("TapjoyCache", (new StringBuilder("Time of death: ")).append(((TapjoyCachedAssetData) (obj)).getTimeOfDeathInSeconds()).toString());
            TapjoyLog.i("TapjoyCache", (new StringBuilder("Time to live: ")).append(((TapjoyCachedAssetData) (obj)).getTimeToLiveInSeconds()).append(" seconds").toString());
            TapjoyLog.i("TapjoyCache", "--------------------------------------");
        }
        obj = TapjoyCache.b(a);
        obj1 = a;
        ((Vector) (obj)).remove(TapjoyCache.a(b.toString()));
        return Boolean.valueOf(true);
        obj2;
        obj = null;
_L10:
        TapjoyLog.e("TapjoyCache", (new StringBuilder("Network timeout during caching: ")).append(((SocketTimeoutException) (obj2)).toString()).toString());
        obj2 = TapjoyCache.b(a);
        obj3 = a;
        ((Vector) (obj2)).remove(TapjoyCache.a(b.toString()));
        TapjoyUtil.deleteFileOrDirectory(file);
        obj3 = Boolean.valueOf(false);
        if (obj1 != null)
        {
            try
            {
                ((BufferedInputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        obj2 = obj3;
        if (obj != null)
        {
            try
            {
                ((BufferedOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return ((Boolean) (obj3));
            }
            return ((Boolean) (obj3));
        }
          goto _L5
        exception1;
        obj = null;
        obj1 = tapjoycache1;
_L9:
        obj2 = obj1;
        obj3 = obj;
        TapjoyLog.e("TapjoyCache", (new StringBuilder("Error caching asset: ")).append(exception1.toString()).toString());
        obj2 = obj1;
        obj3 = obj;
        vector = TapjoyCache.b(a);
        obj2 = obj1;
        obj3 = obj;
        tapjoycache1 = a;
        obj2 = obj1;
        obj3 = obj;
        vector.remove(TapjoyCache.a(b.toString()));
        obj2 = obj1;
        obj3 = obj;
        TapjoyUtil.deleteFileOrDirectory(file);
        obj3 = Boolean.valueOf(false);
        if (obj != null)
        {
            try
            {
                ((BufferedInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        obj2 = obj3;
        if (obj1 == null) goto _L5; else goto _L6
_L6:
        try
        {
            ((BufferedOutputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return ((Boolean) (obj3));
        }
        return ((Boolean) (obj3));
        obj1;
        obj = null;
_L8:
        if (obj != null)
        {
            try
            {
                ((BufferedInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (obj2 != null)
        {
            try
            {
                ((BufferedOutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw obj1;
        obj1;
        obj = obj3;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj2 = obj1;
        obj1 = exception;
        continue; /* Loop/switch isn't completed */
        obj2;
        Object obj4 = obj1;
        obj1 = obj2;
        obj2 = obj;
        obj = obj4;
        if (true) goto _L8; else goto _L7
_L7:
        vector;
        obj1 = tapjoycache1;
          goto _L9
        vector;
          goto _L9
        obj2;
        Object obj5 = null;
        obj1 = obj;
        obj = obj5;
          goto _L10
        obj2;
        Object obj6 = obj;
        obj = obj1;
        obj1 = obj6;
          goto _L10
    }

    public volatile Object call()
    {
        return call();
    }

    public (TapjoyCache tapjoycache, URL url, String s, long l)
    {
        a = tapjoycache;
        super();
        b = url;
        c = s;
        d = l;
        if (d <= 0L)
        {
            d = 0x15180L;
        }
        TapjoyCache.b(tapjoycache).add(TapjoyCache.a(b.toString()));
    }
}
