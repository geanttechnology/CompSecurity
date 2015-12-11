// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.support.v7.tr;
import android.support.v7.tz;
import android.support.v7.ul;
import android.view.MotionEvent;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzq

public static final class zzqG extends ViewSwitcher
{

    private final tr zzqF;
    private final tz zzqG;

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (zzqG != null)
        {
            zzqG.c();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (zzqG != null)
        {
            zzqG.d();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        zzqF.a(motionevent);
        return false;
    }

    public void removeAllViews()
    {
        Object obj = new ArrayList();
        for (int i = 0; i < getChildCount(); i++)
        {
            android.view.View view = getChildAt(i);
            if (view != null && (view instanceof ul))
            {
                ((List) (obj)).add((ul)view);
            }
        }

        super.removeAllViews();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((ul)((Iterator) (obj)).next()).destroy()) { }
    }

    public void zzbR()
    {
        zzb.v("Disable position monitoring on adFrame.");
        if (zzqG != null)
        {
            zzqG.b();
        }
    }

    public tr zzbT()
    {
        return zzqF;
    }

    public r(Context context, android.view.Observer.OnGlobalLayoutListener ongloballayoutlistener, android.view.Observer.OnScrollChangedListener onscrollchangedlistener)
    {
        super(context);
        zzqF = new tr(context);
        if (context instanceof Activity)
        {
            zzqG = new tz((Activity)context, ongloballayoutlistener, onscrollchangedlistener);
            zzqG.a();
            return;
        } else
        {
            zzqG = null;
            return;
        }
    }
}
