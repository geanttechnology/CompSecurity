// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.smule.android.c.aa;
import com.smule.android.f.p;
import com.smule.android.network.core.v;
import com.smule.android.network.managers.PurchasesManager;
import com.smule.android.network.managers.i;
import com.smule.android.network.models.ListingV2;
import com.smule.pianoandroid.magicpiano.a.e;
import java.io.IOException;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            b

public class a extends AsyncTask
{

    private static final String b = com/smule/pianoandroid/magicpiano/b/a.getName();
    public b a;
    private ListingV2 c;

    public a(ListingV2 listingv2, b b1)
    {
        c = listingv2;
        a = b1;
    }

    public static boolean a(Activity activity)
    {
        int j = 1;
        boolean flag = false;
        activity = activity.getSharedPreferences("startup_prefs", 0);
        android.content.SharedPreferences.Editor editor = activity.edit();
        int k = activity.getInt("unlock_counter", 0);
        if (k >= 3 || k == 0)
        {
            flag = true;
        } else
        {
            j = k + 1;
        }
        editor.putInt("unlock_counter", j);
        p.a(editor);
        return flag;
    }

    protected transient Integer a(Void avoid[])
    {
        int j = PurchasesManager.a().a(c);
        return Integer.valueOf(j);
        avoid;
        String s = b;
        if (avoid.getMessage() != null)
        {
            avoid = avoid.getMessage();
        } else
        {
            avoid = avoid.toString();
        }
        aa.b(s, avoid);
_L2:
        return Integer.valueOf(-1);
        avoid;
        String s1 = b;
        if (avoid.getMessage() != null)
        {
            avoid = avoid.getMessage();
        } else
        {
            avoid = avoid.toString();
        }
        aa.b(s1, avoid);
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void a(Integer integer)
    {
        boolean flag1;
        flag1 = true;
        aa.c(b, "OnPostExecute");
        if (integer == null) goto _L2; else goto _L1
_L1:
        integer.intValue();
        JVM INSTR tableswitch 0 4: default 52
    //                   0 82
    //                   1 52
    //                   2 119
    //                   3 52
    //                   4 114;
           goto _L2 _L3 _L2 _L4 _L2 _L5
_L4:
        break MISSING_BLOCK_LABEL_119;
_L2:
        boolean flag = false;
_L6:
        if (a != null)
        {
            if (integer == null)
            {
                flag1 = false;
            }
            a.a(flag1, flag, integer, c);
        }
        return;
_L3:
        i.a().d(c.productId);
        if (c.price > 0)
        {
            e.a("purchased_song", c);
        }
_L5:
        flag = true;
          goto _L6
        aa.b(b, "Insufficient funds response, unexpected");
        flag = false;
          goto _L6
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Integer)obj);
    }

}
