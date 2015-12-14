// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;


// Referenced classes of package com.millennialmedia.internal:
//            SizableStateManager

public static interface 
{

    public abstract void onCollapsed();

    public abstract void onCollapsing();

    public abstract void onExpandFailed();

    public abstract void onExpanded();

    public abstract void onExpanding();

    public abstract void onResized(int i, int j);

    public abstract void onResizing(int i, int j);

    public abstract void onUnresized(int i, int j);

    public abstract void onUnresizing(int i, int j);
}
