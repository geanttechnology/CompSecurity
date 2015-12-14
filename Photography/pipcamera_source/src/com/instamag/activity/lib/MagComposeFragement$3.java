// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.instamag.activity.view.TDecorateInfosLayerView;

// Referenced classes of package com.instamag.activity.lib:
//            MagComposeFragement, MagComposeActivity

class a
    implements android.view.eFragement._cls3
{

    final MagComposeFragement a;

    public void onClick(View view)
    {
        MagComposeFragement.c(a).setCurSelectedDecorateText(MagComposeFragement.b(a).getText().toString());
        if (MagComposeFragement.b(a).getTag() != null && (MagComposeFragement.b(a).getTag() instanceof Integer) && (((Integer)MagComposeFragement.b(a).getTag()).intValue() == 5 || ((Integer)MagComposeFragement.b(a).getTag()).intValue() == 10 || ((Integer)MagComposeFragement.b(a).getTag()).intValue() == 9))
        {
            MagComposeFragement.a(a, MagComposeFragement.b(a).getText().toString(), ((Integer)MagComposeFragement.b(a).getTag()).intValue());
        }
        if (a.a != null)
        {
            a.a.a(true);
        }
        a.b(MagComposeFragement.b(a));
        MagComposeFragement.b(a).clearFocus();
        MagComposeFragement.d(a).setVisibility(4);
    }

    ew(MagComposeFragement magcomposefragement)
    {
        a = magcomposefragement;
        super();
    }
}
