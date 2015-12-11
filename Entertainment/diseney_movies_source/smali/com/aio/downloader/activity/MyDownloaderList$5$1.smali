.class Lcom/aio/downloader/activity/MyDownloaderList$5$1;
.super Ljava/lang/Object;
.source "MyDownloaderList.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyDownloaderList$5;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyDownloaderList$5;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    .line 318
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 321
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 322
    return-void
.end method
