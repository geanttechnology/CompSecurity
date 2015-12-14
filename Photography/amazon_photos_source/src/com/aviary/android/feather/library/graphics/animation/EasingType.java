// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics.animation;


public class EasingType
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type IN;
        public static final Type INOUT;
        public static final Type OUT;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/aviary/android/feather/library/graphics/animation/EasingType$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            IN = new Type("IN", 0);
            OUT = new Type("OUT", 1);
            INOUT = new Type("INOUT", 2);
            $VALUES = (new Type[] {
                IN, OUT, INOUT
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    public EasingType()
    {
    }
}
