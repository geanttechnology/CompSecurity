// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IdleConnectionHandler
{

    private final Map connectionToTimes = new HashMap();
    private final Log log = LogFactory.getLog(getClass());

    public IdleConnectionHandler()
    {
    }

    public void removeAll()
    {
        connectionToTimes.clear();
    }
}
