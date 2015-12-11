// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            Redeem, GrouponActivity

public class ewBinder extends ewBinder
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (Redeem)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, Redeem redeem, Object obj)
    {
        super.bind(ewbinder, redeem, obj);
        redeem.barcodeImageView = (ImageView)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f100076, "field 'barcodeImageView'"), 0x7f100076, "field 'barcodeImageView'");
        redeem.progressView = (View)ewbinder.findRequiredView(obj, 0x7f10010b, "field 'progressView'");
        redeem.barcodeView = (View)ewbinder.findRequiredView(obj, 0x7f1004ed, "field 'barcodeView'");
        redeem.titleView = (TextView)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f10007a, "field 'titleView'"), 0x7f10007a, "field 'titleView'");
        redeem.subTitleView = (TextView)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f10011a, "field 'subTitleView'"), 0x7f10011a, "field 'subTitleView'");
        redeem.grouponNumberView = (TextView)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f1000b9, "field 'grouponNumberView'"), 0x7f1000b9, "field 'grouponNumberView'");
        redeem.barcodeNumberView = (TextView)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f1004ee, "field 'barcodeNumberView'"), 0x7f1004ee, "field 'barcodeNumberView'");
        redeem.markUsedButton = (Button)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f100102, "field 'markUsedButton'"), 0x7f100102, "field 'markUsedButton'");
        redeem.usernameView = (TextView)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f1004ef, "field 'usernameView'"), 0x7f1004ef, "field 'usernameView'");
        redeem.showThisScreenView = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f1004f1, null), 0x7f1004f1, "field 'showThisScreenView'");
        redeem.redeemedView = (View)ewbinder.findOptionalView(obj, 0x7f10057e, null);
        redeem.redeemedTimeView = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f100580, null), 0x7f100580, "field 'redeemedTimeView'");
        redeem.voucherRedeemedText = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f10057f, null), 0x7f10057f, "field 'voucherRedeemedText'");
        redeem.expirationView = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f1004ec, null), 0x7f1004ec, "field 'expirationView'");
        redeem.bottomBar = (LinearLayout)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f1000a0, null), 0x7f1000a0, "field 'bottomBar'");
        redeem.refNumberContainer = (View)ewbinder.findOptionalView(obj, 0x7f1004f5, null);
        redeem.refNumberView = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f1004f7, null), 0x7f1004f7, "field 'refNumberView'");
        redeem.verificationCodeContainer = (View)ewbinder.findOptionalView(obj, 0x7f1004f3, null);
        redeem.verificationCodeView = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f1004f4, null), 0x7f1004f4, "field 'verificationCodeView'");
        redeem.bookNowView = (Button)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f100104, null), 0x7f100104, "field 'bookNowView'");
        redeem.maintenanceLabel = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f1004f8, null), 0x7f1004f8, "field 'maintenanceLabel'");
        redeem.redeemInstructionsContainer = (LinearLayout)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f100152, null), 0x7f100152, "field 'redeemInstructionsContainer'");
        redeem.redeemInstructions = (WebView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f100153, null), 0x7f100153, "field 'redeemInstructions'");
        redeem.refLabel = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f1004f6, null), 0x7f1004f6, "field 'refLabel'");
        redeem.event = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f1004fd, null), 0x7f1004fd, "field 'event'");
        redeem.account = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f1004fb, null), 0x7f1004fb, "field 'account'");
        redeem.moreInfo = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f1004ff, null), 0x7f1004ff, "field 'moreInfo'");
        redeem.section = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f100501, null), 0x7f100501, "field 'section'");
        redeem.row = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f100503, null), 0x7f100503, "field 'row'");
        redeem.seat = (TextView)ewbinder.castView((View)ewbinder.findOptionalView(obj, 0x7f100505, null), 0x7f100505, "field 'seat'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (Redeem)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((Redeem)grouponactivity);
    }

    public void unbind(Redeem redeem)
    {
        super.unbind(redeem);
        redeem.barcodeImageView = null;
        redeem.progressView = null;
        redeem.barcodeView = null;
        redeem.titleView = null;
        redeem.subTitleView = null;
        redeem.grouponNumberView = null;
        redeem.barcodeNumberView = null;
        redeem.markUsedButton = null;
        redeem.usernameView = null;
        redeem.showThisScreenView = null;
        redeem.redeemedView = null;
        redeem.redeemedTimeView = null;
        redeem.voucherRedeemedText = null;
        redeem.expirationView = null;
        redeem.bottomBar = null;
        redeem.refNumberContainer = null;
        redeem.refNumberView = null;
        redeem.verificationCodeContainer = null;
        redeem.verificationCodeView = null;
        redeem.bookNowView = null;
        redeem.maintenanceLabel = null;
        redeem.redeemInstructionsContainer = null;
        redeem.redeemInstructions = null;
        redeem.refLabel = null;
        redeem.event = null;
        redeem.account = null;
        redeem.moreInfo = null;
        redeem.section = null;
        redeem.row = null;
        redeem.seat = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((Redeem)obj);
    }

    public ewBinder()
    {
    }
}
