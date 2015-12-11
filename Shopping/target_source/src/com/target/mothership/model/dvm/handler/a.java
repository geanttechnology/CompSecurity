// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.dvm.handler;

import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.f;
import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.mothership.services.z;

// Referenced classes of package com.target.mothership.model.dvm.handler:
//            TGTDvmDataResponse

public class a extends f
{

    private static final String RESPONSE_ERROR_REASON = "Dvm service returned bad response data for a success status code";

    public a(h h)
    {
        super(h);
    }

    protected DvmDataResponse a(com.target.mothership.services.d.a.b.a a1)
    {
        TGTDvmDataResponse tgtdvmdataresponse = new TGTDvmDataResponse();
        tgtdvmdataresponse.b(a1.b());
        tgtdvmdataresponse.a(a1.a());
        tgtdvmdataresponse.c(a1.c());
        return tgtdvmdataresponse;
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.d.a.b.a)obj);
    }

    protected boolean b(com.target.mothership.services.d.a.b.a a1)
    {
        return a1 != null && a1.b() != null && a1.c() != null && a1.a() != null;
    }

    protected x c(com.target.mothership.services.d.a.b.a a1)
    {
        return x.a("Dvm service returned bad response data for a success status code").b("").a(z.EMPTY_RESPONSE).a();
    }

    protected volatile Object c(Object obj)
    {
        return c((com.target.mothership.services.d.a.b.a)obj);
    }

    protected boolean e(Object obj)
    {
        return b((com.target.mothership.services.d.a.b.a)obj);
    }
}
