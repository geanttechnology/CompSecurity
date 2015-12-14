// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.graphics;


// Referenced classes of package com.aviary.android.feather.sdk.graphics:
//            GlowDrawable

static class 
{

    boolean checked;
    boolean pressed;
    boolean selected;

    public String toString()
    {
        return (new StringBuilder()).append("{ pressed: ").append(pressed).append(", checked: ").append(checked).append(", selected: ").append(selected).append(" }").toString();
    }

    public boolean updateStateSet(int ai[])
    {
        int j = ai.length;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag = false;
        int i = 0;
        while (i < j) 
        {
            int k = ai[i];
            boolean flag3 = flag2;
            boolean flag5 = flag1;
            boolean flag6 = flag;
            if (k > 0)
            {
                if (k == 0x10100a1)
                {
                    flag6 = true;
                    flag5 = flag1;
                    flag3 = flag2;
                } else
                if (k == 0x10100a7)
                {
                    flag5 = true;
                    flag3 = flag2;
                    flag6 = flag;
                } else
                {
                    flag3 = flag2;
                    flag5 = flag1;
                    flag6 = flag;
                    if (k == 0x10100a0)
                    {
                        flag3 = true;
                        flag5 = flag1;
                        flag6 = flag;
                    }
                }
            }
            i++;
            flag2 = flag3;
            flag1 = flag5;
            flag = flag6;
        }
        boolean flag4;
        if (pressed != flag1 || checked != flag2 || selected != flag)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        pressed = flag1;
        checked = flag2;
        selected = flag;
        return flag4;
    }

    ()
    {
    }
}
