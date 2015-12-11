// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.util.android;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.comcast.playerplatform.util.android:
//            ConfigurationManager, IConfigurationEventListener

class val.xmlString
    implements Runnable
{

    final ConfigurationManager this$0;
    final String val$xmlString;

    public void run()
    {
        CopyOnWriteArrayList copyonwritearraylist = ConfigurationManager.access$100(ConfigurationManager.this);
        copyonwritearraylist;
        JVM INSTR monitorenter ;
        for (Iterator iterator = ConfigurationManager.access$100(ConfigurationManager.this).iterator(); iterator.hasNext(); ((IConfigurationEventListener)iterator.next()).configurationFailed((new StringBuilder()).append("Configuration Error. Unable to parse xml: ").append(val$xmlString).toString())) { }
        break MISSING_BLOCK_LABEL_74;
        Exception exception;
        exception;
        copyonwritearraylist;
        JVM INSTR monitorexit ;
        throw exception;
        copyonwritearraylist;
        JVM INSTR monitorexit ;
    }

    ener()
    {
        this$0 = final_configurationmanager;
        val$xmlString = String.this;
        super();
    }
}
