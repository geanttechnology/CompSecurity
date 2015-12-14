// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import android.os.Build;
import android.os.Environment;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            UploadPathResolver

public class DefaultUploadPathResolver
    implements UploadPathResolver
{

    public DefaultUploadPathResolver(RestClient restclient, DeviceAttributeStore deviceattributestore)
    {
    }

    public String getPath(MediaItem mediaitem, String s)
        throws TerminalException, TransientException
    {
        mediaitem = mediaitem.getTags();
        if (mediaitem.isEmpty())
        {
            throw new InvalidParameterException("Trying to upload to a media item that has no album associated with it!");
        } else
        {
            mediaitem = (Tag)mediaitem.iterator().next();
            return (new StringBuilder(Environment.DIRECTORY_PICTURES)).append("/").append(Build.MODEL).append("/").append(mediaitem.getLabel()).toString();
        }
    }
}
