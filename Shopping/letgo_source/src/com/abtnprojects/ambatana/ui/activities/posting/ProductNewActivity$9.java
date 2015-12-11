// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.posting;

import android.support.v7.hp;
import android.view.View;
import android.widget.AdapterView;
import com.abtnprojects.ambatana.models.Category;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.posting:
//            ProductNewActivity

class a
    implements android.widget.ectedListener
{

    final hp a;
    final ProductNewActivity b;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (i >= 1)
        {
            adapterview = a.a(i);
            ProductNewActivity.b(b, adapterview.getId());
            return;
        } else
        {
            ProductNewActivity.b(b, 0);
            return;
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    (ProductNewActivity productnewactivity, hp hp1)
    {
        b = productnewactivity;
        a = hp1;
        super();
    }
}
