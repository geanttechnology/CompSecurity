// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            ShareManager

static class ARE_MODE
{

    static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[];
    static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[];

    static 
    {
        $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE = new int[ARE_TYPE.values().length];
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[ARE_TYPE.FB_DIALOG_SHARE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[ARE_TYPE.FB_SHARE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[ARE_TYPE.FB_MESSENGER_SHARE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[ARE_TYPE.TM_SHARE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[ARE_TYPE.TW_SHARE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[ARE_TYPE.EMAIL_SHARE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[ARE_TYPE.PINTEREST_SHARE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[ARE_TYPE.SMS_SHARE.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE = new int[ARE_MODE.values().length];
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[ARE_MODE.SHARE_MODE_LISTING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[ARE_MODE.SHARE_MODE_PARTY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[ARE_MODE.SHARE_MODE_CLOSET.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[ARE_MODE.SHARE_MODE_SHOWROOM.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[ARE_MODE.SHARE_MODE_BRAND.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[ARE_MODE.SHARE_MODE_INVITE_FRIENDS.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[ARE_MODE.SHARE_MODE_BRAND_JUSTIN.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
