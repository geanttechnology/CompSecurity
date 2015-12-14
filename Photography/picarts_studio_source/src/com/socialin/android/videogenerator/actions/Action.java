// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import java.io.Serializable;
import myobfuscated.cz.a;

public abstract class Action
    implements Serializable
{

    private static final long serialVersionUID = 0x999160dd1475b1fcL;
    private boolean isVisible;
    private String snapshotKey;

    protected Action(String s)
    {
        snapshotKey = s;
        isVisible = true;
    }

    public abstract void apply(a a);

    public void apply(a a, int i)
    {
        apply(a);
    }

    public abstract String getActionDescription();

    public String getSnapshotKey()
    {
        return snapshotKey;
    }

    public boolean isVisible()
    {
        return isVisible;
    }

    public void setVisibile(boolean flag)
    {
        isVisible = flag;
    }
}
