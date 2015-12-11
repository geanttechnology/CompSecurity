.class Lcom/aio/downloader/activity/ExclusiveAppsActivity$5;
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
    iput-object p1, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$5;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    .line 415
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 420
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$5;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->finish()V

    .line 421
    return-void
.end method
