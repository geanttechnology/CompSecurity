// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import android.content.res.Resources;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.http.Http;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.country.Country;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.models.payment.AbstractPaymentMethod;
import com.groupon.models.payment.GoogleWalletPaymentMethod;
import com.groupon.models.payment.PaymentMethodFactory;
import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CheckedFunction1;
import com.groupon.util.ContextUtils;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import com.groupon.util.VolatileBillingInfoProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            LoginService, ApiServiceBase

public class BillingService
{
    protected class GetCreditCardsHttp extends Http
    {

        protected final Function1 exceptionListener;
        protected final Function0 finallyListener;
        private Function0 onUserCancelRetry;
        protected final CheckedFunction1 successListener;
        final BillingService this$0;

        protected void onException(Exception exception)
        {
            if (exceptionListener != null)
            {
                exceptionListener.execute(exception);
                return;
            } else
            {
                super.onException(exception);
                return;
            }
        }

        protected void onFinally()
        {
            if (finallyListener != null)
            {
                finallyListener.execute();
                return;
            } else
            {
                super.onFinally();
                return;
            }
        }

        protected void onSuccess(UserContainer usercontainer)
            throws Exception
        {
            successListener.execute(usercontainer.user.billingRecords);
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((UserContainer)obj);
        }

        public void onUserCancelRetry()
        {
            if (onUserCancelRetry != null)
            {
                onUserCancelRetry.execute();
            }
            super.onUserCancelRetry();
        }

        public GetCreditCardsHttp(CheckedFunction1 checkedfunction1, Function1 function1, Function0 function0, Function0 function0_1)
        {
            this$0 = BillingService.this;
            super(context, com/groupon/models/user/UserContainer, String.format("https:/users/%s", new Object[] {
                loginService.getUserId()
            }));
            successListener = checkedfunction1;
            exceptionListener = function1;
            onUserCancelRetry = function0;
            finallyListener = function0_1;
        }
    }


    private Context context;
    private CurrentCountryManager currentCountryManager;
    private LoginService loginService;
    private PaymentMethodFactory paymentMethodFactory;

    public BillingService()
    {
    }

    public static String getCardTypeId(BillingRecord billingrecord)
    {
        String s = billingrecord.cardType;
        if (s != null)
        {
            return s;
        } else
        {
            return billingrecord.name;
        }
    }

    public static String getCardTypeName(Context context1, BillingRecord billingrecord)
    {
        return getCardTypeName(context1, getPaymentOrCardTypeId(billingrecord));
    }

    public static String getCardTypeName(Context context1, AbstractPaymentMethod abstractpaymentmethod)
    {
        if (abstractpaymentmethod instanceof GoogleWalletPaymentMethod)
        {
            abstractpaymentmethod = abstractpaymentmethod.getId();
        } else
        {
            abstractpaymentmethod = getPaymentOrCardTypeId(abstractpaymentmethod.getBillingRecord());
        }
        return getCardTypeName(context1, ((String) (abstractpaymentmethod)));
    }

    public static String getCardTypeName(Context context1, String s)
    {
        if (s == null)
        {
            return context1.getResources().getString(0x7f080093);
        }
        int i = ContextUtils.getIdentifier(context1, s.toLowerCase(), "string");
        if (i == 0)
        {
            return Strings.capitalize(s);
        } else
        {
            return context1.getString(i);
        }
    }

    private AbstractPaymentMethod getFirstStoredCreditCard(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            AbstractPaymentMethod abstractpaymentmethod = (AbstractPaymentMethod)list.next();
            if (abstractpaymentmethod.isCreditCard() && !abstractpaymentmethod.is3DSecurePayment())
            {
                return abstractpaymentmethod;
            }
        }

        return null;
    }

    private AbstractPaymentMethod getPaymentMethodById(List list, String s)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            AbstractPaymentMethod abstractpaymentmethod = (AbstractPaymentMethod)list.next();
            if (Strings.equalsIgnoreCase(s, abstractpaymentmethod.getId()))
            {
                return abstractpaymentmethod;
            }
        }

        return null;
    }

    public static String getPaymentOrCardTypeId(BillingRecord billingrecord)
    {
        String s = getCardTypeId(billingrecord);
        if (Strings.notEmpty(s))
        {
            return s;
        } else
        {
            return getPaymentTypeId(billingrecord);
        }
    }

    public static String getPaymentTypeId(BillingRecord billingrecord)
    {
        String s = billingrecord.paymentType;
        if (s != null)
        {
            return s;
        } else
        {
            return billingrecord.name;
        }
    }

    public void getCreditCards(CheckedFunction1 checkedfunction1, Function1 function1, Function0 function0, Function0 function0_1)
    {
        if (Strings.isEmpty(loginService.getUserId()))
        {
            try
            {
                checkedfunction1.execute(Collections.emptyList());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (CheckedFunction1 checkedfunction1)
            {
                function1.execute(checkedfunction1);
            }
            return;
        } else
        {
            (new GetCreditCardsHttp(checkedfunction1, function1, function0, function0_1)).execute();
            return;
        }
    }

    public AbstractPaymentMethod getDefaultPaymentMethod(List list, String s)
    {
        Ln.d("BREAKDOWN: getDefaultPaymentMethod pp=%s, pref=%s", new Object[] {
            Boolean.valueOf(Strings.notEmpty(s)), s
        });
        if (list == null || list.size() == 0)
        {
            list = null;
        } else
        {
            s = getPaymentMethodById(list, s);
            AbstractPaymentMethod abstractpaymentmethod = getFirstStoredCreditCard(list);
            list = s;
            if (s == null)
            {
                return abstractpaymentmethod;
            }
        }
        return list;
    }

    public List getListOfPaymentMethods(List list, Deal deal, Option option, int i, VolatileBillingInfoProvider volatilebillinginfoprovider, boolean flag)
    {
        ArrayList arraylist;
        int j;
        if (list != null)
        {
            j = list.size();
        } else
        {
            j = 0;
        }
        arraylist = new ArrayList();
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            Ln.d("BREAKDOWN: USA", new Object[0]);
            if (j > 0)
            {
                list = list.iterator();
                do
                {
                    if (!list.hasNext())
                    {
                        break;
                    }
                    volatilebillinginfoprovider = (BillingRecord)list.next();
                    volatilebillinginfoprovider = paymentMethodFactory.createPaymentMethod(volatilebillinginfoprovider, deal, option, i, flag);
                    if (volatilebillinginfoprovider != null && !volatilebillinginfoprovider.isNonRecurring())
                    {
                        arraylist.add(volatilebillinginfoprovider);
                    }
                } while (true);
            }
        } else
        {
            Ln.d("BREAKDOWN: not USA", new Object[0]);
            int k;
            if (volatilebillinginfoprovider.hasCreditCardDetails())
            {
                list = new BillingRecord();
                list.cardType = volatilebillinginfoprovider.getBillingRecordCardType();
                list.cardNumber = volatilebillinginfoprovider.getBillingRecordMaskedCardNumber();
                list = paymentMethodFactory.createPaymentMethod(list, deal, option, i, flag);
                if (list != null)
                {
                    arraylist.add(list);
                }
            } else
            if (j > 0 && Strings.notEmpty(((BillingRecord)list.get(0)).billingRecordId))
            {
                list = list.iterator();
                while (list.hasNext()) 
                {
                    volatilebillinginfoprovider = (BillingRecord)list.next();
                    volatilebillinginfoprovider = paymentMethodFactory.createPaymentMethod(volatilebillinginfoprovider, deal, option, i, flag);
                    if (volatilebillinginfoprovider != null && !volatilebillinginfoprovider.isNonRecurring())
                    {
                        arraylist.add(volatilebillinginfoprovider);
                    }
                }
            }
        }
        list = com.groupon.activity.IntentFactory.Payments.values();
        k = list.length;
        for (j = 0; j < k; j++)
        {
            volatilebillinginfoprovider = list[j];
            if (Strings.equals(volatilebillinginfoprovider.getPaymentType(), "ECommerce"))
            {
                volatilebillinginfoprovider = paymentMethodFactory.createPaymentMethod(volatilebillinginfoprovider.getPaymentId(), deal, option, i, flag);
                if (volatilebillinginfoprovider != null)
                {
                    arraylist.add(volatilebillinginfoprovider);
                }
            }
        }

        return arraylist;
    }

    public DealBreakdownAddress getShippingAddress(List list)
    {
        list = (BillingRecord)list.get(0);
        return new DealBreakdownAddress(loginService.getFullName(), ((BillingRecord) (list)).streetAddress1, ((BillingRecord) (list)).streetAddress2, ((BillingRecord) (list)).city, ((BillingRecord) (list)).state, ((BillingRecord) (list)).postalCode, ((BillingRecord) (list)).country);
    }

    public transient void putEuBillingRecord(Integer integer, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0, Object aobj[])
    {
        String s = String.format("https:/users/%s/billing_records", new Object[] {
            loginService.getUserId()
        });
        ApiServiceBase apiservicebase = new ApiServiceBase(context, com/groupon/models/billingrecord/BillingRecord$List);
        if (integer != null)
        {
            apiservicebase.withProgress(integer.intValue());
        }
        apiservicebase.execute(function1, returningfunction1, function0, null, s, "PUT", Arrays.asList(aobj));
    }


}
