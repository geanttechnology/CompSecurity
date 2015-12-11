// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.widget.Toast;
import com.google.userfeedback.android.api.common.io.GoogleHttpClient;
import java.io.File;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackSpec, UserFeedback, UserFeedbackReport

public class SendUserFeedbackService extends Service
{

    private static final String APP_AND_VERSION = "AndroidGoogleUIF/1.0";
    private static final String CONTENT_ENCODING = "gzip";
    private static final String CONTENT_TYPE = "application/x-protobuf";
    private static final int MAX_RETRIES = 3;
    private static final int TIMEOUT = 20000;
    private static boolean mSilenceToast;
    private final IBinder mServiceBinder = new SendUserFeedbackServiceBinder();
    public UserFeedbackSpec mSpec;
    private int mToastMessage;
    public String mUrl;

    public SendUserFeedbackService()
    {
        mToastMessage = R.string.gf_report_sent_failure;
    }

    protected String getReceiverUrl()
    {
        String s = getString(R.string.gf_receiver_transport_scheme);
        String s1 = s;
        if ("".equals(s))
        {
            s1 = "http";
        }
        s = getString(R.string.gf_receiver_port);
        String s2;
        String s3;
        if ("".equals(s))
        {
            s = "";
        } else
        {
            s = String.valueOf(s);
            if (s.length() != 0)
            {
                s = ":".concat(s);
            } else
            {
                s = new String(":");
            }
        }
        s2 = String.valueOf(getString(R.string.gf_receiver_host));
        s3 = String.valueOf(getString(R.string.gf_receiver_path));
        return (new StringBuilder(String.valueOf(s1).length() + 3 + String.valueOf(s2).length() + String.valueOf(s).length() + String.valueOf(s3).length())).append(s1).append("://").append(s2).append(s).append(s3).toString();
    }

    public IBinder onBind(Intent intent)
    {
        return mServiceBinder;
    }

    public void onCreate()
    {
        super.onCreate();
    }

    public void onStart(Intent intent, int i)
    {
        submitFeedback();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        submitFeedback();
        return 2;
    }

    protected int sendReport(File file)
    {
        Object obj = new HttpPost(mUrl);
        ((HttpPost) (obj)).setHeader("Content-encoding", "gzip");
        ((HttpPost) (obj)).setEntity(new FileEntity(file, "application/x-protobuf"));
        file = new GoogleHttpClient(mSpec.getContext().getContentResolver(), "AndroidGoogleUIF/1.0", false);
        org.apache.http.params.HttpParams httpparams = file.getParams();
        HttpConnectionParams.setConnectionTimeout(httpparams, 20000);
        HttpConnectionParams.setSoTimeout(httpparams, 20000);
        int i;
        try
        {
            obj = file.execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
            file.close();
            i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        }
        catch (IOException ioexception)
        {
            file.close();
            throw ioexception;
        }
        if (i < 300)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        (new StringBuilder(33)).append("Http response status: ").append(i);
        return i;
    }

    protected void showToast(int i)
    {
        if (!mSilenceToast && !UserFeedback.isServiceToastShown())
        {
            Toast.makeText(mSpec.getContext(), i, 0).show();
            UserFeedback.serviceToastShown();
        }
        mSilenceToast = true;
    }

    protected void startSendingUserFeedback()
    {
        (new Thread(new _cls1())).start();
    }

    protected void submitFeedback()
    {
        mSilenceToast = false;
        if (UserFeedback.userFeedback() == null || UserFeedback.userFeedback().getReport() == null)
        {
            stopSelf();
            return;
        }
        if (!UserFeedback.userFeedback().getReport().shouldSubmitReport())
        {
            break MISSING_BLOCK_LABEL_116;
        }
        mUrl = getReceiverUrl();
        mSpec = UserFeedback.userFeedback().getSpec();
        NetworkInfo networkinfo;
        try
        {
            networkinfo = ((ConnectivityManager)mSpec.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        }
        catch (SecurityException securityexception)
        {
            startSendingUserFeedback();
            return;
        }
        if (networkinfo == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        if (networkinfo.isConnected())
        {
            startSendingUserFeedback();
            return;
        }
        mToastMessage = R.string.gf_report_queued;
        showToast(mToastMessage);
        stopSelf();
        return;
        stopSelf();
        return;
    }



/*
    static int access$002(SendUserFeedbackService senduserfeedbackservice, int i)
    {
        senduserfeedbackservice.mToastMessage = i;
        return i;
    }

*/

    private class SendUserFeedbackServiceBinder extends Binder
    {

        final SendUserFeedbackService this$0;

        public SendUserFeedbackServiceBinder()
        {
            this$0 = SendUserFeedbackService.this;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final SendUserFeedbackService this$0;
        final UserFeedbackReport val$report;
        final Service val$thisService;

        private void cleanup(File file)
        {
            if (file != null)
            {
                showToast(mToastMessage);
                file.delete();
                thisService.stopSelf();
            }
        }

        public void run()
        {
            File file;
            File file1;
            Object obj;
            Object obj1;
            UserFeedbackReportBuilder userfeedbackreportbuilder;
            Looper.prepare();
            userfeedbackreportbuilder = new UserFeedbackReportBuilder(mSpec);
            obj1 = null;
            obj = null;
            file1 = ((File) (obj));
            file = obj1;
            report.setSubmitted(true);
            file1 = ((File) (obj));
            file = obj1;
            obj = userfeedbackreportbuilder.getFormattedFeedbackReport(report);
            int i = 0;
_L10:
            if (i >= 3) goto _L2; else goto _L1
_L1:
            file1 = ((File) (obj));
            file = ((File) (obj));
            int j = sendReport(((File) (obj))) / 100;
            if (j != 2) goto _L4; else goto _L3
_L3:
            file1 = ((File) (obj));
            file = ((File) (obj));
            mToastMessage = R.string.gf_report_being_sent;
_L2:
            file1 = ((File) (obj));
            file = ((File) (obj));
            cleanup(((File) (obj)));
            cleanup(((File) (obj)));
_L7:
            Looper.loop();
            return;
_L4:
            if (j == 5)
            {
                i++;
                continue; /* Loop/switch isn't completed */
            }
              goto _L2
            IOException ioexception;
            ioexception;
            file = file1;
            ioexception = String.valueOf(ioexception.getMessage());
            file = file1;
            if (ioexception.length() == 0) goto _L6; else goto _L5
_L5:
            file = file1;
            ioexception = "IOException: ".concat(ioexception);
_L8:
            file = file1;
            Log.e("GFEEDBACK", ioexception);
            cleanup(file1);
              goto _L7
_L6:
            file = file1;
            ioexception = new String("IOException: ");
              goto _L8
            Exception exception;
            exception;
            cleanup(file);
            throw exception;
            if (true) goto _L10; else goto _L9
_L9:
        }

        _cls1()
        {
            this$0 = SendUserFeedbackService.this;
            report = userfeedbackreport;
            thisService = service;
            super();
        }
    }

}
