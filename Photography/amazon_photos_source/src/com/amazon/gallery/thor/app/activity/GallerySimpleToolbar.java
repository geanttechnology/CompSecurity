// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;


// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            GalleryNavigationSetting

public interface GallerySimpleToolbar
{

    public abstract void setNavigationOnClickListener(android.view.View.OnClickListener onclicklistener);

    public abstract void setNavigationSetting(GalleryNavigationSetting gallerynavigationsetting);

    public abstract void setTitle(CharSequence charsequence);
}
