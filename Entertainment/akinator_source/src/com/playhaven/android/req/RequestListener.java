// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android.req;

import android.content.Context;
import com.playhaven.android.PlayHavenException;

public interface RequestListener
{

    public abstract void handleResponse(Context context, PlayHavenException playhavenexception);

    public abstract void handleResponse(Context context, String s);
}
