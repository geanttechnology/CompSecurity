// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage

private class isThumbUp
    implements android.view.istener
{

    private boolean isThumbUp;
    final BusinessDetailPage this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 1: default 28
    //                   0 30
    //                   1 62;
           goto _L1 _L2 _L3
_L1:
        return false;
_L2:
        if (android.os.hListener >= 21)
        {
            ((ViewGroup)view).getChildAt(0).getBackground().setHotspot(motionevent.getX(), motionevent.getY());
            return false;
        }
          goto _L1
_L3:
        onButtonUp(isThumbUp);
        return false;
    }

    public (boolean flag)
    {
        this$0 = BusinessDetailPage.this;
        super();
        isThumbUp = flag;
    }
}
