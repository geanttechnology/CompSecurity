// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ItemCurrency, NameValue

public class Variation
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Variation createFromParcel(Parcel parcel)
        {
            return new Variation(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Variation[] newArray(int i)
        {
            return new Variation[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private String SKU;
    private ArrayList nameValueList;
    private int quantity;
    private int quantitySold;
    private ItemCurrency startPrice;

    public Variation()
    {
        nameValueList = new ArrayList();
        startPrice = new ItemCurrency();
        SKU = new String();
        nameValueList = new ArrayList();
    }

    private Variation(Parcel parcel)
    {
        nameValueList = new ArrayList();
        startPrice = new ItemCurrency();
        SKU = new String();
        quantity = parcel.readInt();
        quantitySold = parcel.readInt();
        startPrice = (ItemCurrency)parcel.readParcelable(getClass().getClassLoader());
        SKU = parcel.readString();
        parcel.readTypedList(nameValueList, NameValue.CREATOR);
    }


    public Variation(ArrayList arraylist)
    {
        nameValueList = new ArrayList();
        startPrice = new ItemCurrency();
        SKU = new String();
        nameValueList = arraylist;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj instanceof Variation)
                {
                    obj = (Variation)obj;
                    if (!nameValueList.equals(((Variation) (obj)).nameValueList) || quantity != ((Variation) (obj)).quantity || quantitySold != ((Variation) (obj)).quantitySold || !startPrice.equals(((Variation) (obj)).startPrice) || !SKU.equals(((Variation) (obj)).SKU))
                    {
                        break label0;
                    }
                    flag = true;
                }
            }
            return flag;
        }
        return false;
    }

    public ArrayList getNameValueList()
    {
        return nameValueList;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getQuantitySold()
    {
        return quantitySold;
    }

    public String getSKU()
    {
        return SKU;
    }

    public ItemCurrency getStartPrice()
    {
        return startPrice;
    }

    public boolean isMatch(List list)
    {
        if (list != null || nameValueList != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int j;
        if (list == null && nameValueList != null || list != null && nameValueList == null)
        {
            return false;
        }
        if (nameValueList.size() != list.size())
        {
            return false;
        }
        j = 0;
        Iterator iterator = nameValueList.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            NameValue namevalue = (NameValue)iterator.next();
            String s = namevalue.getName();
            List list1 = namevalue.getValues();
            Iterator iterator1 = list.iterator();
            int i = j;
            do
            {
                j = i;
                if (!iterator1.hasNext())
                {
                    break;
                }
                Object obj = (NameValue)iterator1.next();
                if (((NameValue) (obj)).getName().equals(s) && ((NameValue) (obj)).getNumValues() == namevalue.getValues().size())
                {
                    boolean flag = true;
                    obj = ((NameValue) (obj)).getValues().iterator();
                    do
                    {
                        j = ((flag) ? 1 : 0);
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        if (list1.contains((String)((Iterator) (obj)).next()))
                        {
                            continue;
                        }
                        j = 0;
                        break;
                    } while (true);
                    if (j != 0)
                    {
                        i++;
                    }
                }
            } while (true);
        } while (true);
        if (j == nameValueList.size()) goto _L1; else goto _L3
_L3:
        return false;
    }

    public boolean matchesSelections(ArrayList arraylist)
    {
label0:
        {
            if (arraylist == null || arraylist.size() <= 0 || nameValueList.size() <= 0)
            {
                break label0;
            }
            arraylist = arraylist.iterator();
            boolean flag;
label1:
            do
            {
                String s;
                do
                {
                    if (!arraylist.hasNext())
                    {
                        break label0;
                    }
                    s = (String)arraylist.next();
                } while (s.length() == 0);
                boolean flag1 = false;
                Iterator iterator = nameValueList.iterator();
                do
                {
                    flag = flag1;
                    if (!iterator.hasNext())
                    {
                        continue label1;
                    }
                } while (!((NameValue)iterator.next()).getValue().equals(s));
                flag = true;
            } while (flag);
            return false;
        }
        return true;
    }

    public void setNameValueList(ArrayList arraylist)
    {
        nameValueList = arraylist;
    }

    public void setQuantity(int i)
    {
        quantity = i;
    }

    public void setQuantitySold(int i)
    {
        quantitySold = i;
    }

    public void setSKU(String s)
    {
        SKU = s;
    }

    public void setStartPrice(ItemCurrency itemcurrency)
    {
        startPrice = itemcurrency;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Quantity:").append(String.valueOf(quantity)).append('\n');
        stringbuilder.append("QuantitySold:").append(String.valueOf(quantitySold)).append('\n');
        stringbuilder.append("StartPrice:").append(startPrice.value).append(startPrice.code).append('\n');
        stringbuilder.append("SKU:").append(SKU).append('\n');
        for (Iterator iterator = nameValueList.iterator(); iterator.hasNext(); stringbuilder.append((NameValue)iterator.next()).append('\n')) { }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(quantity);
        parcel.writeInt(quantitySold);
        parcel.writeParcelable(startPrice, i);
        parcel.writeString(SKU);
        parcel.writeTypedList(nameValueList);
    }

}
