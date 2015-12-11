.class Lcom/aio/downloader/views/DeletableEditText$TextWatcherImpl;
.super Ljava/lang/Object;
.source "DeletableEditText.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/DeletableEditText;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TextWatcherImpl"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/DeletableEditText;


# direct methods
.method private constructor <init>(Lcom/aio/downloader/views/DeletableEditText;)V
    .locals 0

    .prologue
    .line 104
    iput-object p1, p0, Lcom/aio/downloader/views/DeletableEditText$TextWatcherImpl;->this$0:Lcom/aio/downloader/views/DeletableEditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/views/DeletableEditText;Lcom/aio/downloader/views/DeletableEditText$TextWatcherImpl;)V
    .locals 0

    .prologue
    .line 104
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/DeletableEditText$TextWatcherImpl;-><init>(Lcom/aio/downloader/views/DeletableEditText;)V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 2
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    const/4 v0, 0x1

    .line 107
    iget-object v1, p0, Lcom/aio/downloader/views/DeletableEditText$TextWatcherImpl;->this$0:Lcom/aio/downloader/views/DeletableEditText;

    invoke-virtual {v1}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lt v1, v0, :cond_0

    .line 108
    .local v0, "isVisible":Z
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/views/DeletableEditText$TextWatcherImpl;->this$0:Lcom/aio/downloader/views/DeletableEditText;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/views/DeletableEditText;->setClearDrawableVisible(Z)V

    .line 109
    return-void

    .line 107
    .end local v0    # "isVisible":Z
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 114
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 119
    return-void
.end method
