// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package net.singular.sdk:
//            NewInjector, PostableWorker, KeyNotFoundException, KeyValueStore

class CountersLogger
{

    public static final String COUNTERS_KEY = "COUNTERS_KEY";
    private JSONObject counters;
    private final KeyValueStore countersKeyValueStore;
    private boolean loaded;
    private PostableWorker saverPostable;

    public CountersLogger(PostableWorker postableworker, NewInjector newinjector)
    {
        countersKeyValueStore = newinjector.generateKeyValueStore("counters");
        saverPostable = postableworker;
        counters = new JSONObject();
        loaded = false;
    }

    private void saveCounters()
    {
        if (loaded)
        {
            saverPostable.postNow(new Runnable() {

                final CountersLogger this$0;

                public void run()
                {
                    Object obj;
                    KeyValueStore keyvaluestore;
                    keyvaluestore = countersKeyValueStore;
                    obj = counters;
                    if (obj instanceof JSONObject)
                    {
                        break MISSING_BLOCK_LABEL_37;
                    }
                    obj = ((JSONObject) (obj)).toString();
_L1:
                    keyvaluestore.put("COUNTERS_KEY", ((String) (obj)));
                    return;
                    try
                    {
                        obj = JSONObjectInstrumentation.toString((JSONObject)obj);
                    }
                    catch (RuntimeException runtimeexception)
                    {
                        return;
                    }
                      goto _L1
                }

            
            {
                this$0 = CountersLogger.this;
                super();
            }
            });
        }
    }

    public JSONObject getAllCounters()
    {
        return counters;
    }

    public long getCounter(String s)
    {
        long l;
        try
        {
            l = counters.getLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0L;
        }
        return l;
    }

    public long increaseCounter(String s)
    {
        return increaseCounter(s, 1L);
    }

    public long increaseCounter(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        setCounter(s, getCounter(s) + l);
        l = getCounter(s);
        this;
        JVM INSTR monitorexit ;
        return l;
        s;
        throw s;
    }

    public void loadSavedCounters()
    {
        loaded = true;
        String s = countersKeyValueStore.getString("COUNTERS_KEY");
        try
        {
            counters = JSONObjectInstrumentation.init(s);
            return;
        }
        catch (JSONException jsonexception) { }
        try
        {
            countersKeyValueStore.delete("COUNTERS_KEY");
            counters = new JSONObject();
            return;
        }
        catch (KeyNotFoundException keynotfoundexception)
        {
            counters = new JSONObject();
        }
        return;
    }

    public void setCounter(String s, long l)
    {
        try
        {
            counters.put(s, l);
            saveCounters();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }


}
