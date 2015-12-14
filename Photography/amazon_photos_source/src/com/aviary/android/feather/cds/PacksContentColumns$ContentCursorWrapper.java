// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

// Referenced classes of package com.aviary.android.feather.cds:
//            PacksContentColumns

public static final class packId extends packId
{

    String author;
    String authorHyperLink;
    int contentDownloadStarted;
    String contentPath;
    String contentURL;
    String contentVersion;
    String detailImageLocalPath;
    String detailImageURL;
    String detailImageVersion;
    String displayDescription;
    String displayName;
    int downloadRequestStatus;
    String featureImageLocalPath;
    String featureImageURL;
    String featureImageVersion;
    int free;
    int iconNeedDownload;
    String iconPath;
    String iconURL;
    String iconVersion;
    int numItems;
    final long packId;
    String previewPath;
    String previewURL;
    String previewVersion;
    int purchased;
    String shopBackgroundColor;
    String socialMediaString;

    public static packId create(Cursor cursor)
    {
        if (id(cursor))
        {
            packId packid = new <init>(cursor.getLong(cursor.getColumnIndex("content_id")), cursor.getLong(cursor.getColumnIndex("content_packId")));
            int i = cursor.getColumnIndex("content_previewURL");
            if (i > -1)
            {
                packid.previewURL = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_contentURL");
            if (i > -1)
            {
                packid.contentURL = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_iconUrl");
            if (i > -1)
            {
                packid.iconURL = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_displayName");
            if (i > -1)
            {
                packid.displayName = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_displayDescription");
            if (i > -1)
            {
                packid.displayDescription = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_iconPath");
            if (i > -1)
            {
                packid.iconPath = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_previewPath");
            if (i > -1)
            {
                packid.previewPath = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_contentPath");
            if (i > -1)
            {
                packid.contentPath = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_contentVersion");
            if (i > -1)
            {
                packid.contentVersion = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_previewVersion");
            if (i > -1)
            {
                packid.previewVersion = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_iconVersion");
            if (i > -1)
            {
                packid.iconVersion = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_isFree");
            if (i > -1)
            {
                packid.free = cursor.getInt(i);
            }
            i = cursor.getColumnIndex("content_purchased");
            if (i > -1)
            {
                packid.purchased = cursor.getInt(i);
            }
            i = cursor.getColumnIndex("content_iconNeedDownload");
            if (i > -1)
            {
                packid.iconNeedDownload = cursor.getInt(i);
            }
            i = cursor.getColumnIndex("content_downloadRequested");
            if (i > -1)
            {
                packid.downloadRequestStatus = cursor.getInt(i);
            }
            i = cursor.getColumnIndex("content_numItems");
            if (i > -1)
            {
                packid.numItems = cursor.getInt(i);
            }
            i = cursor.getColumnIndex("content_author");
            if (i > -1)
            {
                packid.author = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_authorHyperlink");
            if (i > -1)
            {
                packid.authorHyperLink = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_socialMediaString");
            if (i > -1)
            {
                packid.socialMediaString = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_featureImageURL");
            if (i > -1)
            {
                packid.featureImageURL = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_featureImageVersion");
            if (i > -1)
            {
                packid.featureImageVersion = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_detailImageURL");
            if (i > -1)
            {
                packid.detailImageURL = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_detailImageVersion");
            if (i > -1)
            {
                packid.detailImageVersion = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_shopBackgroundColor");
            if (i > -1)
            {
                packid.shopBackgroundColor = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_detailImageLocalPath");
            if (i > -1)
            {
                packid.detailImageLocalPath = cursor.getString(i);
            }
            i = cursor.getColumnIndex("content_featureImageLocalPath");
            if (i > -1)
            {
                packid.featureImageLocalPath = cursor.getString(i);
            }
            return packid;
        } else
        {
            return null;
        }
    }

    public Object clone()
    {
        featureImageLocalPath featureimagelocalpath = new <init>(id, packId);
        featureimagelocalpath.iconURL = iconURL;
        featureimagelocalpath.previewURL = previewURL;
        featureimagelocalpath.contentURL = contentURL;
        featureimagelocalpath.displayName = displayName;
        featureimagelocalpath.displayDescription = displayDescription;
        featureimagelocalpath.previewPath = previewPath;
        featureimagelocalpath.contentPath = contentPath;
        featureimagelocalpath.iconPath = iconPath;
        featureimagelocalpath.contentVersion = contentVersion;
        featureimagelocalpath.previewVersion = previewVersion;
        featureimagelocalpath.iconVersion = iconVersion;
        featureimagelocalpath.iconNeedDownload = iconNeedDownload;
        featureimagelocalpath.contentDownloadStarted = contentDownloadStarted;
        featureimagelocalpath.downloadRequestStatus = downloadRequestStatus;
        featureimagelocalpath.free = free;
        featureimagelocalpath.purchased = purchased;
        featureimagelocalpath.numItems = numItems;
        featureimagelocalpath.author = author;
        featureimagelocalpath.authorHyperLink = authorHyperLink;
        featureimagelocalpath.socialMediaString = socialMediaString;
        featureimagelocalpath.featureImageURL = featureImageURL;
        featureimagelocalpath.featureImageVersion = featureImageVersion;
        featureimagelocalpath.detailImageURL = detailImageURL;
        featureimagelocalpath.detailImageVersion = detailImageVersion;
        featureimagelocalpath.detailImageLocalPath = detailImageLocalPath;
        featureimagelocalpath.featureImageLocalPath = featureImageLocalPath;
        featureimagelocalpath.shopBackgroundColor = shopBackgroundColor;
        return featureimagelocalpath;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof shopBackgroundColor))
        {
            obj = (shopBackgroundColor)obj;
            if (id == ((id) (obj)).id && packId == ((packId) (obj)).packId)
            {
                return true;
            }
        }
        return false;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getAuthorHyperLink()
    {
        return authorHyperLink;
    }

    public int getContentDownloadStarted()
    {
        return contentDownloadStarted;
    }

    public String getContentPath()
    {
        return contentPath;
    }

    public String getContentURL()
    {
        return contentURL;
    }

    public String getContentVersion()
    {
        return contentVersion;
    }

    public String getDetailImageLocalPath()
    {
        return detailImageLocalPath;
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

    public int getDownloadRequestStatus()
    {
        return downloadRequestStatus;
    }

    public String getFeatureImageLocalPath()
    {
        return featureImageLocalPath;
    }

    public String getFeatureImageURL()
    {
        return featureImageURL;
    }

    public String getFeatureImageVersion()
    {
        return featureImageVersion;
    }

    public int getFree()
    {
        return free;
    }

    public int getIconNeedDownload()
    {
        return iconNeedDownload;
    }

    public String getIconPath()
    {
        return iconPath;
    }

    public String getIconURL()
    {
        return iconURL;
    }

    public String getIconVersion()
    {
        return iconVersion;
    }

    public int getNumItems()
    {
        return numItems;
    }

    public long getPackId()
    {
        return packId;
    }

    public String getPreviewPath()
    {
        return previewPath;
    }

    public String getPreviewURL()
    {
        return previewURL;
    }

    public String getPreviewVersion()
    {
        return previewVersion;
    }

    public int getPurchased()
    {
        return purchased;
    }

    public String getShopBackgroundColor()
    {
        return shopBackgroundColor;
    }

    public String getSocialMediaString()
    {
        return socialMediaString;
    }

    public int hashCode()
    {
        return Long.valueOf(id + 0x1869fL + packId).hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("ContentColumns.Content{id: ").append(id).append(", packId: ").append(packId).append(", displayName: ").append(displayName).append(", purchased: ").append(purchased).append(", contentPath: ").append(contentPath).append("}").toString();
    }

    (long l, long l1)
    {
        super(l);
        packId = l1;
    }
}
