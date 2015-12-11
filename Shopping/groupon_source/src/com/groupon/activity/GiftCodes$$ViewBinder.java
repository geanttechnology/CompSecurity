// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.groupon.view.DealCardCompact;
import com.groupon.view.GrouponCheckMark;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.activity:
//            GiftCodes, GrouponActivity

public class inder extends inder
{

    public void bind(butterknife.ewBinder ewbinder, GiftCodes giftcodes, Object obj)
    {
        super.bind(ewbinder, giftcodes, obj);
        giftcodes.codeContainer = (View)ewbinder.dOptionalView(obj, 0x7f1002e1, null);
        giftcodes.code = (EditText)ewbinder.tView((View)ewbinder.dRequiredView(obj, 0x7f1002d8, "field 'code'"), 0x7f1002d8, "field 'code'");
        giftcodes.giftCardNumber = (EditText)ewbinder.tView((View)ewbinder.dOptionalView(obj, 0x7f1002e0, null), 0x7f1002e0, "field 'giftCardNumber'");
        giftcodes.pin = (EditText)ewbinder.tView((View)ewbinder.dRequiredView(obj, 0x7f1002da, "field 'pin'"), 0x7f1002da, "field 'pin'");
        giftcodes.pinContainer = (View)ewbinder.dRequiredView(obj, 0x7f1002d9, "field 'pinContainer'");
        giftcodes.giftCardContainer = (View)ewbinder.dOptionalView(obj, 0x7f1002de, null);
        giftcodes.submitButton = (SpinnerButton)ewbinder.tView((View)ewbinder.dRequiredView(obj, 0x7f100102, "field 'submitButton'"), 0x7f100102, "field 'submitButton'");
        giftcodes.cancelButton = (Button)ewbinder.tView((View)ewbinder.dOptionalView(obj, 0x7f1002db, null), 0x7f1002db, "field 'cancelButton'");
        giftcodes.giftCardCheckMarkContainer = (View)ewbinder.dOptionalView(obj, 0x7f1002dc, null);
        giftcodes.giftCardCheckMark = (GrouponCheckMark)ewbinder.tView((View)ewbinder.dOptionalView(obj, 0x7f1002dd, null), 0x7f1002dd, "field 'giftCardCheckMark'");
        giftcodes.dealCardCompact = (DealCardCompact)ewbinder.tView((View)ewbinder.dOptionalView(obj, 0x7f1000d2, null), 0x7f1000d2, "field 'dealCardCompact'");
        giftcodes.secureConnectionView = (TextView)ewbinder.tView((View)ewbinder.dOptionalView(obj, 0x7f100111, null), 0x7f100111, "field 'secureConnectionView'");
        ewbinder = ewbinder.Context(obj).getResources();
        giftcodes.errorInvalidCode = ewbinder.getString(0x7f0801ee);
        giftcodes.errorInvalidCodeGeneric = ewbinder.getString(0x7f0801ef);
        giftcodes.giftCardNumberInvalid = ewbinder.getString(0x7f0801eb);
        giftcodes.errorInvalidPin = ewbinder.getString(0x7f0801f0);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (GiftCodes)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (GiftCodes)obj, obj1);
    }

    public void unbind(GiftCodes giftcodes)
    {
        super.unbind(giftcodes);
        giftcodes.codeContainer = null;
        giftcodes.code = null;
        giftcodes.giftCardNumber = null;
        giftcodes.pin = null;
        giftcodes.pinContainer = null;
        giftcodes.giftCardContainer = null;
        giftcodes.submitButton = null;
        giftcodes.cancelButton = null;
        giftcodes.giftCardCheckMarkContainer = null;
        giftcodes.giftCardCheckMark = null;
        giftcodes.dealCardCompact = null;
        giftcodes.secureConnectionView = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((GiftCodes)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((GiftCodes)obj);
    }

    public inder()
    {
    }
}
