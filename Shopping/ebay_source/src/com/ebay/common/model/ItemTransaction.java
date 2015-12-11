// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.EbnOrderCancelReason;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.OrderPickupStatus;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

// Referenced classes of package com.ebay.common.model:
//            ParcelableHelper, ItemTransactionVariation, OrderShippingInfo, Refund, 
//            Payment

public class ItemTransaction extends ParcelableHelper
    implements Parcelable
{
    public class ShipmentTrackingDetails
    {

        public String shipmentTrackingNumber;
        public String shippingCarrierUsed;
        final ItemTransaction this$0;

        public ShipmentTrackingDetails()
        {
            this$0 = ItemTransaction.this;
            super();
        }
    }

    public static class UnpaidItem extends BaseDataMapped
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public UnpaidItem createFromParcel(Parcel parcel)
            {
                return (UnpaidItem)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/ItemTransaction$UnpaidItem);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public UnpaidItem[] newArray(int i)
            {
                return new UnpaidItem[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public String status;
        public String type;


        public UnpaidItem()
        {
        }
    }


    public static final String AfterSalesInactive = "NotApplicable";
    public static final String BuyerHasNotCompletedCheckout = "BuyerHasNotCompletedCheckout";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ItemTransaction createFromParcel(Parcel parcel)
        {
            return new ItemTransaction(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ItemTransaction[] newArray(int i)
        {
            return new ItemTransaction[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String CheckoutPaymentMethodUsedCashOnDelivery = "COD";
    public static final String CheckoutPaymentMethodUsedCashOnPickup = "CashOnPickup";
    public static final String CheckoutPaymentMethodUsedMoneyTransferAccepted = "MoneyXferAccepted";
    public static final String CheckoutPaymentMethodUsedMoneyTransferAcceptedInCheckout = "MoneyXferAcceptedInCheckout";
    public static final String CheckoutPaymentMethodUsedPaisaPayEscrow = "PaisaPayEscrow";
    public static final String CheckoutPaymentMethodUsedPaisaPayEscrowEmi = "PaisaPayEscrowEMI";
    public static final String CheckoutPaymentMethodUsedPayPal = "PayPal";
    public static final String CheckoutStatusComplete = "CheckoutComplete";
    public static final String CheckoutStatusIncomplete = "CheckoutIncomplete";
    public static final String CompleteStatusComplete = "Complete";
    public static final String CompleteStatusCustomCode = "CustomCode";
    public static final String CompleteStatusIncomplete = "Incomplete";
    public static final String CompleteStatusPending = "Pending";
    public static final String CustomCode = "CustomCode";
    public static final String EscrowPaymentCancelled = "EscrowPaymentCancelled";
    public static final String MarkedAsPaid = "MarkedAsPaid";
    public static final String NotPaid = "NotPaid";
    public static final String OrderStatusActive = "Active";
    public static final String OrderStatusAll = "All";
    public static final String OrderStatusAuthenticated = "Authenticated";
    public static final String OrderStatusCancelled = "Cancelled";
    public static final String OrderStatusCompleted = "Completed";
    public static final String OrderStatusCustomCode = "CustomCode";
    public static final String OrderStatusDefault = "Default";
    public static final String OrderStatusInProcess = "InProcess";
    public static final String OrderStatusInactive = "Inactive";
    public static final String OrderStatusInvalid = "Invalid";
    public static final String OrderStatusShipped = "Shipped";
    public static final String Paid = "Paid";
    public static final String PaidCOD = "PaidCOD";
    public static final String PaidWithEscrow = "PaidWithEscrow";
    public static final String PaidWithPaisaPay = "PaidWithPaisaPay";
    public static final String PaidWithPaisaPayEscrow = "PaidWithPaisaPayEscrow";
    public static final String PaidWithPayPal = "PaidWithPayPal";
    public static final String PaisaPayNotPaid = "PaisaPayNotPaid";
    public static final String PayUponInvoice = "PayUponInvoice";
    public static final String PaymentHoldStatusCustomCode = "CustomCode";
    public static final String PaymentHoldStatusMerchantHold = "MerchantHold";
    public static final String PaymentHoldStatusNewSellerHold = "NewSellerHold";
    public static final String PaymentHoldStatusNone = "None";
    public static final String PaymentHoldStatusPaymentHold = "PaymentHold";
    public static final String PaymentHoldStatusPaymentReview = "PaymentReview";
    public static final String PaymentHoldStatusReleaseConfirmed = "ReleaseConfirmed";
    public static final String PaymentHoldStatusReleaseFailed = "ReleaseFailed";
    public static final String PaymentHoldStatusReleasePending = "ReleasePending";
    public static final String PaymentHoldStatusReleased = "Released";
    public static final String PaymentPending = "PaymentPending";
    public static final String PaymentPendingWithEscrow = "PaymentPendingWithEscrow";
    public static final String PaymentPendingWithPaisaPay = "PaymentPendingWithPaisaPay";
    public static final String PaymentPendingWithPaisaPayEscrow = "PaymentPendingWithPaisaPayEscrow";
    public static final String PaymentPendingWithPayPal = "PaymentPendingWithPayPal";
    public static final String Refunded = "Refunded";
    public static final String RequiredSellerActionCustomCode = "CustomCode";
    public static final String RequiredSellerActionMarkAsShipped = "MarkAsShipped";
    public static final String RequiredSellerActionNone = "None";
    public static final String RequiredSellerActionResolveeBPCase = "ResolveeBPCase";
    public static final String WaitingForCODPayment = "WaitingForCODPayment";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo unmarshalLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ItemTxUnmarshal", 4, "Parcel unmarshal lifecycle details");
    public ItemCurrency amountPaid;
    public String buyerCheckoutMessage;
    public String buyerCityName;
    public String buyerCountry;
    public String buyerCountryName;
    public boolean buyerFeedbackPrivate;
    public String buyerFeedbackRatingStar;
    public Integer buyerFeedbackScore;
    public String buyerName;
    public String buyerPhone;
    public Float buyerPositiveFeedbackPercent;
    public String buyerPostalCode;
    public String buyerStateOrProvince;
    public String buyerStreet;
    public String buyerStreet1;
    public String buyerStreet2;
    public String buyerUserId;
    public EbnOrderCancelReason cancelReason;
    public String cancelStatus;
    public String checkoutStatus;
    public String completeStatus;
    public ItemCurrency convertedAmountPaid;
    public ItemCurrency convertedTransactionPrice;
    public Date createdDate;
    public String ebayPaymentStatus;
    public Date expectedReleaseDate;
    public String inquiryStatus;
    public boolean isEbayNow;
    public String merchantPickupCode;
    public boolean multiLeg;
    public String multiLegAddressId;
    public String multiLegAddressOwner;
    public String multiLegAddressUsage;
    public String multiLegCityName;
    public String multiLegCountry;
    public String multiLegCountryName;
    public String multiLegExternalAddressId;
    public String multiLegName;
    public String multiLegPhone;
    public String multiLegPostalCode;
    public String multiLegReferenceId;
    public String multiLegServiceName;
    public String multiLegStateOrProvince;
    public String multiLegStreet1;
    public String multiLegStreet2;
    public String orderId;
    public String orderLineItemId;
    public OrderShippingInfo orderShippingInfo;
    public String orderStatus;
    public Date paidTime;
    public String paymentHoldStatus;
    public String paymentMethodUsed;
    public ArrayList paymentMethods;
    public ArrayList payments;
    public String pickupMethod;
    public String pickupPriority;
    public OrderPickupStatus pickupStatus;
    public int quantityPurchased;
    public ArrayList refunds;
    public ArrayList requiredSellerActions;
    public String returnStatus;
    public ItemCurrency salesTaxAmount;
    public float salesTaxPercent;
    public boolean salesTaxShippingIncludedInTax;
    public String salesTaxState;
    public String selectedMethod;
    public ShippingCostsShippingOption selectedShippingOption;
    public String sellerUserId;
    public ArrayList shipmentTrackingDetails;
    public Date shippedTime;
    public ArrayList shippingOptions;
    public int shippingTimeMax;
    public int shippingTimeMin;
    public String shippingType;
    public String storeId;
    public boolean thirdPartyCheckout;
    public String transactionId;
    public ItemCurrency transactionPrice;
    public UnpaidItem unpaidItem;
    public ItemTransactionVariation variation;

    public ItemTransaction()
    {
        quantityPurchased = 1;
        variation = new ItemTransactionVariation();
        selectedShippingOption = new ShippingCostsShippingOption();
        shippingOptions = new ArrayList();
        shipmentTrackingDetails = new ArrayList();
        shippingTimeMin = -1;
        shippingTimeMax = -1;
        orderShippingInfo = new OrderShippingInfo();
        paymentMethods = new ArrayList();
        requiredSellerActions = new ArrayList();
        multiLeg = false;
        payments = new ArrayList();
        refunds = new ArrayList();
        isEbayNow = false;
        cancelReason = EbnOrderCancelReason.NOT_SET;
    }

    ItemTransaction(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        quantityPurchased = 1;
        variation = new ItemTransactionVariation();
        selectedShippingOption = new ShippingCostsShippingOption();
        shippingOptions = new ArrayList();
        shipmentTrackingDetails = new ArrayList();
        shippingTimeMin = -1;
        shippingTimeMax = -1;
        orderShippingInfo = new OrderShippingInfo();
        paymentMethods = new ArrayList();
        requiredSellerActions = new ArrayList();
        multiLeg = false;
        payments = new ArrayList();
        refunds = new ArrayList();
        isEbayNow = false;
        cancelReason = EbnOrderCancelReason.NOT_SET;
        if (unmarshalLogger.isLoggable)
        {
            unmarshalLogger.log(getClass().getSimpleName());
        }
        ClassLoader classloader = getClass().getClassLoader();
        sellerUserId = parcel.readString();
        transactionId = parcel.readString();
        quantityPurchased = parcel.readInt();
        orderId = parcel.readString();
        orderLineItemId = parcel.readString();
        variation = (ItemTransactionVariation)parcel.readParcelable(classloader);
        buyerUserId = parcel.readString();
        buyerFeedbackRatingStar = parcel.readString();
        buyerFeedbackScore = readOptInt(parcel);
        buyerPositiveFeedbackPercent = readOptFloat(parcel);
        buyerCityName = parcel.readString();
        buyerStreet = parcel.readString();
        buyerStreet1 = parcel.readString();
        buyerStreet2 = parcel.readString();
        buyerCountry = parcel.readString();
        buyerCountryName = parcel.readString();
        buyerName = parcel.readString();
        buyerPhone = parcel.readString();
        buyerPostalCode = parcel.readString();
        buyerStateOrProvince = parcel.readString();
        completeStatus = parcel.readString();
        ebayPaymentStatus = parcel.readString();
        paymentMethodUsed = parcel.readString();
        shippingType = parcel.readString();
        int i1;
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        thirdPartyCheckout = flag;
        parcel.readTypedList(shippingOptions, ShippingCostsShippingOption.CREATOR);
        selectedShippingOption = (ShippingCostsShippingOption)parcel.readParcelable(classloader);
        transactionPrice = (ItemCurrency)parcel.readParcelable(classloader);
        convertedTransactionPrice = (ItemCurrency)parcel.readParcelable(classloader);
        amountPaid = (ItemCurrency)parcel.readParcelable(classloader);
        convertedAmountPaid = (ItemCurrency)parcel.readParcelable(classloader);
        if (parcel.readInt() == 1)
        {
            paidTime = new Date(parcel.readLong());
        }
        if (parcel.readInt() == 1)
        {
            createdDate = new Date(parcel.readLong());
        }
        i1 = parcel.readInt();
        for (int i = 0; i < i1; i++)
        {
            ShipmentTrackingDetails shipmenttrackingdetails = new ShipmentTrackingDetails();
            shipmenttrackingdetails.shipmentTrackingNumber = parcel.readString();
            shipmenttrackingdetails.shippingCarrierUsed = parcel.readString();
            shipmentTrackingDetails.add(shipmenttrackingdetails);
        }

        shippingTimeMin = parcel.readInt();
        shippingTimeMax = parcel.readInt();
        orderShippingInfo = (OrderShippingInfo)parcel.readParcelable(classloader);
        parcel.readStringList(paymentMethods);
        orderStatus = parcel.readString();
        if (parcel.readInt() == 1)
        {
            expectedReleaseDate = new Date(parcel.readLong());
        }
        parcel.readStringList(requiredSellerActions);
        paymentHoldStatus = parcel.readString();
        salesTaxAmount = (ItemCurrency)parcel.readParcelable(classloader);
        salesTaxPercent = parcel.readFloat();
        salesTaxState = parcel.readString();
        int j;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        salesTaxShippingIncludedInTax = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        multiLeg = flag;
        multiLegAddressId = parcel.readString();
        multiLegAddressOwner = parcel.readString();
        multiLegAddressUsage = parcel.readString();
        multiLegCityName = parcel.readString();
        multiLegCountry = parcel.readString();
        multiLegCountryName = parcel.readString();
        multiLegExternalAddressId = parcel.readString();
        multiLegName = parcel.readString();
        multiLegPhone = parcel.readString();
        multiLegPostalCode = parcel.readString();
        multiLegReferenceId = parcel.readString();
        multiLegStateOrProvince = parcel.readString();
        multiLegStreet1 = parcel.readString();
        multiLegStreet2 = parcel.readString();
        checkoutStatus = parcel.readString();
        if (parcel.readInt() == 1)
        {
            shippedTime = new Date(parcel.readLong());
        }
        pickupMethod = parcel.readString();
        pickupPriority = parcel.readString();
        selectedMethod = parcel.readString();
        storeId = parcel.readString();
        j = parcel.readInt();
        if (j != -1)
        {
            pickupStatus = OrderPickupStatus.values()[j];
        }
        merchantPickupCode = parcel.readString();
        i1 = parcel.readInt();
        if (i1 > 0)
        {
            refunds = new ArrayList();
            for (int k = 0; k < i1; k++)
            {
                refunds.add(Refund.CREATOR.createFromParcel(parcel));
            }

        }
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isEbayNow = flag;
        cancelReason = EbnOrderCancelReason.values()[parcel.readInt()];
        buyerCheckoutMessage = parcel.readString();
        i1 = parcel.readInt();
        if (i1 > 0)
        {
            payments = new ArrayList();
            for (int l = 0; l < i1; l++)
            {
                payments.add(Payment.CREATOR.createFromParcel(parcel));
            }

        }
        if (parcel.readInt() > 0)
        {
            unpaidItem = (UnpaidItem)UnpaidItem.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        buyerFeedbackPrivate = flag;
        inquiryStatus = parcel.readString();
        returnStatus = parcel.readString();
        cancelStatus = parcel.readString();
        multiLegServiceName = parcel.readString();
    }

    public static boolean isPaid(String s)
    {
        byte byte0;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 7: default 76
    //                   -2141985991: 192
    //                   -1752138358: 122
    //                   2479852: 136
    //                   654322871: 164
    //                   812180948: 178
    //                   862893804: 150
    //                   953242437: 206;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_206;
_L9:
        switch (byte0)
        {
        default:
            return false;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            return true;
        }
_L3:
        if (s.equals("MarkedAsPaid"))
        {
            byte0 = 0;
        }
          goto _L9
_L4:
        if (s.equals("Paid"))
        {
            byte0 = 1;
        }
          goto _L9
_L7:
        if (s.equals("PaidCOD"))
        {
            byte0 = 2;
        }
          goto _L9
_L5:
        if (s.equals("PaidWithEscrow"))
        {
            byte0 = 3;
        }
          goto _L9
_L6:
        if (s.equals("PaidWithPaisaPay"))
        {
            byte0 = 4;
        }
          goto _L9
_L2:
        if (s.equals("PaidWithPaisaPayEscrow"))
        {
            byte0 = 5;
        }
          goto _L9
        if (s.equals("PaidWithPayPal"))
        {
            byte0 = 6;
        }
          goto _L9
        return false;
    }

    public static boolean isPaidFor(String s)
    {
        return isPaid(s) || isPaymentPending(s);
    }

    public static boolean isPaidUsingTradingQuirk(String s, String s1)
    {
        return "CustomCode".equals(s) && s1 != null;
    }

    public static boolean isPaymentPending(String s)
    {
        byte byte0;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 5: default 60
    //                   -1723628452: 112
    //                   -1424708886: 154
    //                   -781466146: 140
    //                   523561017: 126
    //                   1614710993: 98;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_154;
_L7:
        switch (byte0)
        {
        default:
            return false;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            return true;
        }
_L6:
        if (s.equals("PaymentPending"))
        {
            byte0 = 0;
        }
          goto _L7
_L2:
        if (s.equals("PaymentPendingWithEscrow"))
        {
            byte0 = 1;
        }
          goto _L7
_L5:
        if (s.equals("PaymentPendingWithPaisaPay"))
        {
            byte0 = 2;
        }
          goto _L7
_L4:
        if (s.equals("PaymentPendingWithPaisaPayEscrow"))
        {
            byte0 = 3;
        }
          goto _L7
        if (s.equals("PaymentPendingWithPayPal"))
        {
            byte0 = 4;
        }
          goto _L7
        return false;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getShipmentTrackingNumber()
    {
        if (shipmentTrackingDetails.size() > 0)
        {
            return ((ShipmentTrackingDetails)shipmentTrackingDetails.get(0)).shipmentTrackingNumber;
        } else
        {
            return null;
        }
    }

    public String getShippingCarrierUsed()
    {
        if (shipmentTrackingDetails.size() > 0)
        {
            return ((ShipmentTrackingDetails)shipmentTrackingDetails.get(0)).shippingCarrierUsed;
        } else
        {
            return null;
        }
    }

    public boolean isInProcess()
    {
        return pickupStatus != null && pickupStatus == OrderPickupStatus.PendingMerchantConfirmation && !isInStoreCredit() && !isPaymentRefund();
    }

    public boolean isInStoreCredit()
    {
label0:
        {
            if (refunds == null || refunds.size() <= 0)
            {
                break label0;
            }
            Iterator iterator = refunds.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!"StoreCredit".equals(((Refund)iterator.next()).type));
            return true;
        }
        return false;
    }

    public boolean isPaymentRefund()
    {
label0:
        {
            if (refunds == null || refunds.size() <= 0)
            {
                break label0;
            }
            Iterator iterator = refunds.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!"PaymentRefund".equals(((Refund)iterator.next()).type));
            return true;
        }
        return false;
    }

    public void setShipmentTrackingNumber(String s)
    {
        if (shipmentTrackingDetails.size() > 0)
        {
            ((ShipmentTrackingDetails)shipmentTrackingDetails.get(0)).shipmentTrackingNumber = s;
            return;
        } else
        {
            ShipmentTrackingDetails shipmenttrackingdetails = new ShipmentTrackingDetails();
            shipmenttrackingdetails.shipmentTrackingNumber = s;
            shipmentTrackingDetails.add(shipmenttrackingdetails);
            return;
        }
    }

    public void setShippingCarrierUsed(String s)
    {
        if (shipmentTrackingDetails.size() > 0)
        {
            ((ShipmentTrackingDetails)shipmentTrackingDetails.get(0)).shippingCarrierUsed = s;
            return;
        } else
        {
            ShipmentTrackingDetails shipmenttrackingdetails = new ShipmentTrackingDetails();
            shipmenttrackingdetails.shippingCarrierUsed = s;
            shipmentTrackingDetails.add(shipmenttrackingdetails);
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(sellerUserId);
        parcel.writeString(transactionId);
        parcel.writeInt(quantityPurchased);
        parcel.writeString(orderId);
        parcel.writeString(orderLineItemId);
        parcel.writeParcelable(variation, i);
        parcel.writeString(buyerUserId);
        parcel.writeString(buyerFeedbackRatingStar);
        writeOptInt(parcel, buyerFeedbackScore);
        writeOptFloat(parcel, buyerPositiveFeedbackPercent);
        parcel.writeString(buyerCityName);
        parcel.writeString(buyerStreet);
        parcel.writeString(buyerStreet1);
        parcel.writeString(buyerStreet2);
        parcel.writeString(buyerCountry);
        parcel.writeString(buyerCountryName);
        parcel.writeString(buyerName);
        parcel.writeString(buyerPhone);
        parcel.writeString(buyerPostalCode);
        parcel.writeString(buyerStateOrProvince);
        parcel.writeString(completeStatus);
        parcel.writeString(ebayPaymentStatus);
        parcel.writeString(paymentMethodUsed);
        parcel.writeString(shippingType);
        int j;
        if (thirdPartyCheckout)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeTypedList(shippingOptions);
        parcel.writeParcelable(selectedShippingOption, i);
        parcel.writeParcelable(transactionPrice, i);
        parcel.writeParcelable(convertedTransactionPrice, i);
        parcel.writeParcelable(amountPaid, i);
        parcel.writeParcelable(convertedAmountPaid, i);
        if (paidTime != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (paidTime != null)
        {
            parcel.writeLong(paidTime.getTime());
        }
        if (createdDate != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (createdDate != null)
        {
            parcel.writeLong(createdDate.getTime());
        }
        parcel.writeInt(shipmentTrackingDetails.size());
        ShipmentTrackingDetails shipmenttrackingdetails;
        for (Iterator iterator = shipmentTrackingDetails.iterator(); iterator.hasNext(); parcel.writeString(shipmenttrackingdetails.shippingCarrierUsed))
        {
            shipmenttrackingdetails = (ShipmentTrackingDetails)iterator.next();
            parcel.writeString(shipmenttrackingdetails.shipmentTrackingNumber);
        }

        parcel.writeInt(shippingTimeMin);
        parcel.writeInt(shippingTimeMax);
        parcel.writeParcelable(orderShippingInfo, i);
        parcel.writeStringList(paymentMethods);
        parcel.writeString(orderStatus);
        if (expectedReleaseDate != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (expectedReleaseDate != null)
        {
            parcel.writeLong(expectedReleaseDate.getTime());
        }
        parcel.writeStringList(requiredSellerActions);
        parcel.writeString(paymentHoldStatus);
        parcel.writeParcelable(salesTaxAmount, i);
        parcel.writeFloat(salesTaxPercent);
        parcel.writeString(salesTaxState);
        if (salesTaxShippingIncludedInTax)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (multiLeg)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeString(multiLegAddressId);
        parcel.writeString(multiLegAddressOwner);
        parcel.writeString(multiLegAddressUsage);
        parcel.writeString(multiLegCityName);
        parcel.writeString(multiLegCountry);
        parcel.writeString(multiLegCountryName);
        parcel.writeString(multiLegExternalAddressId);
        parcel.writeString(multiLegName);
        parcel.writeString(multiLegPhone);
        parcel.writeString(multiLegPostalCode);
        parcel.writeString(multiLegReferenceId);
        parcel.writeString(multiLegStateOrProvince);
        parcel.writeString(multiLegStreet1);
        parcel.writeString(multiLegStreet2);
        parcel.writeString(checkoutStatus);
        if (shippedTime != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (shippedTime != null)
        {
            parcel.writeLong(shippedTime.getTime());
        }
        parcel.writeString(pickupMethod);
        parcel.writeString(pickupPriority);
        parcel.writeString(selectedMethod);
        parcel.writeString(storeId);
        if (pickupStatus != null)
        {
            j = pickupStatus.ordinal();
        } else
        {
            j = -1;
        }
        parcel.writeInt(j);
        parcel.writeString(merchantPickupCode);
        if (refunds == null || refunds.isEmpty())
        {
            j = 0;
        } else
        {
            j = refunds.size();
        }
        parcel.writeInt(j);
        if (refunds != null)
        {
            for (Iterator iterator1 = refunds.iterator(); iterator1.hasNext(); ((Refund)iterator1.next()).writeToParcel(parcel, i)) { }
        }
        if (isEbayNow)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeInt(cancelReason.ordinal());
        parcel.writeString(buyerCheckoutMessage);
        if (payments == null || payments.isEmpty())
        {
            j = 0;
        } else
        {
            j = payments.size();
        }
        parcel.writeInt(j);
        if (payments != null)
        {
            for (Iterator iterator2 = payments.iterator(); iterator2.hasNext(); ((Payment)iterator2.next()).writeToParcel(parcel, i)) { }
        }
        if (unpaidItem != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (unpaidItem != null)
        {
            unpaidItem.writeToParcel(parcel, i);
        }
        if (buyerFeedbackPrivate)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(inquiryStatus);
        parcel.writeString(returnStatus);
        parcel.writeString(cancelStatus);
        parcel.writeString(multiLegServiceName);
    }

}
