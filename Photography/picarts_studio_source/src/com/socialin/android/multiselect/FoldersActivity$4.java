// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.socialin.android.multiselect:
//            FoldersActivity

final class a
    implements android.view.er
{

    private FoldersActivity a;

    public final void onClick(View view)
    {
        int j = FoldersActivity.b(a).size();
        view = new ArrayList();
        for (int i = 0; i < j; i++)
        {
            if (FoldersActivity.b(a).get(i) != null)
            {
                view.add(FoldersActivity.b(a).get(i));
            }
        }

        String as[] = new String[view.size()];
        view.toArray(as);
        FoldersActivity.a(a, j, as);
    }

    (FoldersActivity foldersactivity)
    {
        a = foldersactivity;
        super();
    }
}
