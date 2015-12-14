// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.provider;

import android.net.Uri;

public class UnknownUriException extends IllegalArgumentException
{

    public UnknownUriException(Uri uri)
    {
        super((new StringBuilder()).append("Unknown URI ").append(uri).toString());
    }
}
