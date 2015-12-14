// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import java.util.List;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountsLogic

private static interface Q
{

    public abstract boolean isMappingCurrentlySetForAccount(String s);

    public abstract boolean isSupportedOnThisPlatform();

    public abstract List onDeregister(String s);

    public abstract List removeAndNotify(String s);

    public abstract List setAndNotify(String s);
}
