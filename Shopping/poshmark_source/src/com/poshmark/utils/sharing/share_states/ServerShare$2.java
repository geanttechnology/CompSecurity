// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;


// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ServerShare

static class 
{

    static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[];

    static 
    {
        $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE = new int[com.poshmark.utils.HARE_MODE.values().length];
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.HARE_MODE.SHARE_MODE_LISTING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.HARE_MODE.SHARE_MODE_BRAND.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.HARE_MODE.SHARE_MODE_SHOWROOM.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.HARE_MODE.SHARE_MODE_INVITE_FRIENDS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.HARE_MODE.SHARE_MODE_CLOSET.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.HARE_MODE.SHARE_MODE_PARTY.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
