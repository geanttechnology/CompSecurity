// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.socialin.android.activity:
//            WhatsNewActivity

final class a
    implements android.view.hatsNewAdapter._cls1
{

    private com.socialin.android.apiv3.model._cls0 a;
    private is._cls0 b;

    public final void onClick(View view)
    {
        view = new Intent("android.intent.action.VIEW", Uri.parse(a.l()));
        b._fld0.startActivity(view);
    }

    ( , com.socialin.android.apiv3.model.I i)
    {
        b = ;
        a = i;
        super();
    }
}
