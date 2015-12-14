// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.IOUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal:
//            AdPlacementReporter, Handshake

static class _cls6
{

    private static String buildRequest(File afile[])
    {
        JSONObject jsonobject;
        JSONArray jsonarray;
        JSONArray jsonarray1;
        JSONArray jsonarray2;
        JSONObject jsonobject1;
        Object obj;
        int i;
        jsonobject = new JSONObject();
        jsonarray = new JSONArray();
        jsonarray1 = new JSONArray();
        jsonarray2 = new JSONArray();
        int j;
        try
        {
            j = afile.length;
        }
        // Misplaced declaration of an exception variable
        catch (File afile[])
        {
            MMLog.e(AdPlacementReporter.access$100(), "Error creating SSP reporting request", afile);
            return null;
        }
        i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        obj = afile[i];
        jsonobject1 = retrieveEvent(((File) (obj)));
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        obj = ((File) (obj)).getName();
        if (((String) (obj)).startsWith("request_"))
        {
            jsonarray.put(jsonobject1);
            break MISSING_BLOCK_LABEL_247;
        }
        if (((String) (obj)).startsWith("display_"))
        {
            jsonarray1.put(jsonobject1);
            break MISSING_BLOCK_LABEL_247;
        }
        if (((String) (obj)).startsWith("click_"))
        {
            jsonarray2.put(jsonobject1);
        }
        break MISSING_BLOCK_LABEL_247;
        if (jsonarray.length() > 0)
        {
            jsonobject.put("req", jsonarray);
        }
        if (jsonarray1.length() > 0)
        {
            jsonobject.put("display", jsonarray1);
        }
        if (jsonarray2.length() > 0)
        {
            jsonobject.put("click", jsonarray2);
        }
        try
        {
            afile = jsonobject.toString(2);
        }
        // Misplaced declaration of an exception variable
        catch (File afile[])
        {
            afile = "Unable to format report with indentation";
        }
        if (MMLog.isDebugEnabled() && MMLog.isDebugEnabled())
        {
            MMLog.d(AdPlacementReporter.access$100(), (new StringBuilder()).append("Generated report.\n").append(afile).toString());
        }
        return jsonobject.toString();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void countQueuedEvents()
    {
        File afile[] = AdPlacementReporter.access$000().listFiles();
        int k = 0;
        int l = afile.length;
        int j = 0;
        while (j < l) 
        {
            File file = afile[j];
            int i;
            if (file.getName().endsWith(".tmp"))
            {
                i = k;
                if (setEventAsCompleted(file, false))
                {
                    i = k + 1;
                }
            } else
            {
                i = k;
                if (file.getName().endsWith(".json"))
                {
                    i = k + 1;
                }
            }
            j++;
            k = i;
        }
        AdPlacementReporter.access$200().set(k);
    }

    private static void deleteUploadedEvents(File afile[])
    {
        int j = 0;
        int k = afile.length;
        int i = 0;
        while (i < k) 
        {
            File file = afile[i];
            if (!file.delete())
            {
                MMLog.e(AdPlacementReporter.access$100(), (new StringBuilder()).append("Failed to delete reporting file <").append(file.getName()).append(">").toString());
            } else
            {
                j--;
            }
            i++;
        }
        AdPlacementReporter.access$200().addAndGet(j);
    }

    private static File[] getEventsToUpload()
    {
        return AdPlacementReporter.access$000().listFiles(new FilenameFilter() {

            public boolean accept(File file, String s)
            {
                return s.endsWith(".json");
            }

        });
    }

    private static void incrementQueuedEventsCount()
    {
        synchronized (AdPlacementReporter.access$300())
        {
            int i = AdPlacementReporter.access$200().incrementAndGet();
            if (AdPlacementReporter.access$400() == te.IDLE && i >= Handshake.getReportingBatchSize())
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(AdPlacementReporter.access$100(), "Reporting batch size limit detected -- requesting upload");
                }
                setUploadState(te.UPLOADING);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static String readFromFile(File file)
    {
        Object obj;
        Object obj3;
        Object obj4;
        Object obj1 = null;
        obj3 = null;
        obj4 = null;
        obj = obj4;
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_43;
        }
        obj = obj1;
        Object obj2 = new FileInputStream(file);
        obj = IOUtils.read(((java.io.InputStream) (obj2)), "UTF-8");
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        try
        {
            ((FileInputStream) (obj2)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            MMLog.e(AdPlacementReporter.access$100(), (new StringBuilder()).append("Failed to close file <").append(file.getName()).append(">").toString(), ((Throwable) (obj2)));
            return ((String) (obj));
        }
_L2:
        return ((String) (obj));
        obj;
        obj2 = obj3;
        obj3 = obj;
_L5:
        obj = obj2;
        MMLog.e(AdPlacementReporter.access$100(), (new StringBuilder()).append("Error opening file <").append(file.getName()).append(">").toString(), ((Throwable) (obj3)));
        obj = obj4;
        if (obj2 == null) goto _L2; else goto _L1
_L1:
        try
        {
            ((FileInputStream) (obj2)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.e(AdPlacementReporter.access$100(), (new StringBuilder()).append("Failed to close file <").append(file.getName()).append(">").toString(), ((Throwable) (obj)));
            return null;
        }
        return null;
        obj2;
_L4:
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MMLog.e(AdPlacementReporter.access$100(), (new StringBuilder()).append("Failed to close file <").append(file.getName()).append(">").toString(), ((Throwable) (obj)));
            }
        }
        throw obj2;
        obj3;
        obj = obj2;
        obj2 = obj3;
        if (true) goto _L4; else goto _L3
_L3:
        obj3;
          goto _L5
        return ((String) (obj));
    }

    private static JSONObject retrieveEvent(File file)
    {
        Object obj = null;
        if (file.exists())
        {
            obj = readFromFile(file);
            try
            {
                obj = new JSONObject(((String) (obj)));
            }
            catch (JSONException jsonexception)
            {
                MMLog.e(AdPlacementReporter.access$100(), (new StringBuilder()).append("Error parsing reporting file <").append(file.getName()).append(">").toString(), jsonexception);
                return null;
            }
        }
        return ((JSONObject) (obj));
    }

    private static String retrieveSiteId()
    {
        return readFromFile(new File(AdPlacementReporter.access$000(), "siteid"));
    }

    public static boolean saveToFile(File file, String s)
    {
        Object obj;
        Object obj2;
        boolean flag;
        flag = false;
        obj = null;
        obj2 = null;
        Object obj1 = new FileOutputStream(file);
        IOUtils.write(((java.io.OutputStream) (obj1)), s);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        try
        {
            ((FileOutputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMLog.e(AdPlacementReporter.access$100(), (new StringBuilder()).append("Failed to close file <").append(file.getName()).append(">").toString(), s);
            return false;
        }
        flag = true;
_L2:
        return flag;
        obj1;
        s = obj2;
_L5:
        obj = s;
        MMLog.e(AdPlacementReporter.access$100(), (new StringBuilder()).append("Error writing to file <").append(file.getName()).append(">").toString(), ((Throwable) (obj1)));
        if (s == null) goto _L2; else goto _L1
_L1:
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMLog.e(AdPlacementReporter.access$100(), (new StringBuilder()).append("Failed to close file <").append(file.getName()).append(">").toString(), s);
            return false;
        }
        return true;
        s;
_L4:
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MMLog.e(AdPlacementReporter.access$100(), (new StringBuilder()).append("Failed to close file <").append(file.getName()).append(">").toString(), ((Throwable) (obj)));
            }
        }
        throw s;
        s;
        obj = obj1;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        s = ((String) (obj1));
        obj1 = exception;
          goto _L5
        return false;
    }

    private static boolean setEventAsCompleted(File file, boolean flag)
    {
        File file1 = new File(file.getPath().replace(".tmp", ".json"));
        if (file1.exists())
        {
            MMLog.w(AdPlacementReporter.access$100(), (new StringBuilder()).append("Target file already exists + <").append(file1.getName()).append(">").toString());
        } else
        if (file.renameTo(file1))
        {
            if (flag)
            {
                incrementQueuedEventsCount();
            }
            return true;
        }
        MMLog.w(AdPlacementReporter.access$100(), (new StringBuilder()).append("Unable to rename temp file <").append(file.getName()).append(">").toString());
        if (!file.delete())
        {
            MMLog.e(AdPlacementReporter.access$100(), (new StringBuilder()).append("Error deleting temp file <").append(file.getName()).append(">").toString());
        }
        return false;
    }

    static void setUploadState(te te)
    {
label0:
        {
            synchronized (AdPlacementReporter.access$300())
            {
                if (te != AdPlacementReporter.access$400())
                {
                    break label0;
                }
            }
            return;
        }
        AdPlacementReporter.access$402(te);
        obj;
        JVM INSTR monitorexit ;
        switch (Map.com.millennialmedia.internal.AdPlacementReporter.UploadState[AdPlacementReporter.access$400().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(AdPlacementReporter.access$100(), "Reporting upload state set to IDLE");
            }
            AdPlacementReporter.access$502(ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

                public void run()
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(AdPlacementReporter.access$100(), "Reporting batch frequency detected -- requesting upload");
                    }
                    AdPlacementReporter.Uploader.setUploadState(AdPlacementReporter.UploadState.UPLOADING);
                }

            }, Handshake.getReportingBatchFrequency()));
            return;

        case 2: // '\002'
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(AdPlacementReporter.access$100(), "Reporting upload state set to UPLOADING");
            }
            if (AdPlacementReporter.access$500() != null)
            {
                AdPlacementReporter.access$500().cancel();
            }
            uploadNow();
            return;

        case 3: // '\003'
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(AdPlacementReporter.access$100(), "Reporting upload state set to ERROR_NETWORK_UNAVAILABLE");
            }
            EnvironmentUtils.getApplicationContext().registerReceiver(new BroadcastReceiver() {

                public void onReceive(Context context, Intent intent)
                {
                    if (EnvironmentUtils.isNetworkAvailable())
                    {
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(AdPlacementReporter.access$100(), "Reporting detected network is now available -- requesting upload");
                        }
                        EnvironmentUtils.getApplicationContext().unregisterReceiver(this);
                        AdPlacementReporter.Uploader.setUploadState(AdPlacementReporter.UploadState.UPLOADING);
                    }
                }

            }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            return;

        case 4: // '\004'
            break;
        }
        break MISSING_BLOCK_LABEL_177;
        te;
        obj;
        JVM INSTR monitorexit ;
        throw te;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(AdPlacementReporter.access$100(), "Reporting upload state set to ERROR_SENDING_TO_SERVER");
        }
        AdPlacementReporter.access$502(ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

            public void run()
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(AdPlacementReporter.access$100(), "Reporting batch frequency detected -- requesting upload");
                }
                AdPlacementReporter.Uploader.setUploadState(AdPlacementReporter.UploadState.UPLOADING);
            }

        }, Handshake.getReportingBatchFrequency()));
        return;
    }

    private static void start()
    {
        File _tmp = AdPlacementReporter.access$002(new File((new StringBuilder()).append(EnvironmentUtils.getMillennialDir()).append("/.reporting/").toString()));
        AdPlacementReporter.access$000().mkdirs();
        if (!AdPlacementReporter.access$000().isDirectory())
        {
            MMLog.e(AdPlacementReporter.access$100(), "Unable to creating reporting directory");
            return;
        } else
        {
            countQueuedEvents();
            com.millennialmedia.internal.utils. _tmp1 = AdPlacementReporter.access$502(ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

                public void run()
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(AdPlacementReporter.access$100(), "Reporting startup -- requesting upload");
                    }
                    AdPlacementReporter.Uploader.setUploadState(AdPlacementReporter.UploadState.UPLOADING);
                }

            }, 5000L));
            return;
        }
    }

    private static File storeEvent(String s, String s1, JSONObject jsonobject, boolean flag)
    {
        if (s1 == null)
        {
            s = null;
        } else
        {
            s1 = (new StringBuilder()).append(s).append(s1);
            if (flag)
            {
                s = ".json";
            } else
            {
                s = ".tmp";
            }
            s = s1.append(s).toString();
            s1 = new File(AdPlacementReporter.access$000(), s);
            s = s1;
            if (saveToFile(s1, jsonobject.toString()))
            {
                s = s1;
                if (flag)
                {
                    incrementQueuedEventsCount();
                    return s1;
                }
            }
        }
        return s;
    }

    private static void storeSiteId(String s)
    {
        saveToFile(new File(AdPlacementReporter.access$000(), "siteid"), s);
    }

    static void uploadNow()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(AdPlacementReporter.access$100(), "Reporting is starting upload");
        }
        ThreadUtils.runOnWorkerThread(new Runnable() {

            public void run()
            {
                Object obj;
                Object obj1;
                String s;
                obj = AdPlacementReporter.Uploader.getEventsToUpload();
                obj1 = AdPlacementReporter.UploadState.IDLE;
                s = Handshake.getReportingBaseUrl();
                if (s == null)
                {
                    MMLog.e(AdPlacementReporter.access$100(), "Unable to determine base url for request");
                    return;
                }
                s = s.concat(AdPlacementReporter.SSP_REPORTING_PATH);
                if (obj.length <= 0) goto _L2; else goto _L1
_L1:
                obj1 = AdPlacementReporter.Uploader.retrieveSiteId();
                if (TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    MMLog.e(AdPlacementReporter.access$100(), "Unable to upload report -- siteId has not been set");
                    obj = AdPlacementReporter.UploadState.ERROR_SENDING_TO_SERVER;
                } else
                {
                    String s1 = AdPlacementReporter.Uploader.buildRequest(((File []) (obj)));
                    obj1 = HttpUtils.getContentFromPostRequest((new StringBuilder()).append(s).append(AdPlacementReporter.SSP_SITE_ID_PARAMETER).append(((String) (obj1))).toString(), s1, "application/json");
                    if (((com.millennialmedia.internal.utils.HttpUtils.Response) (obj1)).code == 200)
                    {
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(AdPlacementReporter.access$100(), (new StringBuilder()).append("Reporting successfully uploaded ").append(obj.length).append(" events").toString());
                        }
                        AdPlacementReporter.Uploader.deleteUploadedEvents(((File []) (obj)));
                        if (AdPlacementReporter.access$200().get() >= Handshake.getReportingBatchSize())
                        {
                            AdPlacementReporter.Uploader.uploadNow();
                            return;
                        }
                        obj = AdPlacementReporter.UploadState.IDLE;
                    } else
                    if (!EnvironmentUtils.isNetworkAvailable())
                    {
                        MMLog.e(AdPlacementReporter.access$100(), "Reporting failed to upload because network is unavailable");
                        obj = AdPlacementReporter.UploadState.ERROR_NETWORK_UNAVAILABLE;
                    } else
                    {
                        MMLog.e(AdPlacementReporter.access$100(), (new StringBuilder()).append("Reporting failed to upload with response code <").append(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj1)).code).append(">").toString());
                        obj = AdPlacementReporter.UploadState.ERROR_SENDING_TO_SERVER;
                    }
                }
_L4:
                AdPlacementReporter.Uploader.setUploadState(((AdPlacementReporter.UploadState) (obj)));
                return;
_L2:
                obj = obj1;
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(AdPlacementReporter.access$100(), "Reporting found no events to upload");
                    obj = obj1;
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

        });
    }









    _cls6()
    {
    }
}
