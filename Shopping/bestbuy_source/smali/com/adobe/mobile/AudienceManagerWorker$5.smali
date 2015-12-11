.class final Lcom/adobe/mobile/AudienceManagerWorker$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/AudienceManagerWorker;->Reset()V
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 235
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 238
    # invokes: Lcom/adobe/mobile/AudienceManagerWorker;->SetUUID(Ljava/lang/String;)V
    invoke-static {v0}, Lcom/adobe/mobile/AudienceManagerWorker;->access$600(Ljava/lang/String;)V

    .line 239
    # invokes: Lcom/adobe/mobile/AudienceManagerWorker;->SetVisitorProfile(Ljava/util/Map;)V
    invoke-static {v0}, Lcom/adobe/mobile/AudienceManagerWorker;->access$800(Ljava/util/Map;)V

    .line 240
    return-void
.end method
