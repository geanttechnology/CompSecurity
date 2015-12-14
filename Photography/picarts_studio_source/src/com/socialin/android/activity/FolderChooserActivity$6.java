// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.view.View;

// Referenced classes of package com.socialin.android.activity:
//            FolderChooserActivity

final class a
    implements android.view.hooserActivity._cls6
{

    private int a;
    private FolderChooserActivity b;

    public final void onClick(View view)
    {
        String as[] = FolderChooserActivity.access$000(b).split("/");
        view = "";
        for (int i = 0; i <= a + 1; i++)
        {
            view = (new StringBuilder()).append(view).append(as[i]).append("/").toString();
        }

        FolderChooserActivity.access$400(b, view);
    }

    (FolderChooserActivity folderchooseractivity, int i)
    {
        b = folderchooseractivity;
        a = i;
        super();
    }
}
