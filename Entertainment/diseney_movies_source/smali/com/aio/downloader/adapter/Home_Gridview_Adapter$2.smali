.class Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;
.super Ljava/lang/Object;
.source "Home_Gridview_Adapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

.field private final synthetic val$has_apk:Ljava/lang/String;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    iput p2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;->val$position:I

    iput-object p3, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;->val$has_apk:Ljava/lang/String;

    .line 311
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v8, 0x1

    const/4 v9, 0x0

    .line 319
    iget-object v5, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v5}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/Context;

    move-result-object v5

    .line 320
    const-string v6, "window"

    invoke-virtual {v5, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    .line 319
    check-cast v4, Landroid/view/WindowManager;

    .line 322
    .local v4, "wm":Landroid/view/WindowManager;
    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Display;->getWidth()I

    move-result v3

    .line 323
    .local v3, "width":I
    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Display;->getHeight()I

    move-result v1

    .line 325
    .local v1, "height":I
    const/4 v5, 0x2

    new-array v2, v5, [I

    .line 326
    .local v2, "location":[I
    invoke-virtual {p1, v2}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 327
    iget-object v5, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    iget v6, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;->val$position:I

    iget-object v7, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;->val$has_apk:Ljava/lang/String;

    # invokes: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->popuWindow(ILjava/lang/String;)V
    invoke-static {v5, v6, v7}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$4(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;ILjava/lang/String;)V

    .line 328
    div-int/lit8 v5, v1, 0x2

    aget v6, v2, v8

    if-ge v5, v6, :cond_0

    .line 329
    iget-object v5, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v5}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/Context;

    move-result-object v5

    const/high16 v6, 0x43160000    # 150.0f

    invoke-static {v5, v6}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->dip2px(Landroid/content/Context;F)I

    move-result v0

    .line 330
    .local v0, "dip2px":I
    iget-object v5, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v5}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$5(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/widget/PopupWindow;

    move-result-object v5

    .line 331
    aget v6, v2, v9

    aget v7, v2, v8

    sub-int/2addr v7, v0

    .line 330
    invoke-virtual {v5, p1, v9, v6, v7}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    .line 378
    .end local v0    # "dip2px":I
    :goto_0
    return-void

    .line 333
    :cond_0
    iget-object v5, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v5}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$5(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/widget/PopupWindow;

    move-result-object v5

    .line 334
    aget v6, v2, v9

    aget v7, v2, v8

    iget-object v8, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v8}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$5(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/widget/PopupWindow;

    move-result-object v8

    invoke-virtual {v8}, Landroid/widget/PopupWindow;->getHeight()I

    move-result v8

    sub-int/2addr v7, v8

    .line 333
    invoke-virtual {v5, p1, v9, v6, v7}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    goto :goto_0
.end method
