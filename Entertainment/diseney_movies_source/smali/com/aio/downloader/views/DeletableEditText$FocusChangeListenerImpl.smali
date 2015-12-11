.class Lcom/aio/downloader/views/DeletableEditText$FocusChangeListenerImpl;
.super Ljava/lang/Object;
.source "DeletableEditText.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/DeletableEditText;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FocusChangeListenerImpl"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/DeletableEditText;


# direct methods
.method private constructor <init>(Lcom/aio/downloader/views/DeletableEditText;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/aio/downloader/views/DeletableEditText$FocusChangeListenerImpl;->this$0:Lcom/aio/downloader/views/DeletableEditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/views/DeletableEditText;Lcom/aio/downloader/views/DeletableEditText$FocusChangeListenerImpl;)V
    .locals 0

    .prologue
    .line 89
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/DeletableEditText$FocusChangeListenerImpl;-><init>(Lcom/aio/downloader/views/DeletableEditText;)V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "hasFocus"    # Z

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 92
    iget-object v2, p0, Lcom/aio/downloader/views/DeletableEditText$FocusChangeListenerImpl;->this$0:Lcom/aio/downloader/views/DeletableEditText;

    invoke-static {v2, p2}, Lcom/aio/downloader/views/DeletableEditText;->access$0(Lcom/aio/downloader/views/DeletableEditText;Z)V

    .line 93
    iget-object v2, p0, Lcom/aio/downloader/views/DeletableEditText$FocusChangeListenerImpl;->this$0:Lcom/aio/downloader/views/DeletableEditText;

    # getter for: Lcom/aio/downloader/views/DeletableEditText;->isHasFocus:Z
    invoke-static {v2}, Lcom/aio/downloader/views/DeletableEditText;->access$1(Lcom/aio/downloader/views/DeletableEditText;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 94
    iget-object v2, p0, Lcom/aio/downloader/views/DeletableEditText$FocusChangeListenerImpl;->this$0:Lcom/aio/downloader/views/DeletableEditText;

    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-interface {v2}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-lt v2, v0, :cond_0

    .line 95
    .local v0, "isVisible":Z
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/views/DeletableEditText$FocusChangeListenerImpl;->this$0:Lcom/aio/downloader/views/DeletableEditText;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/views/DeletableEditText;->setClearDrawableVisible(Z)V

    .line 99
    .end local v0    # "isVisible":Z
    :goto_1
    return-void

    :cond_0
    move v0, v1

    .line 94
    goto :goto_0

    .line 97
    :cond_1
    iget-object v2, p0, Lcom/aio/downloader/views/DeletableEditText$FocusChangeListenerImpl;->this$0:Lcom/aio/downloader/views/DeletableEditText;

    invoke-virtual {v2, v1}, Lcom/aio/downloader/views/DeletableEditText;->setClearDrawableVisible(Z)V

    goto :goto_1
.end method
