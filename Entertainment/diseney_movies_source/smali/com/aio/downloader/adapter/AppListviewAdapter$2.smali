.class Lcom/aio/downloader/adapter/AppListviewAdapter$2;
.super Ljava/lang/Object;
.source "AppListviewAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/AppListviewAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

.field private final synthetic val$has_apk:Ljava/lang/String;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppListviewAdapter;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    iput p2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$2;->val$position:I

    iput-object p3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$2;->val$has_apk:Ljava/lang/String;

    .line 435
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 441
    :try_start_0
    iget-object v5, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v5}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;

    move-result-object v5

    .line 442
    const-string v6, "window"

    invoke-virtual {v5, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    .line 441
    check-cast v4, Landroid/view/WindowManager;

    .line 444
    .local v4, "wm":Landroid/view/WindowManager;
    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Display;->getWidth()I

    move-result v3

    .line 445
    .local v3, "width":I
    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Display;->getHeight()I

    move-result v1

    .line 447
    .local v1, "height":I
    const/4 v5, 0x2

    new-array v2, v5, [I

    .line 448
    .local v2, "location":[I
    invoke-virtual {p1, v2}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 449
    iget-object v5, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    iget v6, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$2;->val$position:I

    iget-object v7, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$2;->val$has_apk:Ljava/lang/String;

    # invokes: Lcom/aio/downloader/adapter/AppListviewAdapter;->popuWindow(ILjava/lang/String;)V
    invoke-static {v5, v6, v7}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$6(Lcom/aio/downloader/adapter/AppListviewAdapter;ILjava/lang/String;)V

    .line 450
    div-int/lit8 v5, v1, 0x2

    const/4 v6, 0x1

    aget v6, v2, v6

    if-ge v5, v6, :cond_0

    .line 451
    iget-object v5, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v5}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;

    move-result-object v5

    const/high16 v6, 0x43160000    # 150.0f

    invoke-static {v5, v6}, Lcom/aio/downloader/adapter/AppListviewAdapter;->dip2px(Landroid/content/Context;F)I

    move-result v0

    .line 452
    .local v0, "dip2px":I
    iget-object v5, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v5}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$7(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/widget/PopupWindow;

    move-result-object v5

    const/4 v6, 0x0

    .line 453
    const/4 v7, 0x0

    aget v7, v2, v7

    const/4 v8, 0x1

    aget v8, v2, v8

    sub-int/2addr v8, v0

    .line 452
    invoke-virtual {v5, p1, v6, v7, v8}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    .line 520
    .end local v0    # "dip2px":I
    .end local v1    # "height":I
    .end local v2    # "location":[I
    .end local v3    # "width":I
    .end local v4    # "wm":Landroid/view/WindowManager;
    :goto_0
    return-void

    .line 455
    .restart local v1    # "height":I
    .restart local v2    # "location":[I
    .restart local v3    # "width":I
    .restart local v4    # "wm":Landroid/view/WindowManager;
    :cond_0
    iget-object v5, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v5}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$7(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/widget/PopupWindow;

    move-result-object v5

    const/4 v6, 0x0

    .line 456
    const/4 v7, 0x0

    aget v7, v2, v7

    const/4 v8, 0x1

    aget v8, v2, v8

    iget-object v9, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v9}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$7(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/widget/PopupWindow;

    move-result-object v9

    invoke-virtual {v9}, Landroid/widget/PopupWindow;->getHeight()I

    move-result v9

    sub-int/2addr v8, v9

    .line 455
    invoke-virtual {v5, p1, v6, v7, v8}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 458
    .end local v1    # "height":I
    .end local v2    # "location":[I
    .end local v3    # "width":I
    .end local v4    # "wm":Landroid/view/WindowManager;
    :catch_0
    move-exception v5

    goto :goto_0
.end method
