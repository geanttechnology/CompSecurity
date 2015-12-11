.class Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;
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
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    iput-object p2, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->val$dialog1:Lcom/aio/downloader/dialog/WebFirstDialog;

    .line 2827
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 2831
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->spnetworkre:Landroid/content/SharedPreferences;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$4(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "isopen"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2833
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v0

    const/4 v1, 0x1

    if-eq v0, v1, :cond_0

    .line 2834
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    # invokes: Lcom/aio/downloader/activity/MyMainActivity;->downwifi()V
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$5(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 2872
    :goto_0
    return-void

    .line 2840
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$6(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_2

    .line 2842
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    .line 2843
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v2

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v3

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v3

    .line 2844
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v4

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v4

    .line 2842
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/aio/downloader/activity/MyMainActivity;->MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 2850
    :goto_1
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    iget-boolean v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->callerD:Z

    if-eqz v0, :cond_1

    .line 2853
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$6(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v0

    .line 2854
    const-string v1, "com.freepezzle.hexcrush"

    invoke-virtual {v0, v1}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 2853
    if-nez v0, :cond_3

    .line 2857
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 2858
    const-string v1, "web_caller_click"

    .line 2856
    invoke-static {v0, v1}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 2859
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    .line 2860
    const-string v1, "com.freepezzle.hexcrush"

    .line 2861
    const-string v2, "HEX Crush"

    .line 2862
    const-string v3, "http://android.downloadatoz.com/_201409/img/hex512.png"

    .line 2863
    const/16 v4, 0x2304

    .line 2859
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/aio/downloader/activity/MyMainActivity;->MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 2871
    :cond_1
    :goto_2
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->val$dialog1:Lcom/aio/downloader/dialog/WebFirstDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/WebFirstDialog;->dismiss()V

    goto/16 :goto_0

    .line 2847
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    # invokes: Lcom/aio/downloader/activity/MyMainActivity;->Mydialog()V
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$17(Lcom/aio/downloader/activity/MyMainActivity;)V

    goto :goto_1

    .line 2866
    :cond_3
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    # invokes: Lcom/aio/downloader/activity/MyMainActivity;->Mydialog()V
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$17(Lcom/aio/downloader/activity/MyMainActivity;)V

    goto :goto_2
.end method
