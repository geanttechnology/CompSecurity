// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.photo.draw:
//            b, DrawingActivity

final class a
    implements android.view..OnClickListener
{

    private b a;
    private com.socialin.android.photo.draw.b b;

    public final void onClick(View view)
    {
        view = com.socialin.android.photo.draw.DrawingActivity.b(b.a);
        b b1 = a;
        boolean flag;
        if (!a.f)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setLayerVisibility(b1, flag);
        DrawingActivity.r(b.a).notifyDataSetChanged();
    }

    b(com.socialin.android.photo.draw.b b1, b b2)
    {
        b = b1;
        a = b2;
        super();
    }
}
