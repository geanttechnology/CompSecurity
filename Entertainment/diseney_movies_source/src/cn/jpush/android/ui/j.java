// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.view.View;
import cn.jpush.android.api.m;
import cn.jpush.android.service.ServiceInterface;

// Referenced classes of package cn.jpush.android.ui:
//            PushActivity

final class j
    implements android.view.View.OnClickListener
{

    final PushActivity a;

    j(PushActivity pushactivity)
    {
        a = pushactivity;
        super();
    }

    public final void onClick(View view)
    {
        ServiceInterface.a(PushActivity.a(a), 1006, a);
        m.a(a, PushActivity.b(a), 0);
        a.finish();
    }
}
