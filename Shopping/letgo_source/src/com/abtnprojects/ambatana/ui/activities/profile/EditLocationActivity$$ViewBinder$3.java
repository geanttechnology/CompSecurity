// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.profile:
//            EditLocationActivity

class a
    implements android.widget.itLocationActivity..ViewBinder._cls3
{

    final EditLocationActivity a;
    final inish b;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        return a.onTypeAddressFinish(i);
    }

    ( , EditLocationActivity editlocationactivity)
    {
        b = ;
        a = editlocationactivity;
        super();
    }
}
