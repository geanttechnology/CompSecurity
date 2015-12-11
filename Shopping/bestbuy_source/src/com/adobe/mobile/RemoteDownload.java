// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods

class RemoteDownload
{

    private static final int DEFAULT_CONNECTION_TIMEOUT = 10000;
    private static final int DEFAULT_READ_TIMEOUT = 10000;

    RemoteDownload()
    {
    }

    private static SimpleDateFormat createRFC2822Formatter()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
        simpledateformat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpledateformat;
    }

    protected static boolean deleteCachedDataForURL(String s, String s1)
    {
        boolean flag = true;
        if (s == null || s.length() < 1)
        {
            StaticMethods.logWarningFormat("Cached File - tried to delete cached file, but file path was empty", new Object[0]);
            flag = false;
        } else
        {
            s = getFileForCachedURL(s, s1);
            if (s == null || !s.delete())
            {
                return false;
            }
        }
        return flag;
    }

    protected static void deleteFilesForDirectoryNotInList(String s, List list)
    {
        if (list != null && list.size() > 0) goto _L2; else goto _L1
_L1:
        deleteFilesInDirectory(s);
_L4:
        return;
_L2:
        s = getDownloadCacheDirectory(s);
        if (s != null)
        {
            s = s.listFiles();
            if (s != null && s.length > 0)
            {
                ArrayList arraylist = new ArrayList();
                for (list = list.iterator(); list.hasNext(); arraylist.add(md5hash((String)list.next()))) { }
                int j = s.length;
                int i = 0;
                while (i < j) 
                {
                    list = s[i];
                    String s1 = list.getName();
                    if (!arraylist.contains(s1.substring(0, s1.indexOf("."))))
                    {
                        if (list.delete())
                        {
                            StaticMethods.logDebugFormat("Cached File - Removed unused cache file", new Object[0]);
                        } else
                        {
                            StaticMethods.logWarningFormat("Cached File - Failed to remove unused cache file", new Object[0]);
                        }
                    }
                    i++;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected static void deleteFilesInDirectory(String s)
    {
        s = getDownloadCacheDirectory(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((s = s.listFiles()) != null && s.length > 0)
        {
            int j = s.length;
            int i = 0;
            while (i < j) 
            {
                if (s[i].delete())
                {
                    StaticMethods.logDebugFormat("Cached File - Removed unused cache file", new Object[0]);
                } else
                {
                    StaticMethods.logWarningFormat("Cached File - Failed to remove unused cache file", new Object[0]);
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected static File getDownloadCacheDirectory(String s)
    {
        File file = new File(StaticMethods.getCacheDirectory(), s);
        s = file;
        if (!file.exists())
        {
            s = file;
            if (!file.mkdir())
            {
                StaticMethods.logWarningFormat("Cached File - unable to open/make download cache directory", new Object[0]);
                s = null;
            }
        }
        return s;
    }

    private static String getEtagOfFile(String s)
    {
        if (s == null || s.length() < 1)
        {
            StaticMethods.logWarningFormat("Cached File - Path was null or empty for Cache File", new Object[0]);
            return null;
        }
        s = splitPathExtension(getPathExtension(s));
        if (s == null || s.length < 2)
        {
            StaticMethods.logWarningFormat("Cached File - No etag for file. Extension had no second value after split.", new Object[0]);
            return null;
        } else
        {
            return s[1];
        }
    }

    protected static File getFileForCachedURL(String s)
    {
        return getFileForCachedURL(s, "adbdownloadcache");
    }

    protected static File getFileForCachedURL(String s, String s1)
    {
        if (s != null && s.length() >= 1)
        {
            if ((s1 = getDownloadCacheDirectory(s1)) != null)
            {
                String as[] = s1.list();
                if (as == null || as.length < 1)
                {
                    StaticMethods.logDebugFormat("Cached Files - Directory is empty (%s).", new Object[] {
                        s1.getAbsolutePath()
                    });
                    return null;
                }
                String s2 = md5hash(s);
                int j = as.length;
                for (int i = 0; i < j; i++)
                {
                    String s3 = as[i];
                    if (s3.substring(0, s3.lastIndexOf('.')).equals(s2))
                    {
                        return new File(s1, s3);
                    }
                }

                StaticMethods.logDebugFormat("Cached Files - This file has not previously been cached (%s).", new Object[] {
                    s
                });
                return null;
            }
        }
        return null;
    }

    private static long getLastModifiedOfFile(String s)
    {
        if (s == null || s.length() < 1)
        {
            StaticMethods.logWarningFormat("Cached File - Path was null or empty for Cache File. Could not get Last Modified Date.", new Object[0]);
            return 0L;
        }
        s = splitPathExtension(getPathExtension(s));
        if (s == null || s.length < 1)
        {
            StaticMethods.logWarningFormat("Cached File - No last modified date for file. Extension had no values after split.", new Object[0]);
            return 0L;
        } else
        {
            return Long.parseLong(s[0]);
        }
    }

    private static File getNewCachedFile(String s, Date date, String s1, String s2)
    {
        if (s == null || s.length() < 1)
        {
            StaticMethods.logWarningFormat("Cached File - Invalid url parameter while attempting to create cache file. Could not save data.", new Object[0]);
        } else
        {
            if (date == null)
            {
                StaticMethods.logWarningFormat("Cached File - Invalid lastModified parameter while attempting to create cache file. Could not save data.", new Object[0]);
                return null;
            }
            if (s1 == null || s1.length() < 1)
            {
                StaticMethods.logWarningFormat("Cached File - Invalid etag parameter while attempting to create cache file. Could not save data.", new Object[0]);
                return null;
            }
            s2 = getDownloadCacheDirectory(s2);
            if (s2 != null)
            {
                String s3 = md5hash(s);
                if (s3 != null && s3.length() >= 1)
                {
                    return new File((new StringBuilder()).append(s2.getPath()).append(File.separator).append(md5hash(s)).append(".").append(date.getTime()).append("_").append(s1).toString());
                }
            }
        }
        return null;
    }

    private static String getPathExtension(String s)
    {
        if (s == null || s.length() < 1)
        {
            StaticMethods.logWarningFormat("Cached File - Path was null or empty for Cache File", new Object[0]);
            return null;
        } else
        {
            return s.substring(s.lastIndexOf(".") + 1);
        }
    }

    private static String md5hash(String s)
    {
        if (s == null || s.length() < 1)
        {
            return null;
        }
        byte abyte0[];
        StringBuilder stringbuilder;
        int i;
        int j;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes("UTF-8"));
            abyte0 = messagedigest.digest();
            stringbuilder = new StringBuilder();
            j = abyte0.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logErrorFormat("Cached Files - unable to get md5 hash (%s)", new Object[] {
                s.getMessage()
            });
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logErrorFormat("Cached Files - Unsupported Encoding: UTF-8 (%s)", new Object[] {
                s.getMessage()
            });
            return null;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        for (s = Integer.toHexString(abyte0[i] & 0xff); s.length() < 2; s = (new StringBuilder()).append("0").append(s).toString()) { }
        stringbuilder.append(s);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_51;
_L1:
        s = stringbuilder.toString();
        return s;
    }

    protected static void remoteDownloadAsync(String s, int i, int j, RemoteDownloadBlock remotedownloadblock)
    {
        remoteDownloadAsync(s, i, j, remotedownloadblock, "adbdownloadcache");
    }

    protected static void remoteDownloadAsync(String s, int i, int j, RemoteDownloadBlock remotedownloadblock, String s1)
    {
        (new Thread(new DownloadFileTask(s, remotedownloadblock, i, j, s1))).start();
    }

    protected static void remoteDownloadAsync(String s, RemoteDownloadBlock remotedownloadblock)
    {
        remoteDownloadAsync(s, 10000, 10000, remotedownloadblock, "adbdownloadcache");
    }

    protected static void remoteDownloadAsync(String s, String s1, RemoteDownloadBlock remotedownloadblock)
    {
        remoteDownloadAsync(s, 10000, 10000, remotedownloadblock, s1);
    }

    protected static void remoteDownloadSync(String s, int i, int j, RemoteDownloadBlock remotedownloadblock)
    {
        remoteDownloadSync(s, i, j, remotedownloadblock, "adbdownloadcache");
    }

    protected static void remoteDownloadSync(String s, int i, int j, RemoteDownloadBlock remotedownloadblock, String s1)
    {
        (new DownloadFileTask(s, remotedownloadblock, i, j, s1)).run();
    }

    protected static void remoteDownloadSync(String s, RemoteDownloadBlock remotedownloadblock)
    {
        remoteDownloadSync(s, 10000, 10000, remotedownloadblock, "adbdownloadcache");
    }

    protected static void remoteDownloadSync(String s, String s1, RemoteDownloadBlock remotedownloadblock)
    {
        remoteDownloadSync(s, 10000, 10000, remotedownloadblock, s1);
    }

    private static String[] splitPathExtension(String s)
    {
        if (s == null || s.length() < 1)
        {
            StaticMethods.logWarningFormat("Cached File - Extension was null or empty on Cache File", new Object[0]);
            return null;
        }
        String as[] = s.split("_");
        if (as.length != 2)
        {
            StaticMethods.logWarningFormat("Cached File - Invalid Extension on Cache File (%s)", new Object[] {
                s
            });
            return null;
        } else
        {
            return as;
        }
    }

    protected static boolean stringIsUrl(String s)
    {
        if (s == null || s.length() <= 0)
        {
            return false;
        }
        try
        {
            new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }





    private class DownloadFileTask
        implements Runnable
    {

        private final RemoteDownloadBlock callback;
        private final int connectionTimeout;
        private final String directory;
        private final int readTimeout;
        private final String url;

        protected static HttpURLConnection requestConnect(String s)
        {
            try
            {
                s = (HttpURLConnection)(new URL(s)).openConnection();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                StaticMethods.logErrorFormat("Cached Files - Exception opening URL(%s)", new Object[] {
                    s.getLocalizedMessage()
                });
                return null;
            }
            return s;
        }

        public void run()
        {
            byte abyte0[];
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            obj6 = null;
            obj5 = null;
            obj4 = null;
            obj2 = null;
            obj3 = null;
            abyte0 = null;
            if (url != null) goto _L2; else goto _L1
_L1:
            StaticMethods.logDebugFormat("Cached Files - url is null and cannot be cached", new Object[0]);
            if (callback != null)
            {
                callback.call(false, null);
            }
_L4:
            return;
_L2:
            if (RemoteDownload.stringIsUrl(url))
            {
                break; /* Loop/switch isn't completed */
            }
            StaticMethods.logDebugFormat("Cached Files - given url is not valid and cannot be cached (\"%s\")", new Object[] {
                url
            });
            if (callback != null)
            {
                callback.call(false, null);
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
            Object obj;
            HttpURLConnection httpurlconnection;
            Object obj8;
            obj = RemoteDownload.getFileForCachedURL(url, directory);
            obj8 = RemoteDownload.createRFC2822Formatter();
            httpurlconnection = requestConnect(url);
            if (httpurlconnection != null)
            {
                break; /* Loop/switch isn't completed */
            }
            if (callback != null)
            {
                callback.call(false, null);
                return;
            }
            if (true) goto _L4; else goto _L5
_L5:
            httpurlconnection.setConnectTimeout(connectionTimeout);
            httpurlconnection.setReadTimeout(readTimeout);
            if (obj != null)
            {
                String s = StaticMethods.hexToString(RemoteDownload.getEtagOfFile(((File) (obj)).getPath()));
                Long long1 = Long.valueOf(RemoteDownload.getLastModifiedOfFile(((File) (obj)).getPath()));
                if (long1.longValue() != 0L)
                {
                    httpurlconnection.setRequestProperty("If-Modified-Since", ((SimpleDateFormat) (obj8)).format(long1));
                }
                if (s != null)
                {
                    httpurlconnection.setRequestProperty("If-None-Match", s);
                }
            }
            p.a(httpurlconnection);
            httpurlconnection.connect();
            p.b(httpurlconnection);
            p.a(httpurlconnection);
            int i;
            i = httpurlconnection.getResponseCode();
            p.b(httpurlconnection);
            p.c(httpurlconnection);
            if (i != 304) goto _L7; else goto _L6
_L6:
            StaticMethods.logDebugFormat("Cached Files - File has not been modified since last download. (%s)", new Object[] {
                url
            });
            if (callback != null)
            {
                callback.call(false, ((File) (obj)));
            }
            if (false)
            {
                try
                {
                    throw new NullPointerException();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                        ((IOException) (obj)).getLocalizedMessage()
                    });
                }
                break MISSING_BLOCK_LABEL_356;
            }
            if (true)
            {
                break MISSING_BLOCK_LABEL_333;
            }
            throw new NullPointerException();
            httpurlconnection.disconnect();
            return;
            return;
            obj;
            p.a(httpurlconnection, ((IOException) (obj)));
            throw obj;
            obj;
            obj3 = null;
            obj = abyte0;
_L21:
            StaticMethods.logWarningFormat("Cached Files - Timed out making request (%s)", new Object[] {
                url
            });
            if (callback != null)
            {
                callback.call(false, null);
            }
            if (obj3 != null)
            {
                try
                {
                    ((OutputStream) (obj3)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                        ((IOException) (obj)).getLocalizedMessage()
                    });
                    return;
                }
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_424;
            }
            ((InputStream) (obj)).close();
            httpurlconnection.disconnect();
            return;
            obj;
            p.a(httpurlconnection, ((IOException) (obj)));
            throw obj;
            obj3;
            obj = null;
            obj4 = obj6;
_L19:
            obj2 = obj4;
            abyte0 = ((byte []) (obj));
            StaticMethods.logWarningFormat("Cached Files - IOException while making request (%s)", new Object[] {
                ((IOException) (obj3)).getLocalizedMessage()
            });
            obj2 = obj4;
            abyte0 = ((byte []) (obj));
            if (callback == null)
            {
                break MISSING_BLOCK_LABEL_515;
            }
            obj2 = obj4;
            abyte0 = ((byte []) (obj));
            callback.call(false, null);
            if (obj4 != null)
            {
                try
                {
                    ((OutputStream) (obj4)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                        ((IOException) (obj)).getLocalizedMessage()
                    });
                    return;
                }
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_533;
            }
            ((InputStream) (obj)).close();
            httpurlconnection.disconnect();
            return;
_L7:
            p.a(httpurlconnection);
            i = httpurlconnection.getResponseCode();
            p.b(httpurlconnection);
            p.c(httpurlconnection);
            if (i != 404) goto _L9; else goto _L8
_L8:
            StaticMethods.logDebugFormat("Cached Files - File not found. (%s)", new Object[] {
                url
            });
            if (callback != null)
            {
                callback.call(false, ((File) (obj)));
            }
            if (false)
            {
                try
                {
                    throw new NullPointerException();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                        ((IOException) (obj)).getLocalizedMessage()
                    });
                }
                break MISSING_BLOCK_LABEL_668;
            }
            if (true)
            {
                break MISSING_BLOCK_LABEL_645;
            }
            throw new NullPointerException();
            httpurlconnection.disconnect();
            return;
            return;
            obj;
            p.a(httpurlconnection, ((IOException) (obj)));
            throw obj;
            obj3;
            obj = null;
            obj4 = obj5;
_L18:
            obj2 = obj4;
            abyte0 = ((byte []) (obj));
            StaticMethods.logWarningFormat("Cached Files - Unexpected exception while attempting to get remote file (%s)", new Object[] {
                ((Exception) (obj3)).getLocalizedMessage()
            });
            obj2 = obj4;
            abyte0 = ((byte []) (obj));
            if (callback == null)
            {
                break MISSING_BLOCK_LABEL_736;
            }
            obj2 = obj4;
            abyte0 = ((byte []) (obj));
            callback.call(false, null);
            if (obj4 != null)
            {
                try
                {
                    ((OutputStream) (obj4)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                        ((IOException) (obj)).getLocalizedMessage()
                    });
                    return;
                }
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_754;
            }
            ((InputStream) (obj)).close();
            httpurlconnection.disconnect();
            return;
_L9:
            p.a(httpurlconnection);
            i = httpurlconnection.getResponseCode();
            p.b(httpurlconnection);
            p.c(httpurlconnection);
            if (i == 200) goto _L11; else goto _L10
_L10:
            Object obj7;
            obj7 = url;
            p.a(httpurlconnection);
            i = httpurlconnection.getResponseCode();
            p.b(httpurlconnection);
            p.c(httpurlconnection);
            p.a(httpurlconnection);
            obj3 = httpurlconnection.getResponseMessage();
            p.b(httpurlconnection);
            p.c(httpurlconnection);
            StaticMethods.logWarningFormat("Cached Files - File could not be downloaded from URL (%s) Response: (%d) Message: (%s)", new Object[] {
                obj7, Integer.valueOf(i), obj3
            });
            if (callback != null)
            {
                callback.call(false, ((File) (obj)));
            }
            if (false)
            {
                try
                {
                    throw new NullPointerException();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                        ((IOException) (obj)).getLocalizedMessage()
                    });
                }
                break MISSING_BLOCK_LABEL_950;
            }
            if (true)
            {
                break MISSING_BLOCK_LABEL_927;
            }
            throw new NullPointerException();
            httpurlconnection.disconnect();
            return;
            return;
            obj;
            p.a(httpurlconnection, ((IOException) (obj)));
            throw obj;
            obj3;
            obj = null;
_L17:
            obj2 = obj4;
            abyte0 = ((byte []) (obj));
            StaticMethods.logWarningFormat("Cached Files - Unexpected error while attempting to get remote file (%s)", new Object[] {
                ((Error) (obj3)).getLocalizedMessage()
            });
            obj2 = obj4;
            abyte0 = ((byte []) (obj));
            if (callback == null)
            {
                break MISSING_BLOCK_LABEL_1014;
            }
            obj2 = obj4;
            abyte0 = ((byte []) (obj));
            callback.call(false, null);
            if (obj4 != null)
            {
                try
                {
                    ((OutputStream) (obj4)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                        ((IOException) (obj)).getLocalizedMessage()
                    });
                    return;
                }
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_1032;
            }
            ((InputStream) (obj)).close();
            httpurlconnection.disconnect();
            return;
            obj;
            p.a(httpurlconnection, ((IOException) (obj)));
            throw obj;
            obj3;
            obj = null;
_L16:
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_1077;
            }
            ((OutputStream) (obj2)).close();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_1085;
            }
            ((InputStream) (obj)).close();
            httpurlconnection.disconnect();
_L14:
            throw obj3;
            obj;
            p.a(httpurlconnection, ((IOException) (obj)));
            throw obj;
_L11:
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_1118;
            }
            RemoteDownload.deleteCachedDataForURL(url, directory);
            p.a(httpurlconnection);
            long l = httpurlconnection.getLastModified();
            p.b(httpurlconnection);
            p.c(httpurlconnection);
            obj8 = new Date(l);
            p.a(httpurlconnection);
            obj7 = httpurlconnection.getHeaderField("ETag");
            p.b(httpurlconnection);
            p.c(httpurlconnection);
            obj = obj7;
            if (obj7 == null)
            {
                break MISSING_BLOCK_LABEL_1189;
            }
            obj = StaticMethods.getHexString(((String) (obj7)));
            obj7 = RemoteDownload.getNewCachedFile(url, ((Date) (obj8)), ((String) (obj)), directory);
            if (obj7 != null)
            {
                break MISSING_BLOCK_LABEL_1276;
            }
            if (callback != null)
            {
                callback.call(false, null);
            }
            if (false)
            {
                try
                {
                    throw new NullPointerException();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                        ((IOException) (obj)).getLocalizedMessage()
                    });
                }
                break MISSING_BLOCK_LABEL_1275;
            }
            if (true)
            {
                break MISSING_BLOCK_LABEL_1252;
            }
            throw new NullPointerException();
            httpurlconnection.disconnect();
            return;
            return;
            obj = p.d(httpurlconnection);
            obj2 = obj3;
            abyte0 = ((byte []) (obj));
            obj3 = new FileOutputStream(((File) (obj7)));
            abyte0 = new byte[4096];
_L12:
            i = ((InputStream) (obj)).read(abyte0);
            if (i == -1)
            {
                break MISSING_BLOCK_LABEL_1329;
            }
            ((OutputStream) (obj3)).write(abyte0, 0, i);
              goto _L12
            StaticMethods.logDebugFormat("Cached Files - Caching successful (%s)", new Object[] {
                url
            });
            if (callback != null)
            {
                callback.call(true, ((File) (obj7)));
            }
            if (obj3 != null)
            {
                try
                {
                    ((OutputStream) (obj3)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                        ((IOException) (obj)).getLocalizedMessage()
                    });
                    return;
                }
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_1382;
            }
            ((InputStream) (obj)).close();
            httpurlconnection.disconnect();
            return;
            obj;
            StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                ((IOException) (obj)).getLocalizedMessage()
            });
            if (true) goto _L14; else goto _L13
_L13:
            obj3;
            obj = abyte0;
            continue; /* Loop/switch isn't completed */
            Object obj1;
            obj1;
            obj2 = obj3;
            obj3 = obj1;
            continue; /* Loop/switch isn't completed */
            obj1;
            obj2 = obj3;
            obj3 = obj1;
            if (true) goto _L16; else goto _L15
_L15:
            obj3;
              goto _L17
            obj1;
            obj4 = obj3;
            obj3 = obj1;
              goto _L17
            obj3;
            obj4 = obj5;
              goto _L18
            obj1;
            obj4 = obj3;
            obj3 = obj1;
              goto _L18
            obj3;
            obj4 = obj6;
              goto _L19
            obj1;
            obj4 = obj3;
            obj3 = obj1;
              goto _L19
            obj1;
            obj3 = null;
            continue; /* Loop/switch isn't completed */
            obj1;
            if (true) goto _L21; else goto _L20
_L20:
        }

        private DownloadFileTask(String s, RemoteDownloadBlock remotedownloadblock, int i, int j, String s1)
        {
            url = s;
            callback = remotedownloadblock;
            connectionTimeout = i;
            readTimeout = j;
            directory = s1;
        }


        private class RemoteDownloadBlock
        {

            public abstract void call(boolean flag, File file);
        }

    }

}
