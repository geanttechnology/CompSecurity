// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.registry:
//            RegistryWishList

public class RegistryWishListCompleteData
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String firstUrl;
    private String lastUrl;
    private String nextUrl;
    private String prevUrl;
    private ArrayList registryWishlistArray;

    public RegistryWishListCompleteData()
    {
        registryWishlistArray = new ArrayList();
    }

    public static RegistryWishListCompleteData getRegistryWishListData(JSONObject jsonobject)
    {
        RegistryWishListCompleteData registrywishlistcompletedata = new RegistryWishListCompleteData();
        if (jsonobject != null)
        {
            registrywishlistcompletedata.firstUrl = jsonobject.optString("first");
            registrywishlistcompletedata.lastUrl = jsonobject.optString("last");
            registrywishlistcompletedata.nextUrl = jsonobject.optString("next");
            registrywishlistcompletedata.prevUrl = jsonobject.optString("prev");
            jsonobject = jsonobject.optJSONArray("entities");
            if (jsonobject != null && jsonobject.length() > 0)
            {
                int i = 0;
                while (i < jsonobject.length()) 
                {
                    try
                    {
                        JSONObject jsonobject1 = jsonobject.getJSONObject(i);
                        RegistryWishList registrywishlist = RegistryWishList.parseRegistryWishListData(jsonobject1);
                        registrywishlist.setCoRegistrantFirstName(jsonobject1.optString("coRegistrantFirstName", ""));
                        registrywishlist.setCoRegistrantLastName(jsonobject1.optString("coRegistrantLastName", ""));
                        registrywishlistcompletedata.registryWishlistArray.add(registrywishlist);
                    }
                    catch (JSONException jsonexception)
                    {
                        jsonexception.printStackTrace();
                    }
                    i++;
                }
            }
        }
        return registrywishlistcompletedata;
    }

    public String getFirstUrl()
    {
        return firstUrl;
    }

    public String getLastUrl()
    {
        return lastUrl;
    }

    public String getNextUrl()
    {
        return nextUrl;
    }

    public String getPrevUrl()
    {
        return prevUrl;
    }

    public ArrayList getRegistryWishlistArray()
    {
        return registryWishlistArray;
    }

    public void setFirstUrl(String s)
    {
        firstUrl = s;
    }

    public void setLastUrl(String s)
    {
        lastUrl = s;
    }

    public void setNextUrl(String s)
    {
        nextUrl = s;
    }

    public void setPrevUrl(String s)
    {
        prevUrl = s;
    }

    public void setRegistryWishlistArray(ArrayList arraylist)
    {
        registryWishlistArray = arraylist;
    }
}
