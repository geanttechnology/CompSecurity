// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzmf;
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
        return (String)zza(zzmb.zzakp);
    }

    public int getContentAvailability()
    {
        Integer integer = (Integer)zza(zzmf.zzalj);
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
        return (Date)zza(zzmd.zzald);
    }

    public Map getCustomProperties()
    {
        AppVisibleCustomProperties appvisiblecustomproperties = (AppVisibleCustomProperties)zza(zzmb.zzakq);
        if (appvisiblecustomproperties == null)
        {
            return Collections.emptyMap();
        } else
        {
            return appvisiblecustomproperties.zzqX();
        }
    }

    public String getDescription()
    {
        return (String)zza(zzmb.zzakr);
    }

    public DriveId getDriveId()
    {
        return (DriveId)zza(zzmb.zzako);
    }

    public String getEmbedLink()
    {
        return (String)zza(zzmb.zzaks);
    }

    public String getFileExtension()
    {
        return (String)zza(zzmb.zzakt);
    }

    public long getFileSize()
    {
        return ((Long)zza(zzmb.zzaku)).longValue();
    }

    public Date getLastViewedByMeDate()
    {
        return (Date)zza(zzmd.zzale);
    }

    public String getMimeType()
    {
        return (String)zza(zzmb.zzakL);
    }

    public Date getModifiedByMeDate()
    {
        return (Date)zza(zzmd.zzalg);
    }

    public Date getModifiedDate()
    {
        return (Date)zza(zzmd.zzalf);
    }

    public String getOriginalFilename()
    {
        return (String)zza(zzmb.zzakM);
    }

    public long getQuotaBytesUsed()
    {
        return ((Long)zza(zzmb.zzakR)).longValue();
    }

    public Date getSharedWithMeDate()
    {
        return (Date)zza(zzmd.zzalh);
    }

    public String getTitle()
    {
        return (String)zza(zzmb.zzakU);
    }

    public String getWebContentLink()
    {
        return (String)zza(zzmb.zzakW);
    }

    public String getWebViewLink()
    {
        return (String)zza(zzmb.zzakX);
    }

    public boolean isEditable()
    {
        Boolean boolean1 = (Boolean)zza(zzmb.zzakA);
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
        Boolean boolean1 = (Boolean)zza(zzmb.zzakB);
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
        Boolean boolean1 = (Boolean)zza(zzmb.zzaky);
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
        Boolean boolean1 = (Boolean)zza(zzmf.zzalk);
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
        Boolean boolean1 = (Boolean)zza(zzmb.zzakD);
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
        Boolean boolean1 = (Boolean)zza(zzmb.zzakF);
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
        Boolean boolean1 = (Boolean)zza(zzmb.zzakG);
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
        Boolean boolean1 = (Boolean)zza(zzmb.zzakS);
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
        Boolean boolean1 = (Boolean)zza(zzmb.zzakJ);
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
        Boolean boolean1 = (Boolean)zza(zzmb.zzakV);
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
        Boolean boolean1 = (Boolean)zza(zzmb.zzakK);
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
