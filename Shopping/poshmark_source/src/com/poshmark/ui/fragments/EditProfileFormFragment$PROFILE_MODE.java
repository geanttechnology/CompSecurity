// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            EditProfileFormFragment

public static final class  extends Enum
{

    private static final PROFILE_MODE_EDIT $VALUES[];
    public static final PROFILE_MODE_EDIT PROFILE_MODE_CREATE;
    public static final PROFILE_MODE_EDIT PROFILE_MODE_EDIT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PROFILE_MODE_CREATE = new <init>("PROFILE_MODE_CREATE", 0);
        PROFILE_MODE_EDIT = new <init>("PROFILE_MODE_EDIT", 1);
        $VALUES = (new .VALUES[] {
            PROFILE_MODE_CREATE, PROFILE_MODE_EDIT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
