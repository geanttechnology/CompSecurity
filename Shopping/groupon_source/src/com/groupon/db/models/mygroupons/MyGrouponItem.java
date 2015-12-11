// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models.mygroupons;

import com.groupon.db.models.Division;
import com.groupon.db.models.Location;
import com.groupon.db.models.Price;
import com.groupon.db.models.Shipment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.db.models.mygroupons:
//            AbstractMyGrouponItem

public class MyGrouponItem extends AbstractMyGrouponItem
{
    protected static class BillingInfo
    {

        public String cardNumber;
        public String cardType;
        public String number;
        public String paymentType;

        protected BillingInfo()
        {
            cardType = "";
            number = "";
            cardNumber = "";
            paymentType = "";
        }
    }

    protected static class Breakdowns
    {

        public static final Pricing DefaultPricing = new Pricing();
        public Pricing pricing;
        public List tenders;


        protected Breakdowns()
        {
            pricing = DefaultPricing;
            tenders = Collections.emptyList();
        }
    }

    protected static class Deal
    {

        public Division division;
        public String id;
        public boolean isBookableTravelDeal;
        public boolean isInventoryDeal;
        public boolean isRewardDeal;
        public String largeImageUrl;
        public String sidebarImageUrl;
        public String title;

        protected Deal()
        {
            largeImageUrl = "";
            sidebarImageUrl = "";
            title = "";
            id = "";
            isRewardDeal = false;
            isInventoryDeal = false;
            isBookableTravelDeal = false;
            division = MyGrouponItem.DefaultDivision;
        }
    }

    protected static class DealOption
    {

        public static final SchedulerOptions DefaultSchedulerOptions = new SchedulerOptions();
        public boolean bookable;
        public List details;
        public String id;
        public String instructions;
        public Price price;
        public String redeemInstructions;
        public List redemptionLocations;
        public SchedulerOptions schedulerOptions;
        public SpecificAttributes specificAttributes;
        public String subTitle;
        public String title;
        public Price value;


        protected DealOption()
        {
            title = "";
            subTitle = "";
            instructions = "";
            redeemInstructions = "";
            id = "";
            bookable = false;
            schedulerOptions = DefaultSchedulerOptions;
            details = Collections.emptyList();
            redemptionLocations = Collections.emptyList();
            specificAttributes = new SpecificAttributes();
            price = new Price();
            value = new Price();
        }
    }

    protected static class Detail
    {

        public String description;

        protected Detail()
        {
            description = "";
        }
    }

    protected static class Images
    {

        public String url;

        protected Images()
        {
            url = "";
        }
    }

    protected static class LocalBookingInfo
    {

        public static final Reservation DefaultReservation = new Reservation();
        public Reservation reservation;


        protected LocalBookingInfo()
        {
            reservation = DefaultReservation;
        }
    }

    protected static class Merchant
    {

        public String id;
        public String name;
        public String uuid;
        public String websiteUrl;

        protected Merchant()
        {
            name = "";
            websiteUrl = "";
            id = "";
            uuid = "";
        }
    }

    protected static class OnlineBooking
    {

        public boolean isBooked;
        public boolean isMaintenance;
        public String travelBookingUrl;

        protected OnlineBooking()
        {
            isBooked = false;
            isMaintenance = false;
            travelBookingUrl = "";
        }
    }

    protected static class Option
    {

        public static final ArrayList DefaultListDetails = new ArrayList();
        ArrayList details;

        public ArrayList getDetails()
        {
            return (ArrayList)details.get(0);
        }


        protected Option()
        {
            details = DefaultListDetails;
        }
    }

    protected static class Order
    {

        public String id;
        public boolean isEditable;
        public String status;
        public String statusMessage;

        protected Order()
        {
            id = "";
            status = "";
            statusMessage = "";
            isEditable = false;
        }
    }

    protected static class PriceType
    {

        public String formattedAmount;

        protected PriceType()
        {
            formattedAmount = "";
        }
    }

    protected static class Pricing
    {

        public static final PriceType DefaultPriceType = new PriceType();
        public PriceType hotelTax;
        public PriceType subTotal;
        public PriceType total;


        protected Pricing()
        {
            hotelTax = DefaultPriceType;
            subTotal = DefaultPriceType;
            total = DefaultPriceType;
        }
    }

    protected static class Reservation
    {

        public Date checkInDate;
        public Date checkOutDate;
        public int dealTimezoneOffsetInSeconds;
        public String hotelName;
        public String hotelTimezoneIdentifier;
        public String id;
        public List images;
        public int numOfNights;
        public Date purchaseDate;
        public String purchaseStatus;
        public String status;
        public String travellerFirstName;
        public String travellerLastName;

        protected Reservation()
        {
            dealTimezoneOffsetInSeconds = 0;
            numOfNights = 0;
            travellerFirstName = "";
            travellerLastName = "";
            hotelTimezoneIdentifier = "";
            checkInDate = null;
            purchaseDate = null;
            purchaseStatus = "";
            checkOutDate = null;
            hotelName = "";
            status = "";
            id = "";
            images = Collections.emptyList();
        }
    }

    protected static class SchedulerOptions
    {

        public String bookingType;

        protected SchedulerOptions()
        {
            bookingType = "";
        }
    }

    protected static class SpecificAttributes
    {

        public TakeoutDelivery takeoutDelivery;

        protected SpecificAttributes()
        {
            takeoutDelivery = new TakeoutDelivery();
        }
    }

    protected static class TakeoutDelivery
    {

        public boolean delivery;
        public boolean takeout;

        protected TakeoutDelivery()
        {
            takeout = false;
            delivery = false;
        }
    }

    protected static class Tenders
    {

        public static final BillingInfo DefaultBillingInfo = new BillingInfo();
        public static final PriceType DefaultPriceType = new PriceType();
        public PriceType amount;
        private BillingInfo billingInfo;
        public String type;



        protected Tenders()
        {
            type = "";
            amount = DefaultPriceType;
            billingInfo = DefaultBillingInfo;
        }
    }

    protected static class Ticket
    {

        public String account;
        public String entrance;
        public String event;
        public String row;
        public String seat;
        public String section;

        protected Ticket()
        {
            event = "";
            account = "";
            entrance = "";
            section = "";
            row = "";
            seat = "";
        }
    }

    protected static class TravelBookingInfo
    {

        public static final Breakdowns DefaultBreakdowns = new Breakdowns();
        public static final OnlineBooking DefaultOnlineBooking = new OnlineBooking();
        public static final Reservation DefaultReservation = new Reservation();
        public Breakdowns breakdowns;
        public OnlineBooking onlineBooking;
        public Reservation reservation;


        protected TravelBookingInfo()
        {
            reservation = DefaultReservation;
            breakdowns = DefaultBreakdowns;
            onlineBooking = DefaultOnlineBooking;
        }
    }

    protected static class VoucherIdInfo
    {

        public String cnoOrSnText;
        public String serialNumber;

        protected VoucherIdInfo()
        {
            cnoOrSnText = "";
            serialNumber = "";
        }
    }


    public static final Deal DefaultDeal = new Deal();
    public static final DealOption DefaultDealOption = new DealOption();
    public static final Division DefaultDivision = new Division();
    public static final LocalBookingInfo DefaultLocalBookingInfo = new LocalBookingInfo();
    public static final Merchant DefaultMerchant = new Merchant();
    public static final Option DefaultOption = new Option();
    public static final Order DefaultOrder = new Order();
    public static final Ticket DefaultTicket = new Ticket();
    public static final TravelBookingInfo DefaultTravelBookingInfo = new TravelBookingInfo();
    public static final VoucherIdInfo DefaultVoucherIdInfo = new VoucherIdInfo();
    public String barcodeImageUrl;
    public String billingInfoCardNumber;
    public String billingInfoCardType;
    public String billingInfoPaymentType;
    public String cash;
    public String category;
    public String cnoOrSnText;
    public Deal deal;
    public DealOption dealOption;
    public int dealOptionPriceAmount;
    public boolean dealOptionSpecificAttributeDelivery;
    public int dealOptionValueAmount;
    public String dealOptionValueCurrencyCode;
    public String dealTitle;
    public Division division;
    public int divisionTimezoneOffsetInSeconds;
    public String externalVoucherUrl;
    public String grouponNumber;
    public boolean hasExternalVoucherUrl;
    public String hotelFormattedAmount;
    public boolean isAutoRefundEnabled;
    public boolean isAwaitingTicket;
    public boolean isBookableTravelDeal;
    public boolean isBooked;
    public boolean isDealOptionSpecificAttributeTakeout;
    public boolean isEditable;
    public boolean isInventoryDeal;
    public boolean isMaintenance;
    public String listDescriptionFromDetails;
    public String listDescriptions;
    public LocalBookingInfo localBookingInfo;
    public Merchant merchant;
    public Date merchantRedeemedAt;
    public String merchantUuid;
    public int numOfNights;
    public Option option;
    public Order order;
    public Date printedAt;
    public String redeemInstructions;
    public String redeemerName;
    public Collection redemptionLocations;
    public volatile ArrayList redemptionLocationsList;
    public String remoteId;
    public String serialNumber;
    public Collection shipments;
    public volatile ArrayList shipmentsList;
    public boolean shouldDisplayLocation;
    public boolean shouldDisplayMap;
    public String showUseThisGroupon;
    public String subTotalFormattedAmount;
    public Ticket ticket;
    public String ticketAccount;
    public String ticketEntrance;
    public String ticketEvent;
    public String ticketRow;
    public String ticketSeat;
    public String ticketSection;
    public String totalFormattedAmount;
    public TravelBookingInfo travelBookingInfo;
    public String travelBookingUrl;
    public String travellerFirstName;
    public String travellerLastName;
    public VoucherIdInfo voucherIdInfo;
    public String websiteUrl;

    public MyGrouponItem()
    {
        dealOption = DefaultDealOption;
        deal = DefaultDeal;
        travelBookingInfo = DefaultTravelBookingInfo;
        localBookingInfo = DefaultLocalBookingInfo;
        merchant = DefaultMerchant;
        voucherIdInfo = DefaultVoucherIdInfo;
        ticket = DefaultTicket;
        order = DefaultOrder;
        division = DefaultDivision;
        option = DefaultOption;
        redeemerName = "";
        merchantRedeemedAt = null;
        barcodeImageUrl = "";
        externalVoucherUrl = "";
        printedAt = null;
        grouponNumber = "";
        showUseThisGroupon = "true";
        isAutoRefundEnabled = false;
        isAwaitingTicket = false;
        hasExternalVoucherUrl = true;
        shouldDisplayMap = true;
        shouldDisplayLocation = true;
        category = "";
        merchantUuid = "";
        dealOptionSpecificAttributeDelivery = false;
        isDealOptionSpecificAttributeTakeout = false;
        dealTitle = "";
        ticketEvent = "";
        ticketAccount = "";
        ticketEntrance = "";
        ticketSection = "";
        ticketRow = "";
        ticketSeat = "";
        redeemInstructions = "";
        websiteUrl = "";
        travelBookingUrl = "";
        travellerFirstName = "";
        travellerLastName = "";
        listDescriptionFromDetails = "";
        cash = "";
        billingInfoCardType = "";
        billingInfoCardNumber = "";
        billingInfoPaymentType = "";
        cnoOrSnText = "";
        serialNumber = "";
        dealOptionPriceAmount = 0;
        dealOptionValueAmount = 0;
        dealOptionValueCurrencyCode = "";
        isInventoryDeal = false;
        isBookableTravelDeal = false;
        isBooked = false;
        isMaintenance = false;
        divisionTimezoneOffsetInSeconds = 0;
        numOfNights = 0;
        hotelFormattedAmount = "";
        subTotalFormattedAmount = "";
        totalFormattedAmount = "";
        listDescriptions = "";
        isEditable = false;
        shipments = Collections.emptyList();
        redemptionLocations = Collections.emptyList();
    }

    public void afterJsonDeserializationPostProcessor()
    {
        dealOptionId = dealOption.id;
        title = dealOption.title;
        subTitle = dealOption.subTitle;
        bookable = dealOption.bookable;
        instructions = dealOption.instructions;
        redeemInstructions = dealOption.redeemInstructions;
        if (dealOption.schedulerOptions != null)
        {
            bookingType = dealOption.schedulerOptions.bookingType;
        }
        if (dealOption.specificAttributes != null && dealOption.specificAttributes.takeoutDelivery != null)
        {
            dealOptionSpecificAttributeDelivery = dealOption.specificAttributes.takeoutDelivery.delivery;
            isDealOptionSpecificAttributeTakeout = dealOption.specificAttributes.takeoutDelivery.takeout;
        }
        if (dealOption.details != null)
        {
            ArrayList arraylist = new ArrayList();
            for (Iterator iterator = dealOption.details.iterator(); iterator.hasNext(); arraylist.add(((Detail)iterator.next()).description)) { }
            listDescriptionFromDetails = Strings.join("<BR />", arraylist);
        }
        setRedemptionLocations(dealOption.redemptionLocations);
        if (dealOption.value != null)
        {
            dealOptionPriceAmount = dealOption.price.amount;
            dealOptionValueAmount = dealOption.value.amount;
            dealOptionValueCurrencyCode = dealOption.value.currencyCode;
        }
        dealId = deal.id;
        dealTitle = deal.title;
        largeImageUrl = deal.largeImageUrl;
        sidebarImageUrl = deal.sidebarImageUrl;
        isRewardDeal = deal.isRewardDeal;
        isInventoryDeal = deal.isInventoryDeal;
        isBookableTravelDeal = deal.isBookableTravelDeal;
        if (deal.division != null)
        {
            timezoneOffsetInSeconds = deal.division.timezoneOffsetInSeconds;
            timezoneIdentifier = deal.division.timezoneIdentifier;
        }
        reservationId = travelBookingInfo.reservation.id;
        dealTimezoneOffsetInSeconds = travelBookingInfo.reservation.dealTimezoneOffsetInSeconds;
        travellerFirstName = travelBookingInfo.reservation.travellerFirstName;
        travellerLastName = travelBookingInfo.reservation.travellerLastName;
        numOfNights = travelBookingInfo.reservation.numOfNights;
        hotelTimezoneIdentifier = travelBookingInfo.reservation.hotelTimezoneIdentifier;
        checkInDate = travelBookingInfo.reservation.checkInDate;
        checkOutDate = travelBookingInfo.reservation.checkOutDate;
        purchaseDate = travelBookingInfo.reservation.purchaseDate;
        purchaseStatusMarketRate = travelBookingInfo.reservation.purchaseStatus;
        hotelName = travelBookingInfo.reservation.hotelName;
        if (travelBookingInfo.reservation.images != null && travelBookingInfo.reservation.images.size() > 0)
        {
            url = ((Images)travelBookingInfo.reservation.images.get(0)).url;
        }
        isBooked = travelBookingInfo.onlineBooking.isBooked;
        isMaintenance = travelBookingInfo.onlineBooking.isMaintenance;
        travelBookingUrl = travelBookingInfo.onlineBooking.travelBookingUrl;
        hotelFormattedAmount = travelBookingInfo.breakdowns.pricing.hotelTax.formattedAmount;
        subTotalFormattedAmount = travelBookingInfo.breakdowns.pricing.subTotal.formattedAmount;
        totalFormattedAmount = travelBookingInfo.breakdowns.pricing.total.formattedAmount;
        Object obj = travelBookingInfo.breakdowns.tenders.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Tenders tenders = (Tenders)((Iterator) (obj)).next();
            if (Strings.equalsIgnoreCase(tenders.type, "cash"))
            {
                cash = tenders.amount.formattedAmount;
                billingInfoCardType = tenders.billingInfo.cardType;
                billingInfoCardNumber = tenders.billingInfo.cardNumber;
                billingInfoPaymentType = tenders.billingInfo.paymentType;
            }
            if (Strings.equalsIgnoreCase(tenders.type, "credit"))
            {
                credit = tenders.amount.formattedAmount;
            }
        } while (true);
        localBookingInfoStatus = localBookingInfo.reservation.status;
        status = order.status;
        statusMessage = order.statusMessage;
        isEditable = order.isEditable;
        orderId = order.id;
        merchantId = merchant.id;
        merchantUuid = merchant.uuid;
        name = merchant.name;
        websiteUrl = merchant.websiteUrl;
        if (Strings.notEmpty(division.timezoneIdentifier))
        {
            timezone = division.timezone;
            timezoneIdentifier = division.timezoneIdentifier;
            divisionTimezoneOffsetInSeconds = division.timezoneOffsetInSeconds;
        }
        cnoOrSnText = voucherIdInfo.cnoOrSnText;
        serialNumber = voucherIdInfo.serialNumber;
        ticketAccount = ticket.account;
        ticketEntrance = ticket.entrance;
        ticketEvent = ticket.event;
        ticketRow = ticket.row;
        ticketSeat = ticket.seat;
        ticketSection = ticket.section;
        obj = new ArrayList();
        if (option.details.size() > 0)
        {
            for (Iterator iterator1 = option.getDetails().iterator(); iterator1.hasNext(); ((ArrayList) (obj)).add(((Detail)iterator1.next()).description)) { }
        }
        listDescriptions = Strings.join("<BR />", ((Collection) (obj)));
        if (Strings.isEmpty(remoteId))
        {
            remoteId = reservationId;
        }
    }

    public ArrayList getRedemptionLocations()
    {
        if (redemptionLocationsList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (redemptionLocationsList == null)
        {
            redemptionLocationsList = new ArrayList(redemptionLocations);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return redemptionLocationsList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ArrayList getShipments()
    {
        if (shipmentsList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (shipmentsList == null)
        {
            shipmentsList = new ArrayList(shipments);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return shipmentsList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setRedemptionLocations(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Location)collection.next()).parentMyGrouponItem = this;
        }

        redemptionLocations = ((Collection) (obj));
    }

    public void setShipments(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Shipment)collection.next()).parentMyGrouponItem = this;
        }

        shipments = ((Collection) (obj));
    }

}
