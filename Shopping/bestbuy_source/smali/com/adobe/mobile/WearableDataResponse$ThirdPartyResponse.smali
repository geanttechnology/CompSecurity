.class Lcom/adobe/mobile/WearableDataResponse$ThirdPartyResponse;
.super Lcom/adobe/mobile/WearableDataResponse;
.source "SourceFile"


# direct methods
.method protected constructor <init>(Latz;)V
    .locals 1

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataResponse;-><init>()V

    .line 63
    const-string v0, "Result"

    invoke-virtual {p1, v0}, Latz;->c(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/adobe/mobile/WearableDataResponse$ThirdPartyResponse;->success:Z

    .line 64
    return-void
.end method
