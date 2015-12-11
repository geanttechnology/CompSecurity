.class Lcom/aio/downloader/service/ServiceUpdate$Mya7;
.super Landroid/os/AsyncTask;
.source "ServiceUpdate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/service/ServiceUpdate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Mya7"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field private showup:I

.field final synthetic this$0:Lcom/aio/downloader/service/ServiceUpdate;

.field private url1:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceUpdate;)V
    .locals 0

    .prologue
    .line 2069
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method private ShowResult7(Ljava/lang/String;)V
    .locals 8
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 2100
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseupdata(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 2101
    sget v2, Lcom/aio/downloader/utils/Myutils;->status:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    .line 2104
    :try_start_0
    const-string v2, "qaz"

    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2105
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v2

    iget-object v4, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    int-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->showup:I

    .line 2106
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 2107
    .local v0, "timer":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/service/ServiceUpdate$Mya7$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/service/ServiceUpdate$Mya7$1;-><init>(Lcom/aio/downloader/service/ServiceUpdate$Mya7;)V

    .line 2125
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0x3e8

    const-wide/16 v4, 0x7530

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 2130
    .end local v0    # "timer":Ljava/util/Timer;
    .end local v1    # "task":Ljava/util/TimerTask;
    :goto_0
    new-instance v6, Lcom/aio/downloader/utils/MyAppInfo;

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v6, v2}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 2132
    .local v6, "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :try_start_1
    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    iget v4, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->showup:I

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 2133
    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v2

    .line 2132
    invoke-virtual {v6, v2}, Lcom/aio/downloader/utils/MyAppInfo;->getAppName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v3, Lcom/aio/downloader/service/ServiceUpdate;->appName:Ljava/lang/String;

    .line 2134
    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    iget v4, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->showup:I

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 2135
    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v2

    .line 2134
    invoke-virtual {v6, v2}, Lcom/aio/downloader/utils/MyAppInfo;->getAppVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v3, Lcom/aio/downloader/service/ServiceUpdate;->appVersion:Ljava/lang/String;

    .line 2136
    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    iget v4, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->showup:I

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 2137
    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v2

    .line 2136
    invoke-virtual {v6, v2}, Lcom/aio/downloader/utils/MyAppInfo;->getAppIcon(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    iput-object v2, v3, Lcom/aio/downloader/service/ServiceUpdate;->appIcon:Landroid/graphics/drawable/Drawable;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 2160
    .end local v6    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :cond_0
    :goto_1
    return-void

    .line 2139
    .restart local v6    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :catch_0
    move-exception v7

    .line 2141
    .local v7, "e":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 2127
    .end local v6    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .end local v7    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v2

    goto :goto_0
.end method

.method static synthetic access$2(Lcom/aio/downloader/service/ServiceUpdate$Mya7;)I
    .locals 1

    .prologue
    .line 2071
    iget v0, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->showup:I

    return v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/service/ServiceUpdate$Mya7;)Lcom/aio/downloader/service/ServiceUpdate;
    .locals 1

    .prologue
    .line 2069
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    return-object v0
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 4
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 2083
    const-string v1, "qaz"

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->upJsonStr:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$51(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "==="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2084
    iget-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->upJsonStr:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceUpdate;->access$51(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v0

    .line 2085
    .local v0, "jsonData":Ljava/lang/String;
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 2090
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 2091
    if-nez p1, :cond_0

    .line 2096
    :goto_0
    return-void

    .line 2094
    :cond_0
    const-string v0, "qaz"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "result="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2095
    invoke-direct {p0, p1}, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->ShowResult7(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 0

    .prologue
    .line 2075
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 2076
    return-void
.end method
