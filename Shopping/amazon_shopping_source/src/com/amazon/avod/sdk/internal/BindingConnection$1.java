// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;


// Referenced classes of package com.amazon.avod.sdk.internal:
//            BindingConnection, BlockingBindingConnection

class this._cls0
    implements Runnable
{

    final BindingConnection this$0;

    public void run()
    {
        BindingConnection.access$000(BindingConnection.this).unbind();
    }

    ction()
    {
        this$0 = BindingConnection.this;
        super();
    }
}
