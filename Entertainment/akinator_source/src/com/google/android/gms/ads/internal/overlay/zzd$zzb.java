// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.zzif;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzd

static final class zzqQ extends RelativeLayout
{

    zzif zzqQ;

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        zzqQ.zze(motionevent);
        return false;
    }

    public _cls9(Context context, String s)
    {
        super(context);
        zzqQ = new zzif(context, s);
    }
}
