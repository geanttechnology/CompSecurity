// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.savepagescrollview;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.fotoable.savepagescrollview:
//            FotoFbNativeAdViewItem

class a
    implements android.view.NativeAdViewItem._cls1
{

    final FotoFbNativeAdViewItem a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return true;
    }

    (FotoFbNativeAdViewItem fotofbnativeadviewitem)
    {
        a = fotofbnativeadviewitem;
        super();
    }
}
