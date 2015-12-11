.class Lcom/adobe/mobile/WearableDataRequest$ShareConfig;
.super Lcom/adobe/mobile/WearableDataRequest;
.source "SourceFile"


# direct methods
.method protected constructor <init>(I)V
    .locals 0

    .prologue
    .line 238
    invoke-direct {p0, p1}, Lcom/adobe/mobile/WearableDataRequest;-><init>(I)V

    .line 239
    return-void
.end method

.method protected constructor <init>(Latz;)V
    .locals 1

    .prologue
    .line 241
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataRequest;-><init>()V

    .line 242
    const-string v0, "ID"

    invoke-virtual {p1, v0}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$ShareConfig;->uuid:Ljava/lang/String;

    .line 243
    return-void
.end method


# virtual methods
.method protected getDataMap()Latz;
    .locals 3

    .prologue
    .line 246
    new-instance v0, Latz;

    invoke-direct {v0}, Latz;-><init>()V

    .line 247
    const-string v1, "Type"

    const-string v2, "Config"

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 248
    const-string v1, "ID"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$ShareConfig;->uuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 249
    return-object v0
.end method

.method protected handle(Landroid/content/Context;)Latz;
    .locals 3

    .prologue
    .line 253
    new-instance v0, Latz;

    invoke-direct {v0}, Latz;-><init>()V

    .line 254
    const-string v1, "ID"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$ShareConfig;->uuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 255
    const-string v1, "Type"

    const-string v2, "Config"

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    invoke-static {}, Lcom/adobe/mobile/ConfigSynchronizer;->getSharedConfig()Latz;

    move-result-object v1

    invoke-virtual {v0, v1}, Latz;->a(Latz;)V

    .line 257
    return-object v0
.end method
