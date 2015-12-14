// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.firegnom.rat;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.socialin.android.apiv3.exception.CrashLog;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.d;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import com.socialin.android.dialog.c;
import com.socialin.android.util.s;
import myobfuscated.f.m;

public abstract class ExceptionActivity extends Activity
{

    public static final String TAG = "ExceptionActivity - ";
    private final String DIALOG_EXCEPTION_PREVIEW = "dialogPreview";
    private String address;
    private CrashLog crashLog;
    private c onCreateViewListener;
    private a previewDialog;
    private boolean sendWithConfirm;

    public ExceptionActivity()
    {
        address = "techsupport@picsart.com";
        sendWithConfirm = true;
        onCreateViewListener = new c() {

            final ExceptionActivity this$0;

            public void onViewCreated(View view, DialogFragment dialogfragment)
            {
                ((TextView)view.findViewById(0x7f1004cb)).setText(crashLog.appVersion);
                ((TextView)view.findViewById(0x7f1004cc)).setText(crashLog.osVersion);
                ((TextView)view.findViewById(0x7f1004cd)).setText(crashLog.appPackage);
                ((TextView)view.findViewById(0x7f1004ce)).setText(crashLog.phoneModel);
                ((TextView)view.findViewById(0x7f1004cf)).setText(crashLog.crashId);
                ((TextView)view.findViewById(0x7f1004d0)).setText(crashLog.stacktrace);
            }

            
            {
                this$0 = ExceptionActivity.this;
                super();
            }
        };
    }

    private void buildCrashLog(Intent intent)
    {
        intent = (Throwable)intent.getSerializableExtra("EXCEPTION");
        crashLog = CrashLog.create(getApplicationContext());
        crashLog.setException(intent, false);
    }

    private void initDialog()
    {
        previewDialog = (a)getFragmentManager().findFragmentByTag("dialogPreview");
        if (previewDialog != null && previewDialog.isAdded())
        {
            previewDialog.a(onCreateViewListener);
        }
    }

    private void send()
    {
        (new Thread() {

            final ExceptionActivity this$0;

            public void run()
            {
                ExceptionReportService.sendStackTrace(getUrl(), getSecurityToken(), crashLog.appVersion, crashLog.appPackage, crashLog.phoneModel, crashLog.osVersion, crashLog.stacktrace, false, getMoreDetails());
                String s1 = crashLog.getJsonString();
                d.b("ExceptionActivity - ", new Object[] {
                    s1
                });
                ExceptionReportService.sendStackTrace("https://analytics.picsart.com/crash", s1);
                try
                {
                    Thread.sleep(5000L);
                    return;
                }
                catch (InterruptedException interruptedexception)
                {
                    interruptedexception.printStackTrace();
                }
            }

            
            {
                this$0 = ExceptionActivity.this;
                super();
            }
        }).start();
    }

    public abstract String getMessage();

    public abstract String getMoreDetails();

    public abstract String getSecurityToken();

    public abstract String getUrl();

    public abstract boolean isSend();

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        m.b(this);
        Intent intent = getIntent();
        Object obj1 = m.d(this, "SOCIALIN_CONFIRM_EXCEPTION");
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = Boolean.valueOf(false);
        }
        obj = (Boolean)obj;
        if (obj != null)
        {
            sendWithConfirm = ((Boolean) (obj)).booleanValue();
        }
        d.b("ExceptionActivity - ", new Object[] {
            "confirm=", Boolean.valueOf(sendWithConfirm)
        });
        setContentView(0x7f0300ea);
        if (bundle == null)
        {
            buildCrashLog(intent);
        } else
        {
            crashLog = (CrashLog)bundle.getParcelable("crash_log");
        }
        findViewById(0x7f1004c9).setOnClickListener(new android.view.View.OnClickListener() {

            final ExceptionActivity this$0;

            public void onClick(View view)
            {
                sendEmail();
            }

            
            {
                this$0 = ExceptionActivity.this;
                super();
            }
        });
        findViewById(0x7f1004ca).setOnClickListener(new android.view.View.OnClickListener() {

            final ExceptionActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = ExceptionActivity.this;
                super();
            }
        });
        findViewById(0x7f1004c8).setOnClickListener(new android.view.View.OnClickListener() {

            final ExceptionActivity this$0;

            public void onClick(View view)
            {
                if (previewDialog == null)
                {
                    view = ExceptionActivity.this;
                    b b1 = (new b()).a(1, 0x7f0c0181).a(getResources().getString(0x7f0802b8));
                    b1.h = false;
                    b1.p = onCreateViewListener;
                    b1.f = 0x7f0300eb;
                    b1.g = true;
                    view.previewDialog = b1.a(new android.view.View.OnClickListener() {

                        final _cls4 this$1;

                        public void onClick(View view)
                        {
                            previewDialog.dismiss();
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    }).a();
                }
                if (!previewDialog.isAdded())
                {
                    previewDialog.show(getFragmentManager(), "dialogPreview");
                }
            }

            
            {
                this$0 = ExceptionActivity.this;
                super();
            }
        });
        initDialog();
        if (!sendWithConfirm && bundle == null)
        {
            send();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("crash_log", crashLog);
    }

    public void sendEmail()
    {
        if (!s.a(this))
        {
            break MISSING_BLOCK_LABEL_318;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        StringBuilder stringbuilder = (new StringBuilder(getResources().getString(0x7f08010f))).append(getResources().getString(0x7f08049a)).append(getResources().getString(0x7f080050)).append(crashLog.appVersion).append(getResources().getString(0x7f08049a)).append(getResources().getString(0x7f08004d)).append(crashLog.osVersion).append(getResources().getString(0x7f08049a)).append(getResources().getString(0x7f0804cd)).append(crashLog.appPackage).append(getResources().getString(0x7f08049a)).append(getResources().getString(0x7f080400)).append(crashLog.phoneModel).append(getResources().getString(0x7f08049a)).append(getResources().getString(0x7f08049a)).append(getResources().getString(0x7f080110)).append(getResources().getString(0x7f08049a)).append(crashLog.stacktrace);
        intent.setType("plain/text");
        intent.putExtra("android.intent.extra.EMAIL", new String[] {
            address
        });
        intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append(getResources().getString(0x7f080228)).append(" PICSART ").append(crashLog.appVersion).toString());
        intent.putExtra("android.intent.extra.TEXT", stringbuilder.toString());
        startActivity(intent);
        return;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        Toast.makeText(this, getString(0x7f08094b), 0).show();
        return;
    }




/*
    static a access$102(ExceptionActivity exceptionactivity, a a1)
    {
        exceptionactivity.previewDialog = a1;
        return a1;
    }

*/

}
