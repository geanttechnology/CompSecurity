// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Entities
    implements Serializable
{

    private static String TAG = com/bestbuy/android/api/lib/models/registry/Entities.getSimpleName();
    private static final long serialVersionUID = 1L;
    private String Uuid;
    private String createdBy;
    private boolean favoriteFlag;
    private String parentType;
    private String parentUuid;
    private String personalizedMsg;
    private int purchaseQuantity;
    private int requiredQuantity;
    private String sku;
    private String tags;
    private String type;
    private String updatedBy;

    public Entities()
    {
        purchaseQuantity = 0;
    }

    public static ArrayList getAddedProductsList(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray != null && jsonarray.length() > 0)
        {
            for (int i = 0; i < jsonarray.length(); i++)
            {
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                if (jsonobject == null)
                {
                    continue;
                }
                Entities entities = new Entities();
                entities.Uuid = jsonobject.optString("uuid");
                entities.type = jsonobject.optString("type");
                entities.createdBy = jsonobject.optString("created-by");
                entities.updatedBy = jsonobject.optString("last-updated-by");
                entities.requiredQuantity = jsonobject.optInt("required-quantity");
                entities.purchaseQuantity = jsonobject.optInt("purchased-quantity");
                entities.sku = jsonobject.optString("sku");
                entities.tags = jsonobject.optString("tags");
                entities.personalizedMsg = jsonobject.optString("personalized-message");
                entities.favoriteFlag = jsonobject.optBoolean("favorite");
                jsonobject = jsonobject.optJSONObject("parent");
                if (jsonobject != null)
                {
                    entities.parentUuid = jsonobject.optString("uuid");
                    entities.parentType = jsonobject.optString("type");
                }
                arraylist.add(entities);
            }

        }
        return arraylist;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public String getParentType()
    {
        return parentType;
    }

    public String getParentUuid()
    {
        return parentUuid;
    }

    public String getPersonalizedMsg()
    {
        return personalizedMsg;
    }

    public int getPurchaseQuantity()
    {
        return purchaseQuantity;
    }

    public int getRequiredQuantity()
    {
        return requiredQuantity;
    }

    public String getSku()
    {
        return sku;
    }

    public String getTags()
    {
        return tags;
    }

    public String getType()
    {
        return type;
    }

    public String getUpdatedBy()
    {
        return updatedBy;
    }

    public String getUuid()
    {
        return Uuid;
    }

    public boolean isFavorite()
    {
        return favoriteFlag;
    }

    public void setFavorite(boolean flag)
    {
        favoriteFlag = flag;
    }

    public void setPurchaseQuantity(int i)
    {
        purchaseQuantity = i;
    }

    public void setRequiredQuantity(int i)
    {
        requiredQuantity = i;
    }

}
