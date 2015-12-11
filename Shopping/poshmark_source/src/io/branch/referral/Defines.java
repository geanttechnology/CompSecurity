// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;


public class Defines
{
    public static final class Jsonkey extends Enum
    {

        private static final Jsonkey $VALUES[];
        public static final Jsonkey Amount;
        public static final Jsonkey AndroidAppLinkURL;
        public static final Jsonkey AndroidDeepLinkPath;
        public static final Jsonkey AppIdentifier;
        public static final Jsonkey AppVersion;
        public static final Jsonkey BeginAfterID;
        public static final Jsonkey Bluetooth;
        public static final Jsonkey BluetoothVersion;
        public static final Jsonkey Brand;
        public static final Jsonkey Bucket;
        public static final Jsonkey CalculationType;
        public static final Jsonkey CanonicalIdentifier;
        public static final Jsonkey Carrier;
        public static final Jsonkey Clicked_Branch_Link;
        public static final Jsonkey ContentDesc;
        public static final Jsonkey ContentExpiryTime;
        public static final Jsonkey ContentImgUrl;
        public static final Jsonkey ContentKeyWords;
        public static final Jsonkey ContentTitle;
        public static final Jsonkey ContentType;
        public static final Jsonkey CreationSource;
        public static final Jsonkey Data;
        public static final Jsonkey Debug;
        public static final Jsonkey DeepLinkPath;
        public static final Jsonkey DefaultBucket;
        public static final Jsonkey DeviceFingerprintID;
        public static final Jsonkey Direction;
        public static final Jsonkey Event;
        public static final Jsonkey Expiration;
        public static final Jsonkey External_Intent_Extra;
        public static final Jsonkey External_Intent_URI;
        public static final Jsonkey GoogleAdvertisingID;
        public static final Jsonkey HardwareID;
        public static final Jsonkey HasNfc;
        public static final Jsonkey HasTelephone;
        public static final Jsonkey Identity;
        public static final Jsonkey IdentityID;
        public static final Jsonkey IsFirstSession;
        public static final Jsonkey IsHardwareIDReal;
        public static final Jsonkey IsReferrable;
        public static final Jsonkey LATVal;
        public static final Jsonkey Length;
        public static final Jsonkey Link;
        public static final Jsonkey LinkClickID;
        public static final Jsonkey LinkIdentifier;
        public static final Jsonkey Location;
        public static final Jsonkey Metadata;
        public static final Jsonkey Model;
        public static final Jsonkey OS;
        public static final Jsonkey OSVersion;
        public static final Jsonkey Params;
        public static final Jsonkey Prefix;
        public static final Jsonkey PublicallyIndexable;
        public static final Jsonkey ReferralCode;
        public static final Jsonkey ReferringData;
        public static final Jsonkey ScreenDpi;
        public static final Jsonkey ScreenHeight;
        public static final Jsonkey ScreenWidth;
        public static final Jsonkey SessionID;
        public static final Jsonkey Total;
        public static final Jsonkey Type;
        public static final Jsonkey URIScheme;
        public static final Jsonkey Unique;
        public static final Jsonkey Update;
        public static final Jsonkey WiFi;
        private String key;

        public static Jsonkey valueOf(String s)
        {
            return (Jsonkey)Enum.valueOf(io/branch/referral/Defines$Jsonkey, s);
        }

        public static Jsonkey[] values()
        {
            return (Jsonkey[])$VALUES.clone();
        }

        public String getKey()
        {
            return key;
        }

        public String toString()
        {
            return key;
        }

        static 
        {
            IdentityID = new Jsonkey("IdentityID", 0, "identity_id");
            Identity = new Jsonkey("Identity", 1, "identity");
            DeviceFingerprintID = new Jsonkey("DeviceFingerprintID", 2, "device_fingerprint_id");
            SessionID = new Jsonkey("SessionID", 3, "session_id");
            LinkClickID = new Jsonkey("LinkClickID", 4, "link_click_id");
            Bucket = new Jsonkey("Bucket", 5, "bucket");
            DefaultBucket = new Jsonkey("DefaultBucket", 6, "default");
            Amount = new Jsonkey("Amount", 7, "amount");
            CalculationType = new Jsonkey("CalculationType", 8, "calculation_type");
            Location = new Jsonkey("Location", 9, "location");
            Type = new Jsonkey("Type", 10, "type");
            CreationSource = new Jsonkey("CreationSource", 11, "creation_source");
            Prefix = new Jsonkey("Prefix", 12, "prefix");
            Expiration = new Jsonkey("Expiration", 13, "expiration");
            Event = new Jsonkey("Event", 14, "event");
            Metadata = new Jsonkey("Metadata", 15, "metadata");
            ReferralCode = new Jsonkey("ReferralCode", 16, "referral_code");
            Total = new Jsonkey("Total", 17, "total");
            Unique = new Jsonkey("Unique", 18, "unique");
            Length = new Jsonkey("Length", 19, "length");
            Direction = new Jsonkey("Direction", 20, "direction");
            BeginAfterID = new Jsonkey("BeginAfterID", 21, "begin_after_id");
            Link = new Jsonkey("Link", 22, "link");
            ReferringData = new Jsonkey("ReferringData", 23, "referring_data");
            Data = new Jsonkey("Data", 24, "data");
            OS = new Jsonkey("OS", 25, "os");
            HardwareID = new Jsonkey("HardwareID", 26, "hardware_id");
            IsHardwareIDReal = new Jsonkey("IsHardwareIDReal", 27, "is_hardware_id_real");
            AppVersion = new Jsonkey("AppVersion", 28, "app_version");
            OSVersion = new Jsonkey("OSVersion", 29, "os_version");
            IsReferrable = new Jsonkey("IsReferrable", 30, "is_referrable");
            Update = new Jsonkey("Update", 31, "update");
            URIScheme = new Jsonkey("URIScheme", 32, "uri_scheme");
            AppIdentifier = new Jsonkey("AppIdentifier", 33, "app_identifier");
            LinkIdentifier = new Jsonkey("LinkIdentifier", 34, "link_identifier");
            GoogleAdvertisingID = new Jsonkey("GoogleAdvertisingID", 35, "google_advertising_id");
            LATVal = new Jsonkey("LATVal", 36, "lat_val");
            Debug = new Jsonkey("Debug", 37, "debug");
            Carrier = new Jsonkey("Carrier", 38, "carrier");
            Bluetooth = new Jsonkey("Bluetooth", 39, "bluetooth");
            BluetoothVersion = new Jsonkey("BluetoothVersion", 40, "bluetooth_version");
            HasNfc = new Jsonkey("HasNfc", 41, "has_nfc");
            HasTelephone = new Jsonkey("HasTelephone", 42, "has_telephone");
            Brand = new Jsonkey("Brand", 43, "brand");
            Model = new Jsonkey("Model", 44, "model");
            ScreenDpi = new Jsonkey("ScreenDpi", 45, "screen_dpi");
            ScreenHeight = new Jsonkey("ScreenHeight", 46, "screen_height");
            ScreenWidth = new Jsonkey("ScreenWidth", 47, "screen_width");
            WiFi = new Jsonkey("WiFi", 48, "wifi");
            Clicked_Branch_Link = new Jsonkey("Clicked_Branch_Link", 49, "+clicked_branch_link");
            IsFirstSession = new Jsonkey("IsFirstSession", 50, "+is_first_session");
            AndroidDeepLinkPath = new Jsonkey("AndroidDeepLinkPath", 51, "$android_deeplink_path");
            DeepLinkPath = new Jsonkey("DeepLinkPath", 52, "$deeplink_path");
            AndroidAppLinkURL = new Jsonkey("AndroidAppLinkURL", 53, "android_app_link_url");
            CanonicalIdentifier = new Jsonkey("CanonicalIdentifier", 54, "$canonical_identifier");
            ContentTitle = new Jsonkey("ContentTitle", 55, "$og_title");
            ContentDesc = new Jsonkey("ContentDesc", 56, "$og_description");
            ContentImgUrl = new Jsonkey("ContentImgUrl", 57, "$og_image_url");
            ContentType = new Jsonkey("ContentType", 58, "$content_type");
            PublicallyIndexable = new Jsonkey("PublicallyIndexable", 59, "$publicly_indexable");
            ContentKeyWords = new Jsonkey("ContentKeyWords", 60, "$keywords");
            ContentExpiryTime = new Jsonkey("ContentExpiryTime", 61, "$exp_date");
            Params = new Jsonkey("Params", 62, "params");
            External_Intent_URI = new Jsonkey("External_Intent_URI", 63, "external_intent_uri");
            External_Intent_Extra = new Jsonkey("External_Intent_Extra", 64, "external_intent_extra");
            $VALUES = (new Jsonkey[] {
                IdentityID, Identity, DeviceFingerprintID, SessionID, LinkClickID, Bucket, DefaultBucket, Amount, CalculationType, Location, 
                Type, CreationSource, Prefix, Expiration, Event, Metadata, ReferralCode, Total, Unique, Length, 
                Direction, BeginAfterID, Link, ReferringData, Data, OS, HardwareID, IsHardwareIDReal, AppVersion, OSVersion, 
                IsReferrable, Update, URIScheme, AppIdentifier, LinkIdentifier, GoogleAdvertisingID, LATVal, Debug, Carrier, Bluetooth, 
                BluetoothVersion, HasNfc, HasTelephone, Brand, Model, ScreenDpi, ScreenHeight, ScreenWidth, WiFi, Clicked_Branch_Link, 
                IsFirstSession, AndroidDeepLinkPath, DeepLinkPath, AndroidAppLinkURL, CanonicalIdentifier, ContentTitle, ContentDesc, ContentImgUrl, ContentType, PublicallyIndexable, 
                ContentKeyWords, ContentExpiryTime, Params, External_Intent_URI, External_Intent_Extra
            });
        }

        private Jsonkey(String s, int i, String s1)
        {
            super(s, i);
            key = "";
            key = s1;
        }
    }

    public static final class LinkParam extends Enum
    {

        private static final LinkParam $VALUES[];
        public static final LinkParam Alias;
        public static final LinkParam Channel;
        public static final LinkParam Data;
        public static final LinkParam Duration;
        public static final LinkParam Feature;
        public static final LinkParam Stage;
        public static final LinkParam Tags;
        public static final LinkParam Type;
        private String key;

        public static LinkParam valueOf(String s)
        {
            return (LinkParam)Enum.valueOf(io/branch/referral/Defines$LinkParam, s);
        }

        public static LinkParam[] values()
        {
            return (LinkParam[])$VALUES.clone();
        }

        public String getKey()
        {
            return key;
        }

        public String toString()
        {
            return key;
        }

        static 
        {
            Tags = new LinkParam("Tags", 0, "tags");
            Alias = new LinkParam("Alias", 1, "alias");
            Type = new LinkParam("Type", 2, "type");
            Duration = new LinkParam("Duration", 3, "duration");
            Channel = new LinkParam("Channel", 4, "channel");
            Feature = new LinkParam("Feature", 5, "feature");
            Stage = new LinkParam("Stage", 6, "stage");
            Data = new LinkParam("Data", 7, "data");
            $VALUES = (new LinkParam[] {
                Tags, Alias, Type, Duration, Channel, Feature, Stage, Data
            });
        }

        private LinkParam(String s, int i, String s1)
        {
            super(s, i);
            key = "";
            key = s1;
        }
    }

    public static final class RequestPath extends Enum
    {

        private static final RequestPath $VALUES[];
        public static final RequestPath ApplyReferralCode;
        public static final RequestPath CompletedAction;
        public static final RequestPath DebugConnect;
        public static final RequestPath GetCreditHistory;
        public static final RequestPath GetCredits;
        public static final RequestPath GetReferralCode;
        public static final RequestPath GetURL;
        public static final RequestPath IdentifyUser;
        public static final RequestPath Logout;
        public static final RequestPath RedeemRewards;
        public static final RequestPath Referrals;
        public static final RequestPath RegisterClose;
        public static final RequestPath RegisterInstall;
        public static final RequestPath RegisterOpen;
        public static final RequestPath RegisterView;
        public static final RequestPath SendAPPList;
        public static final RequestPath ValidateReferralCode;
        private String key;

        public static RequestPath valueOf(String s)
        {
            return (RequestPath)Enum.valueOf(io/branch/referral/Defines$RequestPath, s);
        }

        public static RequestPath[] values()
        {
            return (RequestPath[])$VALUES.clone();
        }

        public String getPath()
        {
            return key;
        }

        public String toString()
        {
            return key;
        }

        static 
        {
            RedeemRewards = new RequestPath("RedeemRewards", 0, "v1/redeem");
            GetURL = new RequestPath("GetURL", 1, "v1/url");
            RegisterInstall = new RequestPath("RegisterInstall", 2, "v1/install");
            RegisterClose = new RequestPath("RegisterClose", 3, "v1/close");
            RegisterOpen = new RequestPath("RegisterOpen", 4, "v1/open");
            RegisterView = new RequestPath("RegisterView", 5, "v1/register-view");
            Referrals = new RequestPath("Referrals", 6, "v1/referrals/");
            SendAPPList = new RequestPath("SendAPPList", 7, "v1/applist");
            GetCredits = new RequestPath("GetCredits", 8, "v1/credits/");
            GetCreditHistory = new RequestPath("GetCreditHistory", 9, "v1/credithistory");
            CompletedAction = new RequestPath("CompletedAction", 10, "v1/event");
            IdentifyUser = new RequestPath("IdentifyUser", 11, "v1/profile");
            Logout = new RequestPath("Logout", 12, "v1/logout");
            GetReferralCode = new RequestPath("GetReferralCode", 13, "v1/referralcode");
            ValidateReferralCode = new RequestPath("ValidateReferralCode", 14, "v1/referralcode/");
            ApplyReferralCode = new RequestPath("ApplyReferralCode", 15, "v1/applycode/");
            DebugConnect = new RequestPath("DebugConnect", 16, "v1/debug/connect");
            $VALUES = (new RequestPath[] {
                RedeemRewards, GetURL, RegisterInstall, RegisterClose, RegisterOpen, RegisterView, Referrals, SendAPPList, GetCredits, GetCreditHistory, 
                CompletedAction, IdentifyUser, Logout, GetReferralCode, ValidateReferralCode, ApplyReferralCode, DebugConnect
            });
        }

        private RequestPath(String s, int i, String s1)
        {
            super(s, i);
            key = "";
            key = s1;
        }
    }


    public Defines()
    {
    }
}
