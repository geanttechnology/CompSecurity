// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.groupon.db.models.Special;
import com.groupon.models.nst.MerchantPageMerchantIdMetadata;
import com.groupon.util.LoggingUtils;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            BusinessSpecialPage

class this._cls0
    implements android.view.lPage._cls8
{

    final BusinessSpecialPage this$0;

    public void onClick(View view)
    {
        Object obj;
        String s;
        String s1;
        String s2;
        if (Strings.notEmpty(BusinessSpecialPage.access$000(BusinessSpecialPage.this).name))
        {
            view = BusinessSpecialPage.access$000(BusinessSpecialPage.this).name;
        } else
        {
            view = "";
        }
        if (Strings.notEmpty(BusinessSpecialPage.access$000(BusinessSpecialPage.this).getDerivedBusinessName()))
        {
            obj = BusinessSpecialPage.access$000(BusinessSpecialPage.this).getDerivedBusinessName();
        } else
        {
            obj = "";
        }
        if (Strings.notEmpty(BusinessSpecialPage.access$000(BusinessSpecialPage.this).shortRecurringText))
        {
            s = BusinessSpecialPage.access$000(BusinessSpecialPage.this).shortRecurringText;
        } else
        {
            s = "";
        }
        if (Strings.notEmpty(BusinessSpecialPage.access$000(BusinessSpecialPage.this).derivedBusinessUrl))
        {
            s1 = BusinessSpecialPage.access$000(BusinessSpecialPage.this).derivedBusinessUrl;
        } else
        {
            s1 = "";
        }
        s2 = String.format(getApplicationContext().getString(0x7f0803be), new Object[] {
            view, obj
        });
        view = String.format(getApplicationContext().getString(0x7f080461), new Object[] {
            obj, view, obj, s, s1
        });
        obj = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "", null));
        ((Intent) (obj)).putExtra("android.intent.extra.SUBJECT", s2);
        ((Intent) (obj)).putExtra("android.intent.extra.TEXT", view);
        BusinessSpecialPage.access$400(BusinessSpecialPage.this).logClick("", "email_special_click", BusinessSpecialPage.access$000(BusinessSpecialPage.this).remoteId, BusinessSpecialPage.access$400(BusinessSpecialPage.this).encodeAsJson(new MerchantPageMerchantIdMetadata(businessId)));
        startActivity(Intent.createChooser(((Intent) (obj)), "Email Special"));
    }

    IdMetadata()
    {
        this$0 = BusinessSpecialPage.this;
        super();
    }
}
