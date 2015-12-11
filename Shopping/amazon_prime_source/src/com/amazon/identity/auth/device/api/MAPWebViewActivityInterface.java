// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.app.Activity;
import android.os.Bundle;
import com.amazon.android.webkit.AmazonWebView;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPWebViewHelper

public interface MAPWebViewActivityInterface
{

    public abstract Activity getActivity();

    public abstract Callback getAuthActivityCallback();

    public abstract Callback getEventCallback();

    public abstract Bundle getOptions();

    public abstract AmazonWebView getWebView();

    public abstract MAPWebViewHelper getWebWebViewHelper();
}
