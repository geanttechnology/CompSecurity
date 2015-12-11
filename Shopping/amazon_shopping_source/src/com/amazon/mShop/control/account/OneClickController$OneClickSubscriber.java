// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.mShop.model.auth.UserSubscriber;
import com.amazon.rio.j2me.client.services.mShop.OneClickConfigResponse;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.account:
//            OneClickController

public static interface 
    extends UserSubscriber
{

    public abstract void onReceiveOneClickAddresses(List list);

    public abstract void onReceiveOneClickConfig(OneClickConfigResponse oneclickconfigresponse);

    public abstract void onSaveOneClickStatus(boolean flag);
}
