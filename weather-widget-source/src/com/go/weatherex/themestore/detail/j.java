// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.go.weatherex.themestore.detail;

import android.app.Dialog;
import android.view.View;

// Referenced classes of package com.go.weatherex.themestore.detail:
//            f

class j
    implements android.view.View.OnClickListener
{

    final f a;

    j(f f1)
    {
        a = f1;
        super();
    }

    public void onClick(View view)
    {
        f.b(a).dismiss();
    }
}
