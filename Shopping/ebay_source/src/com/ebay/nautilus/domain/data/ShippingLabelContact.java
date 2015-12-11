// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            Address

public class ShippingLabelContact
{
    public static class AdditionalData
    {

        public ArrayList entry;

        public AdditionalData()
        {
            entry = new ArrayList();
        }
    }

    public static class AdditionalData.EntryItem extends BaseDataMapped
    {

        public String key;
        public List value;

        public AdditionalData.EntryItem()
        {
            value = new ArrayList();
        }
    }

    public static final class ShippingAddressType extends Enum
    {

        private static final ShippingAddressType $VALUES[];
        public static final ShippingAddressType SHIP_FROM;
        public static final ShippingAddressType SHIP_TO;

        public static ShippingAddressType valueOf(String s)
        {
            return (ShippingAddressType)Enum.valueOf(com/ebay/nautilus/domain/data/ShippingLabelContact$ShippingAddressType, s);
        }

        public static ShippingAddressType[] values()
        {
            return (ShippingAddressType[])$VALUES.clone();
        }

        static 
        {
            SHIP_TO = new ShippingAddressType("SHIP_TO", 0);
            SHIP_FROM = new ShippingAddressType("SHIP_FROM", 1);
            $VALUES = (new ShippingAddressType[] {
                SHIP_TO, SHIP_FROM
            });
        }

        private ShippingAddressType(String s, int i)
        {
            super(s, i);
        }
    }

    public static class ShippingLocation
    {

        public Address address;
        public ShippingLocationType locationType;

        public ShippingLocation()
        {
        }
    }

    public static class ShippingLocation.Address
    {

        public String addressLine1;
        public String addressLine2;
        public String addressLine3;
        public String city;
        public String country;
        public String county;
        public String district;
        public String postalCode;
        public String stateOrProvince;

        public ShippingLocation.Address()
        {
        }
    }

    public static final class ShippingLocationType extends Enum
    {

        private static final ShippingLocationType $VALUES[];
        public static final ShippingLocationType BUSINESS;
        public static final ShippingLocationType LOCKER;
        public static final ShippingLocationType RESIDENTIAL;
        public static final ShippingLocationType STORE;
        public static final ShippingLocationType WAREHOUSE;

        public static ShippingLocationType valueOf(String s)
        {
            return (ShippingLocationType)Enum.valueOf(com/ebay/nautilus/domain/data/ShippingLabelContact$ShippingLocationType, s);
        }

        public static ShippingLocationType[] values()
        {
            return (ShippingLocationType[])$VALUES.clone();
        }

        static 
        {
            RESIDENTIAL = new ShippingLocationType("RESIDENTIAL", 0);
            BUSINESS = new ShippingLocationType("BUSINESS", 1);
            WAREHOUSE = new ShippingLocationType("WAREHOUSE", 2);
            STORE = new ShippingLocationType("STORE", 3);
            LOCKER = new ShippingLocationType("LOCKER", 4);
            $VALUES = (new ShippingLocationType[] {
                RESIDENTIAL, BUSINESS, WAREHOUSE, STORE, LOCKER
            });
        }

        private ShippingLocationType(String s, int i)
        {
            super(s, i);
        }
    }


    public AdditionalData additionalData;
    public String companyName;
    public String email;
    public String fax;
    public String fullName;
    public ShippingLocation location;
    public String phone;
    public String phone2;

    public ShippingLabelContact()
    {
    }

    public void updateContact(com.ebay.nautilus.domain.data.Address address)
    {
        email = null;
        fullName = address.addressFields.getName();
        location.locationType = ShippingLocationType.RESIDENTIAL;
        location.address.addressLine1 = address.addressFields.getStreet1();
        ShippingLocation.Address address1 = location.address;
        String s;
        if (TextUtils.isEmpty(address.addressFields.getStreet2()))
        {
            s = "";
        } else
        {
            s = address.addressFields.getStreet2();
        }
        address1.addressLine2 = s;
        location.address.city = address.addressFields.getCity();
        location.address.country = address.addressFields.getCountry();
        location.address.county = address.addressFields.getCounty();
        location.address.postalCode = address.addressFields.getPostalCode();
        location.address.stateOrProvince = address.addressFields.getStateOrProvince();
        phone = address.addressFields.getPhone();
    }
}
