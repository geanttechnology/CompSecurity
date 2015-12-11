// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountRegistrar

public static interface rationError
{

    public abstract void accountAlreadyExists(String s);

    public abstract void failure(com.amazon.identity.auth.device.api.tionError tionerror, Bundle bundle);

    public abstract void success(String s, String s1, Bundle bundle);
}
