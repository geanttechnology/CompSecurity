.class Lcom/aio/downloader/adapter/AppListviewAdapter$4$1;
.super Ljava/lang/Object;
.source "AppListviewAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/AppListviewAdapter$4;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/adapter/AppListviewAdapter$4;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppListviewAdapter$4;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$4$1;->this$1:Lcom/aio/downloader/adapter/AppListviewAdapter$4;

    .line 625
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 630
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$4$1;->this$1:Lcom/aio/downloader/adapter/AppListviewAdapter$4;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$4;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;
    invoke-static {v0}, Lcom/aio/downloader/adapter/AppListviewAdapter$4;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter$4;)Lcom/aio/downloader/adapter/AppListviewAdapter;

    move-result-object v0

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$7(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/widget/PopupWindow;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 631
    return-void
.end method
