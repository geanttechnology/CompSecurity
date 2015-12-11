// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Loader;

// Referenced classes of package com.wishabi.flipp.app:
//            FlippApplication

final class ax
    implements android.content.Loader.OnLoadCompleteListener
{

    final FlippApplication a;

    ax(FlippApplication flippapplication)
    {
        a = flippapplication;
        super();
    }

    public final void onLoadComplete(Loader loader, Object obj)
    {
        FlippApplication.a(a);
    }
}
