.class Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;
.super Ljava/lang/Object;
.source "Downloader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/download/Downloader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DownloadInfo"
.end annotation


# instance fields
.field iBytesDownloaded:Z

.field iDownloadExceptions:I

.field iDownloading:Z

.field iLastBytesRead:J

.field final synthetic this$0:Lcom/penthera/virtuososdk/download/Downloader;


# direct methods
.method private constructor <init>(Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 686
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 688
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    .line 690
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 691
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 692
    iput v2, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    return-void
.end method

.method synthetic constructor <init>(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;)V
    .locals 0

    .prologue
    .line 686
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;-><init>(Lcom/penthera/virtuososdk/download/Downloader;)V

    return-void
.end method
