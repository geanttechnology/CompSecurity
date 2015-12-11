.class public Lcom/poshmark/utils/NewRelicCustomInteractions;
.super Ljava/lang/Object;
.source "NewRelicCustomInteractions.java"


# static fields
.field public static APP_FOREGROUND_FEED_REFRESH:Ljava/lang/String;

.field public static APP_LAUNCH_FEED_REFRESH:Ljava/lang/String;

.field public static CLOSET:Ljava/lang/String;

.field public static CLOSET_LAUNCH_FROM_AVATAAR:Ljava/lang/String;

.field public static CREATE_LISTING:Ljava/lang/String;

.field public static LISTING_DETAILS:Ljava/lang/String;

.field public static NEWS_FEED_REFRESH:Ljava/lang/String;

.field public static SEARCH_LISTINGS_BY_KEYWORD:Ljava/lang/String;

.field public static SHARE_LISTING_TO_FOLLOWERS:Ljava/lang/String;

.field public static SHARE_LISTING_TO_PARTY:Ljava/lang/String;

.field public static USER_TRIGGERED_FEED_REFRESH:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 7
    const-string v0, "CLOSET_LAUNCH_FROM_AVATAAR"

    sput-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->CLOSET_LAUNCH_FROM_AVATAAR:Ljava/lang/String;

    .line 8
    const-string v0, "Refresh Feed on App Launch"

    sput-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->APP_LAUNCH_FEED_REFRESH:Ljava/lang/String;

    .line 9
    const-string v0, "Refresh Feed on App Foreground"

    sput-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->APP_FOREGROUND_FEED_REFRESH:Ljava/lang/String;

    .line 10
    const-string v0, "Refresh Feed by User"

    sput-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->USER_TRIGGERED_FEED_REFRESH:Ljava/lang/String;

    .line 11
    const-string v0, "News Feed Refresh"

    sput-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->NEWS_FEED_REFRESH:Ljava/lang/String;

    .line 12
    const-string v0, "ServerShare Listing to Party"

    sput-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->SHARE_LISTING_TO_PARTY:Ljava/lang/String;

    .line 13
    const-string v0, "ServerShare Listing to Followers"

    sput-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->SHARE_LISTING_TO_FOLLOWERS:Ljava/lang/String;

    .line 14
    const-string v0, "Create Listing"

    sput-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->CREATE_LISTING:Ljava/lang/String;

    .line 15
    const-string v0, "Search Listings by Keyword"

    sput-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->SEARCH_LISTINGS_BY_KEYWORD:Ljava/lang/String;

    .line 16
    const-string v0, "View Closet"

    sput-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->CLOSET:Ljava/lang/String;

    .line 17
    const-string v0, "View Listing Details"

    sput-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->LISTING_DETAILS:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
