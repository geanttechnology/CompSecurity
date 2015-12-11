// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.managers;

import com.rdio.android.core.util.Logging;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.rdio.android.core.managers:
//            AdManager

class val.path
    implements Runnable
{

    final AdManager this$0;
    final String val$path;

    public void run()
    {
        Object obj;
        Object obj1;
        Object obj2;
        try
        {
            obj1 = new URL(val$path);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            AdManager.access$300(AdManager.this).log(6, "AdManager", (new StringBuilder("MalformedURLException when trying to request '")).append(val$path).append("' : ").append(obj).toString());
            return;
        }
        obj = null;
        obj2 = null;
        obj1 = (HttpURLConnection)((URL) (obj1)).openConnection();
        new BufferedInputStream(((HttpURLConnection) (obj1)).getInputStream());
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
_L2:
        return;
        obj;
        obj1 = obj2;
        obj2 = obj;
_L5:
        obj = obj1;
        AdManager.access$300(AdManager.this).log(6, "AdManager", (new StringBuilder("IOException when trying to request '")).append(val$path).append("' : ").append(obj2).toString());
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        ((HttpURLConnection) (obj1)).disconnect();
        return;
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
_L4:
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
        throw obj;
        obj;
        if (true) goto _L4; else goto _L3
_L3:
        exception;
          goto _L5
    }

    ()
    {
        this$0 = final_admanager;
        val$path = String.this;
        super();
    }
}
