// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.appcontext;


// Referenced classes of package com.amazon.mobile.mash.appcontext:
//            CapabilityManager

public abstract class Capability extends Enum
{

    private static final Capability $VALUES[];
    public static final Capability AIV_PLAYBACK;
    public static final Capability APPSTORE;
    public static final Capability APP_NAV_MENU;
    public static final Capability ENFORCE_PARENTAL_CONTROLS;
    public static final Capability PDF_VIEWER;
    public static final Capability SHOW_ADS_BROWSER;
    public static final Capability SHOW_AMAZON_POINTS;
    public static final Capability SHOW_CARD_SCANNER_CREDIT;
    public static final Capability SHOW_CONTACT_PICKER;
    public static final Capability SHOW_DELIVERY_DESTINATION_PICKER;
    public static final Capability SHOW_NOTIFICATION_SETTINGS;
    public static final Capability SMILE;
    private int mCapabilityId;
    private Boolean mIsAvailable;

    private Capability(String s, int i, int j)
    {
        super(s, i);
        mIsAvailable = null;
        mCapabilityId = j;
    }


    public static void init(CapabilityManager capabilitymanager)
    {
        Capability acapability[] = values();
        int j = acapability.length;
        for (int i = 0; i < j; i++)
        {
            acapability[i].initAvailability(capabilitymanager);
        }

    }

    public static Capability valueOf(String s)
    {
        return (Capability)Enum.valueOf(com/amazon/mobile/mash/appcontext/Capability, s);
    }

    public static Capability[] values()
    {
        return (Capability[])$VALUES.clone();
    }

    public int getCapabilityId()
    {
        return mCapabilityId;
    }

    protected abstract void initAvailability(CapabilityManager capabilitymanager);

    public boolean isAvailable()
    {
        if (mIsAvailable == null)
        {
            throw new RuntimeException("Should call Capability.init(CapabilityManager) before calling this method.");
        } else
        {
            return mIsAvailable.booleanValue();
        }
    }

    protected void setIsAvailable(boolean flag)
    {
        mIsAvailable = Boolean.valueOf(flag);
    }

    static 
    {
        SHOW_CONTACT_PICKER = new Capability("SHOW_CONTACT_PICKER", 0, 0) {

            protected void initAvailability(CapabilityManager capabilitymanager)
            {
                setIsAvailable(capabilitymanager.isAvailableShowContactPicker());
            }

        };
        SHOW_AMAZON_POINTS = new Capability("SHOW_AMAZON_POINTS", 1, 1) {

            protected void initAvailability(CapabilityManager capabilitymanager)
            {
                setIsAvailable(capabilitymanager.isAvailableShowAmazonPoints());
            }

        };
        SHOW_DELIVERY_DESTINATION_PICKER = new Capability("SHOW_DELIVERY_DESTINATION_PICKER", 2, 2) {

            protected void initAvailability(CapabilityManager capabilitymanager)
            {
                setIsAvailable(capabilitymanager.isAvailableShowDeliveryDestinationPicker());
            }

        };
        APP_NAV_MENU = new Capability("APP_NAV_MENU", 3, 3) {

            protected void initAvailability(CapabilityManager capabilitymanager)
            {
                setIsAvailable(capabilitymanager.isAvailableAppNavMenu());
            }

        };
        SHOW_NOTIFICATION_SETTINGS = new Capability("SHOW_NOTIFICATION_SETTINGS", 4, 4) {

            protected void initAvailability(CapabilityManager capabilitymanager)
            {
                setIsAvailable(capabilitymanager.isAvailableShowNotificationSettings());
            }

        };
        ENFORCE_PARENTAL_CONTROLS = new Capability("ENFORCE_PARENTAL_CONTROLS", 5, 5) {

            protected void initAvailability(CapabilityManager capabilitymanager)
            {
                setIsAvailable(capabilitymanager.isAvailableEnforceParentalControls());
            }

        };
        AIV_PLAYBACK = new Capability("AIV_PLAYBACK", 6, 6) {

            protected void initAvailability(CapabilityManager capabilitymanager)
            {
                setIsAvailable(capabilitymanager.isAvailableAivPlayback());
            }

        };
        SHOW_ADS_BROWSER = new Capability("SHOW_ADS_BROWSER", 7, 7) {

            protected void initAvailability(CapabilityManager capabilitymanager)
            {
                setIsAvailable(capabilitymanager.isAvailableShowAdsBrowser());
            }

        };
        SHOW_CARD_SCANNER_CREDIT = new Capability("SHOW_CARD_SCANNER_CREDIT", 8, 8) {

            protected void initAvailability(CapabilityManager capabilitymanager)
            {
                setIsAvailable(capabilitymanager.isAvailableShowCardScannerCredit());
            }

        };
        APPSTORE = new Capability("APPSTORE", 9, 13) {

            protected void initAvailability(CapabilityManager capabilitymanager)
            {
                setIsAvailable(capabilitymanager.isAvailableAppstore());
            }

        };
        SMILE = new Capability("SMILE", 10, 15) {

            protected void initAvailability(CapabilityManager capabilitymanager)
            {
                setIsAvailable(capabilitymanager.isAvailableSmile());
            }

        };
        PDF_VIEWER = new Capability("PDF_VIEWER", 11, 18) {

            protected void initAvailability(CapabilityManager capabilitymanager)
            {
                setIsAvailable(capabilitymanager.isAvailablePdfViewer());
            }

        };
        $VALUES = (new Capability[] {
            SHOW_CONTACT_PICKER, SHOW_AMAZON_POINTS, SHOW_DELIVERY_DESTINATION_PICKER, APP_NAV_MENU, SHOW_NOTIFICATION_SETTINGS, ENFORCE_PARENTAL_CONTROLS, AIV_PLAYBACK, SHOW_ADS_BROWSER, SHOW_CARD_SCANNER_CREDIT, APPSTORE, 
            SMILE, PDF_VIEWER
        });
    }
}
