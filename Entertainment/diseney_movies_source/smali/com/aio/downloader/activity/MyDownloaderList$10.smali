.class Lcom/aio/downloader/activity/MyDownloaderList$10;
.super Ljava/lang/Object;
.source "MyDownloaderList.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyDownloaderList;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyDownloaderList;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyDownloaderList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$10;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    .line 1116
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "arg0"    # Landroid/content/DialogInterface;
    .param p2, "arg1"    # I

    .prologue
    .line 1121
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$10;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->Appdeletall()V

    .line 1122
    return-void
.end method
