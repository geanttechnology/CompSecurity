// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces.toolkit;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.penthera.virtuososdk.client.IServiceConnectedCallback;
import com.penthera.virtuososdk.service.VirtuosoService;

// Referenced classes of package com.penthera.virtuososdk.interfaces.toolkit:
//            VirtuosoContentBox

class this._cls0
    implements ServiceConnection
{

    final VirtuosoContentBox this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        com.penthera.virtuososdk.utility.ntentBox(VirtuosoContentBox.access$8(), (new StringBuilder("Service Connected: ")).append(componentname.getClassName()).toString());
        if (com/penthera/virtuososdk/service/VirtuosoService.getName().equals(componentname.getClassName()))
        {
            VirtuosoContentBox.access$9(VirtuosoContentBox.this, com.penthera.virtuososdk.interfaces..asInterface(ibinder));
            VirtuosoContentBox.access$10(VirtuosoContentBox.this);
            if (VirtuosoContentBox.access$11(VirtuosoContentBox.this) != null)
            {
                VirtuosoContentBox.access$11(VirtuosoContentBox.this).connected();
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        com.penthera.virtuososdk.utility.ntentBox(VirtuosoContentBox.access$8(), (new StringBuilder("Service Disconnected: ")).append(componentname.getClassName()).toString());
        VirtuosoContentBox.access$9(VirtuosoContentBox.this, null);
        VirtuosoContentBox.access$12(VirtuosoContentBox.this, false);
        VirtuosoContentBox.access$13(VirtuosoContentBox.this, (short)0);
    }

    ()
    {
        this$0 = VirtuosoContentBox.this;
        super();
    }
}
