// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.os.AsyncTask;
import com.picsart.effectnew.EffectsDrawController;
import com.picsart.effectnew.e;
import com.socialin.android.util.c;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            s

final class a extends AsyncTask
{

    private s a;

    protected final volatile Object doInBackground(Object aobj[])
    {
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        if (s.o(a) != null)
        {
            c.a(s.j(a));
        }
        c.a(s.p(a));
        obj = s.q(a);
        if (((e) (obj)).c != null)
        {
            ((e) (obj)).c.k();
        }
        s.r(a);
    }

    ler(s s1)
    {
        a = s1;
        super();
    }
}
