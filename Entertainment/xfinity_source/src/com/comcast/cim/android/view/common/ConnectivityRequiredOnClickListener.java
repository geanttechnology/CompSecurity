// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.view.View;
import com.comcast.cim.utils.UIUtil;

public class ConnectivityRequiredOnClickListener
    implements android.view.View.OnClickListener
{

    private Runnable runnable;
    private UIUtil uiUtil;

    public ConnectivityRequiredOnClickListener(UIUtil uiutil, Runnable runnable1)
    {
        uiUtil = uiutil;
        runnable = runnable1;
    }

    public void onClick(View view)
    {
        uiUtil.ensureConnectivityBeforeExecuting(view.getContext(), runnable);
    }
}
