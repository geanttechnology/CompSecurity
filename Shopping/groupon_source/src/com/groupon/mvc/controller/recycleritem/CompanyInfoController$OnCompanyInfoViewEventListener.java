// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.groupon.activity.IntentFactory;
import com.groupon.callbacks.OnCompanyInfoEventListener;
import com.groupon.mvc.model.CompanyInfo;
import java.util.ArrayList;
import java.util.List;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            CompanyInfoController

private class <init>
    implements OnCompanyInfoEventListener
{

    final CompanyInfoController this$0;

    public void onAddressClick(View view, String s)
    {
        view = String.format("https://maps.google.com/maps?f=d&daddr=%s", new Object[] {
            Uri.encode(s)
        });
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(view)));
    }

    public void onMapViewClick(View view, double d, double d1, String s)
    {
        view = new ArrayList();
        view.add(CompanyInfoController.access$100(CompanyInfoController.this));
        context.startActivity(CompanyInfoController.access$200(CompanyInfoController.this).newShowOnMapIntent(view, s, 0));
    }

    public void onMultipleLocationsClick(View view)
    {
        context.startActivity(CompanyInfoController.access$200(CompanyInfoController.this).newShowOnMapIntent(CompanyInfoController.access$300(CompanyInfoController.this), ((CompanyInfo)model).vendorName, CompanyInfoController.access$400(CompanyInfoController.this)));
    }

    public void onPhoneClick(View view, String s)
    {
        try
        {
            view = new Intent("android.intent.action.DIAL", Uri.parse(String.format("tel:%s", new Object[] {
                s
            })));
            context.startActivity(Intent.createChooser(view, context.getString(0x7f080083)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Ln.d(view, "Formatting phone number failed", new Object[0]);
        }
    }

    public void onWebsiteClick(View view)
    {
        try
        {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((CompanyInfo)model).website)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    private ()
    {
        this$0 = CompanyInfoController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
