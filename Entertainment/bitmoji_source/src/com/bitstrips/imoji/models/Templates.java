// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.bitstrips.imoji.models:
//            Imoji, Announcers, OutfitBuilderCatalogs

public class Templates
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Templates createFromParcel(Parcel parcel)
        {
            return new Templates(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Templates[] newArray(int i)
        {
            return new Templates[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final List OTHER_TAGS;
    private static final List SUPER_TAGS;
    Announcers announcers;
    List friends;
    List imoji;
    OutfitBuilderCatalogs outfits;
    List packs;

    public Templates(Parcel parcel)
    {
        imoji = new ArrayList();
        friends = new ArrayList();
        parcel.readTypedList(imoji, Imoji.CREATOR);
        parcel.readTypedList(friends, Imoji.CREATOR);
    }

    public Templates(List list)
    {
        this(list, null, null);
    }

    public Templates(List list, OutfitBuilderCatalogs outfitbuildercatalogs, Announcers announcers1)
    {
        imoji = list;
        outfits = outfitbuildercatalogs;
        announcers = announcers1;
    }

    private Map buildTemplateIdLookupTable()
    {
        HashMap hashmap = new HashMap();
        Imoji imoji1;
        for (Iterator iterator = getImoji().iterator(); iterator.hasNext(); hashmap.put(imoji1.getTemplateId(), imoji1))
        {
            imoji1 = (Imoji)iterator.next();
        }

        return hashmap;
    }

    private void initSuperTagLists(HashMap hashmap)
    {
        for (Iterator iterator = SUPER_TAGS.iterator(); iterator.hasNext(); hashmap.put((String)iterator.next(), new ArrayList())) { }
        for (Iterator iterator1 = OTHER_TAGS.iterator(); iterator1.hasNext(); hashmap.put((String)iterator1.next(), new ArrayList())) { }
    }

    public int describeContents()
    {
        return 0;
    }

    public Announcers getAnnouncers()
    {
        return announcers;
    }

    public Map getFriendmojiSuperTagMap()
    {
        HashMap hashmap = new HashMap();
        initSuperTagLists(hashmap);
        for (Iterator iterator = friends.iterator(); iterator.hasNext();)
        {
            Imoji imoji1 = (Imoji)iterator.next();
            Iterator iterator1 = imoji1.getSupertags().iterator();
            while (iterator1.hasNext()) 
            {
                ((List)hashmap.get((String)iterator1.next())).add(imoji1);
            }
        }

        return hashmap;
    }

    public List getFriendmojis()
    {
        return friends;
    }

    public List getImoji()
    {
        return imoji;
    }

    public List getImojiById(List list)
    {
        Map map = buildTemplateIdLookupTable();
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Imoji imoji1 = (Imoji)map.get((String)list.next());
            if (imoji1 != null)
            {
                arraylist.add(imoji1);
            }
        } while (true);
        return arraylist;
    }

    public OutfitBuilderCatalogs getOutfitBuilderData()
    {
        return outfits;
    }

    public List getPacks()
    {
        return packs;
    }

    public Map getSuperTagMap(boolean flag)
    {
        HashMap hashmap = new HashMap();
        initSuperTagLists(hashmap);
        for (Iterator iterator = imoji.iterator(); iterator.hasNext();)
        {
            Imoji imoji1 = (Imoji)iterator.next();
            if (flag || imoji1.isFree())
            {
                Iterator iterator1 = imoji1.getSupertags().iterator();
                while (iterator1.hasNext()) 
                {
                    List list = (List)hashmap.get((String)iterator1.next());
                    if (list != null)
                    {
                        list.add(imoji1);
                    }
                }
            }
        }

        return hashmap;
    }

    public List getSuperTags()
    {
        return SUPER_TAGS;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = imoji.iterator(); iterator.hasNext(); stringbuilder.append(((Imoji)iterator.next()).toString()).append(" | ")) { }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeTypedList(imoji);
        parcel.writeTypedList(friends);
    }

    static 
    {
        SUPER_TAGS = new ArrayList();
        SUPER_TAGS.add("#popmoji");
        SUPER_TAGS.add("#ismiley");
        SUPER_TAGS.add("#ilove");
        SUPER_TAGS.add("#ifrowny");
        SUPER_TAGS.add("#inuanced");
        SUPER_TAGS.add("#iwacky");
        OTHER_TAGS = new ArrayList();
        OTHER_TAGS.add("#purchased");
        OTHER_TAGS.add("#invite");
    }
}
