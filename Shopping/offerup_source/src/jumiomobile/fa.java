// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package jumiomobile:
//            ey

class fa
    implements android.widget.AdapterView.OnItemSelectedListener
{

    final ey a;

    fa(ey ey1)
    {
        a = ey1;
        super();
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (a.getVisibility() == 0)
        {
            a.b();
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }
}
