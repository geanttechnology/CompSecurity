// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.view.View;
import android.widget.ImageView;

public class StarRatingLayoutHelper
{

    public StarRatingLayoutHelper()
    {
    }

    public static void setStarRating(View view, int i)
    {
        if (i > 0)
        {
            ((ImageView)view.findViewById(0x7f0a0180)).setImageResource(0x7f02011c);
        } else
        {
            ((ImageView)view.findViewById(0x7f0a0180)).setImageResource(0x7f02011b);
        }
        if (i > 1)
        {
            ((ImageView)view.findViewById(0x7f0a0181)).setImageResource(0x7f02011c);
        } else
        {
            ((ImageView)view.findViewById(0x7f0a0181)).setImageResource(0x7f02011b);
        }
        if (i > 2)
        {
            ((ImageView)view.findViewById(0x7f0a0182)).setImageResource(0x7f02011c);
        } else
        {
            ((ImageView)view.findViewById(0x7f0a0182)).setImageResource(0x7f02011b);
        }
        if (i > 3)
        {
            ((ImageView)view.findViewById(0x7f0a0183)).setImageResource(0x7f02011c);
        } else
        {
            ((ImageView)view.findViewById(0x7f0a0183)).setImageResource(0x7f02011b);
        }
        if (i > 4)
        {
            ((ImageView)view.findViewById(0x7f0a0184)).setImageResource(0x7f02011c);
            return;
        } else
        {
            ((ImageView)view.findViewById(0x7f0a0184)).setImageResource(0x7f02011b);
            return;
        }
    }
}
