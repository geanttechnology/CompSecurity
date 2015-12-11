// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv;

import java.nio.Buffer;

public class Frame
{

    public com.googlecode.javacv.cpp.opencv_core.IplImage image;
    public boolean keyFrame;
    public Buffer samples[];

    public Frame()
    {
    }
}
