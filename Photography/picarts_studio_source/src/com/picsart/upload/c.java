// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.upload;

import android.net.Uri;
import android.provider.BaseColumns;

public final class c
    implements BaseColumns
{

    public static final Uri a = Uri.parse("content://com.picsart.studio.provider/uploads");

    static 
    {
        Uri.parse("content://com.picsart.studio.provider/uploads/#");
        Uri.parse("content://com.picsart.studio.provider/uploads/*");
    }
}
