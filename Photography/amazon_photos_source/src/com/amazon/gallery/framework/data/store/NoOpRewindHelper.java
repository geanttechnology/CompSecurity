// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import com.amazon.gallery.framework.model.media.RewindPhoto;
import com.bumptech.glide.GenericRequestBuilder;
import java.io.File;

public class NoOpRewindHelper
{

    public NoOpRewindHelper()
    {
    }

    public void deleteNonPreferredRewindFrames(RewindPhoto rewindphoto)
    {
    }

    public GenericRequestBuilder insertSignature(Object obj, GenericRequestBuilder genericrequestbuilder)
    {
        return genericrequestbuilder;
    }

    public boolean isRewindPhoto(File file)
    {
        return false;
    }

    public boolean isRewindPhoto(String s)
    {
        return false;
    }

    public void setRewindMetadata(RewindPhoto rewindphoto, File file)
    {
    }
}
