.class Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;
.super Lcom/adobe/mobile/WearableDataResponse;
.source "SourceFile"


# instance fields
.field final result:Latz;


# direct methods
.method protected constructor <init>(Latz;)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataResponse;-><init>()V

    .line 70
    iput-object p1, p0, Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;->result:Latz;

    .line 71
    return-void
.end method


# virtual methods
.method protected getResult()Latz;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;->result:Latz;

    return-object v0
.end method
