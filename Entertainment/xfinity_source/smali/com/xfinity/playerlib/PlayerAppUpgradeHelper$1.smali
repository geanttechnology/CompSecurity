.class Lcom/xfinity/playerlib/PlayerAppUpgradeHelper$1;
.super Ljava/lang/Object;
.source "PlayerAppUpgradeHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->onUserLoadedOrSignedIn()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper$1;->this$0:Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 92
    iget-object v1, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper$1;->this$0:Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;

    # getter for: Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->playNowApplication:Lcom/xfinity/playerlib/PlayerApplication;
    invoke-static {v1}, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->access$000(Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;)Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/PlayerApplication;->getFilesDir()Ljava/io/File;

    .line 93
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper$1;->this$0:Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;

    # getter for: Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->playNowApplication:Lcom/xfinity/playerlib/PlayerApplication;
    invoke-static {v2}, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->access$000(Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;)Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/PlayerApplication;->getFilesDir()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "analyticsqueue"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 94
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 95
    return-void
.end method
