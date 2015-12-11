// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.graphics.drawable.Drawable;
import java.util.Arrays;

class MarkerImage
{

    Drawable marker;
    Drawable shadow;

    MarkerImage(Drawable drawable, Drawable drawable1)
    {
        marker = drawable;
        shadow = drawable1;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof MarkerImage))
            {
                return false;
            }
            obj = (MarkerImage)obj;
            boolean flag = marker.getConstantState().equals(((MarkerImage) (obj)).marker.getConstantState());
            if (shadow != null)
            {
                if (!flag || !shadow.getConstantState().equals(((MarkerImage) (obj)).shadow.getConstantState()))
                {
                    return false;
                }
            } else
            {
                return flag;
            }
        }
        return true;
    }

    public int hashCode()
    {
        if (shadow != null)
        {
            return Arrays.hashCode(new Object[] {
                marker.getConstantState(), shadow.getConstantState()
            });
        } else
        {
            return Arrays.hashCode(new Object[] {
                marker.getConstantState()
            });
        }
    }
}
