// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.uid.d;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.signals:
//            l

public class k extends NetworkRequest
{

    private static final String d = com/inmobi/signals/k.getSimpleName();
    private int e;
    private int f;
    private l g;

    public k(String s, int i, int j, d d1, l l1)
    {
        super(com.inmobi.commons.core.network.NetworkRequest.RequestType.POST, s, true, d1);
        e = i;
        f = j;
        g = l1;
        s = g.a().toString();
        c.put("payload", s);
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, d, (new StringBuilder()).append("Ice payload being sent:").append(s).toString());
    }

    public int b()
    {
        return e;
    }

    public int c()
    {
        return f;
    }

}
