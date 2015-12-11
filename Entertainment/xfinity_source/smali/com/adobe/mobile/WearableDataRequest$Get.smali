.class Lcom/adobe/mobile/WearableDataRequest$Get;
.super Lcom/adobe/mobile/WearableDataRequest;
.source "WearableDataRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mobile/WearableDataRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Get"
.end annotation


# static fields
.field protected static final logPrefix:Ljava/lang/String; = "Wearable GET Requested Forward"


# instance fields
.field protected url:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 1
    .param p1, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataRequest;-><init>()V

    .line 76
    const-string v0, "URL"

    invoke-virtual {p1, v0}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->url:Ljava/lang/String;

    .line 77
    const-string v0, "ID"

    invoke-virtual {p1, v0}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->uuid:Ljava/lang/String;

    .line 78
    const-string v0, "Timeout"

    invoke-virtual {p1, v0}, Lcom/google/android/gms/wearable/DataMap;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->timeOut:I

    .line 79
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "timeOut"    # I

    .prologue
    .line 71
    invoke-direct {p0, p2}, Lcom/adobe/mobile/WearableDataRequest;-><init>(I)V

    .line 72
    iput-object p1, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->url:Ljava/lang/String;

    .line 73
    return-void
.end method


# virtual methods
.method protected getDataMap()Lcom/google/android/gms/wearable/DataMap;
    .locals 3

    .prologue
    .line 82
    new-instance v0, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v0}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 83
    .local v0, "dataMap":Lcom/google/android/gms/wearable/DataMap;
    const-string v1, "ID"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->uuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    const-string v1, "Timeout"

    iget v2, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->timeOut:I

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putInt(Ljava/lang/String;I)V

    .line 85
    const-string v1, "Type"

    const-string v2, "GET"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    const-string v1, "URL"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->url:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

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

.method protected handle(Landroid/content/Context;)Lcom/google/android/gms/wearable/DataMap;
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 91
    new-instance v1, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v1}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 92
    .local v1, "responseDataMap":Lcom/google/android/gms/wearable/DataMap;
    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->url:Ljava/lang/String;

    const/4 v3, 0x0

    iget v4, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->timeOut:I

    const-string v5, "Wearable GET Requested Forward"

    invoke-static {v2, v3, v4, v5}, Lcom/adobe/mobile/RequestHandler;->retrieveData(Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)[B

    move-result-object v0

    .line 93
    .local v0, "byteArray":[B
    const-string v2, "Result"

    invoke-virtual {v1, v2, v0}, Lcom/google/android/gms/wearable/DataMap;->putByteArray(Ljava/lang/String;[B)V

    .line 94
    const-string v2, "ID"

    iget-object v3, p0, Lcom/adobe/mobile/WearableDataRequest$Get;->uuid:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    const-string v2, "Type"

    const-string v3, "GET"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    return-object v1
.end method
