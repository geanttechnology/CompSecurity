// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.internal;

import java.util.HashMap;

// Referenced classes of package com.boldchat.visitor.api.internal:
//            ResultListener

public class RPCMethod
{

    private ResultListener listener;
    private String method;
    private HashMap params;

    public RPCMethod(String s, HashMap hashmap, ResultListener resultlistener)
    {
        method = s;
        params = hashmap;
        listener = resultlistener;
    }

    public ResultListener getListener()
    {
        return listener;
    }

    public String getMethod()
    {
        return method;
    }

    public HashMap getParams()
    {
        return params;
    }
}
