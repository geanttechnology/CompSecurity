// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

// Referenced classes of package com.ebay.common.model:
//            UserDetail

public class PostalAddress
    implements Parcelable
{
    public static final class AddressUsage extends Enum
    {

        private static final AddressUsage $VALUES[];
        public static final AddressUsage kAddressUsageDefaultShipping;
        public static final AddressUsage kAddressUsageInvalid;
        public static final AddressUsage kAddressUsageShipping;
        public static final AddressUsage kAddressUsageUnknown;
        public final int id;

        public static AddressUsage enumFromID(int i)
        {
            AddressUsage aaddressusage[] = values();
            int k = aaddressusage.length;
            for (int j = 0; j < k; j++)
            {
                AddressUsage addressusage = aaddressusage[j];
                if (addressusage.id == i)
                {
                    return addressusage;
                }
            }

            return kAddressUsageUnknown;
        }

        public static AddressUsage valueOf(String s)
        {
            return (AddressUsage)Enum.valueOf(com/ebay/common/model/PostalAddress$AddressUsage, s);
        }

        public static AddressUsage[] values()
        {
            return (AddressUsage[])$VALUES.clone();
        }

        static 
        {
            kAddressUsageUnknown = new AddressUsage("kAddressUsageUnknown", 0, 0);
            kAddressUsageDefaultShipping = new AddressUsage("kAddressUsageDefaultShipping", 1, 1001);
            kAddressUsageInvalid = new AddressUsage("kAddressUsageInvalid", 2, 1002);
            kAddressUsageShipping = new AddressUsage("kAddressUsageShipping", 3, 1003);
            $VALUES = (new AddressUsage[] {
                kAddressUsageUnknown, kAddressUsageDefaultShipping, kAddressUsageInvalid, kAddressUsageShipping
            });
        }

        private AddressUsage(String s, int i)
        {
            super(s, i);
            id = 0;
        }

        private AddressUsage(String s, int i, int j)
        {
            super(s, i);
            id = j;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PostalAddress createFromParcel(Parcel parcel)
        {
            return new PostalAddress(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public PostalAddress[] newArray(int i)
        {
            return new PostalAddress[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String kAddressIDKey = "externalAddressID";
    public static final String kAddressUsageKey = "addressUsage";
    public static final String kCityKey = "cityName";
    public static final String kCompanyKey = "companyName";
    public static final String kCountryCodeKey = "countryCode";
    public static final String kCountryKey = "countryName";
    public static final String kFirstNameKey = "firstName";
    public static final String kFullNameKey = "name";
    public static final String kLastNameKey = "lastName";
    public static final String kPhoneKey = "phone";
    public static final String kStateKey = "stateOrProvince";
    public static final String kStreet1Key = "street1";
    public static final String kStreet2Key = "street2";
    public static final String kStreetKey = "street";
    public static final String kZipCodeKey = "postalCode";
    public String addressHash;
    public AddressUsage addressUsage;
    public String cityName;
    public String companyName;
    public String countryCode;
    public String countryName;
    public String externalAddressID;
    public String firstName;
    public String lastName;
    public String name;
    public int numberOfLines;
    public String phone;
    public String postalCode;
    public String stateOrProvince;
    public String street;
    public String street1;
    public String street2;

    public PostalAddress()
    {
        addressUsage = AddressUsage.kAddressUsageUnknown;
    }

    private PostalAddress(Parcel parcel)
    {
        addressUsage = AddressUsage.kAddressUsageUnknown;
        cityName = parcel.readString();
        countryCode = parcel.readString();
        countryName = parcel.readString();
        externalAddressID = parcel.readString();
        companyName = parcel.readString();
        firstName = parcel.readString();
        lastName = parcel.readString();
        name = parcel.readString();
        phone = parcel.readString();
        postalCode = parcel.readString();
        stateOrProvince = parcel.readString();
        street = parcel.readString();
        street1 = parcel.readString();
        street2 = parcel.readString();
        addressUsage = AddressUsage.valueOf(parcel.readString());
        numberOfLines = parcel.readInt();
    }


    public PostalAddress(UserDetail userdetail)
    {
        addressUsage = AddressUsage.kAddressUsageUnknown;
        set(userdetail);
    }

    public int describeContents()
    {
        return 0;
    }

    public String formattedAddress()
    {
        return formattedAddressWithCountry(false);
    }

    public String formattedAddressWithCountry(boolean flag)
    {
        numberOfLines = 0;
        String s1 = "";
        if (name != null)
        {
            s1 = (new StringBuilder()).append("").append(String.format("%s\n", new Object[] {
                name
            })).toString();
            numberOfLines = numberOfLines + 1;
        }
        String s = s1;
        if (street != null)
        {
            s = (new StringBuilder()).append(s1).append(String.format("%s\n", new Object[] {
                street
            })).toString();
            numberOfLines = numberOfLines + 1;
        }
        s1 = s;
        if (street1 != null)
        {
            s1 = (new StringBuilder()).append(s).append(String.format("%s\n", new Object[] {
                street1
            })).toString();
            numberOfLines = numberOfLines + 1;
        }
        s = s1;
        if (street2 != null)
        {
            s = (new StringBuilder()).append(s1).append(String.format("%s\n", new Object[] {
                street2
            })).toString();
            numberOfLines = numberOfLines + 1;
        }
        if (cityName != null || stateOrProvince != null || postalCode != null)
        {
            numberOfLines = numberOfLines + 1;
        }
        s1 = s;
        if (cityName != null)
        {
            s1 = (new StringBuilder()).append(s).append(String.format("%s", new Object[] {
                cityName
            })).toString();
        }
        s = s1;
        if (stateOrProvince != null)
        {
            s = (new StringBuilder()).append(s1).append(String.format(", %s", new Object[] {
                stateOrProvince
            })).toString();
        }
        s1 = s;
        if (postalCode != null)
        {
            s1 = (new StringBuilder()).append(s).append(String.format(" %s", new Object[] {
                postalCode
            })).toString();
        }
        s = s1;
        if (countryName != null)
        {
            s = s1;
            if (flag)
            {
                s = (new StringBuilder()).append(s1).append(String.format("\n%s", new Object[] {
                    countryName
                })).toString();
            }
        }
        return s;
    }

    public String formattedHTMLAddressWithCountry(boolean flag)
    {
        numberOfLines = 0;
        String s1 = (new StringBuilder()).append("").append("<html><body>").toString();
        String s = s1;
        if (name != null)
        {
            s = (new StringBuilder()).append(s1).append(String.format("%s<br>", new Object[] {
                name
            })).toString();
            numberOfLines = numberOfLines + 1;
        }
        s1 = s;
        if (street != null)
        {
            s1 = (new StringBuilder()).append(s).append(String.format("%s<br>", new Object[] {
                street
            })).toString();
            numberOfLines = numberOfLines + 1;
        }
        s = s1;
        if (street1 != null)
        {
            s = (new StringBuilder()).append(s1).append(String.format("%s<br>", new Object[] {
                street1
            })).toString();
            numberOfLines = numberOfLines + 1;
        }
        s1 = s;
        if (street2 != null)
        {
            s1 = (new StringBuilder()).append(s).append(String.format("%s<br>", new Object[] {
                street2
            })).toString();
            numberOfLines = numberOfLines + 1;
        }
        if (cityName != null || stateOrProvince != null || postalCode != null)
        {
            numberOfLines = numberOfLines + 1;
        }
        s = s1;
        if (cityName != null)
        {
            s = (new StringBuilder()).append(s1).append(String.format("%s", new Object[] {
                cityName
            })).toString();
        }
        s1 = s;
        if (stateOrProvince != null)
        {
            s1 = (new StringBuilder()).append(s).append(String.format(", %s", new Object[] {
                stateOrProvince
            })).toString();
        }
        s = s1;
        if (postalCode != null)
        {
            s = (new StringBuilder()).append(s1).append(String.format(" %s", new Object[] {
                postalCode
            })).toString();
        }
        s1 = s;
        if (countryName != null)
        {
            s1 = s;
            if (flag)
            {
                s1 = (new StringBuilder()).append(s).append(String.format("<br>%s", new Object[] {
                    countryName
                })).toString();
            }
        }
        return (new StringBuilder()).append(s1).append("</body></html>").toString();
    }

    public boolean hasRequiredFields()
    {
        return true;
    }

    public String hashForAddress()
    {
        return hashforString(formattedAddressWithCountry(true));
    }

    String hashforString(String s)
    {
        String s1;
        try
        {
            s1 = UUID.nameUUIDFromBytes(MessageDigest.getInstance("SHA-1").digest(s.getBytes())).toString();
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            Log.e("PostalAddress", nosuchalgorithmexception.toString());
            return s;
        }
        return s1;
    }

    public boolean isDefaultShippingAddress()
    {
        return addressUsage == AddressUsage.kAddressUsageDefaultShipping;
    }

    public int numberOfLines()
    {
        formattedAddress();
        return numberOfLines;
    }

    public void set(UserDetail userdetail)
    {
        companyName = userdetail.registrationAddress.companyName;
        countryCode = userdetail.registrationAddress.country;
        countryName = userdetail.registrationAddress.countryName;
        name = userdetail.registrationAddress.name;
        phone = userdetail.registrationAddress.phone;
        postalCode = userdetail.registrationAddress.postalCode;
        stateOrProvince = userdetail.registrationAddress.stateOrProvince;
        cityName = userdetail.registrationAddress.cityName;
        street = userdetail.registrationAddress.street;
        street1 = userdetail.registrationAddress.street1;
        street2 = userdetail.registrationAddress.street2;
    }

    public void setHasShippingDefault()
    {
        addressUsage = AddressUsage.kAddressUsageDefaultShipping;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(cityName);
        parcel.writeString(countryCode);
        parcel.writeString(countryName);
        parcel.writeString(externalAddressID);
        parcel.writeString(companyName);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(name);
        parcel.writeString(phone);
        parcel.writeString(postalCode);
        parcel.writeString(stateOrProvince);
        parcel.writeString(street);
        parcel.writeString(street1);
        parcel.writeString(street2);
        parcel.writeString(addressUsage.name());
        parcel.writeInt(numberOfLines);
    }

}
