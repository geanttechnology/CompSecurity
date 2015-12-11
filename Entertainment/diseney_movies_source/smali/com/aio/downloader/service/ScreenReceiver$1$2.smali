.class Lcom/aio/downloader/service/ScreenReceiver$1$2;
.super Ljava/lang/Object;
.source "ScreenReceiver.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ScreenReceiver$1;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/service/ScreenReceiver$1;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/CleanerUPDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ScreenReceiver$1;Lcom/aio/downloader/dialog/CleanerUPDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ScreenReceiver$1$2;->this$1:Lcom/aio/downloader/service/ScreenReceiver$1;

    iput-object p2, p0, Lcom/aio/downloader/service/ScreenReceiver$1$2;->val$dialog:Lcom/aio/downloader/dialog/CleanerUPDialog;

    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ScreenReceiver$1$2;)Lcom/aio/downloader/service/ScreenReceiver$1;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/aio/downloader/service/ScreenReceiver$1$2;->this$1:Lcom/aio/downloader/service/ScreenReceiver$1;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x0

    .line 73
    iget-object v3, p0, Lcom/aio/downloader/service/ScreenReceiver$1$2;->this$1:Lcom/aio/downloader/service/ScreenReceiver$1;

    # getter for: Lcom/aio/downloader/service/ScreenReceiver$1;->this$0:Lcom/aio/downloader/service/ScreenReceiver;
    invoke-static {v3}, Lcom/aio/downloader/service/ScreenReceiver$1;->access$0(Lcom/aio/downloader/service/ScreenReceiver$1;)Lcom/aio/downloader/service/ScreenReceiver;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ScreenReceiver;->mContext:Landroid/content/Context;
    invoke-static {v3}, Lcom/aio/downloader/service/ScreenReceiver;->access$0(Lcom/aio/downloader/service/ScreenReceiver;)Landroid/content/Context;

    move-result-object v3

    const-string v4, "cleanerupdate_click"

    invoke-static {v3, v4}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 74
    const/4 v2, 0x0

    .line 76
    .local v2, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v3, p0, Lcom/aio/downloader/service/ScreenReceiver$1$2;->this$1:Lcom/aio/downloader/service/ScreenReceiver$1;

    # getter for: Lcom/aio/downloader/service/ScreenReceiver$1;->this$0:Lcom/aio/downloader/service/ScreenReceiver;
    invoke-static {v3}, Lcom/aio/downloader/service/ScreenReceiver$1;->access$0(Lcom/aio/downloader/service/ScreenReceiver$1;)Lcom/aio/downloader/service/ScreenReceiver;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ScreenReceiver;->mContext:Landroid/content/Context;
    invoke-static {v3}, Lcom/aio/downloader/service/ScreenReceiver;->access$0(Lcom/aio/downloader/service/ScreenReceiver;)Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 77
    const-string v4, "com.evzapp.cleanmaster"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 81
    :goto_0
    if-nez v2, :cond_0

    .line 82
    iget-object v3, p0, Lcom/aio/downloader/service/ScreenReceiver$1$2;->this$1:Lcom/aio/downloader/service/ScreenReceiver$1;

    # getter for: Lcom/aio/downloader/service/ScreenReceiver$1;->this$0:Lcom/aio/downloader/service/ScreenReceiver;
    invoke-static {v3}, Lcom/aio/downloader/service/ScreenReceiver$1;->access$0(Lcom/aio/downloader/service/ScreenReceiver$1;)Lcom/aio/downloader/service/ScreenReceiver;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ScreenReceiver;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/ScreenReceiver;->access$1(Lcom/aio/downloader/service/ScreenReceiver;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 83
    new-instance v0, Landroid/content/Intent;

    const-string v3, "android.intent.action.VIEW"

    invoke-direct {v0, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 85
    .local v0, "aa":Landroid/content/Intent;
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "file://"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/aio/downloader/service/ScreenReceiver$1$2;->this$1:Lcom/aio/downloader/service/ScreenReceiver$1;

    # getter for: Lcom/aio/downloader/service/ScreenReceiver$1;->this$0:Lcom/aio/downloader/service/ScreenReceiver;
    invoke-static {v4}, Lcom/aio/downloader/service/ScreenReceiver$1;->access$0(Lcom/aio/downloader/service/ScreenReceiver$1;)Lcom/aio/downloader/service/ScreenReceiver;

    move-result-object v4

    # getter for: Lcom/aio/downloader/service/ScreenReceiver;->PRO_DIR:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/service/ScreenReceiver;->access$2(Lcom/aio/downloader/service/ScreenReceiver;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 86
    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "cleaner.apk"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 85
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 87
    const-string v4, "application/vnd.android.package-archive"

    .line 84
    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 88
    const/high16 v3, 0x10000000

    invoke-virtual {v0, v3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 89
    iget-object v3, p0, Lcom/aio/downloader/service/ScreenReceiver$1$2;->this$1:Lcom/aio/downloader/service/ScreenReceiver$1;

    # getter for: Lcom/aio/downloader/service/ScreenReceiver$1;->this$0:Lcom/aio/downloader/service/ScreenReceiver;
    invoke-static {v3}, Lcom/aio/downloader/service/ScreenReceiver$1;->access$0(Lcom/aio/downloader/service/ScreenReceiver$1;)Lcom/aio/downloader/service/ScreenReceiver;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ScreenReceiver;->mContext:Landroid/content/Context;
    invoke-static {v3}, Lcom/aio/downloader/service/ScreenReceiver;->access$0(Lcom/aio/downloader/service/ScreenReceiver;)Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 117
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_0
    :goto_1
    iget-object v3, p0, Lcom/aio/downloader/service/ScreenReceiver$1$2;->val$dialog:Lcom/aio/downloader/dialog/CleanerUPDialog;

    invoke-virtual {v3}, Lcom/aio/downloader/dialog/CleanerUPDialog;->dismiss()V

    .line 119
    return-void

    .line 78
    :catch_0
    move-exception v1

    .line 79
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 90
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v3, p0, Lcom/aio/downloader/service/ScreenReceiver$1$2;->this$1:Lcom/aio/downloader/service/ScreenReceiver$1;

    # getter for: Lcom/aio/downloader/service/ScreenReceiver$1;->this$0:Lcom/aio/downloader/service/ScreenReceiver;
    invoke-static {v3}, Lcom/aio/downloader/service/ScreenReceiver$1;->access$0(Lcom/aio/downloader/service/ScreenReceiver$1;)Lcom/aio/downloader/service/ScreenReceiver;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ScreenReceiver;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/ScreenReceiver;->access$3(Lcom/aio/downloader/service/ScreenReceiver;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 91
    new-instance v3, Lcom/aio/downloader/service/ScreenReceiver$1$2$1;

    invoke-direct {v3, p0}, Lcom/aio/downloader/service/ScreenReceiver$1$2$1;-><init>(Lcom/aio/downloader/service/ScreenReceiver$1$2;)V

    new-array v4, v6, [Ljava/lang/Void;

    .line 114
    invoke-virtual {v3, v4}, Lcom/aio/downloader/service/ScreenReceiver$1$2$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1
.end method
