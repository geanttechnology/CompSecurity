// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            Action

public class UndoAction extends Action
{

    private static final long serialVersionUID = 0x48b5908d0466532cL;

    public UndoAction(String s)
    {
        super(s);
        setVisibile(false);
    }

    public void apply(a a)
    {
    }

    public String getActionDescription()
    {
        return "";
    }

    public String toString()
    {
        return "Undo";
    }
}
