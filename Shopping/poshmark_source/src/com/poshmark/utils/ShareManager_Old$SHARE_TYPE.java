// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            ShareManager_Old

public static final class  extends Enum
{

    private static final EMAIL_SHARE_SUBJECT $VALUES[];
    public static final EMAIL_SHARE_SUBJECT EMAIL_SHARE;
    public static final EMAIL_SHARE_SUBJECT EMAIL_SHARE_BODY;
    public static final EMAIL_SHARE_SUBJECT EMAIL_SHARE_SUBJECT;
    public static final EMAIL_SHARE_SUBJECT FB_DIALOG_SHARE;
    public static final EMAIL_SHARE_SUBJECT FB_MESSENGER_SHARE;
    public static final EMAIL_SHARE_SUBJECT FB_SHARE;
    public static final EMAIL_SHARE_SUBJECT INSTAGRAM_SHARE;
    public static final EMAIL_SHARE_SUBJECT PINTEREST_SHARE;
    public static final EMAIL_SHARE_SUBJECT SMS_SHARE;
    public static final EMAIL_SHARE_SUBJECT TM_SHARE;
    public static final EMAIL_SHARE_SUBJECT TW_SHARE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/utils/ShareManager_Old$SHARE_TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FB_SHARE = new <init>("FB_SHARE", 0);
        TW_SHARE = new <init>("TW_SHARE", 1);
        TM_SHARE = new <init>("TM_SHARE", 2);
        INSTAGRAM_SHARE = new <init>("INSTAGRAM_SHARE", 3);
        PINTEREST_SHARE = new <init>("PINTEREST_SHARE", 4);
        SMS_SHARE = new <init>("SMS_SHARE", 5);
        FB_MESSENGER_SHARE = new <init>("FB_MESSENGER_SHARE", 6);
        FB_DIALOG_SHARE = new <init>("FB_DIALOG_SHARE", 7);
        EMAIL_SHARE = new <init>("EMAIL_SHARE", 8);
        EMAIL_SHARE_BODY = new <init>("EMAIL_SHARE_BODY", 9);
        EMAIL_SHARE_SUBJECT = new <init>("EMAIL_SHARE_SUBJECT", 10);
        $VALUES = (new .VALUES[] {
            FB_SHARE, TW_SHARE, TM_SHARE, INSTAGRAM_SHARE, PINTEREST_SHARE, SMS_SHARE, FB_MESSENGER_SHARE, FB_DIALOG_SHARE, EMAIL_SHARE, EMAIL_SHARE_BODY, 
            EMAIL_SHARE_SUBJECT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
