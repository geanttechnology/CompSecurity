// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.Cursor;

public final class PacksContentColumns
{
    public static final class ContentCursorWrapper extends VersionColumns.BaseCursorWrapper
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

        public static ContentCursorWrapper create(Cursor cursor)
        {
            if (VersionColumns.VersionCursorWrapper.isValid(cursor))
            {
                ContentCursorWrapper contentcursorwrapper = new ContentCursorWrapper(cursor.getLong(cursor.getColumnIndex("content_id")), cursor.getLong(cursor.getColumnIndex("content_packId")));
                int i = cursor.getColumnIndex("content_previewURL");
                if (i > -1)
                {
                    contentcursorwrapper.previewURL = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_contentURL");
                if (i > -1)
                {
                    contentcursorwrapper.contentURL = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_iconUrl");
                if (i > -1)
                {
                    contentcursorwrapper.iconURL = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_displayName");
                if (i > -1)
                {
                    contentcursorwrapper.displayName = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_displayDescription");
                if (i > -1)
                {
                    contentcursorwrapper.displayDescription = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_iconPath");
                if (i > -1)
                {
                    contentcursorwrapper.iconPath = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_previewPath");
                if (i > -1)
                {
                    contentcursorwrapper.previewPath = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_contentPath");
                if (i > -1)
                {
                    contentcursorwrapper.contentPath = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_contentVersion");
                if (i > -1)
                {
                    contentcursorwrapper.contentVersion = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_previewVersion");
                if (i > -1)
                {
                    contentcursorwrapper.previewVersion = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_iconVersion");
                if (i > -1)
                {
                    contentcursorwrapper.iconVersion = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_isFree");
                if (i > -1)
                {
                    contentcursorwrapper.free = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("content_purchased");
                if (i > -1)
                {
                    contentcursorwrapper.purchased = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("content_iconNeedDownload");
                if (i > -1)
                {
                    contentcursorwrapper.iconNeedDownload = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("content_downloadRequested");
                if (i > -1)
                {
                    contentcursorwrapper.downloadRequestStatus = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("content_numItems");
                if (i > -1)
                {
                    contentcursorwrapper.numItems = cursor.getInt(i);
                }
                i = cursor.getColumnIndex("content_author");
                if (i > -1)
                {
                    contentcursorwrapper.author = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_authorHyperlink");
                if (i > -1)
                {
                    contentcursorwrapper.authorHyperLink = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_socialMediaString");
                if (i > -1)
                {
                    contentcursorwrapper.socialMediaString = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_featureImageURL");
                if (i > -1)
                {
                    contentcursorwrapper.featureImageURL = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_featureImageVersion");
                if (i > -1)
                {
                    contentcursorwrapper.featureImageVersion = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_detailImageURL");
                if (i > -1)
                {
                    contentcursorwrapper.detailImageURL = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_detailImageVersion");
                if (i > -1)
                {
                    contentcursorwrapper.detailImageVersion = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_shopBackgroundColor");
                if (i > -1)
                {
                    contentcursorwrapper.shopBackgroundColor = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_detailImageLocalPath");
                if (i > -1)
                {
                    contentcursorwrapper.detailImageLocalPath = cursor.getString(i);
                }
                i = cursor.getColumnIndex("content_featureImageLocalPath");
                if (i > -1)
                {
                    contentcursorwrapper.featureImageLocalPath = cursor.getString(i);
                }
                return contentcursorwrapper;
            } else
            {
                return null;
            }
        }

        public Object clone()
        {
            ContentCursorWrapper contentcursorwrapper = new ContentCursorWrapper(id, packId);
            contentcursorwrapper.iconURL = iconURL;
            contentcursorwrapper.previewURL = previewURL;
            contentcursorwrapper.contentURL = contentURL;
            contentcursorwrapper.displayName = displayName;
            contentcursorwrapper.displayDescription = displayDescription;
            contentcursorwrapper.previewPath = previewPath;
            contentcursorwrapper.contentPath = contentPath;
            contentcursorwrapper.iconPath = iconPath;
            contentcursorwrapper.contentVersion = contentVersion;
            contentcursorwrapper.previewVersion = previewVersion;
            contentcursorwrapper.iconVersion = iconVersion;
            contentcursorwrapper.iconNeedDownload = iconNeedDownload;
            contentcursorwrapper.contentDownloadStarted = contentDownloadStarted;
            contentcursorwrapper.downloadRequestStatus = downloadRequestStatus;
            contentcursorwrapper.free = free;
            contentcursorwrapper.purchased = purchased;
            contentcursorwrapper.numItems = numItems;
            contentcursorwrapper.author = author;
            contentcursorwrapper.authorHyperLink = authorHyperLink;
            contentcursorwrapper.socialMediaString = socialMediaString;
            contentcursorwrapper.featureImageURL = featureImageURL;
            contentcursorwrapper.featureImageVersion = featureImageVersion;
            contentcursorwrapper.detailImageURL = detailImageURL;
            contentcursorwrapper.detailImageVersion = detailImageVersion;
            contentcursorwrapper.detailImageLocalPath = detailImageLocalPath;
            contentcursorwrapper.featureImageLocalPath = featureImageLocalPath;
            contentcursorwrapper.shopBackgroundColor = shopBackgroundColor;
            return contentcursorwrapper;
        }

        public boolean equals(Object obj)
        {
            if (obj != null && (obj instanceof ContentCursorWrapper))
            {
                obj = (ContentCursorWrapper)obj;
                if (id == ((ContentCursorWrapper) (obj)).id && packId == ((ContentCursorWrapper) (obj)).packId)
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

        ContentCursorWrapper(long l, long l1)
        {
            super(l);
            packId = l1;
        }
    }


    public static final String AUTHOR = "content_author";
    public static final String AUTHOR_HYPERLINK = "content_authorHyperlink";
    public static final String CONTENT_NEED_DOWNLOAD = "content_contentNeedDownload";
    public static final String CONTENT_PATH = "content_contentPath";
    public static final String CONTENT_URL = "content_contentURL";
    public static final String CONTENT_VERSION = "content_contentVersion";
    public static final String DETAIL_IMAGE_LOCAL_PATH = "content_detailImageLocalPath";
    public static final String DETAIL_IMAGE_URL = "content_detailImageURL";
    public static final String DETAIL_IMAGE_VERSION = "content_detailImageVersion";
    public static final String DISPLAY_DESCRIPTION = "content_displayDescription";
    public static final String DISPLAY_NAME = "content_displayName";
    public static final String DOWNLOAD_REQUESTED = "content_downloadRequested";
    public static final String FEATURE_IMAGE_LOCAL_PATH = "content_featureImageLocalPath";
    public static final String FEATURE_IMAGE_URL = "content_featureImageURL";
    public static final String FEATURE_IMAGE_VERSION = "content_featureImageVersion";
    public static final String ICON_NEED_DOWNLOAD = "content_iconNeedDownload";
    public static final String ICON_PATH = "content_iconPath";
    public static final String ICON_URL = "content_iconUrl";
    public static final String ICON_VERSION = "content_iconVersion";
    public static final String INSTALL_DATE = "content_installDate";
    public static final String IS_FREE_PURCHASE = "content_isFree";
    public static final String ITEMS_COUNT = "content_numItems";
    public static final String PACK_ID = "content_packId";
    public static final String PREVIEW_NEED_DOWNLOAD = "content_previewNeedDownload";
    public static final String PREVIEW_PATH = "content_previewPath";
    public static final String PREVIEW_URL = "content_previewURL";
    public static final String PREVIEW_VERSION = "content_previewVersion";
    public static final String PURCHASED = "content_purchased";
    public static final String SHOP_BACKGROUND_COLOR = "content_shopBackgroundColor";
    public static final String SOCIAL_MEDIA_STRING = "content_socialMediaString";
    public static final String TABLE_NAME = "content_table";
    public static final String _ID = "content_id";

    private PacksContentColumns()
    {
    }
}
