// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.bitstrips.outfitbuilder.models:
//            OBShowcaseItems, OBCatalogItem, OBShowcaseItem, OBBrand, 
//            OBOutfit

public class OBCatalog
    implements Parcelable
{

    private static String BRAND_BGCOLOR_KEY = "bg_color";
    private static String BRAND_FGCOLOR_KEY = "fg_color";
    private static String BRAND_HEADERBG_KEY = "header_background";
    private static String BRAND_ID_KEY = "id";
    private static String BRAND_KEY = "brands";
    private static String BRAND_LOGO_KEY = "logo";
    private static String BRAND_NAME_KEY = "name";
    private static String BRAND_OUTFITS_KEY = "outfits";
    private static String BRAND_STOREBG__KEY = "store_background";
    private static String BRAND_THEME_KEY = "theme";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OBCatalog createFromParcel(Parcel parcel)
        {
            return new OBCatalog(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public OBCatalog[] newArray(int i)
        {
            return new OBCatalog[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static String OUTFIT_DESCRIPTION_KEY = "description";
    private static String OUTFIT_ID_KEY = "id";
    private static String OUTFIT_IMAGE_KEY = "image";
    private static String OUTFIT_SUBLOGO_KEY = "sublogo";
    private static String SHOWCASE_ITEM_IMAGE = "image";
    private static String SHOWCASE_KEY = "showcase";
    ArrayList items;
    OBShowcaseItems showcase;

    public OBCatalog()
    {
        items = new ArrayList();
        showcase = new OBShowcaseItems();
    }

    protected OBCatalog(Parcel parcel)
    {
        items = new ArrayList();
        showcase = new OBShowcaseItems();
        parcel.readTypedList(items, OBCatalogItem.CREATOR);
        parcel.readTypedList(showcase, OBShowcaseItem.CREATOR);
    }

    public static OBCatalog catalogFromJsonString(String s)
    {
        OBCatalog obcatalog = new OBCatalog();
        JSONArray jsonarray;
        s = new JSONObject(s);
        jsonarray = s.getJSONArray(BRAND_KEY);
        int i = 0;
_L4:
        OBBrand obbrand;
        ArrayList arraylist;
        Object obj;
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = jsonarray.getJSONObject(i);
        obbrand = new OBBrand(((JSONObject) (obj)).getInt(BRAND_ID_KEY), ((JSONObject) (obj)).getString(BRAND_NAME_KEY), ((JSONObject) (obj)).getString(BRAND_LOGO_KEY), ((JSONObject) (obj)).getString(BRAND_HEADERBG_KEY), ((JSONObject) (obj)).getString(BRAND_STOREBG__KEY), ((JSONObject) (obj)).getString(BRAND_BGCOLOR_KEY), ((JSONObject) (obj)).getString(BRAND_FGCOLOR_KEY));
        arraylist = new ArrayList();
        obj = ((JSONObject) (obj)).getJSONArray(BRAND_OUTFITS_KEY);
        int j = 0;
_L2:
        if (j >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = ((JSONArray) (obj)).getJSONObject(j);
        arraylist.add(new OBOutfit(jsonobject.getInt(OUTFIT_ID_KEY), jsonobject.getString(OUTFIT_IMAGE_KEY), jsonobject.optString(OUTFIT_SUBLOGO_KEY, null), jsonobject.optString(OUTFIT_DESCRIPTION_KEY, null)));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        obcatalog.items.add(new OBCatalogItem(obbrand, arraylist));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        jsonarray = s.getJSONArray(SHOWCASE_KEY);
        i = 0;
_L6:
        s = obcatalog;
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        s = jsonarray.getJSONObject(i);
        obcatalog.showcase.add(new OBShowcaseItem(s.getString(SHOWCASE_ITEM_IMAGE)));
        i++;
        if (true) goto _L6; else goto _L5
        s;
        s.printStackTrace();
        s = null;
_L5:
        return s;
    }

    public void addItem(OBCatalogItem obcatalogitem)
    {
        items.add(obcatalogitem);
    }

    public void addShowcaseItem(OBShowcaseItem obshowcaseitem)
    {
        showcase.add(obshowcaseitem);
    }

    public ArrayList asOutfitList()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = items.iterator(); iterator.hasNext();)
        {
            OBCatalogItem obcatalogitem = (OBCatalogItem)iterator.next();
            Iterator iterator1 = obcatalogitem.getOutfits().iterator();
            while (iterator1.hasNext()) 
            {
                OBOutfit oboutfit = (OBOutfit)iterator1.next();
                oboutfit.setBrand(obcatalogitem.getBrand());
                arraylist.add(oboutfit);
            }
        }

        return arraylist;
    }

    public int describeContents()
    {
        return 0;
    }

    public ArrayList getItems()
    {
        return items;
    }

    public OBShowcaseItems getShowcase()
    {
        return showcase;
    }

    public void updateWithNewCatalogData(OBCatalog obcatalog)
    {
        items.clear();
        OBCatalogItem obcatalogitem;
        for (Iterator iterator = obcatalog.items.iterator(); iterator.hasNext(); items.add(obcatalogitem))
        {
            obcatalogitem = (OBCatalogItem)iterator.next();
        }

        showcase.clear();
        OBShowcaseItem obshowcaseitem;
        for (obcatalog = obcatalog.showcase.iterator(); obcatalog.hasNext(); showcase.add(obshowcaseitem))
        {
            obshowcaseitem = (OBShowcaseItem)obcatalog.next();
        }

    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeTypedList(items);
        parcel.writeTypedList(showcase);
    }

}
