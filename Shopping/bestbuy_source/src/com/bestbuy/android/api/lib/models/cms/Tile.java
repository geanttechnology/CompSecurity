// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.cms;

import org.json.JSONObject;

public class Tile
{

    static String TAG = com/bestbuy/android/api/lib/models/cms/Tile.getSimpleName();
    private String conditionalVisibilityProperty;
    private String conditionalVisibilityPropertyValue;
    private boolean disabled;
    private String displayTitle;
    private float height;
    private String image;
    private int index;
    private String jsForEvaluationString;
    private String key;
    private String selectedImage;
    private String subTitle;
    private String targetURL;
    private String targetView;
    private String title;
    private String trackingTitle;
    private float width;
    private float x;

    public Tile()
    {
    }

    public static Tile loadData(JSONObject jsonobject)
    {
        Tile tile = new Tile();
        tile.title = jsonobject.optString("title");
        tile.subTitle = jsonobject.optString("subTitle");
        tile.image = jsonobject.optString("image");
        tile.selectedImage = jsonobject.optString("selectedImage");
        tile.x = (float)jsonobject.optDouble("x");
        tile.width = (float)jsonobject.optDouble("width");
        tile.height = (float)jsonobject.optDouble("height");
        tile.index = jsonobject.optInt("index");
        tile.targetURL = jsonobject.optString("targetURL");
        tile.targetView = jsonobject.optString("targetView");
        tile.trackingTitle = jsonobject.optString("trackingTitle");
        tile.displayTitle = jsonobject.optString("displayTitle");
        tile.jsForEvaluationString = jsonobject.optString("jsForEvaluationString");
        tile.conditionalVisibilityProperty = jsonobject.optString("conditionalVisibilityProperty");
        tile.conditionalVisibilityPropertyValue = jsonobject.optString("conditionalVisibilityPropertyValue");
        tile.key = jsonobject.optString("key");
        tile.disabled = false;
        return tile;
    }

    public String getConditionalVisibilityProperty()
    {
        return conditionalVisibilityProperty;
    }

    public String getConditionalVisibilityPropertyValue()
    {
        return conditionalVisibilityPropertyValue;
    }

    public String getDisplayTitle()
    {
        return displayTitle;
    }

    public float getHeight()
    {
        return height;
    }

    public String getImage()
    {
        return image;
    }

    public int getIndex()
    {
        return index;
    }

    public String getJsForEvaluationString()
    {
        return jsForEvaluationString;
    }

    public String getKey()
    {
        return key;
    }

    public String getSelectedImage()
    {
        return selectedImage;
    }

    public String getSubTitle()
    {
        return subTitle;
    }

    public String getTargetURL()
    {
        return targetURL;
    }

    public String getTargetView()
    {
        return targetView;
    }

    public String getTitle()
    {
        return title;
    }

    public String getTrackingTitle()
    {
        return trackingTitle;
    }

    public float getWidth()
    {
        return width;
    }

    public float getX()
    {
        return x;
    }

    public boolean isDisabled()
    {
        return disabled;
    }

}
