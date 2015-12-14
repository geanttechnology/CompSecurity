// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.model.media.MediaItem;

public interface ViewDescriptorAction
{

    public abstract boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem);

    public abstract void executeViewDescriptor(ViewDescriptor viewdescriptor, MediaItem mediaitem);
}
