// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.weibo.other.facebook;

import android.view.View;
import zd;

// Referenced classes of package com.wantu.weibo.other.facebook:
//            FbDialog

class a
    implements android.view.kListener
{

    final FbDialog a;

    public void onClick(View view)
    {
        FbDialog.a(a).a();
        a.dismiss();
    }

    (FbDialog fbdialog)
    {
        a = fbdialog;
        super();
    }
}
