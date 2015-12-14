// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.app.Activity;
import android.widget.Toast;
import com.socialin.android.dialog.g;

// Referenced classes of package com.picsart.collages:
//            f, e, CollageCreatorView

final class a
    implements f
{

    private e a;

    public final void a(String s)
    {
        Toast.makeText(a.getActivity().getApplicationContext(), (new StringBuilder()).append(a.getString(0x7f080572)).append(" ").append(s).toString(), 0).show();
        e.b(a).setChanged(false);
        e.l(a).dismiss();
    }

    g.g(e e1)
    {
        a = e1;
        super();
    }
}
