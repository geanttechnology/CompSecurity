.class Lcom/aio/downloader/activity/Mp3DownloadedActivity$11;
.super Ljava/lang/Object;
.source "Mp3DownloadedActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/Mp3DownloadedActivity;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

.field private final synthetic val$downloadpathCustomDialog:Lcom/aio/downloader/dialog/DownloadpathCustomDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;Lcom/aio/downloader/dialog/DownloadpathCustomDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$11;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$11;->val$downloadpathCustomDialog:Lcom/aio/downloader/dialog/DownloadpathCustomDialog;

    .line 521
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 525
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$11;->val$downloadpathCustomDialog:Lcom/aio/downloader/dialog/DownloadpathCustomDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->dismiss()V

    .line 527
    return-void
.end method
