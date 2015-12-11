// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;

import com.groupon.tracking.mobile.sdk.ExceptionFunctor;
import roboguice.util.Ln;

// Referenced classes of package com.groupon:
//            GrouponModule

class this._cls0
    implements ExceptionFunctor
{

    final GrouponModule this$0;

    public void logException(Exception exception)
    {
        Ln.e(exception);
    }

    sdk.ExceptionFunctor()
    {
        this$0 = GrouponModule.this;
        super();
    }
}
