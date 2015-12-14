// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;


// Referenced classes of package com.targetspot.android.sdk.util:
//            ImageUtil

static final class val.handler
    implements Runnable
{

    final ageHandler val$handler;
    final String val$url;

    public void run()
    {
        ImageUtil.getImageBitmapFromURL(val$url, val$handler, false);
    }

    ageHandler(String s, ageHandler agehandler)
    {
        val$url = s;
        val$handler = agehandler;
        super();
    }
}
