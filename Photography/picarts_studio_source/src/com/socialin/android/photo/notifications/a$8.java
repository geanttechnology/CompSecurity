// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.notifications;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import com.picsart.studio.ads.g;
import com.socialin.android.photo.database.b;
import com.socialin.android.util.an;
import java.util.List;
import myobfuscated.co.c;

// Referenced classes of package com.socialin.android.photo.notifications:
//            a

final class a extends an
{

    private a a;

    protected final Object doInBackground(Object aobj[])
    {
        if (com.socialin.android.photo.notifications.a.d(a) != null && !com.socialin.android.photo.notifications.a.d(a).isFinishing() && a.isAdded())
        {
            if ((aobj = com.socialin.android.photo.notifications.a.d(a).getContentResolver().query(b.a, null, null, null, null)) != null)
            {
                List list = com.socialin.android.photo.notifications.a.a(a, ((Cursor) (aobj)));
                ((Cursor) (aobj)).close();
                return list;
            }
        }
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (List)obj;
        if (com.socialin.android.photo.notifications.a.d(a) == null || com.socialin.android.photo.notifications.a.d(a).isFinishing() || !a.isAdded() || com.socialin.android.photo.notifications.a.e(a) == null || obj == null)
        {
            return;
        }
        if (com.socialin.android.photo.notifications.a.f(a) != null)
        {
            com.socialin.android.photo.notifications.a.f(a).setItems(((List) (obj)));
        } else
        {
            com.socialin.android.photo.notifications.a.e(a).setItems(((List) (obj)));
        }
        com.socialin.android.photo.notifications.a.g(a);
        a.c();
        com.socialin.android.photo.notifications.a.h(a);
    }

    protected final void onPreExecute()
    {
        super.onPreExecute();
        com.socialin.android.photo.notifications.a.c(a);
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
