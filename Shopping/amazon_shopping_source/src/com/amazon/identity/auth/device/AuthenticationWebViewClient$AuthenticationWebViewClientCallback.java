// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.os.Bundle;
import com.amazon.identity.auth.device.endpoint.OpenIdResponse;

// Referenced classes of package com.amazon.identity.auth.device:
//            AuthenticationWebViewClient

public static interface 
{

    public abstract void onCodeEnterFinished();

    public abstract void onPageFinished();

    public abstract void onPageStarted(String s);

    public abstract void setError(Bundle bundle);

    public abstract void setResult(OpenIdResponse openidresponse);
}
