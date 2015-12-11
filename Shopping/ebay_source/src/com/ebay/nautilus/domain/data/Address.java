// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            NamedParameter

public class Address extends BaseDataMapped
    implements Parcelable, Serializable
{
    public static class AddressFields
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public String city;
        public String country;
        public transient String countryName;
        public String county;
        public String name;
        public String phone;
        public String postalCode;
        public String stateOrProvince;
        public String street1;
        public String street2;

        public static String getCityStatePostalString(String s, String s1, String s2, String s3, boolean flag)
        {
            StringBuilder stringbuilder = new StringBuilder();
            if (!TextUtils.isEmpty(s))
            {
                stringbuilder.append(s);
            }
            if (!TextUtils.isEmpty(s1))
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(", ");
                }
                stringbuilder.append(s1);
            }
            s = stringbuilder.toString();
            s1 = new StringBuilder();
            if (TextUtils.isEmpty(s3) || !Address.countryHasReversedPostalCode(s3)) goto _L2; else goto _L1
_L1:
            if (!TextUtils.isEmpty(s2))
            {
                s1.append(s2);
                s1.append(' ');
            }
            if (!TextUtils.isEmpty(s))
            {
                s1.append(s);
            }
_L4:
            if (!TextUtils.isEmpty(s3) && flag)
            {
                if (s1.length() > 0)
                {
                    s1.append(' ');
                }
                s1.append(s3);
            }
            return s1.toString();
_L2:
            if (!TextUtils.isEmpty(s))
            {
                s1.append(s);
                s1.append(' ');
            }
            if (!TextUtils.isEmpty(s2))
            {
                s1.append(s2);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private static final String htmlDecode(String s)
        {
            String s1 = s;
            if (!TextUtils.isEmpty(s))
            {
                s1 = Html.fromHtml(s).toString();
            }
            return s1;
        }

        public String getCity()
        {
            return htmlDecode(city);
        }

        public String getCityStatePostalString()
        {
            return getCityStatePostalString(getCity(), getStateOrProvince(), getPostalCode(), getCountry(), true);
        }

        public String getCountry()
        {
            if ("UK".equals(country))
            {
                return "GB";
            } else
            {
                return country;
            }
        }

        public String getCountryName()
        {
            return countryName;
        }

        public String getCounty()
        {
            return county;
        }

        public String getName()
        {
            return htmlDecode(name);
        }

        public String getPhone()
        {
            return phone;
        }

        public String getPostalCode()
        {
            if ("default".equals(postalCode))
            {
                return null;
            } else
            {
                return postalCode;
            }
        }

        public String getStateOrProvince()
        {
            if ("default".equals(stateOrProvince))
            {
                return null;
            } else
            {
                return stateOrProvince;
            }
        }

        public String getStreet1()
        {
            return htmlDecode(street1);
        }

        public String getStreet2()
        {
            return htmlDecode(street2);
        }

        public AddressFields()
        {
        }

        public AddressFields(AddressFields addressfields)
        {
            if (addressfields != null)
            {
                name = addressfields.getName();
                street1 = addressfields.getStreet1();
                street2 = addressfields.getStreet2();
                city = addressfields.getCity();
                stateOrProvince = addressfields.getStateOrProvince();
                postalCode = addressfields.getPostalCode();
                country = addressfields.getCountry();
                county = addressfields.getCounty();
                phone = addressfields.getPhone();
            }
        }

        public AddressFields(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
                String s7, String s8)
        {
            name = s;
            street1 = s1;
            street2 = s2;
            city = s3;
            stateOrProvince = s4;
            postalCode = s5;
            country = s6;
            county = s7;
            phone = s8;
        }
    }


    public static final String ADDRESS_TYPE_BILLING = "Billing";
    public static final String ADDRESS_TYPE_SHIPMENT_FROM = "Shipment_From";
    public static final String ADDRESS_TYPE_SHIPPING = "Shipping";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Address createFromParcel(Parcel parcel)
        {
            return (Address)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/Address);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Address[] newArray(int i)
        {
            return new Address[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final String EXTERNAL_IDENTIFIER_PREFIX = "eBay:";
    private static final long serialVersionUID = 1L;
    public AddressFields addressFields;
    private String addressId;
    public String addressOwner;
    public String addressStatus;
    public String addressType;
    private transient Map attributeMap;
    public List attributes;
    public Date creationTime;
    private String externalIdentifier;
    public Date lastModifiedTime;

    public Address()
    {
        addressFields = new AddressFields();
    }

    public Address(Address address)
    {
        if (address != null)
        {
            addressId = address.addressId;
            addressType = address.addressType;
            addressStatus = address.addressStatus;
            addressOwner = address.addressOwner;
            addressFields = new AddressFields(address.addressFields);
            getAttributeMap().putAll(address.getAttributeMap());
        }
    }

    public Address(String s, String s1, AddressFields addressfields)
    {
        addressId = s;
        addressType = s1;
        addressFields = new AddressFields(addressfields);
    }

    public static boolean countryHasReversedPostalCode(String s)
    {
        return s.equals("DE") || s.equals("FR") || s.equals("FI") || s.equals("DK") || s.equals("CZ") || s.equals("IS") || s.equals("DK") || s.equals("IT") || s.equals("NL") || s.equals("NO") || s.equals("PL") || s.equals("SK") || s.equals("SI") || s.equals("ES") || s.equals("SE") || s.equals("CH") || s.equals("TR") || s.equals("BE") || s.equals("AT");
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Address)
        {
            obj = (Address)obj;
            if (((Address) (obj)).addressFields != null && addressFields != null && TextUtils.equals(((Address) (obj)).addressFields.getName(), addressFields.getName()) && TextUtils.equals(((Address) (obj)).addressFields.getStreet1(), addressFields.getStreet1()) && TextUtils.equals(((Address) (obj)).addressFields.getStreet2(), addressFields.getStreet2()) && TextUtils.equals(((Address) (obj)).addressFields.getStateOrProvince(), addressFields.getStateOrProvince()) && TextUtils.equals(((Address) (obj)).addressFields.getCity(), addressFields.getCity()) && TextUtils.equals(((Address) (obj)).addressFields.getCountry(), addressFields.getCountry()) && TextUtils.equals(((Address) (obj)).addressFields.getCounty(), addressFields.getCounty()) && TextUtils.equals(((Address) (obj)).addressFields.getPostalCode(), addressFields.getPostalCode()) && TextUtils.equals(((Address) (obj)).addressFields.getPhone(), addressFields.getPhone()))
            {
                return true;
            }
        }
        return false;
    }

    public String getAddressId()
    {
        if (!TextUtils.isEmpty(externalIdentifier) && externalIdentifier.length() > "eBay:".length())
        {
            return externalIdentifier.substring("eBay:".length());
        } else
        {
            return addressId;
        }
    }

    public Map getAttributeMap()
    {
        if (attributeMap == null)
        {
            attributeMap = new HashMap();
            if (attributes != null)
            {
                NamedParameter.addParameterListToMap(attributes, attributeMap);
            }
        }
        return attributeMap;
    }

    public String getCreationTime()
    {
        if (creationTime == null)
        {
            return null;
        } else
        {
            return EbayDateUtils.formatIso8601DateTime(creationTime);
        }
    }

    public String getLastModifiedTime()
    {
        if (lastModifiedTime == null)
        {
            return null;
        } else
        {
            return EbayDateUtils.formatIso8601DateTime(lastModifiedTime);
        }
    }

    public double getLatitude()
    {
        double d;
        try
        {
            d = Double.parseDouble((String)getAttributeMap().get("Latitude"));
        }
        catch (NumberFormatException numberformatexception)
        {
            return 0.0D;
        }
        return d;
    }

    public double getLongitude()
    {
        double d;
        try
        {
            d = Double.parseDouble((String)getAttributeMap().get("Longitude"));
        }
        catch (NumberFormatException numberformatexception)
        {
            return 0.0D;
        }
        return d;
    }

    public String getPickupInstructions()
    {
        return (String)getAttributeMap().get("PickupInstructions");
    }

    public String getPickupStoreId()
    {
        return (String)getAttributeMap().get("LocationId");
    }

    public String getUrl()
    {
        return (String)getAttributeMap().get("InfoURL");
    }

    public boolean isDefault()
    {
        return "DEFAULT".equalsIgnoreCase(addressStatus) || "true".equals(getAttributeMap().get("ExternalIdentifierIsPrimaryAddress"));
    }

    public boolean isPOBox()
    {
        return "true".equals(getAttributeMap().get("IsPOBox")) || "true".equals(getAttributeMap().get("IsPackStation"));
    }

    public boolean isShipmentFrom()
    {
        return "Shipment_From".equals(addressType);
    }

    public boolean isShipping()
    {
        return "Shipping".equals(addressType);
    }

    public void setAddressId(String s)
    {
        addressId = s;
    }

    public void setCreationTime(String s)
        throws ParseException
    {
        creationTime = EbayDateUtils.parseIso8601DateTime(s);
    }

    public void setLastModifiedTime(String s)
        throws ParseException
    {
        lastModifiedTime = EbayDateUtils.parseIso8601DateTime(s);
    }

}
