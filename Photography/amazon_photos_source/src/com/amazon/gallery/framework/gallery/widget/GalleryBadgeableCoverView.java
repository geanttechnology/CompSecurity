// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import com.amazon.gallery.framework.model.ObjectID;
import java.util.Map;
import java.util.Set;

public interface GalleryBadgeableCoverView
{
    public static final class BadgeType extends Enum
    {

        private static final BadgeType $VALUES[];
        public static final BadgeType ACTIVE;
        public static final BadgeType DEVICE;
        public static final BadgeType HIDDEN;
        public static final BadgeType HIGHLIGHT;
        public static final BadgeType LENTICULAR;
        public static final BadgeType NEW_CONTENT;
        public static final BadgeType NOT_UPLOADED;
        public static final BadgeType NO_NETWORK;
        public static final BadgeType PLAYABLE;
        public static final BadgeType QUEUED;
        public static final BadgeType REWIND;
        public static final BadgeType SELECTED;
        public static final BadgeType SHARED;
        public static final BadgeType UPLOADED;
        public static final BadgeType UPLOADING;
        public static final BadgeType UPLOADING_NO_PROGRESS;
        public final int category;
        public final int viewId;

        public static BadgeType valueOf(String s)
        {
            return (BadgeType)Enum.valueOf(com/amazon/gallery/framework/gallery/widget/GalleryBadgeableCoverView$BadgeType, s);
        }

        public static BadgeType[] values()
        {
            return (BadgeType[])$VALUES.clone();
        }

        static 
        {
            HIGHLIGHT = new BadgeType("HIGHLIGHT", 0, 0, 0x7f0c0175);
            PLAYABLE = new BadgeType("PLAYABLE", 1, 1, -1);
            NO_NETWORK = new BadgeType("NO_NETWORK", 2, 2, 0x7f0c0134);
            UPLOADED = new BadgeType("UPLOADED", 3, 2, 0x7f0c0130);
            NOT_UPLOADED = new BadgeType("NOT_UPLOADED", 4, 2, 0x7f0c0134);
            UPLOADING = new BadgeType("UPLOADING", 5, 2, -1);
            UPLOADING_NO_PROGRESS = new BadgeType("UPLOADING_NO_PROGRESS", 6, 2, 0x7f0c0204);
            NEW_CONTENT = new BadgeType("NEW_CONTENT", 7, 2, 0x7f0c018c);
            DEVICE = new BadgeType("DEVICE", 8, 2, 0x7f0c012e);
            HIDDEN = new BadgeType("HIDDEN", 9, 6, 0x7f0c0174);
            LENTICULAR = new BadgeType("LENTICULAR", 10, 5, 0x7f0c0183);
            REWIND = new BadgeType("REWIND", 11, 5, 0x7f0c01c6);
            ACTIVE = new BadgeType("ACTIVE", 12, 3, -1);
            SELECTED = new BadgeType("SELECTED", 13, 4, 0x7f0c01c7);
            QUEUED = new BadgeType("QUEUED", 14, 7, 0x7f0c01c3);
            SHARED = new BadgeType("SHARED", 15, 6, 0x7f0c01c9);
            $VALUES = (new BadgeType[] {
                HIGHLIGHT, PLAYABLE, NO_NETWORK, UPLOADED, NOT_UPLOADED, UPLOADING, UPLOADING_NO_PROGRESS, NEW_CONTENT, DEVICE, HIDDEN, 
                LENTICULAR, REWIND, ACTIVE, SELECTED, QUEUED, SHARED
            });
        }

        private BadgeType(String s, int i, int j, int k)
        {
            super(s, i);
            category = j;
            viewId = k;
        }
    }


    public abstract Set getEnabledBadges();

    public abstract void onDownloadRequested(ObjectID objectid);

    public abstract void setActiveBadgeVisible(boolean flag);

    public abstract void setAdditionalBadgeLayoutMap(Map map);

    public abstract void setBadgeToggleTime(BadgeType badgetype, long l);

    public abstract void setProgress(ObjectID objectid, boolean flag, int i, int j);

    public abstract void setSelectedBadgeVisible(boolean flag);

    public abstract void toggleBadge(BadgeType badgetype, boolean flag);
}
