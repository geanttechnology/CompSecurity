// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;


// Referenced classes of package com.poshmark.utils.sharing:
//            PMShareContent

static class 
{

    static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[];
    static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[];

    static 
    {
        $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE = new int[com.poshmark.utils.E_MODE.values().length];
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.E_MODE.SHARE_MODE_PARTY.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.E_MODE.SHARE_MODE_CLOSET.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.E_MODE.SHARE_MODE_LISTING.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.E_MODE.SHARE_MODE_INVITE_FRIENDS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.E_MODE.SHARE_MODE_SHOWROOM.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.E_MODE.SHARE_MODE_BRAND.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.E_MODE.SHARE_MODE_BRAND_JUSTIN.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE = new int[com.poshmark.utils.E_TYPE.values().length];
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E_TYPE.FB_SHARE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E_TYPE.TM_SHARE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E_TYPE.TW_SHARE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E_TYPE.SMS_SHARE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E_TYPE.FB_MESSENGER_SHARE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E_TYPE.EMAIL_SHARE_BODY.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E_TYPE.EMAIL_SHARE_SUBJECT.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E_TYPE.FB_DIALOG_SHARE.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
