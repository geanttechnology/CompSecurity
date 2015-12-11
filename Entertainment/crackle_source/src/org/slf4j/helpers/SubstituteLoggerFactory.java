// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

// Referenced classes of package org.slf4j.helpers:
//            NOPLogger

public class SubstituteLoggerFactory
    implements ILoggerFactory
{

    private List a;

    public SubstituteLoggerFactory()
    {
        a = new ArrayList();
    }

    public Logger getLogger(String s)
    {
        a.add(s);
        return NOPLogger.NOP_LOGGER;
    }

    public List getLoggerNameList()
    {
        return a;
    }
}
