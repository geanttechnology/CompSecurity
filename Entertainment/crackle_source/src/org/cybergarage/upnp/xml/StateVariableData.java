// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.xml;

import org.cybergarage.upnp.control.QueryListener;
import org.cybergarage.upnp.control.QueryResponse;

// Referenced classes of package org.cybergarage.upnp.xml:
//            NodeData

public class StateVariableData extends NodeData
{

    private QueryListener queryListener;
    private QueryResponse queryRes;
    private String value;

    public StateVariableData()
    {
        value = "";
        queryListener = null;
        queryRes = null;
    }

    public QueryListener getQueryListener()
    {
        return queryListener;
    }

    public QueryResponse getQueryResponse()
    {
        return queryRes;
    }

    public String getValue()
    {
        return value;
    }

    public void setQueryListener(QueryListener querylistener)
    {
        queryListener = querylistener;
    }

    public void setQueryResponse(QueryResponse queryresponse)
    {
        queryRes = queryresponse;
    }

    public void setValue(String s)
    {
        value = s;
    }
}
