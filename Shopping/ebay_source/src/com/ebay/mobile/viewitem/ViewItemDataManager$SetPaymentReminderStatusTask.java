// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.content.Context;
import android.os.AsyncTask;
import android.text.format.DateFormat;
import com.ebay.common.model.ItemTransaction;
import com.ebay.mobile.Item;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.PaymentReminderStorageUtil;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.ArrayList;
import java.util.Date;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

private final class nameValuePair extends AsyncTask
{

    private final ArrayList nameValuePair;
    final ViewItemDataManager this$0;

    protected transient Content doInBackground(Content acontent[])
    {
        Object obj1 = null;
        Object obj2 = null;
        boolean flag1 = false;
        Object obj = obj1;
        Content acontent1[] = obj2;
        boolean flag = flag1;
        if (acontent != null)
        {
            obj = obj1;
            acontent1 = obj2;
            flag = flag1;
            if (acontent[0].getData() != null)
            {
                Content content = acontent[0];
                acontent = (Item)acontent[0].getData();
                com.ebay.nautilus.domain.content.Params params = new com.ebay.nautilus.domain.content.Params();
                params.id = ((Item) (acontent)).id;
                long l;
                boolean flag2;
                if (((Item) (acontent)).iTransaction != null && ((Item) (acontent)).iTransaction.createdDate != null)
                {
                    l = ((Item) (acontent)).iTransaction.createdDate.getTime();
                } else
                {
                    l = 0L;
                }
                params.transactionCreationDate = l;
                params.variationSpecifics = nameValuePair;
                flag2 = PaymentReminderStorageUtil.setStatusToSent(params);
                obj = content;
                acontent1 = acontent;
                flag = flag2;
                if (flag2)
                {
                    l = PaymentReminderStorageUtil.getPaymentReminderSentDate(params);
                    if (l > 0L)
                    {
                        acontent.paymentReminderSentDate = (String)DateFormat.format(Util.getDeliveryDateFormat(getContext(), false), l);
                    }
                    acontent.updatePaymentReminderState(true);
                    flag = flag2;
                    acontent1 = acontent;
                    obj = content;
                }
            }
        }
        if (obj == null || !flag)
        {
            acontent = new ResultStatusOwner();
            obj = new EbayResponseError();
            obj.severity = 1;
            obj.longMessage = getContext().getString(0x7f070143);
            acontent.addResultMessage(new com.ebay.nautilus.kernel.content.Params[] {
                obj
            });
            obj = new Content(acontent1, acontent.getResultStatus());
        }
        return ((Content) (obj));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Content[])aobj);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleSetPaymentReminderStatusResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public rStorageParams(ArrayList arraylist)
    {
        this$0 = ViewItemDataManager.this;
        super();
        nameValuePair = arraylist;
    }
}
