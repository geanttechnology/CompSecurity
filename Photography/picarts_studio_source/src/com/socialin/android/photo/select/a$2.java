// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.graphics.Paint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import com.socialin.android.util.d;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.select:
//            a, b, c

final class b
    implements android.widget.terView.OnItemSelectedListener
{

    private ArrayList a;
    private List b;
    private a c;

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        c.c.setText((CharSequence)a.get(i));
        if (c.a != null)
        {
            adapterview = c.a.f();
            if (adapterview != null)
            {
                i = ((Integer)b.get(i)).intValue();
                adapterview.G = i;
                view = d.a(i);
                ((c) (adapterview)).p.setXfermode(view);
                adapterview = c.a.g();
                if (adapterview != null)
                {
                    adapterview.invalidate();
                }
            }
        }
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }

    tedListener(a a1, ArrayList arraylist, List list)
    {
        c = a1;
        a = arraylist;
        b = list;
        super();
    }
}
