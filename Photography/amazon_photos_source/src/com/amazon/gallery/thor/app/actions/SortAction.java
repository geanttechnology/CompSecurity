// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.actions;

import com.amazon.gallery.framework.gallery.actions.ViewDescriptorAction;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;

public class SortAction
    implements ViewDescriptorAction
{

    public SortAction()
    {
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        return mediaitem == null && (viewdescriptor == null || viewdescriptor.getMediaProperty() != CommonMediaProperty.THISDAY);
    }

    public void executeViewDescriptor(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
    }
}
