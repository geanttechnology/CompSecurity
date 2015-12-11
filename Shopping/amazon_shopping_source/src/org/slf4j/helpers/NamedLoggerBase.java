// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j.helpers;

import java.io.Serializable;
import org.slf4j.Logger;

abstract class NamedLoggerBase
    implements Serializable, Logger
{

    protected String name;

    NamedLoggerBase()
    {
    }

    public String getName()
    {
        return name;
    }
}
