// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.view.View;
import android.widget.EditText;
import com.socialin.android.util.Utils;
import java.io.File;

// Referenced classes of package com.socialin.android.activity:
//            FolderChooserActivity

final class a
    implements android.view.hooserActivity._cls5
{

    private FolderChooserActivity a;

    public final void onClick(View view)
    {
        view = ((EditText)view.getRootView().findViewById(0x7f1009a7)).getText().toString().trim();
        File file = new File((new StringBuilder()).append(FolderChooserActivity.access$000(a)).append("/").append(view).toString());
        if (!file.exists() && !file.mkdir())
        {
            Utils.a(a, 0x7f0804a0);
            return;
        } else
        {
            FolderChooserActivity.access$400(a, (new StringBuilder()).append(FolderChooserActivity.access$000(a)).append("/").append(view).toString());
            return;
        }
    }

    (FolderChooserActivity folderchooseractivity)
    {
        a = folderchooseractivity;
        super();
    }
}
