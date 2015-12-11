// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.target.ui.view.map:
//            StoreMapView

class this._cls0
    implements android.view.tener
{

    final StoreMapView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 2 && StoreMapView.e(StoreMapView.this) != null)
        {
            StoreMapView.e(StoreMapView.this).();
        }
        return false;
    }

    ()
    {
        this$0 = StoreMapView.this;
        super();
    }
}
