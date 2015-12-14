// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.socialin.android.multiselect:
//            e, f

final class b
    implements android.view..OnClickListener
{

    private f a;
    private View b;
    private e c;

    public final void onClick(View view)
    {
        if (e.g(c).containsKey(a.c))
        {
            if (e.g(c).get(a.c) != null)
            {
                ((Bitmap)e.g(c).get(a.c)).recycle();
            }
            e.g(c).remove(a.c);
        }
        e.c(c).removeView(view);
        e.b(c).remove(a);
        ((TextView)b.findViewById(0x7f10072e)).setText((new StringBuilder()).append(e.b(c).size()).toString());
        if (e.b(c).size() == 0)
        {
            b.setVisibility(8);
        }
    }

    (e e1, f f1, View view)
    {
        c = e1;
        a = f1;
        b = view;
        super();
    }
}
