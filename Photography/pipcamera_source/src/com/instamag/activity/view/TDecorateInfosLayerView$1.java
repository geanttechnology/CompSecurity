// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.view;

import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import ri;
import rj;
import rl;

// Referenced classes of package com.instamag.activity.view:
//            TDecorateInfosLayerView

class <init> extends android.view.stureListener
{

    final TDecorateInfosLayerView a;

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        Log.v("TDecorateInfoView", (new StringBuilder()).append("onScroll:").append(f).append("y:").append(f1).toString());
        if (TDecorateInfosLayerView.access$000(a) != null && TDecorateInfosLayerView.access$000(a).a().z)
        {
            TDecorateInfosLayerView.access$000(a).b().postTranslate(-f, -f1);
            a.invalidate();
        }
        return true;
    }

    public void onShowPress(MotionEvent motionevent)
    {
        if (TDecorateInfosLayerView.access$000(a) != null && TDecorateInfosLayerView.access$000(a).a().z)
        {
            TDecorateInfosLayerView.access$000(a).a().l.postConcat(TDecorateInfosLayerView.access$000(a).a().k);
            TDecorateInfosLayerView.access$000(a).a().k.reset();
        }
        super.onShowPress(motionevent);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        Log.v("TDecorateInfoView", (new StringBuilder()).append("onSingleTapConfirmed:").append(motionevent.toString()).toString());
        if (TDecorateInfosLayerView.access$000(a) == null || TDecorateInfosLayerView.access$000(a).a() == null)
        {
            return false;
        }
        if ((TDecorateInfosLayerView.access$000(a) == null || !TDecorateInfosLayerView.access$000(a).a().r || !TDecorateInfosLayerView.access$000(a).a().A) && !TDecorateInfosLayerView.access$000(a).a().J) goto _L2; else goto _L1
_L1:
        if (!TDecorateInfosLayerView.access$100(a)) goto _L4; else goto _L3
_L3:
        TDecorateInfosLayerView.access$000(a).a(true);
        a.invalidate();
_L2:
        return super.onSingleTapConfirmed(motionevent);
_L4:
        if (TDecorateInfosLayerView.access$200(a) != null)
        {
            TDecorateInfosLayerView.access$200(a).a(TDecorateInfosLayerView.access$000(a));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    (TDecorateInfosLayerView tdecorateinfoslayerview)
    {
        a = tdecorateinfoslayerview;
        super();
    }
}
