.class Lcom/adobe/mobile/WearableDataRequest$Get;
.super Lcom/adobe/mobile/WearableDataRequest;
.source "SourceFile"


# static fields
.field protected static final logPrefix:Ljava/lang/String; = "Wearable GET Requested Forward"


# instance fields
.field protected url:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Latz;)V
    .locals 1

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataRequest;-><init>()V

    .line 76
    const-string v0, "URL"

    invoke-virtual {p1, v0}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->url:Ljava/lang/String;

    .line 77
    const-string v0, "ID"

    invoke-virtual {p1, v0}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->uuid:Ljava/lang/String;

    .line 78
    const-string v0, "Timeout"

    invoke-virtual {p1, v0}, Latz;->d(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->timeOut:I

    .line 79
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 71
    invoke-direct {p0, p2}, Lcom/adobe/mobile/WearableDataRequest;-><init>(I)V

    .line 72
    iput-object p1, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->url:Ljava/lang/String;

    .line 73
    return-void
.end method


# virtual methods
.method protected getDataMap()Latz;
    .locals 3

    .prologue
    .line 82
    new-instance v0, Latz;

    invoke-direct {v0}, Latz;-><init>()V

    .line 83
    const-string v1, "ID"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->uuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    const-string v1, "Timeout"

    iget v2, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->timeOut:I

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;I)V

    .line 85
    const-string v1, "Type"

    const-string v2, "GET"

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    const-string v1, "URL"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->url:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    return-object v0
.end method

.method protected getURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->url:Ljava/lang/String;

    return-object v0
.end method

.method protected handle(Landroid/content/Context;)Latz;
    .locals 5

    .prologue
    .line 91
    new-instance v0, Latz;

    invoke-direct {v0}, Latz;-><init>()V

    .line 92
    iget-object v1, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->url:Ljava/lang/String;

    const/4 v2, 0x0

    iget v3, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->timeOut:I

    const-string v4, "Wearable GET Requested Forward"

    invoke-static {v1, v2, v3, v4}, Lcom/adobe/mobile/RequestHandler;->retrieveData(Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)[B

    move-result-object v1

    .line 93
    const-string v2, "Result"

    invoke-virtual {v0, v2, v1}, Latz;->a(Ljava/lang/String;[B)V

    .line 94
    const-string v1, "ID"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->uuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    const-string v1, "Type"

    const-string v2, "GET"

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    return-object v0
.end method
