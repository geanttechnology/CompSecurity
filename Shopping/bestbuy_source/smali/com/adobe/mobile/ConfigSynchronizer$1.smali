.class final Lcom/adobe/mobile/ConfigSynchronizer$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/ConfigSynchronizer;->restoreAdid(Latz;)V
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic val$dataMap:Latz;


# direct methods
.method constructor <init>(Latz;)V
    .locals 0

    .prologue
    .line 203
    iput-object p1, p0, Lcom/adobe/mobile/ConfigSynchronizer$1;->val$dataMap:Latz;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 203
    invoke-virtual {p0}, Lcom/adobe/mobile/ConfigSynchronizer$1;->call()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public call()Ljava/lang/String;
    .locals 2

    .prologue
    .line 206
    iget-object v0, p0, Lcom/adobe/mobile/ConfigSynchronizer$1;->val$dataMap:Latz;

    const-string v1, "ADOBEMOBILE_STOREDDEFAULTS_ADVERTISING_IDENTIFIER"

    invoke-virtual {v0, v1}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
