.class Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$11;
.super Ljava/lang/Object;
.source "ShowCleanActivity_Rub.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->Mydialog()V
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
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$11;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    .line 519
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "arg0"    # Landroid/content/DialogInterface;
    .param p2, "arg1"    # I

    .prologue
    .line 523
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 524
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$11;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 525
    const-class v2, Lcom/aio/downloader/activity/DownloadAppManager;

    .line 524
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 526
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$11;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->startActivity(Landroid/content/Intent;)V

    .line 527
    const/4 v1, 0x0

    sput-boolean v1, Lcom/aio/downloader/utils/publicTools;->cleanertag:Z

    .line 528
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$11;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->finish()V

    .line 529
    return-void
.end method
