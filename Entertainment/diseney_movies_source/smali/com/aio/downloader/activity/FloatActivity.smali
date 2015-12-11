.class public Lcom/aio/downloader/activity/FloatActivity;
.super Landroid/app/Activity;
.source "FloatActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private AIOCRUSHAPK:Ljava/io/File;

.field private AIOCRUSHSWF:Ljava/io/File;

.field private cWidth:I

.field private cm:Landroid/net/ConnectivityManager;

.field private current:I

.field private float_search_view:Lcom/aio/downloader/views/DeletableEditText;

.field private float_searchimg:Lcom/aio/downloader/views/LImageButton;

.field private hSpacing:I

.field private infos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/Programe;",
            ">;"
        }
    .end annotation
.end field

.field private iv_airplane:Landroid/widget/ImageView;

.field private iv_auto_rotate:Landroid/widget/ImageView;

.field private iv_brightness:Landroid/widget/ImageView;

.field private iv_buletooth:Landroid/widget/ImageView;

.field private iv_flash:Landroid/widget/ImageView;

.field private iv_gps:Landroid/widget/ImageView;

.field private iv_sleep:Landroid/widget/ImageView;

.field private iv_vibaration:Landroid/widget/ImageView;

.field private iv_wifi:Landroid/widget/ImageView;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/Programe;",
            ">;"
        }
    .end annotation
.end field

.field private ll_auto_rotate:Landroid/widget/LinearLayout;

.field private ll_brightness:Landroid/widget/LinearLayout;

.field private ll_flash:Landroid/widget/LinearLayout;

.field private ll_gps:Landroid/widget/LinearLayout;

.field private ll_sleep:Landroid/widget/LinearLayout;

.field private ll_wifi:Landroid/widget/LinearLayout;

.field private mAudioManager:Landroid/media/AudioManager;

.field private mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

.field private mGridView:Landroid/widget/GridView;

.field private mScrollView:Landroid/widget/HorizontalScrollView;

.field private max:I

.field private state_blue:I

.field private tv_airplane:Landroid/widget/TextView;

.field private tv_auto_rotate:Landroid/widget/TextView;

.field private tv_buletooth:Landroid/widget/TextView;

.field private tv_flash:Landroid/widget/TextView;

.field private tv_gps:Landroid/widget/TextView;

.field private tv_vibaration:Landroid/widget/TextView;

.field private tv_wifi:Landroid/widget/TextView;

.field private wm:Landroid/net/wifi/WifiManager;

.field private y:I


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 63
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 90
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/activity/FloatActivity;->y:I

    .line 107
    const/16 v0, 0x78

    iput v0, p0, Lcom/aio/downloader/activity/FloatActivity;->cWidth:I

    .line 111
    const/16 v0, 0xa

    iput v0, p0, Lcom/aio/downloader/activity/FloatActivity;->hSpacing:I

    .line 113
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatActivity;->infos:Ljava/util/List;

    .line 115
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 116
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 117
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 118
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatActivity;->AIOCRUSHSWF:Ljava/io/File;

    .line 119
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 120
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 121
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 122
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatActivity;->AIOCRUSHAPK:Ljava/io/File;

    .line 63
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/FloatActivity;)Lcom/aio/downloader/views/DeletableEditText;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatActivity;->float_search_view:Lcom/aio/downloader/views/DeletableEditText;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/FloatActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatActivity;->list:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/FloatActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatActivity;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/FloatActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatActivity;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method private dip2px(Landroid/content/Context;F)I
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "dpValue"    # F

    .prologue
    .line 619
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v0, v1, Landroid/util/DisplayMetrics;->density:F

    .line 620
    .local v0, "scale":F
    mul-float v1, p2, v0

    const/high16 v2, 0x3f000000    # 0.5f

    add-float/2addr v1, v2

    float-to-int v1, v1

    return v1
.end method

.method private findclick()V
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatActivity;->ll_brightness:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 138
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatActivity;->ll_wifi:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 139
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatActivity;->ll_gps:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 140
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatActivity;->ll_flash:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 141
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatActivity;->ll_auto_rotate:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 142
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatActivity;->ll_sleep:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 143
    const v0, 0x7f0701e2

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 144
    const v0, 0x7f0701e3

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 145
    const v0, 0x7f0701e4

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 146
    return-void
.end method

.method public static getAirplaneMode(Landroid/content/Context;)Z
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 563
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string v4, "airplane_mode_on"

    .line 562
    invoke-static {v3, v4, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    .line 565
    .local v0, "isAirplaneMode":I
    if-ne v0, v1, :cond_0

    :goto_0
    return v1

    :cond_0
    move v1, v2

    goto :goto_0
.end method

.method private getScreenBrightness(Landroid/content/Context;)I
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 495
    const/16 v0, 0xff

    .line 498
    .local v0, "screenBrightness":I
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 499
    const-string v2, "screen_brightness"

    .line 497
    invoke-static {v1, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 503
    :goto_0
    return v0

    .line 500
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private getScreenMode(Landroid/content/Context;)I
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 469
    const/4 v0, 0x0

    .line 471
    .local v0, "screenMode":I
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 472
    const-string v2, "screen_brightness_mode"

    .line 471
    invoke-static {v1, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 476
    :goto_0
    return v0

    .line 473
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private getScreenOffTime(Landroid/content/Context;)I
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 532
    const/4 v0, 0x0

    .line 535
    .local v0, "screenOffTime":I
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 536
    const-string v2, "screen_off_timeout"

    .line 534
    invoke-static {v1, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 540
    :goto_0
    return v0

    .line 537
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private init()V
    .locals 4

    .prologue
    const/4 v3, 0x2

    .line 149
    const v1, 0x7f0701b3

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_brightness:Landroid/widget/ImageView;

    .line 150
    const v1, 0x7f0701b2

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->ll_brightness:Landroid/widget/LinearLayout;

    .line 151
    const v1, 0x7f0701b4

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->ll_wifi:Landroid/widget/LinearLayout;

    .line 152
    const v1, 0x7f0701b5

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_wifi:Landroid/widget/ImageView;

    .line 153
    const v1, 0x7f0701b6

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_wifi:Landroid/widget/TextView;

    .line 155
    const v1, 0x7f0701b7

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->ll_gps:Landroid/widget/LinearLayout;

    .line 156
    const v1, 0x7f0701b8

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_gps:Landroid/widget/ImageView;

    .line 157
    const v1, 0x7f0701b9

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_gps:Landroid/widget/TextView;

    .line 159
    const v1, 0x7f0701ba

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->ll_flash:Landroid/widget/LinearLayout;

    .line 160
    const v1, 0x7f0701bb

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_flash:Landroid/widget/ImageView;

    .line 161
    const v1, 0x7f0701bc

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_flash:Landroid/widget/TextView;

    .line 162
    const v1, 0x7f0701bd

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 163
    const v1, 0x7f0701be

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 165
    const v1, 0x7f0701bf

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->ll_auto_rotate:Landroid/widget/LinearLayout;

    .line 166
    const v1, 0x7f0701c0

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_auto_rotate:Landroid/widget/ImageView;

    .line 167
    const v1, 0x7f0701c1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_auto_rotate:Landroid/widget/TextView;

    .line 169
    const v1, 0x7f0701c2

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->ll_sleep:Landroid/widget/LinearLayout;

    .line 170
    const v1, 0x7f0701c3

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_sleep:Landroid/widget/ImageView;

    .line 172
    const v1, 0x7f0701c4

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 173
    const v1, 0x7f0701c5

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_vibaration:Landroid/widget/ImageView;

    .line 174
    const v1, 0x7f0701c6

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_vibaration:Landroid/widget/TextView;

    .line 176
    const v1, 0x7f0701c7

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 177
    const v1, 0x7f0701c8

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_airplane:Landroid/widget/ImageView;

    .line 178
    const v1, 0x7f0701c9

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_airplane:Landroid/widget/TextView;

    .line 180
    const v1, 0x7f0701ca

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 181
    const v1, 0x7f0701cb

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_buletooth:Landroid/widget/ImageView;

    .line 182
    const v1, 0x7f0701cc

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_buletooth:Landroid/widget/TextView;

    .line 184
    const v1, 0x7f0701cd

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 186
    const v1, 0x7f0701da

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 187
    const v1, 0x7f0701e5

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 188
    const v1, 0x7f0701e1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 190
    const v1, 0x7f0701dd

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/DeletableEditText;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->float_search_view:Lcom/aio/downloader/views/DeletableEditText;

    .line 191
    const v1, 0x7f0701dc

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/LImageButton;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->float_searchimg:Lcom/aio/downloader/views/LImageButton;

    .line 192
    iget-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->float_searchimg:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v1, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 194
    const v1, 0x7f0701de

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 196
    const v1, 0x7f0701e0

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/GridView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->mGridView:Landroid/widget/GridView;

    .line 197
    const v1, 0x7f0701df

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/HorizontalScrollView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->mScrollView:Landroid/widget/HorizontalScrollView;

    .line 198
    iget-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->mScrollView:Landroid/widget/HorizontalScrollView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/HorizontalScrollView;->setHorizontalScrollBarEnabled(Z)V

    .line 200
    const v1, 0x7f0701e7

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 201
    .local v0, "tv_qwe":Landroid/widget/TextView;
    const v1, 0x7f0701e8

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 203
    const-string v1, "wifi"

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/wifi/WifiManager;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->wm:Landroid/net/wifi/WifiManager;

    .line 204
    const-string v1, "connectivity"

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/ConnectivityManager;

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->cm:Landroid/net/ConnectivityManager;

    .line 207
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 208
    const-string v2, "audio"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/media/AudioManager;

    .line 207
    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->mAudioManager:Landroid/media/AudioManager;

    .line 209
    iget-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->mAudioManager:Landroid/media/AudioManager;

    invoke-virtual {v1, v3}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/activity/FloatActivity;->current:I

    .line 210
    iget-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->mAudioManager:Landroid/media/AudioManager;

    invoke-virtual {v1, v3}, Landroid/media/AudioManager;->getStreamMaxVolume(I)I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/activity/FloatActivity;->max:I

    .line 214
    :try_start_0
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    .line 215
    iget-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v1, :cond_0

    .line 216
    iget-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothAdapter;->getState()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/activity/FloatActivity;->state_blue:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 224
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/activity/FloatActivity;->float_search_view:Lcom/aio/downloader/views/DeletableEditText;

    new-instance v2, Lcom/aio/downloader/activity/FloatActivity$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/FloatActivity$1;-><init>(Lcom/aio/downloader/activity/FloatActivity;)V

    invoke-virtual {v1, v2}, Lcom/aio/downloader/views/DeletableEditText;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 266
    return-void

    .line 218
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private saveScreenBrightness(ILandroid/content/Context;)V
    .locals 3
    .param p1, "paramInt"    # I
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 484
    :try_start_0
    invoke-virtual {p2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 485
    const-string v2, "screen_brightness"

    .line 484
    invoke-static {v1, v2, p1}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 489
    :goto_0
    return-void

    .line 486
    :catch_0
    move-exception v0

    .line 487
    .local v0, "localException":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private setScreenMode(ILandroid/content/Context;)V
    .locals 3
    .param p1, "paramInt"    # I
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 457
    :try_start_0
    invoke-virtual {p2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 458
    const-string v2, "screen_brightness_mode"

    .line 457
    invoke-static {v1, v2, p1}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 462
    :goto_0
    return-void

    .line 459
    :catch_0
    move-exception v0

    .line 460
    .local v0, "localException":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private setScreenOffTime(ILandroid/content/Context;)V
    .locals 3
    .param p1, "paramInt"    # I
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 548
    :try_start_0
    invoke-virtual {p2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 549
    const-string v2, "screen_off_timeout"

    .line 548
    invoke-static {v1, v2, p1}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 553
    :goto_0
    return-void

    .line 550
    :catch_0
    move-exception v0

    .line 551
    .local v0, "localException":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method public getFileSizes(Ljava/io/File;)J
    .locals 4
    .param p1, "f"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 929
    const-wide/16 v1, 0x0

    .line 930
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 931
    const/4 v0, 0x0

    .line 932
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 933
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 937
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 935
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public getRunningProcess()Ljava/util/List;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/Programe;",
            ">;"
        }
    .end annotation

    .prologue
    .line 570
    new-instance v4, Lcom/aio/downloader/model/PackagesInfo;

    invoke-direct {v4, p0}, Lcom/aio/downloader/model/PackagesInfo;-><init>(Landroid/content/Context;)V

    .line 572
    .local v4, "pi":Lcom/aio/downloader/model/PackagesInfo;
    const-string v9, "activity"

    invoke-virtual {p0, v9}, Lcom/aio/downloader/activity/FloatActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 574
    .local v0, "am":Landroid/app/ActivityManager;
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v8

    .line 576
    .local v8, "run":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 577
    .local v5, "pm":Landroid/content/pm/PackageManager;
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 579
    .local v3, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/model/Programe;>;"
    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_0
    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-nez v10, :cond_1

    .line 612
    return-object v3

    .line 579
    :cond_1
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 583
    .local v7, "ra":Landroid/app/ActivityManager$RunningAppProcessInfo;
    :try_start_0
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    .line 584
    const/4 v11, 0x0

    .line 583
    invoke-virtual {v5, v10, v11}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    .line 585
    .local v1, "appinfo":Landroid/content/pm/ApplicationInfo;
    iget v10, v1, Landroid/content/pm/ApplicationInfo;->flags:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    and-int/lit8 v10, v10, 0x1

    if-nez v10, :cond_0

    .line 593
    .end local v1    # "appinfo":Landroid/content/pm/ApplicationInfo;
    :goto_1
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    const-string v11, "system"

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 594
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    const-string v11, "google"

    invoke-virtual {v10, v11}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 595
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    const-string v11, "android"

    invoke-virtual {v10, v11}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 596
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    const-string v11, "com.android.phone"

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 597
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getPackageName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 600
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v4, v10}, Lcom/aio/downloader/model/PackagesInfo;->getInfo(Ljava/lang/String;)Landroid/content/pm/ApplicationInfo;

    move-result-object v10

    if-eqz v10, :cond_0

    .line 603
    const-string v10, "toggletag"

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "toggletag="

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v12, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 604
    new-instance v6, Lcom/aio/downloader/model/Programe;

    invoke-direct {v6}, Lcom/aio/downloader/model/Programe;-><init>()V

    .line 605
    .local v6, "pr":Lcom/aio/downloader/model/Programe;
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v4, v10}, Lcom/aio/downloader/model/PackagesInfo;->getInfo(Ljava/lang/String;)Landroid/content/pm/ApplicationInfo;

    move-result-object v10

    invoke-virtual {v10, v5}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v10

    invoke-virtual {v6, v10}, Lcom/aio/downloader/model/Programe;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 606
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v4, v10}, Lcom/aio/downloader/model/PackagesInfo;->getInfo(Ljava/lang/String;)Landroid/content/pm/ApplicationInfo;

    move-result-object v10

    invoke-virtual {v10, v5}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v10

    invoke-interface {v10}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v10}, Lcom/aio/downloader/model/Programe;->setName(Ljava/lang/String;)V

    .line 607
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v6, v10}, Lcom/aio/downloader/model/Programe;->setPackagename(Ljava/lang/String;)V

    .line 608
    sget-object v10, Ljava/lang/System;->out:Ljava/io/PrintStream;

    iget-object v11, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v4, v11}, Lcom/aio/downloader/model/PackagesInfo;->getInfo(Ljava/lang/String;)Landroid/content/pm/ApplicationInfo;

    move-result-object v11

    invoke-virtual {v11, v5}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v11

    .line 609
    invoke-interface {v11}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v11

    .line 608
    invoke-virtual {v10, v11}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 610
    invoke-interface {v3, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 588
    .end local v6    # "pr":Lcom/aio/downloader/model/Programe;
    :catch_0
    move-exception v2

    .line 590
    .local v2, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_1
.end method

.method public isOPen(Landroid/content/Context;)Z
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 513
    .line 514
    const-string v3, "location"

    invoke-virtual {p1, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 513
    check-cast v1, Landroid/location/LocationManager;

    .line 517
    .local v1, "locationManager":Landroid/location/LocationManager;
    const-string v3, "gps"

    invoke-virtual {v1, v3}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    .line 520
    .local v0, "gps":Z
    const-string v3, "network"

    invoke-virtual {v1, v3}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v2

    .line 521
    .local v2, "network":Z
    if-nez v0, :cond_0

    if-eqz v2, :cond_1

    .line 522
    :cond_0
    const/4 v3, 0x1

    .line 525
    :goto_0
    return v3

    :cond_1
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 25
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 626
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getId()I

    move-result v21

    sparse-switch v21, :sswitch_data_0

    .line 926
    :cond_0
    :goto_0
    return-void

    .line 630
    :sswitch_0
    const-string v21, "floattag"

    new-instance v22, Ljava/lang/StringBuilder;

    const-string v23, "bright="

    invoke-direct/range {v22 .. v23}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 631
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    .line 630
    invoke-static/range {v21 .. v22}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 632
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenMode(Landroid/content/Context;)I

    move-result v21

    const/16 v22, 0x1

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_1

    .line 633
    const/16 v21, 0x0

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/FloatActivity;->setScreenMode(ILandroid/content/Context;)V

    .line 635
    const/16 v21, 0x3f

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/FloatActivity;->saveScreenBrightness(ILandroid/content/Context;)V

    .line 637
    :cond_1
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v21

    if-ltz v21, :cond_2

    .line 638
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v21

    const/16 v22, 0x40

    move/from16 v0, v21

    move/from16 v1, v22

    if-ge v0, v1, :cond_2

    .line 639
    const/16 v21, 0x40

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/FloatActivity;->saveScreenBrightness(ILandroid/content/Context;)V

    .line 640
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_brightness:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    .line 641
    const v22, 0x7f0200a0

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 642
    :cond_2
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v21

    const/16 v22, 0x40

    move/from16 v0, v21

    move/from16 v1, v22

    if-lt v0, v1, :cond_3

    .line 643
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v21

    const/16 v22, 0x7f

    move/from16 v0, v21

    move/from16 v1, v22

    if-ge v0, v1, :cond_3

    .line 644
    const/16 v21, 0x7f

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/FloatActivity;->saveScreenBrightness(ILandroid/content/Context;)V

    .line 645
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_brightness:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    .line 646
    const v22, 0x7f0200a1

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 647
    :cond_3
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v21

    const/16 v22, 0x7f

    move/from16 v0, v21

    move/from16 v1, v22

    if-lt v0, v1, :cond_4

    .line 648
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v21

    const/16 v22, 0xff

    move/from16 v0, v21

    move/from16 v1, v22

    if-ge v0, v1, :cond_4

    .line 649
    const/16 v21, 0xff

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/FloatActivity;->saveScreenBrightness(ILandroid/content/Context;)V

    .line 650
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_brightness:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    .line 651
    const v22, 0x7f02009f

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 652
    :cond_4
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v21

    const/16 v22, 0xff

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_0

    .line 653
    const/16 v21, 0x1

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/FloatActivity;->setScreenMode(ILandroid/content/Context;)V

    .line 654
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_brightness:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    .line 655
    const v22, 0x7f0200a2

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 660
    :sswitch_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->wm:Landroid/net/wifi/WifiManager;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Landroid/net/wifi/WifiManager;->getWifiState()I

    move-result v21

    const/16 v22, 0x1

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_5

    .line 662
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->wm:Landroid/net/wifi/WifiManager;

    move-object/from16 v21, v0

    const/16 v22, 0x1

    invoke-virtual/range {v21 .. v22}, Landroid/net/wifi/WifiManager;->setWifiEnabled(Z)Z

    .line 663
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_wifi:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    const v22, 0x7f0200b0

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 664
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->tv_wifi:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const v22, -0xde690d

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setTextColor(I)V

    .line 667
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->wm:Landroid/net/wifi/WifiManager;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Landroid/net/wifi/WifiManager;->getWifiState()I

    move-result v21

    const/16 v22, 0x3

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_0

    .line 669
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->wm:Landroid/net/wifi/WifiManager;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    invoke-virtual/range {v21 .. v22}, Landroid/net/wifi/WifiManager;->setWifiEnabled(Z)Z

    .line 670
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_wifi:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    const v22, 0x7f0200af

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 671
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->tv_wifi:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const v22, -0x5e5049

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 676
    :sswitch_2
    new-instance v9, Landroid/content/Intent;

    invoke-direct {v9}, Landroid/content/Intent;-><init>()V

    .line 677
    .local v9, "intent":Landroid/content/Intent;
    const-string v21, "android.settings.LOCATION_SOURCE_SETTINGS"

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 678
    const/high16 v21, 0x10000000

    move/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 680
    :try_start_0
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 682
    :catch_0
    move-exception v7

    .line 688
    .local v7, "ex":Landroid/content/ActivityNotFoundException;
    const-string v21, "android.settings.SETTINGS"

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 690
    :try_start_1
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_0

    .line 691
    :catch_1
    move-exception v21

    goto/16 :goto_0

    .line 696
    .end local v7    # "ex":Landroid/content/ActivityNotFoundException;
    .end local v9    # "intent":Landroid/content/Intent;
    :sswitch_3
    new-instance v15, Landroid/content/Intent;

    .line 697
    const-string v21, "android.settings.INTERNAL_STORAGE_SETTINGS"

    .line 696
    move-object/from16 v0, v21

    invoke-direct {v15, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 698
    .local v15, "intent_flash":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 702
    .end local v15    # "intent_flash":Landroid/content/Intent;
    :sswitch_4
    :try_start_2
    new-instance v17, Landroid/content/Intent;

    invoke-direct/range {v17 .. v17}, Landroid/content/Intent;-><init>()V

    .line 703
    .local v17, "intentcalculator":Landroid/content/Intent;
    const-string v21, "com.android.calculator2"

    .line 704
    const-string v22, "com.android.calculator2.Calculator"

    .line 703
    move-object/from16 v0, v17

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 705
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    goto/16 :goto_0

    .line 706
    .end local v17    # "intentcalculator":Landroid/content/Intent;
    :catch_2
    move-exception v6

    .line 708
    .local v6, "e":Ljava/lang/Exception;
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    .line 709
    const-string v22, "Your phone doesn\'t support."

    const/16 v23, 0x0

    .line 708
    invoke-static/range {v21 .. v23}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v21

    .line 710
    invoke-virtual/range {v21 .. v21}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 715
    .end local v6    # "e":Ljava/lang/Exception;
    :sswitch_5
    new-instance v4, Landroid/content/Intent;

    const-string v21, "android.intent.action.SET_ALARM"

    move-object/from16 v0, v21

    invoke-direct {v4, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 716
    .local v4, "alarms":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 720
    .end local v4    # "alarms":Landroid/content/Intent;
    :sswitch_6
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    .line 721
    invoke-virtual/range {v21 .. v21}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v21

    .line 722
    const-string v22, "accelerometer_rotation"

    const/16 v23, 0x0

    .line 720
    invoke-static/range {v21 .. v23}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v21

    if-nez v21, :cond_6

    .line 723
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    .line 724
    invoke-virtual/range {v21 .. v21}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v21

    .line 725
    const-string v22, "accelerometer_rotation"

    const/16 v23, 0x1

    .line 723
    invoke-static/range {v21 .. v23}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    .line 726
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_auto_rotate:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    .line 727
    const v22, 0x7f0200a6

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 728
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->tv_auto_rotate:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const v22, -0xde690d

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 730
    :cond_6
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    .line 731
    invoke-virtual/range {v21 .. v21}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v21

    .line 732
    const-string v22, "accelerometer_rotation"

    const/16 v23, 0x0

    .line 730
    invoke-static/range {v21 .. v23}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    .line 733
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_auto_rotate:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    .line 734
    const v22, 0x7f0200a5

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 735
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->tv_auto_rotate:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const v22, -0x5e5049

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 740
    :sswitch_7
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenOffTime(Landroid/content/Context;)I

    move-result v21

    const v22, 0x927c0

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_7

    .line 741
    const/16 v21, 0x3a98

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/FloatActivity;->setScreenOffTime(ILandroid/content/Context;)V

    .line 742
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_sleep:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    const v22, 0x7f0200a8

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 743
    :cond_7
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenOffTime(Landroid/content/Context;)I

    move-result v21

    const/16 v22, 0x3a98

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_8

    .line 744
    const/16 v21, 0x7530

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/FloatActivity;->setScreenOffTime(ILandroid/content/Context;)V

    .line 745
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_sleep:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    const v22, 0x7f0200ab

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 746
    :cond_8
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenOffTime(Landroid/content/Context;)I

    move-result v21

    const/16 v22, 0x7530

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_9

    .line 747
    const v21, 0xea60

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/FloatActivity;->setScreenOffTime(ILandroid/content/Context;)V

    .line 748
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_sleep:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    const v22, 0x7f0200a9

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 749
    :cond_9
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenOffTime(Landroid/content/Context;)I

    move-result v21

    const v22, 0xea60

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_a

    .line 750
    const v21, 0x1d4c0

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/FloatActivity;->setScreenOffTime(ILandroid/content/Context;)V

    .line 751
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_sleep:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    const v22, 0x7f0200aa

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 752
    :cond_a
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenOffTime(Landroid/content/Context;)I

    move-result v21

    const v22, 0x1d4c0

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_b

    .line 753
    const v21, 0x493e0

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/FloatActivity;->setScreenOffTime(ILandroid/content/Context;)V

    .line 754
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_sleep:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    const v22, 0x7f0200ac

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 755
    :cond_b
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getScreenOffTime(Landroid/content/Context;)I

    move-result v21

    const v22, 0x493e0

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_0

    .line 756
    const v21, 0x927c0

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/FloatActivity;->setScreenOffTime(ILandroid/content/Context;)V

    .line 757
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_sleep:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    const v22, 0x7f0200a7

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 764
    :sswitch_8
    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/FloatActivity;->y:I

    move/from16 v21, v0

    const/16 v22, 0x2

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_c

    .line 765
    const/16 v21, 0x0

    move/from16 v0, v21

    move-object/from16 v1, p0

    iput v0, v1, Lcom/aio/downloader/activity/FloatActivity;->y:I

    .line 767
    :cond_c
    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/FloatActivity;->y:I

    move/from16 v21, v0

    const/16 v22, 0x1

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_d

    .line 768
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_vibaration:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    .line 769
    const v22, 0x7f0200ae

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 770
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->mAudioManager:Landroid/media/AudioManager;

    move-object/from16 v21, v0

    const/16 v22, 0x1

    invoke-virtual/range {v21 .. v22}, Landroid/media/AudioManager;->setRingerMode(I)V

    .line 771
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->tv_vibaration:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const v22, -0xde690d

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setTextColor(I)V

    .line 772
    const/16 v21, 0x2

    move/from16 v0, v21

    move-object/from16 v1, p0

    iput v0, v1, Lcom/aio/downloader/activity/FloatActivity;->y:I

    .line 774
    :cond_d
    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/FloatActivity;->y:I

    move/from16 v21, v0

    if-nez v21, :cond_0

    .line 775
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_vibaration:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    .line 776
    const v22, 0x7f0200ad

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 777
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->mAudioManager:Landroid/media/AudioManager;

    move-object/from16 v21, v0

    const/16 v22, 0x2

    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/FloatActivity;->max:I

    move/from16 v23, v0

    .line 778
    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/FloatActivity;->max:I

    move/from16 v24, v0

    .line 777
    invoke-virtual/range {v21 .. v24}, Landroid/media/AudioManager;->setStreamVolume(III)V

    .line 779
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->tv_vibaration:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const v22, -0x5e5049

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setTextColor(I)V

    .line 780
    const/16 v21, 0x1

    move/from16 v0, v21

    move-object/from16 v1, p0

    iput v0, v1, Lcom/aio/downloader/activity/FloatActivity;->y:I

    goto/16 :goto_0

    .line 785
    :sswitch_9
    new-instance v14, Landroid/content/Intent;

    .line 786
    const-string v21, "android.settings.AIRPLANE_MODE_SETTINGS"

    .line 785
    move-object/from16 v0, v21

    invoke-direct {v14, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 787
    .local v14, "intent_air":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 792
    .end local v14    # "intent_air":Landroid/content/Intent;
    :sswitch_a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    move-object/from16 v21, v0

    if-nez v21, :cond_e

    .line 794
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    .line 795
    const-string v22, "This machine is not found bluetooth hardware or drivers\uff01"

    .line 796
    const/16 v23, 0x0

    .line 793
    invoke-static/range {v21 .. v23}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v21

    .line 796
    invoke-virtual/range {v21 .. v21}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 798
    :cond_e
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Landroid/bluetooth/BluetoothAdapter;->getState()I

    move-result v20

    .line 799
    .local v20, "state_blue":I
    const/16 v21, 0xa

    move/from16 v0, v20

    move/from16 v1, v21

    if-ne v0, v1, :cond_f

    .line 800
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Landroid/bluetooth/BluetoothAdapter;->enable()Z

    .line 801
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_buletooth:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    .line 802
    const v22, 0x7f02009e

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 803
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->tv_buletooth:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const v22, -0xde690d

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setTextColor(I)V

    .line 805
    :cond_f
    const/16 v21, 0xc

    move/from16 v0, v20

    move/from16 v1, v21

    if-ne v0, v1, :cond_0

    .line 806
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Landroid/bluetooth/BluetoothAdapter;->disable()Z

    .line 807
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->iv_buletooth:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    .line 808
    const v22, 0x7f02009d

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 809
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->tv_buletooth:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const v22, -0x5e5049

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 816
    .end local v20    # "state_blue":I
    :sswitch_b
    new-instance v8, Landroid/content/Intent;

    invoke-direct {v8}, Landroid/content/Intent;-><init>()V

    .line 817
    .local v8, "i":Landroid/content/Intent;
    const-string v21, "android.media.action.STILL_IMAGE_CAMERA"

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 818
    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 821
    .end local v8    # "i":Landroid/content/Intent;
    :sswitch_c
    new-instance v16, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    .line 822
    const-class v22, Lcom/aio/downloader/activity/MyMainActivity;

    .line 821
    move-object/from16 v0, v16

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 823
    .local v16, "intent_home":Landroid/content/Intent;
    const-string v21, "acquire_url_start"

    const-string v22, ""

    move-object/from16 v0, v16

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 824
    const/high16 v21, 0x10000000

    move-object/from16 v0, v16

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 825
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 828
    .end local v16    # "intent_home":Landroid/content/Intent;
    :sswitch_d
    new-instance v21, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    .line 829
    const-class v23, Lcom/aio/downloader/activity/MySettingsActivity;

    invoke-direct/range {v21 .. v23}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 828
    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 832
    :sswitch_e
    const-string v19, "https://play.google.com/store/apps/details?id=com.evzapp.cleanmaster"

    .line 833
    .local v19, "path":Ljava/lang/String;
    new-instance v10, Landroid/content/Intent;

    invoke-direct {v10}, Landroid/content/Intent;-><init>()V

    .line 834
    .local v10, "intent2":Landroid/content/Intent;
    const-string v21, "android.intent.action.VIEW"

    move-object/from16 v0, v21

    invoke-virtual {v10, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 835
    invoke-static/range {v19 .. v19}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    .line 836
    .local v5, "content_url":Landroid/net/Uri;
    invoke-virtual {v10, v5}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 837
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 840
    .end local v5    # "content_url":Landroid/net/Uri;
    .end local v10    # "intent2":Landroid/content/Intent;
    .end local v19    # "path":Ljava/lang/String;
    :sswitch_f
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->float_search_view:Lcom/aio/downloader/views/DeletableEditText;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v21

    invoke-interface/range {v21 .. v21}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v21

    const-string v22, ""

    invoke-virtual/range {v21 .. v22}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_10

    .line 841
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->float_search_view:Lcom/aio/downloader/views/DeletableEditText;

    move-object/from16 v21, v0

    const-string v22, "AIO Cleaner"

    invoke-virtual/range {v21 .. v22}, Lcom/aio/downloader/views/DeletableEditText;->setText(Ljava/lang/CharSequence;)V

    .line 843
    :cond_10
    new-instance v11, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    .line 844
    const-class v22, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    .line 843
    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-direct {v11, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 845
    .local v11, "intent3":Landroid/content/Intent;
    const-string v21, "searchid"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->float_search_view:Lcom/aio/downloader/views/DeletableEditText;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v22

    invoke-interface/range {v22 .. v22}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v11, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 846
    const-string v21, "searchint"

    const/16 v22, 0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    invoke-virtual {v11, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 847
    const/high16 v21, 0x10000000

    move/from16 v0, v21

    invoke-virtual {v11, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 848
    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 851
    .end local v11    # "intent3":Landroid/content/Intent;
    :sswitch_10
    new-instance v12, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    .line 852
    const-class v22, Lcom/aio/downloader/unstall/MyAppActivity;

    .line 851
    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-direct {v12, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 853
    .local v12, "intent4":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 856
    .end local v12    # "intent4":Landroid/content/Intent;
    :sswitch_11
    new-instance v21, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    .line 857
    const-class v23, Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    invoke-direct/range {v21 .. v23}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 856
    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 860
    :sswitch_12
    new-instance v21, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v22

    .line 861
    const-class v23, Lcom/aio/downloader/cleaner/JunkActivity;

    invoke-direct/range {v21 .. v23}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 860
    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 867
    :sswitch_13
    const/16 v18, 0x0

    .line 869
    .local v18, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_3
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v21

    .line 870
    const-string v22, "com.freepezzle.hexcrush"

    const/16 v23, 0x0

    invoke-virtual/range {v21 .. v23}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_3
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_3 .. :try_end_3} :catch_4

    move-result-object v18

    .line 874
    :goto_1
    if-nez v18, :cond_13

    .line 876
    :try_start_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->AIOCRUSHAPK:Ljava/io/File;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Ljava/io/File;->exists()Z

    move-result v21

    if-eqz v21, :cond_11

    .line 877
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->AIOCRUSHAPK:Ljava/io/File;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v21

    const-wide/32 v23, 0x19ee4c

    cmp-long v21, v21, v23

    if-ltz v21, :cond_11

    .line 878
    new-instance v3, Landroid/content/Intent;

    const-string v21, "android.intent.action.VIEW"

    move-object/from16 v0, v21

    invoke-direct {v3, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 880
    .local v3, "aa":Landroid/content/Intent;
    new-instance v21, Ljava/lang/StringBuilder;

    const-string v22, "file://"

    invoke-direct/range {v21 .. v22}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->AIOCRUSHAPK:Ljava/io/File;

    move-object/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    invoke-static/range {v21 .. v21}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v21

    .line 881
    const-string v22, "application/vnd.android.package-archive"

    .line 879
    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 882
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_3

    goto/16 :goto_0

    .line 911
    .end local v3    # "aa":Landroid/content/Intent;
    :catch_3
    move-exception v6

    .line 912
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 871
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v6

    .line 872
    .local v6, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v6}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 883
    .end local v6    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_11
    :try_start_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->AIOCRUSHSWF:Ljava/io/File;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Ljava/io/File;->exists()Z

    move-result v21

    if-eqz v21, :cond_12

    .line 884
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatActivity;->AIOCRUSHSWF:Ljava/io/File;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/FloatActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v21

    const-wide/32 v23, 0x19ee4c

    cmp-long v21, v21, v23

    if-ltz v21, :cond_12

    .line 885
    new-instance v21, Lcom/aio/downloader/activity/FloatActivity$4;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatActivity$4;-><init>(Lcom/aio/downloader/activity/FloatActivity;)V

    const/16 v22, 0x0

    move/from16 v0, v22

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v22, v0

    .line 903
    invoke-virtual/range {v21 .. v22}, Lcom/aio/downloader/activity/FloatActivity$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 905
    :cond_12
    new-instance v3, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v21

    .line 906
    const-class v22, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 905
    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-direct {v3, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 907
    .restart local v3    # "aa":Landroid/content/Intent;
    const-string v21, "myid"

    const-string v22, "com.freepezzle.hexcrush"

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 908
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_0

    .line 915
    .end local v3    # "aa":Landroid/content/Intent;
    :cond_13
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v21

    .line 917
    const-string v22, "com.freepezzle.hexcrush"

    .line 916
    invoke-virtual/range {v21 .. v22}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v13

    .line 918
    .local v13, "intent5":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v13}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 626
    :sswitch_data_0
    .sparse-switch
        0x7f0701b2 -> :sswitch_0
        0x7f0701b4 -> :sswitch_1
        0x7f0701b7 -> :sswitch_2
        0x7f0701ba -> :sswitch_3
        0x7f0701bd -> :sswitch_4
        0x7f0701be -> :sswitch_5
        0x7f0701bf -> :sswitch_6
        0x7f0701c2 -> :sswitch_7
        0x7f0701c4 -> :sswitch_8
        0x7f0701c7 -> :sswitch_9
        0x7f0701ca -> :sswitch_a
        0x7f0701cd -> :sswitch_b
        0x7f0701da -> :sswitch_c
        0x7f0701dc -> :sswitch_f
        0x7f0701de -> :sswitch_10
        0x7f0701e1 -> :sswitch_e
        0x7f0701e2 -> :sswitch_11
        0x7f0701e3 -> :sswitch_12
        0x7f0701e4 -> :sswitch_13
        0x7f0701e5 -> :sswitch_d
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 128
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 129
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "floatwindow_show"

    invoke-static {v0, v1}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 130
    const v0, 0x7f030044

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatActivity;->setContentView(I)V

    .line 131
    invoke-direct {p0}, Lcom/aio/downloader/activity/FloatActivity;->init()V

    .line 132
    invoke-direct {p0}, Lcom/aio/downloader/activity/FloatActivity;->findclick()V

    .line 133
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 447
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 448
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 449
    return-void
.end method

.method protected onResume()V
    .locals 14

    .prologue
    const/16 v13, 0xa

    const/4 v12, 0x1

    const/4 v11, 0x0

    const v10, -0x5e5049

    const v9, -0xde690d

    .line 271
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 272
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 274
    const-string v6, "floattag"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "bright="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 275
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v6

    if-ne v6, v12, :cond_9

    .line 276
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_brightness:Landroid/widget/ImageView;

    .line 277
    const v7, 0x7f0200a2

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 293
    :cond_0
    :goto_0
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->wm:Landroid/net/wifi/WifiManager;

    invoke-virtual {v6}, Landroid/net/wifi/WifiManager;->getWifiState()I

    move-result v6

    if-ne v6, v12, :cond_1

    .line 295
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_wifi:Landroid/widget/ImageView;

    const v7, 0x7f0200af

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 296
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_wifi:Landroid/widget/TextView;

    invoke-virtual {v6, v10}, Landroid/widget/TextView;->setTextColor(I)V

    .line 298
    :cond_1
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->wm:Landroid/net/wifi/WifiManager;

    invoke-virtual {v6}, Landroid/net/wifi/WifiManager;->getWifiState()I

    move-result v6

    const/4 v7, 0x3

    if-ne v6, v7, :cond_2

    .line 300
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_wifi:Landroid/widget/ImageView;

    const v7, 0x7f0200b0

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 301
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_wifi:Landroid/widget/TextView;

    invoke-virtual {v6, v9}, Landroid/widget/TextView;->setTextColor(I)V

    .line 305
    :cond_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {p0, v6}, Lcom/aio/downloader/activity/FloatActivity;->isOPen(Landroid/content/Context;)Z

    move-result v6

    if-eqz v6, :cond_c

    .line 306
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_gps:Landroid/widget/ImageView;

    const v7, 0x7f020092

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 307
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_gps:Landroid/widget/TextView;

    invoke-virtual {v6, v9}, Landroid/widget/TextView;->setTextColor(I)V

    .line 315
    :goto_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v6

    .line 316
    const-string v7, "accelerometer_rotation"

    .line 314
    invoke-static {v6, v7, v11}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v6

    if-nez v6, :cond_d

    .line 317
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_auto_rotate:Landroid/widget/ImageView;

    .line 318
    const v7, 0x7f0200a5

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 319
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_auto_rotate:Landroid/widget/TextView;

    invoke-virtual {v6, v10}, Landroid/widget/TextView;->setTextColor(I)V

    .line 326
    :goto_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/aio/downloader/activity/FloatActivity;->getScreenOffTime(Landroid/content/Context;)I

    move-result v6

    const v7, 0x927c0

    if-ne v6, v7, :cond_e

    .line 327
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_sleep:Landroid/widget/ImageView;

    const v7, 0x7f0200a7

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 340
    :cond_3
    :goto_3
    iget v6, p0, Lcom/aio/downloader/activity/FloatActivity;->current:I

    if-lez v6, :cond_4

    .line 341
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_vibaration:Landroid/widget/ImageView;

    .line 342
    const v7, 0x7f0200ad

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 343
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_vibaration:Landroid/widget/TextView;

    invoke-virtual {v6, v10}, Landroid/widget/TextView;->setTextColor(I)V

    .line 345
    :cond_4
    iget v6, p0, Lcom/aio/downloader/activity/FloatActivity;->current:I

    if-nez v6, :cond_5

    .line 346
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_vibaration:Landroid/widget/ImageView;

    .line 347
    const v7, 0x7f0200ae

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 348
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_vibaration:Landroid/widget/TextView;

    invoke-virtual {v6, v9}, Landroid/widget/TextView;->setTextColor(I)V

    .line 351
    :cond_5
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lcom/aio/downloader/activity/FloatActivity;->getAirplaneMode(Landroid/content/Context;)Z

    move-result v6

    if-eqz v6, :cond_13

    .line 352
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_airplane:Landroid/widget/ImageView;

    .line 353
    const v7, 0x7f02009b

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 354
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_airplane:Landroid/widget/TextView;

    invoke-virtual {v6, v9}, Landroid/widget/TextView;->setTextColor(I)V

    .line 361
    :goto_4
    iget v6, p0, Lcom/aio/downloader/activity/FloatActivity;->state_blue:I

    if-ne v6, v13, :cond_6

    .line 362
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_buletooth:Landroid/widget/ImageView;

    .line 363
    const v7, 0x7f02009d

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 364
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_buletooth:Landroid/widget/TextView;

    invoke-virtual {v6, v10}, Landroid/widget/TextView;->setTextColor(I)V

    .line 366
    :cond_6
    iget v6, p0, Lcom/aio/downloader/activity/FloatActivity;->state_blue:I

    const/16 v7, 0xc

    if-ne v6, v7, :cond_7

    .line 367
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_buletooth:Landroid/widget/ImageView;

    .line 368
    const v7, 0x7f02009e

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 369
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_buletooth:Landroid/widget/TextView;

    invoke-virtual {v6, v9}, Landroid/widget/TextView;->setTextColor(I)V

    .line 372
    :cond_7
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getRunningProcess()Ljava/util/List;

    move-result-object v6

    iput-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->list:Ljava/util/List;

    .line 373
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->list:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v6

    if-nez v6, :cond_8

    .line 374
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->infos:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->clear()V

    .line 375
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 377
    .local v5, "pm":Landroid/content/pm/PackageManager;
    const/16 v6, 0x2000

    invoke-virtual {v5, v6}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v0

    .line 378
    .local v0, "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_5
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v6

    if-lt v1, v6, :cond_14

    .line 392
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->infos:Ljava/util/List;

    iput-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->list:Ljava/util/List;

    .line 395
    .end local v0    # "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    .end local v1    # "i":I
    .end local v5    # "pm":Landroid/content/pm/PackageManager;
    :cond_8
    new-instance v3, Lcom/aio/downloader/adapter/ListAdapter;

    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->list:Ljava/util/List;

    invoke-direct {v3, v6, p0}, Lcom/aio/downloader/adapter/ListAdapter;-><init>(Ljava/util/List;Landroid/content/Context;)V

    .line 396
    .local v3, "mAdapter":Lcom/aio/downloader/adapter/ListAdapter;
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->mGridView:Landroid/widget/GridView;

    invoke-virtual {v6, v3}, Landroid/widget/GridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 398
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    .line 399
    const/high16 v7, 0x425c0000    # 55.0f

    .line 398
    invoke-direct {p0, v6, v7}, Lcom/aio/downloader/activity/FloatActivity;->dip2px(Landroid/content/Context;F)I

    move-result v6

    .line 399
    mul-int/lit8 v6, v6, 0xa

    const/4 v7, -0x2

    .line 398
    invoke-direct {v4, v6, v7}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 400
    .local v4, "params":Landroid/widget/LinearLayout$LayoutParams;
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->mGridView:Landroid/widget/GridView;

    invoke-virtual {v6, v4}, Landroid/widget/GridView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 401
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->mGridView:Landroid/widget/GridView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    const/high16 v8, 0x42200000    # 40.0f

    invoke-direct {p0, v7, v8}, Lcom/aio/downloader/activity/FloatActivity;->dip2px(Landroid/content/Context;F)I

    move-result v7

    invoke-virtual {v6, v7}, Landroid/widget/GridView;->setColumnWidth(I)V

    .line 402
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->mGridView:Landroid/widget/GridView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    const/high16 v8, 0x41700000    # 15.0f

    invoke-direct {p0, v7, v8}, Lcom/aio/downloader/activity/FloatActivity;->dip2px(Landroid/content/Context;F)I

    move-result v7

    invoke-virtual {v6, v7}, Landroid/widget/GridView;->setHorizontalSpacing(I)V

    .line 403
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->mGridView:Landroid/widget/GridView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    const/high16 v8, 0x41a00000    # 20.0f

    invoke-direct {p0, v7, v8}, Lcom/aio/downloader/activity/FloatActivity;->dip2px(Landroid/content/Context;F)I

    move-result v7

    invoke-virtual {v6, v7}, Landroid/widget/GridView;->setVerticalSpacing(I)V

    .line 404
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->mGridView:Landroid/widget/GridView;

    invoke-virtual {v6, v11}, Landroid/widget/GridView;->setStretchMode(I)V

    .line 405
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->mGridView:Landroid/widget/GridView;

    invoke-virtual {v6, v13}, Landroid/widget/GridView;->setNumColumns(I)V

    .line 407
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->mGridView:Landroid/widget/GridView;

    new-instance v7, Lcom/aio/downloader/activity/FloatActivity$2;

    invoke-direct {v7, p0}, Lcom/aio/downloader/activity/FloatActivity$2;-><init>(Lcom/aio/downloader/activity/FloatActivity;)V

    invoke-virtual {v6, v7}, Landroid/widget/GridView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 429
    new-instance v6, Landroid/os/Handler;

    invoke-direct {v6}, Landroid/os/Handler;-><init>()V

    new-instance v7, Lcom/aio/downloader/activity/FloatActivity$3;

    invoke-direct {v7, p0}, Lcom/aio/downloader/activity/FloatActivity$3;-><init>(Lcom/aio/downloader/activity/FloatActivity;)V

    .line 440
    const-wide/16 v8, 0x190

    .line 429
    invoke-virtual {v6, v7, v8, v9}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 442
    return-void

    .line 278
    .end local v3    # "mAdapter":Lcom/aio/downloader/adapter/ListAdapter;
    .end local v4    # "params":Landroid/widget/LinearLayout$LayoutParams;
    :cond_9
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v6

    if-lez v6, :cond_a

    .line 279
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v6

    const/16 v7, 0x40

    if-gt v6, v7, :cond_a

    .line 280
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_brightness:Landroid/widget/ImageView;

    .line 281
    const v7, 0x7f0200a0

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 282
    :cond_a
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v6

    const/16 v7, 0x40

    if-le v6, v7, :cond_b

    .line 283
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v6

    const/16 v7, 0x7f

    if-gt v6, v7, :cond_b

    .line 284
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_brightness:Landroid/widget/ImageView;

    .line 285
    const v7, 0x7f0200a1

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 286
    :cond_b
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v6

    const/16 v7, 0x7f

    if-le v6, v7, :cond_0

    .line 287
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatActivity;->getScreenBrightness(Landroid/content/Context;)I

    move-result v6

    const/16 v7, 0xff

    if-gt v6, v7, :cond_0

    .line 288
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_brightness:Landroid/widget/ImageView;

    .line 289
    const v7, 0x7f02009f

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 309
    :cond_c
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_gps:Landroid/widget/ImageView;

    const v7, 0x7f020091

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 310
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_gps:Landroid/widget/TextView;

    invoke-virtual {v6, v10}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_1

    .line 321
    :cond_d
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_auto_rotate:Landroid/widget/ImageView;

    .line 322
    const v7, 0x7f0200a6

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 323
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_auto_rotate:Landroid/widget/TextView;

    invoke-virtual {v6, v9}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_2

    .line 328
    :cond_e
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/aio/downloader/activity/FloatActivity;->getScreenOffTime(Landroid/content/Context;)I

    move-result v6

    const/16 v7, 0x3a98

    if-ne v6, v7, :cond_f

    .line 329
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_sleep:Landroid/widget/ImageView;

    const v7, 0x7f0200a8

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 330
    :cond_f
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/aio/downloader/activity/FloatActivity;->getScreenOffTime(Landroid/content/Context;)I

    move-result v6

    const/16 v7, 0x7530

    if-ne v6, v7, :cond_10

    .line 331
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_sleep:Landroid/widget/ImageView;

    const v7, 0x7f0200ab

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 332
    :cond_10
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/aio/downloader/activity/FloatActivity;->getScreenOffTime(Landroid/content/Context;)I

    move-result v6

    const v7, 0xea60

    if-ne v6, v7, :cond_11

    .line 333
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_sleep:Landroid/widget/ImageView;

    const v7, 0x7f0200a9

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 334
    :cond_11
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/aio/downloader/activity/FloatActivity;->getScreenOffTime(Landroid/content/Context;)I

    move-result v6

    const v7, 0x1d4c0

    if-ne v6, v7, :cond_12

    .line 335
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_sleep:Landroid/widget/ImageView;

    const v7, 0x7f0200aa

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 336
    :cond_12
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/aio/downloader/activity/FloatActivity;->getScreenOffTime(Landroid/content/Context;)I

    move-result v6

    const v7, 0x493e0

    if-ne v6, v7, :cond_3

    .line 337
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_sleep:Landroid/widget/ImageView;

    const v7, 0x7f0200ac

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 356
    :cond_13
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->iv_airplane:Landroid/widget/ImageView;

    .line 357
    const v7, 0x7f02009a

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 358
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->tv_airplane:Landroid/widget/TextView;

    invoke-virtual {v6, v10}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_4

    .line 379
    .restart local v0    # "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    .restart local v1    # "i":I
    .restart local v5    # "pm":Landroid/content/pm/PackageManager;
    :cond_14
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/pm/ApplicationInfo;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/pm/ApplicationInfo;

    iget v6, v6, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v6, v6, 0x1

    if-nez v6, :cond_15

    .line 380
    new-instance v2, Lcom/aio/downloader/model/Programe;

    invoke-direct {v2}, Lcom/aio/downloader/model/Programe;-><init>()V

    .line 381
    .local v2, "info":Lcom/aio/downloader/model/Programe;
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v5, v6}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v6

    invoke-interface {v6}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v6}, Lcom/aio/downloader/model/Programe;->setName(Ljava/lang/String;)V

    .line 382
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v6, v5}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v2, v6}, Lcom/aio/downloader/model/Programe;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 383
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/pm/ApplicationInfo;

    iget-object v6, v6, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v2, v6}, Lcom/aio/downloader/model/Programe;->setPackagename(Ljava/lang/String;)V

    .line 384
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->infos:Ljava/util/List;

    invoke-interface {v6, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 385
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/pm/ApplicationInfo;

    iget-object v6, v6, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const-string v7, "com.allinone.free"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_15

    .line 386
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/pm/ApplicationInfo;

    iget-object v6, v6, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    .line 387
    const-string v7, "com.aio.downloader"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_15

    .line 388
    iget-object v6, p0, Lcom/aio/downloader/activity/FloatActivity;->infos:Ljava/util/List;

    invoke-interface {v6, v2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 378
    .end local v2    # "info":Lcom/aio/downloader/model/Programe;
    :cond_15
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_5
.end method
