// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.responses;


// Referenced classes of package com.flurry.android.responses:
//            AppCloudError

public interface AppCloudSearchResultCompletionHandler
{

    public abstract void onError(AppCloudError appclouderror);

    public abstract void onOperationSucceed(Object aobj[]);
}
