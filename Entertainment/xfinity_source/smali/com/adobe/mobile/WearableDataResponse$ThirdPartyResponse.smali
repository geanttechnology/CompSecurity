.class Lcom/adobe/mobile/WearableDataResponse$ThirdPartyResponse;
.super Lcom/adobe/mobile/WearableDataResponse;
.source "WearableDataResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mobile/WearableDataResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ThirdPartyResponse"
.end annotation


# direct methods
.method protected constructor <init>(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 1
    .param p1, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataResponse;-><init>()V

    .line 63
    const-string v0, "Result"

    invoke-virtual {p1, v0}, Lcom/google/android/gms/wearable/DataMap;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/adobe/mobile/WearableDataResponse$ThirdPartyResponse;->success:Z

    .line 64
    return-void
.end method
