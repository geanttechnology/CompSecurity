// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.notifications;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.bumptech.glide.b;
import com.bumptech.glide.k;
import com.picsart.studio.d;

// Referenced classes of package com.socialin.android.photo.notifications:
//            a

final class stener extends android.support.v7.widget.clerView.OnScrollListener
{

    private a a;

    public final void onScrollStateChanged(RecyclerView recyclerview, int i)
    {
        super.onScrollStateChanged(recyclerview, i);
        switch (i)
        {
        default:
            b.b(com.socialin.android.photo.notifications.a.a(a).a).a();
            return;

        case 0: // '\0'
            com.socialin.android.photo.notifications.a.a(a, com.socialin.android.photo.notifications.a.b(a).findFirstCompletelyVisibleItemPosition(), com.socialin.android.photo.notifications.a.b(a).findLastCompletelyVisibleItemPosition());
            break;
        }
        b.b(com.socialin.android.photo.notifications.a.a(a).a).c();
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
