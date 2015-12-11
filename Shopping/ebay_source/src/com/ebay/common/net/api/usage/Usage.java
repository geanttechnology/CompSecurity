// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.usage;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.net.IRequestLogger;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.RequestLoggerFactory;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.shell.app.ActivityShim;
import com.ebay.nautilus.shell.app.ActivityShimManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

public class Usage
{
    private static class BackgroundLogger extends Handler
    {

        private byte[] getRequestAsBytes(String s)
        {
            StringBuilder stringbuilder;
            s = Uri.parse(s);
            stringbuilder = new StringBuilder();
            stringbuilder.append(s.getQueryParameter("optype")).append(",");
            if (s.getQueryParameter("name") == null) goto _L2; else goto _L1
_L1:
            stringbuilder.append(s.getQueryParameter("name")).append(",");
_L4:
            stringbuilder.append(s.getQueryParameter("os")).append(",");
            stringbuilder.append(s.getQueryParameter("osv")).append(",");
            stringbuilder.append(s.getQueryParameter("dmodel")).append(",");
            stringbuilder.append(s.getQueryParameter("appn")).append(",");
            stringbuilder.append(s.getQueryParameter("appv")).append(",");
            stringbuilder.append(s.getQueryParameter("guid")).append(",");
            stringbuilder.append(s.getQueryParameter("pid")).append(",");
            stringbuilder.append(s.getQueryParameter("ssnid")).append(",");
            stringbuilder.append(s.getQueryParameter("timestamp")).append("\n");
            return stringbuilder.toString().getBytes();
_L2:
            if (s.getQueryParameter("aid") != null)
            {
                stringbuilder.append(s.getQueryParameter("aid")).append(",");
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void handleMessage(Message message)
        {
            Object obj;
            String s;
            s = (String)message.obj;
            obj = null;
            message = null;
            Usage.apiUsageLogging.log(s);
            Object obj1 = (HttpURLConnection)(new URL(s)).openConnection();
            message = ((Message) (obj1));
            obj = obj1;
            int i = ((HttpURLConnection) (obj1)).getResponseCode();
            if (i == 200)
            {
                break MISSING_BLOCK_LABEL_85;
            }
            message = ((Message) (obj1));
            obj = obj1;
            Usage.apiUsageLogging.logAsWarning((new StringBuilder()).append("http usage logging failed, response code is ").append(i).toString());
            if (obj1 != null)
            {
                ((HttpURLConnection) (obj1)).disconnect();
            }
_L1:
            Object obj2;
            obj = new File(Usage.CSV_LOG_FILE_NAME);
            if (!((File) (obj)).exists() || TextUtils.isEmpty(s))
            {
                break MISSING_BLOCK_LABEL_154;
            }
            obj2 = null;
            message = null;
            obj1 = null;
            obj = new FileOutputStream(((File) (obj)), true);
            ((FileOutputStream) (obj)).write(getRequestAsBytes(s));
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_154;
            }
            ((FileOutputStream) (obj)).close();
_L2:
            return;
            obj1;
            obj = message;
            Usage.apiUsageLogging.logAsWarning((new StringBuilder()).append("http usage logging failed, connection issue: ").append(((Exception) (obj1)).getMessage()).toString());
            if (message != null)
            {
                message.disconnect();
            }
              goto _L1
            message;
            if (obj != null)
            {
                ((HttpURLConnection) (obj)).disconnect();
            }
            throw message;
            message;
            Usage.apiUsageLogging.logAsWarning((new StringBuilder()).append("local usage logging error, unable to close filestream: ").append(message.getMessage()).toString());
              goto _L2
            message;
            obj = obj1;
            obj1 = message;
_L10:
            message = ((Message) (obj));
            Usage.apiUsageLogging.logAsWarning((new StringBuilder()).append("local usage logging error, unable to find file: ").append(((FileNotFoundException) (obj1)).getMessage()).toString());
            if (obj == null) goto _L2; else goto _L3
_L3:
            ((FileOutputStream) (obj)).close();
_L4:
            return;
            message;
            Usage.apiUsageLogging.logAsWarning((new StringBuilder()).append("local usage logging error, unable to close filestream: ").append(message.getMessage()).toString());
              goto _L4
            IOException ioexception;
            ioexception;
            obj = obj2;
_L9:
            message = ((Message) (obj));
            Usage.apiUsageLogging.logAsWarning((new StringBuilder()).append("local usage logging error, unable to write to file: ").append(ioexception.getMessage()).toString());
            if (obj == null) goto _L2; else goto _L5
_L5:
            ((FileOutputStream) (obj)).close();
_L6:
            return;
            message;
            Usage.apiUsageLogging.logAsWarning((new StringBuilder()).append("local usage logging error, unable to close filestream: ").append(message.getMessage()).toString());
              goto _L6
            obj;
_L8:
            if (message != null)
            {
                try
                {
                    message.close();
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Usage.apiUsageLogging.logAsWarning((new StringBuilder()).append("local usage logging error, unable to close filestream: ").append(message.getMessage()).toString());
                }
            }
            throw obj;
            ioexception;
            message = ((Message) (obj));
            obj = ioexception;
            if (true) goto _L8; else goto _L7
_L7:
            ioexception;
              goto _L9
            ioexception;
              goto _L10
        }

        BackgroundLogger(Looper looper)
        {
            super(looper);
        }
    }

    public static final class UsageActivityShim extends ActivityShim
    {

        protected void onCreate(Bundle bundle)
        {
            Usage.inst.startActivity(getActivity().getClass());
        }

        protected void onDestroy()
        {
            Usage.inst.endActivity(getActivity().getClass());
        }

        public UsageActivityShim()
        {
        }
    }

    private class UsageInterceptor extends RequestLoggerFactory
    {

        final Usage this$0;

        public IRequestLogger create(Request request)
        {
            return request. new IRequestLogger() {

                final UsageInterceptor this$1;
                final Request val$request;

                public void logHostError(int i)
                {
                }

                public void setCompleteResponse(Response response)
                {
                }

                public void setRequestTime(long l)
                {
                    Object obj = request.getOperationName();
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        invoke(((String) (obj)));
                        return;
                    }
                    obj = request.getRequestUrl();
                    if (((URL) (obj)).getHost().contains("rover"))
                    {
                        invoke("rover");
                        return;
                    } else
                    {
                        invoke(((URL) (obj)));
                        return;
                    }
                }

                public void setResponseTime(long l)
                {
                }

            
            {
                this$1 = final_usageinterceptor;
                request = Request.this;
                super();
            }
            };
        }

        private UsageInterceptor()
        {
            this$0 = Usage.this;
            super();
        }

    }


    private static final String API_USAGE_PREFERENCES = "com.ebay.api_usage.prefs";
    private static final String CSV_LOG_FILE_NAME;
    private static final String OPERATION_ACTIVITY_START = "ActStart";
    private static final String OPERATION_ACTIVITY_STOP = "ActStop";
    private static final String OPERATION_API_CALL = "ApiCall";
    private static final String OPERATION_SESSION_START = "SsnStart";
    private static final String OPERATION_SESSION_STOP = "SsnStop";
    private static final String PREFERENCES_SESSION_KEY = "ApiUsageLoggingSession";
    private static final String URL_QUERY_PARAMETER_ACTIVITY_NAME = "aid";
    private static final String URL_QUERY_PARAMETER_API_NAME = "name";
    private static final String URL_QUERY_PARAMETER_APP_NAME = "appn";
    private static final String URL_QUERY_PARAMETER_APP_VERSION = "appv";
    private static final String URL_QUERY_PARAMETER_DEVICE_MODEL = "dmodel";
    private static final String URL_QUERY_PARAMETER_DEVICE_NAME = "guid";
    private static final String URL_QUERY_PARAMETER_OPERATION_TYPE = "optype";
    private static final String URL_QUERY_PARAMETER_OS = "os";
    private static final String URL_QUERY_PARAMETER_OS_VERSION = "osv";
    private static final String URL_QUERY_PARAMETER_PROCESS_ID = "pid";
    private static final String URL_QUERY_PARAMETER_SESSION_ID = "ssnid";
    private static final String URL_QUERY_PARAMETER_TIMESTAMP = "timestamp";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo apiUsageLogging = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("eBayApiUsageLogging", 3, "Log API usage");
    private static Usage inst = null;
    private final String DELETE_URL = "http://ebayz.criticalpath.com/usage/logging/annotate";
    private final String ENDPOINT_URL = "http://ebayz.criticalpath.com/usage/logging/record";
    private final Application application;
    private String deviceName;
    private final BackgroundLogger logger;
    private String session;
    private String sessionName;
    private final String version;

    private Usage(Application application1)
    {
        Assert.assertNotNull(application1);
        Assert.assertNull(inst);
        application = application1;
        HandlerThread handlerthread = new HandlerThread("ApiUsageLoggingThread");
        handlerthread.start();
        logger = new BackgroundLogger(handlerthread.getLooper());
        version = NautilusKernel.getAppVersionName(application1);
        RequestLoggerFactory.add(new UsageInterceptor());
        ActivityShimManager.addActivityShimClass(com/ebay/common/net/api/usage/Usage$UsageActivityShim);
        startActivity(application1.getClass());
    }

    private void createFile()
    {
        File file1 = new File(CSV_LOG_FILE_NAME);
        File file = file1;
        if (file1.exists())
        {
            file1.delete();
            file = new File(CSV_LOG_FILE_NAME);
        }
        try
        {
            file.createNewFile();
            return;
        }
        catch (IOException ioexception)
        {
            apiUsageLogging.logAsWarning((new StringBuilder()).append("local usage logging error, unable to create log file: ").append(ioexception.getMessage()).toString());
        }
    }

    private void generateSession()
    {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        StringBuilder stringbuilder = new StringBuilder();
        if (sessionName != null && sessionName.length() > 0)
        {
            stringbuilder.append(sessionName);
            stringbuilder.append('-');
        }
        stringbuilder.append(simpledateformat.format(date));
        stringbuilder.append('-');
        if (deviceName != null && deviceName.length() > 0)
        {
            stringbuilder.append(deviceName);
        } else
        {
            stringbuilder.append("unknown");
        }
        session = stringbuilder.toString();
    }

    public static Usage getInst()
    {
        return inst;
    }

    private String getSession()
    {
        return application.getSharedPreferences("com.ebay.api_usage.prefs", 0).getString("ApiUsageLoggingSession", null);
    }

    public static void init(Application application1)
    {
        if (isEnabled())
        {
            inst = new Usage(application1);
        }
    }

    public static boolean isEnabled()
    {
        return apiUsageLogging.isLoggable;
    }

    private void send(String s, String s1, String s2)
    {
        if (!isEnabled() || !isSessionActive())
        {
            return;
        }
        android.net.Uri.Builder builder = Uri.parse("http://ebayz.criticalpath.com/usage/logging/record").buildUpon();
        builder.appendQueryParameter("optype", s);
        builder.appendQueryParameter("os", "android");
        builder.appendQueryParameter("dmodel", Build.MODEL);
        builder.appendQueryParameter("osv", android.os.Build.VERSION.RELEASE);
        builder.appendQueryParameter("appn", "AEAPP");
        builder.appendQueryParameter("appv", version);
        builder.appendQueryParameter("guid", getDeviceName());
        builder.appendQueryParameter("pid", Integer.toString(Process.myPid()));
        builder.appendQueryParameter("timestamp", Long.toString(System.currentTimeMillis()));
        builder.appendQueryParameter("ssnid", getSession());
        if (!TextUtils.isEmpty(s2))
        {
            builder.appendQueryParameter("name", s2);
        }
        if (!TextUtils.isEmpty(s1))
        {
            builder.appendQueryParameter("aid", s1);
        }
        s = logger.obtainMessage();
        s.obj = builder.build().toString();
        logger.sendMessage(s);
    }

    private void setSession(String s)
    {
        android.content.SharedPreferences.Editor editor = application.getSharedPreferences("com.ebay.api_usage.prefs", 0).edit();
        if (s != null)
        {
            editor.putString("ApiUsageLoggingSession", s);
        } else
        {
            editor.remove("ApiUsageLoggingSession");
        }
        editor.commit();
    }

    public void deleteFile()
    {
        File file = new File(CSV_LOG_FILE_NAME);
        if (file.exists())
        {
            file.delete();
        }
    }

    final void endActivity(Class class1)
    {
        send("ActStop", class1.getSimpleName(), null);
    }

    public final void endSession()
    {
        send("SsnStop", "SsnStop", null);
        session = null;
        setSession(null);
    }

    public final String getDeviceName()
    {
        if (TextUtils.isEmpty(deviceName))
        {
            return "unknown";
        } else
        {
            return deviceName;
        }
    }

    public final String getSessionName()
    {
        return sessionName;
    }

    public final void invoke(Uri uri)
    {
        String s = uri.getHost();
        if (s.contains("clientalerts.ebay.com") && uri.getEncodedQuery().contains("callname=Login"))
        {
            uri = "GetClientAlertsLogin";
        } else
        if (s.contains("clientalerts.ebay.com") && uri.getEncodedQuery().contains("callname=GetUserAlerts"))
        {
            uri = "GetClientAlerts";
        } else
        if (s.contains("anywhere.ebay.com"))
        {
            uri = "Deals";
        } else
        if (uri.getQuery() != null && uri.getQuery().contains("ViewItemLite"))
        {
            uri = "ViewItemLite";
        } else
        if (s.startsWith("autosug.ebay.com"))
        {
            uri = "AutoSuggestionSearch";
        } else
        if (s.contains("thumbs") || s.equals("rtm.ebaystatic.com"))
        {
            uri = "GetImageThumbnail";
        } else
        if (s.contains("ebayimg.com") || s.equals("img.youtube.com"))
        {
            uri = "GetImage";
        } else
        if (s.contains("pushnotifications"))
        {
            uri = "RTUConnect";
        } else
        if (uri.getPath().contains("autofill"))
        {
            uri = "GetAutoComplete";
        } else
        if (s.contains("autocomplete.ebay.com"))
        {
            uri = "AutoCompleteQueryService";
        } else
        if (s.equals("apigrid.ebay.com"))
        {
            uri = "ApiGrid";
        } else
        if (s.startsWith("syicatalogs.ebay.com"))
        {
            uri = "ProductDetails";
        } else
        if (s.equals("auth.ebay.com"))
        {
            uri = "SSO";
        } else
        if (s.endsWith("paypal.com"))
        {
            uri = "PayPal";
        } else
        if (s.startsWith("srx.main.ebayrtm.com"))
        {
            uri = "RtmCampaignTracking";
        } else
        if (s.startsWith("cgi5.ebay.com") && uri.getEncodedQuery().contains("Command=Syi3GetSellerTags"))
        {
            uri = "SellerTagSpellCheck";
        } else
        if (uri.getPath().equals("/selling/ListingDraftService/v1/getSavedListingDrafts"))
        {
            uri = "getSavedListingDrafts";
        } else
        if (uri.getPath().equals("/selling/ListingDraftService/v1/createListingDraft"))
        {
            uri = "createListingDraft";
        } else
        if (uri.getPath().equals("/selling/ListingDraftService/v1/updateListingDraft"))
        {
            uri = "updateListingDraft";
        } else
        if (uri.getPath().equals("/selling/ListingDraftService/v1/publishListingDraft"))
        {
            uri = "publishListingDraft";
        } else
        if (uri.getPath().equals("selling/ListingDraftService/v1/deleteSavedListingDrafts"))
        {
            uri = "deleteSavedListingDrafts";
        } else
        if (uri.getPath().equals("/buying/search/v1"))
        {
            uri = "searchAsAService";
        } else
        if (uri.getPath().equals("/selling/inventorylookup/v1/availability"))
        {
            uri = "inventoryLookup";
        } else
        if (uri.getPath().equals("/mobile/motors/scantowininfo2.xml"))
        {
            uri = "getMotorsScanToWinConfig";
        } else
        if (uri.getPath().equals("/mobile/motors/videos1.xml"))
        {
            uri = "getMotorsVideoManagerConfig";
        } else
        if (uri.getPath().equals("/mobile/motors/mvl.db.gz"))
        {
            uri = "getMotorsMVLConfig";
        } else
        if (uri.getPath().equals("/mobile/motors/mml.db.gz"))
        {
            uri = "getMotorsMMLConfig";
        } else
        if (uri.getPath().equals("/mobile/motors/android_motors_categories.xml"))
        {
            uri = "getMotorsCategoriesConfig";
        } else
        {
            apiUsageLogging.logAsError("unidentified api", new Exception(uri.toString()));
            if (!TextUtils.isEmpty(uri.getHost()))
            {
                uri = uri.getHost().replace('.', '_');
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("no host in url, ").append(uri.toString()).toString());
            }
        }
        send("ApiCall", null, uri);
    }

    final void invoke(String s)
    {
        if (s == null && isEnabled())
        {
            apiUsageLogging.logAsWarning("no api name specified", new Exception());
            return;
        } else
        {
            send("ApiCall", null, s);
            return;
        }
    }

    final void invoke(URL url)
    {
        invoke(Uri.parse(url.toString()));
    }

    public final boolean isSessionActive()
    {
        boolean flag = false;
        if (application.getSharedPreferences("com.ebay.api_usage.prefs", 0).getString("ApiUsageLoggingSession", null) != null)
        {
            flag = true;
        }
        return flag;
    }

    public final void markForDeleteSession()
    {
        if (!isEnabled() || !isSessionActive())
        {
            return;
        } else
        {
            android.net.Uri.Builder builder = Uri.parse("http://ebayz.criticalpath.com/usage/logging/annotate").buildUpon();
            builder.appendQueryParameter("guid", getDeviceName());
            builder.appendQueryParameter("keep", "false");
            Message message = logger.obtainMessage();
            message.obj = builder.build().toString();
            logger.sendMessage(message);
            return;
        }
    }

    public void sendUsageEmail(Context context)
    {
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        File file = new File(CSV_LOG_FILE_NAME);
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_120;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        String s;
        if (TextUtils.isEmpty(sessionName))
        {
            s = "Unknown session";
        } else
        {
            s = sessionName;
        }
        intent.putExtra("android.intent.extra.SUBJECT", s);
        intent.putExtra("android.intent.extra.TEXT", "n/t");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        context.startActivity(intent);
_L1:
        return;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Toast.makeText(context, "This device has no app installed to handle an Email with an attachment...", 1).show();
        return;
        if (!"mounted".equals(Environment.getExternalStorageState()))
        {
            apiUsageLogging.logAsWarning((new StringBuilder()).append("local usage logging error, unable to send email due to issue with external storage. storage state: ").append(Environment.getExternalStorageState()).toString());
            return;
        }
          goto _L1
    }

    public final void setDeviceName(String s)
    {
        if (s != null)
        {
            deviceName = s.replace(' ', '_');
        }
    }

    public final void setSessionName(String s)
    {
        if (s != null)
        {
            sessionName = s.replace(' ', '_');
        }
    }

    final void startActivity(Class class1)
    {
        send("ActStart", class1.getSimpleName(), null);
    }

    public final void startSession()
    {
        generateSession();
        setSession(session);
        createFile();
        send("SsnStart", "SsnStart", null);
    }

    static 
    {
        CSV_LOG_FILE_NAME = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append(File.separator).append("api_profiling.csv").toString();
    }



}
