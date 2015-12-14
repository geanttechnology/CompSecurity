// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.notifications;

import com.picsart.studio.utils.ItemControl;

// Referenced classes of package com.socialin.android.photo.notifications:
//            a

final class 
{

    static final int a[];

    static 
    {
        a = new int[ItemControl.values().length];
        try
        {
            a[ItemControl.COMMENT_IMAGE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[ItemControl.OWNER_NAME_TEXT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[ItemControl.FOLLOW_USER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[ItemControl.OWNER_IMAGE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[ItemControl.IMAGE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[ItemControl.APPBOY_NEWS.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
