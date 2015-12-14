// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.filters;

import android.view.View;

// Referenced classes of package com.picsart.filters:
//            b, FilterAsyncTask

final class a
    implements android.view..OnClickListener
{

    private b a;

    public final void onClick(View view)
    {
        if (b.c(a))
        {
            return;
        } else
        {
            view = new FilterAsyncTask() {

            };
            android.graphics.Bitmap bitmap = b.d(a);
            String s = b.e(a);
            int i = b.f(a);
            java.util.HashMap hashmap = b.g(a);
            int j = b.h(a);
            android.graphics.Point point = b.i(a);
            FilterUIEnhance filteruienhance = b.j(a);
            view.j = bitmap;
            view.e = s;
            view.f = i;
            view.d = hashmap;
            view.g = j;
            view.l = point;
            view.m = filteruienhance;
            view.b = erAsyncTask.TaskMode.ApplyOrigSizeAndSave;
            view.c = a;
            view.a = a.getActivity();
            view.executeOnExecutor(b.k(a), new Void[] {
                null
            });
            b.a(a, 0x7f080679);
            b.l(a);
            return;
        }
    }

    _cls1(b b1)
    {
        a = b1;
        super();
    }
}
