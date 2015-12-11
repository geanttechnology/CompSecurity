.class Lcom/amazon/dcp/settings/BackgroundSynchronizer$2;
.super Ljava/lang/Object;
.source "BackgroundSynchronizer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/dcp/settings/BackgroundSynchronizer;->startSync()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/dcp/settings/BackgroundSynchronizer;


# direct methods
.method constructor <init>(Lcom/amazon/dcp/settings/BackgroundSynchronizer;)V
    .locals 0

    .prologue
    .line 104
    iput-object p1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer$2;->this$0:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 110
    :try_start_0
    iget-object v1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer$2;->this$0:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    # getter for: Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSettingsCacheUpdater:Lcom/amazon/dcp/settings/SettingsCacheUpdater;
    invoke-static {v1}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->access$100(Lcom/amazon/dcp/settings/BackgroundSynchronizer;)Lcom/amazon/dcp/settings/SettingsCacheUpdater;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer$2;->this$0:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    # getter for: Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->access$000(Lcom/amazon/dcp/settings/BackgroundSynchronizer;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/dcp/settings/SettingsCacheUpdater;->updateFromContentProvider(Landroid/content/Context;)V

    .line 111
    iget-object v1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer$2;->this$0:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    const/4 v2, 0x0

    const/4 v3, 0x0

    # invokes: Lcom/amazon/dcp/settings/BackgroundSynchronizer;->setSyncInProgress(ZLjava/lang/Throwable;)V
    invoke-static {v1, v2, v3}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->access$200(Lcom/amazon/dcp/settings/BackgroundSynchronizer;ZLjava/lang/Throwable;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 117
    :goto_0
    return-void

    .line 113
    :catch_0
    move-exception v0

    .line 115
    .local v0, "e":Ljava/lang/Throwable;
    iget-object v1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer$2;->this$0:Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    # invokes: Lcom/amazon/dcp/settings/BackgroundSynchronizer;->setSyncInProgress(ZLjava/lang/Throwable;)V
    invoke-static {v1, v4, v0}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->access$200(Lcom/amazon/dcp/settings/BackgroundSynchronizer;ZLjava/lang/Throwable;)V

    goto :goto_0
.end method
