// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.tools;

import android.view.View;

// Referenced classes of package com.socialin.android.photo.tools:
//            ResizeDialogActivity

final class a
    implements android.view.ner
{

    private ResizeDialogActivity a;

    public final void onFocusChange(View view, boolean flag)
    {
        view = a;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ResizeDialogActivity.a(view, flag);
    }

    (ResizeDialogActivity resizedialogactivity)
    {
        a = resizedialogactivity;
        super();
    }
}
