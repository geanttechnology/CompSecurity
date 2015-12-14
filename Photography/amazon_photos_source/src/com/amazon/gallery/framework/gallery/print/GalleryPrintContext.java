// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.print;

import android.app.Activity;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import java.util.List;

public interface GalleryPrintContext
{

    public abstract boolean canExecute(List list);

    public abstract void destroyPrintContext();

    public abstract void prepareItemsToPrint(List list);

    public abstract void setContext(Activity activity);

    public abstract void setShareStore(ShareStore sharestore);
}
