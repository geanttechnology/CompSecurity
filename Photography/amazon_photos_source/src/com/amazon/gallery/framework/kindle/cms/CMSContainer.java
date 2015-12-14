// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;

import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaProperty;
import com.amazon.gallery.framework.model.media.MediaType;

// Referenced classes of package com.amazon.gallery.framework.kindle.cms:
//            CMSContainerID, CMSObjectID

public final class CMSContainer extends Enum
{

    private static final CMSContainer $VALUES[];
    public static final CMSContainer ALL_PHOTOS;
    public static final CMSContainer CAMERA_ROLL;
    public static final CMSContainer FAVOURITE;
    public static final CMSContainer VIDEOS;
    public CMSObjectID cmsObjectID;
    public ObjectID containerId;
    public MediaProperty property;
    public int titleId;

    private CMSContainer(String s, int i, MediaProperty mediaproperty, ObjectID objectid, int j)
    {
        super(s, i);
        property = mediaproperty;
        containerId = objectid;
        cmsObjectID = CMSObjectID.getCMSSimilarItemID(containerId, containerId);
        titleId = j;
    }

    public static CMSContainer fromCMSObjectID(CMSObjectID cmsobjectid)
    {
        CMSContainer acmscontainer[] = values();
        int j = acmscontainer.length;
        for (int i = 0; i < j; i++)
        {
            CMSContainer cmscontainer = acmscontainer[i];
            if (cmscontainer.cmsObjectID.equals(cmsobjectid))
            {
                return cmscontainer;
            }
        }

        return null;
    }

    public static CMSContainer fromTypeAndProperty(MediaType mediatype, MediaProperty mediaproperty)
    {
        if (mediatype != MediaType.VIDEO) goto _L2; else goto _L1
_L1:
        mediatype = VIDEOS;
_L6:
        return mediatype;
_L2:
        CMSContainer acmscontainer[];
        int i;
        int j;
        if (mediaproperty == null)
        {
            return ALL_PHOTOS;
        }
        acmscontainer = values();
        j = acmscontainer.length;
        i = 0;
_L7:
        if (i >= j) goto _L4; else goto _L3
_L3:
        CMSContainer cmscontainer;
        cmscontainer = acmscontainer[i];
        if (cmscontainer.property == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        mediatype = cmscontainer;
        if (cmscontainer.property.equals(mediaproperty)) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        return null;
    }

    public static CMSContainer valueOf(String s)
    {
        return (CMSContainer)Enum.valueOf(com/amazon/gallery/framework/kindle/cms/CMSContainer, s);
    }

    public static CMSContainer[] values()
    {
        return (CMSContainer[])$VALUES.clone();
    }

    static 
    {
        ALL_PHOTOS = new CMSContainer("ALL_PHOTOS", 0, null, CMSContainerID.ALL_PHOTOS_OBJECT_ID, 0x7f0e0066);
        CAMERA_ROLL = new CMSContainer("CAMERA_ROLL", 1, CommonMediaProperty.CAMERA, CMSContainerID.CAMERA_ROLL_OBJECT_ID, 0x7f0e0098);
        FAVOURITE = new CMSContainer("FAVOURITE", 2, CommonMediaProperty.FAVORITE, CMSContainerID.FAVOURITE_OBJECT_ID, 0x7f0e006a);
        VIDEOS = new CMSContainer("VIDEOS", 3, null, CMSContainerID.VIDEOS_OBJECT_ID, 0x7f0e0073);
        $VALUES = (new CMSContainer[] {
            ALL_PHOTOS, CAMERA_ROLL, FAVOURITE, VIDEOS
        });
    }
}
