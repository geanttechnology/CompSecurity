// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest;


// Referenced classes of package com.amazon.gallery.framework.network.http.rest:
//            RestClient

public static final class  extends Enum
{

    private static final GetUpdateConfig $VALUES[];
    public static final GetUpdateConfig CompleteItem;
    public static final GetUpdateConfig CompleteMediaItemUpload;
    public static final GetUpdateConfig CreateAccount;
    public static final GetUpdateConfig CreateMediaItem;
    public static final GetUpdateConfig DeleteMediaItem;
    public static final GetUpdateConfig DeleteTag;
    public static final GetUpdateConfig DownloadBandwidth;
    public static final GetUpdateConfig FacebookExport;
    public static final GetUpdateConfig FacebookImport;
    public static final GetUpdateConfig GetAccountDetails;
    public static final GetUpdateConfig GetContactInfo;
    public static final GetUpdateConfig GetEndpoint;
    public static final GetUpdateConfig GetFacebookPermissionsOperation;
    public static final GetUpdateConfig GetMediaItem;
    public static final GetUpdateConfig GetMediaItemUploadLocation;
    public static final GetUpdateConfig GetMultiUploadLocationOperation;
    public static final GetUpdateConfig GetNetworkThrottle;
    public static final GetUpdateConfig GetTagCover;
    public static final GetUpdateConfig GetUpdateConfig;
    public static final GetUpdateConfig GetUploadUrl;
    public static final GetUpdateConfig GetUserStorage;
    public static final GetUpdateConfig ListMediaItems;
    public static final GetUpdateConfig ListTags;
    public static final GetUpdateConfig RegisterDeviceOperation;
    public static final GetUpdateConfig RenameTag;
    public static final GetUpdateConfig S3Download;
    public static final GetUpdateConfig SendNotification;
    public static final GetUpdateConfig SetupAccount;
    public static final GetUpdateConfig Share;
    public static final GetUpdateConfig Sync;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/network/http/rest/RestClient$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        GetEndpoint = new <init>("GetEndpoint", 0);
        CreateAccount = new <init>("CreateAccount", 1);
        SetupAccount = new <init>("SetupAccount", 2);
        GetUserStorage = new <init>("GetUserStorage", 3);
        RegisterDeviceOperation = new <init>("RegisterDeviceOperation", 4);
        Sync = new <init>("Sync", 5);
        GetAccountDetails = new <init>("GetAccountDetails", 6);
        CreateMediaItem = new <init>("CreateMediaItem", 7);
        DeleteMediaItem = new <init>("DeleteMediaItem", 8);
        ListMediaItems = new <init>("ListMediaItems", 9);
        GetMediaItem = new <init>("GetMediaItem", 10);
        GetMediaItemUploadLocation = new <init>("GetMediaItemUploadLocation", 11);
        GetMultiUploadLocationOperation = new <init>("GetMultiUploadLocationOperation", 12);
        CompleteMediaItemUpload = new <init>("CompleteMediaItemUpload", 13);
        GetUploadUrl = new <init>("GetUploadUrl", 14);
        CompleteItem = new <init>("CompleteItem", 15);
        FacebookImport = new <init>("FacebookImport", 16);
        FacebookExport = new <init>("FacebookExport", 17);
        GetFacebookPermissionsOperation = new <init>("GetFacebookPermissionsOperation", 18);
        ListTags = new <init>("ListTags", 19);
        GetTagCover = new <init>("GetTagCover", 20);
        DeleteTag = new <init>("DeleteTag", 21);
        RenameTag = new <init>("RenameTag", 22);
        SendNotification = new <init>("SendNotification", 23);
        GetContactInfo = new <init>("GetContactInfo", 24);
        Share = new <init>("Share", 25);
        S3Download = new <init>("S3Download", 26);
        DownloadBandwidth = new <init>("DownloadBandwidth", 27);
        GetNetworkThrottle = new <init>("GetNetworkThrottle", 28);
        GetUpdateConfig = new <init>("GetUpdateConfig", 29);
        $VALUES = (new .VALUES[] {
            GetEndpoint, CreateAccount, SetupAccount, GetUserStorage, RegisterDeviceOperation, Sync, GetAccountDetails, CreateMediaItem, DeleteMediaItem, ListMediaItems, 
            GetMediaItem, GetMediaItemUploadLocation, GetMultiUploadLocationOperation, CompleteMediaItemUpload, GetUploadUrl, CompleteItem, FacebookImport, FacebookExport, GetFacebookPermissionsOperation, ListTags, 
            GetTagCover, DeleteTag, RenameTag, SendNotification, GetContactInfo, Share, S3Download, DownloadBandwidth, GetNetworkThrottle, GetUpdateConfig
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
