// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountsLogic

private static class extras
{

    public final String action;
    public final Bundle extras;
    public final String packageName;

    public (String s)
    {
        this(s, null, null);
    }

    public <init>(String s, String s1, Bundle bundle)
    {
        action = s;
        packageName = s1;
        extras = bundle;
    }
}
