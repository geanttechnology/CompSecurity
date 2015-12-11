// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kochava.android.tracker;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kochava.android.util.Logging;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.kochava.android.tracker:
//            Feature

class this._cls1 extends TimerTask
{

    final is._cls0 this$1;

    public void run()
    {
        Logging.Log("Reached 10 min mark w/o sending initial, sending now.");
        Feature.access$3100(_fld0, false);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/kochava/android/tracker/Feature$7

/* anonymous class */
    class Feature._cls7 extends Handler
    {

        final Feature this$0;

        public void handleMessage(Message message)
        {
            boolean flag = message.getData().getBoolean("sendonstart");
            Feature.access$3000(Feature.this);
            if (!flag)
            {
                Feature.access$3200(Feature.this).schedule(new Feature._cls7._cls1(), 0x927c0L);
                return;
            } else
            {
                Feature.access$3200(Feature.this).schedule(new Feature._cls7._cls2(), 2000L);
                Feature.access$3302(Feature.this, new Timer());
                Feature.access$3300(Feature.this).schedule(new Feature._cls7._cls3(), 4000L);
                return;
            }
        }

            
            {
                this$0 = Feature.this;
                super(looper);
            }

        // Unreferenced inner class com/kochava/android/tracker/Feature$7$2

/* anonymous class */
        class Feature._cls7._cls2 extends TimerTask
        {

            final Feature._cls7 this$1;

            public void run()
            {
                Logging.Log("Scheduling timer to que initial event if needed.");
                Feature.access$3100(this$0, false);
            }

                    
                    {
                        this$1 = Feature._cls7.this;
                        super();
                    }
        }


        // Unreferenced inner class com/kochava/android/tracker/Feature$7$3

/* anonymous class */
        class Feature._cls7._cls3 extends TimerTask
        {

            final Feature._cls7 this$1;

            public void run()
            {
                Feature.flush();
            }

                    
                    {
                        this$1 = Feature._cls7.this;
                        super();
                    }
        }

    }

}
