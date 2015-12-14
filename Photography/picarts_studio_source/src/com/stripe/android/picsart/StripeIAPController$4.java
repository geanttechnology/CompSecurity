// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android.picsart;

import com.socialin.android.util.ModernAsyncTask;
import java.util.ArrayList;
import myobfuscated.bp.c;

// Referenced classes of package com.stripe.android.picsart:
//            StripeIAPController

class val.listener extends ModernAsyncTask
{

    final StripeIAPController this$0;
    final c val$listener;
    final int val$page;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient ArrayList doInBackground(Void avoid[])
    {
        avoid = new ArrayList();
        int i;
        int j;
        if (StripeIAPController.access$200(StripeIAPController.this) == null)
        {
            i = 0;
        } else
        {
            i = StripeIAPController.access$200(StripeIAPController.this).size();
        }
        j = Math.min(i, val$page * 20 + 20);
        if (i > val$page * 20)
        {
            for (i = val$page * 20; i < j; i++)
            {
                avoid.add(StripeIAPController.access$200(StripeIAPController.this).get(i));
            }

        }
        return StripeIAPController.access$300(StripeIAPController.this, avoid);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ArrayList)obj);
    }

    protected void onPostExecute(ArrayList arraylist)
    {
        super.onPostExecute(arraylist);
        c c1 = val$listener;
        StripeIAPController.access$200(StripeIAPController.this).size();
        StripeIAPController.access$200(StripeIAPController.this).size();
        c1.a(arraylist);
    }

    ()
    {
        this$0 = final_stripeiapcontroller;
        val$page = i;
        val$listener = c.this;
        super();
    }
}
