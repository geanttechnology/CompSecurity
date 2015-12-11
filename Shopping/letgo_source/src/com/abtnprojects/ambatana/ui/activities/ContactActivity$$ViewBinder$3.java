// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            ContactActivity

class a
    implements android.widget.ener
{

    final ContactActivity a;
    final  b;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        a.onItemSelected(i);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    ( , ContactActivity contactactivity)
    {
        b = ;
        a = contactactivity;
        super();
    }
}
