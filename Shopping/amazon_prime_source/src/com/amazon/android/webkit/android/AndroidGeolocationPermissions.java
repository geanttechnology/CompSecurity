// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import com.amazon.android.webkit.AmazonGeolocationPermissions;
import com.amazon.android.webkit.AmazonValueCallback;
import java.util.Set;

public class AndroidGeolocationPermissions extends AmazonGeolocationPermissions
{

    public AndroidGeolocationPermissions()
    {
    }

    public void allow(String s)
    {
        GeolocationPermissions.getInstance().allow(s);
    }

    public void clear(String s)
    {
        GeolocationPermissions.getInstance().clear(s);
    }

    public void clearAll()
    {
        GeolocationPermissions.getInstance().clearAll();
    }

    public void getAllowed(String s, final AmazonValueCallback amazonValueCallback)
    {
        amazonValueCallback = new ValueCallback() {

            final AndroidGeolocationPermissions this$0;
            final AmazonValueCallback val$amazonValueCallback;

            public void onReceiveValue(Boolean boolean1)
            {
                amazonValueCallback.onReceiveValue(boolean1);
            }

            public volatile void onReceiveValue(Object obj)
            {
                onReceiveValue((Boolean)obj);
            }

            
            {
                this$0 = AndroidGeolocationPermissions.this;
                amazonValueCallback = amazonvaluecallback;
                super();
            }
        };
        GeolocationPermissions.getInstance().getAllowed(s, amazonValueCallback);
    }

    public void getOrigins(final AmazonValueCallback amazonValueCallback)
    {
        amazonValueCallback = new ValueCallback() {

            final AndroidGeolocationPermissions this$0;
            final AmazonValueCallback val$amazonValueCallback;

            public volatile void onReceiveValue(Object obj)
            {
                onReceiveValue((Set)obj);
            }

            public void onReceiveValue(Set set)
            {
                amazonValueCallback.onReceiveValue(set);
            }

            
            {
                this$0 = AndroidGeolocationPermissions.this;
                amazonValueCallback = amazonvaluecallback;
                super();
            }
        };
        GeolocationPermissions.getInstance().getOrigins(amazonValueCallback);
    }
}
