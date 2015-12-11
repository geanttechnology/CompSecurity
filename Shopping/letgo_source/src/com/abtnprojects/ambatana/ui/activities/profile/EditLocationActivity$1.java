// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.profile:
//            EditLocationActivity

class a
    implements android.widget.Listener
{

    final EditLocationActivity a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        a.d(i);
    }

    (EditLocationActivity editlocationactivity)
    {
        a = editlocationactivity;
        super();
    }
}
