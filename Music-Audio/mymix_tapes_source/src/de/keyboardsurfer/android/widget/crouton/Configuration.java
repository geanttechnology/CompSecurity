// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.keyboardsurfer.android.widget.crouton;


public class Configuration
{
    public static class Builder
    {

        private int durationInMilliseconds;
        private int inAnimationResId;
        private int outAnimationResId;

        public Configuration build()
        {
            return new Configuration(this);
        }

        public Builder setDuration(int i)
        {
            durationInMilliseconds = i;
            return this;
        }

        public Builder setInAnimation(int i)
        {
            inAnimationResId = i;
            return this;
        }

        public Builder setOutAnimation(int i)
        {
            outAnimationResId = i;
            return this;
        }




        public Builder()
        {
            durationInMilliseconds = 3000;
            inAnimationResId = 0;
            outAnimationResId = 0;
        }
    }


    public static final Configuration DEFAULT = (new Builder()).setDuration(3000).build();
    public static final int DURATION_INFINITE = -1;
    public static final int DURATION_LONG = 5000;
    public static final int DURATION_SHORT = 3000;
    final int durationInMilliseconds;
    final int inAnimationResId;
    final int outAnimationResId;

    private Configuration(Builder builder)
    {
        durationInMilliseconds = builder.durationInMilliseconds;
        inAnimationResId = builder.inAnimationResId;
        outAnimationResId = builder.outAnimationResId;
    }


    public String toString()
    {
        return (new StringBuilder()).append("Configuration{durationInMilliseconds=").append(durationInMilliseconds).append(", inAnimationResId=").append(inAnimationResId).append(", outAnimationResId=").append(outAnimationResId).append('}').toString();
    }

}
