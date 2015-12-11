.class Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$10;
.super Ljava/lang/Object;
.source "ShowCleanActivity_Rub.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->downwifi()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;Lcom/aio/downloader/dialog/LianwangDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$10;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    iput-object p2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$10;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    .line 500
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 504
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$10;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    new-instance v1, Landroid/content/Intent;

    .line 505
    const-string v2, "android.settings.WIRELESS_SETTINGS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 504
    invoke-virtual {v0, v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->startActivity(Landroid/content/Intent;)V

    .line 506
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$10;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->dismiss()V

    .line 508
    return-void
.end method
