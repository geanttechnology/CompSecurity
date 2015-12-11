// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            NameValue

public class ItemCompatibilty
{

    public String compatibilityNotes;
    public ArrayList nameValueList;

    public ItemCompatibilty()
    {
        nameValueList = new ArrayList();
    }

    public ItemCompatibilty(Parcel parcel)
    {
        nameValueList = new ArrayList();
        compatibilityNotes = parcel.readString();
        parcel.readTypedList(nameValueList, NameValue.CREATOR);
    }

    public static ArrayList getCompatibilityCategoriesForSite(EbaySite ebaysite)
    {
        ArrayList arraylist = new ArrayList();
        if (ebaysite.idInt == EbaySite.DE.idInt)
        {
            arraylist.add("Make");
            arraylist.add("Platform");
            arraylist.add("Type");
            arraylist.add("Model");
            arraylist.add("Engine");
            arraylist.add("Production Period");
            return arraylist;
        }
        if (ebaysite.idInt == EbaySite.UK.idInt)
        {
            arraylist.add("Cars Year");
            arraylist.add("Car Make");
            arraylist.add("Model");
            arraylist.add("Cars Type");
            arraylist.add("Engine");
            arraylist.add("BodyStyle");
            arraylist.add("Variant");
            return arraylist;
        } else
        {
            arraylist.add("Year");
            arraylist.add("Make");
            arraylist.add("Model");
            arraylist.add("Trim");
            arraylist.add("Submodel");
            return arraylist;
        }
    }

    public String getValueForName(String s)
    {
        Object obj1 = null;
        Iterator iterator = nameValueList.iterator();
        Object obj;
        do
        {
            obj = obj1;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (NameValue)iterator.next();
            if (!((NameValue) (obj)).getName().equals(s))
            {
                continue;
            }
            obj = ((NameValue) (obj)).getValue();
            break;
        } while (true);
        return ((String) (obj));
    }

    public boolean matches(ArrayList arraylist)
    {
        if (arraylist == null || arraylist.size() == 0 || nameValueList == null || nameValueList.size() == 0)
        {
            return false;
        }
        arraylist = new ArrayList(arraylist);
        Iterator iterator = nameValueList.iterator();
label0:
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            NameValue namevalue = (NameValue)iterator.next();
            Iterator iterator1 = arraylist.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    continue label0;
                }
            } while (!((NameValue)iterator1.next()).equals(namevalue));
            iterator1.remove();
        } while (!arraylist.isEmpty());
        return arraylist.isEmpty();
    }

    public boolean matches(ArrayList arraylist, ArrayList arraylist1)
    {
        if (arraylist.size() >= arraylist1.size()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        boolean flag1 = true;
        int i = 0;
        do
        {
            flag = flag1;
            if (i >= arraylist1.size())
            {
                continue;
            }
            if (!TextUtils.isEmpty((CharSequence)arraylist1.get(i)) && !((String)arraylist1.get(i)).equals(getValueForName((String)arraylist.get(i))))
            {
                return false;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(compatibilityNotes);
        parcel.writeTypedList(nameValueList);
    }
}
