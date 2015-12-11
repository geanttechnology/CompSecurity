// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;

// Referenced classes of package com.google.tagmanager:
//            Log, TagManager

public class PreviewActivity extends Activity
    implements TraceFieldInterface
{

    public PreviewActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("PreviewActivity");
        TraceMachine.enterMethod(_nr_trace, "PreviewActivity#onCreate", null);
_L1:
        super.onCreate(bundle);
        Log.i("Preview activity");
        bundle = getIntent().getData();
        if (TagManager.getInstance(this).setPreviewData(bundle))
        {
            break MISSING_BLOCK_LABEL_81;
        }
        Log.w((new StringBuilder()).append("Cannot preview the app with the uri: ").append(bundle).toString());
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "PreviewActivity#onCreate", null);
          goto _L1
        bundle = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        try
        {
            Log.i((new StringBuilder()).append("Invoke the launch activity for package name: ").append(getPackageName()).toString());
            startActivity(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Log.e((new StringBuilder()).append("Calling preview threw an exception: ").append(bundle.getMessage()).toString());
        }
        TraceMachine.exitMethod();
        return;
        Log.i((new StringBuilder()).append("No launch activity found for package name: ").append(getPackageName()).toString());
        break MISSING_BLOCK_LABEL_127;
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
