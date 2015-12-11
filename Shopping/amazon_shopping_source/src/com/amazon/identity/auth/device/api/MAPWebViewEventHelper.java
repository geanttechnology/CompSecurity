// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.os.Bundle;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback

public final class MAPWebViewEventHelper
{

    public static final String AUTHENTICATION_EVENT = "authentication_event";
    public static final String AUTHENTICATION_ONLY_EVENT = "authentication_only_event";
    public static final String ERROR_EVENT = "error_event";
    public static final String ERROR_EVENT_VALUE = "error_event_value";
    public static final String KEY_ERRORS = "errors";
    public static final String KEY_EVENT_TYPE = "event_type";
    private final Bundle mResult;

    public MAPWebViewEventHelper(Bundle bundle)
    {
        mResult = bundle;
    }

    private boolean resultContainsKey(String s)
    {
        if (mResult == null)
        {
            return false;
        } else
        {
            return mResult.containsKey(s);
        }
    }

    static void setAuthenticationEvent(Callback callback)
    {
        if (callback == null)
        {
            return;
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putString("event_type", "authentication_event");
            callback.onSuccess(bundle);
            return;
        }
    }

    static void setAuthenticationOnlyEvent(Callback callback)
    {
        if (callback == null)
        {
            return;
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putString("event_type", "authentication_only_event");
            callback.onSuccess(bundle);
            return;
        }
    }

    static void setError(Bundle bundle, Callback callback)
    {
        if (callback == null)
        {
            return;
        } else
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("event_type", "error_event_value");
            bundle1.putAll(bundle);
            callback.onError(bundle1);
            return;
        }
    }

    public boolean isAuthenticationEvent()
    {
        if (!resultContainsKey("event_type"))
        {
            return false;
        } else
        {
            return mResult.getString("event_type").equals("authentication_event");
        }
    }

    public boolean isErrorEvent()
    {
        if (!resultContainsKey("event_type"))
        {
            return false;
        } else
        {
            return mResult.getString("event_type").equals("error_event");
        }
    }
}
