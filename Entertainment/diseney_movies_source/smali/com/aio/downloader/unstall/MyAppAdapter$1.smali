.class Lcom/aio/downloader/unstall/MyAppAdapter$1;
.super Ljava/lang/Object;
.source "MyAppAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/unstall/MyAppAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

.field private final synthetic val$myPackageNmae:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAppAdapter$1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    iput-object p2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$1;->val$myPackageNmae:Ljava/lang/String;

    .line 150
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v7, 0x1

    const/4 v9, 0x0

    .line 161
    iget-object v5, p0, Lcom/aio/downloader/unstall/MyAppAdapter$1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;
    invoke-static {v5}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$5(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/content/Context;

    move-result-object v5

    .line 162
    const-string v6, "window"

    invoke-virtual {v5, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    .line 161
    check-cast v4, Landroid/view/WindowManager;

    .line 164
    .local v4, "wm":Landroid/view/WindowManager;
    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Display;->getWidth()I

    move-result v3

    .line 165
    .local v3, "width":I
    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Display;->getHeight()I

    move-result v1

    .line 167
    .local v1, "height":I
    const/4 v5, 0x2

    new-array v2, v5, [I

    .line 168
    .local v2, "location":[I
    invoke-virtual {p1, v2}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 169
    iget-object v5, p0, Lcom/aio/downloader/unstall/MyAppAdapter$1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    iget-object v6, p0, Lcom/aio/downloader/unstall/MyAppAdapter$1;->val$myPackageNmae:Ljava/lang/String;

    # invokes: Lcom/aio/downloader/unstall/MyAppAdapter;->popuWindow(Ljava/lang/String;)V
    invoke-static {v5, v6}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$7(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/lang/String;)V

    .line 170
    div-int/lit8 v5, v1, 0x2

    aget v6, v2, v7

    if-ge v5, v6, :cond_0

    .line 171
    iget-object v5, p0, Lcom/aio/downloader/unstall/MyAppAdapter$1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;
    invoke-static {v5}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$5(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/content/Context;

    move-result-object v5

    const/high16 v6, 0x43480000    # 200.0f

    invoke-static {v5, v6}, Lcom/aio/downloader/unstall/MyAppAdapter;->dip2px(Landroid/content/Context;F)I

    move-result v0

    .line 172
    .local v0, "dip2px":I
    iget-object v5, p0, Lcom/aio/downloader/unstall/MyAppAdapter$1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v5}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$8(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/widget/PopupWindow;

    move-result-object v5

    .line 173
    aget v6, v2, v9

    aget v7, v2, v7

    sub-int/2addr v7, v0

    .line 172
    invoke-virtual {v5, p1, v9, v6, v7}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    .line 179
    .end local v0    # "dip2px":I
    :goto_0
    return-void

    .line 175
    :cond_0
    iget-object v5, p0, Lcom/aio/downloader/unstall/MyAppAdapter$1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v5}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$8(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/widget/PopupWindow;

    move-result-object v5

    .line 176
    aget v6, v2, v9

    aget v7, v2, v7

    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter$1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v8}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$8(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/widget/PopupWindow;

    move-result-object v8

    invoke-virtual {v8}, Landroid/widget/PopupWindow;->getHeight()I

    move-result v8

    sub-int/2addr v7, v8

    .line 175
    invoke-virtual {v5, p1, v9, v6, v7}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    goto :goto_0
.end method
