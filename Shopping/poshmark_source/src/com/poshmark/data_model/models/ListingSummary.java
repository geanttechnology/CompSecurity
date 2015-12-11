// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.models.inner_models.CoverShot;
import com.poshmark.data_model.models.inner_models.Inventory;
import com.poshmark.data_model.models.inner_models.ListingAggregates;
import com.poshmark.data_model.models.inner_models.ListingFeature;
import com.poshmark.utils.CurrencyUtils;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.NameIdPair;
import java.math.BigDecimal;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            ListingDetails, MetaItem

public class ListingSummary
{
    public static final class SUMMARY_TYPE extends Enum
    {

        private static final SUMMARY_TYPE $VALUES[];
        public static final SUMMARY_TYPE DEFAULT;
        public static final SUMMARY_TYPE SOCIAL_OLDEST;

        public static SUMMARY_TYPE valueOf(String s)
        {
            return (SUMMARY_TYPE)Enum.valueOf(com/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE, s);
        }

        public static SUMMARY_TYPE[] values()
        {
            return (SUMMARY_TYPE[])$VALUES.clone();
        }

        static 
        {
            DEFAULT = new SUMMARY_TYPE("DEFAULT", 0);
            SOCIAL_OLDEST = new SUMMARY_TYPE("SOCIAL_OLDEST", 1);
            $VALUES = (new SUMMARY_TYPE[] {
                DEFAULT, SOCIAL_OLDEST
            });
        }

        private SUMMARY_TYPE(String s, int i)
        {
            super(s, i);
        }
    }


    ListingAggregates aggregates;
    String brand;
    boolean caller_has_liked;
    List category_features;
    MetaItem category_v2;
    List colors;
    String condition;
    CoverShot cover_shot;
    String created_at;
    String creator_display_handle;
    String creator_fb_id;
    String creator_full_name;
    String creator_id;
    String creator_picture_url;
    String creator_username;
    String description;
    boolean has_offer;
    String id;
    Inventory inventory;
    BigDecimal original_price;
    String picture_url;
    List posters;
    BigDecimal price;
    int publish_count;
    String short_url;
    String size;
    String status;
    String status_changed_at;
    String title;

    public ListingSummary()
    {
    }

    public void copy(ListingDetails listingdetails)
    {
        publish_count = listingdetails.publish_count;
        original_price = listingdetails.original_price;
        id = listingdetails.id;
        creator_username = listingdetails.creator_username;
        title = listingdetails.title;
        description = listingdetails.description;
        created_at = listingdetails.created_at;
        creator_full_name = listingdetails.creator_full_name;
        picture_url = listingdetails.picture_url;
        creator_picture_url = listingdetails.creator_picture_url;
        status = listingdetails.status;
        condition = listingdetails.condition;
        creator_fb_id = listingdetails.creator_fb_id;
        creator_id = listingdetails.creator_id;
        size = listingdetails.size;
        price = listingdetails.price;
        short_url = listingdetails.short_url;
        brand = listingdetails.brand;
        status_changed_at = listingdetails.status_changed_at;
        creator_display_handle = listingdetails.creator_display_handle;
        inventory.copy(listingdetails.inventory);
        cover_shot.copy(listingdetails.cover_shot);
    }

    public String getAvataar()
    {
        String s = null;
        if (creator_picture_url != null)
        {
            s = creator_picture_url;
        } else
        if (creator_fb_id != null)
        {
            return String.format("https://graph.facebook.com/%s/picture?width=100&height=100", new Object[] {
                creator_fb_id
            });
        }
        return s;
    }

    public String getBrand()
    {
        return brand;
    }

    public MetaItem getCategory()
    {
        return category_v2;
    }

    public String getCategoryId()
    {
        return category_v2.getId();
    }

    public String getCategoryLabel()
    {
        return category_v2.getDisplay();
    }

    public List getColorList()
    {
        return colors;
    }

    public String getCondition()
    {
        return condition;
    }

    public String getCovershot()
    {
        return cover_shot.url;
    }

    public String getCovershotId()
    {
        return cover_shot.id;
    }

    public String getCreatorFbId()
    {
        return creator_fb_id;
    }

    public String getDescription()
    {
        return description;
    }

    public long getIdAsLong()
    {
        return Long.parseLong(id);
    }

    public String getIdAsString()
    {
        return id;
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public String getListingDate()
    {
        return created_at;
    }

    public boolean getListingLikeStatus()
    {
        return caller_has_liked;
    }

    public com.poshmark.data_model.models.inner_models.Inventory.ListingStatus getListingStatus()
    {
        return inventory.getInventoryStatus();
    }

    public String getMediumCovershot()
    {
        return cover_shot.url;
    }

    public NameIdPair getNameIdPair()
    {
        return new NameIdPair(creator_username, id);
    }

    public BigDecimal getOriginalPrice()
    {
        return original_price;
    }

    public String getOriginalPriceString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsWholeNumber(original_price)).toString();
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public String getPriceString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsFormattedString(price)).toString();
    }

    public String getPriceStringAsWholeNumber()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsWholeNumber(price)).toString();
    }

    public int getPublishCount()
    {
        return publish_count;
    }

    public String getShortURL()
    {
        return short_url;
    }

    public CharSequence getSize()
    {
        return size;
    }

    public String getSmallCovershot()
    {
        return cover_shot.url_small;
    }

    public List getSubCategoryList()
    {
        return category_features;
    }

    public String getTitle()
    {
        return title;
    }

    public int getTotalComments()
    {
        if (aggregates != null)
        {
            return aggregates.comments;
        } else
        {
            return 0;
        }
    }

    public int getTotalLikes()
    {
        if (aggregates != null)
        {
            return aggregates.likes;
        } else
        {
            return 0;
        }
    }

    public String getUserDisplyName()
    {
        return creator_display_handle;
    }

    public String getUserId()
    {
        return creator_id;
    }

    public String getUserName()
    {
        return creator_username;
    }

    public boolean isAvailableForPurchase()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (inventory == null)
            {
                break label0;
            }
            if (inventory.getInventoryStatus() != com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.AVAILABLE)
            {
                flag = flag1;
                if (!inventory.caller_has_reserved.booleanValue())
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public boolean isNWT()
    {
        return condition != null && condition.toLowerCase().equals("nwt");
    }

    public boolean isPriceValidForOffer()
    {
        BigDecimal bigdecimal = new BigDecimal(3);
        ListingFeature listingfeature = FeatureManager.getGlobalFeatureManager().getListingFeature();
        if (listingfeature != null)
        {
            bigdecimal = listingfeature.getMinimumSellingPrice();
        }
        int i = price.compareTo(bigdecimal);
        return i != -1 && i != 0;
    }

    public boolean isRetail()
    {
        return condition != null && condition.toLowerCase().equals("ret");
    }

    public void setListingLikeStatus(boolean flag)
    {
        caller_has_liked = flag;
    }

    public void setShortURL(String s)
    {
        short_url = s;
    }

    public String statusChangedAt()
    {
        return status_changed_at;
    }
}
