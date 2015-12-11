// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.contextualmenu.api;


// Referenced classes of package com.fanhattan.services.contextualmenu.api:
//            ContextualMenuService, ContextualMenu

public static interface 
{

    public abstract ContextualMenu createContextualMenu();

    public abstract void onCloseContextualMenu();

    public abstract boolean onContextualMenuSelected(String s);
}
