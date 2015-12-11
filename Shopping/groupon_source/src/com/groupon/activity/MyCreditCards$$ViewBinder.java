// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.groupon.view.DealCardCompact;
import com.groupon.view.GrouponCheckMark;

// Referenced classes of package com.groupon.activity:
//            MyCreditCards, GrouponActivity

public class r extends r
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (MyCreditCards)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, MyCreditCards mycreditcards, Object obj)
    {
        super.bind(ewbinder, mycreditcards, obj);
        mycreditcards.savedCardsContainer = (View)ewbinder.ionalView(obj, 0x7f100420, null);
        mycreditcards.addCardsContainer = (LinearLayout)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f100424, "field 'addCardsContainer'"), 0x7f100424, "field 'addCardsContainer'");
        mycreditcards.noSavedCard = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f100422, "field 'noSavedCard'"), 0x7f100422, "field 'noSavedCard'");
        mycreditcards.cardContainer = (ViewGroup)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001f5, "field 'cardContainer'"), 0x7f1001f5, "field 'cardContainer'");
        mycreditcards.maestroContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f10042a, null), 0x7f10042a, "field 'maestroContainer'");
        mycreditcards.elvContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f10042b, null), 0x7f10042b, "field 'elvContainer'");
        mycreditcards.sepaContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f10042c, null), 0x7f10042c, "field 'sepaContainer'");
        mycreditcards.isracardContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f10042d, null), 0x7f10042d, "field 'isracardContainer'");
        mycreditcards.paypalContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f10042e, null), 0x7f10042e, "field 'paypalContainer'");
        mycreditcards.dotpayContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f10042f, null), 0x7f10042f, "field 'dotpayContainer'");
        mycreditcards.ipay88Container = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100430, null), 0x7f100430, "field 'ipay88Container'");
        mycreditcards.oneClickPaymentContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100431, null), 0x7f100431, "field 'oneClickPaymentContainer'");
        mycreditcards.redcompraPaymentContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100432, null), 0x7f100432, "field 'redcompraPaymentContainer'");
        mycreditcards.alipayPaymentContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100433, null), 0x7f100433, "field 'alipayPaymentContainer'");
        mycreditcards.webPayPaymentContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100434, null), 0x7f100434, "field 'webPayPaymentContainer'");
        mycreditcards.visaPePaymentContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100435, null), 0x7f100435, "field 'visaPePaymentContainer'");
        mycreditcards.mastercardPePaymentContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100437, null), 0x7f100437, "field 'mastercardPePaymentContainer'");
        mycreditcards.psePaymentContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100436, null), 0x7f100436, "field 'psePaymentContainer'");
        mycreditcards.idealContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100438, null), 0x7f100438, "field 'idealContainer'");
        mycreditcards.auEasyPayContainer = (ViewGroup)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100439, null), 0x7f100439, "field 'auEasyPayContainer'");
        mycreditcards.grouponBucksContainer = (View)ewbinder.uiredView(obj, 0x7f10043a, "field 'grouponBucksContainer'");
        mycreditcards.bucksValue = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f10043b, "field 'bucksValue'"), 0x7f10043b, "field 'bucksValue'");
        mycreditcards.addCardButton = (View)ewbinder.uiredView(obj, 0x7f100426, "field 'addCardButton'");
        mycreditcards.addCardIntlContainer = (View)ewbinder.ionalView(obj, 0x7f10043c, null);
        mycreditcards.addCardIcon = (TextView)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100427, null), 0x7f100427, "field 'addCardIcon'");
        mycreditcards.addCardDisplayName = (TextView)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100428, null), 0x7f100428, "field 'addCardDisplayName'");
        mycreditcards.addCardIconView = (ImageView)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f10043d, null), 0x7f10043d, "field 'addCardIconView'");
        mycreditcards.savedCardsHeader = (TextView)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100421, null), 0x7f100421, "field 'savedCardsHeader'");
        mycreditcards.newCardHeader = (TextView)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100425, null), 0x7f100425, "field 'newCardHeader'");
        mycreditcards.addPaymentCardTypes = (TextView)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100429, null), 0x7f100429, "field 'addPaymentCardTypes'");
        mycreditcards.addCreditCardButton = (View)ewbinder.ionalView(obj, 0x7f10041c, null);
        mycreditcards.creditCardTypes = (TextView)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f10041f, null), 0x7f10041f, "field 'creditCardTypes'");
        mycreditcards.loadingView = (ProgressBar)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f100173, "field 'loadingView'"), 0x7f100173, "field 'loadingView'");
        mycreditcards.dealCardCompact = (DealCardCompact)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f1000d2, null), 0x7f1000d2, "field 'dealCardCompact'");
        mycreditcards.grouponBucksBalance = (TextView)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f100440, null), 0x7f100440, "field 'grouponBucksBalance'");
        mycreditcards.grouponBucksCheckMark = (GrouponCheckMark)ewbinder.w((View)ewbinder.ionalView(obj, 0x7f10043f, null), 0x7f10043f, "field 'grouponBucksCheckMark'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (MyCreditCards)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((MyCreditCards)grouponactivity);
    }

    public void unbind(MyCreditCards mycreditcards)
    {
        super.unbind(mycreditcards);
        mycreditcards.savedCardsContainer = null;
        mycreditcards.addCardsContainer = null;
        mycreditcards.noSavedCard = null;
        mycreditcards.cardContainer = null;
        mycreditcards.maestroContainer = null;
        mycreditcards.elvContainer = null;
        mycreditcards.sepaContainer = null;
        mycreditcards.isracardContainer = null;
        mycreditcards.paypalContainer = null;
        mycreditcards.dotpayContainer = null;
        mycreditcards.ipay88Container = null;
        mycreditcards.oneClickPaymentContainer = null;
        mycreditcards.redcompraPaymentContainer = null;
        mycreditcards.alipayPaymentContainer = null;
        mycreditcards.webPayPaymentContainer = null;
        mycreditcards.visaPePaymentContainer = null;
        mycreditcards.mastercardPePaymentContainer = null;
        mycreditcards.psePaymentContainer = null;
        mycreditcards.idealContainer = null;
        mycreditcards.auEasyPayContainer = null;
        mycreditcards.grouponBucksContainer = null;
        mycreditcards.bucksValue = null;
        mycreditcards.addCardButton = null;
        mycreditcards.addCardIntlContainer = null;
        mycreditcards.addCardIcon = null;
        mycreditcards.addCardDisplayName = null;
        mycreditcards.addCardIconView = null;
        mycreditcards.savedCardsHeader = null;
        mycreditcards.newCardHeader = null;
        mycreditcards.addPaymentCardTypes = null;
        mycreditcards.addCreditCardButton = null;
        mycreditcards.creditCardTypes = null;
        mycreditcards.loadingView = null;
        mycreditcards.dealCardCompact = null;
        mycreditcards.grouponBucksBalance = null;
        mycreditcards.grouponBucksCheckMark = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((MyCreditCards)obj);
    }

    public r()
    {
    }
}
