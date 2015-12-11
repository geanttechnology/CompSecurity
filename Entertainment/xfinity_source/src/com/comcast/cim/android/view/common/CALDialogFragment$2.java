// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.comcast.cim.utils.AppLauncher;

// Referenced classes of package com.comcast.cim.android.view.common:
//            CALDialogFragment

class val.args
    implements android.view.
{

    final CALDialogFragment this$0;
    final Bundle val$args;

    public void onClick(View view)
    {
        dismiss();
        if (val$args.containsKey("uri"))
        {
            view = (Uri)val$args.getParcelable("uri");
            CALDialogFragment.access$200(CALDialogFragment.this).startUri(view, getActivity());
            return;
        } else
        {
            view = val$args.getString("packageName");
            CALDialogFragment.access$200(CALDialogFragment.this).startApplication(view, getActivity());
            return;
        }
    }

    ()
    {
        this$0 = final_caldialogfragment;
        val$args = Bundle.this;
        super();
    }
}
