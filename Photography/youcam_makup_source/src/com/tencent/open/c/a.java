// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.c;

import android.content.Context;
import android.webkit.WebView;
import java.lang.reflect.Method;

public class a extends WebView
{

    public a(Context context)
    {
        super(context);
    }

    protected void onAttachedToWindow()
    {
        Object obj;
        super.onAttachedToWindow();
        obj = getSettings();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        obj = obj.getClass();
        try
        {
            obj = ((Class) (obj)).getMethod("removeJavascriptInterface", new Class[] {
                java/lang/String
            });
        }
        catch (Exception exception)
        {
            return;
        }
        if (obj == null) goto _L1; else goto _L3
_L3:
        ((Method) (obj)).invoke(this, new Object[] {
            "searchBoxJavaBridge_"
        });
        return;
    }
}
