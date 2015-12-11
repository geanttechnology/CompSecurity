// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.ftue;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.logging.Logger;
import com.amazon.mas.client.authentication.MASClientCustomerAttributeStore;
import com.amazon.venezia.concurrent.AsyncTasks;
import com.amazon.venezia.web.Marketplace;
import com.amazon.venezia.web.PageUrlFactory;

// Referenced classes of package com.amazon.client.ftue:
//            InferCorPfmFragment

class masClientCustomerAttributeStore extends AsyncTask
{

    private final MASClientCustomerAttributeStore masClientCustomerAttributeStore;
    final InferCorPfmFragment this$0;
    private String url;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        String s1;
        if (accountManager == null || accountManager.getAccount() == null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        s1 = accountManager.getAccount();
        avoid = masClientCustomerAttributeStore.getAttribute("PFM", s1, false);
        String s = masClientCustomerAttributeStore.getAttribute("COR", s1, false);
        s1 = masClientCustomerAttributeStore.getAttribute("com.amazon.dcp.sso.token.device.accountpool", s1);
        InferCorPfmFragment.access$002(InferCorPfmFragment.this, Marketplace.fromEMID(avoid));
        InferCorPfmFragment.access$102(InferCorPfmFragment.this, InferCorPfmFragment.access$000(InferCorPfmFragment.this).getStack());
        url = pageUrlFactory.getPfmCorUrl(InferCorPfmFragment.access$100(InferCorPfmFragment.this));
        if (!TextUtils.isEmpty(s1))
        {
            url = (new StringBuilder()).append(url).append("&").append("accountPool").append("=").append(s1).toString();
        }
        avoid = InferCorPfmFragment.access$200(InferCorPfmFragment.this, avoid, s);
        return avoid;
        avoid;
        InferCorPfmFragment.access$300().e("Failed to obtain pfm and cor", avoid);
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        if (s != null)
        {
            InferCorPfmFragment.access$400(InferCorPfmFragment.this, url, s);
            InferCorPfmFragment.access$502(InferCorPfmFragment.this, new this._cls0(InferCorPfmFragment.this, url));
            AsyncTasks.executeInParallel(InferCorPfmFragment.access$500(InferCorPfmFragment.this), new Void[0]);
            return;
        } else
        {
            InferCorPfmFragment.access$600(InferCorPfmFragment.this);
            return;
        }
    }

    public (MASClientCustomerAttributeStore masclientcustomerattributestore)
    {
        this$0 = InferCorPfmFragment.this;
        super();
        masClientCustomerAttributeStore = masclientcustomerattributestore;
    }
}
