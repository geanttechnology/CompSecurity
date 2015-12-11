// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.millennialmedia.android:
//            MMWebView, MMJSObject, MMJSResponse, MMSDK

class MMCommand
    implements Runnable
{

    private Map arguments;
    private String callback;
    private Class cls;
    private Method method;
    private WeakReference webViewRef;

    MMCommand(MMWebView mmwebview, String s)
    {
        webViewRef = new WeakReference(mmwebview);
        String as[];
        as = Uri.parse(s).getHost().split("\\.");
        if (as.length < 2)
        {
            return;
        }
        String s1;
        String as1[];
        int j;
        mmwebview = as[as.length - 2];
        s1 = as[as.length - 1];
        arguments = new HashMap();
        as1 = s.substring(s.indexOf('?') + 1).split("&");
        j = as1.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        String as2[] = as1[i].split("=");
        if (as2.length >= 2)
        {
            arguments.put(Uri.decode(as2[0]), Uri.decode(as2[1]));
            if (as2[0].equalsIgnoreCase("callback"))
            {
                callback = Uri.decode(as2[1]);
            }
        }
        break MISSING_BLOCK_LABEL_243;
        try
        {
            cls = Class.forName((new StringBuilder()).append("com.millennialmedia.android.Bridge").append(mmwebview).toString());
            method = cls.getMethod(s1, new Class[] {
                arguments.getClass()
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MMWebView mmwebview)
        {
            MMSDK.Log.e("Exception while executing javascript call %s %s", new Object[] {
                s, mmwebview.getMessage()
            });
        }
        mmwebview.printStackTrace();
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private String getBridgeStrippedClassName()
    {
        return cls.getSimpleName().replaceFirst("Bridge", "");
    }

    boolean isResizeCommand()
    {
        if (method != null)
        {
            return "resize".equals(method.getName());
        } else
        {
            return false;
        }
    }

    public void run()
    {
        if (cls == null || method == null)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        final Object call;
        InvocationTargetException invocationtargetexception;
        Object obj1;
        final MMWebView webViewCallback;
        try
        {
            call = (MMWebView)webViewRef.get();
        }
        catch (Exception exception)
        {
            MMSDK.Log.e("Exception while executing javascript call %s %s", new Object[] {
                method.toString(), exception.getMessage()
            });
            exception.printStackTrace();
            return;
        }
        if (call == null)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        obj1 = (MMJSObject)cls.newInstance();
        ((MMJSObject) (obj1)).setContext(((MMWebView) (call)).getContext());
        ((MMJSObject) (obj1)).setMMWebView(((MMWebView) (call)));
        ((MMWebView) (call)).updateArgumentsWithSettings(arguments);
        call = (MMJSResponse)method.invoke(obj1, new Object[] {
            arguments
        });
_L1:
        if (callback == null || callback.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        webViewCallback = (MMWebView)webViewRef.get();
        if (webViewCallback == null)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        obj1 = call;
        if (call != null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        obj1 = MMJSResponse.responseWithError(method.getName());
        if (((MMJSResponse) (obj1)).methodName == null)
        {
            obj1.methodName = method.getName();
        }
        if (((MMJSResponse) (obj1)).className == null)
        {
            obj1.className = getBridgeStrippedClassName();
        }
        call = String.format("javascript:%s(%s);", new Object[] {
            callback, ((MMJSResponse) (obj1)).toJSONString()
        });
        MMSDK.Log.v((new StringBuilder()).append("Executing JS bridge callback: ").append(((String) (call))).toString());
        MMSDK.runOnUiThread(new Runnable() {

            final MMCommand this$0;
            final String val$call;
            final MMWebView val$webViewCallback;

            public void run()
            {
                if (method.getName().equals("expandWithProperties"))
                {
                    webViewCallback.isExpanding = true;
                }
                webViewCallback.loadUrl(call);
            }

            
            {
                this$0 = MMCommand.this;
                webViewCallback = mmwebview;
                call = s;
                super();
            }
        });
        return;
        invocationtargetexception;
        invocationtargetexception = invocationtargetexception.getCause();
        if (invocationtargetexception == null)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        if (invocationtargetexception.getClass() != android/content/ActivityNotFoundException)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        invocationtargetexception = MMJSResponse.responseWithError("Activity not found");
          goto _L1
        invocationtargetexception = MMJSResponse.responseWithError();
          goto _L1
        if (!TextUtils.isEmpty(callback))
        {
            Object obj = MMJSResponse.responseWithError("No class or method found");
            obj = String.format("javascript:%s(%s);", new Object[] {
                callback, ((MMJSResponse) (obj)).toJSONString()
            });
            MMSDK.Log.v((new StringBuilder()).append("Executing JS bridge failed callback: ").append(((String) (obj))).toString());
            MMSDK.runOnUiThread(new Runnable() {

                final MMCommand this$0;
                final String val$call;
                final MMWebView val$webViewCallback;

                public void run()
                {
                    webViewCallback.loadUrl(call);
                }

            
            {
                this$0 = MMCommand.this;
                webViewCallback = mmwebview;
                call = s;
                super();
            }
            });
        }
    }

}
