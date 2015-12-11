// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;


// Referenced classes of package com.facebook:
//            AccessTokenManager

class enRefreshCallback
    implements Runnable
{

    final AccessTokenManager this$0;
    final enRefreshCallback val$callback;

    public void run()
    {
        AccessTokenManager.access$000(AccessTokenManager.this, val$callback);
    }

    enRefreshCallback()
    {
        this$0 = final_accesstokenmanager;
        val$callback = enRefreshCallback.this;
        super();
    }
}
