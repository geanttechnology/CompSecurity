// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.os.Bundle;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            TokenCache

public static interface 
{

    public abstract void failure(String s, int i, String s1);

    public abstract void failure(String s, Bundle bundle);

    public abstract void success();
}
