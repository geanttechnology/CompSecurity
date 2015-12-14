// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds.json;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.cds.json:
//            CdsJsonParser

public class CdsContentParser extends CdsJsonParser
{
    public static class ContentItem
    {

        final String displayName;
        final String identifier;
        final byte options[];

        public static ContentItem create(JSONObject jsonobject)
            throws JSONException
        {
            return new ContentItem(jsonobject.getString("identifier"), jsonobject.getString("displayName"), jsonobject.optJSONObject("options"));
        }

        public String getDisplayName()
        {
            return displayName;
        }

        public String getIdentifier()
        {
            return identifier;
        }

        public byte[] getOptions()
        {
            return options;
        }

        public String toString()
        {
            StringBuilder stringbuilder = (new StringBuilder()).append("{").append(identifier).append(", ").append(displayName).append(", ");
            Object obj;
            if (options != null)
            {
                obj = options;
            } else
            {
                obj = "null";
            }
            return stringbuilder.append(obj).append("}").toString();
        }

        ContentItem(String s, String s1, JSONObject jsonobject)
        {
            identifier = s;
            displayName = s1;
            if (jsonobject != null)
            {
                options = jsonobject.toString().getBytes();
                return;
            } else
            {
                options = null;
                return;
            }
        }
    }


    String author;
    String authorHyperlink;
    String contentURL;
    String contentVersion;
    String detailImageURL;
    String detailImageVersion;
    String displayDescription;
    String displayName;
    String featureImageURL;
    String featureImageVersion;
    boolean free;
    String iconURL;
    String iconVersion;
    String identifier;
    List mItems;
    String packType;
    String previewURL;
    String previewVersion;
    String shopBackgroundColor;
    String socialMediaString;
    String versionKey;

    public CdsContentParser()
    {
    }

    public String getAuthor()
    {
        return author;
    }

    public String getAuthorHyperlink()
    {
        return authorHyperlink;
    }

    public String getContentURL()
    {
        return contentURL;
    }

    public String getContentVersion()
    {
        return contentVersion;
    }

    public String getDetailImageURL()
    {
        return detailImageURL;
    }

    public String getDetailImageVersion()
    {
        return detailImageVersion;
    }

    public String getDisplayDescription()
    {
        return displayDescription;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getFeatureImageURL()
    {
        return featureImageURL;
    }

    public String getFeatureImageVersion()
    {
        return featureImageVersion;
    }

    public String getIconURL()
    {
        return iconURL;
    }

    public String getIconVersion()
    {
        return iconVersion;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public List getItems()
    {
        return mItems;
    }

    public String getPackType()
    {
        return packType;
    }

    public String getPreviewURL()
    {
        return previewURL;
    }

    public String getPreviewVersion()
    {
        return previewVersion;
    }

    public String getShopBackgroundColor()
    {
        return shopBackgroundColor;
    }

    public String getSocialMediaString()
    {
        return socialMediaString;
    }

    public String getVersionKey()
    {
        return versionKey;
    }

    public boolean isFree()
    {
        return free;
    }

    protected void onParseJson(JSONObject jsonobject)
        throws JSONException
    {
        mItems = new ArrayList();
        identifier = jsonobject.getString("identifier");
        versionKey = jsonobject.getString("versionKey");
        packType = jsonobject.getString("packType");
        displayName = jsonobject.getString("displayName");
        displayDescription = jsonobject.getString("displayDescription");
        iconURL = jsonobject.getString("icon");
        iconVersion = jsonobject.getString("iconVersion");
        previewURL = jsonobject.getString("previewURL");
        previewVersion = jsonobject.getString("previewVersion");
        contentURL = jsonobject.getString("contentURL");
        contentVersion = jsonobject.getString("contentVersion");
        free = jsonobject.getBoolean("isFree");
        author = jsonobject.optString("author");
        authorHyperlink = jsonobject.optString("authorHyperlink");
        socialMediaString = jsonobject.optString("socialMediaString");
        shopBackgroundColor = jsonobject.optString("shopBackgroundColor");
        featureImageURL = jsonobject.optString("featureImageURL");
        featureImageVersion = jsonobject.optString("featureImageVersion");
        detailImageURL = jsonobject.optString("detailImageURL");
        detailImageVersion = jsonobject.optString("detailImageVersion");
        jsonobject = jsonobject.getJSONArray("items");
        for (int i = 0; i < jsonobject.length(); i++)
        {
            ContentItem contentitem = ContentItem.create(jsonobject.getJSONObject(i));
            mItems.add(contentitem);
        }

    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer("ContentParser:\n");
        stringbuffer.append((new StringBuilder()).append("  identifier: ").append(identifier).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("  versionKey: ").append(versionKey).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("  packType: ").append(packType).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("  displayName: ").append(displayName).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("  displayDescription: ").append(displayDescription).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("  iconURL: ").append(iconURL).append(", iconVersion: ").append(iconVersion).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("  previewURL: ").append(previewURL).append(", previewVersion: ").append(previewVersion).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("  contentURL: ").append(contentURL).append(", contentVersion: ").append(contentVersion).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("  isFree: ").append(free).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("  items: ").append(mItems).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("    author: ").append(author).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("    authorHyperlink: ").append(authorHyperlink).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("    socialMediaString: ").append(socialMediaString).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("    shopBackgroundColor: ").append(shopBackgroundColor).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("    featureImageURL: ").append(featureImageURL).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("    featureImageVersion: ").append(featureImageVersion).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("    detailImageURL: ").append(detailImageURL).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("    detailImageVersion: ").append(detailImageVersion).append("\n").toString());
        return stringbuffer.toString();
    }
}
