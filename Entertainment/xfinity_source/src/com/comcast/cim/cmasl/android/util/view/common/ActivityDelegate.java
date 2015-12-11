// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.common;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.common:
//            LifeCycleDelegate

public interface ActivityDelegate
    extends LifeCycleDelegate
{

    public abstract boolean isBlocking();

    public abstract void onActivityResult(int i, int j, Intent intent);

    public abstract View onCreateView(String s, Context context, AttributeSet attributeset);
}
