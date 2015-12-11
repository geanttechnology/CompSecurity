.class Lcom/xfinity/playerlib/view/widget/DownloadProgressBar$1;
.super Ljava/lang/Object;
.source "DownloadProgressBar.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgressText(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    .prologue
    .line 209
    iput-object p1, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar$1;->this$0:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 5

    .prologue
    .line 213
    iget-object v3, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar$1;->this$0:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    # getter for: Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadProgressBar:Landroid/widget/ProgressBar;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->access$000(Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;)Landroid/widget/ProgressBar;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ProgressBar;->getWidth()I

    move-result v0

    .line 214
    .local v0, "progressBarWidth":I
    iget-object v3, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar$1;->this$0:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    # getter for: Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadProgressText:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->access$100(Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/TextView;->getWidth()I

    move-result v1

    .line 215
    .local v1, "progressTextWidth":I
    iget-object v3, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar$1;->this$0:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    # getter for: Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadSizeText:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->access$200(Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/TextView;->getWidth()I

    move-result v2

    .line 219
    .local v2, "sizeTexWidth":I
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    if-eqz v2, :cond_0

    .line 220
    sub-int v3, v0, v1

    if-lt v3, v2, :cond_1

    .line 221
    iget-object v3, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar$1;->this$0:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    # getter for: Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadSizeText:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->access$200(Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;)Landroid/widget/TextView;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 226
    :goto_0
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x10

    if-lt v3, v4, :cond_2

    .line 227
    iget-object v3, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar$1;->this$0:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    # getter for: Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadProgressBar:Landroid/widget/ProgressBar;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->access$000(Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;)Landroid/widget/ProgressBar;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ProgressBar;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v3

    invoke-virtual {v3, p0}, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 232
    :cond_0
    :goto_1
    return-void

    .line 223
    :cond_1
    iget-object v3, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar$1;->this$0:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    # getter for: Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadSizeText:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->access$200(Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;)Landroid/widget/TextView;

    move-result-object v3

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 229
    :cond_2
    iget-object v3, p0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar$1;->this$0:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    # getter for: Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->downloadProgressBar:Landroid/widget/ProgressBar;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->access$000(Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;)Landroid/widget/ProgressBar;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ProgressBar;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v3

    invoke-virtual {v3, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    goto :goto_1
.end method
