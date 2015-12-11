// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zze

class zzoE
    implements android.view.ouchListener
{

    final zze zzoE;
    final rdClick zzoF;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        zzoE.recordClick();
        return false;
    }

    ( , zze zze1)
    {
        zzoF = ;
        zzoE = zze1;
        super();
    }
}
