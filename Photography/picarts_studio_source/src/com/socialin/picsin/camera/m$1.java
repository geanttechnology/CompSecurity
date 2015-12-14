// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

// Referenced classes of package com.socialin.picsin.camera:
//            m

final class a
    implements android.view..OnClickListener
{

    private m a;

    public final void onClick(View view)
    {
        Log.e("ex", "onRadioButtonClickListener");
        if (m.a(a))
        {
            m.b(a).setVisibility(8);
            m.c(a);
            return;
        } else
        {
            a.a();
            return;
        }
    }

    er(m m1)
    {
        a = m1;
        super();
    }
}
