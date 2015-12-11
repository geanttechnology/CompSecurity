// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.beta;

import android.content.Context;
import c.a.a.a.a.b.r;
import c.a.a.a.a.b.x;
import c.a.a.a.a.e.a;
import c.a.a.a.a.f.c;
import c.a.a.a.a.g.f;

// Referenced classes of package com.crashlytics.android.beta:
//            Beta, BuildProperties

interface UpdatesController
{

    public abstract void initialize$c689b02(Context context, Beta beta, x x, f f, BuildProperties buildproperties, c c, r r, 
            a a);

    public abstract boolean isActivityLifecycleTriggered();
}
