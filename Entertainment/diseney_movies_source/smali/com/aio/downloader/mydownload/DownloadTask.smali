.class public Lcom/aio/downloader/mydownload/DownloadTask;
.super Ljava/lang/Object;
.source "DownloadTask.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;,
        Lcom/aio/downloader/mydownload/DownloadTask$DeleteClick;,
        Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;,
        Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;
    }
.end annotation


# static fields
.field public static mNotificationManager:Landroid/app/NotificationManager;

.field public static nolist:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static tipsToast:Lcom/aio/downloader/views/TipsToast;


# instance fields
.field private final PDTPAUSE:Ljava/lang/String;

.field private click_time:I

.field private comeDb:Z

.field private db:Lnet/tsz/afinal/FinalDBChen;

.field private down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

.field private downloadFile:Lcom/aio/downloader/mydownload/DownloadFile;

.field downloadingbBroadcastReceiver:Landroid/content/BroadcastReceiver;

.field private ds:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private mContext:Landroid/content/Context;

.field private mc:Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;

.field private onDeleteTaskListener:Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;

.field pdtpause:Landroid/content/BroadcastReceiver;

.field private screenWidth:I

.field private typeFace:Landroid/graphics/Typeface;

.field private view:Landroid/view/View;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 73
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/aio/downloader/mydownload/DownloadTask;->nolist:Ljava/util/List;

    .line 197
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/view/View;Lcom/aio/downloader/mydownload/DownloadMovieItem;Z)V
    .locals 5
    .param p1, "mContext"    # Landroid/content/Context;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .param p4, "comeDb"    # Z

    .prologue
    .line 204
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 72
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/aio/downloader/mydownload/DownloadTask;->typeFace:Landroid/graphics/Typeface;

    .line 74
    const/4 v3, 0x0

    iput v3, p0, Lcom/aio/downloader/mydownload/DownloadTask;->click_time:I

    .line 76
    const-string v3, "pdtpause"

    iput-object v3, p0, Lcom/aio/downloader/mydownload/DownloadTask;->PDTPAUSE:Ljava/lang/String;

    .line 78
    new-instance v3, Lcom/aio/downloader/mydownload/DownloadTask$1;

    invoke-direct {v3, p0}, Lcom/aio/downloader/mydownload/DownloadTask$1;-><init>(Lcom/aio/downloader/mydownload/DownloadTask;)V

    iput-object v3, p0, Lcom/aio/downloader/mydownload/DownloadTask;->pdtpause:Landroid/content/BroadcastReceiver;

    .line 137
    new-instance v3, Lcom/aio/downloader/mydownload/DownloadTask$2;

    invoke-direct {v3, p0}, Lcom/aio/downloader/mydownload/DownloadTask$2;-><init>(Lcom/aio/downloader/mydownload/DownloadTask;)V

    iput-object v3, p0, Lcom/aio/downloader/mydownload/DownloadTask;->downloadingbBroadcastReceiver:Landroid/content/BroadcastReceiver;

    .line 206
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;

    .line 207
    iput-object p2, p0, Lcom/aio/downloader/mydownload/DownloadTask;->view:Landroid/view/View;

    .line 208
    iput-object p3, p0, Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 209
    iput-boolean p4, p0, Lcom/aio/downloader/mydownload/DownloadTask;->comeDb:Z

    .line 210
    const v3, 0x7f07027d

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 211
    .local v0, "del":Landroid/widget/ImageView;
    new-instance v3, Lcom/aio/downloader/mydownload/DownloadTask$DeleteClick;

    invoke-direct {v3, p0}, Lcom/aio/downloader/mydownload/DownloadTask$DeleteClick;-><init>(Lcom/aio/downloader/mydownload/DownloadTask;)V

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 212
    new-instance v3, Lnet/tsz/afinal/FinalDBChen;

    const-string v4, "download2.db"

    invoke-virtual {p1, v4}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v4

    .line 213
    invoke-virtual {v4}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, p1, v4}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 212
    iput-object v3, p0, Lcom/aio/downloader/mydownload/DownloadTask;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 214
    invoke-virtual {p0, p3, p2}, Lcom/aio/downloader/mydownload/DownloadTask;->gotoDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;Landroid/view/View;)V

    .line 216
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 217
    .local v1, "intentFilter":Landroid/content/IntentFilter;
    const-string v3, "downloadingbBroadcastReceiver"

    invoke-virtual {v1, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 218
    iget-object v3, p0, Lcom/aio/downloader/mydownload/DownloadTask;->downloadingbBroadcastReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p1, v3, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 220
    new-instance v2, Landroid/content/IntentFilter;

    invoke-direct {v2}, Landroid/content/IntentFilter;-><init>()V

    .line 221
    .local v2, "intentFilter_pdt":Landroid/content/IntentFilter;
    const-string v3, "pdtpause"

    invoke-virtual {v2, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 222
    iget-object v3, p0, Lcom/aio/downloader/mydownload/DownloadTask;->pdtpause:Landroid/content/BroadcastReceiver;

    invoke-virtual {p1, v3, v2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 225
    const-string v3, "notification"

    invoke-virtual {p1, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    .line 224
    check-cast v3, Landroid/app/NotificationManager;

    sput-object v3, Lcom/aio/downloader/mydownload/DownloadTask;->mNotificationManager:Landroid/app/NotificationManager;

    .line 227
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v3

    .line 228
    const-string v4, "Roboto-Light.ttf"

    .line 227
    invoke-static {v3, v4}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v3

    iput-object v3, p0, Lcom/aio/downloader/mydownload/DownloadTask;->typeFace:Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 233
    :goto_0
    return-void

    .line 230
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask;->mc:Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/view/View;
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask;->view:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/mydownload/DownloadTask;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 1020
    invoke-direct {p0, p1, p2}, Lcom/aio/downloader/mydownload/DownloadTask;->showTips(ILjava/lang/String;)V

    return-void
.end method

.method static synthetic access$11(Lcom/aio/downloader/mydownload/DownloadTask;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 198
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadTask;->ds:Ljava/util/List;

    return-void
.end method

.method static synthetic access$12(Lcom/aio/downloader/mydownload/DownloadTask;)Ljava/util/List;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask;->ds:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/mydownload/DownloadTask;)I
    .locals 1

    .prologue
    .line 74
    iget v0, p0, Lcom/aio/downloader/mydownload/DownloadTask;->click_time:I

    return v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/mydownload/DownloadTask;I)V
    .locals 0

    .prologue
    .line 74
    iput p1, p0, Lcom/aio/downloader/mydownload/DownloadTask;->click_time:I

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;
    .locals 1

    .prologue
    .line 362
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask;->onDeleteTaskListener:Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/mydownload/DownloadTask;I)V
    .locals 0

    .prologue
    .line 364
    iput p1, p0, Lcom/aio/downloader/mydownload/DownloadTask;->screenWidth:I

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/mydownload/DownloadTask;)I
    .locals 1

    .prologue
    .line 364
    iget v0, p0, Lcom/aio/downloader/mydownload/DownloadTask;->screenWidth:I

    return v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/graphics/Typeface;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask;->typeFace:Landroid/graphics/Typeface;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/mydownload/DownloadTask;Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;)V
    .locals 0

    .prologue
    .line 195
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadTask;->mc:Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;

    return-void
.end method

.method static synthetic access$9(Lcom/aio/downloader/mydownload/DownloadTask;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method private showTips(ILjava/lang/String;)V
    .locals 2
    .param p1, "iconResId"    # I
    .param p2, "msgResId"    # Ljava/lang/String;

    .prologue
    .line 1021
    sget-object v0, Lcom/aio/downloader/mydownload/DownloadTask;->tipsToast:Lcom/aio/downloader/views/TipsToast;

    if-eqz v0, :cond_1

    .line 1022
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-ge v0, v1, :cond_0

    .line 1023
    sget-object v0, Lcom/aio/downloader/mydownload/DownloadTask;->tipsToast:Lcom/aio/downloader/views/TipsToast;

    invoke-virtual {v0}, Lcom/aio/downloader/views/TipsToast;->cancel()V

    .line 1029
    :cond_0
    :goto_0
    sget-object v0, Lcom/aio/downloader/mydownload/DownloadTask;->tipsToast:Lcom/aio/downloader/views/TipsToast;

    invoke-virtual {v0}, Lcom/aio/downloader/views/TipsToast;->show()V

    .line 1030
    sget-object v0, Lcom/aio/downloader/mydownload/DownloadTask;->tipsToast:Lcom/aio/downloader/views/TipsToast;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/TipsToast;->setIcon(I)V

    .line 1031
    sget-object v0, Lcom/aio/downloader/mydownload/DownloadTask;->tipsToast:Lcom/aio/downloader/views/TipsToast;

    invoke-virtual {v0, p2}, Lcom/aio/downloader/views/TipsToast;->setText(Ljava/lang/CharSequence;)V

    .line 1032
    return-void

    .line 1026
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;

    .line 1027
    const/4 v1, 0x0

    .line 1026
    invoke-static {v0, p2, v1}, Lcom/aio/downloader/views/TipsToast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/aio/downloader/views/TipsToast;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/mydownload/DownloadTask;->tipsToast:Lcom/aio/downloader/views/TipsToast;

    goto :goto_0
.end method


# virtual methods
.method public BufferedReader(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 999
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1000
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-virtual {v1}, Ljava/io/File;->isDirectory()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1001
    :cond_0
    new-instance v4, Ljava/io/FileNotFoundException;

    invoke-direct {v4}, Ljava/io/FileNotFoundException;-><init>()V

    throw v4

    .line 1002
    :cond_1
    new-instance v0, Ljava/io/BufferedReader;

    new-instance v4, Ljava/io/FileReader;

    invoke-direct {v4, v1}, Ljava/io/FileReader;-><init>(Ljava/io/File;)V

    invoke-direct {v0, v4}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 1003
    .local v0, "br":Ljava/io/BufferedReader;
    const/4 v3, 0x0

    .line 1004
    .local v3, "temp":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    .line 1005
    .local v2, "sb":Ljava/lang/StringBuffer;
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    .line 1006
    :cond_2
    if-nez v3, :cond_3

    .line 1016
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V

    .line 1017
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    :goto_0
    return-object v4

    .line 1007
    :cond_3
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1009
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    .line 1011
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    const/16 v5, 0x64

    if-le v4, v5, :cond_2

    .line 1013
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_0
.end method

.method protected excuteSuCMD(Ljava/lang/String;)I
    .locals 6
    .param p1, "cmd"    # Ljava/lang/String;

    .prologue
    .line 1037
    :try_start_0
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v4

    const-string v5, "su"

    invoke-virtual {v4, v5}, Ljava/lang/Runtime;->exec(Ljava/lang/String;)Ljava/lang/Process;

    move-result-object v2

    .line 1038
    .local v2, "process":Ljava/lang/Process;
    new-instance v0, Ljava/io/DataOutputStream;

    .line 1039
    invoke-virtual {v2}, Ljava/lang/Process;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v4

    .line 1038
    invoke-direct {v0, v4}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 1041
    .local v0, "dos":Ljava/io/DataOutputStream;
    const-string v4, "export LD_LIBRARY_PATH=/vendor/lib:/system/lib\n"

    invoke-virtual {v0, v4}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 1042
    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    .line 1043
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 1044
    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V

    .line 1045
    const-string v4, "exit\n"

    invoke-virtual {v0, v4}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 1046
    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V

    .line 1047
    invoke-virtual {v2}, Ljava/lang/Process;->waitFor()I

    .line 1048
    invoke-virtual {v2}, Ljava/lang/Process;->exitValue()I

    move-result v3

    .line 1049
    .local v3, "result":I
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    .line 1052
    .end local v0    # "dos":Ljava/io/DataOutputStream;
    .end local v2    # "process":Ljava/lang/Process;
    .end local v3    # "result":I
    :goto_0
    return v4

    .line 1050
    :catch_0
    move-exception v1

    .line 1051
    .local v1, "localException":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 1052
    const/4 v4, -0x1

    goto :goto_0
.end method

.method public getOnDeleteTaskListener()Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;
    .locals 1

    .prologue
    .line 256
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask;->onDeleteTaskListener:Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;

    return-object v0
.end method

.method public gotoDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;Landroid/view/View;)V
    .locals 5
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 236
    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDownloadUrl()Ljava/lang/String;

    move-result-object v2

    .line 237
    .local v2, "url":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v1

    .line 238
    .local v1, "path":Ljava/lang/String;
    iget-boolean v3, p0, Lcom/aio/downloader/mydownload/DownloadTask;->comeDb:Z

    if-eqz v3, :cond_0

    .line 241
    const v3, 0x7f070276

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 243
    .local v0, "bt":Landroid/widget/TextView;
    const-string v3, "Start"

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 245
    new-instance v3, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;

    const/16 v4, 0xd

    invoke-direct {v3, p0, v4, p1, v0}, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;-><init>(Lcom/aio/downloader/mydownload/DownloadTask;ILcom/aio/downloader/mydownload/DownloadMovieItem;Landroid/widget/TextView;)V

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 253
    .end local v0    # "bt":Landroid/widget/TextView;
    :goto_0
    return-void

    .line 249
    :cond_0
    new-instance v3, Lcom/aio/downloader/mydownload/DownloadFile;

    invoke-direct {v3}, Lcom/aio/downloader/mydownload/DownloadFile;-><init>()V

    .line 250
    new-instance v4, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    invoke-direct {v4, p0, p2, p1}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;-><init>(Lcom/aio/downloader/mydownload/DownloadTask;Landroid/view/View;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 249
    invoke-virtual {v3, v2, v1, v4}, Lcom/aio/downloader/mydownload/DownloadFile;->startDownloadFileByUrl(Ljava/lang/String;Ljava/lang/String;Lnet/tsz/afinal/http/AjaxCallBack;)Lcom/aio/downloader/mydownload/DownloadFile;

    move-result-object v3

    iput-object v3, p0, Lcom/aio/downloader/mydownload/DownloadTask;->downloadFile:Lcom/aio/downloader/mydownload/DownloadFile;

    .line 251
    iget-object v3, p0, Lcom/aio/downloader/mydownload/DownloadTask;->downloadFile:Lcom/aio/downloader/mydownload/DownloadFile;

    invoke-virtual {p1, v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadFile(Lcom/aio/downloader/mydownload/DownloadFile;)V

    goto :goto_0
.end method

.method public is_valid_file()Ljava/lang/Boolean;
    .locals 5

    .prologue
    .line 949
    const-wide/16 v1, 0x1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 951
    .local v0, "file_size":Ljava/lang/Long;
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFileSize()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 976
    :goto_0
    const-string v1, "sdsd"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "file_size"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 977
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    const-wide/16 v3, 0x7d0

    cmp-long v1, v1, v3

    if-gez v1, :cond_0

    .line 978
    const-string v1, "abcd"

    const-string v2, "\u5c0f\u4e8e2kb"

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 979
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 994
    :goto_1
    return-object v1

    :cond_0
    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    goto :goto_1

    .line 952
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public setOnDeleteTaskListener(Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;)V
    .locals 0
    .param p1, "onDeleteTaskListener"    # Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;

    .prologue
    .line 261
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadTask;->onDeleteTaskListener:Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;

    .line 262
    return-void
.end method
