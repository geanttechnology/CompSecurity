// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.TraceMachine;
import net.hockeyapp.android.listeners.DownloadFileListener;
import net.hockeyapp.android.objects.ErrorObject;
import net.hockeyapp.android.tasks.DownloadFileTask;
import net.hockeyapp.android.utils.VersionHelper;
import net.hockeyapp.android.views.UpdateView;

// Referenced classes of package net.hockeyapp.android:
//            UpdateActivityInterface, UpdateInfoListener, UpdateManager, UpdateManagerListener

public class UpdateActivity extends Activity
    implements UpdateActivityInterface, UpdateInfoListener, android.view.View.OnClickListener, TraceFieldInterface
{

    private final int DIALOG_ERROR_ID = 0;
    private Context context;
    protected DownloadFileTask downloadTask;
    private ErrorObject error;
    protected VersionHelper versionHelper;

    public UpdateActivity()
    {
    }

    private boolean isUnknownSourcesChecked()
    {
        Object obj = new String[1];
        obj[0] = "value";
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            obj = getContentResolver().query(android.provider.Settings.Global.CONTENT_URI, ((String []) (obj)), "name = ? AND value = ?", new String[] {
                "install_non_market_apps", String.valueOf(1)
            }, null);
        } else
        {
            obj = getContentResolver().query(android.provider.Settings.Secure.CONTENT_URI, ((String []) (obj)), "name = ? AND value = ?", new String[] {
                "install_non_market_apps", String.valueOf(1)
            }, null);
        }
        return ((Cursor) (obj)).getCount() == 1;
    }

    private boolean isWriteExternalStorageSet(Context context1)
    {
        return context1.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    protected void configureView()
    {
        ((TextView)findViewById(4098)).setText(getAppName());
        ((TextView)findViewById(4099)).setText((new StringBuilder()).append("Version ").append(versionHelper.getVersionString()).append("\n").append(versionHelper.getFileInfoString()).toString());
        ((Button)findViewById(4100)).setOnClickListener(this);
        WebView webview = (WebView)findViewById(4101);
        webview.clearCache(true);
        webview.destroyDrawingCache();
        webview.loadDataWithBaseURL("https://sdk.hockeyapp.net/", getReleaseNotes(), "text/html", "utf-8", null);
    }

    protected void createDownloadTask(String s, DownloadFileListener downloadfilelistener)
    {
        downloadTask = new DownloadFileTask(this, s, downloadfilelistener);
    }

    public void enableUpdateButton()
    {
        findViewById(4100).setEnabled(true);
    }

    public String getAppName()
    {
        Object obj;
        try
        {
            obj = getPackageManager();
            obj = ((PackageManager) (obj)).getApplicationLabel(((PackageManager) (obj)).getApplicationInfo(getPackageName(), 0)).toString();
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return "";
        }
        return ((String) (obj));
    }

    public int getCurrentVersionCode()
    {
        int i;
        try
        {
            i = getPackageManager().getPackageInfo(getPackageName(), 128).versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return -1;
        }
        return i;
    }

    public volatile View getLayoutView()
    {
        return getLayoutView();
    }

    public ViewGroup getLayoutView()
    {
        return new UpdateView(this);
    }

    protected String getReleaseNotes()
    {
        return versionHelper.getReleaseNotes(false);
    }

    public void onClick(View view)
    {
        if (!isWriteExternalStorageSet(context))
        {
            error = new ErrorObject();
            error.setMessage("The permission to access the external storage permission is not set. Please contact the developer.");
            runOnUiThread(new Runnable() {

                final UpdateActivity this$0;

                public void run()
                {
                    showDialog(0);
                }

            
            {
                this$0 = UpdateActivity.this;
                super();
            }
            });
            return;
        }
        if (!isUnknownSourcesChecked())
        {
            error = new ErrorObject();
            error.setMessage("The installation from unknown sources is not enabled. Please check the device settings.");
            runOnUiThread(new Runnable() {

                final UpdateActivity this$0;

                public void run()
                {
                    showDialog(0);
                }

            
            {
                this$0 = UpdateActivity.this;
                super();
            }
            });
            return;
        } else
        {
            startDownloadTask();
            view.setEnabled(false);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("UpdateActivity");
        TraceMachine.enterMethod(_nr_trace, "UpdateActivity#onCreate", null);
_L1:
        super.onCreate(bundle);
        setTitle("App Update");
        setContentView(getLayoutView());
        context = this;
        versionHelper = new VersionHelper(getIntent().getStringExtra("json"), this);
        configureView();
        downloadTask = (DownloadFileTask)getLastNonConfigurationInstance();
        if (downloadTask != null)
        {
            downloadTask.attach(this);
        }
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "UpdateActivity#onCreate", null);
          goto _L1
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return (new android.app.AlertDialog.Builder(this)).setMessage("An error has occured").setCancelable(false).setTitle("Error").setIcon(0x1080027).setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                final UpdateActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    error = null;
                    dialoginterface.cancel();
                }

            
            {
                this$0 = UpdateActivity.this;
                super();
            }
            }).create();
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            dialog = (AlertDialog)dialog;
            break;
        }
        if (error != null)
        {
            dialog.setMessage(error.getMessage());
            return;
        } else
        {
            dialog.setMessage("An unknown error has occured.");
            return;
        }
    }

    public Object onRetainNonConfigurationInstance()
    {
        if (downloadTask != null)
        {
            downloadTask.detach();
        }
        return downloadTask;
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    protected void startDownloadTask()
    {
        startDownloadTask(getIntent().getStringExtra("url"));
    }

    protected void startDownloadTask(String s)
    {
        createDownloadTask(s, new DownloadFileListener() {

            final UpdateActivity this$0;

            public void downloadFailed(DownloadFileTask downloadfiletask, Boolean boolean1)
            {
                if (boolean1.booleanValue())
                {
                    startDownloadTask();
                    return;
                } else
                {
                    enableUpdateButton();
                    return;
                }
            }

            public void downloadSuccessful(DownloadFileTask downloadfiletask)
            {
                enableUpdateButton();
            }

            public String getStringForResource(int i)
            {
                UpdateManagerListener updatemanagerlistener = UpdateManager.getLastListener();
                if (updatemanagerlistener != null)
                {
                    return updatemanagerlistener.getStringForResource(i);
                } else
                {
                    return null;
                }
            }

            
            {
                this$0 = UpdateActivity.this;
                super();
            }
        });
        s = downloadTask;
        String as[] = new String[0];
        if (!(s instanceof AsyncTask))
        {
            s.execute(as);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)s, as);
            return;
        }
    }


/*
    static ErrorObject access$002(UpdateActivity updateactivity, ErrorObject errorobject)
    {
        updateactivity.error = errorobject;
        return errorobject;
    }

*/
}
