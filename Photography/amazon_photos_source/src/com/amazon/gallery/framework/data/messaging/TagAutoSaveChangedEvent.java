// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.messaging;


public class TagAutoSaveChangedEvent
{

    private Runnable postRunnable;

    public TagAutoSaveChangedEvent()
    {
    }

    public Runnable getPostRunnable()
    {
        return postRunnable;
    }

    public void setPostRunnable(Runnable runnable)
    {
        postRunnable = runnable;
    }
}
