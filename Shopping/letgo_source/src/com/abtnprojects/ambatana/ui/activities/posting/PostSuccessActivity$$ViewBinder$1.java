// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.posting;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.posting:
//            PostSuccessActivity

class a extends DebouncingOnClickListener
{

    final PostSuccessActivity a;
    final a b;

    public void doClick(View view)
    {
        a.closeScreen();
    }

    ( , PostSuccessActivity postsuccessactivity)
    {
        b = ;
        a = postsuccessactivity;
        super();
    }
}
