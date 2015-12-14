// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

// Referenced classes of package com.socialin.android.multiselect:
//            FoldersActivity

final class a
    implements android.view.er
{

    private String a;
    private FoldersActivity b;

    public final void onClick(View view)
    {
        FoldersActivity.g(b).removeView(view);
        FoldersActivity.b(b).remove(a);
        if (FoldersActivity.b(b).isEmpty())
        {
            b.findViewById(0x7f100722).setVisibility(8);
        }
        ((TextView)b.findViewById(0x7f10072e)).setText((new StringBuilder()).append(FoldersActivity.b(b).size()).toString());
    }

    (FoldersActivity foldersactivity, String s)
    {
        b = foldersactivity;
        a = s;
        super();
    }
}
