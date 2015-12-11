// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class FeedItemStoryType
{
    public static final class StoryType extends Enum
    {

        private static final StoryType $VALUES[];
        public static final StoryType BRAND_ADD_MIFU;
        public static final StoryType BRAND_CHECKOUT_MIFU;
        public static final StoryType BRAND_JUSTIN_MIFU;
        public static final StoryType BRAND_LISTING_ADD_MIFU;
        public static final StoryType BRAND_RECOMMEND_MIFU;
        public static final StoryType CLOSET_ADD_MIFU;
        public static final StoryType CLOSET_ADD_SIFU;
        public static final StoryType CLOSET_ADD_SIFU_SOCIAL;
        public static final StoryType CLOSET_RECOMMEND_MIFU;
        public static final StoryType CLOSET_UPDATE_MIFU;
        public static final StoryType CLOSET_UPDATE_SIFU;
        public static final StoryType CLOSET_UPDATE_SIFU_SOCIAL;
        public static final StoryType INVALID;
        public static final StoryType LISTING_SHARE_MIFU;
        public static final StoryType LISTING_SHARE_SIFU;
        public static final StoryType LISTING_SHARE_SIFU_SOCIAL;
        public static final StoryType POSHPOST_SIFU;
        public static final StoryType SELF_SHARE_MIFU;
        public static final StoryType SELF_SHARE_SIFU;
        public static final StoryType SELF_SHARE_SIFU_SOCIAL;

        public static StoryType valueOf(String s)
        {
            return (StoryType)Enum.valueOf(com/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType, s);
        }

        public static StoryType[] values()
        {
            return (StoryType[])$VALUES.clone();
        }

        static 
        {
            CLOSET_ADD_SIFU = new StoryType("CLOSET_ADD_SIFU", 0);
            CLOSET_ADD_SIFU_SOCIAL = new StoryType("CLOSET_ADD_SIFU_SOCIAL", 1);
            CLOSET_ADD_MIFU = new StoryType("CLOSET_ADD_MIFU", 2);
            CLOSET_UPDATE_SIFU = new StoryType("CLOSET_UPDATE_SIFU", 3);
            CLOSET_UPDATE_SIFU_SOCIAL = new StoryType("CLOSET_UPDATE_SIFU_SOCIAL", 4);
            CLOSET_UPDATE_MIFU = new StoryType("CLOSET_UPDATE_MIFU", 5);
            LISTING_SHARE_SIFU = new StoryType("LISTING_SHARE_SIFU", 6);
            LISTING_SHARE_SIFU_SOCIAL = new StoryType("LISTING_SHARE_SIFU_SOCIAL", 7);
            LISTING_SHARE_MIFU = new StoryType("LISTING_SHARE_MIFU", 8);
            SELF_SHARE_SIFU = new StoryType("SELF_SHARE_SIFU", 9);
            SELF_SHARE_SIFU_SOCIAL = new StoryType("SELF_SHARE_SIFU_SOCIAL", 10);
            SELF_SHARE_MIFU = new StoryType("SELF_SHARE_MIFU", 11);
            BRAND_ADD_MIFU = new StoryType("BRAND_ADD_MIFU", 12);
            BRAND_RECOMMEND_MIFU = new StoryType("BRAND_RECOMMEND_MIFU", 13);
            BRAND_CHECKOUT_MIFU = new StoryType("BRAND_CHECKOUT_MIFU", 14);
            BRAND_LISTING_ADD_MIFU = new StoryType("BRAND_LISTING_ADD_MIFU", 15);
            BRAND_JUSTIN_MIFU = new StoryType("BRAND_JUSTIN_MIFU", 16);
            CLOSET_RECOMMEND_MIFU = new StoryType("CLOSET_RECOMMEND_MIFU", 17);
            POSHPOST_SIFU = new StoryType("POSHPOST_SIFU", 18);
            INVALID = new StoryType("INVALID", 19);
            $VALUES = (new StoryType[] {
                CLOSET_ADD_SIFU, CLOSET_ADD_SIFU_SOCIAL, CLOSET_ADD_MIFU, CLOSET_UPDATE_SIFU, CLOSET_UPDATE_SIFU_SOCIAL, CLOSET_UPDATE_MIFU, LISTING_SHARE_SIFU, LISTING_SHARE_SIFU_SOCIAL, LISTING_SHARE_MIFU, SELF_SHARE_SIFU, 
                SELF_SHARE_SIFU_SOCIAL, SELF_SHARE_MIFU, BRAND_ADD_MIFU, BRAND_RECOMMEND_MIFU, BRAND_CHECKOUT_MIFU, BRAND_LISTING_ADD_MIFU, BRAND_JUSTIN_MIFU, CLOSET_RECOMMEND_MIFU, POSHPOST_SIFU, INVALID
            });
        }

        private StoryType(String s, int i)
        {
            super(s, i);
        }
    }


    StoryType currentStory;

    public FeedItemStoryType()
    {
        currentStory = StoryType.INVALID;
    }

    public FeedItemStoryType(String s)
    {
        currentStory = StoryType.INVALID;
        setStoryType(s);
    }

    public StoryType getStoryType()
    {
        return currentStory;
    }

    public boolean isStoryTypeValid()
    {
        return currentStory != StoryType.INVALID;
    }

    public void setStoryType(String s)
    {
label0:
        {
            if (s != null)
            {
                if (!s.equalsIgnoreCase("CLOSET_ADD_SIFU"))
                {
                    break label0;
                }
                currentStory = StoryType.CLOSET_ADD_SIFU;
            }
            return;
        }
        if (s.equalsIgnoreCase("CLOSET_ADD_SIFUSOCIAL"))
        {
            currentStory = StoryType.CLOSET_ADD_SIFU_SOCIAL;
            return;
        }
        if (s.equalsIgnoreCase("CLOSET_ADD_MIFU"))
        {
            currentStory = StoryType.CLOSET_ADD_MIFU;
            return;
        }
        if (s.equalsIgnoreCase("CLOSET_UPDATE_SIFU"))
        {
            currentStory = StoryType.CLOSET_UPDATE_SIFU;
            return;
        }
        if (s.equalsIgnoreCase("CLOSET_UPDATE_SIFUSOCIAL"))
        {
            currentStory = StoryType.CLOSET_UPDATE_SIFU_SOCIAL;
            return;
        }
        if (s.equalsIgnoreCase("CLOSET_UPDATE_MIFU"))
        {
            currentStory = StoryType.CLOSET_UPDATE_MIFU;
            return;
        }
        if (s.equalsIgnoreCase("LISTING_SHARE_SIFU"))
        {
            currentStory = StoryType.LISTING_SHARE_SIFU;
            return;
        }
        if (s.equalsIgnoreCase("LISTING_SHARE_SIFUSOCIAL"))
        {
            currentStory = StoryType.LISTING_SHARE_SIFU_SOCIAL;
            return;
        }
        if (s.equalsIgnoreCase("LISTING_SHARE_MIFU"))
        {
            currentStory = StoryType.LISTING_SHARE_MIFU;
            return;
        }
        if (s.equalsIgnoreCase("SELF_SHARE_SIFU"))
        {
            currentStory = StoryType.SELF_SHARE_SIFU;
            return;
        }
        if (s.equalsIgnoreCase("SELF_SHARE_SIFUSOCIAL"))
        {
            currentStory = StoryType.SELF_SHARE_SIFU_SOCIAL;
            return;
        }
        if (s.equalsIgnoreCase("SELF_SHARE_MIFU"))
        {
            currentStory = StoryType.SELF_SHARE_MIFU;
            return;
        }
        if (s.equalsIgnoreCase("BRAND_ADD_MIFU"))
        {
            currentStory = StoryType.BRAND_ADD_MIFU;
            return;
        }
        if (s.equalsIgnoreCase("BRAND_CHECKOUT_MIFU"))
        {
            currentStory = StoryType.BRAND_CHECKOUT_MIFU;
            return;
        }
        if (s.equalsIgnoreCase("BRAND_LISTING_ADD_MIFU"))
        {
            currentStory = StoryType.BRAND_CHECKOUT_MIFU;
            return;
        }
        if (s.equalsIgnoreCase("BRAND_JUSTIN_MIFU"))
        {
            currentStory = StoryType.BRAND_JUSTIN_MIFU;
            return;
        }
        if (s.equalsIgnoreCase("BRAND_RECOMMEND_MIFU"))
        {
            currentStory = StoryType.BRAND_RECOMMEND_MIFU;
            return;
        }
        if (s.equalsIgnoreCase("CLOSET_RECOMMEND_MIFU"))
        {
            currentStory = StoryType.CLOSET_RECOMMEND_MIFU;
            return;
        }
        if (s.equalsIgnoreCase("CPU_SIFU"))
        {
            currentStory = StoryType.POSHPOST_SIFU;
            return;
        } else
        {
            currentStory = StoryType.INVALID;
            return;
        }
    }
}
