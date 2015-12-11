.class public Lcom/aio/downloader/activity/VideoDownloadedActivity;
.super Landroid/app/Activity;
.source "VideoDownloadedActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

.field private appnotice:Landroid/widget/TextView;

.field private dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

.field private filemorevideo:Landroid/widget/ImageView;

.field private l1:Landroid/widget/RelativeLayout;

.field private l2:Landroid/widget/RelativeLayout;

.field private l3:Landroid/widget/RelativeLayout;

.field private l4:Landroid/widget/RelativeLayout;

.field private listdd:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private mBroadcastReceiver_delete:Landroid/content/BroadcastReceiver;

.field private mWindow:Landroid/widget/PopupWindow;

.field private video_lv:Landroid/widget/ListView;

.field private videofan:Landroid/widget/ImageView;

.field private videosuccessful:Landroid/content/BroadcastReceiver;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 35
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 37
    new-instance v0, Lcom/aio/downloader/activity/VideoDownloadedActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/VideoDownloadedActivity$1;-><init>(Lcom/aio/downloader/activity/VideoDownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->mBroadcastReceiver_delete:Landroid/content/BroadcastReceiver;

    .line 89
    new-instance v0, Lcom/aio/downloader/activity/VideoDownloadedActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/VideoDownloadedActivity$2;-><init>(Lcom/aio/downloader/activity/VideoDownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->videosuccessful:Landroid/content/BroadcastReceiver;

    .line 102
    iput-object v1, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    .line 103
    iput-object v1, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 35
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/VideoDownloadedActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/VideoDownloadedActivity;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/VideoDownloadedActivity;)Lcom/aio/downloader/adapter/VideoDownloadedAdapter;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/VideoDownloadedActivity;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->video_lv:Landroid/widget/ListView;

    return-object v0
.end method

.method private buildListener()V
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->videofan:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 156
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->filemorevideo:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 158
    return-void
.end method

.method private init()V
    .locals 3

    .prologue
    .line 136
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 137
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p0}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 141
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v1, "video"

    const-string v2, "timesort"

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/db/TypeDbUtils;->queryApk(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    .line 142
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    if-nez v0, :cond_1

    .line 144
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    .line 146
    :cond_1
    const v0, 0x7f0703f3

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->videofan:Landroid/widget/ImageView;

    .line 147
    const v0, 0x7f0703f4

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->filemorevideo:Landroid/widget/ImageView;

    .line 148
    const v0, 0x7f0703f6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->appnotice:Landroid/widget/TextView;

    .line 149
    const v0, 0x7f0703f5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->video_lv:Landroid/widget/ListView;

    .line 150
    new-instance v0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    iget-object v1, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    .line 151
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->video_lv:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 153
    return-void
.end method

.method private popuWindow()V
    .locals 7

    .prologue
    .line 224
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 225
    .local v2, "inflater":Landroid/view/LayoutInflater;
    const v5, 0x7f030041

    const/4 v6, 0x0

    invoke-virtual {v2, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 226
    .local v3, "view":Landroid/view/View;
    const v5, 0x7f070191

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->l1:Landroid/widget/RelativeLayout;

    .line 227
    const v5, 0x7f070192

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->l2:Landroid/widget/RelativeLayout;

    .line 228
    const v5, 0x7f070193

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->l3:Landroid/widget/RelativeLayout;

    .line 229
    const v5, 0x7f0701ac

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->l4:Landroid/widget/RelativeLayout;

    .line 231
    iget-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->l1:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 232
    iget-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->l2:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 233
    iget-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->l3:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 234
    iget-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->l4:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 236
    new-instance v5, Landroid/widget/PopupWindow;

    invoke-direct {v5, v3}, Landroid/widget/PopupWindow;-><init>(Landroid/view/View;)V

    iput-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    .line 237
    invoke-virtual {p0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v5

    .line 238
    invoke-interface {v5}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Display;->getHeight()I

    move-result v1

    .line 239
    .local v1, "h":I
    invoke-virtual {p0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v5

    .line 240
    invoke-interface {v5}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Display;->getWidth()I

    move-result v4

    .line 241
    .local v4, "w":I
    iget-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    div-int/lit8 v6, v4, 0x2

    add-int/lit8 v6, v6, 0x32

    invoke-virtual {v5, v6}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 242
    iget-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    const/4 v6, -0x2

    invoke-virtual {v5, v6}, Landroid/widget/PopupWindow;->setHeight(I)V

    .line 243
    iget-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Landroid/widget/PopupWindow;->setFocusable(Z)V

    .line 244
    iget-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    const v6, 0x7f0c0011

    invoke-virtual {v5, v6}, Landroid/widget/PopupWindow;->setAnimationStyle(I)V

    .line 245
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    const/4 v5, 0x0

    invoke-direct {v0, v5}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 246
    .local v0, "dw":Landroid/graphics/drawable/ColorDrawable;
    iget-object v5, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v5, v0}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 248
    return-void
.end method


# virtual methods
.method public VideoSort(Ljava/lang/String;)V
    .locals 2
    .param p1, "sort"    # Ljava/lang/String;

    .prologue
    .line 182
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 183
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p0}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 187
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v1, "video"

    invoke-virtual {v0, v1, p1}, Lcom/aio/downloader/db/TypeDbUtils;->queryApk(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    .line 188
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    if-nez v0, :cond_1

    .line 190
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    .line 192
    :cond_1
    const v0, 0x7f0703f5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->video_lv:Landroid/widget/ListView;

    .line 193
    new-instance v0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    iget-object v1, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    .line 194
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->video_lv:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 196
    return-void
.end method

.method public Videodeletall()V
    .locals 4

    .prologue
    .line 162
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v3, "video"

    invoke-virtual {v2, v3}, Lcom/aio/downloader/db/TypeDbUtils;->deleteallfile(Ljava/lang/String;)V

    .line 165
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v1, v2, :cond_0

    .line 175
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    iget-object v3, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    invoke-interface {v2, v3}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    .line 177
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    invoke-virtual {v2}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->notifyDataSetChanged()V

    .line 178
    return-void

    .line 166
    :cond_0
    new-instance v0, Ljava/io/File;

    iget-object v2, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 167
    .local v0, "df":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 169
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 165
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 252
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 313
    :goto_0
    return-void

    .line 254
    :sswitch_0
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->moveTaskToBack(Z)Z

    goto :goto_0

    .line 257
    :sswitch_1
    invoke-direct {p0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->popuWindow()V

    .line 258
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2, p1}, Landroid/widget/PopupWindow;->showAsDropDown(Landroid/view/View;)V

    goto :goto_0

    .line 261
    :sswitch_2
    const-string v2, "timesort"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->VideoSort(Ljava/lang/String;)V

    .line 262
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    goto :goto_0

    .line 265
    :sswitch_3
    const-string v2, "zimusort"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->VideoSort(Ljava/lang/String;)V

    .line 266
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    goto :goto_0

    .line 269
    :sswitch_4
    new-instance v2, Landroid/app/AlertDialog$Builder;

    invoke-direct {v2, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 270
    const v3, 0x7f0b0034

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 271
    const v3, 0x7f0b0044

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 273
    const v3, 0x7f0b003c

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 274
    new-instance v4, Lcom/aio/downloader/activity/VideoDownloadedActivity$3;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/VideoDownloadedActivity$3;-><init>(Lcom/aio/downloader/activity/VideoDownloadedActivity;)V

    .line 272
    invoke-virtual {v2, v3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 283
    const v3, 0x7f0b003b

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 284
    new-instance v4, Lcom/aio/downloader/activity/VideoDownloadedActivity$4;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/VideoDownloadedActivity$4;-><init>(Lcom/aio/downloader/activity/VideoDownloadedActivity;)V

    .line 282
    invoke-virtual {v2, v3, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 290
    invoke-virtual {v2}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 291
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    goto :goto_0

    .line 294
    :sswitch_5
    new-instance v0, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;

    .line 295
    const v2, 0x7f0c000e

    .line 294
    invoke-direct {v0, p0, v2}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;-><init>(Landroid/content/Context;I)V

    .line 296
    .local v0, "downloadpathCustomDialog":Lcom/aio/downloader/dialog/DownloadpathCustomDialog;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->setCanceledOnTouchOutside(Z)V

    .line 297
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->show()V

    .line 299
    const v2, 0x7f070194

    invoke-virtual {v0, v2}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 298
    check-cast v1, Landroid/widget/Button;

    .line 301
    .local v1, "downloadpathCustomDialogok":Landroid/widget/Button;
    new-instance v2, Lcom/aio/downloader/activity/VideoDownloadedActivity$5;

    invoke-direct {v2, p0, v0}, Lcom/aio/downloader/activity/VideoDownloadedActivity$5;-><init>(Lcom/aio/downloader/activity/VideoDownloadedActivity;Lcom/aio/downloader/dialog/DownloadpathCustomDialog;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 309
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    goto/16 :goto_0

    .line 252
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f070191 -> :sswitch_2
        0x7f070192 -> :sswitch_3
        0x7f070193 -> :sswitch_4
        0x7f0701ac -> :sswitch_5
        0x7f0703f3 -> :sswitch_0
        0x7f0703f4 -> :sswitch_1
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 115
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 116
    const v2, 0x7f0300bc

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->setContentView(I)V

    .line 118
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 119
    .local v0, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v2, "videodelete"

    invoke-virtual {v0, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 120
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->mBroadcastReceiver_delete:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 124
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 125
    .local v1, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v2, "videosuccessful"

    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 126
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->videosuccessful:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v1}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 130
    invoke-direct {p0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->init()V

    .line 131
    invoke-direct {p0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->buildListener()V

    .line 133
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 211
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 212
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 213
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 200
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 201
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 202
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->appnotice:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 204
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->notifyDataSetChanged()V

    .line 205
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 206
    return-void
.end method
