// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.net.Uri;
import com.perfectcorp.model.Model;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            FileMetadata

public class a extends Model
{

    private FileMetadata a;
    public Long downloadCount;
    public Long fileId;
    public String fileType;
    public Uri fileUri;
    public String metadata;

    public FileMetadata b()
    {
        if (a == null)
        {
            a = (FileMetadata)Model.a(com/cyberlink/beautycircle/model/FileMetadata, metadata);
            if (a == null)
            {
                return new FileMetadata();
            }
            if (a.redirectUrl != null && a.redirectUrl.toString().isEmpty())
            {
                a.redirectUrl = null;
            }
        }
        return a;
    }

    public ()
    {
        fileType = null;
        downloadCount = null;
        metadata = null;
        a = null;
    }
}
