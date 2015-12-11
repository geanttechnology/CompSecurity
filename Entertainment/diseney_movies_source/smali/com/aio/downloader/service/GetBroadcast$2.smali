.class Lcom/aio/downloader/service/GetBroadcast$2;
.super Ljava/lang/Object;
.source "GetBroadcast.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/GetBroadcast;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/GetBroadcast;

.field private final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/GetBroadcast;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/GetBroadcast$2;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    iput-object p2, p0, Lcom/aio/downloader/service/GetBroadcast$2;->val$context:Landroid/content/Context;

    .line 175
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/GetBroadcast$2;)Lcom/aio/downloader/service/GetBroadcast;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/aio/downloader/service/GetBroadcast$2;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v8, 0x0

    const/high16 v7, 0x10000000

    .line 180
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v4

    sparse-switch v4, :sswitch_data_0

    .line 263
    :goto_0
    return-void

    .line 182
    :sswitch_0
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$2;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    # getter for: Lcom/aio/downloader/service/GetBroadcast;->anzhuangDialog:Lcom/aio/downloader/dialog/AnzhuangDialog;
    invoke-static {v4}, Lcom/aio/downloader/service/GetBroadcast;->access$0(Lcom/aio/downloader/service/GetBroadcast;)Lcom/aio/downloader/dialog/AnzhuangDialog;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/AnzhuangDialog;->dismiss()V

    goto :goto_0

    .line 185
    :sswitch_1
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$2;->val$context:Landroid/content/Context;

    const-string v5, "Installpop_click"

    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 186
    new-instance v4, Lcom/aio/downloader/service/GetBroadcast$2$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/service/GetBroadcast$2$1;-><init>(Lcom/aio/downloader/service/GetBroadcast$2;)V

    .line 196
    invoke-virtual {v4}, Lcom/aio/downloader/service/GetBroadcast$2$1;->start()V

    .line 197
    const/4 v3, 0x0

    .line 199
    .local v3, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$2;->val$context:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 201
    const-string v5, "com.evzapp.cleanmaster"

    const/4 v6, 0x0

    .line 200
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 205
    :goto_1
    if-nez v3, :cond_2

    .line 206
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$2;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    # getter for: Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/service/GetBroadcast;->access$1(Lcom/aio/downloader/service/GetBroadcast;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 207
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 209
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/service/GetBroadcast$2;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    # getter for: Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/service/GetBroadcast;->access$2(Lcom/aio/downloader/service/GetBroadcast;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 210
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 211
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 209
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 212
    const-string v5, "application/vnd.android.package-archive"

    .line 208
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 213
    invoke-virtual {v0, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 214
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$2;->val$context:Landroid/content/Context;

    invoke-virtual {v4, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 258
    .end local v0    # "aa":Landroid/content/Intent;
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$2;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    # getter for: Lcom/aio/downloader/service/GetBroadcast;->anzhuangDialog:Lcom/aio/downloader/dialog/AnzhuangDialog;
    invoke-static {v4}, Lcom/aio/downloader/service/GetBroadcast;->access$0(Lcom/aio/downloader/service/GetBroadcast;)Lcom/aio/downloader/dialog/AnzhuangDialog;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/AnzhuangDialog;->dismiss()V

    goto :goto_0

    .line 202
    :catch_0
    move-exception v1

    .line 203
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 215
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_0
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$2;->this$0:Lcom/aio/downloader/service/GetBroadcast;

    # getter for: Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/service/GetBroadcast;->access$3(Lcom/aio/downloader/service/GetBroadcast;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 216
    new-instance v4, Lcom/aio/downloader/service/GetBroadcast$2$2;

    iget-object v5, p0, Lcom/aio/downloader/service/GetBroadcast$2;->val$context:Landroid/content/Context;

    invoke-direct {v4, p0, v5}, Lcom/aio/downloader/service/GetBroadcast$2$2;-><init>(Lcom/aio/downloader/service/GetBroadcast$2;Landroid/content/Context;)V

    new-array v5, v8, [Ljava/lang/Void;

    .line 242
    invoke-virtual {v4, v5}, Lcom/aio/downloader/service/GetBroadcast$2$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_2

    .line 244
    :cond_1
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$2;->val$context:Landroid/content/Context;

    .line 245
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 244
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 246
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 247
    const-string v5, "com.evzapp.cleanmaster"

    .line 246
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 248
    invoke-virtual {v2, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 249
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$2;->val$context:Landroid/content/Context;

    invoke-virtual {v4, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_2

    .line 252
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_2
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$2;->val$context:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 254
    const-string v5, "com.evzapp.cleanmaster"

    .line 253
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 255
    .restart local v2    # "intent":Landroid/content/Intent;
    invoke-virtual {v2, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 256
    iget-object v4, p0, Lcom/aio/downloader/service/GetBroadcast$2;->val$context:Landroid/content/Context;

    invoke-virtual {v4, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_2

    .line 180
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f070090 -> :sswitch_0
        0x7f070096 -> :sswitch_1
    .end sparse-switch
.end method
