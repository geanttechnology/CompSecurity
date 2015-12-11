.class Lcom/aio/downloader/adapter/Mp3ListviewAdapter$3;
.super Ljava/lang/Object;
.source "Mp3ListviewAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->downwifi()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$3;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    .line 402
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 406
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$2(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Landroid/content/Context;

    move-result-object v0

    new-instance v1, Landroid/content/Intent;

    .line 407
    const-string v2, "android.settings.WIRELESS_SETTINGS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 406
    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 408
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$3;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->dismiss()V

    .line 410
    return-void
.end method
