// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;


// Referenced classes of package com.millennialmedia.internal:
//            MMActivity

public static class orientation
{

    private int audioSource;
    private Integer enterAnimationId;
    private Integer exitAnimationId;
    private boolean immersive;
    private int orientation;
    private boolean transparent;

    public orientation setAudioSource(int i)
    {
        audioSource = i;
        return this;
    }

    public audioSource setImmersive(boolean flag)
    {
        immersive = flag;
        return this;
    }

    public immersive setOrientation(int i)
    {
        orientation = i;
        return this;
    }

    public orientation setTransitionAnimation(Integer integer, Integer integer1)
    {
        enterAnimationId = integer;
        exitAnimationId = integer1;
        return this;
    }

    public exitAnimationId setTransparent(boolean flag)
    {
        transparent = flag;
        return this;
    }





/*
    static int access$302( , int i)
    {
        .orientation = i;
        return i;
    }

*/




    public orientation()
    {
        audioSource = -1;
        orientation = -1;
    }
}
