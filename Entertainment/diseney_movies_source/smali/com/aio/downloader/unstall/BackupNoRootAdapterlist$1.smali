.class Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;
.super Ljava/lang/Object;
.source "BackupNoRootAdapterlist.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private apkFile:Ljava/io/File;

.field private backupFile:Ljava/io/File;

.field final synthetic this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    iput p2, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->val$position:I

    .line 140
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;)Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 17
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 147
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$0(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Lcom/aio/downloader/db/TypeDbUtilsBackup;

    move-result-object v1

    if-nez v1, :cond_0

    .line 148
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    new-instance v2, Lcom/aio/downloader/db/TypeDbUtilsBackup;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->context:Landroid/content/Context;
    invoke-static {v4}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$1(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Landroid/content/Context;

    move-result-object v4

    invoke-direct {v2, v4}, Lcom/aio/downloader/db/TypeDbUtilsBackup;-><init>(Landroid/content/Context;)V

    invoke-static {v1, v2}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$2(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;Lcom/aio/downloader/db/TypeDbUtilsBackup;)V

    .line 151
    :cond_0
    const/4 v14, 0x0

    .line 153
    .local v14, "pI":Landroid/content/pm/PackageInfo;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->context:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$1(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 154
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->infos:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$3(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Ljava/util/List;

    move-result-object v1

    move-object/from16 v0, p0

    iget v4, v0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->val$position:I

    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v1}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v1

    const/4 v4, 0x0

    .line 153
    invoke-virtual {v2, v1, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v14

    .line 159
    :goto_0
    if-eqz v14, :cond_1

    .line 161
    iget-object v1, v14, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 162
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$1(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 161
    invoke-virtual {v1, v2}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v1

    .line 162
    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    .line 164
    .local v3, "appName":Ljava/lang/String;
    iget-object v1, v14, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$1(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Landroid/content/Context;

    move-result-object v2

    .line 165
    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 164
    invoke-virtual {v1, v2}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v12

    .line 167
    .local v12, "icon":Landroid/graphics/drawable/Drawable;
    iget-object v1, v14, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 169
    .local v7, "Version":Ljava/lang/String;
    new-instance v1, Ljava/io/File;

    iget-object v2, v14, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v2, v2, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 170
    invoke-virtual {v1}, Ljava/io/File;->length()J

    move-result-wide v1

    const-wide/16 v15, 0x400

    .line 169
    div-long v8, v1, v15

    .line 171
    .local v8, "appSize":J
    long-to-double v1, v8

    const-wide/high16 v15, 0x4090000000000000L    # 1024.0

    div-double/2addr v1, v15

    const-wide/high16 v15, 0x4059000000000000L    # 100.0

    mul-double/2addr v1, v15

    double-to-int v1, v1

    int-to-double v1, v1

    const-wide/high16 v15, 0x4059000000000000L    # 100.0

    div-double/2addr v1, v15

    double-to-float v13, v1

    .line 172
    .local v13, "lastSize":F
    const/4 v6, 0x0

    .line 173
    .local v6, "Size":Ljava/lang/String;
    const-wide/16 v1, 0x400

    cmp-long v1, v8, v1

    if-ltz v1, :cond_2

    .line 174
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v13}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "MB"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 178
    :goto_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    # invokes: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->drawable2Bitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    invoke-static {v1, v12}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$4(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v10

    .line 179
    .local v10, "drawable2Bitmap":Landroid/graphics/Bitmap;
    invoke-static {v10}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->bitmaptoString(Landroid/graphics/Bitmap;)Ljava/lang/String;

    move-result-object v5

    .line 181
    .local v5, "bitmaptoString":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$0(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Lcom/aio/downloader/db/TypeDbUtilsBackup;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->infos:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$3(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Ljava/util/List;

    move-result-object v2

    move-object/from16 v0, p0

    iget v4, v0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->val$position:I

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v2}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v2

    .line 182
    const-string v4, "game_app"

    .line 181
    invoke-virtual/range {v1 .. v7}, Lcom/aio/downloader/db/TypeDbUtilsBackup;->insertApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    .end local v3    # "appName":Ljava/lang/String;
    .end local v5    # "bitmaptoString":Ljava/lang/String;
    .end local v6    # "Size":Ljava/lang/String;
    .end local v7    # "Version":Ljava/lang/String;
    .end local v8    # "appSize":J
    .end local v10    # "drawable2Bitmap":Landroid/graphics/Bitmap;
    .end local v12    # "icon":Landroid/graphics/drawable/Drawable;
    .end local v13    # "lastSize":F
    :cond_1
    new-instance v1, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;

    move-object/from16 v0, p0

    invoke-direct {v1, v0}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;-><init>(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;)V

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    .line 220
    invoke-virtual {v1, v2}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 283
    return-void

    .line 155
    :catch_0
    move-exception v11

    .line 156
    .local v11, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v11}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_0

    .line 176
    .end local v11    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v3    # "appName":Ljava/lang/String;
    .restart local v6    # "Size":Ljava/lang/String;
    .restart local v7    # "Version":Ljava/lang/String;
    .restart local v8    # "appSize":J
    .restart local v12    # "icon":Landroid/graphics/drawable/Drawable;
    .restart local v13    # "lastSize":F
    :cond_2
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v8, v9}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "KB"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_1
.end method
