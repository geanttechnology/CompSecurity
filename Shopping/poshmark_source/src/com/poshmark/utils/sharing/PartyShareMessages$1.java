// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;


// Referenced classes of package com.poshmark.utils.sharing:
//            PartyShareMessages

static class 
{

    static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[];

    static 
    {
        $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE = new int[com.poshmark.utils.PE.values().length];
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.PE.FB_DIALOG_SHARE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.PE.TW_SHARE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.PE.TM_SHARE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.PE.PINTEREST_SHARE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.PE.SMS_SHARE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.PE.EMAIL_SHARE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.PE.FB_MESSENGER_SHARE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.PE.FB_SHARE.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
