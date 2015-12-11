.class Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$3;
.super Ljava/lang/Object;
.source "Home_Gridview_Adapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$3;->this$1:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;

    .line 728
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 733
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7$3;->this$1:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;)Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    move-result-object v0

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$5(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/widget/PopupWindow;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 734
    return-void
.end method
