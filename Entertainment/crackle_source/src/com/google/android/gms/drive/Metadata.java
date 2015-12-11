// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fi;
import java.util.Date;

// Referenced classes of package com.google.android.gms.drive:
//            DriveId

public abstract class Metadata
    implements Freezable
{

    public Metadata()
    {
    }

    protected abstract Object a(MetadataField metadatafield);

    public Date getCreatedDate()
    {
        return (Date)a(fi.rL);
    }

    public DriveId getDriveId()
    {
        return (DriveId)a(fh.rG);
    }

    public String getMimeType()
    {
        return (String)a(fh.MIME_TYPE);
    }

    public Date getModifiedByMeDate()
    {
        return (Date)a(fi.rK);
    }

    public Date getModifiedDate()
    {
        return (Date)a(fi.rJ);
    }

    public Date getSharedWithMeDate()
    {
        return (Date)a(fi.rM);
    }

    public String getTitle()
    {
        return (String)a(fh.TITLE);
    }

    public boolean isEditable()
    {
        Boolean boolean1 = (Boolean)a(fh.rH);
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public boolean isFolder()
    {
        return "application/vnd.google-apps.folder".equals(getMimeType());
    }

    public boolean isStarred()
    {
        Boolean boolean1 = (Boolean)a(fh.STARRED);
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public boolean isTrashed()
    {
        Boolean boolean1 = (Boolean)a(fh.TRASHED);
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }
}
