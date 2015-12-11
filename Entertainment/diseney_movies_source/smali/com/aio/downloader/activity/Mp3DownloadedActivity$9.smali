.class Lcom/aio/downloader/activity/Mp3DownloadedActivity$9;
.super Ljava/lang/Object;
.source "Mp3DownloadedActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


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


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$9;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    .line 493
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "arg0"    # Landroid/content/DialogInterface;
    .param p2, "arg1"    # I

    .prologue
    .line 498
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$9;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->Mp3deletall()V

    .line 499
    return-void
.end method
