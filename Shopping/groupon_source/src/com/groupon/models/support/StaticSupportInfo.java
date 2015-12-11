// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.support;

import java.util.Arrays;
import java.util.List;

public class StaticSupportInfo extends Enum
{
    public static class CurrencySettings
    {

        public String currencySymbol;
        public String decimalSeparator;
        public String groupingSeparator;
        public boolean isCurrencyFirst;
        public boolean isCurrencyFromAmountSeparated;
        public boolean prefixNegativeSymbol;

        public CurrencySettings()
        {
            isCurrencyFirst = true;
        }
    }


    private static final StaticSupportInfo $VALUES[];
    public static final StaticSupportInfo AE;
    public static final StaticSupportInfo AR;
    public static final StaticSupportInfo AT;
    public static final StaticSupportInfo AU;
    public static final StaticSupportInfo BE;
    public static final StaticSupportInfo BR;
    public static final StaticSupportInfo CA;
    public static final StaticSupportInfo CA_EU;
    public static final StaticSupportInfo CH;
    public static final StaticSupportInfo CL;
    public static final StaticSupportInfo CO;
    public static final StaticSupportInfo DE;
    public static final StaticSupportInfo DK;
    public static final StaticSupportInfo ES;
    public static final StaticSupportInfo FI;
    public static final StaticSupportInfo FR;
    public static final StaticSupportInfo HK;
    public static final StaticSupportInfo IE;
    public static final StaticSupportInfo IL;
    public static final StaticSupportInfo IN;
    public static final StaticSupportInfo IT;
    public static final StaticSupportInfo JP;
    public static final StaticSupportInfo MX;
    public static final StaticSupportInfo MY;
    public static final StaticSupportInfo NL;
    public static final StaticSupportInfo NO;
    public static final StaticSupportInfo NZ;
    public static final StaticSupportInfo PE;
    public static final StaticSupportInfo PL;
    public static final StaticSupportInfo PT;
    public static final StaticSupportInfo RU;
    public static final StaticSupportInfo SE;
    public static final StaticSupportInfo SG;
    public static final StaticSupportInfo UK;
    public static final StaticSupportInfo US;
    public static final StaticSupportInfo ZA;
    public String acceptedCreditCards;
    public CurrencySettings currencySettings;
    public String dateFormat;
    public String defaultDivisionID;
    public boolean numberBeforeStreet;
    public boolean postalCodeAfterCity;
    public List shippingAddress;
    public List shippingAddressMulti;
    public String timeFormat;

    private StaticSupportInfo(String s, int i)
    {
        super(s, i);
        numberBeforeStreet = true;
        postalCodeAfterCity = true;
    }


    public static StaticSupportInfo valueOf(String s)
    {
        return (StaticSupportInfo)Enum.valueOf(com/groupon/models/support/StaticSupportInfo, s);
    }

    public static StaticSupportInfo[] values()
    {
        return (StaticSupportInfo[])$VALUES.clone();
    }

    static 
    {
        AR = new StaticSupportInfo("AR", 0) {

            
            {
                defaultDivisionID = "buenos-aires";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "KK=mm aa";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "pid", "phoneNumber", "state", "additionalInformationAR", "shippingStreet", "requiredStreetNumber", "postalCode"
                });
                shippingAddressMulti = null;
            }
        };
        AE = new StaticSupportInfo("AE", 1) {

            
            {
                defaultDivisionID = "dubai";
                numberBeforeStreet = true;
                postalCodeAfterCity = true;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingSurname", "phoneNumber", "requiredStreetNumber", "additionalInformationAE", "shippingStreet", "district", "city"
                });
                shippingAddressMulti = null;
            }
        };
        AT = new StaticSupportInfo("AT", 2) {

            
            {
                defaultDivisionID = "wien";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "shippingStreet", "requiredStreetNumber", "postalCode", "city", "phoneNumber"
                });
            }
        };
        AU = new StaticSupportInfo("AU", 3) {

            
            {
                defaultDivisionID = "sydney";
                numberBeforeStreet = true;
                postalCodeAfterCity = true;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "KK:mm aa";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingTitle", "shippingFirstName", "shippingLastName", "requiredStreetNumber", "shippingStreet", "additionalInformationAU_NZ_PH_NO_FI", "city", "state", "postalCode", "phoneNumber"
                });
            }
        };
        BE = new StaticSupportInfo("BE", 4) {

            
            {
                defaultDivisionID = "bruxelles";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "phoneNumber", "shippingStreet", "requiredStreetNumber", "additionalInformationAddressLine2Optional", "postalCode", "city", "company"
                });
            }
        };
        BR = new StaticSupportInfo("BR", 5) {

            
            {
                defaultDivisionID = "brasilia";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "pid", "shippingStreet", "requiredStreetNumber", "additionalInformationAddressLine2Optional", "postalCode", "district", "city", "state", 
                    "phoneNumber"
                });
            }
        };
        CA = new StaticSupportInfo("CA", 6) {

            
            {
                defaultDivisionID = "greater-toronto-area";
                numberBeforeStreet = true;
                postalCodeAfterCity = true;
                currencySettings = new _cls1();
                dateFormat = "M/dd/yy";
                timeFormat = "KK:mm aa";
                shippingAddress = Arrays.asList(new String[] {
                    "firstLastName", "shippingAddress1", "shippingAddress2", "shippingCity", "shippingPostalCode"
                });
                shippingAddressMulti = Arrays.asList(new String[] {
                    "firstLastName", "Address1", "Address2", "shippingCity", "shippingPostalCode"
                });
            }
        };
        CA_EU = new StaticSupportInfo("CA_EU", 7) {

            
            {
                defaultDivisionID = "quebec";
                numberBeforeStreet = true;
                postalCodeAfterCity = true;
                currencySettings = new _cls1();
                dateFormat = "M/dd/yy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "requiredStreetNumber", "shippingStreet", "postalCode", "city", "state", "additionalInformationCA_EU_CH_DE_ZA", "phoneNumber"
                });
            }
        };
        CH = new StaticSupportInfo("CH", 8) {

            
            {
                defaultDivisionID = "zuerich";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd.MM.yyyy";
                timeFormat = "KK:mm aa";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "requiredStreetNumber", "shippingStreet", "postalCode", "city", "additionalInformationCA_EU_CH_DE_ZA", "phoneNumber"
                });
            }
        };
        CL = new StaticSupportInfo("CL", 9) {

            
            {
                defaultDivisionID = "santiago";
                numberBeforeStreet = false;
                postalCodeAfterCity = true;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "firstLastNameLatam", "shippingIdNumberCL", "shippingPhone", "shippingAddress1Latam", "shippingNumber", "shippingApartment", "additionalInformationLatam"
                });
            }
        };
        CO = new StaticSupportInfo("CO", 10) {

            
            {
                defaultDivisionID = "bogota";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "KK:mm aa";
                shippingAddress = Arrays.asList(new String[] {
                    "firstLastNameLatam", "shippingIdNumberCO", "shippingPhone", "shippingAddress1Latam", "shippingNumber", "shippingApartment", "additionalInformationLatam"
                });
            }
        };
        DE = new StaticSupportInfo("DE", 11) {

            
            {
                defaultDivisionID = "berlin";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingTitle", "shippingFirstName", "shippingLastName", "company", "shippingStreet", "requiredStreetNumber", "postalCode", "city", "phoneNumber", "additionalInformationCA_EU_CH_DE_ZA"
                });
            }
        };
        DK = new StaticSupportInfo("DK", 12) {

            
            {
                defaultDivisionID = "kobenhavn";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "requiredStreetNumber", "shippingStreet", "additionalInformationAddressLine2Optional", "city", "postalCode", "phoneNumber"
                });
            }
        };
        ES = new StaticSupportInfo("ES", 13) {

            
            {
                defaultDivisionID = "madrid";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "shippingStreet", "requiredStreetNumber", "additionalInformationES", "postalCode", "city", "state", "vat", "phoneNumber"
                });
            }
        };
        FI = new StaticSupportInfo("FI", 14) {

            
            {
                defaultDivisionID = "helsinki";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingTitle", "shippingFirstName", "shippingLastName", "shippingStreet", "requiredStreetNumber", "additionalInformationAU_NZ_PH_NO_FI", "postalCode", "city", "phoneNumber"
                });
            }
        };
        FR = new StaticSupportInfo("FR", 15) {

            
            {
                defaultDivisionID = "paris";
                numberBeforeStreet = true;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "requiredStreetNumber", "shippingStreet", "postalCode", "city", "additionalInformationFR", "phoneNumber"
                });
            }
        };
        HK = new StaticSupportInfo("HK", 16) {

            
            {
                defaultDivisionID = "hongkong";
                numberBeforeStreet = true;
                postalCodeAfterCity = true;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "KK:mm aa";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "requiredStreetNumber", "shippingStreet", "city", "postalCodeOptional", "district", "phoneNumber", "additionalInformationOptional"
                });
            }
        };
        IE = new StaticSupportInfo("IE", 17) {

            
            {
                defaultDivisionID = "dublin";
                numberBeforeStreet = true;
                postalCodeAfterCity = true;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingTitle", "shippingFirstName", "shippingLastName", "requiredStreetNumber", "shippingStreet", "additionalInformationAddressLine2Optional", "city", "postalCodeOptional", "phoneNumber"
                });
            }
        };
        IL = new StaticSupportInfo("IL", 18) {

            
            {
                defaultDivisionID = "jerusalem-iw";
                numberBeforeStreet = true;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "company", "shippingStreet", "requiredStreetNumber", "additionalInformationIL", "city", "postalCode", "phoneNumber"
                });
            }
        };
        IN = new StaticSupportInfo("IN", 19) {

            
            {
                defaultDivisionID = "kolkata";
                numberBeforeStreet = true;
                postalCodeAfterCity = true;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingSurname", "additionalInformationIN", "city", "state", "pinCode", "phoneNumber"
                });
            }
        };
        IT = new StaticSupportInfo("IT", 20) {

            
            {
                defaultDivisionID = "roma";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "shippingStreet", "requiredStreetNumber", "additionalInformationAddressLine2Optional", "postalCode", "city", "state", "vat", "phoneNumber"
                });
            }
        };
        MX = new StaticSupportInfo("MX", 21) {

            
            {
                defaultDivisionID = "ciudad-de-mexico";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "KK:mm aa";
                shippingAddress = Arrays.asList(new String[] {
                    "firstLastNameLatam", "shippingIdNumberMX", "shippingPhone", "shippingCellPhone", "postalCodeLatam", "shippingAddress1Latam", "shippingNumber", "shippingApartment", "additionalInformationLatam"
                });
            }
        };
        MY = new StaticSupportInfo("MY", 22) {

            
            {
                defaultDivisionID = "national-deal";
                numberBeforeStreet = true;
                postalCodeAfterCity = true;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "KK:mm aa";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "additionalInformationMY", "city", "state", "postalCode", "phoneNumber"
                });
            }
        };
        NL = new StaticSupportInfo("NL", 23) {

            
            {
                defaultDivisionID = "amsterdam";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "phoneNumber", "shippingStreet", "requiredStreetNumber", "additionalInformationAddressLine2Optional", "postalCode", "city", "company"
                });
            }
        };
        NO = new StaticSupportInfo("NO", 24) {

            
            {
                defaultDivisionID = "oslo";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "shippingStreet", "requiredStreetNumber", "postalCode", "city", "phoneNumber", "additionalInformationAU_NZ_PH_NO_FI"
                });
            }
        };
        NZ = new StaticSupportInfo("NZ", 25) {

            
            {
                defaultDivisionID = "wellington";
                numberBeforeStreet = true;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "KK:mm aa";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingTitle", "shippingFirstName", "shippingLastName", "shippingStreet", "requiredStreetNumber", "additionalInformationAU_NZ_PH_NO_FI", "postalCode", "city", "phoneNumber"
                });
            }
        };
        PE = new StaticSupportInfo("PE", 26) {

            
            {
                defaultDivisionID = "lima";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "shippingStreet", "requiredStreetNumber", "additionalInformationOptional", "district", "city", "phoneNumber"
                });
            }
        };
        PL = new StaticSupportInfo("PL", 27) {

            
            {
                defaultDivisionID = "warszawa";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "shippingStreet", "requiredStreetNumber", "additionalInformationAddressLine2Optional", "postalCode", "city", "phoneNumber", "vatOptional", "company"
                });
            }
        };
        PT = new StaticSupportInfo("PT", 28) {

            
            {
                defaultDivisionID = "lisboa";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "yyyy/MM/dd";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "shippingStreet", "requiredStreetNumber", "additionalInformationAddressLine2", "postalCode", "city", "state", "vat", "phoneNumber"
                });
            }
        };
        RU = new StaticSupportInfo("RU", 29) {

            
            {
                defaultDivisionID = "moscow";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
            }
        };
        SE = new StaticSupportInfo("SE", 30) {

            
            {
                defaultDivisionID = "stockholm";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "shippingStreet", "requiredStreetNumber", "additionalInformationAddressLine2Optional", "city", "postalCode", "phoneNumber"
                });
            }
        };
        SG = new StaticSupportInfo("SG", 31) {

            
            {
                defaultDivisionID = "singapore";
                numberBeforeStreet = true;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "KK:mm aa";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "shippingStreet", "requiredStreetNumber", "additionalInformationSG", "postalCode", "phoneNumber"
                });
            }
        };
        UK = new StaticSupportInfo("UK", 32) {

            
            {
                defaultDivisionID = "london";
                numberBeforeStreet = true;
                postalCodeAfterCity = true;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingTitle", "shippingFirstName", "shippingLastName", "requiredStreetNumber", "shippingStreet", "additionalInformationAddressLine2Optional", "city", "postalCode", "phoneNumber"
                });
            }
        };
        US = new StaticSupportInfo("US", 33) {

            
            {
                defaultDivisionID = "chicago";
                numberBeforeStreet = true;
                postalCodeAfterCity = true;
                acceptedCreditCards = "Visa, Mastercard, Amex, Discover";
                currencySettings = new _cls1();
                dateFormat = "M/dd/yy";
                timeFormat = "KK:mm aa";
                shippingAddress = Arrays.asList(new String[] {
                    "firstLastName", "shippingAddress1", "shippingAddress2", "shippingCity", "shippingPostalCode"
                });
                shippingAddressMulti = Arrays.asList(new String[] {
                    "firstLastName", "Address1", "Address2", "shippingCity", "shippingPostalCode"
                });
            }
        };
        ZA = new StaticSupportInfo("ZA", 34) {

            
            {
                defaultDivisionID = "cape-town";
                numberBeforeStreet = true;
                postalCodeAfterCity = true;
                currencySettings = new _cls1();
                dateFormat = "dd/MM/yyyy";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingFirstName", "shippingLastName", "shippingStreet", "requiredStreetNumber", "city", "district", "postalCode", "phoneNumber", "additionalInformationCA_EU_CH_DE_ZA"
                });
            }
        };
        JP = new StaticSupportInfo("JP", 35) {

            
            {
                defaultDivisionID = "3";
                numberBeforeStreet = false;
                postalCodeAfterCity = false;
                currencySettings = new _cls1();
                dateFormat = "yyyy/MM/dd";
                timeFormat = "HH:mm";
                shippingAddress = Arrays.asList(new String[] {
                    "shippingLastNameJP", "shippingFirstNameJP", "shippingPostalCodeJP", "shippingCityJP", "shippingAddress1JP", "shippingAddress2JP", "shippingPhoneJP"
                });
            }
        };
        $VALUES = (new StaticSupportInfo[] {
            AR, AE, AT, AU, BE, BR, CA, CA_EU, CH, CL, 
            CO, DE, DK, ES, FI, FR, HK, IE, IL, IN, 
            IT, MX, MY, NL, NO, NZ, PE, PL, PT, RU, 
            SE, SG, UK, US, ZA, JP
        });
    }

    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$1$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls1 this$0;

            
            {
                this$0 = _cls1.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ".";
                decimalSeparator = ",";
                currencySymbol = "$";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$10$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls10 this$0;

            
            {
                this$0 = _cls10.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ".";
                decimalSeparator = ",";
                currencySymbol = "$";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$11$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls11 this$0;

            
            {
                this$0 = _cls11.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ".";
                decimalSeparator = ",";
                currencySymbol = "$";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$12$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls12 this$0;

            
            {
                this$0 = _cls12.this;
                super();
                isCurrencyFirst = false;
                groupingSeparator = ".";
                decimalSeparator = ",";
                currencySymbol = "\u20AC";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$13$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls13 this$0;

            
            {
                this$0 = _cls13.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ".";
                decimalSeparator = ",";
                currencySymbol = "kr.";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$14$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls14 this$0;

            
            {
                this$0 = _cls14.this;
                super();
                isCurrencyFirst = false;
                groupingSeparator = ".";
                decimalSeparator = ",";
                currencySymbol = "\u20AC";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$15$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls15 this$0;

            
            {
                this$0 = _cls15.this;
                super();
                isCurrencyFirst = false;
                groupingSeparator = " ";
                decimalSeparator = ",";
                currencySymbol = "\u20AC";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$16$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls16 this$0;

            
            {
                this$0 = _cls16.this;
                super();
                isCurrencyFirst = false;
                groupingSeparator = " ";
                decimalSeparator = ",";
                currencySymbol = "\u20AC";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$17$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls17 this$0;

            
            {
                this$0 = _cls17.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "HK$";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$18$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls18 this$0;

            
            {
                this$0 = _cls18.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "\u20AC";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$19$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls19 this$0;

            
            {
                this$0 = _cls19.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "\u20AA";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$2$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls2 this$0;

            
            {
                this$0 = _cls2.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "AED";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$20$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls20 this$0;

            
            {
                this$0 = _cls20.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "Rs.";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$21$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls21 this$0;

            
            {
                this$0 = _cls21.this;
                super();
                isCurrencyFirst = false;
                groupingSeparator = " ";
                decimalSeparator = ",";
                currencySymbol = "\u20AC";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$22$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls22 this$0;

            
            {
                this$0 = _cls22.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "$";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$23$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls23 this$0;

            
            {
                this$0 = _cls23.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "RM";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$24$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls24 this$0;

            
            {
                this$0 = _cls24.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ".";
                decimalSeparator = ",";
                currencySymbol = "\u20AC";
                isCurrencyFromAmountSeparated = true;
                prefixNegativeSymbol = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$25$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls25 this$0;

            
            {
                this$0 = _cls25.this;
                super();
                isCurrencyFirst = false;
                groupingSeparator = " ";
                decimalSeparator = ",";
                currencySymbol = "kr";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$26$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls26 this$0;

            
            {
                this$0 = _cls26.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "$";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$27$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls27 this$0;

            
            {
                this$0 = _cls27.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ".";
                decimalSeparator = ",";
                currencySymbol = "S/.";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$28$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls28 this$0;

            
            {
                this$0 = _cls28.this;
                super();
                isCurrencyFirst = false;
                groupingSeparator = " ";
                decimalSeparator = ".";
                currencySymbol = "z\u0142";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$29$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls29 this$0;

            
            {
                this$0 = _cls29.this;
                super();
                isCurrencyFirst = false;
                groupingSeparator = " ";
                decimalSeparator = ",";
                currencySymbol = "\u20AC";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$3$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls3 this$0;

            
            {
                this$0 = _cls3.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ".";
                decimalSeparator = ",";
                currencySymbol = "\u20AC";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$30$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls30 this$0;

            
            {
                this$0 = _cls30.this;
                super();
                isCurrencyFirst = false;
                groupingSeparator = " ";
                decimalSeparator = ",";
                currencySymbol = "\u0440\u0443\u0431";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$31$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls31 this$0;

            
            {
                this$0 = _cls31.this;
                super();
                isCurrencyFirst = false;
                groupingSeparator = " ";
                decimalSeparator = ",";
                currencySymbol = "kr";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$32$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls32 this$0;

            
            {
                this$0 = _cls32.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "S$";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$33$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls33 this$0;

            
            {
                this$0 = _cls33.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "\243";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$34$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls34 this$0;

            
            {
                this$0 = _cls34.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "$";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$35$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls35 this$0;

            
            {
                this$0 = _cls35.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "R";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$36$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls36 this$0;

            
            {
                this$0 = _cls36.this;
                super();
                isCurrencyFirst = false;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "\u5186";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$4$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls4 this$0;

            
            {
                this$0 = _cls4.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "$";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$5$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls5 this$0;

            
            {
                this$0 = _cls5.this;
                super();
                isCurrencyFirst = false;
                groupingSeparator = ".";
                decimalSeparator = ",";
                currencySymbol = "\u20AC";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$6$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls6 this$0;

            
            {
                this$0 = _cls6.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ".";
                decimalSeparator = ",";
                currencySymbol = "R$";
                isCurrencyFromAmountSeparated = true;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$7$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls7 this$0;

            
            {
                this$0 = _cls7.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = ",";
                decimalSeparator = ".";
                currencySymbol = "C$";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$8$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls8 this$0;

            
            {
                this$0 = _cls8.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = " ";
                decimalSeparator = ".";
                currencySymbol = "C$";
                isCurrencyFromAmountSeparated = false;
            }
    }


    // Unreferenced inner class com/groupon/models/support/StaticSupportInfo$9$1

/* anonymous class */
    class _cls1 extends CurrencySettings
    {

        final _cls9 this$0;

            
            {
                this$0 = _cls9.this;
                super();
                isCurrencyFirst = true;
                groupingSeparator = "'";
                decimalSeparator = ".";
                currencySymbol = "CHF";
                isCurrencyFromAmountSeparated = true;
            }
    }

}
