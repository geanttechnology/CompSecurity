// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.svg;

import java.io.Serializable;

public class NodeAttributeBean
    implements Serializable
{

    private int command;
    private float fx;
    private float fx1;
    private float fx2;
    private float fy;
    private float fy1;
    private float fy2;

    public NodeAttributeBean()
    {
    }

    public int getCommand()
    {
        return command;
    }

    public float getFx()
    {
        return fx;
    }

    public float getFx1()
    {
        return fx1;
    }

    public float getFx2()
    {
        return fx2;
    }

    public float getFy()
    {
        return fy;
    }

    public float getFy1()
    {
        return fy1;
    }

    public float getFy2()
    {
        return fy2;
    }

    public void setCommand(int i)
    {
        command = i;
    }

    public void setFx(float f)
    {
        fx = f;
    }

    public void setFx1(float f)
    {
        fx1 = f;
    }

    public void setFx2(float f)
    {
        fx2 = f;
    }

    public void setFy(float f)
    {
        fy = f;
    }

    public void setFy1(float f)
    {
        fy1 = f;
    }

    public void setFy2(float f)
    {
        fy2 = f;
    }
}
