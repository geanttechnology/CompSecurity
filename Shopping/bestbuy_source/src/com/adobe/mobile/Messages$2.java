// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.adobe.mobile:
//            Messages, MobileConfig, Lifecycle, Message

final class val.vars
    implements Runnable
{

    final Map val$cdata;
    final Map val$vars;

    public void run()
    {
        Object obj = MobileConfig.getInstance().getCallbackTemplates();
        if (obj != null && ((ArrayList) (obj)).size() > 0)
        {
            HashMap hashmap = new HashMap(Lifecycle.getContextDataLowercase());
            HashMap hashmap1 = Messages.lowercaseKeysForMap(val$cdata);
            HashMap hashmap2 = Messages.lowercaseKeysForMap(val$vars);
            obj = ((ArrayList) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Message message = (Message)((Iterator) (obj)).next();
                if (message.shouldShowForVariables(hashmap2, hashmap1, hashmap))
                {
                    message.show();
                }
            }
        }
    }

    g()
    {
        val$cdata = map;
        val$vars = map1;
        super();
    }
}
