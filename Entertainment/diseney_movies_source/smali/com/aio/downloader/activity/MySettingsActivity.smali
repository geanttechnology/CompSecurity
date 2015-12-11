.class public Lcom/aio/downloader/activity/MySettingsActivity;
.super Landroid/app/Activity;
.source "MySettingsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;,
        Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;
    }
.end annotation


# static fields
.field public static final UPDATE_TAG:I = 0x234

.field private static typeFace:Landroid/graphics/Typeface;


# instance fields
.field private aboutus:Landroid/widget/RelativeLayout;

.field private checkforupdate:Landroid/widget/RelativeLayout;

.field private cleancache:Landroid/widget/RelativeLayout;

.field private contactus:Landroid/widget/RelativeLayout;

.field private downloadingdialog:Lcom/aio/downloader/dialog/DownloadsettingDialog;

.field private downloadpath:Landroid/widget/RelativeLayout;

.field private downloadsetting:Landroid/widget/RelativeLayout;

.field private fan:Lcom/aio/downloader/views/LImageButton;

.field handler:Landroid/os/Handler;

.field private helpus:Landroid/widget/RelativeLayout;

.field private imageLoader:Lcom/nostra13/universalimageloader/core/ImageLoader;

.field private mysettingtv:Landroid/widget/TextView;

.field private newVersionUrl:Ljava/lang/String;

.field private notisetting:Landroid/widget/RelativeLayout;

.field private spnetwork:Landroid/content/SharedPreferences;

.field private updateDialog:Lcom/aio/downloader/dialog/UpdateDialogVerison;

.field private wifi_download:Landroid/widget/ToggleButton;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 126
    const/4 v0, 0x0

    sput-object v0, Lcom/aio/downloader/activity/MySettingsActivity;->typeFace:Landroid/graphics/Typeface;

    .line 128
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 51
    new-instance v0, Lcom/aio/downloader/activity/MySettingsActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MySettingsActivity$1;-><init>(Lcom/aio/downloader/activity/MySettingsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->handler:Landroid/os/Handler;

    .line 115
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->imageLoader:Lcom/nostra13/universalimageloader/core/ImageLoader;

    .line 129
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->newVersionUrl:Ljava/lang/String;

    .line 49
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MySettingsActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 129
    iput-object p1, p0, Lcom/aio/downloader/activity/MySettingsActivity;->newVersionUrl:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/MySettingsActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->newVersionUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/MySettingsActivity;)Lcom/aio/downloader/dialog/UpdateDialogVerison;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->updateDialog:Lcom/aio/downloader/dialog/UpdateDialogVerison;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/MySettingsActivity;Lcom/aio/downloader/dialog/UpdateDialogVerison;)V
    .locals 0

    .prologue
    .line 130
    iput-object p1, p0, Lcom/aio/downloader/activity/MySettingsActivity;->updateDialog:Lcom/aio/downloader/dialog/UpdateDialogVerison;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/MySettingsActivity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->spnetwork:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/MySettingsActivity;)Lcom/aio/downloader/dialog/DownloadsettingDialog;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->downloadingdialog:Lcom/aio/downloader/dialog/DownloadsettingDialog;

    return-object v0
.end method

.method private buildListerrn()V
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->fan:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 171
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->downloadsetting:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 172
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->cleancache:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 173
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->checkforupdate:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 174
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->contactus:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 175
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->aboutus:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 176
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->downloadpath:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 177
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->helpus:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 178
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->notisetting:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 181
    return-void
.end method

.method private init()V
    .locals 2

    .prologue
    .line 149
    const-string v0, "network"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/aio/downloader/activity/MySettingsActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->spnetwork:Landroid/content/SharedPreferences;

    .line 151
    const v0, 0x7f07014e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->fan:Lcom/aio/downloader/views/LImageButton;

    .line 152
    const v0, 0x7f070310

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->mysettingtv:Landroid/widget/TextView;

    .line 158
    const v0, 0x7f070312

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->downloadsetting:Landroid/widget/RelativeLayout;

    .line 159
    const v0, 0x7f070314

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->cleancache:Landroid/widget/RelativeLayout;

    .line 160
    const v0, 0x7f070315

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->checkforupdate:Landroid/widget/RelativeLayout;

    .line 161
    const v0, 0x7f070316

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->contactus:Landroid/widget/RelativeLayout;

    .line 162
    const v0, 0x7f070317

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->aboutus:Landroid/widget/RelativeLayout;

    .line 163
    const v0, 0x7f070318

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->downloadpath:Landroid/widget/RelativeLayout;

    .line 164
    const v0, 0x7f070319

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->helpus:Landroid/widget/RelativeLayout;

    .line 165
    const v0, 0x7f070313

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity;->notisetting:Landroid/widget/RelativeLayout;

    .line 166
    const v0, 0x7f070311

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 167
    return-void
.end method


# virtual methods
.method public delAllFile(Ljava/lang/String;)V
    .locals 6
    .param p1, "filePath"    # Ljava/lang/String;

    .prologue
    .line 486
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 487
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_1

    .line 510
    :cond_0
    return-void

    .line 490
    :cond_1
    invoke-virtual {v0}, Ljava/io/File;->isDirectory()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 493
    invoke-virtual {v0}, Ljava/io/File;->list()[Ljava/lang/String;

    move-result-object v3

    .line 494
    .local v3, "tempList":[Ljava/lang/String;
    const/4 v2, 0x0

    .line 495
    .local v2, "temp":Ljava/io/File;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v4, v3

    if-ge v1, v4, :cond_0

    .line 496
    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {p1, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 497
    new-instance v2, Ljava/io/File;

    .end local v2    # "temp":Ljava/io/File;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v5, v3, v1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 501
    .restart local v2    # "temp":Ljava/io/File;
    :goto_1
    invoke-virtual {v2}, Ljava/io/File;->isFile()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 502
    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    .line 504
    :cond_2
    invoke-virtual {v2}, Ljava/io/File;->isDirectory()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 505
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    aget-object v5, v3, v1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/MySettingsActivity;->delAllFile(Ljava/lang/String;)V

    .line 506
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    aget-object v5, v3, v1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/MySettingsActivity;->delFolder(Ljava/lang/String;)V

    .line 495
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 499
    :cond_4
    new-instance v2, Ljava/io/File;

    .end local v2    # "temp":Ljava/io/File;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    aget-object v5, v3, v1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .restart local v2    # "temp":Ljava/io/File;
    goto :goto_1
.end method

.method public delFolder(Ljava/lang/String;)V
    .locals 6
    .param p1, "folderPath"    # Ljava/lang/String;

    .prologue
    .line 469
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MySettingsActivity;->delAllFile(Ljava/lang/String;)V

    .line 470
    move-object v1, p1

    .line 471
    .local v1, "filePath":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v1

    .line 472
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 473
    .local v2, "myFilePath":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    .line 475
    const-string v4, "Data"

    .line 476
    const/4 v5, 0x0

    .line 475
    invoke-virtual {p0, v4, v5}, Lcom/aio/downloader/activity/MySettingsActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v3

    .line 477
    .local v3, "sp":Landroid/content/SharedPreferences;
    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    invoke-interface {v4}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 483
    .end local v1    # "filePath":Ljava/lang/String;
    .end local v2    # "myFilePath":Ljava/io/File;
    .end local v3    # "sp":Landroid/content/SharedPreferences;
    :goto_0
    return-void

    .line 478
    :catch_0
    move-exception v0

    .line 480
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 14
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 185
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v11

    sparse-switch v11, :sswitch_data_0

    .line 366
    :goto_0
    return-void

    .line 187
    :sswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MySettingsActivity;->finish()V

    goto :goto_0

    .line 191
    :sswitch_1
    new-instance v11, Lcom/aio/downloader/dialog/DownloadsettingDialog;

    .line 192
    const v12, 0x7f0c000e

    invoke-direct {v11, p0, v12}, Lcom/aio/downloader/dialog/DownloadsettingDialog;-><init>(Landroid/content/Context;I)V

    .line 191
    iput-object v11, p0, Lcom/aio/downloader/activity/MySettingsActivity;->downloadingdialog:Lcom/aio/downloader/dialog/DownloadsettingDialog;

    .line 193
    iget-object v11, p0, Lcom/aio/downloader/activity/MySettingsActivity;->downloadingdialog:Lcom/aio/downloader/dialog/DownloadsettingDialog;

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Lcom/aio/downloader/dialog/DownloadsettingDialog;->setCanceledOnTouchOutside(Z)V

    .line 194
    iget-object v11, p0, Lcom/aio/downloader/activity/MySettingsActivity;->downloadingdialog:Lcom/aio/downloader/dialog/DownloadsettingDialog;

    invoke-virtual {v11}, Lcom/aio/downloader/dialog/DownloadsettingDialog;->show()V

    .line 195
    iget-object v11, p0, Lcom/aio/downloader/activity/MySettingsActivity;->downloadingdialog:Lcom/aio/downloader/dialog/DownloadsettingDialog;

    .line 196
    const v12, 0x7f070195

    invoke-virtual {v11, v12}, Lcom/aio/downloader/dialog/DownloadsettingDialog;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/ToggleButton;

    .line 195
    iput-object v11, p0, Lcom/aio/downloader/activity/MySettingsActivity;->wifi_download:Landroid/widget/ToggleButton;

    .line 199
    :try_start_0
    iget-object v11, p0, Lcom/aio/downloader/activity/MySettingsActivity;->spnetwork:Landroid/content/SharedPreferences;

    const-string v12, "isopen"

    const/4 v13, 0x0

    invoke-interface {v11, v12, v13}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v11

    if-eqz v11, :cond_0

    .line 200
    iget-object v11, p0, Lcom/aio/downloader/activity/MySettingsActivity;->wifi_download:Landroid/widget/ToggleButton;

    const/4 v12, 0x1

    invoke-virtual {v11, v12}, Landroid/widget/ToggleButton;->setChecked(Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 207
    :goto_1
    iget-object v11, p0, Lcom/aio/downloader/activity/MySettingsActivity;->wifi_download:Landroid/widget/ToggleButton;

    .line 208
    new-instance v12, Lcom/aio/downloader/activity/MySettingsActivity$2;

    invoke-direct {v12, p0}, Lcom/aio/downloader/activity/MySettingsActivity$2;-><init>(Lcom/aio/downloader/activity/MySettingsActivity;)V

    invoke-virtual {v11, v12}, Landroid/widget/ToggleButton;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 235
    iget-object v11, p0, Lcom/aio/downloader/activity/MySettingsActivity;->downloadingdialog:Lcom/aio/downloader/dialog/DownloadsettingDialog;

    const v12, 0x7f070197

    invoke-virtual {v11, v12}, Lcom/aio/downloader/dialog/DownloadsettingDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 236
    .local v1, "btnok":Landroid/widget/Button;
    iget-object v11, p0, Lcom/aio/downloader/activity/MySettingsActivity;->downloadingdialog:Lcom/aio/downloader/dialog/DownloadsettingDialog;

    .line 237
    const v12, 0x7f070196

    invoke-virtual {v11, v12}, Lcom/aio/downloader/dialog/DownloadsettingDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 236
    check-cast v0, Landroid/widget/Button;

    .line 238
    .local v0, "btncancel":Landroid/widget/Button;
    new-instance v11, Lcom/aio/downloader/activity/MySettingsActivity$3;

    invoke-direct {v11, p0}, Lcom/aio/downloader/activity/MySettingsActivity$3;-><init>(Lcom/aio/downloader/activity/MySettingsActivity;)V

    invoke-virtual {v1, v11}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 247
    new-instance v11, Lcom/aio/downloader/activity/MySettingsActivity$4;

    invoke-direct {v11, p0}, Lcom/aio/downloader/activity/MySettingsActivity$4;-><init>(Lcom/aio/downloader/activity/MySettingsActivity;)V

    invoke-virtual {v0, v11}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 202
    .end local v0    # "btncancel":Landroid/widget/Button;
    .end local v1    # "btnok":Landroid/widget/Button;
    :cond_0
    :try_start_1
    iget-object v11, p0, Lcom/aio/downloader/activity/MySettingsActivity;->wifi_download:Landroid/widget/ToggleButton;

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Landroid/widget/ToggleButton;->setChecked(Z)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 204
    :catch_0
    move-exception v11

    goto :goto_1

    .line 259
    :sswitch_2
    new-instance v11, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;

    invoke-direct {v11, p0}, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;-><init>(Lcom/aio/downloader/activity/MySettingsActivity;)V

    const/4 v12, 0x0

    new-array v12, v12, [Ljava/lang/Void;

    invoke-virtual {v11, v12}, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 260
    iget-object v11, p0, Lcom/aio/downloader/activity/MySettingsActivity;->imageLoader:Lcom/nostra13/universalimageloader/core/ImageLoader;

    invoke-virtual {v11}, Lcom/nostra13/universalimageloader/core/ImageLoader;->clearDiscCache()V

    goto/16 :goto_0

    .line 263
    :sswitch_3
    new-instance v11, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;

    invoke-direct {v11, p0}, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;-><init>(Lcom/aio/downloader/activity/MySettingsActivity;)V

    const/4 v12, 0x0

    new-array v12, v12, [Ljava/lang/Void;

    invoke-virtual {v11, v12}, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 275
    :sswitch_4
    const/4 v11, 0x1

    new-array v5, v11, [Ljava/lang/String;

    const/4 v11, 0x0

    const-string v12, "aio.downloader@yahoo.com.sg"

    aput-object v12, v5, v11

    .line 276
    .local v5, "email":[Ljava/lang/String;
    new-instance v9, Landroid/content/Intent;

    const-string v11, "android.intent.action.SEND"

    invoke-direct {v9, v11}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 277
    .local v9, "intent_email":Landroid/content/Intent;
    const-string v11, "message/rfc822"

    invoke-virtual {v9, v11}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 278
    const-string v11, "android.intent.extra.EMAIL"

    invoke-virtual {v9, v11, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 279
    const-string v11, "E-mail"

    invoke-static {v9, v11}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v11

    invoke-virtual {p0, v11}, Lcom/aio/downloader/activity/MySettingsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 283
    .end local v5    # "email":[Ljava/lang/String;
    .end local v9    # "intent_email":Landroid/content/Intent;
    :sswitch_5
    new-instance v2, Lcom/aio/downloader/dialog/AboutCustomDialog;

    .line 284
    const v11, 0x7f0c000e

    .line 283
    invoke-direct {v2, p0, v11}, Lcom/aio/downloader/dialog/AboutCustomDialog;-><init>(Landroid/content/Context;I)V

    .line 285
    .local v2, "dialog":Lcom/aio/downloader/dialog/AboutCustomDialog;
    const/4 v11, 0x0

    invoke-virtual {v2, v11}, Lcom/aio/downloader/dialog/AboutCustomDialog;->setCanceledOnTouchOutside(Z)V

    .line 286
    invoke-virtual {v2}, Lcom/aio/downloader/dialog/AboutCustomDialog;->show()V

    .line 287
    const v11, 0x7f07001e

    invoke-virtual {v2, v11}, Lcom/aio/downloader/dialog/AboutCustomDialog;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/Button;

    .line 288
    .local v10, "ok":Landroid/widget/Button;
    new-instance v11, Lcom/aio/downloader/activity/MySettingsActivity$5;

    invoke-direct {v11, p0, v2}, Lcom/aio/downloader/activity/MySettingsActivity$5;-><init>(Lcom/aio/downloader/activity/MySettingsActivity;Lcom/aio/downloader/dialog/AboutCustomDialog;)V

    invoke-virtual {v10, v11}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_0

    .line 300
    .end local v2    # "dialog":Lcom/aio/downloader/dialog/AboutCustomDialog;
    .end local v10    # "ok":Landroid/widget/Button;
    :sswitch_6
    new-instance v3, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;

    .line 301
    const v11, 0x7f0c000e

    .line 300
    invoke-direct {v3, p0, v11}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;-><init>(Landroid/content/Context;I)V

    .line 302
    .local v3, "downloadpathCustomDialog":Lcom/aio/downloader/dialog/DownloadpathCustomDialog;
    const/4 v11, 0x0

    invoke-virtual {v3, v11}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->setCanceledOnTouchOutside(Z)V

    .line 303
    invoke-virtual {v3}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->show()V

    .line 305
    const v11, 0x7f070194

    invoke-virtual {v3, v11}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 304
    check-cast v4, Landroid/widget/Button;

    .line 307
    .local v4, "downloadpathCustomDialogok":Landroid/widget/Button;
    new-instance v11, Lcom/aio/downloader/activity/MySettingsActivity$6;

    invoke-direct {v11, p0, v3}, Lcom/aio/downloader/activity/MySettingsActivity$6;-><init>(Lcom/aio/downloader/activity/MySettingsActivity;Lcom/aio/downloader/dialog/DownloadpathCustomDialog;)V

    invoke-virtual {v4, v11}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_0

    .line 320
    .end local v3    # "downloadpathCustomDialog":Lcom/aio/downloader/dialog/DownloadpathCustomDialog;
    .end local v4    # "downloadpathCustomDialogok":Landroid/widget/Button;
    :sswitch_7
    new-instance v6, Lcom/aio/downloader/dialog/HelpusShareDialog;

    .line 321
    const v11, 0x7f0c000e

    .line 320
    invoke-direct {v6, p0, v11}, Lcom/aio/downloader/dialog/HelpusShareDialog;-><init>(Landroid/content/Context;I)V

    .line 322
    .local v6, "helpusShareDialog":Lcom/aio/downloader/dialog/HelpusShareDialog;
    const/4 v11, 0x0

    invoke-virtual {v6, v11}, Lcom/aio/downloader/dialog/HelpusShareDialog;->setCanceledOnTouchOutside(Z)V

    .line 323
    invoke-virtual {v6}, Lcom/aio/downloader/dialog/HelpusShareDialog;->show()V

    .line 325
    const v11, 0x7f070222

    invoke-virtual {v6, v11}, Lcom/aio/downloader/dialog/HelpusShareDialog;->findViewById(I)Landroid/view/View;

    move-result-object v7

    .line 324
    check-cast v7, Landroid/widget/Button;

    .line 327
    .local v7, "helpuscancel":Landroid/widget/Button;
    const v11, 0x7f070223

    invoke-virtual {v6, v11}, Lcom/aio/downloader/dialog/HelpusShareDialog;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .line 326
    check-cast v8, Landroid/widget/Button;

    .line 328
    .local v8, "helpusok":Landroid/widget/Button;
    new-instance v11, Lcom/aio/downloader/activity/MySettingsActivity$7;

    invoke-direct {v11, p0, v6}, Lcom/aio/downloader/activity/MySettingsActivity$7;-><init>(Lcom/aio/downloader/activity/MySettingsActivity;Lcom/aio/downloader/dialog/HelpusShareDialog;)V

    invoke-virtual {v7, v11}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 338
    new-instance v11, Lcom/aio/downloader/activity/MySettingsActivity$8;

    invoke-direct {v11, p0, v6}, Lcom/aio/downloader/activity/MySettingsActivity$8;-><init>(Lcom/aio/downloader/activity/MySettingsActivity;Lcom/aio/downloader/dialog/HelpusShareDialog;)V

    invoke-virtual {v8, v11}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_0

    .line 356
    .end local v6    # "helpusShareDialog":Lcom/aio/downloader/dialog/HelpusShareDialog;
    .end local v7    # "helpuscancel":Landroid/widget/Button;
    .end local v8    # "helpusok":Landroid/widget/Button;
    :sswitch_8
    new-instance v11, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MySettingsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v12

    const-class v13, Lcom/aio/downloader/activity/Noti_Set_Activity;

    invoke-direct {v11, v12, v13}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v11}, Lcom/aio/downloader/activity/MySettingsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 362
    :sswitch_9
    new-instance v11, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MySettingsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v12

    const-class v13, Lcom/aio/downloader/activity/FloatControlActivity;

    invoke-direct {v11, v12, v13}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v11}, Lcom/aio/downloader/activity/MySettingsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 185
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f07014e -> :sswitch_0
        0x7f070311 -> :sswitch_9
        0x7f070312 -> :sswitch_1
        0x7f070313 -> :sswitch_8
        0x7f070314 -> :sswitch_2
        0x7f070315 -> :sswitch_3
        0x7f070316 -> :sswitch_4
        0x7f070317 -> :sswitch_5
        0x7f070318 -> :sswitch_6
        0x7f070319 -> :sswitch_7
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 140
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 141
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->requestWindowFeature(I)Z

    .line 142
    const v0, 0x7f030082

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->setContentView(I)V

    .line 143
    invoke-direct {p0}, Lcom/aio/downloader/activity/MySettingsActivity;->init()V

    .line 144
    invoke-direct {p0}, Lcom/aio/downloader/activity/MySettingsActivity;->buildListerrn()V

    .line 146
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 522
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 523
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 524
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 515
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 516
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 517
    return-void
.end method
