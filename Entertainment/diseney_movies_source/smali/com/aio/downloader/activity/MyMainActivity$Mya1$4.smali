.class Lcom/aio/downloader/activity/MyMainActivity$Mya1$4;
.super Ljava/lang/Object;
.source "MyMainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity$Mya1;->onPostExecute(Ljava/util/ArrayList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

.field private final synthetic val$dialog1:Lcom/aio/downloader/dialog/WebFirstDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity$Mya1;Lcom/aio/downloader/dialog/WebFirstDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$4;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    iput-object p2, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$4;->val$dialog1:Lcom/aio/downloader/dialog/WebFirstDialog;

    .line 2875
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 2880
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "https://play.google.com/store/apps/details?id="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 2881
    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$4;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v3

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 2880
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 2882
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 2883
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$4;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2884
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$4;->val$dialog1:Lcom/aio/downloader/dialog/WebFirstDialog;

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/WebFirstDialog;->dismiss()V

    .line 2885
    return-void
.end method
