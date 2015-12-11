// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net.http;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.sessionm.a.a;
import com.sessionm.core.i;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;

// Referenced classes of package com.sessionm.net.http:
//            b

public class DownloadService extends IntentService
{

    public static final String CHECKSUM_ALGORITHM = "CHECKSUM_ALGORITHM";
    private static final String DOWNLOAD_DESTINATION = "DOWNLOAD_DESTINATION";
    private static final String DOWNLOAD_URL = "DOWNLOAD_URL";
    private static final String EXPECTED_CHECKSUM = "EXPECTED_CHECKSUM";
    private static final String EXPECTED_SIZE = "EXPECTED_SIZE";
    private static final String TAG = "SessionM.Download";
    private static b listener;
    private static boolean simulateDownloadFailure;

    public DownloadService()
    {
        super("Download Service");
    }

    private void downloadFile(String s, String s1, String s2, String s3, int j)
    {
        Object obj1;
        Object obj4;
        int l;
        long l1;
        if (Log.isLoggable("SessionM.Download", 3))
        {
            Log.d("SessionM.Download", String.format("start downloading url: %s", new Object[] {
                s
            }));
        }
        l1 = 0L;
        l = 1;
        obj1 = null;
        obj4 = null;
        long l2 = System.currentTimeMillis();
        l1 = l2;
        Object obj = (HttpURLConnection)(new URL(s)).openConnection();
        File file;
        MessageDigest messagedigest;
        int k;
        int i1;
        int j1;
        int k1;
        try
        {
            ((HttpURLConnection) (obj)).setInstanceFollowRedirects(true);
            if (obj instanceof HttpsURLConnection)
            {
                ((HttpsURLConnection)obj).setHostnameVerifier(new AllowAllHostnameVerifier());
            }
            ((HttpURLConnection) (obj)).setConnectTimeout(30000);
            ((HttpURLConnection) (obj)).setRequestMethod("GET");
            file = new File(s1);
            messagedigest = i.b(file, s3);
            if (file.exists())
            {
                long l3 = file.length();
                if (Log.isLoggable("SessionM.Download", 3))
                {
                    Log.d("SessionM.Download", String.format("Resuming download at %d bytes.", new Object[] {
                        Long.valueOf(l3)
                    }));
                }
                ((HttpURLConnection) (obj)).setRequestProperty("Range", String.format(Locale.US, "bytes=%d-", new Object[] {
                    Long.valueOf(l3)
                }));
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s3)
        {
            k = 0;
            s2 = ((String) (obj));
            j = 0;
            s1 = null;
            l = 1;
            obj = obj4;
            break MISSING_BLOCK_LABEL_375;
        }
        finally
        {
            s3 = null;
            k = 0;
            j = 0;
            s2 = ((String) (obj));
            obj = obj1;
            continue; /* Loop/switch isn't completed */
        }
        if (messagedigest == null) goto _L2; else goto _L1
_L1:
        s3 = new DigestInputStream(new BufferedInputStream(((HttpURLConnection) (obj)).getInputStream(), 0x10000), messagedigest);
_L8:
        k = ((HttpURLConnection) (obj)).getResponseCode();
        if (k < 200 || k >= 400)
        {
            break MISSING_BLOCK_LABEL_1618;
        }
        s1 = new BufferedOutputStream(new FileOutputStream(file, file.exists()));
        obj1 = new byte[0x10000];
        i1 = 1;
        l = 0;
_L9:
        j1 = i1;
        k1 = s3.read(((byte []) (obj1)));
        if (k1 == -1) goto _L4; else goto _L3
_L3:
        j1 = i1;
        if (!simulateDownloadFailure || l <= 500) goto _L5; else goto _L4
_L4:
        j1 = i1;
        if (!simulateDownloadFailure) goto _L7; else goto _L6
_L6:
        Object obj2;
        j1 = i1;
        long l4;
        boolean flag;
        try
        {
            throw new IOException();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            s2 = ((String) (obj));
        }
        finally
        {
            s2 = ((String) (obj));
        }
        j = k;
        k = l;
        obj = s1;
        l = j1;
        s1 = s3;
        s3 = ((String) (obj1));
_L26:
        i1 = j;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_389;
        }
        i1 = s2.getResponseCode();
        j = i1;
_L21:
        i1 = l;
        if (l == 1)
        {
            i1 = 6;
        }
        if (Log.isLoggable("SessionM.Download", 3))
        {
            Log.d("SessionM.Download", "Uncaught exception during download processing", s3);
        }
        i.a(s1);
        i.a(((java.io.Closeable) (obj)));
        l4 = System.currentTimeMillis();
        if (Log.isLoggable("SessionM.Download", 3))
        {
            s1 = String.format(Locale.US, "URL: %s, code: %d, error: %s, processing time: %d, response size: %d", new Object[] {
                s, Integer.valueOf(j), null, Long.valueOf(l4 - l1), Integer.valueOf(k)
            });
            Log.d("SessionM.Download", (new StringBuilder()).append("Finish request, ").append(s1).toString());
        }
        k = i1;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_538;
        }
        s2.disconnect();
        k = i1;
_L15:
        if (listener != null)
        {
            listener.a(this, s, k);
        }
        return;
_L2:
        if (Log.isLoggable("SessionM.Download", 3))
        {
            Log.d("SessionM.Download", "Skipping file checksum since digest is unavailable.");
        }
        s3 = new BufferedInputStream(((HttpURLConnection) (obj)).getInputStream(), 0x10000);
          goto _L8
        s1;
        l = 7;
        try
        {
            throw s1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            s1 = s3;
        }
        finally
        {
            j = 0;
        }
        j = k;
        k = 0;
        s2 = ((String) (obj));
        s3 = ((String) (obj1));
        obj = obj4;
        break MISSING_BLOCK_LABEL_375;
_L5:
        j1 = i1;
        s1.write(((byte []) (obj1)), 0, k1);
        j1 = i1;
        s1.flush();
_L10:
        l += k1;
          goto _L9
        obj4;
        i1 = 7;
          goto _L10
_L7:
        if (j == 0) goto _L12; else goto _L11
_L11:
        j1 = i1;
        if (file.length() == (long)j) goto _L12; else goto _L13
_L13:
        j1 = i1;
        if (!Log.isLoggable("SessionM.Download", 3))
        {
            break MISSING_BLOCK_LABEL_768;
        }
        j1 = i1;
        Log.d("SessionM.Download", String.format(Locale.US, "incorrect file size file for url: %s expected: %d actual: %d", new Object[] {
            s, Integer.valueOf(j), Long.valueOf(file.length())
        }));
        j = 5;
        j1 = j;
        flag = file.delete();
        if (!flag)
        {
            j = 7;
        }
_L17:
        i.a(s3);
        i.a(s1);
        l4 = System.currentTimeMillis();
        if (Log.isLoggable("SessionM.Download", 3))
        {
            s1 = String.format(Locale.US, "URL: %s, code: %d, error: %s, processing time: %d, response size: %d", new Object[] {
                s, Integer.valueOf(k), null, Long.valueOf(l4 - l1), Integer.valueOf(l)
            });
            Log.d("SessionM.Download", (new StringBuilder()).append("Finish request, ").append(s1).toString());
        }
        k = j;
        if (obj == null) goto _L15; else goto _L14
_L14:
        ((HttpURLConnection) (obj)).disconnect();
        k = j;
          goto _L15
        s1;
        k = j;
        if (Log.isLoggable("SessionM.Download", 3))
        {
            Log.d("SessionM.Download", "Exception on disconnect.", s1);
            k = j;
        }
          goto _L15
_L12:
        if (messagedigest == null)
        {
            break MISSING_BLOCK_LABEL_1095;
        }
        j1 = i1;
        obj1 = a.a(messagedigest.digest());
        j1 = i1;
        if (!((String) (obj1)).equals(s2))
        {
            break MISSING_BLOCK_LABEL_1025;
        }
        j1 = i1;
        j = i1;
        if (!Log.isLoggable("SessionM.Download", 3)) goto _L17; else goto _L16
_L16:
        j1 = i1;
        Log.d("SessionM.Download", String.format(Locale.US, "downloaded file for url: %s checksum: %s", new Object[] {
            s, obj1
        }));
        j = i1;
          goto _L17
        j1 = i1;
        if (!Log.isLoggable("SessionM.Download", 3))
        {
            break MISSING_BLOCK_LABEL_1073;
        }
        j1 = i1;
        Log.d("SessionM.Download", String.format(Locale.US, "checksums do not match for url: %s expected: %s actual: %s", new Object[] {
            s, s2, obj1
        }));
        j = 4;
        j1 = j;
        if (file.delete()) goto _L17; else goto _L18
_L18:
        j = 7;
          goto _L17
        j1 = i1;
        j = i1;
        if (!Log.isLoggable("SessionM.Download", 3)) goto _L17; else goto _L19
_L19:
        j1 = i1;
        Log.d("SessionM.Download", String.format(Locale.US, "downloaded file for url: %s", new Object[] {
            s
        }));
        j = i1;
          goto _L17
        obj1;
        if (!Log.isLoggable("SessionM.Download", 3)) goto _L21; else goto _L20
_L20:
        Log.d("SessionM.Download", "Status code unavailable.", ((Throwable) (obj1)));
          goto _L21
        s1;
        k = i1;
        if (Log.isLoggable("SessionM.Download", 3))
        {
            Log.d("SessionM.Download", "Exception on disconnect.", s1);
            k = i1;
        }
          goto _L15
        s1;
        l1 = 0L;
        s3 = null;
        k = 0;
        s2 = null;
        j = 0;
        obj = obj1;
_L25:
        i.a(s3);
        i.a(((java.io.Closeable) (obj)));
        l4 = System.currentTimeMillis();
        if (Log.isLoggable("SessionM.Download", 3))
        {
            s = String.format(Locale.US, "URL: %s, code: %d, error: %s, processing time: %d, response size: %d", new Object[] {
                s, Integer.valueOf(k), null, Long.valueOf(l4 - l1), Integer.valueOf(j)
            });
            Log.d("SessionM.Download", (new StringBuilder()).append("Finish request, ").append(s).toString());
        }
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_1323;
        }
        s2.disconnect();
_L23:
        throw s1;
        s;
        if (Log.isLoggable("SessionM.Download", 3))
        {
            Log.d("SessionM.Download", "Exception on disconnect.", s);
        }
        if (true) goto _L23; else goto _L22
_L22:
        s1;
        s3 = null;
        k = 0;
        s2 = null;
        j = 0;
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        s1;
        k = 0;
        j = 0;
        s2 = ((String) (obj));
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        s2 = ((String) (obj));
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        obj4;
        s2 = s1;
        j = 0;
        obj1 = obj;
        s1 = ((String) (obj4));
        obj = s2;
        s2 = ((String) (obj1));
        continue; /* Loop/switch isn't completed */
        obj = obj2;
        j = l;
        String s4 = s1;
        s1 = ((String) (obj));
        obj = s4;
        continue; /* Loop/switch isn't completed */
        s4;
        s3 = s1;
        l = j;
        s1 = s4;
        j = k;
        k = l;
        continue; /* Loop/switch isn't completed */
        s4;
        s3 = s1;
        l = j;
        s1 = s4;
        j = k;
        k = l;
        if (true) goto _L25; else goto _L24
_L24:
        s3;
        k = 0;
        s2 = null;
        j = 0;
        l = 1;
        s1 = null;
        obj = obj4;
          goto _L26
        s3;
        k = 0;
        s2 = null;
        j = 0;
        l = 1;
        s1 = null;
        obj = obj4;
          goto _L26
        s4;
        l = 1;
        s1 = s3;
        k = 0;
        s2 = ((String) (obj));
        j = 0;
        s3 = s4;
        obj = obj4;
          goto _L26
        Throwable throwable;
        throwable;
        l = 1;
        s2 = s3;
        j = k;
        k = 0;
        Object obj3 = obj;
        s3 = throwable;
        obj = s1;
        s1 = s2;
        s2 = ((String) (obj3));
          goto _L26
        s1 = null;
        j = 1;
        l = 0;
          goto _L17
    }

    public static boolean isSimulateDownloadFailure()
    {
        return simulateDownloadFailure;
    }

    public static void setListener(b b1)
    {
        listener = b1;
    }

    public static void setSimulateDownloadFailure(boolean flag)
    {
        simulateDownloadFailure = flag;
    }

    public static void start(Context context, String s, String s1, String s2, String s3, int j)
    {
        if (Log.isLoggable("SessionM.Download", 3))
        {
            Log.d("SessionM.Download", String.format("send download intent url: %s, path: %s", new Object[] {
                s, s1
            }));
        }
        Intent intent = new Intent(context, com/sessionm/net/http/DownloadService);
        intent.setFlags(0x10000000);
        intent.putExtra("DOWNLOAD_URL", s);
        intent.putExtra("EXPECTED_CHECKSUM", s2);
        intent.putExtra("DOWNLOAD_DESTINATION", s1);
        intent.putExtra("CHECKSUM_ALGORITHM", s3);
        intent.putExtra("EXPECTED_SIZE", j);
        context.startService(intent);
    }

    protected void onHandleIntent(Intent intent)
    {
        String s = intent.getStringExtra("DOWNLOAD_URL");
        String s1 = intent.getStringExtra("DOWNLOAD_DESTINATION");
        if (Log.isLoggable("SessionM.Download", 3))
        {
            Log.d("SessionM.Download", String.format("received download intent url: %s, path: %s", new Object[] {
                s, s1
            }));
        }
        if (s == null)
        {
            throw new NullPointerException("null url sent to download service.");
        }
        if (s1 == null)
        {
            throw new NullPointerException("null destination path sent to download service.");
        } else
        {
            downloadFile(s, s1, intent.getStringExtra("EXPECTED_CHECKSUM"), intent.getStringExtra("CHECKSUM_ALGORITHM"), intent.getIntExtra("EXPECTED_SIZE", 0));
            return;
        }
    }
}
