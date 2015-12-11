// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib;

import com.comcast.cim.cmasl.utils.logging.Log4JConfigurator;
import org.apache.log4j.Logger;

public class PlayNowLog4JConfiguratorProduction
    implements Log4JConfigurator
{

    public PlayNowLog4JConfiguratorProduction()
    {
    }

    public void configureLogging()
    {
        Logger.getRootLogger().removeAllAppenders();
    }
}
