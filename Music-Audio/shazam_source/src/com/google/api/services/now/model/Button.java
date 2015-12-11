// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;

// Referenced classes of package com.google.api.services.now.model:
//            Action

public final class Button extends b
{

    private String icon;
    private String name;
    private Action tapAction;

    public Button()
    {
    }

    public final volatile b clone()
    {
        return clone();
    }

    public final volatile l clone()
    {
        return clone();
    }

    public final Button clone()
    {
        return (Button)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final String getIcon()
    {
        return icon;
    }

    public final String getName()
    {
        return name;
    }

    public final Action getTapAction()
    {
        return tapAction;
    }

    public final volatile b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final Button set(String s, Object obj)
    {
        return (Button)super.set(s, obj);
    }

    public final Button setIcon(String s)
    {
        icon = s;
        return this;
    }

    public final Button setName(String s)
    {
        name = s;
        return this;
    }

    public final Button setTapAction(Action action)
    {
        tapAction = action;
        return this;
    }
}
