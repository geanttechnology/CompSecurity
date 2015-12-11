.class Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;
.super Ljava/lang/Thread;
.source "RefreshFeedsThread.java"


# static fields
.field protected static final EVENT_WHERE:Ljava/lang/String; = "eventWhere"

.field protected static final EVENT_WHERE_ARG:Ljava/lang/String; = "eventWhereArg"


# instance fields
.field abbre:Ljava/lang/String;

.field epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

.field feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

.field key:I

.field limit:Ljava/lang/String;

.field mEPEventType:Lcom/espn/androidplayersdk/utilities/EPEventType;

.field mEPFeaturedEventType:Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;

.field mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

.field mObject:Ljava/lang/Object;

.field networkCode:Ljava/lang/String;

.field networkId:Ljava/lang/String;

.field sport:Ljava/lang/String;

.field sportsid:Ljava/lang/String;

.field start:Ljava/lang/String;

.field subKey:I

.field subKeyMeta:Ljava/lang/String;

.field type:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;I)V
    .locals 2
    .param p1, "pLock"    # Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;
    .param p2, "key"    # I

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 52
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 33
    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    .line 34
    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKey:I

    .line 35
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

    .line 36
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkCode:Ljava/lang/String;

    .line 37
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkId:Ljava/lang/String;

    .line 38
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sportsid:Ljava/lang/String;

    .line 39
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sport:Ljava/lang/String;

    .line 40
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    .line 41
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    .line 42
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    .line 43
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->abbre:Ljava/lang/String;

    .line 44
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKeyMeta:Ljava/lang/String;

    .line 46
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 53
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>()V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    .line 54
    iput p2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    .line 55
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 56
    return-void
.end method

.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;IILcom/espn/androidplayersdk/datamanager/EPSport;)V
    .locals 2
    .param p1, "pLock"    # Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;
    .param p2, "key"    # I
    .param p3, "subKey"    # I
    .param p4, "sport"    # Lcom/espn/androidplayersdk/datamanager/EPSport;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 73
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 33
    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    .line 34
    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKey:I

    .line 35
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

    .line 36
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkCode:Ljava/lang/String;

    .line 37
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkId:Ljava/lang/String;

    .line 38
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sportsid:Ljava/lang/String;

    .line 39
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sport:Ljava/lang/String;

    .line 40
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    .line 41
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    .line 42
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    .line 43
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->abbre:Ljava/lang/String;

    .line 44
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKeyMeta:Ljava/lang/String;

    .line 46
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 74
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>()V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    .line 75
    iput p2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    .line 76
    iput p3, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKey:I

    .line 77
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 78
    iput-object p4, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

    .line 79
    return-void
.end method

.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;IILjava/lang/String;Lcom/espn/androidplayersdk/datamanager/EPSport;)V
    .locals 2
    .param p1, "pLock"    # Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;
    .param p2, "key"    # I
    .param p3, "subKey"    # I
    .param p4, "subKeyMeta"    # Ljava/lang/String;
    .param p5, "sport"    # Lcom/espn/androidplayersdk/datamanager/EPSport;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 82
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 33
    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    .line 34
    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKey:I

    .line 35
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

    .line 36
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkCode:Ljava/lang/String;

    .line 37
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkId:Ljava/lang/String;

    .line 38
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sportsid:Ljava/lang/String;

    .line 39
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sport:Ljava/lang/String;

    .line 40
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    .line 41
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    .line 42
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    .line 43
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->abbre:Ljava/lang/String;

    .line 44
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKeyMeta:Ljava/lang/String;

    .line 46
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 83
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>()V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    .line 84
    iput p2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    .line 85
    iput p3, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKey:I

    .line 86
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 87
    iput-object p5, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

    .line 88
    iput-object p4, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKeyMeta:Ljava/lang/String;

    .line 89
    return-void
.end method

.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;ILcom/espn/androidplayersdk/objects/EPChannels;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "pLock"    # Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;
    .param p2, "key"    # I
    .param p3, "epChannel"    # Lcom/espn/androidplayersdk/objects/EPChannels;
    .param p4, "type"    # Ljava/lang/String;
    .param p5, "limit"    # Ljava/lang/String;
    .param p6, "start"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 94
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 33
    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    .line 34
    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKey:I

    .line 35
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

    .line 36
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkCode:Ljava/lang/String;

    .line 37
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkId:Ljava/lang/String;

    .line 38
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sportsid:Ljava/lang/String;

    .line 39
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sport:Ljava/lang/String;

    .line 40
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    .line 41
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    .line 42
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    .line 43
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->abbre:Ljava/lang/String;

    .line 44
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKeyMeta:Ljava/lang/String;

    .line 46
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 95
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>()V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    .line 96
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 97
    iput p2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    .line 98
    invoke-virtual {p3}, Lcom/espn/androidplayersdk/objects/EPChannels;->getNetworkCode()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkCode:Ljava/lang/String;

    .line 99
    invoke-virtual {p3}, Lcom/espn/androidplayersdk/objects/EPChannels;->getNetworkId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkId:Ljava/lang/String;

    .line 100
    iput-object p4, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    .line 101
    iput-object p5, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    .line 102
    iput-object p6, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    .line 103
    return-void
.end method

.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;ILjava/lang/Object;Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;Lcom/espn/androidplayersdk/utilities/EPEventType;Ljava/lang/String;)V
    .locals 2
    .param p1, "pLock"    # Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;
    .param p2, "key"    # I
    .param p3, "object"    # Ljava/lang/Object;
    .param p4, "epFeaturedType"    # Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;
    .param p5, "epEventType"    # Lcom/espn/androidplayersdk/utilities/EPEventType;
    .param p6, "limit"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 62
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 33
    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    .line 34
    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKey:I

    .line 35
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

    .line 36
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkCode:Ljava/lang/String;

    .line 37
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkId:Ljava/lang/String;

    .line 38
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sportsid:Ljava/lang/String;

    .line 39
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sport:Ljava/lang/String;

    .line 40
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    .line 41
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    .line 42
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    .line 43
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->abbre:Ljava/lang/String;

    .line 44
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKeyMeta:Ljava/lang/String;

    .line 46
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 63
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>()V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    .line 64
    iput p2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    .line 65
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 66
    iput-object p3, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mObject:Ljava/lang/Object;

    .line 67
    iput-object p4, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mEPFeaturedEventType:Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;

    .line 68
    iput-object p5, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mEPEventType:Lcom/espn/androidplayersdk/utilities/EPEventType;

    .line 69
    iput-object p6, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    .line 70
    return-void
.end method

.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "pLock"    # Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;
    .param p2, "key"    # I
    .param p3, "sport"    # Ljava/lang/String;
    .param p4, "sportId"    # Ljava/lang/String;
    .param p5, "type"    # Ljava/lang/String;
    .param p6, "limit"    # Ljava/lang/String;
    .param p7, "start"    # Ljava/lang/String;
    .param p8, "abbre"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 109
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 33
    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    .line 34
    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKey:I

    .line 35
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

    .line 36
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkCode:Ljava/lang/String;

    .line 37
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkId:Ljava/lang/String;

    .line 38
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sportsid:Ljava/lang/String;

    .line 39
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sport:Ljava/lang/String;

    .line 40
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    .line 41
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    .line 42
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    .line 43
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->abbre:Ljava/lang/String;

    .line 44
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKeyMeta:Ljava/lang/String;

    .line 46
    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 110
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>()V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    .line 111
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 112
    iput p2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    .line 113
    iput-object p3, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sport:Ljava/lang/String;

    .line 114
    iput-object p4, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sportsid:Ljava/lang/String;

    .line 115
    iput-object p5, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    .line 116
    iput-object p6, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    .line 117
    iput-object p7, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    .line 118
    iput-object p8, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->abbre:Ljava/lang/String;

    .line 119
    return-void
.end method

.method private loadEventsForChannel(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 12
    .param p1, "networkCode"    # Ljava/lang/String;
    .param p2, "networkId"    # Ljava/lang/String;
    .param p3, "pEvent"    # Ljava/lang/String;
    .param p4, "limit"    # Ljava/lang/String;

    .prologue
    .line 502
    const/4 v10, 0x0

    .line 503
    .local v10, "eventsByChannelCursor":Landroid/database/Cursor;
    const/4 v2, 0x0

    .line 505
    .local v2, "event":Ljava/lang/String;
    if-eqz p3, :cond_2

    .line 506
    move-object v2, p3

    .line 510
    :goto_0
    if-nez p4, :cond_0

    .line 511
    :try_start_0
    const-string p4, "10"

    .line 513
    :cond_0
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v0, p2, v2}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getEventsForChannel(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 514
    invoke-interface {v10}, Landroid/database/Cursor;->getCount()I

    move-result v11

    .line 515
    .local v11, "start":I
    const/4 v0, 0x2

    new-array v8, v0, [Ljava/lang/String;

    .line 516
    .local v8, "dates":[Ljava/lang/String;
    const/16 v0, 0xa

    invoke-virtual {p0, v0, v8}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->setDateRange(I[Ljava/lang/String;)V

    .line 517
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-static {v11}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v1, 0x0

    aget-object v5, v8, v1

    const/4 v1, 0x1

    aget-object v6, v8, v1

    const/4 v7, 0x0

    move-object v1, p1

    move-object/from16 v3, p4

    invoke-virtual/range {v0 .. v7}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsByChannelFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 522
    if-eqz v10, :cond_1

    .line 523
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 525
    .end local v8    # "dates":[Ljava/lang/String;
    .end local v11    # "start":I
    :cond_1
    :goto_1
    return-void

    .line 508
    :cond_2
    :try_start_1
    sget-object v0, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v2

    goto :goto_0

    .line 519
    :catch_0
    move-exception v9

    .line 520
    .local v9, "e":Ljava/lang/Exception;
    :try_start_2
    const-string v0, "Error: "

    const/4 v1, 0x5

    invoke-static {v0, v1, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 522
    if-eqz v10, :cond_1

    .line 523
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 521
    .end local v9    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 522
    if-eqz v10, :cond_3

    .line 523
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 524
    :cond_3
    throw v0
.end method

.method private loadEventsForChannelByLeague(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 12
    .param p1, "networkCode"    # Ljava/lang/String;
    .param p2, "networkId"    # Ljava/lang/String;
    .param p3, "pEvent"    # Ljava/lang/String;
    .param p4, "limit"    # Ljava/lang/String;

    .prologue
    .line 681
    const/4 v10, 0x0

    .line 682
    .local v10, "eventsByChannelCursor":Landroid/database/Cursor;
    const/4 v2, 0x0

    .line 684
    .local v2, "event":Ljava/lang/String;
    if-eqz p3, :cond_2

    .line 685
    move-object v2, p3

    .line 689
    :goto_0
    if-nez p4, :cond_0

    .line 690
    :try_start_0
    const-string p4, "10"

    .line 692
    :cond_0
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v0, p2, v2}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getEventsForChannelByLeague(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 693
    invoke-interface {v10}, Landroid/database/Cursor;->getCount()I

    move-result v11

    .line 694
    .local v11, "start":I
    const/4 v0, 0x2

    new-array v8, v0, [Ljava/lang/String;

    .line 695
    .local v8, "dates":[Ljava/lang/String;
    const/16 v0, 0xa

    invoke-virtual {p0, v0, v8}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->setDateRange(I[Ljava/lang/String;)V

    .line 696
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-static {v11}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v1, 0x0

    aget-object v5, v8, v1

    const/4 v1, 0x1

    aget-object v6, v8, v1

    const/4 v7, 0x0

    move-object v1, p1

    move-object/from16 v3, p4

    invoke-virtual/range {v0 .. v7}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsByChannelSortedByLeagueFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 701
    if-eqz v10, :cond_1

    .line 702
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 704
    .end local v8    # "dates":[Ljava/lang/String;
    .end local v11    # "start":I
    :cond_1
    :goto_1
    return-void

    .line 687
    :cond_2
    :try_start_1
    sget-object v0, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v2

    goto :goto_0

    .line 698
    :catch_0
    move-exception v9

    .line 699
    .local v9, "e":Ljava/lang/Exception;
    :try_start_2
    const-string v0, "Error: "

    const/4 v1, 0x5

    invoke-static {v0, v1, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 701
    if-eqz v10, :cond_1

    .line 702
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 700
    .end local v9    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 701
    if-eqz v10, :cond_3

    .line 702
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 703
    :cond_3
    throw v0
.end method

.method private loadEventsForSport(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 12
    .param p1, "sportId"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "limit"    # Ljava/lang/String;

    .prologue
    .line 530
    const/4 v10, 0x0

    .line 533
    .local v10, "eventsBySportCursor":Landroid/database/Cursor;
    :try_start_0
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v0, p1, p2}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getEventsForSport(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 534
    invoke-interface {v10}, Landroid/database/Cursor;->getCount()I

    move-result v11

    .line 535
    .local v11, "start":I
    const/4 v0, 0x2

    new-array v8, v0, [Ljava/lang/String;

    .line 536
    .local v8, "dates":[Ljava/lang/String;
    const/16 v0, 0xa

    invoke-virtual {p0, v0, v8}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->setDateRange(I[Ljava/lang/String;)V

    .line 537
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-static {v11}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v1, 0x0

    aget-object v5, v8, v1

    const/4 v1, 0x1

    aget-object v6, v8, v1

    const/4 v7, 0x0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-virtual/range {v0 .. v7}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsBySportFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 542
    if-eqz v10, :cond_0

    .line 543
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 545
    .end local v8    # "dates":[Ljava/lang/String;
    .end local v11    # "start":I
    :cond_0
    :goto_0
    return-void

    .line 539
    :catch_0
    move-exception v9

    .line 540
    .local v9, "e":Ljava/lang/Exception;
    :try_start_1
    const-string v0, "Error: "

    const/4 v1, 0x5

    invoke-static {v0, v1, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 542
    if-eqz v10, :cond_0

    .line 543
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 541
    .end local v9    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 542
    if-eqz v10, :cond_1

    .line 543
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 544
    :cond_1
    throw v0
.end method

.method private loadEventsForSportByLeague(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 13
    .param p1, "sportId"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "abbre"    # Ljava/lang/String;
    .param p4, "limit"    # Ljava/lang/String;

    .prologue
    .line 709
    const/4 v11, 0x0

    .line 711
    .local v11, "eventsBySportCursor":Landroid/database/Cursor;
    :try_start_0
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v0, p1, p2}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getEventsForSportByLeague(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 712
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v12

    .line 713
    .local v12, "start":I
    const/4 v0, 0x2

    new-array v9, v0, [Ljava/lang/String;

    .line 714
    .local v9, "dates":[Ljava/lang/String;
    const/16 v0, 0xa

    invoke-virtual {p0, v0, v9}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->setDateRange(I[Ljava/lang/String;)V

    .line 715
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-static {v12}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    const/4 v1, 0x0

    aget-object v6, v9, v1

    const/4 v1, 0x1

    aget-object v7, v9, v1

    const/4 v8, 0x0

    move-object v1, p1

    move-object v2, p2

    move-object/from16 v3, p3

    move-object/from16 v4, p4

    invoke-virtual/range {v0 .. v8}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsBySportSortedByLeagueFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 720
    if-eqz v11, :cond_0

    .line 721
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 723
    .end local v9    # "dates":[Ljava/lang/String;
    .end local v12    # "start":I
    :cond_0
    :goto_0
    return-void

    .line 717
    :catch_0
    move-exception v10

    .line 718
    .local v10, "e":Ljava/lang/Exception;
    :try_start_1
    const-string v0, "Error: "

    const/4 v1, 0x5

    invoke-static {v0, v1, v10}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 720
    if-eqz v11, :cond_0

    .line 721
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 719
    .end local v10    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 720
    if-eqz v11, :cond_1

    .line 721
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 722
    :cond_1
    throw v0
.end method

.method private refreshChannelEventsByLeague(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 18
    .param p1, "networkID"    # Ljava/lang/String;
    .param p2, "networkCode"    # Ljava/lang/String;
    .param p3, "type"    # Ljava/lang/String;
    .param p4, "limit"    # Ljava/lang/String;

    .prologue
    .line 613
    const/4 v11, 0x0

    .line 616
    .local v11, "metaCursor":Landroid/database/Cursor;
    new-instance v12, Landroid/content/ContentValues;

    invoke-direct {v12}, Landroid/content/ContentValues;-><init>()V

    .line 617
    .local v12, "values":Landroid/content/ContentValues;
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 619
    .local v8, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v14, "metaEventRelationId = ? and networkId = ?"

    .line 620
    .local v14, "whereEvent":Ljava/lang/String;
    if-eqz p3, :cond_2

    .line 621
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v14}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, " and eventType = ?"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    .line 622
    const/4 v1, 0x3

    new-array v13, v1, [Ljava/lang/String;

    .line 623
    .local v13, "whereArgEvent":[Ljava/lang/String;
    const/4 v1, 0x2

    aput-object p3, v13, v1

    .line 627
    :goto_0
    const/4 v1, 0x0

    const-string v2, "8"

    aput-object v2, v13, v1

    .line 628
    const/4 v1, 0x1

    aput-object p1, v13, v1

    .line 630
    const-string v16, "eventRelationId = ? and networkId = ?"

    .line 631
    .local v16, "whereMetaEvent":Ljava/lang/String;
    if-eqz p3, :cond_3

    .line 632
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, " and eventsType = ?"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    .line 633
    const/4 v1, 0x3

    new-array v15, v1, [Ljava/lang/String;

    .line 634
    .local v15, "whereMetaArg":[Ljava/lang/String;
    const/4 v1, 0x2

    aput-object p3, v15, v1

    .line 635
    const-string v1, "eventsType"

    move-object/from16 v0, p3

    invoke-virtual {v12, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 639
    :goto_1
    const/4 v1, 0x0

    const-string v2, "8"

    aput-object v2, v15, v1

    .line 640
    const/4 v1, 0x1

    aput-object p1, v15, v1

    .line 642
    const-string v1, "networkId"

    move-object/from16 v0, p1

    invoke-virtual {v12, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 644
    const/4 v1, 0x2

    new-array v9, v1, [Ljava/lang/String;

    .line 645
    .local v9, "dates":[Ljava/lang/String;
    const/16 v1, 0xa

    move-object/from16 v0, p0

    invoke-virtual {v0, v1, v9}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->setDateRange(I[Ljava/lang/String;)V

    .line 648
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    move-object/from16 v17, v0

    monitor-enter v17
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 650
    :try_start_1
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v2, "metaEvents"

    move-object/from16 v0, v16

    invoke-virtual {v1, v2, v0, v15}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getMeta(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 651
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_4

    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 652
    const-string v1, "ttl"

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/espn/androidplayersdk/utilities/Utils;->isExpired(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 653
    const-string v1, "eventWhere"

    invoke-virtual {v8, v1, v14}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 654
    const-string v1, "eventWhereArg"

    invoke-virtual {v8, v1, v13}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 655
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v2, "metaEvents"

    move-object/from16 v0, v16

    invoke-virtual {v1, v2, v0, v15, v12}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 656
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    const/4 v2, 0x0

    aget-object v6, v9, v2

    const/4 v2, 0x1

    aget-object v7, v9, v2

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    move-object/from16 v4, p4

    invoke-virtual/range {v1 .. v8}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsByChannelSortedByLeagueFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 648
    :cond_0
    :goto_2
    :try_start_2
    monitor-exit v17
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 669
    if-eqz v11, :cond_1

    .line 670
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 673
    :cond_1
    :goto_3
    return-void

    .line 625
    .end local v9    # "dates":[Ljava/lang/String;
    .end local v13    # "whereArgEvent":[Ljava/lang/String;
    .end local v15    # "whereMetaArg":[Ljava/lang/String;
    .end local v16    # "whereMetaEvent":Ljava/lang/String;
    :cond_2
    const/4 v1, 0x2

    new-array v13, v1, [Ljava/lang/String;

    .restart local v13    # "whereArgEvent":[Ljava/lang/String;
    goto/16 :goto_0

    .line 637
    .restart local v16    # "whereMetaEvent":Ljava/lang/String;
    :cond_3
    const/4 v1, 0x2

    new-array v15, v1, [Ljava/lang/String;

    .restart local v15    # "whereMetaArg":[Ljava/lang/String;
    goto :goto_1

    .line 659
    .restart local v9    # "dates":[Ljava/lang/String;
    :cond_4
    :try_start_3
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v2, "metaEvents"

    move-object/from16 v0, v16

    invoke-virtual {v1, v2, v0, v15, v12}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 660
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    const/4 v2, 0x0

    aget-object v6, v9, v2

    const/4 v2, 0x1

    aget-object v7, v9, v2

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    move-object/from16 v4, p4

    invoke-virtual/range {v1 .. v8}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsByChannelSortedByLeagueFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_2

    .line 662
    :catch_0
    move-exception v10

    .line 663
    .local v10, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v1, "Error: "

    const/4 v2, 0x5

    invoke-static {v1, v2, v10}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_2

    .line 648
    .end local v10    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    monitor-exit v17
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v1
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 666
    :catch_1
    move-exception v10

    .line 667
    .restart local v10    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v1, "Error: "

    const/4 v2, 0x5

    invoke-static {v1, v2, v10}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 669
    if-eqz v11, :cond_1

    .line 670
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    goto :goto_3

    .line 668
    .end local v10    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v1

    .line 669
    if-eqz v11, :cond_5

    .line 670
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 671
    :cond_5
    throw v1
.end method

.method private refreshChannelsFeed()V
    .locals 10

    .prologue
    .line 416
    const/4 v1, 0x0

    .line 418
    .local v1, "metaCursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    monitor-enter v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 420
    :try_start_1
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v4, "metaChannel"

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual {v2, v4, v5, v6}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getMeta(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 421
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-lez v2, :cond_2

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 422
    const-string v2, "TTL"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/espn/androidplayersdk/utilities/Utils;->isExpired(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 423
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v4, "metaChannel"

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    const-string v9, "TTL"

    aput-object v9, v7, v8

    invoke-virtual {v2, v4, v5, v6, v7}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForMisc(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V

    .line 424
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getChannelFeed()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 418
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 437
    if-eqz v1, :cond_1

    .line 438
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 440
    :cond_1
    :goto_1
    return-void

    .line 427
    :cond_2
    :try_start_3
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v4, "metaChannel"

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    const-string v9, "TTL"

    aput-object v9, v7, v8

    invoke-virtual {v2, v4, v5, v6, v7}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForMisc(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V

    .line 428
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getChannelFeed()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 430
    :catch_0
    move-exception v0

    .line 431
    .local v0, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v2, "Error: "

    const/4 v4, 0x5

    invoke-static {v2, v4, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 418
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v2
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 434
    :catch_1
    move-exception v0

    .line 435
    .restart local v0    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v2, "Error: "

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 437
    if-eqz v1, :cond_1

    .line 438
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 436
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v2

    .line 437
    if-eqz v1, :cond_3

    .line 438
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 439
    :cond_3
    throw v2
.end method

.method private refreshConfigFeed()V
    .locals 6

    .prologue
    .line 477
    const/4 v0, 0x0

    .line 479
    .local v0, "configCursor":Landroid/database/Cursor;
    :try_start_0
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getConfig()Landroid/database/Cursor;

    move-result-object v0

    .line 480
    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-lez v2, :cond_2

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 481
    const-string v2, "TTL"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/espn/androidplayersdk/utilities/Utils;->isExpired(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 482
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v3, "config"

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v4, v5}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->delAllRows(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 483
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getConfigFeed()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 491
    :cond_0
    :goto_0
    if-eqz v0, :cond_1

    .line 492
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 494
    :cond_1
    :goto_1
    return-void

    .line 486
    :cond_2
    :try_start_1
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getConfigFeed()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 488
    :catch_0
    move-exception v1

    .line 489
    .local v1, "e":Ljava/lang/Exception;
    :try_start_2
    const-string v2, "Error: "

    const/4 v3, 0x5

    invoke-static {v2, v3, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 491
    if-eqz v0, :cond_1

    .line 492
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 490
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v2

    .line 491
    if-eqz v0, :cond_3

    .line 492
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 493
    :cond_3
    throw v2
.end method

.method private refreshEventsByChannelsFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 17
    .param p1, "networkCode"    # Ljava/lang/String;
    .param p2, "networkId"    # Ljava/lang/String;
    .param p3, "type"    # Ljava/lang/String;
    .param p4, "limit"    # Ljava/lang/String;
    .param p5, "start"    # Ljava/lang/String;

    .prologue
    .line 301
    const/4 v11, 0x0

    .line 302
    .local v11, "metaCursor":Landroid/database/Cursor;
    const/4 v1, 0x3

    new-array v13, v1, [Ljava/lang/String;

    .line 303
    .local v13, "whereArg":[Ljava/lang/String;
    new-instance v12, Landroid/content/ContentValues;

    invoke-direct {v12}, Landroid/content/ContentValues;-><init>()V

    .line 304
    .local v12, "values":Landroid/content/ContentValues;
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 306
    .local v8, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    if-nez p4, :cond_0

    .line 307
    :try_start_0
    const-string p4, "10"

    .line 308
    :cond_0
    const-string v14, "metaEventRelationId = ? and networkId = ? and eventType = ?"

    .line 310
    .local v14, "whereEvent":Ljava/lang/String;
    const/4 v1, 0x0

    const-string v2, "3"

    aput-object v2, v13, v1

    .line 311
    const/4 v1, 0x1

    aput-object p2, v13, v1

    .line 312
    const/4 v1, 0x2

    aput-object p3, v13, v1

    .line 313
    const-string v1, "eventsType"

    move-object/from16 v0, p3

    invoke-virtual {v12, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 314
    const-string v1, "networkId"

    move-object/from16 v0, p2

    invoke-virtual {v12, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 316
    const-string v15, "eventRelationId = ? and networkId = ? and eventsType = ?"

    .line 319
    .local v15, "whereMetaEvent":Ljava/lang/String;
    const/4 v1, 0x2

    new-array v9, v1, [Ljava/lang/String;

    .line 320
    .local v9, "dates":[Ljava/lang/String;
    const/16 v1, 0xa

    move-object/from16 v0, p0

    invoke-virtual {v0, v1, v9}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->setDateRange(I[Ljava/lang/String;)V

    .line 321
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    move-object/from16 v16, v0

    monitor-enter v16
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 323
    :try_start_1
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v2, "metaEvents"

    invoke-virtual {v1, v2, v15, v13}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getMeta(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 324
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_3

    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 325
    const-string v1, "ttl"

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/espn/androidplayersdk/utilities/Utils;->isExpired(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 326
    const-string v1, "eventWhere"

    invoke-virtual {v8, v1, v14}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 327
    const-string v1, "eventWhereArg"

    invoke-virtual {v8, v1, v13}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 328
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v2, "metaEvents"

    invoke-virtual {v1, v2, v15, v13, v12}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 329
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    const/4 v2, 0x0

    aget-object v6, v9, v2

    const/4 v2, 0x1

    aget-object v7, v9, v2

    move-object/from16 v2, p1

    move-object/from16 v3, p3

    move-object/from16 v4, p4

    move-object/from16 v5, p5

    invoke-virtual/range {v1 .. v8}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsByChannelFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 321
    :cond_1
    :goto_0
    :try_start_2
    monitor-exit v16
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 342
    if-eqz v11, :cond_2

    .line 343
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 345
    .end local v9    # "dates":[Ljava/lang/String;
    .end local v14    # "whereEvent":Ljava/lang/String;
    .end local v15    # "whereMetaEvent":Ljava/lang/String;
    :cond_2
    :goto_1
    return-void

    .line 332
    .restart local v9    # "dates":[Ljava/lang/String;
    .restart local v14    # "whereEvent":Ljava/lang/String;
    .restart local v15    # "whereMetaEvent":Ljava/lang/String;
    :cond_3
    :try_start_3
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v2, "metaEvents"

    invoke-virtual {v1, v2, v15, v13, v12}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 333
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    const/4 v2, 0x0

    aget-object v6, v9, v2

    const/4 v2, 0x1

    aget-object v7, v9, v2

    move-object/from16 v2, p1

    move-object/from16 v3, p3

    move-object/from16 v4, p4

    move-object/from16 v5, p5

    invoke-virtual/range {v1 .. v8}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsByChannelFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 335
    :catch_0
    move-exception v10

    .line 336
    .local v10, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v1, "Error: "

    const/4 v2, 0x5

    invoke-static {v1, v2, v10}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 321
    .end local v10    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    monitor-exit v16
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v1
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 339
    .end local v9    # "dates":[Ljava/lang/String;
    .end local v14    # "whereEvent":Ljava/lang/String;
    .end local v15    # "whereMetaEvent":Ljava/lang/String;
    :catch_1
    move-exception v10

    .line 340
    .restart local v10    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v1, "Error: "

    const/4 v2, 0x5

    invoke-static {v1, v2, v10}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 342
    if-eqz v11, :cond_2

    .line 343
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 341
    .end local v10    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v1

    .line 342
    if-eqz v11, :cond_4

    .line 343
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 344
    :cond_4
    throw v1
.end method

.method private refreshEventsBySportFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 18
    .param p1, "sport"    # Ljava/lang/String;
    .param p2, "sportId"    # Ljava/lang/String;
    .param p3, "type"    # Ljava/lang/String;
    .param p4, "limit"    # Ljava/lang/String;
    .param p5, "start"    # Ljava/lang/String;

    .prologue
    .line 353
    const/4 v11, 0x0

    .line 356
    .local v11, "metaCursor":Landroid/database/Cursor;
    new-instance v12, Landroid/content/ContentValues;

    invoke-direct {v12}, Landroid/content/ContentValues;-><init>()V

    .line 357
    .local v12, "values":Landroid/content/ContentValues;
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 359
    .local v8, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v14, "metaEventRelationId = ? and sportId = ?"

    .line 360
    .local v14, "whereEvent":Ljava/lang/String;
    if-eqz p3, :cond_2

    .line 361
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v14}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, " and eventType = ?"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    .line 362
    const/4 v1, 0x3

    new-array v13, v1, [Ljava/lang/String;

    .line 363
    .local v13, "whereArgEvent":[Ljava/lang/String;
    const/4 v1, 0x2

    aput-object p3, v13, v1

    .line 367
    :goto_0
    const/4 v1, 0x0

    const-string v2, "4"

    aput-object v2, v13, v1

    .line 368
    const/4 v1, 0x1

    aput-object p2, v13, v1

    .line 370
    const-string v16, "eventRelationId = ? and sportId = ?"

    .line 371
    .local v16, "whereMetaEvent":Ljava/lang/String;
    if-eqz p3, :cond_3

    .line 372
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, " and eventsType = ?"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    .line 373
    const/4 v1, 0x3

    new-array v15, v1, [Ljava/lang/String;

    .line 374
    .local v15, "whereMetaArg":[Ljava/lang/String;
    const/4 v1, 0x2

    aput-object p3, v15, v1

    .line 375
    const-string v1, "eventsType"

    move-object/from16 v0, p3

    invoke-virtual {v12, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 379
    :goto_1
    const/4 v1, 0x0

    const-string v2, "4"

    aput-object v2, v15, v1

    .line 380
    const/4 v1, 0x1

    aput-object p2, v15, v1

    .line 382
    const-string v1, "sportId"

    move-object/from16 v0, p2

    invoke-virtual {v12, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 385
    const/4 v1, 0x2

    new-array v9, v1, [Ljava/lang/String;

    .line 386
    .local v9, "dates":[Ljava/lang/String;
    const/16 v1, 0xa

    move-object/from16 v0, p0

    invoke-virtual {v0, v1, v9}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->setDateRange(I[Ljava/lang/String;)V

    .line 388
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    move-object/from16 v17, v0

    monitor-enter v17
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 390
    :try_start_1
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v2, "metaEvents"

    move-object/from16 v0, v16

    invoke-virtual {v1, v2, v0, v15}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getMeta(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 391
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_4

    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 392
    const-string v1, "ttl"

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/espn/androidplayersdk/utilities/Utils;->isExpired(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 393
    const-string v1, "eventWhere"

    invoke-virtual {v8, v1, v14}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 394
    const-string v1, "eventWhereArg"

    invoke-virtual {v8, v1, v13}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 395
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v2, "metaEvents"

    move-object/from16 v0, v16

    invoke-virtual {v1, v2, v0, v15, v12}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 396
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    const/4 v2, 0x0

    aget-object v6, v9, v2

    const/4 v2, 0x1

    aget-object v7, v9, v2

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    move-object/from16 v4, p4

    move-object/from16 v5, p5

    invoke-virtual/range {v1 .. v8}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsBySportFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 388
    :cond_0
    :goto_2
    :try_start_2
    monitor-exit v17
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 409
    if-eqz v11, :cond_1

    .line 410
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 412
    :cond_1
    :goto_3
    return-void

    .line 365
    .end local v9    # "dates":[Ljava/lang/String;
    .end local v13    # "whereArgEvent":[Ljava/lang/String;
    .end local v15    # "whereMetaArg":[Ljava/lang/String;
    .end local v16    # "whereMetaEvent":Ljava/lang/String;
    :cond_2
    const/4 v1, 0x2

    new-array v13, v1, [Ljava/lang/String;

    .restart local v13    # "whereArgEvent":[Ljava/lang/String;
    goto/16 :goto_0

    .line 377
    .restart local v16    # "whereMetaEvent":Ljava/lang/String;
    :cond_3
    const/4 v1, 0x2

    new-array v15, v1, [Ljava/lang/String;

    .restart local v15    # "whereMetaArg":[Ljava/lang/String;
    goto :goto_1

    .line 399
    .restart local v9    # "dates":[Ljava/lang/String;
    :cond_4
    :try_start_3
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v2, "metaEvents"

    move-object/from16 v0, v16

    invoke-virtual {v1, v2, v0, v15, v12}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 400
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    const/4 v2, 0x0

    aget-object v6, v9, v2

    const/4 v2, 0x1

    aget-object v7, v9, v2

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    move-object/from16 v4, p4

    move-object/from16 v5, p5

    invoke-virtual/range {v1 .. v8}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsBySportFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_2

    .line 402
    :catch_0
    move-exception v10

    .line 403
    .local v10, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v1, "Error: "

    const/4 v2, 0x5

    invoke-static {v1, v2, v10}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_2

    .line 388
    .end local v10    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    monitor-exit v17
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v1
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 406
    :catch_1
    move-exception v10

    .line 407
    .restart local v10    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v1, "Error: "

    const/4 v2, 0x5

    invoke-static {v1, v2, v10}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 409
    if-eqz v11, :cond_1

    .line 410
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    goto :goto_3

    .line 408
    .end local v10    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v1

    .line 409
    if-eqz v11, :cond_5

    .line 410
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 411
    :cond_5
    throw v1
.end method

.method private refreshFeaturedCategory()V
    .locals 10

    .prologue
    .line 727
    const/4 v2, 0x0

    .line 728
    .local v2, "metaCursor":Landroid/database/Cursor;
    const/4 v3, 0x0

    .line 729
    .local v3, "values":Landroid/content/ContentValues;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 730
    .local v1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v7, 0x1

    new-array v4, v7, [Ljava/lang/String;

    .line 731
    .local v4, "whereArg":[Ljava/lang/String;
    const-string v5, "metaEventRelationId = ?"

    .line 732
    .local v5, "whereEvent":Ljava/lang/String;
    const-string v6, "eventRelationId = ?"

    .line 733
    .local v6, "whereMeta":Ljava/lang/String;
    const/4 v7, 0x0

    iget v8, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    invoke-static {v8}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v4, v7

    .line 735
    :try_start_0
    iget-object v8, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    monitor-enter v8
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 737
    :try_start_1
    sget-object v7, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v9, "metaEvents"

    invoke-virtual {v7, v9, v6, v4}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getMeta(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 738
    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v7

    if-lez v7, :cond_2

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 739
    const-string v7, "ttl"

    invoke-interface {v2, v7}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    invoke-interface {v2, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/espn/androidplayersdk/utilities/Utils;->isExpired(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 740
    const-string v7, "eventWhere"

    invoke-virtual {v1, v7, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 741
    const-string v7, "eventWhereArg"

    invoke-virtual {v1, v7, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 742
    sget-object v7, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v9, "metaEvents"

    invoke-virtual {v7, v9, v6, v4, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 743
    iget-object v7, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v7, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getFeturedCategories(Ljava/util/HashMap;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 735
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v8
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 756
    if-eqz v2, :cond_1

    .line 757
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 759
    :cond_1
    :goto_1
    return-void

    .line 746
    :cond_2
    :try_start_3
    sget-object v7, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v9, "metaEvents"

    invoke-virtual {v7, v9, v6, v4, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 747
    iget-object v7, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v7, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getFeturedCategories(Ljava/util/HashMap;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 749
    :catch_0
    move-exception v0

    .line 750
    .local v0, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v7, "Error: "

    const/4 v9, 0x5

    invoke-static {v7, v9, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 735
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v7

    monitor-exit v8
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v7
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 753
    :catch_1
    move-exception v0

    .line 754
    .restart local v0    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v7, "Error: "

    const/4 v8, 0x5

    invoke-static {v7, v8, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 756
    if-eqz v2, :cond_1

    .line 757
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 755
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v7

    .line 756
    if-eqz v2, :cond_3

    .line 757
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 758
    :cond_3
    throw v7
.end method

.method private refreshFeaturedCategoryEvents()V
    .locals 18

    .prologue
    .line 763
    const/4 v12, 0x0

    .line 764
    .local v12, "metaCursor":Landroid/database/Cursor;
    new-instance v13, Landroid/content/ContentValues;

    invoke-direct {v13}, Landroid/content/ContentValues;-><init>()V

    .line 766
    .local v13, "values":Landroid/content/ContentValues;
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 767
    .local v3, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v1, 0x3

    new-array v9, v1, [Ljava/lang/String;

    .line 768
    .local v9, "dates":[Ljava/lang/String;
    const/4 v1, 0x3

    new-array v14, v1, [Ljava/lang/String;

    .line 769
    .local v14, "whereArg":[Ljava/lang/String;
    const-string v15, "metaEventRelationId = ? and eventType = ? and sportId = ?"

    .line 770
    .local v15, "whereEvent":Ljava/lang/String;
    const-string v16, "eventRelationId = ? and eventsType = ? and sportId = ?"

    .line 772
    .local v16, "whereMeta":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mObject:Ljava/lang/Object;

    check-cast v11, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;

    .line 774
    .local v11, "mEPFeaturedCategory":Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;
    const-string v1, "sportId"

    invoke-virtual {v11}, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->getCategoryId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 775
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iget v4, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v14, v1

    .line 776
    const/4 v1, 0x2

    invoke-virtual {v11}, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->getCategoryId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v14, v1

    .line 777
    const-string v1, "sportId"

    invoke-virtual {v11}, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->getCategoryId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v13, v1, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 778
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mEPFeaturedEventType:Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;

    sget-object v4, Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;->VOD:Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;

    if-ne v1, v4, :cond_2

    .line 779
    const/4 v1, 0x1

    const-string v4, "VOD"

    aput-object v4, v14, v1

    .line 780
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-virtual {v11}, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->getVodUrl()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "?"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 781
    .local v2, "baseUrl":Ljava/lang/String;
    const-string v1, "featuredCatEventType"

    sget-object v4, Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;->VOD:Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 782
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    .line 783
    const-string v1, "eventsType"

    const-string v4, "VOD"

    invoke-virtual {v13, v1, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 794
    :goto_0
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    move-object/from16 v17, v0

    monitor-enter v17
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 796
    :try_start_1
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v4, "metaEvents"

    move-object/from16 v0, v16

    invoke-virtual {v1, v4, v0, v14}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getMeta(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v12

    .line 797
    invoke-interface {v12}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_3

    invoke-interface {v12}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 798
    const-string v1, "ttl"

    invoke-interface {v12, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v12, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/espn/androidplayersdk/utilities/Utils;->isExpired(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 799
    const-string v1, "eventWhere"

    invoke-virtual {v3, v1, v15}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 800
    const-string v1, "eventWhereArg"

    invoke-virtual {v3, v1, v14}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 801
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v4, "metaEvents"

    move-object/from16 v0, v16

    invoke-virtual {v1, v4, v0, v14, v13}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 802
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    const/4 v5, 0x0

    aget-object v5, v9, v5

    const/4 v6, 0x1

    aget-object v6, v9, v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    invoke-virtual/range {v1 .. v8}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsForFeaturedCategory(Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 794
    :cond_0
    :goto_1
    :try_start_2
    monitor-exit v17
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 815
    if-eqz v12, :cond_1

    .line 816
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    .line 818
    :cond_1
    :goto_2
    return-void

    .line 785
    .end local v2    # "baseUrl":Ljava/lang/String;
    :cond_2
    const/4 v1, 0x1

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mEPEventType:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v14, v1

    .line 786
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-virtual {v11}, Lcom/espn/androidplayersdk/datamanager/EPFeaturedCategory;->getListingsUrl()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 787
    .restart local v2    # "baseUrl":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mEPEventType:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    .line 788
    const-string v1, "featuredCatEventType"

    sget-object v4, Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;->LINEAR:Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 789
    const/16 v1, 0xa

    move-object/from16 v0, p0

    invoke-virtual {v0, v1, v9}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->setDateRange(I[Ljava/lang/String;)V

    .line 790
    const-string v1, "eventsType"

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mEPEventType:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v13, v1, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 805
    :cond_3
    :try_start_3
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v4, "metaEvents"

    move-object/from16 v0, v16

    invoke-virtual {v1, v4, v0, v14, v13}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 806
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    const/4 v5, 0x0

    aget-object v5, v9, v5

    const/4 v6, 0x1

    aget-object v6, v9, v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    invoke-virtual/range {v1 .. v8}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsForFeaturedCategory(Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 808
    :catch_0
    move-exception v10

    .line 809
    .local v10, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v1, "Error: "

    const/4 v4, 0x5

    invoke-static {v1, v4, v10}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1

    .line 794
    .end local v10    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    monitor-exit v17
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v1
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 812
    :catch_1
    move-exception v10

    .line 813
    .restart local v10    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v1, "Error: "

    const/4 v4, 0x5

    invoke-static {v1, v4, v10}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 815
    if-eqz v12, :cond_1

    .line 816
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    goto/16 :goto_2

    .line 814
    .end local v10    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v1

    .line 815
    if-eqz v12, :cond_4

    .line 816
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    .line 817
    :cond_4
    throw v1
.end method

.method private refreshSportEventsByLeague(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 20
    .param p1, "sportId"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "limit"    # Ljava/lang/String;
    .param p4, "abbre"    # Ljava/lang/String;

    .prologue
    .line 549
    const/4 v13, 0x0

    .line 552
    .local v13, "metaCursor":Landroid/database/Cursor;
    new-instance v14, Landroid/content/ContentValues;

    invoke-direct {v14}, Landroid/content/ContentValues;-><init>()V

    .line 553
    .local v14, "values":Landroid/content/ContentValues;
    new-instance v10, Ljava/util/HashMap;

    invoke-direct {v10}, Ljava/util/HashMap;-><init>()V

    .line 555
    .local v10, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v16, "metaEventRelationId = ? and sportId = ?"

    .line 556
    .local v16, "whereEvent":Ljava/lang/String;
    if-eqz p2, :cond_2

    .line 557
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " and eventType = ?"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    .line 558
    const/4 v2, 0x3

    new-array v15, v2, [Ljava/lang/String;

    .line 559
    .local v15, "whereArgEvent":[Ljava/lang/String;
    const/4 v2, 0x2

    aput-object p2, v15, v2

    .line 563
    :goto_0
    const/4 v2, 0x0

    const-string v3, "7"

    aput-object v3, v15, v2

    .line 564
    const/4 v2, 0x1

    aput-object p1, v15, v2

    .line 566
    const-string v18, "eventRelationId = ? and sportId = ?"

    .line 567
    .local v18, "whereMetaEvent":Ljava/lang/String;
    if-eqz p2, :cond_3

    .line 568
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static/range {v18 .. v18}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " and eventsType = ?"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    .line 569
    const/4 v2, 0x3

    new-array v0, v2, [Ljava/lang/String;

    move-object/from16 v17, v0

    .line 570
    .local v17, "whereMetaArg":[Ljava/lang/String;
    const/4 v2, 0x2

    aput-object p2, v17, v2

    .line 571
    const-string v2, "eventsType"

    move-object/from16 v0, p2

    invoke-virtual {v14, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 575
    :goto_1
    const/4 v2, 0x0

    const-string v3, "7"

    aput-object v3, v17, v2

    .line 576
    const/4 v2, 0x1

    aput-object p1, v17, v2

    .line 578
    const-string v2, "sportId"

    move-object/from16 v0, p1

    invoke-virtual {v14, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 580
    const/4 v2, 0x2

    new-array v11, v2, [Ljava/lang/String;

    .line 581
    .local v11, "dates":[Ljava/lang/String;
    const/16 v2, 0xa

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v11}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->setDateRange(I[Ljava/lang/String;)V

    .line 584
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    move-object/from16 v19, v0

    monitor-enter v19
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 586
    :try_start_1
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v3, "metaEvents"

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v2, v3, v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getMeta(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v13

    .line 587
    invoke-interface {v13}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-lez v2, :cond_4

    invoke-interface {v13}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 588
    const-string v2, "ttl"

    invoke-interface {v13, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v13, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/espn/androidplayersdk/utilities/Utils;->isExpired(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 589
    const-string v2, "eventWhere"

    move-object/from16 v0, v16

    invoke-virtual {v10, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 590
    const-string v2, "eventWhereArg"

    invoke-virtual {v10, v2, v15}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 591
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v3, "metaEvents"

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v2, v3, v0, v1, v14}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 592
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    const/4 v3, 0x0

    aget-object v8, v11, v3

    const/4 v3, 0x1

    aget-object v9, v11, v3

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v5, p4

    move-object/from16 v6, p3

    invoke-virtual/range {v2 .. v10}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsBySportSortedByLeagueFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 584
    :cond_0
    :goto_2
    :try_start_2
    monitor-exit v19
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 605
    if-eqz v13, :cond_1

    .line 606
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    .line 609
    :cond_1
    :goto_3
    return-void

    .line 561
    .end local v11    # "dates":[Ljava/lang/String;
    .end local v15    # "whereArgEvent":[Ljava/lang/String;
    .end local v17    # "whereMetaArg":[Ljava/lang/String;
    .end local v18    # "whereMetaEvent":Ljava/lang/String;
    :cond_2
    const/4 v2, 0x2

    new-array v15, v2, [Ljava/lang/String;

    .restart local v15    # "whereArgEvent":[Ljava/lang/String;
    goto/16 :goto_0

    .line 573
    .restart local v18    # "whereMetaEvent":Ljava/lang/String;
    :cond_3
    const/4 v2, 0x2

    new-array v0, v2, [Ljava/lang/String;

    move-object/from16 v17, v0

    .restart local v17    # "whereMetaArg":[Ljava/lang/String;
    goto/16 :goto_1

    .line 595
    .restart local v11    # "dates":[Ljava/lang/String;
    :cond_4
    :try_start_3
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v3, "metaEvents"

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v2, v3, v0, v1, v14}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 596
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    const/4 v3, 0x0

    aget-object v8, v11, v3

    const/4 v3, 0x1

    aget-object v9, v11, v3

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v5, p4

    move-object/from16 v6, p3

    invoke-virtual/range {v2 .. v10}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsBySportSortedByLeagueFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_2

    .line 598
    :catch_0
    move-exception v12

    .line 599
    .local v12, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v2, "Error: "

    const/4 v3, 0x5

    invoke-static {v2, v3, v12}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_2

    .line 584
    .end local v12    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v2

    monitor-exit v19
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v2
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 602
    :catch_1
    move-exception v12

    .line 603
    .restart local v12    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v2, "Error: "

    const/4 v3, 0x5

    invoke-static {v2, v3, v12}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 605
    if-eqz v13, :cond_1

    .line 606
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    goto :goto_3

    .line 604
    .end local v12    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v2

    .line 605
    if-eqz v13, :cond_5

    .line 606
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    .line 607
    :cond_5
    throw v2
.end method

.method private refreshSportsFeed(I)V
    .locals 11
    .param p1, "subKey"    # I

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 444
    const/4 v2, 0x0

    .line 445
    .local v2, "metaCursor":Landroid/database/Cursor;
    const-string v3, "sportrelationId= ?"

    .line 446
    .local v3, "where":Ljava/lang/String;
    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    .line 447
    .local v1, "keyStr":Ljava/lang/String;
    new-array v4, v6, [Ljava/lang/String;

    aput-object v1, v4, v5

    .line 449
    .local v4, "whereArg":[Ljava/lang/String;
    :try_start_0
    iget-object v6, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    monitor-enter v6
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 451
    :try_start_1
    sget-object v5, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v7, "metaSport"

    invoke-virtual {v5, v7, v3, v4}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getMeta(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 452
    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v5

    if-lez v5, :cond_2

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 453
    const-string v5, "TTL"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/espn/androidplayersdk/utilities/Utils;->isExpired(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 454
    sget-object v5, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v7, "metaSport"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    const-string v10, "TTL"

    aput-object v10, v8, v9

    const/4 v9, 0x1

    .line 455
    const-string v10, "sportrelationId"

    aput-object v10, v8, v9

    .line 454
    invoke-virtual {v5, v7, v3, v4, v8}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForMisc(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V

    .line 456
    iget-object v5, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v5, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getSportsFeed(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 449
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v6
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 470
    if-eqz v2, :cond_1

    .line 471
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 473
    :cond_1
    :goto_1
    return-void

    .line 459
    :cond_2
    :try_start_3
    sget-object v5, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v7, "metaSport"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    const-string v10, "TTL"

    aput-object v10, v8, v9

    const/4 v9, 0x1

    .line 460
    const-string v10, "sportrelationId"

    aput-object v10, v8, v9

    .line 459
    invoke-virtual {v5, v7, v3, v4, v8}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForMisc(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V

    .line 461
    iget-object v5, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v5, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getSportsFeed(Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 463
    :catch_0
    move-exception v0

    .line 464
    .local v0, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v5, "Error: "

    const/4 v7, 0x5

    invoke-static {v5, v7, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 449
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v5

    monitor-exit v6
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v5
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 467
    :catch_1
    move-exception v0

    .line 468
    .restart local v0    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v5, "Error: "

    const/4 v6, 0x5

    invoke-static {v5, v6, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 470
    if-eqz v2, :cond_1

    .line 471
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 469
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v5

    .line 470
    if-eqz v2, :cond_3

    .line 471
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 472
    :cond_3
    throw v5
.end method

.method private refreshTopSportEvents()V
    .locals 19

    .prologue
    .line 822
    const/4 v13, 0x0

    .line 823
    .local v13, "metaCursor":Landroid/database/Cursor;
    new-instance v14, Landroid/content/ContentValues;

    invoke-direct {v14}, Landroid/content/ContentValues;-><init>()V

    .line 824
    .local v14, "values":Landroid/content/ContentValues;
    const/4 v9, 0x0

    .line 826
    .local v9, "isVod":Z
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 827
    .local v3, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v1, 0x3

    new-array v10, v1, [Ljava/lang/String;

    .line 828
    .local v10, "dates":[Ljava/lang/String;
    const/4 v1, 0x3

    new-array v15, v1, [Ljava/lang/String;

    .line 829
    .local v15, "whereArg":[Ljava/lang/String;
    const-string v16, "metaEventRelationId = ? and eventType = ? and sportId = ?"

    .line 830
    .local v16, "whereEvent":Ljava/lang/String;
    const-string v17, "eventRelationId = ? and eventsType = ? and sportId = ?"

    .line 832
    .local v17, "whereMeta":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mObject:Ljava/lang/Object;

    check-cast v12, Lcom/espn/androidplayersdk/datamanager/EPSport;

    .line 833
    .local v12, "mEPSport":Lcom/espn/androidplayersdk/datamanager/EPSport;
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iget v4, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v15, v1

    .line 834
    const-string v1, "sportId"

    invoke-virtual {v12}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 835
    const/4 v1, 0x2

    invoke-virtual {v12}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v15, v1

    .line 836
    const-string v1, "sportId"

    invoke-virtual {v12}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v14, v1, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 837
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mEPFeaturedEventType:Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;

    sget-object v4, Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;->VOD:Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;

    if-ne v1, v4, :cond_2

    .line 838
    const/4 v9, 0x1

    .line 839
    const/4 v1, 0x1

    const-string v4, "VOD"

    aput-object v4, v15, v1

    .line 840
    invoke-virtual {v12}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getVodLink()Ljava/lang/String;

    move-result-object v2

    .line 841
    .local v2, "urlExt":Ljava/lang/String;
    const-string v1, "featuredTopSportEventType"

    sget-object v4, Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;->VOD:Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 842
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    .line 843
    const-string v1, "eventsType"

    const-string v4, "VOD"

    invoke-virtual {v14, v1, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 861
    :goto_0
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    move-object/from16 v18, v0

    monitor-enter v18
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 863
    :try_start_1
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v4, "metaEvents"

    move-object/from16 v0, v17

    invoke-virtual {v1, v4, v0, v15}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getMeta(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v13

    .line 864
    invoke-interface {v13}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_4

    invoke-interface {v13}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 865
    const-string v1, "ttl"

    invoke-interface {v13, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v13, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/espn/androidplayersdk/utilities/Utils;->isExpired(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 866
    const-string v1, "eventWhere"

    move-object/from16 v0, v16

    invoke-virtual {v3, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 867
    const-string v1, "eventWhereArg"

    invoke-virtual {v3, v1, v15}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 868
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v4, "metaEvents"

    move-object/from16 v0, v17

    invoke-virtual {v1, v4, v0, v15, v14}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 869
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    const/4 v5, 0x0

    aget-object v5, v10, v5

    const/4 v6, 0x1

    aget-object v6, v10, v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    invoke-virtual/range {v1 .. v9}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsForTopSport(Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 861
    :cond_0
    :goto_1
    :try_start_2
    monitor-exit v18
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 882
    if-eqz v13, :cond_1

    .line 883
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    .line 885
    :cond_1
    :goto_2
    return-void

    .line 844
    .end local v2    # "urlExt":Ljava/lang/String;
    :cond_2
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mEPEventType:Lcom/espn/androidplayersdk/utilities/EPEventType;

    if-nez v1, :cond_3

    .line 845
    const/4 v1, 0x1

    const-string v4, "top"

    aput-object v4, v15, v1

    .line 846
    invoke-virtual {v12}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getTopListingLink()Ljava/lang/String;

    move-result-object v2

    .line 847
    .restart local v2    # "urlExt":Ljava/lang/String;
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    .line 848
    const-string v1, "featuredTopSportEventType"

    sget-object v4, Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;->LINEAR:Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 849
    const-string v1, "eventType"

    const-string v4, "top"

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 850
    const-string v1, "eventsType"

    const-string v4, "top"

    invoke-virtual {v14, v1, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 852
    .end local v2    # "urlExt":Ljava/lang/String;
    :cond_3
    const/4 v1, 0x1

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mEPEventType:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v15, v1

    .line 853
    invoke-virtual {v12}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getListingLink()Ljava/lang/String;

    move-result-object v2

    .line 854
    .restart local v2    # "urlExt":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mEPEventType:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    .line 855
    const-string v1, "featuredTopSportEventType"

    sget-object v4, Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;->LINEAR:Lcom/espn/androidplayersdk/utilities/EPFeaturedEventType;

    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 856
    const/16 v1, 0xa

    move-object/from16 v0, p0

    invoke-virtual {v0, v1, v10}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->setDateRange(I[Ljava/lang/String;)V

    .line 857
    const-string v1, "eventsType"

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mEPEventType:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v14, v1, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 872
    :cond_4
    :try_start_3
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v4, "metaEvents"

    move-object/from16 v0, v17

    invoke-virtual {v1, v4, v0, v15, v14}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 873
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    const/4 v5, 0x0

    aget-object v5, v10, v5

    const/4 v6, 0x1

    aget-object v6, v10, v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    invoke-virtual/range {v1 .. v9}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventsForTopSport(Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_1

    .line 875
    :catch_0
    move-exception v11

    .line 876
    .local v11, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v1, "Error: "

    const/4 v4, 0x5

    invoke-static {v1, v4, v11}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto/16 :goto_1

    .line 861
    .end local v11    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    monitor-exit v18
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v1
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 879
    :catch_1
    move-exception v11

    .line 880
    .restart local v11    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v1, "Error: "

    const/4 v4, 0x5

    invoke-static {v1, v4, v11}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 882
    if-eqz v13, :cond_1

    .line 883
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    goto/16 :goto_2

    .line 881
    .end local v11    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v1

    .line 882
    if-eqz v13, :cond_5

    .line 883
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    .line 884
    :cond_5
    throw v1
.end method


# virtual methods
.method getFeaturedEvents(ILjava/util/HashMap;)V
    .locals 2
    .param p1, "subKey"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 229
    .local p2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    packed-switch p1, :pswitch_data_0

    .line 256
    :cond_0
    :goto_0
    return-void

    .line 231
    :pswitch_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v0, p2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getFeturedEventsFeed(Ljava/util/HashMap;)V

    goto :goto_0

    .line 235
    :pswitch_1
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKeyMeta:Ljava/lang/String;

    invoke-virtual {v0, p1, v1, p2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getFeturedEventsForE3Feed(ILjava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 238
    :pswitch_2
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

    if-eqz v0, :cond_0

    .line 239
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

    invoke-virtual {v0, v1, p2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getFeturedEventsForCatagoryFeed(Lcom/espn/androidplayersdk/datamanager/EPSport;Ljava/util/HashMap;)V

    goto :goto_0

    .line 242
    :pswitch_3
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v0, p2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getMustSeeFeturedEvents(Ljava/util/HashMap;)V

    goto :goto_0

    .line 245
    :pswitch_4
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v0, p2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getBestOfFeturedEvents(Ljava/util/HashMap;)V

    goto :goto_0

    .line 248
    :pswitch_5
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v0, p2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getTopVODFeturedEvents(Ljava/util/HashMap;)V

    goto :goto_0

    .line 251
    :pswitch_6
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v0, p2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getTrendingFeturedEvents(Ljava/util/HashMap;)V

    goto :goto_0

    .line 229
    :pswitch_data_0
    .packed-switch 0xb
        :pswitch_0
        :pswitch_1
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_2
        :pswitch_6
        :pswitch_1
    .end packed-switch
.end method

.method protected refreshLiveEvents()V
    .locals 10

    .prologue
    .line 263
    const/4 v2, 0x0

    .line 264
    .local v2, "metaCursor":Landroid/database/Cursor;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 265
    .local v1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v4, "metaEventRelationId = ?"

    .line 266
    .local v4, "whereEvent":Ljava/lang/String;
    const-string v5, "eventRelationId = ?"

    .line 267
    .local v5, "whereMeta":Ljava/lang/String;
    const/4 v6, 0x1

    new-array v3, v6, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string v7, "1"

    aput-object v7, v3, v6

    .line 269
    .local v3, "whereArg":[Ljava/lang/String;
    :try_start_0
    iget-object v7, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    monitor-enter v7
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 271
    :try_start_1
    sget-object v6, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v8, "metaEvents"

    invoke-virtual {v6, v8, v5, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getMeta(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 272
    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v6

    if-lez v6, :cond_2

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 273
    const-string v6, "ttl"

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/espn/androidplayersdk/utilities/Utils;->isExpired(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 274
    const-string v6, "eventWhere"

    invoke-virtual {v1, v6, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 275
    const-string v6, "eventWhereArg"

    invoke-virtual {v1, v6, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 276
    sget-object v6, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v8, "metaEvents"

    const/4 v9, 0x0

    invoke-virtual {v6, v8, v5, v3, v9}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 277
    iget-object v6, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v6, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getLiveEventsFeed(Ljava/util/HashMap;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 269
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v7
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 290
    if-eqz v2, :cond_1

    .line 291
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 293
    :cond_1
    :goto_1
    return-void

    .line 280
    :cond_2
    :try_start_3
    sget-object v6, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v8, "metaEvents"

    const/4 v9, 0x0

    invoke-virtual {v6, v8, v5, v3, v9}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 281
    iget-object v6, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->feeds:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-virtual {v6, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getLiveEventsFeed(Ljava/util/HashMap;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 283
    :catch_0
    move-exception v0

    .line 284
    .local v0, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v6, "Error: "

    const/4 v8, 0x5

    invoke-static {v6, v8, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 269
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v6

    monitor-exit v7
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v6
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 287
    :catch_1
    move-exception v0

    .line 288
    .restart local v0    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v6, "Error: "

    const/4 v7, 0x5

    invoke-static {v6, v7, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 290
    if-eqz v2, :cond_1

    .line 291
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 289
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v6

    .line 290
    if-eqz v2, :cond_3

    .line 291
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 292
    :cond_3
    throw v6
.end method

.method protected refreshfeaturedEvents(I)V
    .locals 10
    .param p1, "subKey"    # I

    .prologue
    const/4 v9, 0x1

    .line 183
    const/4 v2, 0x0

    .line 184
    .local v2, "metaCursor":Landroid/database/Cursor;
    const/4 v3, 0x0

    .line 185
    .local v3, "values":Landroid/content/ContentValues;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 187
    .local v1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v5, "metaEventRelationId = ?"

    .line 188
    .local v5, "whereEvent":Ljava/lang/String;
    const-string v6, "eventRelationId = ?"

    .line 189
    .local v6, "whereMeta":Ljava/lang/String;
    iget-object v7, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

    if-eqz v7, :cond_2

    .line 190
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v8, " and sportId = ?"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 191
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v8, " and sportId = ?"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 192
    const/4 v7, 0x2

    new-array v4, v7, [Ljava/lang/String;

    .line 193
    .local v4, "whereArg":[Ljava/lang/String;
    iget-object v7, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

    invoke-virtual {v7}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getId()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v9

    .line 194
    new-instance v3, Landroid/content/ContentValues;

    .end local v3    # "values":Landroid/content/ContentValues;
    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 195
    .restart local v3    # "values":Landroid/content/ContentValues;
    const-string v7, "sportId"

    iget-object v8, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->epSport:Lcom/espn/androidplayersdk/datamanager/EPSport;

    invoke-virtual {v8}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 199
    :goto_0
    const/4 v7, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v4, v7

    .line 201
    :try_start_0
    iget-object v8, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->mLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    monitor-enter v8
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 203
    :try_start_1
    sget-object v7, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v9, "metaEvents"

    invoke-virtual {v7, v9, v6, v4}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getMeta(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 204
    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v7

    if-lez v7, :cond_3

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v7

    if-eqz v7, :cond_3

    .line 205
    const-string v7, "ttl"

    invoke-interface {v2, v7}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    invoke-interface {v2, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/espn/androidplayersdk/utilities/Utils;->isExpired(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 206
    const-string v7, "eventWhere"

    invoke-virtual {v1, v7, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 207
    const-string v7, "eventWhereArg"

    invoke-virtual {v1, v7, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 208
    sget-object v7, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v9, "metaEvents"

    invoke-virtual {v7, v9, v6, v4, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 209
    invoke-virtual {p0, p1, v1}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->getFeaturedEvents(ILjava/util/HashMap;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 201
    :cond_0
    :goto_1
    :try_start_2
    monitor-exit v8
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 222
    if-eqz v2, :cond_1

    .line 223
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 225
    :cond_1
    :goto_2
    return-void

    .line 197
    .end local v4    # "whereArg":[Ljava/lang/String;
    :cond_2
    new-array v4, v9, [Ljava/lang/String;

    .restart local v4    # "whereArg":[Ljava/lang/String;
    goto :goto_0

    .line 212
    :cond_3
    :try_start_3
    sget-object v7, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v9, "metaEvents"

    invoke-virtual {v7, v9, v6, v4, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 213
    invoke-virtual {p0, p1, v1}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->getFeaturedEvents(ILjava/util/HashMap;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 215
    :catch_0
    move-exception v0

    .line 216
    .local v0, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v7, "Error: "

    const/4 v9, 0x5

    invoke-static {v7, v9, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1

    .line 201
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v7

    monitor-exit v8
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v7
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 219
    :catch_1
    move-exception v0

    .line 220
    .restart local v0    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v7, "Error: "

    const/4 v8, 0x5

    invoke-static {v7, v8, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 222
    if-eqz v2, :cond_1

    .line 223
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_2

    .line 221
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v7

    .line 222
    if-eqz v2, :cond_4

    .line 223
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 224
    :cond_4
    throw v7
.end method

.method public run()V
    .locals 6

    .prologue
    .line 123
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 124
    iget v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->key:I

    packed-switch v0, :pswitch_data_0

    .line 176
    :goto_0
    :pswitch_0
    return-void

    .line 126
    :pswitch_1
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->refreshChannelsFeed()V

    goto :goto_0

    .line 129
    :pswitch_2
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->refreshConfigFeed()V

    goto :goto_0

    .line 132
    :pswitch_3
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkCode:Ljava/lang/String;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkId:Ljava/lang/String;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    iget-object v5, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->refreshEventsByChannelsFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 135
    :pswitch_4
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkCode:Ljava/lang/String;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkId:Ljava/lang/String;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->loadEventsForChannel(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 138
    :pswitch_5
    iget v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKey:I

    invoke-direct {p0, v0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->refreshSportsFeed(I)V

    goto :goto_0

    .line 141
    :pswitch_6
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sport:Ljava/lang/String;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sportsid:Ljava/lang/String;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    iget-object v5, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start:Ljava/lang/String;

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->refreshEventsBySportFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 144
    :pswitch_7
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sportsid:Ljava/lang/String;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->loadEventsForSport(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 147
    :pswitch_8
    iget v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->subKey:I

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->refreshfeaturedEvents(I)V

    goto :goto_0

    .line 150
    :pswitch_9
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->refreshLiveEvents()V

    goto :goto_0

    .line 153
    :pswitch_a
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sportsid:Ljava/lang/String;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->abbre:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->refreshSportEventsByLeague(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 156
    :pswitch_b
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkId:Ljava/lang/String;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkCode:Ljava/lang/String;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->refreshChannelEventsByLeague(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 159
    :pswitch_c
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkCode:Ljava/lang/String;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->networkId:Ljava/lang/String;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->loadEventsForChannelByLeague(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 162
    :pswitch_d
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->sportsid:Ljava/lang/String;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->abbre:Ljava/lang/String;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->limit:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->loadEventsForSportByLeague(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 165
    :pswitch_e
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->refreshFeaturedCategory()V

    goto :goto_0

    .line 168
    :pswitch_f
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->refreshFeaturedCategoryEvents()V

    goto/16 :goto_0

    .line 171
    :pswitch_10
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->refreshTopSportEvents()V

    goto/16 :goto_0

    .line 124
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_a
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_0
        :pswitch_9
        :pswitch_8
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_e
        :pswitch_f
        :pswitch_10
    .end packed-switch
.end method

.method varargs setDateRange(I[Ljava/lang/String;)V
    .locals 10
    .param p1, "range"    # I
    .param p2, "dates"    # [Ljava/lang/String;

    .prologue
    const/4 v9, 0x5

    .line 892
    const/16 p1, 0x16d

    .line 893
    :try_start_0
    new-instance v0, Ljava/util/GregorianCalendar;

    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v5

    sget-object v6, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v5, v6}, Ljava/util/GregorianCalendar;-><init>(Ljava/util/TimeZone;Ljava/util/Locale;)V

    .line 894
    .local v0, "calander":Ljava/util/GregorianCalendar;
    new-instance v2, Ljava/text/SimpleDateFormat;

    const-string v5, "yyyy-MM-dd"

    sget-object v6, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v2, v5, v6}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 895
    .local v2, "format":Ljava/text/SimpleDateFormat;
    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    .line 897
    .local v4, "today":Ljava/util/Date;
    iget-object v5, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    sget-object v6, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v6}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 898
    const/4 v5, 0x5

    invoke-virtual {v0, v5, p1}, Ljava/util/GregorianCalendar;->add(II)V

    .line 899
    invoke-virtual {v0}, Ljava/util/GregorianCalendar;->getTime()Ljava/util/Date;

    move-result-object v3

    .line 906
    .local v3, "maxDate":Ljava/util/Date;
    :goto_0
    const/4 v5, 0x0

    invoke-virtual {v2, v4}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "-"

    const-string v8, ""

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, p2, v5

    .line 907
    const/4 v5, 0x1

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "-"

    const-string v8, ""

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, p2, v5

    .line 911
    .end local v0    # "calander":Ljava/util/GregorianCalendar;
    .end local v2    # "format":Ljava/text/SimpleDateFormat;
    .end local v3    # "maxDate":Ljava/util/Date;
    .end local v4    # "today":Ljava/util/Date;
    :goto_1
    return-void

    .line 900
    .restart local v0    # "calander":Ljava/util/GregorianCalendar;
    .restart local v2    # "format":Ljava/text/SimpleDateFormat;
    .restart local v4    # "today":Ljava/util/Date;
    :cond_0
    iget-object v5, p0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->type:Ljava/lang/String;

    sget-object v6, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v6}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 901
    const/4 v5, 0x5

    neg-int v6, p1

    invoke-virtual {v0, v5, v6}, Ljava/util/GregorianCalendar;->add(II)V

    .line 902
    move-object v3, v4

    .line 903
    .restart local v3    # "maxDate":Ljava/util/Date;
    invoke-virtual {v0}, Ljava/util/GregorianCalendar;->getTime()Ljava/util/Date;

    move-result-object v4

    .line 904
    goto :goto_0

    .line 905
    .end local v3    # "maxDate":Ljava/util/Date;
    :cond_1
    invoke-virtual {v0}, Ljava/util/GregorianCalendar;->getTime()Ljava/util/Date;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .restart local v3    # "maxDate":Ljava/util/Date;
    goto :goto_0

    .line 908
    .end local v0    # "calander":Ljava/util/GregorianCalendar;
    .end local v2    # "format":Ljava/text/SimpleDateFormat;
    .end local v3    # "maxDate":Ljava/util/Date;
    .end local v4    # "today":Ljava/util/Date;
    :catch_0
    move-exception v1

    .line 909
    .local v1, "e":Ljava/lang/Exception;
    const-string v5, "Error: "

    invoke-static {v5, v9, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1
.end method
