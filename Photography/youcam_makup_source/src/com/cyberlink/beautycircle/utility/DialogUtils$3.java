// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Dialog;
import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.g;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            DialogUtils

final class a
    implements android.view.stener
{

    final Dialog a;

    public void onClick(View view)
    {
        a.dismiss();
        g.a(Globals.d, Globals.n().getPackageName(), "BeautyCircle", "download");
    }

    (Dialog dialog)
    {
        a = dialog;
        super();
    }
}
