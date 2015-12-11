.class Lcom/aio/downloader/adapter/AppGridviewAdapter$5;
.super Ljava/lang/Object;
.source "AppGridviewAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/AppGridviewAdapter;->downwifi()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/AppGridviewAdapter;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppGridviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$5;->this$0:Lcom/aio/downloader/adapter/AppGridviewAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$5;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    .line 549
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 553
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$5;->this$0:Lcom/aio/downloader/adapter/AppGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Landroid/content/Context;

    move-result-object v0

    new-instance v1, Landroid/content/Intent;

    .line 554
    const-string v2, "android.settings.WIRELESS_SETTINGS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 553
    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 555
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter$5;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->dismiss()V

    .line 557
    return-void
.end method
