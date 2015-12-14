// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.view.View;
import com.cyberlink.youcammakeup.utility.bd;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            h

class a
    implements android.view..OnClickListener
{

    final h a;

    public void onClick(View view)
    {
        a.b = true;
        a.dismiss();
        bd.a(a.getActivity(), "com.cyberlink.youperfect", "ymk", "downloadycpdialog");
    }

    (h h1)
    {
        a = h1;
        super();
    }
}
