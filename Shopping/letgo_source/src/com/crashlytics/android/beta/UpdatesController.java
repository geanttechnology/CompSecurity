// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.beta;

import android.content.Context;
import android.support.v7.ams;
import android.support.v7.amw;
import android.support.v7.aol;
import android.support.v7.aos;
import android.support.v7.aoz;

// Referenced classes of package com.crashlytics.android.beta:
//            Beta, BuildProperties

interface UpdatesController
{

    public abstract void initialize(Context context, Beta beta, amw amw, aoz aoz, BuildProperties buildproperties, aos aos, ams ams, 
            aol aol);

    public abstract boolean isActivityLifecycleTriggered();
}
