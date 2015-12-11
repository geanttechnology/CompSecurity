// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import android.os.AsyncTask;
import com.smule.android.c.aa;
import com.smule.android.network.managers.PurchasesManager;
import com.smule.android.network.managers.i;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            o

public class n extends AsyncTask
{

    private static final String b = com/smule/pianoandroid/magicpiano/b/n.getName();
    public o a;
    private String c;

    public n(String s, o o1)
    {
        a = o1;
        c = s;
    }

    protected transient Boolean a(Void avoid[])
    {
        return Boolean.valueOf(PurchasesManager.a().b(c));
    }

    protected void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            i.a().d(c);
        } else
        {
            aa.b(b, (new StringBuilder()).append("failed to claim reward: ").append(c).toString());
        }
        if (a != null)
        {
            a.a(boolean1.booleanValue());
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

}
