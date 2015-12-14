// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.cab;


// Referenced classes of package com.amazon.gallery.framework.gallery.cab:
//            SelectionChecker

public interface ContextBar
    extends SelectionChecker
{

    public abstract void addSelectable(Object obj);

    public abstract void hide();

    public abstract boolean isContextBarActive();

    public abstract boolean isSelected(Object obj);

    public abstract void onPause();

    public abstract void onResume();

    public abstract void removeSelectable(Object obj);

    public abstract void show();
}
