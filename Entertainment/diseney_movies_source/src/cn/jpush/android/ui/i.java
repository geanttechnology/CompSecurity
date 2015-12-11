// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.view.View;
import cn.jpush.android.util.x;

// Referenced classes of package cn.jpush.android.ui:
//            PushActivity

final class i
    implements android.view.View.OnClickListener
{

    final PushActivity a;

    i(PushActivity pushactivity)
    {
        a = pushactivity;
        super();
    }

    public final void onClick(View view)
    {
        x.c();
        a.finish();
    }
}
