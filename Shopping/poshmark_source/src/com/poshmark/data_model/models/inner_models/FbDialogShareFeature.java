// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class FbDialogShareFeature
{
    class Feature
    {

        boolean enabled;
        TipInfo fb_brand_tip;
        TipInfo fb_closet_tip;
        TipInfo fb_invite_friends_tip;
        TipInfo fb_listing_tip;
        TipInfo fb_party_tip;
        TipInfo fb_showroom_tip;
        final FbDialogShareFeature this$0;
        boolean use_fb_dialog;
        boolean use_separate_section_for_tip;

        Feature()
        {
            this$0 = FbDialogShareFeature.this;
            super();
            enabled = false;
            use_fb_dialog = false;
            use_separate_section_for_tip = false;
        }
    }

    public class TipInfo
    {

        public String background_color;
        public String message;
        public String text_color;
        final FbDialogShareFeature this$0;
        public boolean use_separate_section_for_tip;

        public TipInfo()
        {
            this$0 = FbDialogShareFeature.this;
            super();
            use_separate_section_for_tip = false;
        }
    }


    Feature android;

    public FbDialogShareFeature()
    {
    }

    public TipInfo getProTipInfo(com.poshmark.utils.ShareManager.SHARE_MODE share_mode)
    {
        if (android == null)
        {
            return null;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[];

            static 
            {
                $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE = new int[com.poshmark.utils.ShareManager.SHARE_MODE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_BRAND.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_CLOSET.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_INVITE_FRIENDS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_PARTY.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_SHOWROOM.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[share_mode.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            if (android.fb_brand_tip != null)
            {
                android.fb_brand_tip.use_separate_section_for_tip = android.use_separate_section_for_tip;
            }
            return android.fb_brand_tip;

        case 2: // '\002'
            if (android.fb_closet_tip != null)
            {
                android.fb_closet_tip.use_separate_section_for_tip = android.use_separate_section_for_tip;
            }
            return android.fb_closet_tip;

        case 3: // '\003'
            if (android.fb_invite_friends_tip != null)
            {
                android.fb_invite_friends_tip.use_separate_section_for_tip = android.use_separate_section_for_tip;
            }
            return android.fb_invite_friends_tip;

        case 4: // '\004'
            if (android.fb_listing_tip != null)
            {
                android.fb_listing_tip.use_separate_section_for_tip = android.use_separate_section_for_tip;
            }
            return android.fb_listing_tip;

        case 5: // '\005'
            if (android.fb_party_tip != null)
            {
                android.fb_party_tip.use_separate_section_for_tip = android.use_separate_section_for_tip;
            }
            return android.fb_party_tip;

        case 6: // '\006'
            break;
        }
        if (android.fb_showroom_tip != null)
        {
            android.fb_showroom_tip.use_separate_section_for_tip = android.use_separate_section_for_tip;
        }
        return android.fb_showroom_tip;
    }

    public boolean isEnabled()
    {
        if (android == null)
        {
            return false;
        } else
        {
            return android.use_fb_dialog;
        }
    }

    public boolean isProTipEnabled(com.poshmark.utils.ShareManager.SHARE_MODE share_mode)
    {
        if (android != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[share_mode.ordinal()];
        JVM INSTR tableswitch 1 6: default 56
    //                   1 58
    //                   2 83
    //                   3 108
    //                   4 133
    //                   5 158
    //                   6 183;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L9:
        continue; /* Loop/switch isn't completed */
_L3:
        return false;
_L4:
        if (android.fb_brand_tip == null || android.fb_brand_tip.message == null) goto _L1; else goto _L10
_L10:
        return true;
_L5:
        if (android.fb_closet_tip == null || android.fb_closet_tip.message == null) goto _L1; else goto _L11
_L11:
        return true;
_L6:
        if (android.fb_invite_friends_tip == null || android.fb_invite_friends_tip.message == null) goto _L1; else goto _L12
_L12:
        return true;
_L7:
        if (android.fb_listing_tip == null || android.fb_listing_tip.message == null) goto _L1; else goto _L13
_L13:
        return true;
_L8:
        if (android.fb_party_tip == null || android.fb_party_tip.message == null) goto _L1; else goto _L14
_L14:
        return true;
        if (android.fb_showroom_tip == null || android.fb_showroom_tip.message == null) goto _L1; else goto _L15
_L15:
        return true;
    }
}
