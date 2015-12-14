// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import java.util.Date;

public final class MetadataChangeSet
{

    public static final MetadataChangeSet HV = new MetadataChangeSet(MetadataBundle.gF());
    private final MetadataBundle HW;

    public MetadataChangeSet(MetadataBundle metadatabundle)
    {
        HW = MetadataBundle.a(metadatabundle);
    }

    public String getDescription()
    {
        return (String)HW.a(iq.JW);
    }

    public String getIndexableText()
    {
        return (String)HW.a(iq.Kb);
    }

    public Date getLastViewedByMeDate()
    {
        return (Date)HW.a(is.Kx);
    }

    public String getMimeType()
    {
        return (String)HW.a(iq.Kk);
    }

    public String getTitle()
    {
        return (String)HW.a(iq.Kr);
    }

    public MetadataBundle gm()
    {
        return HW;
    }

    public Boolean isPinned()
    {
        return (Boolean)HW.a(iq.Kf);
    }

    public Boolean isStarred()
    {
        return (Boolean)HW.a(iq.Kp);
    }

    public Boolean isViewed()
    {
        return (Boolean)HW.a(iq.Kj);
    }

}
