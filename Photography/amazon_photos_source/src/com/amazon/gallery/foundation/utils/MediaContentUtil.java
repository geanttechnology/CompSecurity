// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils;

import com.amazon.gallery.foundation.utils.messaging.ContentFetcher;
import com.amazon.gallery.framework.gallery.messaging.ConfigurationContentFetcher;
import com.amazon.gallery.framework.gallery.messaging.ContentConfigurationEvent;
import com.amazon.gallery.framework.gallery.view.ContentConfiguration;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.model.tags.Tag;

public class MediaContentUtil
{

    public static Tag getTagFromContentConfiguration()
    {
        Object obj1 = null;
        Object obj = (ContentConfigurationEvent)(new ConfigurationContentFetcher()).getContentFromProducer();
        ViewDescriptor viewdescriptor;
        if (obj != null)
        {
            obj = ((ContentConfigurationEvent) (obj)).getContentConfiguration();
        } else
        {
            obj = null;
        }
        viewdescriptor = null;
        if (obj != null)
        {
            viewdescriptor = ((ContentConfiguration) (obj)).toViewDescriptor();
        }
        obj = obj1;
        if (viewdescriptor != null)
        {
            obj = viewdescriptor.getTag();
        }
        return ((Tag) (obj));
    }
}
