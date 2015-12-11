// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.posting;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.aqo;
import android.support.v7.da;
import android.support.v7.ig;
import android.support.v7.iv;
import android.widget.Toast;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.posting:
//            ProductNewActivity

public class c extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final ProductNewActivity a;
    private final File b;
    private final File c;

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

    protected transient _nr_trace a(Void avoid[])
    {
        Object obj;
        boolean flag;
        obj = null;
        flag = true;
        if (b == null)
        {
            aqo.d("Error bigImageFile is null", new Object[0]);
            return null;
        }
        Bitmap bitmap;
        Bitmap bitmap1;
        FileOutputStream fileoutputstream;
        bitmap = BitmapFactoryInstrumentation.decodeStream(new FileInputStream(b));
        avoid = ig.b(bitmap, 512);
        bitmap1 = ig.a(avoid, b.getAbsolutePath());
        fileoutputstream = new FileOutputStream(c);
        if (bitmap1 == null) goto _L2; else goto _L1
_L1:
        if (!bitmap1.compress(android.graphics..PNG, 100, fileoutputstream)) goto _L2; else goto _L3
_L3:
        aqo.a("bitmap size : %d, %d", new Object[] {
            Integer.valueOf(bitmap1.getWidth()), Integer.valueOf(bitmap1.getHeight())
        });
_L9:
        fileoutputstream.close();
        if (avoid == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        avoid.recycle();
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        bitmap1.recycle();
        boolean flag1;
        avoid = obj;
        flag1 = flag;
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        bitmap.recycle();
        flag1 = flag;
        avoid = obj;
_L4:
        return new <init>(a, flag1, avoid);
        avoid;
        flag = false;
_L7:
        aqo.b(avoid, "File not found ", new Object[0]);
        flag1 = flag;
          goto _L4
        avoid;
        flag = false;
_L6:
        aqo.b(avoid, "Error accessing file", new Object[0]);
        flag1 = flag;
          goto _L4
        avoid;
        flag = false;
_L5:
        aqo.b(avoid, "Other error", new Object[0]);
        flag1 = flag;
          goto _L4
        avoid;
        flag1 = false;
          goto _L4
        avoid;
        flag1 = flag;
          goto _L4
        avoid;
          goto _L5
        avoid;
          goto _L6
        avoid;
          goto _L7
_L2:
        flag = false;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void a(a a1)
    {
        iv.a(ProductNewActivity.h(a));
        if (a1.a)
        {
            ProductNewActivity.a(a, Uri.fromFile(b), b.getAbsolutePath(), Uri.fromFile(c));
            return;
        }
        if ((a1.b instanceof da) || (a1.b instanceof OutOfMemoryError))
        {
            Toast.makeText(a.getApplicationContext(), 0x7f0900a1, 1).show();
            return;
        } else
        {
            ProductNewActivity.a(a, Uri.fromFile(b), b.getAbsolutePath(), Uri.fromFile(b));
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "ProductNewActivity$b#doInBackground", null);
_L1:
        aobj = a((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "ProductNewActivity$b#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "ProductNewActivity$b#onPostExecute", null);
_L1:
        a((a)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "ProductNewActivity$b#onPostExecute", null);
          goto _L1
    }

    protected void onPreExecute()
    {
        ProductNewActivity.a(a, a, a.getString(0x7f09010b), a.getString(0x7f09010a), 0, 0);
    }

    public on(ProductNewActivity productnewactivity, File file)
    {
        a = productnewactivity;
        super();
        b = file;
        c = iv.a(productnewactivity, "AmbatanaImageThumb_", "jpg");
    }
}
