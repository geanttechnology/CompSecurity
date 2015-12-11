// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import com.poshmark.utils.sharing.share_states.Payload;

// Referenced classes of package com.poshmark.utils.sharing:
//            ShareMessagesContainer

public class ServerShareMessages
{

    ShareMessagesContainer data;

    public ServerShareMessages()
    {
    }

    public String getBody(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[];

            static 
            {
                $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE = new int[com.poshmark.utils.ShareManager.SHARE_TYPE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.FB_DIALOG_SHARE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.FB_MESSENGER_SHARE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.FB_SHARE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.TM_SHARE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.TW_SHARE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.EMAIL_SHARE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.SMS_SHARE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.PINTEREST_SHARE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()];
        JVM INSTR tableswitch 1 8: default 56
    //                   1 58
    //                   2 86
    //                   3 114
    //                   4 142
    //                   5 170
    //                   6 198
    //                   7 226
    //                   8 254;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        return null;
_L2:
        if (data != null && data.fbd != null)
        {
            return data.fbd.body;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (data != null && data.fbm != null)
        {
            return data.fbm.body;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (data != null && data.fb != null)
        {
            return data.fb.body;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (data != null && data.tm != null)
        {
            return data.tm.body;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (data != null && data.tw != null)
        {
            return data.tw.body;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (data != null && data.email != null)
        {
            return data.email.body;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (data != null && data.sms != null)
        {
            return data.sms.body;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (data != null && data.pnd != null)
        {
            return data.pnd.body;
        }
        if (true) goto _L1; else goto _L10
_L10:
    }

    public String getDescription(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()];
        JVM INSTR tableswitch 1 8: default 56
    //                   1 58
    //                   2 86
    //                   3 114
    //                   4 142
    //                   5 170
    //                   6 198
    //                   7 226
    //                   8 254;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        return null;
_L2:
        if (data != null && data.fbd != null)
        {
            return data.fbd.description;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (data != null && data.fbm != null)
        {
            return data.fbm.description;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (data != null && data.fb != null)
        {
            return data.fb.description;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (data != null && data.tm != null)
        {
            return data.tm.description;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (data != null && data.tw != null)
        {
            return data.tw.description;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (data != null && data.email != null)
        {
            return data.email.description;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (data != null && data.sms != null)
        {
            return data.sms.description;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (data != null && data.pnd != null)
        {
            return data.pnd.description;
        }
        if (true) goto _L1; else goto _L10
_L10:
    }

    public String getImageUrl(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()];
        JVM INSTR tableswitch 1 8: default 56
    //                   1 58
    //                   2 86
    //                   3 114
    //                   4 142
    //                   5 170
    //                   6 198
    //                   7 226
    //                   8 254;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        return null;
_L2:
        if (data != null && data.fbd != null)
        {
            return data.fbd.image_url;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (data != null && data.fbm != null)
        {
            return data.fbm.image_url;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (data != null && data.fb != null)
        {
            return data.fb.image_url;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (data != null && data.tm != null)
        {
            return data.tm.image_url;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (data != null && data.tw != null)
        {
            return data.tw.image_url;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (data != null && data.email != null)
        {
            return data.email.image_url;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (data != null && data.sms != null)
        {
            return data.sms.image_url;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (data != null && data.pnd != null)
        {
            return data.pnd.image_url;
        }
        if (true) goto _L1; else goto _L10
_L10:
    }

    public String getMessage(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()];
        JVM INSTR tableswitch 1 8: default 56
    //                   1 58
    //                   2 86
    //                   3 114
    //                   4 142
    //                   5 170
    //                   6 198
    //                   7 226
    //                   8 254;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        return null;
_L2:
        if (data != null && data.fbd != null)
        {
            return data.fbd.message;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (data != null && data.fbm != null)
        {
            return data.fbm.message;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (data != null && data.fb != null)
        {
            return data.fb.message;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (data != null && data.tm != null)
        {
            return data.tm.message;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (data != null && data.tw != null)
        {
            return data.tw.message;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (data != null && data.email != null)
        {
            return data.email.message;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (data != null && data.sms != null)
        {
            return data.sms.message;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (data != null && data.pnd != null)
        {
            return data.pnd.message;
        }
        if (true) goto _L1; else goto _L10
_L10:
    }

    public String getPlaceHolder(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()];
        JVM INSTR tableswitch 1 8: default 56
    //                   1 58
    //                   2 86
    //                   3 114
    //                   4 142
    //                   5 170
    //                   6 198
    //                   7 226
    //                   8 254;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        return null;
_L2:
        if (data != null && data.fbd != null)
        {
            return data.fbd.placeholder;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (data != null && data.fbm != null)
        {
            return data.fbm.placeholder;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (data != null && data.fb != null)
        {
            return data.fb.placeholder;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (data != null && data.tm != null)
        {
            return data.tm.placeholder;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (data != null && data.tw != null)
        {
            return data.tw.placeholder;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (data != null && data.email != null)
        {
            return data.email.placeholder;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (data != null && data.sms != null)
        {
            return data.sms.placeholder;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (data != null && data.pnd != null)
        {
            return data.pnd.placeholder;
        }
        if (true) goto _L1; else goto _L10
_L10:
    }

    public String getSubject(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()];
        JVM INSTR tableswitch 1 8: default 56
    //                   1 58
    //                   2 86
    //                   3 114
    //                   4 142
    //                   5 170
    //                   6 198
    //                   7 226
    //                   8 254;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        return null;
_L2:
        if (data != null && data.fbd != null)
        {
            return data.fbd.subject;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (data != null && data.fbm != null)
        {
            return data.fbm.subject;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (data != null && data.fb != null)
        {
            return data.fb.subject;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (data != null && data.tm != null)
        {
            return data.tm.subject;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (data != null && data.tw != null)
        {
            return data.tw.subject;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (data != null && data.email != null)
        {
            return data.email.subject;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (data != null && data.sms != null)
        {
            return data.sms.subject;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (data != null && data.pnd != null)
        {
            return data.pnd.subject;
        }
        if (true) goto _L1; else goto _L10
_L10:
    }

    public String getTitle(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()];
        JVM INSTR tableswitch 1 8: default 56
    //                   1 58
    //                   2 86
    //                   3 114
    //                   4 142
    //                   5 170
    //                   6 198
    //                   7 226
    //                   8 254;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        return null;
_L2:
        if (data != null && data.fbd != null)
        {
            return data.fbd.title;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (data != null && data.fbm != null)
        {
            return data.fbm.title;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (data != null && data.fb != null)
        {
            return data.fb.title;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (data != null && data.tm != null)
        {
            return data.tm.title;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (data != null && data.tw != null)
        {
            return data.tw.title;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (data != null && data.email != null)
        {
            return data.email.title;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (data != null && data.sms != null)
        {
            return data.sms.title;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (data != null && data.pnd != null)
        {
            return data.pnd.title;
        }
        if (true) goto _L1; else goto _L10
_L10:
    }

    public String getUrl(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()];
        JVM INSTR tableswitch 1 8: default 56
    //                   1 58
    //                   2 86
    //                   3 114
    //                   4 142
    //                   5 170
    //                   6 198
    //                   7 226
    //                   8 254;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        return null;
_L2:
        if (data != null && data.fbd != null)
        {
            return data.fbd.url;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (data != null && data.fbm != null)
        {
            return data.fbm.url;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (data != null && data.fb != null)
        {
            return data.fb.url;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (data != null && data.tm != null)
        {
            return data.tm.url;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (data != null && data.tw != null)
        {
            return data.tw.url;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (data != null && data.email != null)
        {
            return data.email.url;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (data != null && data.sms != null)
        {
            return data.sms.url;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (data != null && data.pnd != null)
        {
            return data.pnd.url;
        }
        if (true) goto _L1; else goto _L10
_L10:
    }
}
