// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;


public interface GalleryMediaController
{
    public static interface OnBackKeyPressedListener
    {

        public abstract boolean onBackKeyPressed();
    }

    public static interface OnVisibilityChangeListener
    {

        public abstract void hide();

        public abstract void onHideController();

        public abstract void show();
    }


    public abstract void addBackKeyPressedListener(OnBackKeyPressedListener onbackkeypressedlistener);

    public abstract void addOnVisibilityChangeListener(OnVisibilityChangeListener onvisibilitychangelistener);

    public abstract void clearListeners();

    public abstract void removeBackKeyPressedListener(OnBackKeyPressedListener onbackkeypressedlistener);

    public abstract void show();

    public abstract void show(int i, boolean flag, boolean flag1);
}
