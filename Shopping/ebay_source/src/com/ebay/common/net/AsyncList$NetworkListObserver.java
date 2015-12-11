// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import java.io.IOException;

// Referenced classes of package com.ebay.common.net:
//            AsyncList

public static interface 
{

    public abstract void onChanged();

    public abstract void onGetNotReady();

    public abstract void onNetworkError(IOException ioexception);
}
