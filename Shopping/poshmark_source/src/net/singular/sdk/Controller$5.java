// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package net.singular.sdk:
//            Controller, Collector, EventStore, SingularLog

class val.delayMillis
    implements Runnable
{

    final Controller this$0;
    final long val$delayMillis;
    final JSONObject val$event_copy;

    public void run()
    {
        try
        {
            JSONObject jsonobject = Controller.access$500(Controller.this).getTemporalIds();
            Iterator iterator = jsonobject.keys();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (!s.equals("event_timestamp_s") && !s.equals("sdk_event_id"))
                {
                    val$event_copy.put(s, jsonobject.get(s));
                }
            } while (true);
        }
        catch (JSONException jsonexception)
        {
            Controller.access$300(Controller.this, jsonexception, "postEventDelayed runnable");
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            Controller.access$300(Controller.this, runtimeexception, "postEventDelayed runnable");
            return;
        }
        if (Controller.access$600(Controller.this).addEvent(val$event_copy))
        {
            Controller.access$700(Controller.this).d("net.singular.sdk.Controller", String.format("postEventDelayed: event saved to db, posting with delay = %d to sender", new Object[] {
                Long.valueOf(val$delayMillis)
            }));
            activateSender(val$delayMillis);
            return;
        }
        Controller.access$700(Controller.this).e("net.singular.sdk.Controller", "postEventDelayed: eventStore.addEvent failed :(");
        return;
    }

    ()
    {
        this$0 = final_controller;
        val$event_copy = jsonobject;
        val$delayMillis = J.this;
        super();
    }
}
