.class Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3;
.super Ljava/lang/Object;
.source "ShowCleanActivity_Rub.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    .line 131
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 138
    :try_start_0
    new-instance v0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3$1;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 161
    invoke-virtual {v0, v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 163
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->spnetworkre:Landroid/content/SharedPreferences;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$2(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "isopen"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 165
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v0

    const/4 v1, 0x1

    if-eq v0, v1, :cond_0

    .line 166
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    # invokes: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->downwifi()V
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$3(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V

    .line 185
    :goto_0
    return-void

    .line 171
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$4(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v0

    const-string v1, "com.evzapp.cleanmaster"

    invoke-virtual {v0, v1}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    .line 172
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    .line 173
    const-string v1, "com.evzapp.cleanmaster"

    .line 174
    const-string v2, "AIO Cleaner & Speed Booster"

    .line 175
    const-string v3, "https://lh3.googleusercontent.com/b8eWJD74_yw7BqWv0FER9nnJXX_7ihY1Y3pjxJ111xH6q_syFWRVGvcatpgiDaXiJk9l=w300"

    .line 176
    const v4, 0x149a37

    .line 172
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_0

    .line 182
    :catch_0
    move-exception v0

    goto :goto_0

    .line 179
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    # invokes: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->Mydialog()V
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0
.end method
