.class Lcom/aio/downloader/cleaner/ShowCleanActivity1$2;
.super Ljava/lang/Object;
.source "ShowCleanActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity1;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$2;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    .line 122
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 125
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$2;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$2;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mContainer:Landroid/view/View;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$2(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    invoke-static {v0, v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$13(Lcom/aio/downloader/cleaner/ShowCleanActivity1;F)V

    .line 126
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$2;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$2;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mContainer:Landroid/view/View;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$2(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    invoke-static {v0, v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$14(Lcom/aio/downloader/cleaner/ShowCleanActivity1;F)V

    .line 128
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$2;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$2;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->mStartAnimView:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$8(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/ImageView;

    move-result-object v1

    const/4 v2, 0x0

    const/high16 v3, 0x42b40000    # 90.0f

    # invokes: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->applyRotation(Landroid/view/View;FF)V
    invoke-static {v0, v1, v2, v3}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$15(Lcom/aio/downloader/cleaner/ShowCleanActivity1;Landroid/view/View;FF)V

    .line 129
    return-void
.end method
