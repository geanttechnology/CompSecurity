// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.content.Context;
import com.amazon.gallery.framework.data.dao.sqlite.GalleryDBConnectionManager;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;

public class KindleGalleryDBConnectionManager extends GalleryDBConnectionManager
{

    private final AuthenticationManager authenticationManager;

    public KindleGalleryDBConnectionManager(Context context, AuthenticationManager authenticationmanager)
    {
        super(context);
        authenticationManager = authenticationmanager;
    }

    protected String getAccountIdentifier()
    {
        return authenticationManager.getAccountId();
    }
}
