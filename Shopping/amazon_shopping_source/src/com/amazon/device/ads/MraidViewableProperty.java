// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            MraidProperty

class MraidViewableProperty extends MraidProperty
{

    private final boolean mViewable;

    MraidViewableProperty(boolean flag)
    {
        mViewable = flag;
    }

    public static MraidViewableProperty createWithViewable(boolean flag)
    {
        return new MraidViewableProperty(flag);
    }

    public String toJsonPair()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("viewable: ");
        String s;
        if (mViewable)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        return stringbuilder.append(s).toString();
    }
}
