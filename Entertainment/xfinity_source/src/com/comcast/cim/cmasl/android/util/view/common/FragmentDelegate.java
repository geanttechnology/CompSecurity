// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.common;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.common:
//            LifeCycleDelegate

public interface FragmentDelegate
    extends LifeCycleDelegate
{

    public abstract void onAttach(Activity activity);

    public abstract View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle);
}
