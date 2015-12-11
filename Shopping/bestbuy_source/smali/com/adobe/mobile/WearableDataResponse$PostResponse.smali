.class Lcom/adobe/mobile/WearableDataResponse$PostResponse;
.super Lcom/adobe/mobile/WearableDataResponse;
.source "SourceFile"


# direct methods
.method protected constructor <init>(Latz;)V
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataResponse;-><init>()V

    .line 57
    const-string v0, "Result"

    invoke-virtual {p1, v0}, Latz;->c(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/adobe/mobile/WearableDataResponse$PostResponse;->success:Z

    .line 58
    return-void
.end method
