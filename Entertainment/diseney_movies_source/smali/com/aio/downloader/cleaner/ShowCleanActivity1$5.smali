.class Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;
.super Ljava/lang/Object;
.source "ShowCleanActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity1;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    .line 204
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;)Lcom/aio/downloader/cleaner/ShowCleanActivity1;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/high16 v8, 0x10000000

    const/4 v7, 0x0

    .line 210
    const/4 v3, 0x0

    .line 212
    .local v3, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 213
    const-string v5, "com.evzapp.cleanmaster"

    const/4 v6, 0x0

    .line 212
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 217
    :goto_0
    if-nez v3, :cond_2

    .line 218
    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$23(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 219
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 221
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$24(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 222
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 221
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 223
    const-string v5, "application/vnd.android.package-archive"

    .line 220
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 224
    invoke-virtual {v0, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 225
    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    invoke-virtual {v4, v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->startActivity(Landroid/content/Intent;)V

    .line 259
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_0
    :goto_1
    return-void

    .line 214
    :catch_0
    move-exception v1

    .line 215
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 226
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$25(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 227
    new-instance v4, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5$1;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;)V

    new-array v5, v7, [Ljava/lang/Void;

    .line 250
    invoke-virtual {v4, v5}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 253
    :cond_2
    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    invoke-virtual {v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 254
    const-string v5, "com.evzapp.cleanmaster"

    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 255
    .local v2, "intent":Landroid/content/Intent;
    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 256
    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$5;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    invoke-virtual {v4, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->startActivity(Landroid/content/Intent;)V

    goto :goto_1
.end method
