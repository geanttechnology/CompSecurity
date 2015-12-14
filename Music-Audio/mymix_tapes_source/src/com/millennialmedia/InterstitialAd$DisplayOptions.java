// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            InterstitialAd

public static class 
{

    public Integer enterAnimationId;
    public Integer exitAnimationId;
    public boolean immersive;

    public  setImmersive(boolean flag)
    {
        immersive = flag;
        return this;
    }

    public immersive setTransitionAnimation(int i, int j)
    {
        enterAnimationId = Integer.valueOf(i);
        exitAnimationId = Integer.valueOf(j);
        return this;
    }

    public ()
    {
    }
}
