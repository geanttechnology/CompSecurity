// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.mediation;

import java.util.HashMap;

// Referenced classes of package com.sponsorpay.mediation:
//            SPMediationCoordinator, SPMediationAdapter

class this._cls0 extends HashMap
{

    private static final long serialVersionUID = 0x30be10da6905b68aL;
    final SPMediationCoordinator this$0;

    public SPMediationAdapter get(Object obj)
    {
        return (SPMediationAdapter)super.get(obj.toString().toLowerCase());
    }

    public volatile Object get(Object obj)
    {
        return get(obj);
    }

    public SPMediationAdapter put(String s, SPMediationAdapter spmediationadapter)
    {
        return (SPMediationAdapter)super.put(s.toString().toLowerCase(), spmediationadapter);
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put((String)obj, (SPMediationAdapter)obj1);
    }

    ()
    {
        this$0 = SPMediationCoordinator.this;
        super();
    }
}
