// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            Action

public abstract class AsyncAction extends Action
{

    private static final long serialVersionUID = 0x53fd7b00f7579424L;
    private boolean isReady;

    protected AsyncAction(String s)
    {
        super(s);
        isReady = false;
    }

    public abstract void apply(a a);

    public boolean isReady()
    {
        return isReady;
    }

    public void setReady(boolean flag)
    {
        isReady = flag;
    }
}
