// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.view.View;
import android.widget.LinearLayout;
import java.util.List;

// Referenced classes of package com.socialin.android.multiselect:
//            FoldersActivity

final class a
    implements android.view.er
{

    private FoldersActivity a;

    public final void onClick(View view)
    {
        FoldersActivity.b(a).clear();
        FoldersActivity.e(a);
        ((LinearLayout)a.findViewById(0x7f100733)).removeAllViews();
        a.findViewById(0x7f100722).setVisibility(8);
    }

    (FoldersActivity foldersactivity)
    {
        a = foldersactivity;
        super();
    }
}
