.class Lcom/adobe/mobile/WearableDataRequest$ShareConfig;
.super Lcom/adobe/mobile/WearableDataRequest;
.source "WearableDataRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mobile/WearableDataRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ShareConfig"
.end annotation


# direct methods
.method protected constructor <init>(I)V
    .locals 0
    .param p1, "timeOut"    # I

    .prologue
    .line 238
    invoke-direct {p0, p1}, Lcom/adobe/mobile/WearableDataRequest;-><init>(I)V

    .line 239
    return-void
.end method

.method protected constructor <init>(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 1
    .param p1, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 241
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataRequest;-><init>()V

    .line 242
    const-string v0, "ID"

    invoke-virtual {p1, v0}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$ShareConfig;->uuid:Ljava/lang/String;

    .line 243
    return-void
.end method


# virtual methods
.method protected getDataMap()Lcom/google/android/gms/wearable/DataMap;
    .locals 3

    .prologue
    .line 246
    new-instance v0, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v0}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 247
    .local v0, "dataMap":Lcom/google/android/gms/wearable/DataMap;
    const-string v1, "Type"

    const-string v2, "Config"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 248
    const-string v1, "ID"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$ShareConfig;->uuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 249
    return-object v0
.end method

.method protected handle(Landroid/content/Context;)Lcom/google/android/gms/wearable/DataMap;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 253
    new-instance v0, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v0}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 254
    .local v0, "responseDataMap":Lcom/google/android/gms/wearable/DataMap;
    const-string v1, "ID"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$ShareConfig;->uuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 255
    const-string v1, "Type"

    const-string v2, "Config"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    invoke-static {}, Lcom/adobe/mobile/ConfigSynchronizer;->getSharedConfig()Lcom/google/android/gms/wearable/DataMap;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/wearable/DataMap;->putAll(Lcom/google/android/gms/wearable/DataMap;)V

    .line 257
    return-object v0
.end method
