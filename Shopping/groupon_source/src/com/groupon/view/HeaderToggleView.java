// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;


// Referenced classes of package com.groupon.view:
//            HeaderTogglePresenter

public interface HeaderToggleView
{

    public abstract HeaderTogglePresenter getPresenter();

    public abstract void setEnabled(boolean flag);

    public abstract void setTitle(String s);

    public abstract void setToggled(boolean flag);
}
