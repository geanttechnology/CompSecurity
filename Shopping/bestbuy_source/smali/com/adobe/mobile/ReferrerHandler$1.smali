.class final Lcom/adobe/mobile/ReferrerHandler$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/ReferrerHandler;->handleV1Acquisition(Ljava/util/HashMap;)V
.end annotation


# instance fields
.field final synthetic val$referrerLifecycleContextData:Ljava/util/HashMap;


# direct methods
.method constructor <init>(Ljava/util/HashMap;)V
    .locals 0

    .prologue
    .line 137
    iput-object p1, p0, Lcom/adobe/mobile/ReferrerHandler$1;->val$referrerLifecycleContextData:Ljava/util/HashMap;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/adobe/mobile/ReferrerHandler$1;->val$referrerLifecycleContextData:Ljava/util/HashMap;

    invoke-static {v0}, Lcom/adobe/mobile/Lifecycle;->updateContextData(Ljava/util/HashMap;)V

    .line 140
    return-void
.end method
