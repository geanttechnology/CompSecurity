// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;


class ArmArchHelper
{

    ArmArchHelper()
    {
    }

    native String cpuArchFromJNI();

    boolean isARM_v7_CPU(String s)
    {
        return s.contains("v7");
    }

    boolean isNeonSupported(String s)
    {
        return s.contains("-neon");
    }

    static 
    {
        System.loadLibrary("ARM_ARCH");
    }
}
