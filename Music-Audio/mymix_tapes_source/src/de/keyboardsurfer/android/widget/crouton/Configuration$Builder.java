// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.keyboardsurfer.android.widget.crouton;


// Referenced classes of package de.keyboardsurfer.android.widget.crouton:
//            Configuration

public static class outAnimationResId
{

    private int durationInMilliseconds;
    private int inAnimationResId;
    private int outAnimationResId;

    public Configuration build()
    {
        return new Configuration(this, null);
    }

    public outAnimationResId setDuration(int i)
    {
        durationInMilliseconds = i;
        return this;
    }

    public durationInMilliseconds setInAnimation(int i)
    {
        inAnimationResId = i;
        return this;
    }

    public inAnimationResId setOutAnimation(int i)
    {
        outAnimationResId = i;
        return this;
    }




    public ()
    {
        durationInMilliseconds = 3000;
        inAnimationResId = 0;
        outAnimationResId = 0;
    }
}
