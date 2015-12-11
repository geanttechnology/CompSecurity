// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.content.Context;
import com.amazon.android.webkit.AmazonWebKitUpdateHandler;
import com.amazon.android.webkit.AmazonWebKitUpdateReadyListener;

public class AndroidWebKitUpdateHandler
    implements AmazonWebKitUpdateHandler
{

    public AndroidWebKitUpdateHandler()
    {
    }

    public boolean isUpdateRequired(Context context)
    {
        return false;
    }

    public void setReadyListener(AmazonWebKitUpdateReadyListener amazonwebkitupdatereadylistener)
    {
        if (amazonwebkitupdatereadylistener != null)
        {
            amazonwebkitupdatereadylistener.onSuccess();
        }
    }

    public void startUpdate()
    {
    }
}
