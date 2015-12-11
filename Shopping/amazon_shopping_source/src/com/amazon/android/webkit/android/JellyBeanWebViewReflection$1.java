// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import com.amazon.android.webkit.AmazonFindListener;

// Referenced classes of package com.amazon.android.webkit.android:
//            JellyBeanWebViewReflection

class val.listener
    implements android.webkit.ebViewReflection._cls1
{

    final JellyBeanWebViewReflection this$0;
    final AmazonFindListener val$listener;

    public void onFindResultReceived(int i, int j, boolean flag)
    {
        val$listener.onFindResultReceived(i, j, flag);
    }

    ()
    {
        this$0 = final_jellybeanwebviewreflection;
        val$listener = AmazonFindListener.this;
        super();
    }
}
