// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import java.io.Serializable;

public class 
    implements Serializable
{

    private static final long serialVersionUID = 0x8aba5ac52b28303bL;
    public int invisibleActionsCount;
    public int longActionsCount;
    public int shortActionsCount;

    public int getActionsCount()
    {
        return shortActionsCount + longActionsCount;
    }

    public ()
    {
    }
}
