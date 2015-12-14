// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.messaging;

import android.net.Uri;

public class ChooserResultEvent
{

    public final Uri data;
    public final String type;

    public ChooserResultEvent(Uri uri, String s)
    {
        data = uri;
        type = s;
    }
}
