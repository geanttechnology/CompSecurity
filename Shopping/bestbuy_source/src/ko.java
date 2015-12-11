// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.ImageView;
import android.widget.LinearLayout;

public class ko extends LinearLayout
{

    public void a(int i)
    {
        int j = 0;
        while (j < getChildCount()) 
        {
            ImageView imageview = (ImageView)getChildAt(j);
            if (i == j)
            {
                if (imageview != null)
                {
                    imageview.setSelected(true);
                }
            } else
            {
                imageview.setSelected(false);
            }
            j++;
        }
    }
}
