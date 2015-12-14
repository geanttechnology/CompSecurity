// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.upload;

import android.content.res.Resources;
import android.view.View;
import com.firegnom.rat.util.DialogUtils;

// Referenced classes of package com.socialin.android.picsart.upload:
//            PicsartUploadEditActivity

final class a
    implements android.view.rtUploadEditActivity._cls1
{

    private PicsartUploadEditActivity a;

    public final void onClick(View view)
    {
        DialogUtils.openInfoDialog(0x7f020392, a.getResources().getString(0x7f080417), "", a.getResources().getString(0x7f080418), PicsartUploadEditActivity.a(a), Integer.valueOf(0));
    }

    (PicsartUploadEditActivity picsartuploadeditactivity)
    {
        a = picsartuploadeditactivity;
        super();
    }
}
