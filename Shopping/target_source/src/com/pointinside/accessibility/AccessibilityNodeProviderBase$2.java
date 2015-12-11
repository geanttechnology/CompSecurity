// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.accessibility;

import android.support.v4.view.a.b;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.pointinside.accessibility:
//            AccessibilityNodeProviderBase

class this._cls0
    implements android.view.deProviderBase._cls2
{

    final AccessibilityNodeProviderBase this$0;

    public boolean onHover(View view, MotionEvent motionevent)
    {
        if (!b.a(AccessibilityNodeProviderBase.access$000(AccessibilityNodeProviderBase.this)))
        {
            return false;
        }
        switch (motionevent.getAction())
        {
        case 8: // '\b'
        default:
            return false;

        case 7: // '\007'
        case 9: // '\t'
            view = ((View) (getItemAt(motionevent.getX(), motionevent.getY())));
            AccessibilityNodeProviderBase.access$100(AccessibilityNodeProviderBase.this, view);
            return true;

        case 10: // '\n'
            AccessibilityNodeProviderBase.access$100(AccessibilityNodeProviderBase.this, null);
            break;
        }
        return true;
    }

    ()
    {
        this$0 = AccessibilityNodeProviderBase.this;
        super();
    }
}
