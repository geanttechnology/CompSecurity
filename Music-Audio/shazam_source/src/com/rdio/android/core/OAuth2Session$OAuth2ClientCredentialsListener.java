// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.google.api.a.a.a.i;

// Referenced classes of package com.rdio.android.core:
//            OAuth2Session

public static interface I
{

    public abstract void onCredentialRefreshed(i i);

    public abstract void onError(String s);

    public abstract void onReceivedCredentials(i i);
}
