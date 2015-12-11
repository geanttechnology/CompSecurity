// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.BitshopPack;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.bitstrips.imoji.services:
//            BitshopGooglePlayService

class this._cls0
    implements ServiceConnection
{

    final BitshopGooglePlayService this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        Log.d("BitshopGooglePlayServ", "Billing Service Connected");
        BitshopGooglePlayService.access$002(BitshopGooglePlayService.this, com.android.vending.billing.sInterface(ibinder));
        packsMap = new HashMap();
        for (componentname = templatesManager.getPacks().iterator(); componentname.hasNext(); packsMap.put(ibinder.getApplicationPackStoreId(), ibinder))
        {
            ibinder = (BitshopPack)componentname.next();
        }

        BitshopGooglePlayService.access$100(BitshopGooglePlayService.this);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        BitshopGooglePlayService.access$002(BitshopGooglePlayService.this, null);
    }

    ()
    {
        this$0 = BitshopGooglePlayService.this;
        super();
    }
}
