// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.dvm;

import com.target.mothership.model.dvm.interfaces.DvmRemoteData;
import com.target.mothership.model.e;
import com.target.mothership.model.h;
import com.target.mothership.services.d.a.c.a;
import java.net.URL;

// Referenced classes of package com.target.mothership.model.dvm:
//            a

public class b
    implements com.target.mothership.model.dvm.a
{

    private final a mServices = new a();

    public b()
    {
    }

    public void a(DvmRemoteData dvmremotedata, h h)
    {
        h = new e(new com.target.mothership.model.dvm.handler.a(h));
        dvmremotedata = dvmremotedata.a();
        dvmremotedata = (new StringBuilder()).append(dvmremotedata.getPath()).append("?").append(dvmremotedata.getQuery()).toString();
        mServices.a(dvmremotedata, h);
    }

    public void a(String s, h h)
    {
        h = new e(new com.target.mothership.model.dvm.handler.b(h));
        mServices.b(s, h);
    }
}
