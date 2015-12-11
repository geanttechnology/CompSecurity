// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

class val.popupWindow
    implements android.view.ment._cls19
{

    final NearbyDealsFragment this$0;
    final PopupWindow val$popupWindow;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 4)
        {
            val$popupWindow.dismiss();
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = final_nearbydealsfragment;
        val$popupWindow = PopupWindow.this;
        super();
    }
}
