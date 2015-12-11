// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            SubAuthenticatorConnection

public static interface 
{

    public abstract void error(SubAuthenticatorConnection subauthenticatorconnection, int i, String s);

    public abstract void success(SubAuthenticatorConnection subauthenticatorconnection, Bundle bundle);
}
