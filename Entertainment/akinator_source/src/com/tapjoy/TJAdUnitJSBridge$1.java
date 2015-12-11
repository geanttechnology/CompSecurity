// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import java.lang.reflect.Method;
import org.json.JSONObject;

// Referenced classes of package com.tapjoy:
//            TJWebViewJSInterfaceListener, TJAdUnitJSBridge

final class a
    implements TJWebViewJSInterfaceListener
{

    final TJAdUnitJSBridge a;

    public final void onDispatchMethod(String s, JSONObject jsonobject)
    {
        Object obj;
        if (!TJAdUnitJSBridge.a(a))
        {
            break MISSING_BLOCK_LABEL_67;
        }
        try
        {
            obj = jsonobject.getString("callbackId");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
        }
        jsonobject = jsonobject.getJSONObject("data");
        com/tapjoy/TJAdUnitJSBridge.getMethod(s, new Class[] {
            org/json/JSONObject, java/lang/String
        }).invoke(TJAdUnitJSBridge.b(a), new Object[] {
            jsonobject, obj
        });
        return;
        s;
        s.printStackTrace();
        a.invokeJSCallback(((String) (obj)), new Object[] {
            Boolean.FALSE
        });
        return;
    }

    eListener(TJAdUnitJSBridge tjadunitjsbridge)
    {
        a = tjadunitjsbridge;
        super();
    }
}
