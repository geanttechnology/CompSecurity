// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import android.content.Context;
import android.util.Log;
import com.poshmark.data_model.models.inner_models.CoverShot;
import com.poshmark.data_model.models.inner_models.FeedItemFooterLayout;
import com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout;
import com.poshmark.data_model.models.inner_models.FeedItemLayoutInfo;
import com.poshmark.data_model.models.inner_models.FeedItemStoryType;
import com.poshmark.data_model.models.inner_models.UserReference;
import com.poshmark.ui.customviews.PMAvataarImageView;
import com.poshmark.utils.DateUtils;
import com.poshmark.utils.TextFormatter;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            FeedItemImageLayout, FeedItemContentType, Actor, ListingSocial, 
//            Brand, PoshmarkPost

public class FeedItem
{
    private static final class ViewLayoutType extends Enum
    {

        private static final ViewLayoutType $VALUES[];
        public static final ViewLayoutType VIEW_LAYOUT_TYPE_BRAND_MIFU_3_FLUID_LARGE_LEFT;
        public static final ViewLayoutType VIEW_LAYOUT_TYPE_BRAND_MIFU_4_GRID;
        public static final ViewLayoutType VIEW_LAYOUT_TYPE_BRAND_SIFU;
        public static final ViewLayoutType VIEW_LAYOUT_TYPE_CLOSET_MIFU_3_FLUID_LARGE_LEFT;
        public static final ViewLayoutType VIEW_LAYOUT_TYPE_CLOSET_MIFU_4_GRID;
        public static final ViewLayoutType VIEW_LAYOUT_TYPE_CLOSET_SIFU;
        public static final ViewLayoutType VIEW_LAYOUT_TYPE_COUNT;
        public static final ViewLayoutType VIEW_LAYOUT_TYPE_MIFU_3_FLUID_LARGE_LEFT;
        public static final ViewLayoutType VIEW_LAYOUT_TYPE_MIFU_4_GRID;
        public static final ViewLayoutType VIEW_LAYOUT_TYPE_POSHPOST_SIFU_LEFT_TEXT_RIGHT;
        public static final ViewLayoutType VIEW_LAYOUT_TYPE_SIFU;
        public static final ViewLayoutType VIEW_LAYOUT_TYPE_SIFU_DOUBLE_HEADER;
        public static final ViewLayoutType VIEW_LAYOUT_TYPE_SOCIAL;

        public static ViewLayoutType valueOf(String s)
        {
            return (ViewLayoutType)Enum.valueOf(com/poshmark/data_model/models/FeedItem$ViewLayoutType, s);
        }

        public static ViewLayoutType[] values()
        {
            return (ViewLayoutType[])$VALUES.clone();
        }

        static 
        {
            VIEW_LAYOUT_TYPE_SOCIAL = new ViewLayoutType("VIEW_LAYOUT_TYPE_SOCIAL", 0);
            VIEW_LAYOUT_TYPE_SIFU = new ViewLayoutType("VIEW_LAYOUT_TYPE_SIFU", 1);
            VIEW_LAYOUT_TYPE_SIFU_DOUBLE_HEADER = new ViewLayoutType("VIEW_LAYOUT_TYPE_SIFU_DOUBLE_HEADER", 2);
            VIEW_LAYOUT_TYPE_MIFU_4_GRID = new ViewLayoutType("VIEW_LAYOUT_TYPE_MIFU_4_GRID", 3);
            VIEW_LAYOUT_TYPE_MIFU_3_FLUID_LARGE_LEFT = new ViewLayoutType("VIEW_LAYOUT_TYPE_MIFU_3_FLUID_LARGE_LEFT", 4);
            VIEW_LAYOUT_TYPE_BRAND_SIFU = new ViewLayoutType("VIEW_LAYOUT_TYPE_BRAND_SIFU", 5);
            VIEW_LAYOUT_TYPE_BRAND_MIFU_4_GRID = new ViewLayoutType("VIEW_LAYOUT_TYPE_BRAND_MIFU_4_GRID", 6);
            VIEW_LAYOUT_TYPE_BRAND_MIFU_3_FLUID_LARGE_LEFT = new ViewLayoutType("VIEW_LAYOUT_TYPE_BRAND_MIFU_3_FLUID_LARGE_LEFT", 7);
            VIEW_LAYOUT_TYPE_CLOSET_SIFU = new ViewLayoutType("VIEW_LAYOUT_TYPE_CLOSET_SIFU", 8);
            VIEW_LAYOUT_TYPE_CLOSET_MIFU_4_GRID = new ViewLayoutType("VIEW_LAYOUT_TYPE_CLOSET_MIFU_4_GRID", 9);
            VIEW_LAYOUT_TYPE_CLOSET_MIFU_3_FLUID_LARGE_LEFT = new ViewLayoutType("VIEW_LAYOUT_TYPE_CLOSET_MIFU_3_FLUID_LARGE_LEFT", 10);
            VIEW_LAYOUT_TYPE_POSHPOST_SIFU_LEFT_TEXT_RIGHT = new ViewLayoutType("VIEW_LAYOUT_TYPE_POSHPOST_SIFU_LEFT_TEXT_RIGHT", 11);
            VIEW_LAYOUT_TYPE_COUNT = new ViewLayoutType("VIEW_LAYOUT_TYPE_COUNT", 12);
            $VALUES = (new ViewLayoutType[] {
                VIEW_LAYOUT_TYPE_SOCIAL, VIEW_LAYOUT_TYPE_SIFU, VIEW_LAYOUT_TYPE_SIFU_DOUBLE_HEADER, VIEW_LAYOUT_TYPE_MIFU_4_GRID, VIEW_LAYOUT_TYPE_MIFU_3_FLUID_LARGE_LEFT, VIEW_LAYOUT_TYPE_BRAND_SIFU, VIEW_LAYOUT_TYPE_BRAND_MIFU_4_GRID, VIEW_LAYOUT_TYPE_BRAND_MIFU_3_FLUID_LARGE_LEFT, VIEW_LAYOUT_TYPE_CLOSET_SIFU, VIEW_LAYOUT_TYPE_CLOSET_MIFU_4_GRID, 
                VIEW_LAYOUT_TYPE_CLOSET_MIFU_3_FLUID_LARGE_LEFT, VIEW_LAYOUT_TYPE_POSHPOST_SIFU_LEFT_TEXT_RIGHT, VIEW_LAYOUT_TYPE_COUNT
            });
        }

        private ViewLayoutType(String s, int i)
        {
            super(s, i);
        }
    }


    public String action;
    public Actor actor;
    public List contentArray;
    public int contentTotalCount;
    public FeedItemContentType contentType;
    public String createdAt;
    public String footer;
    public String header;
    public String headerIconUrl;
    public FeedItemImageLayout imageLayout;
    public FeedItemLayoutInfo layoutInfo;
    public FeedItemStoryType storyType;

    public FeedItem()
    {
    }

    public static int getViewLayoutTypeCount()
    {
        ViewLayoutType.VIEW_LAYOUT_TYPE_COUNT.ordinal();
        int i = com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.invalid.ordinal();
        int j = FeedItemImageLayout.Layout.Invalid.ordinal();
        int k = com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.invalid.ordinal();
        new String("");
        String s = Integer.toString(i);
        s = (new StringBuilder()).append(s).append(Integer.toString(j)).toString();
        return Integer.parseInt((new StringBuilder()).append(s).append(Integer.toString(k)).toString()) + 1;
    }

    public void computeFeedItemLayout()
    {
        if (imageLayout == null)
        {
            break MISSING_BLOCK_LABEL_308;
        }
        layoutInfo = new FeedItemLayoutInfo();
        layoutInfo.imageLayout = imageLayout;
        if (layoutInfo.imageLayout.currentLayout != FeedItemImageLayout.Layout.SIFU_SOCIAL) goto _L2; else goto _L1
_L1:
        layoutInfo.headerLayout = new FeedItemHeaderLayout();
        layoutInfo.headerLayout.currentLayout = com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.LEGACY_HEADER;
        layoutInfo.footerLayout = new FeedItemFooterLayout();
        layoutInfo.footerLayout.currentLayout = com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.LEGACY_FOOTER;
_L4:
        return;
_L2:
        if (header != null)
        {
            layoutInfo.headerLayout = new FeedItemHeaderLayout();
            if (storyType.getStoryType() == com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.LISTING_SHARE_SIFU)
            {
                layoutInfo.headerLayout.currentLayout = com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.DOUBLE_LEVEL_HEADER;
            } else
            if (storyType.getStoryType() == com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.POSHPOST_SIFU)
            {
                layoutInfo.headerLayout.currentLayout = com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.SINGLE_LEVEL_HEADER_POSHPOST;
            } else
            {
                layoutInfo.headerLayout.currentLayout = com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.SINGLE_LEVEL_HEADER;
            }
        }
        layoutInfo.footerLayout = new FeedItemFooterLayout();
        if ((imageLayout.currentLayout == FeedItemImageLayout.Layout.SIFU_SUMMARY || imageLayout.currentLayout == FeedItemImageLayout.Layout.SIFU_SOCIAL) && contentType.type == FeedItemContentType.ContentType.Post)
        {
            layoutInfo.footerLayout = new FeedItemFooterLayout();
            layoutInfo.footerLayout.currentLayout = com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.SOCIAL_ACTIONS_FOOTER;
            return;
        }
        if (footer == null) goto _L4; else goto _L3
_L3:
        layoutInfo.footerLayout = new FeedItemFooterLayout();
        layoutInfo.footerLayout.currentLayout = com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.SIMPLE_LAUNCH_FOOTER;
        return;
        Log.d("Test", "Test");
        return;
    }

    public String getActorId()
    {
        if (actor != null)
        {
            return actor.getId();
        } else
        {
            return null;
        }
    }

    public String getActorImageUrl()
    {
        if (actor != null)
        {
            return actor.getAvataar();
        } else
        {
            return null;
        }
    }

    public String getAttributionText()
    {
        if ((storyType.getStoryType() == com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.CLOSET_ADD_SIFU_SOCIAL || storyType.getStoryType() == com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.CLOSET_UPDATE_SIFU_SOCIAL || storyType.getStoryType() == com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.LISTING_SHARE_SIFU_SOCIAL || storyType.getStoryType() == com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.SELF_SHARE_SIFU_SOCIAL) && contentType.type == FeedItemContentType.ContentType.Post && contentArray.size() > 0)
        {
            ListingSocial listingsocial = (ListingSocial)contentArray.get(0);
            return (new TextFormatter()).getPublishedAtMessageString(listingsocial);
        } else
        {
            return DateUtils.formatDateForDisplay(createdAt, null);
        }
    }

    public Object getContentFromIndex(int i, Class class1)
    {
        if (contentArray.size() > i)
        {
            if (class1 == com/poshmark/data_model/models/ListingSocial && contentType.type == FeedItemContentType.ContentType.Post)
            {
                return (ListingSocial)contentArray.get(i);
            }
            if (class1 == com/poshmark/data_model/models/Brand && contentType.type == FeedItemContentType.ContentType.Brand)
            {
                return (Brand)contentArray.get(i);
            }
            if (class1 == com/poshmark/data_model/models/inner_models/UserReference && contentType.type == FeedItemContentType.ContentType.User)
            {
                return (UserReference)contentArray.get(i);
            }
        }
        return null;
    }

    public String getContentIdFromIndex(int i)
    {
        if (contentArray.size() <= i) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$data_model$models$FeedItemContentType$ContentType[];
            static final int $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[];

            static 
            {
                $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout = new int[FeedItemImageLayout.Layout.values().length];
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[FeedItemImageLayout.Layout.SIFU_SUMMARY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[FeedItemImageLayout.Layout.SIFU_LEFT_IMAGE_RIGHT_TEXT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[FeedItemImageLayout.Layout.SIFU_SOCIAL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[FeedItemImageLayout.Layout.MIFU_3_FLUID_LARGE_LEFT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[FeedItemImageLayout.Layout.MIFU_4_GRID.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$poshmark$data_model$models$FeedItemContentType$ContentType = new int[FeedItemContentType.ContentType.values().length];
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemContentType$ContentType[FeedItemContentType.ContentType.Brand.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemContentType$ContentType[FeedItemContentType.ContentType.Post.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemContentType$ContentType[FeedItemContentType.ContentType.User.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemContentType$ContentType[FeedItemContentType.ContentType.PoshmarkPost.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.poshmark.data_model.models.FeedItemContentType.ContentType[contentType.type.ordinal()];
        JVM INSTR tableswitch 1 3: default 52
    //                   1 54
    //                   2 71
    //                   3 88;
           goto _L2 _L3 _L4 _L5
_L2:
        return null;
_L3:
        return ((Brand)contentArray.get(i)).canonical_name;
_L4:
        return ((ListingSocial)contentArray.get(i)).getIdAsString();
_L5:
        return ((UserReference)contentArray.get(i)).getUserId();
    }

    public String getContentImageUrlFromIndex(int i, com.poshmark.utils.FeedItemPopulator.COVERSHOT_SIZE covershot_size)
    {
        if (contentArray.size() <= i) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.poshmark.data_model.models.FeedItemContentType.ContentType[contentType.type.ordinal()];
        JVM INSTR tableswitch 1 4: default 56
    //                   1 58
    //                   2 102
    //                   3 133
    //                   4 150;
           goto _L3 _L4 _L5 _L6 _L7
_L6:
        break MISSING_BLOCK_LABEL_133;
_L3:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_150;
_L2:
        Brand brand;
        return null;
_L4:
        if ((brand = (Brand)contentArray.get(i)).logo != null)
        {
            if (covershot_size == com.poshmark.utils.FeedItemPopulator.COVERSHOT_SIZE.LARGE)
            {
                return brand.logo.url;
            } else
            {
                return brand.logo.url_small;
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
        ListingSocial listingsocial = (ListingSocial)contentArray.get(i);
        if (covershot_size == com.poshmark.utils.FeedItemPopulator.COVERSHOT_SIZE.LARGE)
        {
            return listingsocial.getCovershot();
        } else
        {
            return listingsocial.getSmallCovershot();
        }
        return ((UserReference)contentArray.get(i)).getAvataar();
        return ((PoshmarkPost)contentArray.get(i)).image.url;
    }

    public String getContentOwnerImageUrl()
    {
        if (contentArray.size() > 0 && contentType.type == FeedItemContentType.ContentType.Post)
        {
            return ((ListingSocial)contentArray.get(0)).getAvataar();
        } else
        {
            return null;
        }
    }

    public String getContentOwnerName()
    {
        if (contentArray.size() > 0 && contentType.type == FeedItemContentType.ContentType.Post)
        {
            return ((ListingSocial)contentArray.get(0)).getUserName();
        } else
        {
            return null;
        }
    }

    public String getContentStringFromIndex(int i)
    {
        if (contentArray.size() > i)
        {
            if (contentType.type == FeedItemContentType.ContentType.Brand)
            {
                Brand brand = (Brand)contentArray.get(i);
                if (brand.logo == null)
                {
                    return brand.canonical_name;
                }
            } else
            if (contentType.type == FeedItemContentType.ContentType.User)
            {
                UserReference userreference = (UserReference)contentArray.get(i);
                if (userreference != null)
                {
                    return String.format("@%s", new Object[] {
                        userreference.getUserName()
                    });
                }
            } else
            if (contentType.type == FeedItemContentType.ContentType.PoshmarkPost)
            {
                PoshmarkPost poshmarkpost = (PoshmarkPost)contentArray.get(i);
                if (poshmarkpost != null)
                {
                    return poshmarkpost.text.title;
                }
            }
        }
        return null;
    }

    public String getFooterString()
    {
        return footer;
    }

    public FeedItemStoryType getStoryType()
    {
        return storyType;
    }

    public int getViewLayoutTypeId()
    {
        int i = 0;
        int j = 0;
        int k = 0;
        if (layoutInfo.headerLayout != null)
        {
            i = layoutInfo.headerLayout.currentLayout.ordinal();
        }
        if (layoutInfo.imageLayout != null)
        {
            j = layoutInfo.imageLayout.currentLayout.ordinal();
        }
        if (layoutInfo.footerLayout != null)
        {
            k = layoutInfo.footerLayout.currentLayout.ordinal();
        }
        new String("");
        String s = Integer.toString(i);
        s = (new StringBuilder()).append(s).append(Integer.toString(j)).toString();
        return Integer.parseInt((new StringBuilder()).append(s).append(Integer.toString(k)).toString());
    }

    public FeedItemImageLayout.Layout getViewType()
    {
        return imageLayout.currentLayout;
    }

    public void renderHeaderAvataar(Context context, PMAvataarImageView pmavataarimageview)
    {
        if (actor == null) goto _L2; else goto _L1
_L1:
        context = actor.getAvataar();
        if (context == null) goto _L4; else goto _L3
_L3:
        pmavataarimageview.loadImage(context);
_L6:
        return;
_L4:
        pmavataarimageview.loadImage(actor.getDefaultAvataarImageId());
        return;
_L2:
        if (contentType.type == FeedItemContentType.ContentType.User)
        {
            pmavataarimageview.loadImage(0x7f020116);
            return;
        }
        if (contentType.type == FeedItemContentType.ContentType.Brand)
        {
            pmavataarimageview.loadImage(0x7f02006b);
            return;
        }
        if (contentType.type == FeedItemContentType.ContentType.PoshmarkPost)
        {
            if (headerIconUrl != null)
            {
                pmavataarimageview.loadImage(headerIconUrl);
                return;
            } else
            {
                pmavataarimageview.loadImage(0x7f0200f6);
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setActor(Actor actor1)
    {
        actor = actor1;
    }

    public void setHeaderIconUrl(String s)
    {
        if (s != null && s.length() > 0)
        {
            headerIconUrl = s;
        }
    }

    public boolean validate()
    {
        boolean flag1 = true;
        boolean flag;
        if (storyType.getStoryType() == com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.BRAND_CHECKOUT_MIFU || storyType.getStoryType() == com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.BRAND_JUSTIN_MIFU || storyType.getStoryType() == com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.BRAND_RECOMMEND_MIFU || storyType.getStoryType() == com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.CLOSET_RECOMMEND_MIFU || storyType.getStoryType() == com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.POSHPOST_SIFU)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || actor != null) goto _L2; else goto _L1
_L1:
        flag1 = false;
_L10:
        return flag1;
_L2:
        int i = contentArray.size();
        _cls1..SwitchMap.com.poshmark.data_model.models.FeedItemImageLayout.Layout[imageLayout.currentLayout.ordinal()];
        JVM INSTR tableswitch 1 5: default 148
    //                   1 150
    //                   2 156
    //                   3 162
    //                   4 168
    //                   5 175;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        continue; /* Loop/switch isn't completed */
_L3:
        return false;
_L4:
        if (i > 0) goto _L10; else goto _L9
_L9:
        return false;
_L5:
        if (i > 0) goto _L10; else goto _L11
_L11:
        return false;
_L6:
        if (i > 0) goto _L10; else goto _L12
_L12:
        return false;
_L7:
        if (i > 2) goto _L10; else goto _L13
_L13:
        return false;
        if (i > 3) goto _L10; else goto _L14
_L14:
        return false;
    }
}
