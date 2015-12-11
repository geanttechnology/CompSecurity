// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            BillingAddress

public class DirectDebit extends BaseDataMapped
    implements Parcelable
{
    public static class Bban
    {

        public String accountNumber;
        public String cardNumberLastFour;
        public String routingNumber;
        public String tokenId;

        public Bban()
        {
        }

        public Bban(String s, String s1)
        {
            accountNumber = s;
            routingNumber = s1;
        }
    }

    public static class Iban
    {

        public String bic;
        public String cardNumberLastFour;
        public String ibanAccountNumber;
        public String ibanTokenId;

        public Iban()
        {
        }

        public Iban(String s)
        {
            ibanAccountNumber = s;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public DirectDebit createFromParcel(Parcel parcel)
        {
            return (DirectDebit)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/DirectDebit);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public DirectDebit[] newArray(int i)
        {
            return new DirectDebit[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String accountHolderName;
    public Bban bankAccountNumber;
    public BillingAddress billingAddress;
    public String dateOfBirth;
    public Iban internationalBankAccountNumber;

    public DirectDebit()
    {
    }

    public static String getMaskedNumber(String s, String s1, int i)
    {
        if (s == null && s == null)
        {
            return null;
        }
        if (s1 != null)
        {
            s = s1;
        } else
        {
            s = s.substring(s.length() - 5);
        }
        s1 = new StringBuilder();
        for (int j = 0; j <= i - s.length() - 1; j++)
        {
            s1.append("\u2022");
        }

        s1.append(s);
        return s1.toString();
    }

    public static boolean validateMod97Checksum(String s)
    {
label0:
        {
            boolean flag1 = true;
            boolean flag2 = false;
            int i = 0;
            int k = s.length();
            int j = 4;
            boolean flag;
            while (j < k + 4) 
            {
                char c = s.charAt(j % k);
                if (c >= '0' && c <= '9')
                {
                    i = (i * 10 + (c - 48)) % 97;
                } else
                {
                    flag = flag2;
                    if (c < 'A')
                    {
                        break label0;
                    }
                    flag = flag2;
                    if (c > 'Z')
                    {
                        break label0;
                    }
                    i = (i * 100 + ((c - 65) + 10)) % 97;
                }
                j++;
            }
            if (i == 1)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        return flag;
    }

    public boolean isIban()
    {
        return bankAccountNumber == null && internationalBankAccountNumber != null;
    }

}
