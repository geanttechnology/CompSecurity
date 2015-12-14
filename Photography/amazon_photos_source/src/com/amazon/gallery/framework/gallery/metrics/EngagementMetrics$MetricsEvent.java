// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;


// Referenced classes of package com.amazon.gallery.framework.gallery.metrics:
//            EngagementMetrics

public static final class Q extends Enum
{

    private static final TagTimeStampToggled $VALUES[];
    public static final TagTimeStampToggled AllViewDateUploadedToggled;
    public static final TagTimeStampToggled AllViewTimeStampToggled;
    public static final TagTimeStampToggled CameraRollNewestFirstToggled;
    public static final TagTimeStampToggled CameraRollOldestFirstToggled;
    public static final TagTimeStampToggled CloudAlsoCheckboxSelected;
    public static final TagTimeStampToggled CloudAlsoCheckboxSelectedForRemovingMediaItemsFromAlbum;
    public static final TagTimeStampToggled CollectionNewestFirstToggled;
    public static final TagTimeStampToggled CollectionOldestFirstToggled;
    public static final TagTimeStampToggled DeleteClickedFromAlbumDialog;
    public static final TagTimeStampToggled DeleteClickedFromAlbumsListDialog;
    public static final TagTimeStampToggled DeleteClickedFromCloudDriveDialog;
    public static final TagTimeStampToggled DeleteClickedFromCloudUnifiedDialog;
    public static final TagTimeStampToggled DeleteClickedFromDeviceAndCloudDialog;
    public static final TagTimeStampToggled DeleteClickedFromUnifiedDialog;
    public static final TagTimeStampToggled DeleteClickedFromYourDeviceDialog;
    public static final TagTimeStampToggled DeleteCloudUnifiedDialogDisplayed;
    public static final TagTimeStampToggled DeleteFromAlbumDialogDisplayed;
    public static final TagTimeStampToggled DeleteFromCloudDriveDialogDisplayed;
    public static final TagTimeStampToggled DeleteFromYourDeviceDialogDisplayed;
    public static final TagTimeStampToggled DeleteUnifiedDialogDisplayed;
    public static final TagTimeStampToggled DeviceAndCloudDeleteDialogDisplayed;
    public static final TagTimeStampToggled EmailOptionSharingClicked;
    public static final TagTimeStampToggled FacebookOptionSharingClicked;
    public static final TagTimeStampToggled MoreOptionSharingClicked;
    public static final TagTimeStampToggled MultiSelectClickedGridMosaicView;
    public static final TagTimeStampToggled TagAlbumNameToggled;
    public static final TagTimeStampToggled TagTimeStampToggled;
    public static final TagTimeStampToggled VideoDateUploadedToggled;
    public static final TagTimeStampToggled VideoTimeStampToggled;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/amazon/gallery/framework/gallery/metrics/EngagementMetrics$MetricsEvent, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        DeleteFromAlbumDialogDisplayed = new <init>("DeleteFromAlbumDialogDisplayed", 0);
        DeleteClickedFromAlbumDialog = new <init>("DeleteClickedFromAlbumDialog", 1);
        DeleteFromCloudDriveDialogDisplayed = new <init>("DeleteFromCloudDriveDialogDisplayed", 2);
        DeleteClickedFromCloudDriveDialog = new <init>("DeleteClickedFromCloudDriveDialog", 3);
        DeleteFromYourDeviceDialogDisplayed = new <init>("DeleteFromYourDeviceDialogDisplayed", 4);
        DeleteClickedFromYourDeviceDialog = new <init>("DeleteClickedFromYourDeviceDialog", 5);
        FacebookOptionSharingClicked = new <init>("FacebookOptionSharingClicked", 6);
        EmailOptionSharingClicked = new <init>("EmailOptionSharingClicked", 7);
        MoreOptionSharingClicked = new <init>("MoreOptionSharingClicked", 8);
        MultiSelectClickedGridMosaicView = new <init>("MultiSelectClickedGridMosaicView", 9);
        DeviceAndCloudDeleteDialogDisplayed = new <init>("DeviceAndCloudDeleteDialogDisplayed", 10);
        DeleteClickedFromDeviceAndCloudDialog = new <init>("DeleteClickedFromDeviceAndCloudDialog", 11);
        DeleteUnifiedDialogDisplayed = new <init>("DeleteUnifiedDialogDisplayed", 12);
        DeleteCloudUnifiedDialogDisplayed = new <init>("DeleteCloudUnifiedDialogDisplayed", 13);
        DeleteClickedFromUnifiedDialog = new <init>("DeleteClickedFromUnifiedDialog", 14);
        DeleteClickedFromCloudUnifiedDialog = new <init>("DeleteClickedFromCloudUnifiedDialog", 15);
        CloudAlsoCheckboxSelected = new <init>("CloudAlsoCheckboxSelected", 16);
        DeleteClickedFromAlbumsListDialog = new <init>("DeleteClickedFromAlbumsListDialog", 17);
        CloudAlsoCheckboxSelectedForRemovingMediaItemsFromAlbum = new <init>("CloudAlsoCheckboxSelectedForRemovingMediaItemsFromAlbum", 18);
        AllViewTimeStampToggled = new <init>("AllViewTimeStampToggled", 19);
        AllViewDateUploadedToggled = new <init>("AllViewDateUploadedToggled", 20);
        VideoTimeStampToggled = new <init>("VideoTimeStampToggled", 21);
        VideoDateUploadedToggled = new <init>("VideoDateUploadedToggled", 22);
        CameraRollNewestFirstToggled = new <init>("CameraRollNewestFirstToggled", 23);
        CameraRollOldestFirstToggled = new <init>("CameraRollOldestFirstToggled", 24);
        CollectionNewestFirstToggled = new <init>("CollectionNewestFirstToggled", 25);
        CollectionOldestFirstToggled = new <init>("CollectionOldestFirstToggled", 26);
        TagAlbumNameToggled = new <init>("TagAlbumNameToggled", 27);
        TagTimeStampToggled = new <init>("TagTimeStampToggled", 28);
        $VALUES = (new .VALUES[] {
            DeleteFromAlbumDialogDisplayed, DeleteClickedFromAlbumDialog, DeleteFromCloudDriveDialogDisplayed, DeleteClickedFromCloudDriveDialog, DeleteFromYourDeviceDialogDisplayed, DeleteClickedFromYourDeviceDialog, FacebookOptionSharingClicked, EmailOptionSharingClicked, MoreOptionSharingClicked, MultiSelectClickedGridMosaicView, 
            DeviceAndCloudDeleteDialogDisplayed, DeleteClickedFromDeviceAndCloudDialog, DeleteUnifiedDialogDisplayed, DeleteCloudUnifiedDialogDisplayed, DeleteClickedFromUnifiedDialog, DeleteClickedFromCloudUnifiedDialog, CloudAlsoCheckboxSelected, DeleteClickedFromAlbumsListDialog, CloudAlsoCheckboxSelectedForRemovingMediaItemsFromAlbum, AllViewTimeStampToggled, 
            AllViewDateUploadedToggled, VideoTimeStampToggled, VideoDateUploadedToggled, CameraRollNewestFirstToggled, CameraRollOldestFirstToggled, CollectionNewestFirstToggled, CollectionOldestFirstToggled, TagAlbumNameToggled, TagTimeStampToggled
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
