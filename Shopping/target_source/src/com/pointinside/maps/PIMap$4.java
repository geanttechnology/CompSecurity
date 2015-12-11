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

class val.zones
    implements Runnable
{

    final PIMap this$0;
    final List val$zones;

    public void run()
    {
        Iterator iterator = val$zones.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            final Zone zone = (Zone)iterator.next();
            if ((IntByReference)mZoneUUIDToZoneRefMap.get(zone.getUUID()) == null)
            {
                PIMap.access$602(PIMap.this, new CountDownLatch(1));
                PIMap.access$1300(PIMap.this).post(new Runnable() {

                    final PIMap._cls4 this$1;
                    final Zone val$zone;

                    public void run()
                    {
                        PIMap.access$2800(this$0, zone, PIMap.EventHandlerActions.LOAD_SVG_LOAD_ZONE);
                    }

            
            {
                this$1 = PIMap._cls4.this;
                zone = zone1;
                super();
            }
                });
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

    _cls1.val.zone()
    {
        this$0 = final_pimap;
        val$zones = List.this;
        super();
    }
}
