// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.socialin.android.activity:
//            FolderChooserActivity

final class a
    implements android.view.hooserActivity._cls3
{

    private FolderChooserActivity a;

    public final void onClick(View view)
    {
        view = new Intent();
        view.putExtra("path", FolderChooserActivity.access$000(a));
        a.setResult(-1, view);
        a.finish();
    }

    (FolderChooserActivity folderchooseractivity)
    {
        a = folderchooseractivity;
        super();
    }
}
