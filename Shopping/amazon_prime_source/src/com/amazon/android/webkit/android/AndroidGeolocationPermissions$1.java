// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.ValueCallback;
import com.amazon.android.webkit.AmazonValueCallback;
import java.util.Set;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidGeolocationPermissions

class val.amazonValueCallback
    implements ValueCallback
{

    final AndroidGeolocationPermissions this$0;
    final AmazonValueCallback val$amazonValueCallback;

    public volatile void onReceiveValue(Object obj)
    {
        onReceiveValue((Set)obj);
    }

    public void onReceiveValue(Set set)
    {
        val$amazonValueCallback.onReceiveValue(set);
    }

    ()
    {
        this$0 = final_androidgeolocationpermissions;
        val$amazonValueCallback = AmazonValueCallback.this;
        super();
    }
}
