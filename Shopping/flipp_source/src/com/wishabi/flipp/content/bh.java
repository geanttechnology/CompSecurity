// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;

// Referenced classes of package com.wishabi.flipp.content:
//            UserContentProvider, i

final class bh extends ContentObserver
{

    final UserContentProvider a;

    bh(UserContentProvider usercontentprovider, Handler handler)
    {
        a = usercontentprovider;
        super(handler);
    }

    public final void onChange(boolean flag)
    {
        a.getContext().getContentResolver().notifyChange(i.r, null);
    }
}
