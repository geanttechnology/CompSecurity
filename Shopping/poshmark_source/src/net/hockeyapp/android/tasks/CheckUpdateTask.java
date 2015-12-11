// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.tasks;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import net.hockeyapp.android.Constants;
import net.hockeyapp.android.Strings;
import net.hockeyapp.android.Tracking;
import net.hockeyapp.android.UpdateActivity;
import net.hockeyapp.android.UpdateFragment;
import net.hockeyapp.android.UpdateManager;
import net.hockeyapp.android.UpdateManagerListener;
import net.hockeyapp.android.utils.VersionCache;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckUpdateTask extends AsyncTask
    implements TraceFieldInterface
{

    private static final int MAX_NUMBER_OF_VERSIONS = 25;
    public Trace _nr_trace;
    private Activity activity;
    protected String appIdentifier;
    private UpdateManagerListener listener;
    private Boolean mandatory;
    protected String urlString;
    private long usageTime;

    public CheckUpdateTask(WeakReference weakreference, String s)
    {
        urlString = null;
        appIdentifier = null;
        activity = null;
        mandatory = Boolean.valueOf(false);
        usageTime = 0L;
        appIdentifier = null;
        urlString = s;
        if (weakreference != null)
        {
            activity = (Activity)weakreference.get();
        }
        if (activity != null)
        {
            usageTime = Tracking.getUsageTime(activity);
            Constants.loadFromContext(activity);
        }
    }

    public CheckUpdateTask(WeakReference weakreference, String s, String s1)
    {
        urlString = null;
        appIdentifier = null;
        activity = null;
        mandatory = Boolean.valueOf(false);
        usageTime = 0L;
        appIdentifier = s1;
        urlString = s;
        if (weakreference != null)
        {
            activity = (Activity)weakreference.get();
        }
        if (activity != null)
        {
            usageTime = Tracking.getUsageTime(activity);
            Constants.loadFromContext(activity);
        }
    }

    public CheckUpdateTask(WeakReference weakreference, String s, String s1, UpdateManagerListener updatemanagerlistener)
    {
        urlString = null;
        appIdentifier = null;
        activity = null;
        mandatory = Boolean.valueOf(false);
        usageTime = 0L;
        appIdentifier = s1;
        urlString = s;
        listener = updatemanagerlistener;
        if (weakreference != null)
        {
            activity = (Activity)weakreference.get();
        }
        if (activity != null)
        {
            usageTime = Tracking.getUsageTime(activity);
            Constants.loadFromContext(activity);
        }
    }

    private void cleanUp()
    {
        activity = null;
        urlString = null;
        appIdentifier = null;
    }

    private static String convertStreamToString(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream), 1024);
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
          goto _L1
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        return stringbuilder.toString();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        Exception exception;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        throw exception;
    }

    private String encodeParam(String s)
    {
        try
        {
            s = URLEncoder.encode(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    private boolean findNewVersion(JSONArray jsonarray, int i)
    {
        boolean flag1 = false;
        int j = 0;
        do
        {
label0:
            {
label1:
                {
                    boolean flag = flag1;
                    try
                    {
                        if (j >= jsonarray.length())
                        {
                            break label1;
                        }
                        JSONObject jsonobject = jsonarray.getJSONObject(j);
                        if (jsonobject.getInt("version") <= i)
                        {
                            break label0;
                        }
                        if (jsonobject.has("mandatory"))
                        {
                            mandatory = Boolean.valueOf(jsonobject.getBoolean("mandatory"));
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (JSONArray jsonarray)
                    {
                        return false;
                    }
                    flag = true;
                }
                return flag;
            }
            j++;
        } while (true);
    }

    private JSONArray limitResponseSize(JSONArray jsonarray)
    {
        JSONArray jsonarray1 = new JSONArray();
        int i = 0;
        while (i < Math.min(jsonarray.length(), 25)) 
        {
            try
            {
                jsonarray1.put(jsonarray.get(i));
            }
            catch (JSONException jsonexception) { }
            i++;
        }
        return jsonarray1;
    }

    private void showDialog(final JSONArray updateInfo)
    {
        if (getCachingEnabled())
        {
            Activity activity1 = activity;
            String s;
            if (!(updateInfo instanceof JSONArray))
            {
                s = updateInfo.toString();
            } else
            {
                s = JSONArrayInstrumentation.toString((JSONArray)updateInfo);
            }
            VersionCache.setVersionInfo(activity1, s);
        }
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(Strings.get(listener, 9));
        if (!mandatory.booleanValue())
        {
            builder.setMessage(Strings.get(listener, 10));
            builder.setNegativeButton(Strings.get(listener, 11), new android.content.DialogInterface.OnClickListener() {

                final CheckUpdateTask this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    cleanUp();
                }

            
            {
                this$0 = CheckUpdateTask.this;
                super();
            }
            });
            builder.setPositiveButton(Strings.get(listener, 12), new android.content.DialogInterface.OnClickListener() {

                final CheckUpdateTask this$0;
                final JSONArray val$updateInfo;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    if (getCachingEnabled())
                    {
                        VersionCache.setVersionInfo(activity, "[]");
                    }
                    dialoginterface = new WeakReference(activity);
                    if (UpdateManager.fragmentsSupported().booleanValue() && UpdateManager.runsOnTablet(dialoginterface).booleanValue())
                    {
                        showUpdateFragment(updateInfo);
                        return;
                    } else
                    {
                        startUpdateIntent(updateInfo, Boolean.valueOf(false));
                        return;
                    }
                }

            
            {
                this$0 = CheckUpdateTask.this;
                updateInfo = jsonarray;
                super();
            }
            });
            builder.create().show();
            return;
        } else
        {
            Toast.makeText(activity, Strings.get(listener, 8), 1).show();
            startUpdateIntent(updateInfo, Boolean.valueOf(true));
            return;
        }
    }

    private void showUpdateFragment(JSONArray jsonarray)
    {
        Object obj;
        FragmentTransaction fragmenttransaction;
        if (activity == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        fragmenttransaction = activity.getFragmentManager().beginTransaction();
        fragmenttransaction.setTransition(4097);
        obj = activity.getFragmentManager().findFragmentByTag("hockey_update_dialog");
        if (obj != null)
        {
            fragmenttransaction.remove(((android.app.Fragment) (obj)));
        }
        fragmenttransaction.addToBackStack(null);
        obj = net/hockeyapp/android/UpdateFragment;
        if (listener != null)
        {
            obj = listener.getUpdateFragmentClass();
        }
        ((DialogFragment)((Class) (obj)).getMethod("newInstance", new Class[] {
            org/json/JSONArray, java/lang/String
        }).invoke(null, new Object[] {
            jsonarray, getURLString("apk")
        })).show(fragmenttransaction, "hockey_update_dialog");
        return;
        Exception exception;
        exception;
        Log.d("HockeyApp", "An exception happened while showing the update fragment:");
        exception.printStackTrace();
        Log.d("HockeyApp", "Showing update activity instead.");
        startUpdateIntent(jsonarray, Boolean.valueOf(false));
        return;
    }

    private void startUpdateIntent(JSONArray jsonarray, Boolean boolean1)
    {
        Class class1 = null;
        if (listener != null)
        {
            class1 = listener.getUpdateActivityClass();
        }
        Object obj = class1;
        if (class1 == null)
        {
            obj = net/hockeyapp/android/UpdateActivity;
        }
        if (activity != null)
        {
            Intent intent = new Intent();
            intent.setClass(activity, ((Class) (obj)));
            if (!(jsonarray instanceof JSONArray))
            {
                jsonarray = jsonarray.toString();
            } else
            {
                jsonarray = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
            }
            intent.putExtra("json", jsonarray);
            intent.putExtra("url", getURLString("apk"));
            activity.startActivity(intent);
            if (boolean1.booleanValue())
            {
                activity.finish();
            }
        }
        cleanUp();
    }

    public void _nr_setTrace(Trace trace)
    {
        try
        {
            _nr_trace = trace;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Trace trace)
        {
            return;
        }
    }

    public void attach(WeakReference weakreference)
    {
        if (weakreference != null)
        {
            activity = (Activity)weakreference.get();
        }
        if (activity != null)
        {
            Constants.loadFromContext(activity);
        }
    }

    protected URLConnection createConnection(URL url)
        throws IOException
    {
        url = HttpInstrumentation.openConnection(url.openConnection());
        url.addRequestProperty("User-Agent", "Hockey/Android");
        if (android.os.Build.VERSION.SDK_INT <= 9)
        {
            url.setRequestProperty("connection", "close");
        }
        return url;
    }

    public void detach()
    {
        activity = null;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "CheckUpdateTask#doInBackground", null);
_L1:
        aobj = doInBackground((String[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "CheckUpdateTask#doInBackground", null);
          goto _L1
    }

    protected transient JSONArray doInBackground(String as[])
    {
        int i;
        i = getVersionCode();
        as = JSONArrayInstrumentation.init(VersionCache.getVersionInfo(activity));
        if (getCachingEnabled() && findNewVersion(as, i))
        {
            return as;
        }
        as = createConnection(new URL(getURLString("json")));
        as.connect();
        as = new BufferedInputStream(as.getInputStream());
        String s = convertStreamToString(as);
        as.close();
        as = JSONArrayInstrumentation.init(s);
        if (!findNewVersion(as, i))
        {
            break MISSING_BLOCK_LABEL_105;
        }
        as = limitResponseSize(as);
        return as;
        as;
        as.printStackTrace();
        return null;
    }

    protected boolean getCachingEnabled()
    {
        return true;
    }

    protected String getURLString(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(urlString);
        stringbuilder.append("api/2/apps/");
        String s1;
        if (appIdentifier != null)
        {
            s1 = appIdentifier;
        } else
        {
            s1 = activity.getPackageName();
        }
        stringbuilder.append(s1);
        stringbuilder.append((new StringBuilder()).append("?format=").append(s).toString());
        if (android.provider.Settings.Secure.getString(activity.getContentResolver(), "android_id") != null)
        {
            stringbuilder.append((new StringBuilder()).append("&udid=").append(encodeParam(android.provider.Settings.Secure.getString(activity.getContentResolver(), "android_id"))).toString());
        }
        stringbuilder.append("&os=Android");
        stringbuilder.append((new StringBuilder()).append("&os_version=").append(encodeParam(Constants.ANDROID_VERSION)).toString());
        stringbuilder.append((new StringBuilder()).append("&device=").append(encodeParam(Constants.PHONE_MODEL)).toString());
        stringbuilder.append((new StringBuilder()).append("&oem=").append(encodeParam(Constants.PHONE_MANUFACTURER)).toString());
        stringbuilder.append((new StringBuilder()).append("&app_version=").append(encodeParam(Constants.APP_VERSION)).toString());
        stringbuilder.append((new StringBuilder()).append("&sdk=").append(encodeParam("HockeySDK")).toString());
        stringbuilder.append((new StringBuilder()).append("&sdk_version=").append(encodeParam("3.0.0")).toString());
        stringbuilder.append((new StringBuilder()).append("&lang=").append(encodeParam(Locale.getDefault().getLanguage())).toString());
        stringbuilder.append((new StringBuilder()).append("&usage_time=").append(usageTime).toString());
        return stringbuilder.toString();
    }

    protected int getVersionCode()
    {
        return Integer.parseInt(Constants.APP_VERSION);
    }

    protected volatile void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "CheckUpdateTask#onPostExecute", null);
_L1:
        onPostExecute((JSONArray)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "CheckUpdateTask#onPostExecute", null);
          goto _L1
    }

    protected void onPostExecute(JSONArray jsonarray)
    {
        if (jsonarray != null)
        {
            if (listener != null)
            {
                listener.onUpdateAvailable();
            }
            showDialog(jsonarray);
        } else
        if (listener != null)
        {
            listener.onNoUpdateAvailable();
            return;
        }
    }




}
