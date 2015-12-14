// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android.picsart;

import com.socialin.android.apiv3.model.ShopItemsListResponse;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.util.ArrayList;
import myobfuscated.bp.c;

// Referenced classes of package com.stripe.android.picsart:
//            StripeIAPController

class this._cls1 extends ModernAsyncTask
{

    final is._cls0 this$1;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient ArrayList doInBackground(Void avoid[])
    {
        avoid = new ArrayList();
        int i;
        int j;
        if (StripeIAPController.access$200(_fld0) == null)
        {
            i = 0;
        } else
        {
            i = StripeIAPController.access$200(_fld0).size();
        }
        j = Math.min(i, page * 20 + 20);
        if (i > page * 20)
        {
            for (i = page * 20; i < j; i++)
            {
                avoid.add(StripeIAPController.access$200(_fld0).get(i));
            }

        }
        return StripeIAPController.access$300(_fld0, avoid);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ArrayList)obj);
    }

    protected void onPostExecute(ArrayList arraylist)
    {
        super.onPostExecute(arraylist);
        c c1 = listener;
        StripeIAPController.access$200(_fld0).size();
        StripeIAPController.access$200(_fld0).size();
        c1.a(arraylist);
    }

    l.listener()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/stripe/android/picsart/StripeIAPController$3

/* anonymous class */
    class StripeIAPController._cls3
        implements d
    {

        final StripeIAPController this$0;
        final c val$listener;
        final int val$page;

        public void onCancelRequest(ShopItemsListResponse shopitemslistresponse, Request request)
        {
        }

        public volatile void onCancelRequest(Object obj, Request request)
        {
            onCancelRequest((ShopItemsListResponse)obj, request);
        }

        public void onFailure(Exception exception, Request request)
        {
        }

        public transient void onProgressUpdate(Integer ainteger[])
        {
        }

        public void onSuccess(ShopItemsListResponse shopitemslistresponse, Request request)
        {
            StripeIAPController.access$202(StripeIAPController.this, shopitemslistresponse.response);
            (new StripeIAPController._cls3._cls1()).execute(new Void[0]);
        }

        public volatile void onSuccess(Object obj, Request request)
        {
            onSuccess((ShopItemsListResponse)obj, request);
        }

            
            {
                this$0 = final_stripeiapcontroller;
                page = i;
                listener = c.this;
                super();
            }
    }

}
