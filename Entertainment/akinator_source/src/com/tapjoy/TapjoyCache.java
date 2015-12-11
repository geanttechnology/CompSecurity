// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tapjoy:
//            TapjoyCacheMap, TapjoyUtil, TapjoyLog, TapjoyCachedAssetData, 
//            TJCacheListener

public class TapjoyCache
{
    public class CacheAssetThread
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

        public CacheAssetThread(URL url, String s, long l)
        {
            a = TapjoyCache.this;
            super();
            b = url;
            c = s;
            d = l;
            if (d <= 0L)
            {
                d = 0x15180L;
            }
            TapjoyCache.b(TapjoyCache.this).add(TapjoyCache.a(b.toString()));
        }
    }


    public static final String CACHE_DIRECTORY_NAME = "Tapjoy/Cache/";
    public static final int CACHE_LIMIT = -1;
    private static TapjoyCache a = null;
    public static boolean unit_test_mode = false;
    private Context b;
    private TapjoyCacheMap c;
    private Vector d;
    private ExecutorService e;
    private File f;
    private boolean g;

    public TapjoyCache(Context context)
    {
        if (a == null || unit_test_mode)
        {
            a = this;
            b = context;
            c = new TapjoyCacheMap(context, -1);
            d = new Vector();
            e = Executors.newFixedThreadPool(5);
            if (Environment.getExternalStorageDirectory() != null)
            {
                TapjoyUtil.deleteFileOrDirectory(new File(Environment.getExternalStorageDirectory(), "tapjoy"));
                TapjoyUtil.deleteFileOrDirectory(new File(Environment.getExternalStorageDirectory(), "tjcache/tmp/"));
            }
            f = new File((new StringBuilder()).append(b.getFilesDir()).append("/Tapjoy/Cache/").toString());
            if (!f.exists() && !f.mkdirs())
            {
                TapjoyLog.e("TapjoyCache", "Error initalizing cache");
                a = null;
            }
            a();
        }
    }

    static String a(String s)
    {
        return b(s);
    }

    private void a()
    {
        Object obj = b.getSharedPreferences("tapjoyCacheData", 0);
        android.content.SharedPreferences.Editor editor = ((SharedPreferences) (obj)).edit();
        obj = ((SharedPreferences) (obj)).getAll().entrySet().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            File file = new File((String)entry.getKey());
            if (file.exists() && file.isFile())
            {
                TapjoyCachedAssetData tapjoycachedassetdata = TapjoyCachedAssetData.fromRawJSONString(entry.getValue().toString());
                if (tapjoycachedassetdata != null)
                {
                    String s = b(tapjoycachedassetdata.getAssetURL());
                    if (s != null && !"".equals(s) && s.length() > 0)
                    {
                        if (tapjoycachedassetdata.getTimeOfDeathInSeconds() < System.currentTimeMillis() / 1000L)
                        {
                            if (g)
                            {
                                TapjoyLog.i("TapjoyCache", "Asset expired, removing from cache");
                            }
                            if (tapjoycachedassetdata.getLocalFilePath() != null && tapjoycachedassetdata.getLocalFilePath().length() > 0)
                            {
                                TapjoyUtil.deleteFileOrDirectory(new File(tapjoycachedassetdata.getLocalFilePath()));
                            }
                        } else
                        {
                            c.put(s, tapjoycachedassetdata);
                        }
                    } else
                    {
                        editor.remove((String)entry.getKey()).commit();
                    }
                } else
                {
                    editor.remove((String)entry.getKey()).commit();
                }
            } else
            {
                editor.remove((String)entry.getKey()).commit();
            }
        } while (true);
    }

    static boolean a(TapjoyCache tapjoycache)
    {
        return tapjoycache.g;
    }

    private static String b(String s)
    {
        String s1 = s;
        if (s.startsWith("//"))
        {
            s1 = (new StringBuilder("http:")).append(s).toString();
        }
        try
        {
            s = (new URL(s1)).getFile();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    static Vector b(TapjoyCache tapjoycache)
    {
        return tapjoycache.d;
    }

    static TapjoyCacheMap c(TapjoyCache tapjoycache)
    {
        return tapjoycache.c;
    }

    static File d(TapjoyCache tapjoycache)
    {
        return tapjoycache.f;
    }

    public static TapjoyCache getInstance()
    {
        return a;
    }

    public static void setInstance(TapjoyCache tapjoycache)
    {
        a = tapjoycache;
    }

    public Future cacheAssetFromJSONObject(JSONObject jsonobject)
    {
        try
        {
            jsonobject = cacheAssetFromURL(jsonobject.getString("url"), jsonobject.optString("offerId"), Long.valueOf(jsonobject.optLong("timeToLive")).longValue());
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return null;
        }
        return jsonobject;
    }

    public Future cacheAssetFromURL(String s, String s1, long l)
    {
        URL url;
        try
        {
            url = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        s = b(s);
        if (d.contains(s))
        {
            return null;
        } else
        {
            return startCachingThread(url, s1, l);
        }
    }

    public void cacheAssetGroup(JSONArray jsonarray, TJCacheListener tjcachelistener)
    {
        if (jsonarray != null && jsonarray.length() > 0)
        {
            (new Thread(jsonarray, tjcachelistener) {

                final JSONArray a;
                final TJCacheListener b;
                final TapjoyCache c;

                public final void run()
                {
                    Object obj;
                    int i;
                    boolean flag;
                    obj = new ArrayList();
                    flag = true;
                    i = 0;
_L3:
                    if (i >= a.length()) goto _L2; else goto _L1
_L1:
                    Object obj1;
                    obj1 = a.getJSONObject(i);
                    obj1 = c.cacheAssetFromJSONObject(((JSONObject) (obj1)));
                    Object obj2;
                    if (obj1 != null)
                    {
                        try
                        {
                            ((List) (obj)).add(obj1);
                        }
                        catch (JSONException jsonexception) { }
                    }
                    i++;
                      goto _L3
_L2:
                    obj = ((List) (obj)).iterator();
                    i = ((flag) ? 1 : 0);
_L5:
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    obj1 = (Future)((Iterator) (obj)).next();
                    if (!((Boolean)((Future) (obj1)).get()).booleanValue())
                    {
                        i = 2;
                    }
                    try
                    {
                        if (TapjoyCache.a(c))
                        {
                            TapjoyLog.i("TapjoyCache", "Caching thread completed");
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj2)
                    {
                        i = 2;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj2)
                    {
                        i = 2;
                    }
                    if (true) goto _L5; else goto _L4
_L4:
                    if (b != null)
                    {
                        b.onCachingComplete(i);
                    }
                    return;
                }

            
            {
                c = TapjoyCache.this;
                a = jsonarray;
                b = tjcachelistener;
                super();
            }
            }).start();
        } else
        if (tjcachelistener != null)
        {
            tjcachelistener.onCachingComplete(1);
            return;
        }
    }

    public String cachedAssetsToJSON()
    {
        Iterator iterator = c.entrySet().iterator();
        JSONObject jsonobject = new JSONObject();
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            try
            {
                jsonobject.put(((String)entry.getKey()).toString(), ((TapjoyCachedAssetData)entry.getValue()).toRawJSONString());
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }
        return jsonobject.toString();
    }

    public void clearTapjoyCache()
    {
        TapjoyUtil.deleteFileOrDirectory(f);
        f.mkdirs();
        c = new TapjoyCacheMap(b, -1);
    }

    public TapjoyCacheMap getCachedData()
    {
        return c;
    }

    public TapjoyCachedAssetData getCachedDataForURL(String s)
    {
        s = b(s);
        if (s != "")
        {
            return (TapjoyCachedAssetData)c.get(s);
        } else
        {
            return null;
        }
    }

    public String getCachedOfferIDs()
    {
        Object obj = "";
        ArrayList arraylist = new ArrayList();
        if (c != null)
        {
            obj = c.entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s = ((TapjoyCachedAssetData)((java.util.Map.Entry)((Iterator) (obj)).next()).getValue()).getOfferId();
                if (s != null && s.length() != 0 && !arraylist.contains(s))
                {
                    arraylist.add(s);
                }
            } while (true);
            obj = TextUtils.join(",", arraylist);
        }
        return ((String) (obj));
    }

    public String getPathOfCachedURL(String s)
    {
label0:
        {
            String s1 = b(s);
            Object obj = s;
            if (s1 != "")
            {
                obj = s;
                if (c.containsKey(s1))
                {
                    obj = (TapjoyCachedAssetData)c.get(s1);
                    if (!(new File(((TapjoyCachedAssetData) (obj)).getLocalFilePath())).exists())
                    {
                        break label0;
                    }
                    obj = ((TapjoyCachedAssetData) (obj)).getLocalURL();
                }
            }
            return ((String) (obj));
        }
        getInstance().removeAssetFromCache(s);
        return s;
    }

    public boolean isURLCached(String s)
    {
        return c.get(s) != null;
    }

    public boolean isURLDownloading(String s)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (d != null)
        {
            s = b(s);
            flag = flag1;
            if (s != "")
            {
                flag = flag1;
                if (d.contains(s))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public void printCacheInformation()
    {
        TapjoyLog.i("TapjoyCache", "------------- Cache Data -------------");
        TapjoyLog.i("TapjoyCache", (new StringBuilder("Number of files in cache: ")).append(c.size()).toString());
        TapjoyLog.i("TapjoyCache", (new StringBuilder("Cache Size: ")).append(TapjoyUtil.fileOrDirectorySize(f)).toString());
        TapjoyLog.i("TapjoyCache", "--------------------------------------");
    }

    public boolean removeAssetFromCache(String s)
    {
        s = b(s);
        return s != "" && c.remove(s) != null;
    }

    public Future startCachingThread(URL url, String s, long l)
    {
        if (url != null)
        {
            return e.submit(new CacheAssetThread(url, s, l));
        } else
        {
            return null;
        }
    }

}
