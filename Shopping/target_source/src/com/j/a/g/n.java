// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.j.a.g:
//            w, l

class n extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    private JSONObject a;
    private JSONArray b;
    private Object c;
    private String d;
    private File e;
    private final l f;
    private Exception g;

    public n(Object obj, String s, File file, l l1)
    {
        g = null;
        if (!(obj instanceof JSONObject)) goto _L2; else goto _L1
_L1:
        a = (JSONObject)obj;
_L4:
        d = s;
        e = file;
        f = l1;
        return;
_L2:
        if (obj instanceof JSONArray)
        {
            b = (JSONArray)obj;
        } else
        if (obj instanceof Serializable)
        {
            c = obj;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a()
        throws Exception
    {
        ObjectOutputStream objectoutputstream;
        if (a == null && b == null && c == null || d == null || f == null)
        {
            w.c("Missing json, fileName, or listener to write JSON to disk");
            return;
        }
        objectoutputstream = new ObjectOutputStream(new FileOutputStream(new File(e, d)));
        Date date = new Date();
        if (c == null) goto _L2; else goto _L1
_L1:
        Object obj = c;
_L3:
        objectoutputstream.writeObject(obj);
        objectoutputstream.close();
        w.a("Wrote JSON to Disk", date);
        return;
_L2:
label0:
        {
            if (a == null)
            {
                break MISSING_BLOCK_LABEL_163;
            }
            obj = a;
            if (obj instanceof JSONObject)
            {
                break label0;
            }
            obj = ((JSONObject) (obj)).toString();
        }
          goto _L3
        try
        {
            obj = JSONObjectInstrumentation.toString((JSONObject)obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            w.b("RW err", ((Exception) (obj)));
            objectoutputstream.close();
            return;
        }
          goto _L3
label1:
        {
            obj = b;
            if (obj instanceof JSONArray)
            {
                break label1;
            }
            obj = ((JSONArray) (obj)).toString();
        }
          goto _L3
        obj = JSONArrayInstrumentation.toString((JSONArray)obj);
          goto _L3
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

    protected transient Void a(Void avoid[])
    {
        try
        {
            a();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            g = avoid;
        }
        return null;
    }

    protected void a(Void void1)
    {
        f.a(g);
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "n#doInBackground", null);
_L1:
        aobj = a((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "n#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "n#onPostExecute", null);
_L1:
        a((Void)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "n#onPostExecute", null);
          goto _L1
    }
}
