// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.app.Activity;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.common.api:
//            ResultCallbacks, Result, Status

public abstract class ResolvingResultCallbacks extends ResultCallbacks
{

    private final Activity mActivity;
    private final int zzaaY;

    protected ResolvingResultCallbacks(Activity activity, int i)
    {
        mActivity = (Activity)zzx.zzb(activity, "Activity must not be null");
        zzaaY = i;
    }

    public abstract void onSuccess(Result result);

    public abstract void onUnresolvableFailure(Status status);
}
