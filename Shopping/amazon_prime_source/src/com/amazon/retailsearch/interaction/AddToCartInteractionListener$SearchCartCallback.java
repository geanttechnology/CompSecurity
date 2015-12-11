// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;


// Referenced classes of package com.amazon.retailsearch.interaction:
//            AddToCartInteractionListener

public static interface Y
{

    public abstract void error();

    public abstract void error(int i, String s, int j);

    public abstract void success();

    public abstract void success(int i, String s, int j);
}
