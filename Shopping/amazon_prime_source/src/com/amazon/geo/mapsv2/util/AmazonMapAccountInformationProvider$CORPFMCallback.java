// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;
import com.amazon.identity.auth.device.api.MAPAccountManager;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            AmazonMapAccountInformationProvider, AmazonMapsRuntimeUtilInternal

public class k.CallbackItem.onFinished extends k
{

    public String cor;
    public String pfm;
    final AmazonMapAccountInformationProvider this$0;

    protected void onFinished(Bundle bundle, boolean flag)
    {
        if (cor != null || pfm != null)
        {
            AmazonMapAccountInformationProvider.access$102(AmazonMapAccountInformationProvider.this, true);
        }
        super.onFinished(bundle, flag);
    }

    protected void onFinishedMainThread(Bundle bundle, boolean flag)
    {
        if (cor != null || pfm != null)
        {
            AmazonMapsRuntimeUtilInternal.setAccountInfo(cor, pfm);
        }
        if (flag)
        {
            AmazonMapAccountInformationProvider.access$000(AmazonMapAccountInformationProvider.this).onSuccess(null);
            return;
        } else
        {
            AmazonMapAccountInformationProvider.access$000(AmazonMapAccountInformationProvider.this).onError(null);
            return;
        }
    }

    public k.CallbackItem(MAPAccountManager mapaccountmanager, Context context)
    {
        this.this$0 = AmazonMapAccountInformationProvider.this;
        super(AmazonMapAccountInformationProvider.this);
        context = CustomerAttributeStore.getInstance(context);
        k.CallbackItem callbackitem = new AmazonMapAccountInformationProvider.CompoundCallback.CallbackItem() {

            final AmazonMapAccountInformationProvider.CORPFMCallback this$1;
            final AmazonMapAccountInformationProvider val$this$0;

            protected void onFinished(Bundle bundle, boolean flag)
            {
                cor = bundle.getString("value_key", null);
                super.onFinished(bundle, flag);
            }

            
            {
                this$1 = AmazonMapAccountInformationProvider.CORPFMCallback.this;
                this$0 = amazonmapaccountinformationprovider;
                super(AmazonMapAccountInformationProvider.CORPFMCallback.this);
            }
        };
        this$0 = new AmazonMapAccountInformationProvider.CompoundCallback.CallbackItem() {

            final AmazonMapAccountInformationProvider.CORPFMCallback this$1;
            final AmazonMapAccountInformationProvider val$this$0;

            protected void onFinished(Bundle bundle, boolean flag)
            {
                pfm = bundle.getString("value_key", null);
                super.onFinished(bundle, flag);
            }

            
            {
                this$1 = AmazonMapAccountInformationProvider.CORPFMCallback.this;
                this$0 = amazonmapaccountinformationprovider;
                super(AmazonMapAccountInformationProvider.CORPFMCallback.this);
            }
        };
        context.getAttribute(mapaccountmanager.getAccount(), "COR", callbackitem);
        context.getAttribute(mapaccountmanager.getAccount(), "PFM", AmazonMapAccountInformationProvider.this);
    }
}
