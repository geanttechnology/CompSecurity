// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class RegistrySpecificResData
    implements Comparable
{

    private String alias;
    private long created;
    private String created_by;
    private boolean favorite;
    private String last_updated_by;
    private String location;
    private long modified;
    private String name;
    private String parent_Reference;
    private String requiredQuantity;
    private String sku;
    private String tags;
    private boolean transientFlag;
    private String type;
    private String uuid;

    public RegistrySpecificResData()
    {
    }

    public static ArrayList parseRegistrySpecificData(String s)
    {
        Object obj = new JSONObject(s);
        s = new ArrayList();
        obj = ((JSONObject) (obj)).optJSONArray("entities");
        for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
        {
            JSONObject jsonobject = (JSONObject)((JSONArray) (obj)).get(i);
            RegistrySpecificResData registryspecificresdata = new RegistrySpecificResData();
            registryspecificresdata.uuid = jsonobject.optString("uuid", "");
            registryspecificresdata.type = jsonobject.optString("type", "");
            registryspecificresdata.alias = jsonobject.optString("alias", "");
            registryspecificresdata.created_by = jsonobject.optString("created-by", "");
            registryspecificresdata.last_updated_by = jsonobject.optString("last-updated-by", "");
            registryspecificresdata.name = jsonobject.optString("name", "");
            registryspecificresdata.tags = jsonobject.optString("tags", "");
            registryspecificresdata.transientFlag = jsonobject.optBoolean("transient", false);
            registryspecificresdata.favorite = jsonobject.optBoolean("favorite", false);
            registryspecificresdata.created = jsonobject.optLong("created");
            registryspecificresdata.modified = jsonobject.optLong("modified");
            registryspecificresdata.parent_Reference = jsonobject.optString("parentRef", "");
            registryspecificresdata.name = jsonobject.optString("name", "");
            registryspecificresdata.requiredQuantity = jsonobject.optString("required-quantity", "");
            registryspecificresdata.sku = jsonobject.optString("sku", "");
            registryspecificresdata.tags = jsonobject.optString("tags", "");
            s.add(registryspecificresdata);
        }

        return s;
    }

    public int compareTo(RegistrySpecificResData registryspecificresdata)
    {
        return created - registryspecificresdata.getCreated() <= 0L ? 1 : -1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((RegistrySpecificResData)obj);
    }

    public String getAlias()
    {
        return alias;
    }

    public long getCreated()
    {
        return created;
    }

    public String getCreated_by()
    {
        return created_by;
    }

    public boolean getFavorite()
    {
        return favorite;
    }

    public String getLast_updated_by()
    {
        return last_updated_by;
    }

    public String getLocation()
    {
        return location;
    }

    public long getModified()
    {
        return modified;
    }

    public String getName()
    {
        return name;
    }

    public String getParent_Reference()
    {
        return parent_Reference;
    }

    public String getRequiredQuantity()
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

    public String getUuid()
    {
        return uuid;
    }

    public boolean isTransientFlag()
    {
        return transientFlag;
    }

    public void setAlias(String s)
    {
        alias = s;
    }

    public void setCreated(long l)
    {
        created = l;
    }

    public void setCreated_by(String s)
    {
        created_by = s;
    }

    public void setFavorite(boolean flag)
    {
        favorite = flag;
    }

    public void setLast_updated_by(String s)
    {
        last_updated_by = s;
    }

    public void setLocation(String s)
    {
        location = s;
    }

    public void setModified(long l)
    {
        modified = l;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setParent_Reference(String s)
    {
        parent_Reference = s;
    }

    public void setRequiredQuantity(String s)
    {
        requiredQuantity = s;
    }

    public void setSku(String s)
    {
        sku = s;
    }

    public void setTags(String s)
    {
        tags = s;
    }

    public void setTransientFlag(boolean flag)
    {
        transientFlag = flag;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setUuid(String s)
    {
        uuid = s;
    }
}
