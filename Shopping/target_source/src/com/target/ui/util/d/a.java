// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.d;

import com.google.a.a.e;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.guest.interfaces.AppliedGiftCard;
import com.target.mothership.model.guest.interfaces.AppliedPaymentCard;
import com.target.mothership.model.guest.interfaces.EmailDeliveryShipmentDetails;
import com.target.mothership.model.guest.interfaces.MobileDeliveryShipmentDetails;
import com.target.mothership.model.guest.interfaces.OrderDetails;
import com.target.mothership.model.guest.interfaces.ShipHomeShipmentDetails;
import com.target.mothership.model.guest.interfaces.StorePickUpShipmentDetails;
import com.target.mothership.util.o;
import com.target.ui.model.account.TGTOrderPaymentCardDetailsModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{

    private static final int ADDRESS_LINE_1_INDEX = 0;
    private static final int ADDRESS_LINE_2_INDEX = 1;
    private static final int AMOUNT_PRECISION = 2;
    public static final String COMMA_STRING = ", ";
    private static final String DOLLAR_STRING = "$";
    private static final int GIFT_CARD_INDEX_FIRST = 2;
    private static final int GIFT_CARD_INDEX_FOURTH = 11;
    private static final int GIFT_CARD_INDEX_SECOND = 5;
    private static final int GIFT_CARD_INDEX_THIRD = 8;
    private static final int GIFT_CARD_LENGTH = 15;
    private static final String HYPHEN = "-";

    public static String a(AddressParams addressparams)
    {
        if (addressparams == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((String)addressparams.a().get(0));
        if (addressparams.a().size() > 1)
        {
            addressparams = (String)addressparams.a().get(1);
            if (o.f(addressparams))
            {
                stringbuilder.append(", ");
                stringbuilder.append(addressparams);
            }
        }
        return stringbuilder.toString();
    }

    public static String a(GuestAddress guestaddress)
    {
        if (guestaddress == null || guestaddress.getAddressLines().isEmpty())
        {
            return "";
        }
        guestaddress = guestaddress.getAddressLines();
        StringBuilder stringbuilder = new StringBuilder((String)guestaddress.get(0));
        if (guestaddress.size() > 1 && o.g((String)guestaddress.get(1)))
        {
            stringbuilder.append(", ");
            stringbuilder.append((String)guestaddress.get(1));
        }
        return stringbuilder.toString();
    }

    public static String a(String s)
    {
        if (o.c(s) || s.length() > 15)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        s = s.toCharArray();
        for (int i = 0; i < s.length; i++)
        {
            stringbuilder.append(s[i]);
            if (i == 2 || i == 5 || i == 8 || i == 11)
            {
                stringbuilder.append("-");
            }
        }

        return stringbuilder.toString();
    }

    public static String a(BigDecimal bigdecimal)
    {
        if (bigdecimal == null)
        {
            return "";
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("$");
            stringbuilder.append(bigdecimal.setScale(2, RoundingMode.CEILING));
            return stringbuilder.toString();
        }
    }

    public static List a(AppliedPaymentCard appliedpaymentcard, List list)
    {
        ArrayList arraylist = new ArrayList();
        if (appliedpaymentcard != null)
        {
            TGTOrderPaymentCardDetailsModel tgtorderpaymentcarddetailsmodel = new TGTOrderPaymentCardDetailsModel();
            tgtorderpaymentcarddetailsmodel.a(appliedpaymentcard.a());
            tgtorderpaymentcarddetailsmodel.a(appliedpaymentcard.c());
            tgtorderpaymentcarddetailsmodel.a(appliedpaymentcard.b());
            arraylist.add(tgtorderpaymentcarddetailsmodel);
        }
        TGTOrderPaymentCardDetailsModel tgtorderpaymentcarddetailsmodel1;
        for (appliedpaymentcard = list.iterator(); appliedpaymentcard.hasNext(); arraylist.add(tgtorderpaymentcarddetailsmodel1))
        {
            list = (AppliedGiftCard)appliedpaymentcard.next();
            tgtorderpaymentcarddetailsmodel1 = new TGTOrderPaymentCardDetailsModel();
            tgtorderpaymentcarddetailsmodel1.a(com.target.mothership.common.tender.a.TARGET_GIFT_CARD);
            tgtorderpaymentcarddetailsmodel1.a(list.b());
            tgtorderpaymentcarddetailsmodel1.a(list.a());
        }

        return arraylist;
    }

    public static List a(OrderDetails orderdetails)
    {
        ArrayList arraylist = new ArrayList();
        if (orderdetails.b().b())
        {
            arraylist.addAll(((ShipHomeShipmentDetails)orderdetails.b().c()).a());
        }
        if (orderdetails.c().b())
        {
            arraylist.addAll(((StorePickUpShipmentDetails)orderdetails.c().c()).a());
        }
        if (orderdetails.d().b())
        {
            arraylist.addAll(((EmailDeliveryShipmentDetails)orderdetails.d().c()).a());
        }
        if (orderdetails.e().b())
        {
            arraylist.addAll(((MobileDeliveryShipmentDetails)orderdetails.e().c()).a());
        }
        arraylist.addAll(orderdetails.a());
        return arraylist;
    }
}
