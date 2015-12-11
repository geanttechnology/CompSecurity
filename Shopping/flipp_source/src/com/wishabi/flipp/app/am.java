// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.SparseBooleanArray;
import com.wishabi.flipp.widget.bc;
import com.wishabi.flipp.widget.bw;
import com.wishabi.flipp.widget.cb;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.app:
//            FavoritesFragment

final class am extends bw
{

    final FavoritesFragment a;

    am(FavoritesFragment favoritesfragment, Context context, Cursor cursor, SparseBooleanArray sparsebooleanarray, List list, cb cb, bc bc)
    {
        a = favoritesfragment;
        super(context, cursor, sparsebooleanarray, list, cb, false, null, bc);
    }

    protected final String a(Context context, int i)
    {
label0:
        {
            context = null;
            if (FavoritesFragment.c(a).b && i == 1 || i == 0)
            {
                if (FavoritesFragment.d(a) != 1)
                {
                    break label0;
                }
                context = a.getResources().getString(0x7f0e00f9);
            }
            return context;
        }
        return a.getResources().getString(0x7f0e00fa, new Object[] {
            Integer.valueOf(FavoritesFragment.d(a))
        });
    }
}
