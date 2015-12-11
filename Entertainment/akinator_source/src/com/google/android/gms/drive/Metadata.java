// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.internal.zznh;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

// Referenced classes of package com.google.android.gms.drive:
//            DriveId

public abstract class Metadata
    implements Freezable
{

    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    public Metadata()
    {
    }

    public String getAlternateLink()
    {
        return (String)zza(zznd.zzamK);
    }

    public int getContentAvailability()
    {
        Integer integer = (Integer)zza(zznh.zzanI);
        if (integer == null)
        {
            return 0;
        } else
        {
            return integer.intValue();
        }
    }

    public Date getCreatedDate()
    {
        return (Date)zza(zznf.zzanB);
    }

    public Map getCustomProperties()
    {
        AppVisibleCustomProperties appvisiblecustomproperties = (AppVisibleCustomProperties)zza(zznd.zzamL);
        if (appvisiblecustomproperties == null)
        {
            return Collections.emptyMap();
        } else
        {
            return appvisiblecustomproperties.zzrH();
        }
    }

    public String getDescription()
    {
        return (String)zza(zznd.zzamM);
    }

    public DriveId getDriveId()
    {
        return (DriveId)zza(zznd.zzamJ);
    }

    public String getEmbedLink()
    {
        return (String)zza(zznd.zzamN);
    }

    public String getFileExtension()
    {
        return (String)zza(zznd.zzamO);
    }

    public long getFileSize()
    {
        return ((Long)zza(zznd.zzamP)).longValue();
    }

    public Date getLastViewedByMeDate()
    {
        return (Date)zza(zznf.zzanC);
    }

    public String getMimeType()
    {
        return (String)zza(zznd.zzang);
    }

    public Date getModifiedByMeDate()
    {
        return (Date)zza(zznf.zzanE);
    }

    public Date getModifiedDate()
    {
        return (Date)zza(zznf.zzanD);
    }

    public String getOriginalFilename()
    {
        return (String)zza(zznd.zzanh);
    }

    public long getQuotaBytesUsed()
    {
        return ((Long)zza(zznd.zzanm)).longValue();
    }

    public Date getSharedWithMeDate()
    {
        return (Date)zza(zznf.zzanF);
    }

    public String getTitle()
    {
        return (String)zza(zznd.zzanp);
    }

    public String getWebContentLink()
    {
        return (String)zza(zznd.zzanr);
    }

    public String getWebViewLink()
    {
        return (String)zza(zznd.zzans);
    }

    public boolean isEditable()
    {
        Boolean boolean1 = (Boolean)zza(zznd.zzamV);
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public boolean isExplicitlyTrashed()
    {
        Boolean boolean1 = (Boolean)zza(zznd.zzamW);
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

    public boolean isInAppFolder()
    {
        Boolean boolean1 = (Boolean)zza(zznd.zzamT);
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public boolean isPinnable()
    {
        Boolean boolean1 = (Boolean)zza(zznh.zzanJ);
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public boolean isPinned()
    {
        Boolean boolean1 = (Boolean)zza(zznd.zzamY);
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public boolean isRestricted()
    {
        Boolean boolean1 = (Boolean)zza(zznd.zzana);
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public boolean isShared()
    {
        Boolean boolean1 = (Boolean)zza(zznd.zzanb);
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public boolean isStarred()
    {
        Boolean boolean1 = (Boolean)zza(zznd.zzann);
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public boolean isTrashable()
    {
        Boolean boolean1 = (Boolean)zza(zznd.zzane);
        if (boolean1 == null)
        {
            return true;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public boolean isTrashed()
    {
        Boolean boolean1 = (Boolean)zza(zznd.zzanq);
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public boolean isViewed()
    {
        Boolean boolean1 = (Boolean)zza(zznd.zzanf);
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public abstract Object zza(MetadataField metadatafield);
}
