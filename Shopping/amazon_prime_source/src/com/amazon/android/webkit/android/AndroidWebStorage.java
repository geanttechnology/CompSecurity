// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import com.amazon.android.webkit.AmazonValueCallback;
import com.amazon.android.webkit.AmazonWebStorage;
import java.util.Map;

public class AndroidWebStorage extends AmazonWebStorage
{

    public AndroidWebStorage()
    {
    }

    public void deleteAllData()
    {
        WebStorage.getInstance().deleteAllData();
    }

    public void deleteOrigin(String s)
    {
        WebStorage.getInstance().deleteOrigin(s);
    }

    public void getOrigins(final AmazonValueCallback amazonValueCallback)
    {
        amazonValueCallback = new ValueCallback() {

            final AndroidWebStorage this$0;
            final AmazonValueCallback val$amazonValueCallback;

            public volatile void onReceiveValue(Object obj)
            {
                onReceiveValue((Map)obj);
            }

            public void onReceiveValue(Map map)
            {
                amazonValueCallback.onReceiveValue(map);
            }

            
            {
                this$0 = AndroidWebStorage.this;
                amazonValueCallback = amazonvaluecallback;
                super();
            }
        };
        WebStorage.getInstance().getOrigins(amazonValueCallback);
    }

    public void getQuotaForOrigin(String s, final AmazonValueCallback amazonValueCallback)
    {
        amazonValueCallback = new ValueCallback() {

            final AndroidWebStorage this$0;
            final AmazonValueCallback val$amazonValueCallback;

            public void onReceiveValue(Long long1)
            {
                amazonValueCallback.onReceiveValue(long1);
            }

            public volatile void onReceiveValue(Object obj)
            {
                onReceiveValue((Long)obj);
            }

            
            {
                this$0 = AndroidWebStorage.this;
                amazonValueCallback = amazonvaluecallback;
                super();
            }
        };
        WebStorage.getInstance().getQuotaForOrigin(s, amazonValueCallback);
    }

    public void getUsageForOrigin(String s, final AmazonValueCallback amazonValueCallback)
    {
        amazonValueCallback = new ValueCallback() {

            final AndroidWebStorage this$0;
            final AmazonValueCallback val$amazonValueCallback;

            public void onReceiveValue(Long long1)
            {
                amazonValueCallback.onReceiveValue(long1);
            }

            public volatile void onReceiveValue(Object obj)
            {
                onReceiveValue((Long)obj);
            }

            
            {
                this$0 = AndroidWebStorage.this;
                amazonValueCallback = amazonvaluecallback;
                super();
            }
        };
        WebStorage.getInstance().getUsageForOrigin(s, amazonValueCallback);
    }

    public void setQuotaForOrigin(String s, long l)
    {
        WebStorage.getInstance().setQuotaForOrigin(s, l);
    }
}
