// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.http;

import android.net.Uri;
import com.amazon.blueshift.bluefront.android.common.BluefrontCredential;
import java.net.MalformedURLException;

// Referenced classes of package com.amazon.blueshift.bluefront.android.http:
//            URLWrapper

public interface SigningProtocol
{

    public abstract URLWrapper sign(BluefrontCredential bluefrontcredential, Uri uri)
        throws MalformedURLException;
}
