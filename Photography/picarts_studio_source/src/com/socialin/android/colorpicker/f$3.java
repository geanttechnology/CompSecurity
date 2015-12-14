// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.colorpicker;

import android.view.View;
import android.widget.AdapterView;
import java.util.List;

// Referenced classes of package com.socialin.android.colorpicker:
//            f, e

final class a
    implements android.widget.terView.OnItemLongClickListener
{

    private e a;
    private f b;

    public final boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        if (((Integer)f.d(b).get(i)).intValue() != 0)
        {
            f.d(b).set(i, Integer.valueOf(0));
            a.notifyDataSetChanged();
        }
        f.g(b);
        return true;
    }

    ClickListener(f f1, e e1)
    {
        b = f1;
        a = e1;
        super();
    }
}
