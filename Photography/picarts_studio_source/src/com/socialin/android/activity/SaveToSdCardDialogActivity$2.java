// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.Intent;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.activity:
//            SaveToSdCardDialogActivity, FolderChooserActivity

final class a
    implements android.view.DialogActivity._cls2
{

    private SaveToSdCardDialogActivity a;

    public final void onClick(View view)
    {
        view = new Intent(a.getApplicationContext(), com/socialin/android/activity/FolderChooserActivity);
        view.putExtra("actionName", a.getString(0x7f080606));
        view.putExtra("currentPath", (String)SaveToSdCardDialogActivity.access$000(a).get(0));
        a.startActivityForResult(view, 12);
    }

    (SaveToSdCardDialogActivity savetosdcarddialogactivity)
    {
        a = savetosdcarddialogactivity;
        super();
    }
}
