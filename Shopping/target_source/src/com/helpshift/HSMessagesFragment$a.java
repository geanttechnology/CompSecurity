// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.AsyncTask;
import android.util.Log;
import com.helpshift.k.a;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment

private class <init> extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final HSMessagesFragment a;

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

    protected transient HashMap a(HashMap ahashmap[])
    {
        ahashmap = ahashmap[0];
        String s = (String)ahashmap.get("url");
        String s1 = (String)ahashmap.get("messageId");
        int i = ((Integer)ahashmap.get("attachId")).intValue();
        int j = ((Integer)ahashmap.get("position")).intValue();
        ahashmap = new HashMap();
        try
        {
            s = a.a(s, s1, i);
            ahashmap.put("success", Boolean.valueOf(true));
            ahashmap.put("filepath", s);
            ahashmap.put("position", Integer.valueOf(j));
        }
        catch (IOException ioexception)
        {
            Log.d("HelpShiftDebug", "Downloading image", ioexception);
            ahashmap.put("success", Boolean.valueOf(false));
            return ahashmap;
        }
        return ahashmap;
    }

    protected void a(HashMap hashmap)
    {
        if (((Boolean)hashmap.get("success")).booleanValue())
        {
            int i = ((Integer)hashmap.get("position")).intValue();
            ((a)HSMessagesFragment.s(a).get(i)).h = (String)hashmap.get("filepath");
            HSMessagesFragment.d(a).notifyDataSetChanged();
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "HSMessagesFragment$a#doInBackground", null);
_L1:
        aobj = a((HashMap[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "HSMessagesFragment$a#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "HSMessagesFragment$a#onPostExecute", null);
_L1:
        a((HashMap)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "HSMessagesFragment$a#onPostExecute", null);
          goto _L1
    }

    private Trace(HSMessagesFragment hsmessagesfragment)
    {
        a = hsmessagesfragment;
        super();
    }

    a(HSMessagesFragment hsmessagesfragment, a a1)
    {
        this(hsmessagesfragment);
    }
}
