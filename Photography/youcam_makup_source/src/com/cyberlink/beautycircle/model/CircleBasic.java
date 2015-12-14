// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.graphics.Bitmap;
import android.net.Uri;
import com.perfectcorp.model.Model;
import java.util.Date;

public class CircleBasic extends Model
    implements Comparable
{

    public static final String CICLE_TYPE_EYE_MAKEUP = "EYE_MAKEUP";
    public static final String CICLE_TYPE_HAIR = "HAIR";
    public static final String CICLE_TYPE_LIPS = "LIPS";
    public static final String CICLE_TYPE_MAKEUP = "MAKEUP";
    public static final String CICLE_TYPE_NAILS = "NAILS";
    public static final String CICLE_TYPE_OUTFITS = "OUTFITS";
    public static final String CICLE_TYPE_SELFIE = "SELFIE";
    public static final String CICLE_TYPE_SKINCARE = "SKINCARE";
    public Long circleCreatorId;
    public String circleName;
    public Long circleTypeId;
    public String defaultType;
    public String description;
    public transient Bitmap iconBmp;
    public Uri iconUrl;
    public Long id;
    public Boolean isSecret;
    public Date lastModified;

    public CircleBasic()
    {
    }

    public int compareTo(Object obj)
    {
        return id.compareTo(((CircleBasic)obj).id);
    }
}
