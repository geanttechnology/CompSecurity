// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.content.Context;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            DibicProgramFilter

public static final class contentDescriptionResStringId extends Enum
{

    private static final ALPHA $VALUES[];
    public static final ALPHA ALPHA;
    public static final ALPHA GENRE;
    public static final ALPHA NETWORK;
    public static final ALPHA PROGRAM_TYPE;
    private final int contentDescriptionResStringId;
    private final int labelResStringId;
    private int navListIndex;

    public static contentDescriptionResStringId int2FilterCategory(int i)
    {
        contentDescriptionResStringId acontentdescriptionresstringid[] = values();
        int k = acontentdescriptionresstringid.length;
        for (int j = 0; j < k; j++)
        {
            contentDescriptionResStringId contentdescriptionresstringid = acontentdescriptionresstringid[j];
            if (contentdescriptionresstringid.ordinal() == i)
            {
                return contentdescriptionresstringid;
            }
        }

        return GENRE;
    }

    public static GENRE valueOf(String s)
    {
        return (GENRE)Enum.valueOf(com/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory, s);
    }

    public static GENRE[] values()
    {
        return (GENRE[])$VALUES.clone();
    }

    public CharSequence getContentDescription(Context context)
    {
        String s = context.getString(contentDescriptionResStringId);
        return context.getString(com.xfinity.playerlib.r, new Object[] {
            s
        });
    }

    public CharSequence getLabel(Context context)
    {
        return context.getString(labelResStringId);
    }

    public int getNavListIndex()
    {
        return navListIndex;
    }

    static 
    {
        NETWORK = new <init>("NETWORK", 0, com.xfinity.playerlib.lter.FilterCategory, 1, com.xfinity.playerlib.r_networks);
        GENRE = new <init>("GENRE", 1, com.xfinity.playerlib.lter.FilterCategory, 0, com.xfinity.playerlib.r_genres);
        PROGRAM_TYPE = new <init>("PROGRAM_TYPE", 2, com.xfinity.playerlib.lter.FilterCategory, 3, com.xfinity.playerlib.r_type);
        ALPHA = new <init>("ALPHA", 3, com.xfinity.playerlib.lter.FilterCategory, 2, com.xfinity.playerlib.r_titles_atoz);
        $VALUES = (new .VALUES[] {
            NETWORK, GENRE, PROGRAM_TYPE, ALPHA
        });
    }

    private Q(String s, int i, int j, int k, int l)
    {
        super(s, i);
        labelResStringId = j;
        navListIndex = k;
        contentDescriptionResStringId = l;
    }
}
