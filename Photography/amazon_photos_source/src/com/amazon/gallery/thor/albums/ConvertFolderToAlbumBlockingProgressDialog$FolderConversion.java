// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import com.amazon.gallery.framework.model.tags.Tag;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            ConvertFolderToAlbumBlockingProgressDialog

public static class albumTag
{

    private Tag albumTag;
    private String folderNodeId;

    public Tag getAlbumTag()
    {
        return albumTag;
    }


    public (String s, Tag tag)
    {
        folderNodeId = s;
        albumTag = tag;
    }
}
