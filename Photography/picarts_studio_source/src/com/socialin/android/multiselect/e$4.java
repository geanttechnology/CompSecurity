// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.os.AsyncTask;
import com.socialin.android.dialog.g;
import com.socialin.android.net.b;
import com.socialin.android.net.e;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.multiselect:
//            e

final class c extends AsyncTask
{

    private ArrayList a;
    private e b;
    private b c;
    private com.socialin.android.multiselect.e d;

    protected final Object doInBackground(Object aobj[])
    {
        int j = a.size();
        for (int i = 0; i < j; i++)
        {
            aobj = (String)a.remove(i);
            a.add(i, e.a(((String) (aobj))));
        }

        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        if (com.socialin.android.multiselect.e.e(d) != null && com.socialin.android.multiselect.e.e(d).isShowing())
        {
            com.socialin.android.multiselect.e.e(d).dismiss();
        }
        b.a(a, e.f(d), c);
    }

    protected final void onPreExecute()
    {
        super.onPreExecute();
        if (com.socialin.android.multiselect.e.e(d) != null && !com.socialin.android.multiselect.e.e(d).isShowing())
        {
            com.socialin.android.multiselect.e.e(d).show();
        }
    }

    (com.socialin.android.multiselect.e e1, ArrayList arraylist, e e2, b b1)
    {
        d = e1;
        a = arraylist;
        b = e2;
        c = b1;
        super();
    }
}
