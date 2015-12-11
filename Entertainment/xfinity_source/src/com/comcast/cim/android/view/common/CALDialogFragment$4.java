// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

// Referenced classes of package com.comcast.cim.android.view.common:
//            CALDialogFragment

class this._cls0
    implements android.view.
{

    final CALDialogFragment this$0;

    public void onClick(View view)
    {
        dismiss();
        view = new Bundle();
        view.putParcelable("uri", Uri.parse(getResources().getString(com.comcast.cim.android.ID)));
        CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("openAnotherAppDlg");
        caldialogfragment.addArguments(view);
        caldialogfragment.show(getFragmentManager(), "openAnotherAppDlg");
    }

    ()
    {
        this$0 = CALDialogFragment.this;
        super();
    }
}
