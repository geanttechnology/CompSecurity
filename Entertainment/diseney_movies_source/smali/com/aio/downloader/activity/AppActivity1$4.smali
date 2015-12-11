.class Lcom/aio/downloader/activity/AppActivity1$4;
.super Ljava/lang/Object;
.source "AppActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppActivity1;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppActivity1$4;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    .line 275
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 280
    iget-object v0, p0, Lcom/aio/downloader/activity/AppActivity1$4;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/activity/AppActivity1$4;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    .line 281
    const-class v3, Lcom/aio/downloader/activity/DownloadAppManager;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 280
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/AppActivity1;->startActivity(Landroid/content/Intent;)V

    .line 282
    return-void
.end method
