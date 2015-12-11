// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;

import com.groupon.tracking.mobile.sdk.InfoFunctor;
import roboguice.util.Ln;

// Referenced classes of package com.groupon:
//            GrouponModule

class this._cls0
    implements InfoFunctor
{

    final GrouponModule this$0;

    public void logInfo(String s)
    {
        Ln.d(s, new Object[0]);
    }

    sdk.InfoFunctor()
    {
        this$0 = GrouponModule.this;
        super();
    }
}
