// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.notifications;

import com.bumptech.glide.b;
import com.bumptech.glide.k;
import com.picsart.studio.d;
import myobfuscated.co.f;

// Referenced classes of package com.socialin.android.photo.notifications:
//            a

final class a
    implements android.support.v7.widget.clerView.RecyclerListener
{

    private a a;

    public final void onViewRecycled(android.support.v7.widget.clerView.ViewHolder viewholder)
    {
        if (viewholder instanceof f)
        {
            viewholder = (f)viewholder;
            if (viewholder != null && ((f) (viewholder)).c != null)
            {
                b.b(com.socialin.android.photo.notifications.a.a(a).a).a(((f) (viewholder)).c);
            }
        }
    }

    lder(a a1)
    {
        a = a1;
        super();
    }
}
