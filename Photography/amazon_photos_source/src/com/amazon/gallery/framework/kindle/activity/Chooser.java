// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.net.Uri;

public interface Chooser
{

    public abstract void finishActivityAndAttachResult(Uri uri, String s);

    public abstract String getImageMediaType();

    public abstract Object getItemAtPosition(int i);
}
