// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.os.Handler;
import com.pointinside.model.Zone;
import com.sun.jna.ptr.IntByReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.pointinside.maps:
//            PIMap

class val.zone
    implements Runnable
{

    final ONE this$1;
    final Zone val$zone;

    public void run()
    {
        PIMap.access$2800(_fld0, val$zone, tHandlerActions.LOAD_SVG_LOAD_ZONE);
    }

    l.zones()
    {
        this$1 = final_zones;
        val$zone = Zone.this;
        super();
    }

    // Unreferenced inner class com/pointinside/maps/PIMap$4

/* anonymous class */
    class PIMap._cls4
        implements Runnable
    {

        final PIMap this$0;
        final List val$zones;

        public void run()
        {
            Iterator iterator = zones.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Zone zone1 = (Zone)iterator.next();
                if ((IntByReference)mZoneUUIDToZoneRefMap.get(zone1.getUUID()) == null)
                {
                    PIMap.access$602(PIMap.this, new CountDownLatch(1));
                    PIMap.access$1300(PIMap.this).post(zone1. new PIMap._cls4._cls1());
                    try
                    {
                        PIMap.access$600(PIMap.this).await();
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                }
            } while (true);
        }

            
            {
                this$0 = final_pimap;
                zones = List.this;
                super();
            }
    }

}
