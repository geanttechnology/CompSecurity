// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.posting;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.aqo;
import android.support.v7.iv;
import android.text.TextUtils;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.posting:
//            ProductNewActivity

public class a extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    WeakReference a;
    final ProductNewActivity b;

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

    protected transient File a(String as[])
    {
        Object obj;
        if (as.length <= 0)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        obj = as[0];
        if (TextUtils.isEmpty(((CharSequence) (obj))) || a.get() == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        as = iv.a((Context)a.get(), "AmbatanaImage_", "jpg");
        FileOutputStream fileoutputstream;
        obj = BitmapFactoryInstrumentation.decodeStream(new FileInputStream(new File(((String) (obj)))));
        fileoutputstream = new FileOutputStream(as);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (((Bitmap) (obj)).compress(android.graphics..PNG, 100, fileoutputstream))
        {
            return as;
        }
        try
        {
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            aqo.b(as, "Error Saving image", new Object[0]);
        }
        return null;
        return null;
    }

    protected void a(File file)
    {
        iv.a(ProductNewActivity.h(b));
        if (file != null && a != null)
        {
            ProductNewActivity.a(b, Uri.fromFile(file), file.getAbsolutePath());
            return;
        } else
        {
            ProductNewActivity.i(b);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "ProductNewActivity$d#doInBackground", null);
_L1:
        aobj = a((String[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "ProductNewActivity$d#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "ProductNewActivity$d#onPostExecute", null);
_L1:
        a((File)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "ProductNewActivity$d#onPostExecute", null);
          goto _L1
    }

    protected void onPreExecute()
    {
        ProductNewActivity.a(b, b, b.getString(0x7f09010b), b.getString(0x7f09010a), 0, 0);
    }

    public on(ProductNewActivity productnewactivity, ProductNewActivity productnewactivity1)
    {
        b = productnewactivity;
        super();
        a = new WeakReference(productnewactivity1);
    }
}
