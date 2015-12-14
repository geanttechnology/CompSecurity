// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.colorpicker;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import java.util.List;

// Referenced classes of package com.socialin.android.colorpicker:
//            f, e, a

final class a
    implements android.widget.terView.OnItemClickListener
{

    private e a;
    private f b;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (((Integer)f.d(b).get(i)).intValue() == 0)
        {
            f.d(b).set(i, Integer.valueOf(b.b()));
            a.notifyDataSetChanged();
        } else
        {
            Color.colorToHSV(((Integer)f.d(b).get(i)).intValue(), f.e(b));
            f.a(b, ((Integer)f.d(b).get(i)).intValue());
            f.c(b).a(f.e(b));
            adapterview = f.c(b);
            adapterview.b = f.f(b);
            adapterview.d();
        }
        f.g(b);
    }

    kListener(f f1, e e1)
    {
        b = f1;
        a = e1;
        super();
    }
}
