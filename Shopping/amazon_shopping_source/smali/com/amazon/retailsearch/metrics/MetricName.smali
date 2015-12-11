.class final enum Lcom/amazon/retailsearch/metrics/MetricName;
.super Ljava/lang/Enum;
.source "MetricName.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/metrics/MetricName;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum AlternateDetailPageInvokedForcedPrime:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum AlternateDetailPageInvokedNeva:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum AlternateDetailPageInvokedTwister:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum AssetFetchType:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum BadResponse:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum BarcodeInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum BrowseActivityRefinementMenuClicked:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum BrowsePageLoaded:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum ClientATF:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum ClientVisibleImpression:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum Deprecated:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum DetailPageInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum DetailPagePogo:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum EndOfResults:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum EntryVoiceInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum Error:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum FirstByte:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum FlowInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum ImageInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum Info:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum InitTime:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum JsonError:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum MarketAppVersion:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum MenuInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum NavActivityRefinementMenuClicked:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum NetworkError:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum QueryBuilder:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum RecentSearchesClear:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum RelatedSearchesInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum RequestLatency:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum ResponseParseTime:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum ScrollDepth:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum SearchCell:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum SearchGrid:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum SearchImage:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum SearchLandscape:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum SearchList:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum SearchPortrait:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum SearchSplit:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum SearchWifi:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum SearchesPerFilterAccess:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum StreamingRefinementsLatency:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum StreamingResultsLatency:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum TapToATF:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum TapToATFCell:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum TapToATFGrid:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum TapToATFImage:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum TapToATFList:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum TapToATFSplit:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum TapToATFWifi:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum TapToFirstByte:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum TimeToFirstSuggestion:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum Timeout:Lcom/amazon/retailsearch/metrics/MetricName;

.field public static final enum ValueSelected:Lcom/amazon/retailsearch/metrics/MetricName;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 17
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "TapToATF"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATF:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "TapToFirstByte"

    invoke-direct {v0, v1, v4}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToFirstByte:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "ClientATF"

    invoke-direct {v0, v1, v5}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->ClientATF:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 18
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "TapToATFList"

    invoke-direct {v0, v1, v6}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFList:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "TapToATFGrid"

    invoke-direct {v0, v1, v7}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFGrid:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "TapToATFImage"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFImage:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "TapToATFSplit"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFSplit:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 19
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "TapToATFWifi"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFWifi:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "TapToATFCell"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFCell:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 22
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "FirstByte"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->FirstByte:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "RequestLatency"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->RequestLatency:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "ResponseParseTime"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->ResponseParseTime:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "StreamingResultsLatency"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->StreamingResultsLatency:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 23
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "StreamingRefinementsLatency"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->StreamingRefinementsLatency:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "Timeout"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->Timeout:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "Error"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->Error:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "BadResponse"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->BadResponse:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "Deprecated"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->Deprecated:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 26
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "DetailPageInvoked"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->DetailPageInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "AlternateDetailPageInvokedForcedPrime"

    const/16 v2, 0x13

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->AlternateDetailPageInvokedForcedPrime:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 27
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "AlternateDetailPageInvokedNeva"

    const/16 v2, 0x14

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->AlternateDetailPageInvokedNeva:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "AlternateDetailPageInvokedTwister"

    const/16 v2, 0x15

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->AlternateDetailPageInvokedTwister:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 28
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "DetailPagePogo"

    const/16 v2, 0x16

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->DetailPagePogo:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 31
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "MenuInvoked"

    const/16 v2, 0x17

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->MenuInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "ValueSelected"

    const/16 v2, 0x18

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->ValueSelected:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "SearchesPerFilterAccess"

    const/16 v2, 0x19

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchesPerFilterAccess:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 34
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "RelatedSearchesInvoked"

    const/16 v2, 0x1a

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->RelatedSearchesInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 37
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "RecentSearchesClear"

    const/16 v2, 0x1b

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->RecentSearchesClear:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "QueryBuilder"

    const/16 v2, 0x1c

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->QueryBuilder:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 40
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "ScrollDepth"

    const/16 v2, 0x1d

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->ScrollDepth:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 43
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "TimeToFirstSuggestion"

    const/16 v2, 0x1e

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->TimeToFirstSuggestion:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "Info"

    const/16 v2, 0x1f

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->Info:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 46
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "InitTime"

    const/16 v2, 0x20

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->InitTime:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 49
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "EntryVoiceInvoked"

    const/16 v2, 0x21

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->EntryVoiceInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "BarcodeInvoked"

    const/16 v2, 0x22

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->BarcodeInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "ImageInvoked"

    const/16 v2, 0x23

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->ImageInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "FlowInvoked"

    const/16 v2, 0x24

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->FlowInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 52
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "SearchList"

    const/16 v2, 0x25

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchList:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "SearchGrid"

    const/16 v2, 0x26

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchGrid:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "SearchImage"

    const/16 v2, 0x27

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchImage:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "SearchSplit"

    const/16 v2, 0x28

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchSplit:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 55
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "SearchWifi"

    const/16 v2, 0x29

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchWifi:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "SearchCell"

    const/16 v2, 0x2a

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchCell:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 58
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "SearchLandscape"

    const/16 v2, 0x2b

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchLandscape:Lcom/amazon/retailsearch/metrics/MetricName;

    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "SearchPortrait"

    const/16 v2, 0x2c

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->SearchPortrait:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 61
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "ClientVisibleImpression"

    const/16 v2, 0x2d

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->ClientVisibleImpression:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 64
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "NetworkError"

    const/16 v2, 0x2e

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->NetworkError:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 67
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "JsonError"

    const/16 v2, 0x2f

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->JsonError:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 70
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "EndOfResults"

    const/16 v2, 0x30

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->EndOfResults:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 73
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "AssetFetchType"

    const/16 v2, 0x31

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->AssetFetchType:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 76
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "MarketAppVersion"

    const/16 v2, 0x32

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->MarketAppVersion:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 79
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "BrowsePageLoaded"

    const/16 v2, 0x33

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->BrowsePageLoaded:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 81
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "BrowseActivityRefinementMenuClicked"

    const/16 v2, 0x34

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->BrowseActivityRefinementMenuClicked:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 82
    new-instance v0, Lcom/amazon/retailsearch/metrics/MetricName;

    const-string/jumbo v1, "NavActivityRefinementMenuClicked"

    const/16 v2, 0x35

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/MetricName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->NavActivityRefinementMenuClicked:Lcom/amazon/retailsearch/metrics/MetricName;

    .line 14
    const/16 v0, 0x36

    new-array v0, v0, [Lcom/amazon/retailsearch/metrics/MetricName;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATF:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToFirstByte:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->ClientATF:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFList:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFGrid:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFImage:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFSplit:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFWifi:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATFCell:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->FirstByte:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->RequestLatency:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->ResponseParseTime:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->StreamingResultsLatency:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->StreamingRefinementsLatency:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->Timeout:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->Error:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->BadResponse:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->Deprecated:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->DetailPageInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->AlternateDetailPageInvokedForcedPrime:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->AlternateDetailPageInvokedNeva:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->AlternateDetailPageInvokedTwister:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->DetailPagePogo:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->MenuInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->ValueSelected:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->SearchesPerFilterAccess:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->RelatedSearchesInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->RecentSearchesClear:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->QueryBuilder:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->ScrollDepth:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->TimeToFirstSuggestion:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->Info:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x20

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->InitTime:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x21

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->EntryVoiceInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x22

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->BarcodeInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x23

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->ImageInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x24

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->FlowInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x25

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->SearchList:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x26

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->SearchGrid:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x27

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->SearchImage:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x28

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->SearchSplit:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x29

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->SearchWifi:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->SearchCell:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->SearchLandscape:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->SearchPortrait:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->ClientVisibleImpression:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->NetworkError:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->JsonError:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x30

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->EndOfResults:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x31

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->AssetFetchType:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x32

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->MarketAppVersion:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x33

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->BrowsePageLoaded:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x34

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->BrowseActivityRefinementMenuClicked:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    const/16 v1, 0x35

    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->NavActivityRefinementMenuClicked:Lcom/amazon/retailsearch/metrics/MetricName;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->$VALUES:[Lcom/amazon/retailsearch/metrics/MetricName;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 14
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/MetricName;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    const-class v0, Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/metrics/MetricName;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/metrics/MetricName;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->$VALUES:[Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/metrics/MetricName;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/metrics/MetricName;

    return-object v0
.end method
