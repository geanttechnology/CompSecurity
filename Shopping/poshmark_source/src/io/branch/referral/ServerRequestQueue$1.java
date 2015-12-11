// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

// Referenced classes of package io.branch.referral:
//            ServerRequestQueue, ServerRequest, PrefHelper

class this._cls0
    implements Runnable
{

    final ServerRequestQueue this$0;

    public void run()
    {
        JSONArray jsonarray = new JSONArray();
        List list = ServerRequestQueue.access$000(ServerRequestQueue.this);
        list;
        JVM INSTR monitorenter ;
        Object obj = ServerRequestQueue.access$000(ServerRequestQueue.this).iterator();
_L2:
        Object obj2;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_74;
            }
            obj2 = ((ServerRequest)((Iterator) (obj)).next()).toJSON();
        } while (obj2 == null);
        jsonarray.put(obj2);
        if (true) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1;
        list;
        JVM INSTR monitorexit ;
        throw obj1;
        obj2 = ServerRequestQueue.access$100(ServerRequestQueue.this);
        if (jsonarray instanceof JSONArray) goto _L4; else goto _L3
_L3:
        obj1 = jsonarray.toString();
_L7:
        ((android.content.tor) (obj2)).putString("BNCServerRequestQueue", ((String) (obj1))).commit();
        obj2 = ServerRequestQueue.access$100(ServerRequestQueue.this);
        if (jsonarray instanceof JSONArray) goto _L6; else goto _L5
_L5:
        obj1 = jsonarray.toString();
_L8:
        ((android.content.tor) (obj2)).putString("BNCServerRequestQueue", ((String) (obj1))).commit();
_L11:
        list;
        JVM INSTR monitorexit ;
        return;
_L4:
        obj1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
          goto _L7
_L6:
        obj1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
          goto _L8
        obj1;
        if (jsonarray instanceof JSONArray) goto _L10; else goto _L9
_L9:
        obj1 = jsonarray.toString();
_L12:
        PrefHelper.Debug("Persisting Queue: ", ((String) (obj1)));
        obj2 = ServerRequestQueue.access$100(ServerRequestQueue.this);
        if (jsonarray instanceof JSONArray)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        obj1 = jsonarray.toString();
_L13:
        ((android.content.tor) (obj2)).putString("BNCServerRequestQueue", ((String) (obj1))).commit();
          goto _L11
        obj1;
          goto _L11
_L10:
        obj1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
          goto _L12
        obj1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
          goto _L13
        Exception exception;
        exception;
        android.content.tor tor = ServerRequestQueue.access$100(ServerRequestQueue.this);
        if (jsonarray instanceof JSONArray) goto _L15; else goto _L14
_L14:
        obj1 = jsonarray.toString();
_L16:
        tor.putString("BNCServerRequestQueue", ((String) (obj1))).commit();
_L17:
        throw exception;
_L15:
        obj1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
          goto _L16
        obj1;
          goto _L17
        obj1;
          goto _L11
    }

    n()
    {
        this$0 = ServerRequestQueue.this;
        super();
    }
}
