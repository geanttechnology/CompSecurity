.class public Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;
.super Landroid/widget/BaseAdapter;
.source "RingtoneDownloadedAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field ctx:Landroid/content/Context;

.field holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

.field isAlarm:Z

.field isMusic:Z

.field isNotification:Z

.field isRingtone:Z

.field private l1:Landroid/widget/LinearLayout;

.field private l2:Landroid/widget/LinearLayout;

.field private l3:Landroid/widget/LinearLayout;

.field private l4:Landroid/widget/LinearLayout;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private mWindow:Landroid/widget/PopupWindow;

.field mystandard:Landroid/widget/LinearLayout;

.field private new_file_path:Ljava/lang/String;

.field private popodismiss:Landroid/widget/RelativeLayout;

.field sp:Landroid/content/SharedPreferences;

.field private view:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;)V
    .locals 2
    .param p1, "ctx"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 55
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 47
    iput-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    .line 48
    iput-boolean v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->isRingtone:Z

    iput-boolean v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->isNotification:Z

    iput-boolean v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->isAlarm:Z

    .line 49
    iput-boolean v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->isMusic:Z

    .line 53
    iput-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->sp:Landroid/content/SharedPreferences;

    .line 56
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->ctx:Landroid/content/Context;

    .line 57
    iput-object p2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->list:Ljava/util/List;

    .line 60
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 64
    :goto_0
    const-string v0, "data"

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->sp:Landroid/content/SharedPreferences;

    .line 65
    return-void

    .line 61
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 236
    invoke-direct {p0, p1}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->initPopuWindow1(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->new_file_path:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->new_file_path:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->l1:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Landroid/widget/PopupWindow;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->mWindow:Landroid/widget/PopupWindow;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->l2:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->l3:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->l4:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->popodismiss:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method private initPopuWindow1(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v7, 0x1

    const/4 v5, -0x1

    const/4 v6, 0x0

    .line 237
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->mWindow:Landroid/widget/PopupWindow;

    if-nez v3, :cond_0

    .line 238
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->ctx:Landroid/content/Context;

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 239
    .local v2, "mLayoutInflater":Landroid/view/LayoutInflater;
    const v3, 0x7f0300ab

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    iput-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->view:Landroid/view/View;

    .line 240
    new-instance v3, Landroid/widget/PopupWindow;

    iget-object v4, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->view:Landroid/view/View;

    .line 242
    invoke-direct {v3, v4, v5, v5}, Landroid/widget/PopupWindow;-><init>(Landroid/view/View;II)V

    .line 240
    iput-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->mWindow:Landroid/widget/PopupWindow;

    .line 243
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->view:Landroid/view/View;

    const/high16 v4, 0x7f070000

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    iput-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->l1:Landroid/widget/LinearLayout;

    .line 244
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->view:Landroid/view/View;

    const v4, 0x7f07039f

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    iput-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->l2:Landroid/widget/LinearLayout;

    .line 245
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->view:Landroid/view/View;

    const v4, 0x7f0703a0

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    iput-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->l3:Landroid/widget/LinearLayout;

    .line 246
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->view:Landroid/view/View;

    const v4, 0x7f0703a1

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    iput-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->l4:Landroid/widget/LinearLayout;

    .line 247
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->view:Landroid/view/View;

    const v4, 0x7f07039e

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout;

    iput-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->popodismiss:Landroid/widget/RelativeLayout;

    .line 254
    .end local v2    # "mLayoutInflater":Landroid/view/LayoutInflater;
    :cond_0
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v0, v6}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 255
    .local v0, "cd":Landroid/graphics/drawable/ColorDrawable;
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v3, v0}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 257
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->ctx:Landroid/content/Context;

    check-cast v3, Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v3

    .line 258
    invoke-virtual {v3}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v1

    .line 259
    .local v1, "lp":Landroid/view/WindowManager$LayoutParams;
    const v3, 0x3dcccccd    # 0.1f

    iput v3, v1, Landroid/view/WindowManager$LayoutParams;->alpha:F

    .line 260
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->ctx:Landroid/content/Context;

    check-cast v3, Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 262
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v3, v7}, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V

    .line 263
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v3, v7}, Landroid/widget/PopupWindow;->setFocusable(Z)V

    .line 265
    iget-object v4, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    check-cast v3, Landroid/view/View;

    const/16 v5, 0x11

    invoke-virtual {v4, v3, v5, v6, v6}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    .line 268
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v3}, Landroid/widget/PopupWindow;->update()V

    .line 269
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->mWindow:Landroid/widget/PopupWindow;

    new-instance v4, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$4;

    invoke-direct {v4, p0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$4;-><init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)V

    invoke-virtual {v3, v4}, Landroid/widget/PopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V

    .line 279
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 71
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 73
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 81
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 87
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 93
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 96
    .local v0, "in_fo":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    if-nez p2, :cond_0

    .line 97
    new-instance v1, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    invoke-direct {v1, p0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)V

    iput-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    .line 98
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->ctx:Landroid/content/Context;

    .line 99
    const v2, 0x7f0300a8

    const/4 v3, 0x0

    .line 98
    invoke-static {v1, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 100
    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    .line 101
    const v1, 0x7f07038e

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 100
    iput-object v1, v2, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;->my_delete_movie:Landroid/widget/ImageView;

    .line 102
    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    .line 103
    const v1, 0x7f07038f

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 102
    iput-object v1, v2, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;->my_test_head_image3:Landroid/widget/ImageView;

    .line 104
    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    .line 105
    const v1, 0x7f070390

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 104
    iput-object v1, v2, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;->my_movie_name_item:Landroid/widget/TextView;

    .line 106
    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    .line 107
    const v1, 0x7f070391

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 106
    iput-object v1, v2, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;->my_totalsize:Landroid/widget/TextView;

    .line 108
    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    .line 109
    const v1, 0x7f070392

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 108
    iput-object v1, v2, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/Button;

    .line 110
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 115
    :goto_0
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    iget-object v1, v1, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;->my_totalsize:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFileSize()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    invoke-static {v2, v3, v4}, Landroid/text/format/Formatter;->formatFileSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 120
    :goto_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    iget-object v1, v1, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;->my_movie_name_item:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 125
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    iget-object v1, v1, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/Button;

    new-instance v2, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;

    invoke-direct {v2, p0, v0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;-><init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 197
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    iget-object v1, v1, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;->my_delete_movie:Landroid/widget/ImageView;

    new-instance v2, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$2;

    invoke-direct {v2, p0, p1}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$2;-><init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;I)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 210
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    iget-object v1, v1, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;->my_test_head_image3:Landroid/widget/ImageView;

    new-instance v2, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$3;

    invoke-direct {v2, p0, v0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$3;-><init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 223
    return-object p2

    .line 112
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    iput-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$ViewHolder;

    goto :goto_0

    .line 116
    :catch_0
    move-exception v1

    goto :goto_1
.end method

.method public onClick(Landroid/view/View;)V
    .locals 0
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 326
    return-void
.end method

.method public setRingtone(ILjava/lang/String;)V
    .locals 7
    .param p1, "ringType"    # I
    .param p2, "file_path"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    .line 283
    packed-switch p1, :pswitch_data_0

    .line 303
    :goto_0
    :pswitch_0
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 304
    .local v2, "values":Landroid/content/ContentValues;
    const-string v3, "_data"

    invoke-virtual {v2, v3, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 305
    const-string v3, "title"

    .line 306
    iget-object v4, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->sp:Landroid/content/SharedPreferences;

    const-string v5, "movivename"

    const-string v6, "AAA"

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 305
    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 307
    const-string v3, "mime_type"

    const-string v4, "audio/mp3"

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 308
    const-string v3, "is_ringtone"

    iget-boolean v4, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->isRingtone:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 309
    const-string v3, "is_notification"

    iget-boolean v4, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->isNotification:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 310
    const-string v3, "is_alarm"

    iget-boolean v4, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->isAlarm:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 311
    const-string v3, "is_music"

    iget-boolean v4, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->isMusic:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 312
    invoke-static {p2}, Landroid/provider/MediaStore$Audio$Media;->getContentUriForPath(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 314
    .local v1, "uri":Landroid/net/Uri;
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    .line 315
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "_data=\""

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->new_file_path:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 316
    const/4 v5, 0x0

    .line 314
    invoke-virtual {v3, v1, v4, v5}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 318
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    invoke-virtual {v3, v1, v2}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    .line 319
    .local v0, "newUri":Landroid/net/Uri;
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->ctx:Landroid/content/Context;

    invoke-static {v3, p1, v0}, Landroid/media/RingtoneManager;->setActualDefaultRingtoneUri(Landroid/content/Context;ILandroid/net/Uri;)V

    .line 320
    const-string v3, "ringType"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 321
    return-void

    .line 285
    .end local v0    # "newUri":Landroid/net/Uri;
    .end local v1    # "uri":Landroid/net/Uri;
    .end local v2    # "values":Landroid/content/ContentValues;
    :pswitch_1
    iput-boolean v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->isRingtone:Z

    goto/16 :goto_0

    .line 289
    :pswitch_2
    iput-boolean v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->isNotification:Z

    goto/16 :goto_0

    .line 293
    :pswitch_3
    iput-boolean v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->isAlarm:Z

    goto/16 :goto_0

    .line 297
    :pswitch_4
    iput-boolean v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->isMusic:Z

    goto/16 :goto_0

    .line 283
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_4
    .end packed-switch
.end method
