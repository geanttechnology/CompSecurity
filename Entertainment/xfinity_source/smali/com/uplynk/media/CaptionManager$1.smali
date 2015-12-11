.class Lcom/uplynk/media/CaptionManager$1;
.super Ljava/lang/Object;
.source "CaptionManager.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/uplynk/media/CaptionManager;-><init>(Lcom/uplynk/media/MediaPlayer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/uplynk/media/CaptionManager;


# direct methods
.method constructor <init>(Lcom/uplynk/media/CaptionManager;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager$1;->this$0:Lcom/uplynk/media/CaptionManager;

    .line 107
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 3

    .prologue
    .line 112
    const/4 v1, 0x0

    .line 113
    .local v1, "newWidth":I
    const/4 v0, 0x0

    .line 115
    .local v0, "newHeight":I
    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$1;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;
    invoke-static {v2}, Lcom/uplynk/media/CaptionManager;->access$10(Lcom/uplynk/media/CaptionManager;)Landroid/widget/RelativeLayout;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 117
    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$1;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;
    invoke-static {v2}, Lcom/uplynk/media/CaptionManager;->access$10(Lcom/uplynk/media/CaptionManager;)Landroid/widget/RelativeLayout;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/RelativeLayout;->getWidth()I

    move-result v1

    .line 118
    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$1;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccContainer:Landroid/widget/RelativeLayout;
    invoke-static {v2}, Lcom/uplynk/media/CaptionManager;->access$10(Lcom/uplynk/media/CaptionManager;)Landroid/widget/RelativeLayout;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/RelativeLayout;->getHeight()I

    move-result v0

    .line 121
    :cond_0
    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$1;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccLayoutWidth:I
    invoke-static {v2}, Lcom/uplynk/media/CaptionManager;->access$11(Lcom/uplynk/media/CaptionManager;)I

    move-result v2

    if-ne v1, v2, :cond_1

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$1;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccLayoutHeight:I
    invoke-static {v2}, Lcom/uplynk/media/CaptionManager;->access$7(Lcom/uplynk/media/CaptionManager;)I

    move-result v2

    if-eq v0, v2, :cond_2

    .line 124
    :cond_1
    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$1;->this$0:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v2}, Lcom/uplynk/media/CaptionManager;->updateMetrics()V

    .line 126
    :cond_2
    return-void
.end method
