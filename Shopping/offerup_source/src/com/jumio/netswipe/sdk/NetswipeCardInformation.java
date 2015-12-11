// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netswipe.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import com.jumio.netswipe.sdk.enums.CreditCardType;
import java.util.Arrays;
import java.util.HashMap;
import jumiomobile.bh;
import jumiomobile.cx;

public class NetswipeCardInformation
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new cx();
    public char cardAccountNumber[];
    public boolean cardAccountNumberValid;
    public char cardCvvCode[];
    protected char cardExpiryDate[];
    public char cardExpiryDateMonth[];
    public char cardExpiryDateYear[];
    public char cardHolderName[];
    public char cardNumber[];
    public char cardNumberGrouped[];
    public boolean cardNumberManuallyEntered;
    public char cardNumberMasked[];
    public char cardSortCode[];
    public boolean cardSortCodeValid;
    public CreditCardType cardType;
    public HashMap customFields;
    public String encryptedAdyenString;
    public String nameToCompare;

    public NetswipeCardInformation()
    {
        cardNumberManuallyEntered = false;
        cardSortCodeValid = false;
        cardAccountNumberValid = false;
        cardType = CreditCardType.UNKNOWN;
        customFields = new HashMap();
    }

    public NetswipeCardInformation(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        cardNumberManuallyEntered = false;
        cardSortCodeValid = false;
        cardAccountNumberValid = false;
        cardType = CreditCardType.UNKNOWN;
        customFields = new HashMap();
        cardNumber = new char[parcel.readInt()];
        parcel.readCharArray(cardNumber);
        cardNumberGrouped = new char[parcel.readInt()];
        parcel.readCharArray(cardNumberGrouped);
        cardNumberMasked = new char[parcel.readInt()];
        parcel.readCharArray(cardNumberMasked);
        cardHolderName = new char[parcel.readInt()];
        parcel.readCharArray(cardHolderName);
        cardSortCode = new char[parcel.readInt()];
        parcel.readCharArray(cardSortCode);
        cardAccountNumber = new char[parcel.readInt()];
        parcel.readCharArray(cardAccountNumber);
        cardType = (CreditCardType)parcel.readSerializable();
        cardExpiryDateMonth = new char[parcel.readInt()];
        parcel.readCharArray(cardExpiryDateMonth);
        cardExpiryDateYear = new char[parcel.readInt()];
        parcel.readCharArray(cardExpiryDateYear);
        cardCvvCode = new char[parcel.readInt()];
        parcel.readCharArray(cardCvvCode);
        customFields = (HashMap)parcel.readSerializable();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cardNumberManuallyEntered = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cardAccountNumberValid = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        cardSortCodeValid = flag;
        nameToCompare = parcel.readString();
        encryptedAdyenString = parcel.readString();
    }

    public static char[] copyField(char ac[])
    {
        if (ac != null)
        {
            return Arrays.copyOf(ac, ac.length);
        } else
        {
            return null;
        }
    }

    public static NetswipeCardInformation create(NetswipeCardInformation netswipecardinformation)
    {
        NetswipeCardInformation netswipecardinformation1 = new NetswipeCardInformation();
        netswipecardinformation1.cardNumber = copyField(netswipecardinformation.cardNumber);
        netswipecardinformation1.cardNumberGrouped = copyField(netswipecardinformation.cardNumberGrouped);
        netswipecardinformation1.cardNumberMasked = copyField(netswipecardinformation.cardNumberMasked);
        netswipecardinformation1.cardExpiryDateMonth = copyField(netswipecardinformation.cardExpiryDateMonth);
        netswipecardinformation1.cardExpiryDateYear = copyField(netswipecardinformation.cardExpiryDateYear);
        netswipecardinformation1.cardCvvCode = copyField(netswipecardinformation.cardCvvCode);
        netswipecardinformation1.cardHolderName = copyField(netswipecardinformation.cardHolderName);
        netswipecardinformation1.cardSortCode = copyField(netswipecardinformation.cardSortCode);
        netswipecardinformation1.cardAccountNumber = copyField(netswipecardinformation.cardAccountNumber);
        netswipecardinformation1.cardNumberManuallyEntered = netswipecardinformation.cardNumberManuallyEntered;
        netswipecardinformation1.cardType = netswipecardinformation.cardType;
        netswipecardinformation1.customFields = (HashMap)netswipecardinformation.customFields.clone();
        netswipecardinformation1.cardSortCodeValid = netswipecardinformation.cardSortCodeValid;
        netswipecardinformation1.cardAccountNumberValid = netswipecardinformation.cardAccountNumberValid;
        netswipecardinformation1.nameToCompare = netswipecardinformation.nameToCompare;
        netswipecardinformation1.encryptedAdyenString = netswipecardinformation.encryptedAdyenString;
        return netswipecardinformation1;
    }

    public void clear()
    {
        if (cardNumber != null)
        {
            Arrays.fill(cardNumber, '\0');
            cardNumber = null;
        }
        if (cardNumberGrouped != null)
        {
            Arrays.fill(cardNumberGrouped, '\0');
            cardNumberGrouped = null;
        }
        if (cardNumberMasked != null)
        {
            Arrays.fill(cardNumberMasked, '\0');
            cardNumberMasked = null;
        }
        if (cardHolderName != null)
        {
            Arrays.fill(cardHolderName, '\0');
            cardHolderName = null;
        }
        if (cardSortCode != null)
        {
            Arrays.fill(cardSortCode, '\0');
            cardSortCode = null;
            cardSortCodeValid = false;
        }
        if (cardAccountNumber != null)
        {
            Arrays.fill(cardAccountNumber, '\0');
            cardAccountNumber = null;
            cardAccountNumberValid = false;
        }
        if (cardExpiryDateMonth != null)
        {
            Arrays.fill(cardExpiryDateMonth, '\0');
            cardExpiryDateMonth = null;
        }
        if (cardExpiryDateYear != null)
        {
            Arrays.fill(cardExpiryDateYear, '\0');
            cardExpiryDateYear = null;
        }
        if (cardExpiryDate != null)
        {
            Arrays.fill(cardExpiryDate, '\0');
            cardExpiryDate = null;
        }
        if (cardCvvCode != null)
        {
            Arrays.fill(cardCvvCode, '\0');
            cardCvvCode = null;
        }
        cardType = CreditCardType.UNKNOWN;
    }

    public int describeContents()
    {
        return 0;
    }

    public char[] getCardAccountNumber()
    {
        if (cardAccountNumber == null)
        {
            return new char[0];
        } else
        {
            return cardAccountNumber;
        }
    }

    public char[] getCardCvvCode()
    {
        if (cardCvvCode == null)
        {
            return new char[0];
        } else
        {
            return cardCvvCode;
        }
    }

    public char[] getCardExpiryDate()
    {
        if (getCardExpiryDateMonth().length == 0 || getCardExpiryDateYear().length == 0)
        {
            return new char[0];
        }
        if (cardExpiryDate == null)
        {
            cardExpiryDate = new char[5];
        }
        System.arraycopy(getCardExpiryDateMonth(), 0, cardExpiryDate, 0, getCardExpiryDateMonth().length);
        cardExpiryDate[2] = '/';
        System.arraycopy(getCardExpiryDateYear(), 0, cardExpiryDate, 3, getCardExpiryDateYear().length);
        return cardExpiryDate;
    }

    public char[] getCardExpiryDateMonth()
    {
        if (cardExpiryDateMonth == null)
        {
            return new char[0];
        } else
        {
            return cardExpiryDateMonth;
        }
    }

    public char[] getCardExpiryDateYear()
    {
        if (cardExpiryDateYear == null)
        {
            return new char[0];
        } else
        {
            return cardExpiryDateYear;
        }
    }

    public char[] getCardHolderName()
    {
        if (cardHolderName == null)
        {
            return new char[0];
        } else
        {
            return cardHolderName;
        }
    }

    public char[] getCardNumber()
    {
        if (cardNumber == null)
        {
            return new char[0];
        } else
        {
            return cardNumber;
        }
    }

    public char[] getCardNumberGrouped()
    {
        if (cardNumberGrouped == null)
        {
            return new char[0];
        } else
        {
            return cardNumberGrouped;
        }
    }

    public char[] getCardNumberMasked()
    {
        if (cardNumberMasked == null)
        {
            return new char[0];
        } else
        {
            return cardNumberMasked;
        }
    }

    public char[] getCardSortCode()
    {
        if (cardSortCode == null)
        {
            return new char[0];
        } else
        {
            return cardSortCode;
        }
    }

    public CreditCardType getCardType()
    {
        return cardType;
    }

    public String getCustomField(String s)
    {
        return (String)customFields.get(s);
    }

    public String getEncryptedAdyenString()
    {
        return encryptedAdyenString;
    }

    public int getNameDistance()
    {
        if (nameToCompare == null)
        {
            return -1;
        } else
        {
            return (new bh(nameToCompare, String.valueOf(getCardHolderName()))).a();
        }
    }

    public boolean isCardAccountNumberValid()
    {
        return cardAccountNumberValid;
    }

    public boolean isCardNumberManuallyEntered()
    {
        return cardNumberManuallyEntered;
    }

    public boolean isCardSortCodeValid()
    {
        return cardSortCodeValid;
    }

    public boolean isCleared()
    {
        return cardNumber == null || cardNumber.length == 0;
    }

    public boolean isNameMatch()
    {
        if (nameToCompare == null)
        {
            return false;
        } else
        {
            return (new bh(nameToCompare, String.valueOf(getCardHolderName()))).b();
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        char ac[];
        if (cardNumber != null)
        {
            i = cardNumber.length;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (cardNumber != null)
        {
            ac = cardNumber;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (cardNumberGrouped != null)
        {
            i = cardNumberGrouped.length;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (cardNumberGrouped != null)
        {
            ac = cardNumberGrouped;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (cardNumberMasked != null)
        {
            i = cardNumberMasked.length;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (cardNumberMasked != null)
        {
            ac = cardNumberMasked;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (cardHolderName != null)
        {
            i = cardHolderName.length;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (cardHolderName != null)
        {
            ac = cardHolderName;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (cardSortCode != null)
        {
            i = cardSortCode.length;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (cardSortCode != null)
        {
            ac = cardSortCode;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (cardAccountNumber != null)
        {
            i = cardAccountNumber.length;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (cardAccountNumber != null)
        {
            ac = cardAccountNumber;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        parcel.writeSerializable(cardType);
        if (cardExpiryDateMonth != null)
        {
            i = cardExpiryDateMonth.length;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (cardExpiryDateMonth != null)
        {
            ac = cardExpiryDateMonth;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (cardExpiryDateYear != null)
        {
            i = cardExpiryDateYear.length;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (cardExpiryDateYear != null)
        {
            ac = cardExpiryDateYear;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        if (cardCvvCode != null)
        {
            i = cardCvvCode.length;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (cardCvvCode != null)
        {
            ac = cardCvvCode;
        } else
        {
            ac = new char[0];
        }
        parcel.writeCharArray(ac);
        parcel.writeSerializable(customFields);
        if (cardNumberManuallyEntered)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (cardAccountNumberValid)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (cardSortCodeValid)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(nameToCompare);
        parcel.writeString(encryptedAdyenString);
    }

}
