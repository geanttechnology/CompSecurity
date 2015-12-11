.class Lcom/aio/downloader/service/ServiceCleaner$1$1;
.super Ljava/lang/Object;
.source "ServiceCleaner.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceCleaner$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/service/ServiceCleaner$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceCleaner$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceCleaner$1$1;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    .line 150
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 155
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner$1$1;->this$1:Lcom/aio/downloader/service/ServiceCleaner$1;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;
    invoke-static {v0}, Lcom/aio/downloader/service/ServiceCleaner$1;->access$0(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/dialog/NeituiDialog;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/NeituiDialog;->dismiss()V

    .line 156
    return-void
.end method
