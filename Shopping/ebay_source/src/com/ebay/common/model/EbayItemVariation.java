// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.VariationSpecific;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EbayItemVariation
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbayItemVariation createFromParcel(Parcel parcel)
        {
            return new EbayItemVariation(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayItemVariation[] newArray(int i)
        {
            return new EbayItemVariation[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public int quantity;
    public int quantitySold;
    public String sku;
    public ArrayList specifics;
    public CurrencyAmount startPrice;
    public String variationID;
    public String variationTitle;

    public EbayItemVariation()
    {
    }

    private EbayItemVariation(Parcel parcel)
    {
        sku = parcel.readString();
        variationTitle = parcel.readString();
        variationID = parcel.readString();
        startPrice = (CurrencyAmount)parcel.readParcelable(com/ebay/nautilus/domain/data/CurrencyAmount.getClassLoader());
        quantity = parcel.readInt();
        quantitySold = parcel.readInt();
        specifics = new ArrayList();
        parcel.readList(specifics, com/ebay/nautilus/domain/data/VariationSpecific.getClassLoader());
    }


    public EbayItemVariation(Map map)
    {
        specifics = new ArrayList();
        VariationSpecific variationspecific;
        Object obj;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); variationspecific.values.add(obj))
        {
            obj = (String)iterator.next();
            String s = (String)map.get(obj);
            variationspecific = new VariationSpecific();
            variationspecific.name = ((String) (obj));
            variationspecific.values = new ArrayList();
            obj = new com.ebay.nautilus.domain.data.ItemSpecific.ItemSpecificValue(((String) (obj)), s);
        }

    }

    public int describeContents()
    {
        return 0;
    }

    public boolean hasSingleSelectedValue()
    {
        boolean flag1 = true;
        Iterator iterator = specifics.iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                break;
            }
            if (((VariationSpecific)iterator.next()).valueList().size() == 1)
            {
                continue;
            }
            flag = false;
            break;
        } while (true);
        return flag;
    }

    public boolean matchesSelectedVariation(EbayItemVariation ebayitemvariation)
    {
        for (Iterator iterator = specifics.iterator(); iterator.hasNext();)
        {
            Object obj = (VariationSpecific)iterator.next();
            Object obj2 = ((VariationSpecific) (obj)).name;
            Object obj1 = null;
            obj2 = ebayitemvariation.specificForName(((String) (obj2)));
            ArrayList arraylist = ((VariationSpecific) (obj)).valueList();
            obj = obj1;
            if (obj2 != null)
            {
                obj = obj1;
                if (arraylist.size() == 1)
                {
                    obj = (String)arraylist.get(0);
                }
            }
            if (obj != null && !arraylist.contains(obj))
            {
                return false;
            }
        }

        return true;
    }

    public int quantityAvailable()
    {
        return quantity - quantitySold;
    }

    public VariationSpecific specificForName(String s)
    {
        for (Iterator iterator = specifics.iterator(); iterator.hasNext();)
        {
            VariationSpecific variationspecific = (VariationSpecific)iterator.next();
            if (s.equals(variationspecific.name))
            {
                return variationspecific;
            }
        }

        return null;
    }

    public boolean specificsAreEqualTo(EbayItemVariation ebayitemvariation)
    {
        Object obj = specifics;
        ebayitemvariation = ebayitemvariation.specifics;
        if (((ArrayList) (obj)).size() != ebayitemvariation.size())
        {
            return false;
        }
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            VariationSpecific variationspecific = (VariationSpecific)((Iterator) (obj)).next();
            boolean flag = false;
            Iterator iterator = ebayitemvariation.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (variationspecific.isEqual((VariationSpecific)iterator.next()))
                {
                    flag = true;
                }
            } while (true);
            if (!flag)
            {
                return false;
            }
        }

        return true;
    }

    public String toString()
    {
        return "TODO: fill this out";
    }

    public Map variationSpecificsAsDictionary()
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = specifics.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VariationSpecific variationspecific = (VariationSpecific)iterator.next();
            Object obj = variationspecific.valueList();
            if (((ArrayList) (obj)).size() == 1)
            {
                obj = (String)((ArrayList) (obj)).get(0);
                hashmap.put(variationspecific.name, obj);
            }
        } while (true);
        return hashmap;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(sku);
        parcel.writeString(variationTitle);
        parcel.writeString(variationID);
        parcel.writeParcelable(startPrice, 0);
        parcel.writeInt(quantity);
        parcel.writeInt(quantitySold);
        parcel.writeList(specifics);
    }

}
