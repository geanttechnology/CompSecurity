// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;

public class EngagementMetrics extends ComponentProfiler
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AllViewDateUploadedToggled;
        public static final MetricsEvent AllViewTimeStampToggled;
        public static final MetricsEvent CameraRollNewestFirstToggled;
        public static final MetricsEvent CameraRollOldestFirstToggled;
        public static final MetricsEvent CloudAlsoCheckboxSelected;
        public static final MetricsEvent CloudAlsoCheckboxSelectedForRemovingMediaItemsFromAlbum;
        public static final MetricsEvent CollectionNewestFirstToggled;
        public static final MetricsEvent CollectionOldestFirstToggled;
        public static final MetricsEvent DeleteClickedFromAlbumDialog;
        public static final MetricsEvent DeleteClickedFromAlbumsListDialog;
        public static final MetricsEvent DeleteClickedFromCloudDriveDialog;
        public static final MetricsEvent DeleteClickedFromCloudUnifiedDialog;
        public static final MetricsEvent DeleteClickedFromDeviceAndCloudDialog;
        public static final MetricsEvent DeleteClickedFromUnifiedDialog;
        public static final MetricsEvent DeleteClickedFromYourDeviceDialog;
        public static final MetricsEvent DeleteCloudUnifiedDialogDisplayed;
        public static final MetricsEvent DeleteFromAlbumDialogDisplayed;
        public static final MetricsEvent DeleteFromCloudDriveDialogDisplayed;
        public static final MetricsEvent DeleteFromYourDeviceDialogDisplayed;
        public static final MetricsEvent DeleteUnifiedDialogDisplayed;
        public static final MetricsEvent DeviceAndCloudDeleteDialogDisplayed;
        public static final MetricsEvent EmailOptionSharingClicked;
        public static final MetricsEvent FacebookOptionSharingClicked;
        public static final MetricsEvent MoreOptionSharingClicked;
        public static final MetricsEvent MultiSelectClickedGridMosaicView;
        public static final MetricsEvent TagAlbumNameToggled;
        public static final MetricsEvent TagTimeStampToggled;
        public static final MetricsEvent VideoDateUploadedToggled;
        public static final MetricsEvent VideoTimeStampToggled;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/gallery/metrics/EngagementMetrics$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            DeleteFromAlbumDialogDisplayed = new MetricsEvent("DeleteFromAlbumDialogDisplayed", 0);
            DeleteClickedFromAlbumDialog = new MetricsEvent("DeleteClickedFromAlbumDialog", 1);
            DeleteFromCloudDriveDialogDisplayed = new MetricsEvent("DeleteFromCloudDriveDialogDisplayed", 2);
            DeleteClickedFromCloudDriveDialog = new MetricsEvent("DeleteClickedFromCloudDriveDialog", 3);
            DeleteFromYourDeviceDialogDisplayed = new MetricsEvent("DeleteFromYourDeviceDialogDisplayed", 4);
            DeleteClickedFromYourDeviceDialog = new MetricsEvent("DeleteClickedFromYourDeviceDialog", 5);
            FacebookOptionSharingClicked = new MetricsEvent("FacebookOptionSharingClicked", 6);
            EmailOptionSharingClicked = new MetricsEvent("EmailOptionSharingClicked", 7);
            MoreOptionSharingClicked = new MetricsEvent("MoreOptionSharingClicked", 8);
            MultiSelectClickedGridMosaicView = new MetricsEvent("MultiSelectClickedGridMosaicView", 9);
            DeviceAndCloudDeleteDialogDisplayed = new MetricsEvent("DeviceAndCloudDeleteDialogDisplayed", 10);
            DeleteClickedFromDeviceAndCloudDialog = new MetricsEvent("DeleteClickedFromDeviceAndCloudDialog", 11);
            DeleteUnifiedDialogDisplayed = new MetricsEvent("DeleteUnifiedDialogDisplayed", 12);
            DeleteCloudUnifiedDialogDisplayed = new MetricsEvent("DeleteCloudUnifiedDialogDisplayed", 13);
            DeleteClickedFromUnifiedDialog = new MetricsEvent("DeleteClickedFromUnifiedDialog", 14);
            DeleteClickedFromCloudUnifiedDialog = new MetricsEvent("DeleteClickedFromCloudUnifiedDialog", 15);
            CloudAlsoCheckboxSelected = new MetricsEvent("CloudAlsoCheckboxSelected", 16);
            DeleteClickedFromAlbumsListDialog = new MetricsEvent("DeleteClickedFromAlbumsListDialog", 17);
            CloudAlsoCheckboxSelectedForRemovingMediaItemsFromAlbum = new MetricsEvent("CloudAlsoCheckboxSelectedForRemovingMediaItemsFromAlbum", 18);
            AllViewTimeStampToggled = new MetricsEvent("AllViewTimeStampToggled", 19);
            AllViewDateUploadedToggled = new MetricsEvent("AllViewDateUploadedToggled", 20);
            VideoTimeStampToggled = new MetricsEvent("VideoTimeStampToggled", 21);
            VideoDateUploadedToggled = new MetricsEvent("VideoDateUploadedToggled", 22);
            CameraRollNewestFirstToggled = new MetricsEvent("CameraRollNewestFirstToggled", 23);
            CameraRollOldestFirstToggled = new MetricsEvent("CameraRollOldestFirstToggled", 24);
            CollectionNewestFirstToggled = new MetricsEvent("CollectionNewestFirstToggled", 25);
            CollectionOldestFirstToggled = new MetricsEvent("CollectionOldestFirstToggled", 26);
            TagAlbumNameToggled = new MetricsEvent("TagAlbumNameToggled", 27);
            TagTimeStampToggled = new MetricsEvent("TagTimeStampToggled", 28);
            $VALUES = (new MetricsEvent[] {
                DeleteFromAlbumDialogDisplayed, DeleteClickedFromAlbumDialog, DeleteFromCloudDriveDialogDisplayed, DeleteClickedFromCloudDriveDialog, DeleteFromYourDeviceDialogDisplayed, DeleteClickedFromYourDeviceDialog, FacebookOptionSharingClicked, EmailOptionSharingClicked, MoreOptionSharingClicked, MultiSelectClickedGridMosaicView, 
                DeviceAndCloudDeleteDialogDisplayed, DeleteClickedFromDeviceAndCloudDialog, DeleteUnifiedDialogDisplayed, DeleteCloudUnifiedDialogDisplayed, DeleteClickedFromUnifiedDialog, DeleteClickedFromCloudUnifiedDialog, CloudAlsoCheckboxSelected, DeleteClickedFromAlbumsListDialog, CloudAlsoCheckboxSelectedForRemovingMediaItemsFromAlbum, AllViewTimeStampToggled, 
                AllViewDateUploadedToggled, VideoTimeStampToggled, VideoDateUploadedToggled, CameraRollNewestFirstToggled, CameraRollOldestFirstToggled, CollectionNewestFirstToggled, CollectionOldestFirstToggled, TagAlbumNameToggled, TagTimeStampToggled
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    public EngagementMetrics(Profiler profiler)
    {
        super(profiler, com/amazon/gallery/framework/gallery/metrics/EngagementMetrics);
    }
}
