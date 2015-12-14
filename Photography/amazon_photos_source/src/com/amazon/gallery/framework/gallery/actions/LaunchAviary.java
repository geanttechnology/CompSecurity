// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.net.Uri;
import java.io.File;

public interface LaunchAviary
{

    public abstract void launch(Activity activity, Uri uri, File file, int i);
}
