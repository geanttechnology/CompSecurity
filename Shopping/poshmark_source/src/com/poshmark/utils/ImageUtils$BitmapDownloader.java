// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.net.Uri;
import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.ui.fragments.CameraPreviewFragment;

// Referenced classes of package com.poshmark.utils:
//            ImageUtils

public static class callingFragment extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    public CameraPreviewFragment callingFragment;

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

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "ImageUtils$BitmapDownloader#doInBackground", null);
_L1:
        aobj = doInBackground((Uri[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "ImageUtils$BitmapDownloader#doInBackground", null);
          goto _L1
    }

    protected transient String doInBackground(Uri auri[])
    {
        return ImageUtils.downloadBitmap(ImageUtils.generateFileName(), auri[0]);
    }

    protected volatile void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "ImageUtils$BitmapDownloader#onPostExecute", null);
_L1:
        onPostExecute((String)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "ImageUtils$BitmapDownloader#onPostExecute", null);
          goto _L1
    }

    protected void onPostExecute(String s)
    {
        callingFragment.cropImage(s);
    }

    protected void onPreExecute()
    {
    }

    public (CameraPreviewFragment camerapreviewfragment)
    {
        callingFragment = camerapreviewfragment;
    }
}
