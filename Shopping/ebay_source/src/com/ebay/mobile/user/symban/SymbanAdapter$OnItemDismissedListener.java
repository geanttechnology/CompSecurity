// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import com.ebay.nautilus.domain.data.SymbanNotification;

// Referenced classes of package com.ebay.mobile.user.symban:
//            SymbanAdapter

public static interface 
{

    public abstract void onItemDismissed(SymbanNotification symbannotification);

    public abstract void onItemUnDismissed(SymbanNotification symbannotification);

    public abstract void onNoItemsDismissed();
}
