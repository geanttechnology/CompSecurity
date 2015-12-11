.class Lcom/aio/downloader/adapter/AppListviewAdapter$8;
.super Ljava/lang/Object;
.source "AppListviewAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/AppListviewAdapter;->downwifi()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppListviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$8;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$8;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    .line 971
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 975
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$8;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;

    move-result-object v0

    new-instance v1, Landroid/content/Intent;

    .line 976
    const-string v2, "android.settings.WIRELESS_SETTINGS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 975
    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 977
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$8;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->dismiss()V

    .line 979
    return-void
.end method
