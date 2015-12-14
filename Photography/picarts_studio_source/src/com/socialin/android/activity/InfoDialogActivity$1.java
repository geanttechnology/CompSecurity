// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.view.View;

// Referenced classes of package com.socialin.android.activity:
//            InfoDialogActivity

final class a
    implements android.view.DialogActivity._cls1
{

    private InfoDialogActivity a;

    public final void onClick(View view)
    {
        a.finish();
    }

    (InfoDialogActivity infodialogactivity)
    {
        a = infodialogactivity;
        super();
    }
}
