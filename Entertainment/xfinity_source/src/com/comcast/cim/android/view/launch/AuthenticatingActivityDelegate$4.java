// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.launch;


// Referenced classes of package com.comcast.cim.android.view.launch:
//            AuthenticatingActivityDelegate

class this._cls0
    implements Runnable
{

    final AuthenticatingActivityDelegate this$0;

    public void run()
    {
        checkForUserUpgrade();
    }

    ()
    {
        this$0 = AuthenticatingActivityDelegate.this;
        super();
    }
}
