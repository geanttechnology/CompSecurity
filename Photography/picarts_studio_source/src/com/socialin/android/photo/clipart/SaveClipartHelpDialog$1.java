// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.content.Intent;
import android.view.View;
import com.socialin.android.util.a;

// Referenced classes of package com.socialin.android.photo.clipart:
//            SaveClipartHelpDialog

final class a
    implements android.view.veClipartHelpDialog._cls1
{

    private SaveClipartHelpDialog a;

    public final void onClick(View view)
    {
        if (a.getIntent().getStringExtra("from").equals("freeCrop"))
        {
            com.socialin.android.photo.clipart.SaveClipartHelpDialog.a(a).a("save-clipart-help-opened-freeCrop", true);
        }
        if (a.getIntent().getStringExtra("from").equals("collageCrop"))
        {
            com.socialin.android.photo.clipart.SaveClipartHelpDialog.a(a).a("save-clipart-help-opened-collageCrop", true);
        }
        if (a.getIntent().getStringExtra("from").equals("selectionMainFragment"))
        {
            com.socialin.android.photo.clipart.SaveClipartHelpDialog.a(a).a("save-clipart-help-opened-selectionMainFragment", true);
        }
        a.finish();
    }

    (SaveClipartHelpDialog savecliparthelpdialog)
    {
        a = savecliparthelpdialog;
        super();
    }
}
