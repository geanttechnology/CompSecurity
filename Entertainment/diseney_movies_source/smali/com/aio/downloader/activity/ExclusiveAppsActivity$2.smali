.class Lcom/aio/downloader/activity/ExclusiveAppsActivity$2;
.super Ljava/lang/Object;
.source "ExclusiveAppsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/ExclusiveAppsActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$2;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    .line 126
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 131
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$2;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$2;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 132
    const-class v3, Lcom/aio/downloader/activity/DownloadAppManager;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 131
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->startActivity(Landroid/content/Intent;)V

    .line 133
    return-void
.end method
