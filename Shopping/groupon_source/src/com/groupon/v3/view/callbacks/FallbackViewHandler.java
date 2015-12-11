// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.callbacks;

import roboguice.util.Ln;

// Referenced classes of package com.groupon.v3.view.callbacks:
//            FallbackCallback

public class FallbackViewHandler
    implements FallbackCallback
{

    public FallbackViewHandler()
    {
    }

    public void onBind(Object obj)
    {
        Ln.w((new StringBuilder()).append("Fallback for ").append(String.valueOf(obj)).toString(), new Object[0]);
    }
}
