// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import java.lang.ref.WeakReference;

// Referenced classes of package com.groupon.fragment:
//            GrouponFragmentDelegate, GrouponFragmentInterface

protected static class ref
    implements Runnable
{

    private WeakReference ref;

    public void run()
    {
        GrouponFragmentDelegate grouponfragmentdelegate = (GrouponFragmentDelegate)ref.get();
        if (grouponfragmentdelegate != null)
        {
            GrouponFragmentDelegate.access$000(grouponfragmentdelegate).forceReload();
        }
    }

    public (GrouponFragmentDelegate grouponfragmentdelegate)
    {
        ref = new WeakReference(grouponfragmentdelegate);
    }
}
