// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;

// Referenced classes of package com.google.android.gms.tagmanager:
//            bh, TagManager

public class PreviewActivity extends Activity
    implements TraceFieldInterface
{

    public PreviewActivity()
    {
    }

    private void a(String s, String s1, String s2)
    {
        AlertDialog alertdialog = (new android.app.AlertDialog.Builder(this)).create();
        alertdialog.setTitle(s);
        alertdialog.setMessage(s1);
        alertdialog.setButton(-1, s2, new android.content.DialogInterface.OnClickListener() {

            final PreviewActivity VR;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                VR = PreviewActivity.this;
                super();
            }
        });
        alertdialog.show();
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("PreviewActivity");
        TraceMachine.enterMethod(_nr_trace, "PreviewActivity#onCreate", null);
_L2:
        super.onCreate(bundle);
        bh.u("Preview activity");
        bundle = getIntent().getData();
        if (!TagManager.getInstance(this).f(bundle))
        {
            bundle = (new StringBuilder()).append("Cannot preview the app with the uri: ").append(bundle).append(". Launching current version instead.").toString();
            bh.w(bundle);
            a("Preview failure", bundle, "Continue");
        }
        bundle = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        NoSuchFieldError nosuchfielderror;
        try
        {
            bh.u((new StringBuilder()).append("Invoke the launch activity for package name: ").append(getPackageName()).toString());
            startActivity(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bh.t((new StringBuilder()).append("Calling preview threw an exception: ").append(bundle.getMessage()).toString());
        }
        TraceMachine.exitMethod();
        return;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "PreviewActivity#onCreate", null);
        if (true) goto _L2; else goto _L1
_L1:
        bh.u((new StringBuilder()).append("No launch activity found for package name: ").append(getPackageName()).toString());
        break MISSING_BLOCK_LABEL_128;
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
}
