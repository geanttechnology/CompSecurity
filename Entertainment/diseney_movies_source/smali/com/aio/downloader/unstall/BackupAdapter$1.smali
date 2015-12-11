.class Lcom/aio/downloader/unstall/BackupAdapter$1;
.super Ljava/lang/Object;
.source "BackupAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/unstall/BackupAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private apkFile:Ljava/io/File;

.field private backupFile:Ljava/io/File;

.field final synthetic this$0:Lcom/aio/downloader/unstall/BackupAdapter;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/BackupAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/unstall/BackupAdapter$1;->this$0:Lcom/aio/downloader/unstall/BackupAdapter;

    iput p2, p0, Lcom/aio/downloader/unstall/BackupAdapter$1;->val$position:I

    .line 137
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/unstall/BackupAdapter$1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupAdapter$1;->apkFile:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/unstall/BackupAdapter$1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupAdapter$1;->backupFile:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/unstall/BackupAdapter$1;)Lcom/aio/downloader/unstall/BackupAdapter;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupAdapter$1;->this$0:Lcom/aio/downloader/unstall/BackupAdapter;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 145
    iget-object v2, p0, Lcom/aio/downloader/unstall/BackupAdapter$1;->this$0:Lcom/aio/downloader/unstall/BackupAdapter;

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter;->infos:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/unstall/BackupAdapter;->access$0(Lcom/aio/downloader/unstall/BackupAdapter;)Ljava/util/List;

    move-result-object v2

    iget v3, p0, Lcom/aio/downloader/unstall/BackupAdapter$1;->val$position:I

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v2}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v1

    .line 146
    .local v1, "myPackageNmae":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "/data/app/"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "-1.apk"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 147
    .local v0, "apkPath":Ljava/lang/String;
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v2, p0, Lcom/aio/downloader/unstall/BackupAdapter$1;->apkFile:Ljava/io/File;

    .line 150
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/unstall/BackupAdapter$1;->apkFile:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_0

    .line 151
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "/data/app/"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "-2.apk"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 152
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v2, p0, Lcom/aio/downloader/unstall/BackupAdapter$1;->apkFile:Ljava/io/File;

    .line 153
    iget-object v2, p0, Lcom/aio/downloader/unstall/BackupAdapter$1;->apkFile:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_0

    .line 155
    iget-object v2, p0, Lcom/aio/downloader/unstall/BackupAdapter$1;->this$0:Lcom/aio/downloader/unstall/BackupAdapter;

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/unstall/BackupAdapter;->access$1(Lcom/aio/downloader/unstall/BackupAdapter;)Landroid/content/Context;

    move-result-object v2

    const-string v3, "This app does not support backup."

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->show()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 162
    :cond_0
    :goto_0
    new-instance v2, Ljava/io/File;

    new-instance v3, Ljava/lang/StringBuilder;

    .line 163
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 164
    const-string v4, "/AIO_BACKUPAPP"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 165
    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 166
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 167
    const-string v4, ".apk"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 162
    iput-object v2, p0, Lcom/aio/downloader/unstall/BackupAdapter$1;->backupFile:Ljava/io/File;

    .line 169
    new-instance v2, Lcom/aio/downloader/unstall/BackupAdapter$1$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/unstall/BackupAdapter$1$1;-><init>(Lcom/aio/downloader/unstall/BackupAdapter$1;)V

    new-array v3, v5, [Ljava/lang/Void;

    .line 201
    invoke-virtual {v2, v3}, Lcom/aio/downloader/unstall/BackupAdapter$1$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 203
    return-void

    .line 159
    :catch_0
    move-exception v2

    goto :goto_0
.end method
