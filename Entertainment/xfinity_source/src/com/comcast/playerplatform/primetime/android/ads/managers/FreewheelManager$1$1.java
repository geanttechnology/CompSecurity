// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads.managers;

import com.google.common.util.concurrent.SettableFuture;
import java.util.HashMap;
import java.util.Vector;
import org.slf4j.Logger;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads.managers:
//            FreewheelManager

class this._cls1
    implements IEventListener
{

    final is._cls0 this$1;

    public void run(IEvent ievent)
    {
        Vector vector = new Vector();
        String s = ievent.getType();
        ievent = ievent.getData().get(FreewheelManager.access$000(_fld0).INFO_KEY_SUCCESS()).toString();
        if (FreewheelManager.access$000(_fld0).EVENT_REQUEST_COMPLETE().equals(s) && Boolean.valueOf(ievent).booleanValue())
        {
            ievent = FreewheelManager.access$100(_fld0);
            FreewheelManager.access$200().debug("Freewheel ad request completed successfully");
        } else
        {
            FreewheelManager.access$200().debug("Freewheel ad request failed. Playing main content.");
            ievent = vector;
        }
        FreewheelManager.access$300(_fld0).set(ievent);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1

/* anonymous class */
    class FreewheelManager._cls1
        implements Runnable
    {

        final FreewheelManager this$0;

        public void run()
        {
            FreewheelManager.access$400(FreewheelManager.this).addEventListener(FreewheelManager.access$000(FreewheelManager.this).EVENT_REQUEST_COMPLETE(), new FreewheelManager._cls1._cls1());
            FreewheelManager.access$400(FreewheelManager.this).submitRequest(3D);
        }

            
            {
                this$0 = FreewheelManager.this;
                super();
            }
    }

}
