.class Lcom/facebook/widget/ImageDownloader$DownloadImageWorkItem;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private context:Landroid/content/Context;

.field private key:Lcom/facebook/widget/ImageDownloader$RequestKey;


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/facebook/widget/ImageDownloader$RequestKey;)V
    .locals 0

    .prologue
    .line 332
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 333
    iput-object p1, p0, Lcom/facebook/widget/ImageDownloader$DownloadImageWorkItem;->context:Landroid/content/Context;

    .line 334
    iput-object p2, p0, Lcom/facebook/widget/ImageDownloader$DownloadImageWorkItem;->key:Lcom/facebook/widget/ImageDownloader$RequestKey;

    .line 335
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 339
    iget-object v0, p0, Lcom/facebook/widget/ImageDownloader$DownloadImageWorkItem;->key:Lcom/facebook/widget/ImageDownloader$RequestKey;

    iget-object v1, p0, Lcom/facebook/widget/ImageDownloader$DownloadImageWorkItem;->context:Landroid/content/Context;

    # invokes: Lcom/facebook/widget/ImageDownloader;->download(Lcom/facebook/widget/ImageDownloader$RequestKey;Landroid/content/Context;)V
    invoke-static {v0, v1}, Lcom/facebook/widget/ImageDownloader;->access$200(Lcom/facebook/widget/ImageDownloader$RequestKey;Landroid/content/Context;)V

    .line 340
    return-void
.end method
