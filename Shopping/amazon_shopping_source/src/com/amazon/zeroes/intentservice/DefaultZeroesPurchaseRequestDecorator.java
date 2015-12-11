// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice;

import org.json.JSONObject;

// Referenced classes of package com.amazon.zeroes.intentservice:
//            ZeroesPurchaseRequestDecorator

public class DefaultZeroesPurchaseRequestDecorator
    implements ZeroesPurchaseRequestDecorator
{

    public DefaultZeroesPurchaseRequestDecorator()
    {
    }

    public JSONObject decorateZeroesPurchaseRequest(JSONObject jsonobject)
    {
        return jsonobject;
    }
}
