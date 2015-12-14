// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;


// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            AbstractShareAction

static final class packageName extends Enum
{

    private static final Twitter $VALUES[];
    public static final Twitter Email;
    public static final Twitter Facebook;
    public static final Twitter Twitter;
    private String packageName;

    public static packageName valueOf(String s)
    {
        return (packageName)Enum.valueOf(com/amazon/gallery/framework/gallery/actions/AbstractShareAction$CommonSharedActivity, s);
    }

    public static packageName[] values()
    {
        return (packageName[])$VALUES.clone();
    }

    static 
    {
        Email = new <init>("Email", 0, "com.android.email.activity.MessageCompose");
        Facebook = new <init>("Facebook", 1, "com.amazon.unifiedshare.facebook.FacebookShareActivity");
        Twitter = new <init>("Twitter", 2, "com.amazon.unifiedshare.twitter.TwitterShareActivity");
        $VALUES = (new .VALUES[] {
            Email, Facebook, Twitter
        });
    }


    private (String s, int i, String s1)
    {
        super(s, i);
        packageName = s1;
    }
}
