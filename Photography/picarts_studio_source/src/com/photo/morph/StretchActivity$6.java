// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.view.View;
import android.widget.RelativeLayout;

// Referenced classes of package com.photo.morph:
//            StretchActivity

final class a
    implements android.view.er
{

    private RelativeLayout a;
    private StretchActivity b;

    public final void onClick(View view)
    {
        a.removeView(StretchActivity.y(b));
        StretchActivity.z(b);
    }

    (StretchActivity stretchactivity, RelativeLayout relativelayout)
    {
        b = stretchactivity;
        a = relativelayout;
        super();
    }
}
