// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;


// Referenced classes of package com.poshmark.utils.sharing:
//            ClosetShareMessages

static class 
{

    static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[];

    static 
    {
        $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE = new int[com.poshmark.utils.E.values().length];
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E.FB_DIALOG_SHARE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E.TW_SHARE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E.TM_SHARE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E.PINTEREST_SHARE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E.SMS_SHARE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E.EMAIL_SHARE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E.FB_MESSENGER_SHARE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E.FB_SHARE.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E.EMAIL_SHARE_BODY.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.E.EMAIL_SHARE_SUBJECT.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
