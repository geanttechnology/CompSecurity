.class Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$5;
.super Ljava/lang/Object;
.source "ShowCleanActivity_Rub.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$5;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    .line 200
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 205
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$5;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/aio/downloader/activity/DownloadAppManager;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 206
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$5;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->startActivity(Landroid/content/Intent;)V

    .line 207
    const/4 v1, 0x0

    sput-boolean v1, Lcom/aio/downloader/utils/publicTools;->cleanertag:Z

    .line 208
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$5;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->finish()V

    .line 209
    return-void
.end method
