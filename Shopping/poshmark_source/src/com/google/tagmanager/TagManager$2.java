// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;

// Referenced classes of package com.google.tagmanager:
//            TagManager, Container

static final class ntainerProvider
    implements ntainerProvider
{

    public Container newContainer(Context context, String s, TagManager tagmanager)
    {
        return new Container(context, s, tagmanager);
    }

    ntainerProvider()
    {
    }
}
