// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            ContactActivity

class a extends DebouncingOnClickListener
{

    final ContactActivity a;
    final ap b;

    public void doClick(View view)
    {
        a.onSendContactTap();
    }

    ( , ContactActivity contactactivity)
    {
        b = ;
        a = contactactivity;
        super();
    }
}
