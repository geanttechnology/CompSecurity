.class Lcom/aio/downloader/activity/MySettingsActivity$6;
.super Ljava/lang/Object;
.source "MySettingsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MySettingsActivity;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MySettingsActivity;

.field private final synthetic val$downloadpathCustomDialog:Lcom/aio/downloader/dialog/DownloadpathCustomDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MySettingsActivity;Lcom/aio/downloader/dialog/DownloadpathCustomDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MySettingsActivity$6;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/MySettingsActivity$6;->val$downloadpathCustomDialog:Lcom/aio/downloader/dialog/DownloadpathCustomDialog;

    .line 307
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 311
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$6;->val$downloadpathCustomDialog:Lcom/aio/downloader/dialog/DownloadpathCustomDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->dismiss()V

    .line 313
    return-void
.end method
