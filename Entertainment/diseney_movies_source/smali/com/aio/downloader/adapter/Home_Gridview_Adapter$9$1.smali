.class Lcom/aio/downloader/adapter/Home_Gridview_Adapter$9$1;
.super Ljava/lang/Object;
.source "Home_Gridview_Adapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Home_Gridview_Adapter$9;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$9;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$9;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$9$1;->this$1:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$9;

    .line 779
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 784
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$9$1;->this$1:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$9;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter$9;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$9;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$9;)Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    move-result-object v0

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$5(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/widget/PopupWindow;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 785
    return-void
.end method
