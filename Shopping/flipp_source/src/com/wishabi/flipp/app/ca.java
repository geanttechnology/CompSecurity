// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.net.Uri;
import android.view.View;
import com.wishabi.flipp.content.FlyerInfo;
import java.util.Locale;

// Referenced classes of package com.wishabi.flipp.app:
//            bx, fu, fx

final class ca
    implements android.view.View.OnClickListener
{

    final bx a;

    ca(bx bx1)
    {
        a = bx1;
        super();
    }

    public final void onClick(View view)
    {
        view = Uri.parse(bx.e(a).c).buildUpon();
        view.appendQueryParameter("locale", Locale.getDefault().toString());
        view = view.build().toString();
        a.a(com/wishabi/flipp/app/fu, fu.b().a(view).a().b().a);
    }
}
