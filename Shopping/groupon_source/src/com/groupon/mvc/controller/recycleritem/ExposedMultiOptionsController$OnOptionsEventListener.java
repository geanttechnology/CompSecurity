// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.callbacks.DefaultOnExposedOptionsEventListener;
import com.groupon.callbacks.OnExposedOptionsEventListener;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.models.nst.ClickExtraInfo;
import com.groupon.models.nst.MultiOptionClickExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BookingUtil;
import com.groupon.util.LoggingUtils;
import java.util.List;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            ExposedMultiOptionsController

private class <init> extends DefaultOnExposedOptionsEventListener
{

    final ExposedMultiOptionsController this$0;

    public void onAllOptionsButtonClick(View view)
    {
        ClickExtraInfo clickextrainfo = new ClickExtraInfo();
        view = null;
        if (ExposedMultiOptionsController.access$900(ExposedMultiOptionsController.this))
        {
            view = ExposedMultiOptionsController.access$1100(ExposedMultiOptionsController.this).createDateTimeFinderSchedulerIntent(ExposedMultiOptionsController.access$1000(ExposedMultiOptionsController.this), ExposedMultiOptionsController.access$800(ExposedMultiOptionsController.this), ExposedMultiOptionsController.access$700(ExposedMultiOptionsController.this).remoteId, ExposedMultiOptionsController.access$400(ExposedMultiOptionsController.this), ExposedMultiOptionsController.access$200(ExposedMultiOptionsController.this), false, false);
            view.removeExtra("channel");
        }
        clickextrainfo.pageId = ExposedMultiOptionsController.access$300(ExposedMultiOptionsController.this);
        ExposedMultiOptionsController.access$500(ExposedMultiOptionsController.this).logClick("", "view_all_options_click", ExposedMultiOptionsController.access$200(ExposedMultiOptionsController.this).toString(), Logger.NULL_NST_FIELD, clickextrainfo);
        view = ExposedMultiOptionsController.access$1300(ExposedMultiOptionsController.this).newMultiOptionIntent(ExposedMultiOptionsController.access$200(ExposedMultiOptionsController.this), ExposedMultiOptionsController.access$800(ExposedMultiOptionsController.this).remoteId, view).putExtra("multi_option_selection", true).putExtra("defaultOptionId", ExposedMultiOptionsController.access$400(ExposedMultiOptionsController.this)).putExtra("isDeepLinked", ExposedMultiOptionsController.access$1200(ExposedMultiOptionsController.this));
        context.startActivity(view);
    }

    public void onOptionSelectionChange(String s)
    {
        if (ExposedMultiOptionsController.access$100(ExposedMultiOptionsController.this) != null)
        {
            ExposedMultiOptionsController.access$100(ExposedMultiOptionsController.this).onOptionSelectionChange(s);
        }
        ExposedMultiOptionsController.access$500(ExposedMultiOptionsController.this).logClick("", "deal_option_click", ExposedMultiOptionsController.access$200(ExposedMultiOptionsController.this).toString(), Logger.NULL_NST_FIELD, new MultiOptionClickExtraInfo(ExposedMultiOptionsController.access$300(ExposedMultiOptionsController.this), ExposedMultiOptionsController.access$400(ExposedMultiOptionsController.this), s));
        String s1;
        java.util.ArrayList arraylist;
        if (ExposedMultiOptionsController.access$600(ExposedMultiOptionsController.this))
        {
            if (ExposedMultiOptionsController.access$700(ExposedMultiOptionsController.this).specificAttributeDelivery || ExposedMultiOptionsController.access$700(ExposedMultiOptionsController.this).specificAttributeTakeout)
            {
                s1 = "on";
            } else
            {
                s1 = "off";
            }
        } else
        {
            s1 = "";
        }
        arraylist = ExposedMultiOptionsController.access$800(ExposedMultiOptionsController.this).getOptions();
        ExposedMultiOptionsController.access$500(ExposedMultiOptionsController.this).logMultiOption("", ExposedMultiOptionsController.access$800(ExposedMultiOptionsController.this).remoteId, s, arraylist.size(), arraylist.indexOf(ExposedMultiOptionsController.access$700(ExposedMultiOptionsController.this)), loggingUtils.getMultiOptionExtraInfoString(s1, ExposedMultiOptionsController.access$300(ExposedMultiOptionsController.this)));
    }

    private ()
    {
        this$0 = ExposedMultiOptionsController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
