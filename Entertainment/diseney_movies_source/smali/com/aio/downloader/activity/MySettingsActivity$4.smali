.class Lcom/aio/downloader/activity/MySettingsActivity$4;
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


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MySettingsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MySettingsActivity$4;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    .line 247
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 251
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$4;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    # getter for: Lcom/aio/downloader/activity/MySettingsActivity;->downloadingdialog:Lcom/aio/downloader/dialog/DownloadsettingDialog;
    invoke-static {v0}, Lcom/aio/downloader/activity/MySettingsActivity;->access$5(Lcom/aio/downloader/activity/MySettingsActivity;)Lcom/aio/downloader/dialog/DownloadsettingDialog;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/DownloadsettingDialog;->dismiss()V

    .line 253
    return-void
.end method
