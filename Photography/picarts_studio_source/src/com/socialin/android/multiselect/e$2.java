// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.multiselect:
//            e

final class a
    implements android.view..OnClickListener
{

    private e a;

    public final void onClick(View view)
    {
        e.b(a).clear();
        e.c(a).removeAllViews();
        a.getView().setVisibility(8);
        e.d(a);
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
