.class Lcom/aio/downloader/adapter/TodaypickListviewAdapter$5;
.super Ljava/lang/Object;
.source "TodaypickListviewAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->downwifi()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$5;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$5;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    .line 597
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 601
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$5;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$0(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Landroid/content/Context;

    move-result-object v0

    new-instance v1, Landroid/content/Intent;

    .line 602
    const-string v2, "android.settings.WIRELESS_SETTINGS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 601
    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 603
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$5;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->dismiss()V

    .line 605
    return-void
.end method
