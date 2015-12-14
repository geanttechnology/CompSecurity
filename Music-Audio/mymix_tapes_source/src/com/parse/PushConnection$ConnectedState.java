// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.net.Socket;
import java.util.Set;

// Referenced classes of package com.parse:
//            PushConnection

public class socket extends socket
{

    private Socket socket;
    final PushConnection this$0;

    public socket runState()
    {
        Object obj = null;
        itor itor = new itor(PushConnection.this, null);
        r r = new r(PushConnection.this, socket, PushConnection.KEEP_ALIVE_INTERVAL);
        r r1 = new nit>(PushConnection.this, socket);
        itor.register();
        r.register();
        r1.art();
        do
        {
            if (obj != null)
            {
                break;
            }
            Set set = PushConnection.access$300(PushConnection.this)._mth0(new this._cls0[] {
                this._fld0, ITY_CHANGED, E_ERROR, R
            });
            if (set.contains(R))
            {
                obj = new nit>(PushConnection.this);
            } else
            if (set.contains(R) || set.contains(E_ERROR) || set.contains(ITY_CHANGED))
            {
                obj = new <init>(PushConnection.this, 0L);
            }
        } while (true);
        itor.unregister();
        r.unregister();
        r1.opReading();
        PushConnection.access$600(socket);
        PushConnection.access$300(PushConnection.this).Events(new Events[] {
            ITY_CHANGED, E_ERROR, R
        });
        return ((R) (obj));
    }

    public r(Socket socket1)
    {
        this$0 = PushConnection.this;
        super(PushConnection.this);
        socket = socket1;
    }
}
