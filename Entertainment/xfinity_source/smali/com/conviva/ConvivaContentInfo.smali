.class public Lcom/conviva/ConvivaContentInfo;
.super Ljava/lang/Object;


# instance fields
.field public assetName:Ljava/lang/String;

.field public defaultReportingBitrateKbps:I

.field public defaultReportingCdnName:Ljava/lang/String;

.field public defaultReportingResource:Ljava/lang/String;

.field public deviceId:Ljava/lang/String;

.field public deviceType:Ljava/lang/String;

.field public frameworkName:Ljava/lang/String;

.field public frameworkVersion:Ljava/lang/String;

.field public isLive:Ljava/lang/Boolean;

.field public playerName:Ljava/lang/String;

.field public pluginName:Ljava/lang/String;

.field public pluginVersion:Ljava/lang/String;

.field public streamUrl:Ljava/lang/String;

.field public tags:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public viewerId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object v1, p0, Lcom/conviva/ConvivaContentInfo;->assetName:Ljava/lang/String;

    const/4 v0, -0x1

    iput v0, p0, Lcom/conviva/ConvivaContentInfo;->defaultReportingBitrateKbps:I

    const-string v0, "OTHER"

    iput-object v0, p0, Lcom/conviva/ConvivaContentInfo;->defaultReportingCdnName:Ljava/lang/String;

    iput-object v1, p0, Lcom/conviva/ConvivaContentInfo;->defaultReportingResource:Ljava/lang/String;

    iput-object v1, p0, Lcom/conviva/ConvivaContentInfo;->frameworkName:Ljava/lang/String;

    iput-object v1, p0, Lcom/conviva/ConvivaContentInfo;->frameworkVersion:Ljava/lang/String;

    iput-object v1, p0, Lcom/conviva/ConvivaContentInfo;->pluginName:Ljava/lang/String;

    iput-object v1, p0, Lcom/conviva/ConvivaContentInfo;->pluginVersion:Ljava/lang/String;

    iput-object v1, p0, Lcom/conviva/ConvivaContentInfo;->viewerId:Ljava/lang/String;

    iput-object v1, p0, Lcom/conviva/ConvivaContentInfo;->deviceId:Ljava/lang/String;

    iput-object v1, p0, Lcom/conviva/ConvivaContentInfo;->deviceType:Ljava/lang/String;

    iput-object v1, p0, Lcom/conviva/ConvivaContentInfo;->playerName:Ljava/lang/String;

    iput-object v1, p0, Lcom/conviva/ConvivaContentInfo;->streamUrl:Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/ConvivaContentInfo;->isLive:Ljava/lang/Boolean;

    iput-object p1, p0, Lcom/conviva/ConvivaContentInfo;->assetName:Ljava/lang/String;

    iput-object p2, p0, Lcom/conviva/ConvivaContentInfo;->tags:Ljava/util/Map;

    if-nez p2, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    :cond_0
    return-void
.end method
