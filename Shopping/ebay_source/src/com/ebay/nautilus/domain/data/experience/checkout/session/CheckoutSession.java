// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.session;

import com.ebay.nautilus.domain.data.experience.checkout.address.Address;
import com.ebay.nautilus.domain.data.experience.checkout.address.ShippingAddressesModule;
import com.ebay.nautilus.domain.data.experience.checkout.details.LineItem;
import com.ebay.nautilus.domain.data.experience.checkout.error.ErrorsModule;
import com.ebay.nautilus.domain.data.experience.checkout.payment.PaymentMethod;
import com.ebay.nautilus.domain.data.experience.checkout.payment.PaymentMethodsModule;
import com.ebay.nautilus.domain.data.experience.type.ExperienceData;
import com.ebay.nautilus.domain.data.experience.type.base.Presentities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.session:
//            CheckoutServiceMeta, CheckoutServiceMetaExtension

public class CheckoutSession extends ExperienceData
{

    public CheckoutSession()
    {
    }

    public List getListingSummariesForItem(LineItem lineitem)
    {
        if (presentities != null && presentities.listings != null && !presentities.listings.isEmpty() && lineitem != null && lineitem.listingSummaries != null && !lineitem.listingSummaries.isEmpty()) goto _L2; else goto _L1
_L1:
        lineitem = Collections.emptyList();
_L4:
        return lineitem;
_L2:
        List list = lineitem.listingSummaries;
        ArrayList arraylist = new ArrayList(list.size());
        int i = 0;
        do
        {
            lineitem = arraylist;
            if (i >= list.size())
            {
                continue;
            }
            lineitem = presentities.findListingSummary((String)list.get(i));
            if (lineitem != null)
            {
                arraylist.add(lineitem);
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public PaymentMethod getPaymentMethod(String s)
    {
label0:
        {
            if (modules == null || !modules.containsKey("paymentMethods"))
            {
                break label0;
            }
            Object obj = (PaymentMethodsModule)modules.get("paymentMethods");
            if (obj == null || ((PaymentMethodsModule) (obj)).availablePaymentMethods == null)
            {
                break label0;
            }
            obj = ((PaymentMethodsModule) (obj)).availablePaymentMethods.iterator();
            PaymentMethod paymentmethod;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                paymentmethod = (PaymentMethod)((Iterator) (obj)).next();
            } while (!s.equals(paymentmethod.paymentMethodId));
            return paymentmethod;
        }
        return null;
    }

    public Address getSelectedCheckoutAddress()
    {
label0:
        {
            if (modules == null || !modules.containsKey("shippingAddresses"))
            {
                break label0;
            }
            Object obj = (ShippingAddressesModule)modules.get("shippingAddresses");
            if (obj == null || ((ShippingAddressesModule) (obj)).addresses == null)
            {
                break label0;
            }
            obj = ((ShippingAddressesModule) (obj)).addresses.iterator();
            Address address;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                address = (Address)((Iterator) (obj)).next();
            } while (!address.selected);
            return address;
        }
        return null;
    }

    public PaymentMethod getSelectedPaymentMethod()
    {
label0:
        {
            if (modules == null || !modules.containsKey("paymentMethods"))
            {
                break label0;
            }
            Object obj = (PaymentMethodsModule)modules.get("paymentMethods");
            if (obj == null || ((PaymentMethodsModule) (obj)).availablePaymentMethods == null)
            {
                break label0;
            }
            obj = ((PaymentMethodsModule) (obj)).availablePaymentMethods.iterator();
            PaymentMethod paymentmethod;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                paymentmethod = (PaymentMethod)((Iterator) (obj)).next();
            } while (!paymentmethod.selected);
            return paymentmethod;
        }
        return null;
    }

    public String getSessionId()
    {
        if (meta != null && ((CheckoutServiceMeta)meta).xoServiceMeta != null)
        {
            return ((CheckoutServiceMeta)meta).xoServiceMeta.sessionId;
        } else
        {
            return null;
        }
    }

    public boolean hasErrors()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (modules != null)
        {
            flag = flag1;
            if (modules.containsKey("errors"))
            {
                ErrorsModule errorsmodule = (ErrorsModule)modules.get("errors");
                flag = flag1;
                if (errorsmodule != null)
                {
                    flag = flag1;
                    if (errorsmodule.errors != null)
                    {
                        flag = flag1;
                        if (!errorsmodule.errors.isEmpty())
                        {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

    public boolean hasFatalError()
    {
        return meta != null && ((CheckoutServiceMeta)meta).xoServiceMeta != null && ((CheckoutServiceMeta)meta).xoServiceMeta.hasFatalError;
    }

    public boolean hasShippingAddresses()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (modules != null)
        {
            flag = flag1;
            if (modules.containsKey("shippingAddresses"))
            {
                ShippingAddressesModule shippingaddressesmodule = (ShippingAddressesModule)modules.get("shippingAddresses");
                flag = flag1;
                if (shippingaddressesmodule != null)
                {
                    flag = flag1;
                    if (shippingaddressesmodule.addresses != null)
                    {
                        flag = flag1;
                        if (!shippingaddressesmodule.addresses.isEmpty())
                        {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }
}
