// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.tasks;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import net.hockeyapp.android.Strings;
import net.hockeyapp.android.listeners.DownloadFileListener;

public class DownloadFileTask extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    private Context context;
    private String filePath;
    private String filename;
    private DownloadFileListener notifier;
    private ProgressDialog progressDialog;
    private String urlString;

    public DownloadFileTask(Context context1, String s, DownloadFileListener downloadfilelistener)
    {
        context = context1;
        urlString = s;
        filename = (new StringBuilder()).append(UUID.randomUUID()).append(".apk").toString();
        filePath = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Download").toString();
        notifier = downloadfilelistener;
    }

    private String getURLString()
    {
        return (new StringBuilder()).append(urlString).append("&type=apk").toString();
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

    public void attach(Context context1)
    {
        context = context1;
    }

    protected URLConnection createConnection(URL url)
        throws IOException
    {
        url = HttpInstrumentation.openConnection(url.openConnection());
        url.setRequestProperty("connection", "close");
        return url;
    }

    public void detach()
    {
        context = null;
        progressDialog = null;
    }

    protected transient Boolean doInBackground(String as[])
    {
        Object obj;
        int i;
        try
        {
            as = createConnection(new URL(getURLString()));
            as.connect();
            i = as.getContentLength();
            obj = new File(filePath);
            if (!((File) (obj)).mkdirs() && !((File) (obj)).exists())
            {
                throw new IOException((new StringBuilder()).append("Could not create the dir(s):").append(((File) (obj)).getAbsolutePath()).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
            return Boolean.valueOf(false);
        }
        byte abyte0[];
        obj = new File(((File) (obj)), filename);
        as = new BufferedInputStream(as.getInputStream());
        obj = new FileOutputStream(((File) (obj)));
        abyte0 = new byte[1024];
        long l = 0L;
_L1:
        int j = as.read(abyte0);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        l += j;
        publishProgress(new Integer[] {
            Integer.valueOf((int)((100L * l) / (long)i))
        });
        ((OutputStream) (obj)).write(abyte0, 0, j);
          goto _L1
        ((OutputStream) (obj)).flush();
        ((OutputStream) (obj)).close();
        as.close();
        boolean flag;
        if (l > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "DownloadFileTask#doInBackground", null);
_L1:
        aobj = doInBackground((String[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "DownloadFileTask#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(Boolean boolean1)
    {
        if (progressDialog != null)
        {
            try
            {
                progressDialog.dismiss();
            }
            catch (Exception exception) { }
        }
        if (boolean1.booleanValue())
        {
            notifier.downloadSuccessful(this);
            boolean1 = new Intent("android.intent.action.VIEW");
            boolean1.setDataAndType(Uri.fromFile(new File(filePath, filename)), "application/vnd.android.package-archive");
            boolean1.setFlags(0x10000000);
            context.startActivity(boolean1);
            return;
        }
        try
        {
            boolean1 = new android.app.AlertDialog.Builder(context);
            boolean1.setTitle(Strings.get(notifier, 4));
            boolean1.setMessage(Strings.get(notifier, 5));
            boolean1.setNegativeButton(Strings.get(notifier, 6), new android.content.DialogInterface.OnClickListener() {

                final DownloadFileTask this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    notifier.downloadFailed(DownloadFileTask.this, Boolean.valueOf(false));
                }

            
            {
                this$0 = DownloadFileTask.this;
                super();
            }
            });
            boolean1.setPositiveButton(Strings.get(notifier, 7), new android.content.DialogInterface.OnClickListener() {

                final DownloadFileTask this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    notifier.downloadFailed(DownloadFileTask.this, Boolean.valueOf(true));
                }

            
            {
                this$0 = DownloadFileTask.this;
                super();
            }
            });
            boolean1.create().show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Boolean boolean1)
        {
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "DownloadFileTask#onPostExecute", null);
_L1:
        onPostExecute((Boolean)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "DownloadFileTask#onPostExecute", null);
          goto _L1
    }

    protected transient void onProgressUpdate(Integer ainteger[])
    {
        try
        {
            if (progressDialog == null)
            {
                progressDialog = new ProgressDialog(context);
                progressDialog.setProgressStyle(1);
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();
            }
            progressDialog.setProgress(ainteger[0].intValue());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Integer ainteger[])
        {
            return;
        }
    }

    protected volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Integer[])aobj);
    }

}
