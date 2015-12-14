// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.beta;

import aaz;
import acy;
import adf;
import adm;
import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;

// Referenced classes of package com.crashlytics.android.beta:
//            Beta, BuildProperties

interface UpdatesController
{

    public abstract void initialize(Context context, Beta beta, IdManager idmanager, adm adm, BuildProperties buildproperties, adf adf, aaz aaz, 
            acy acy);

    public abstract boolean isActivityLifecycleTriggered();
}
