// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.beta;

import android.content.Context;
import btx;
import bwl;
import bws;
import bwz;
import io.fabric.sdk.android.services.common.IdManager;

// Referenced classes of package com.crashlytics.android.beta:
//            Beta, BuildProperties

interface UpdatesController
{

    public abstract void initialize(Context context, Beta beta, IdManager idmanager, bwz bwz, BuildProperties buildproperties, bws bws, btx btx, 
            bwl bwl);

    public abstract boolean isActivityLifecycleTriggered();
}
