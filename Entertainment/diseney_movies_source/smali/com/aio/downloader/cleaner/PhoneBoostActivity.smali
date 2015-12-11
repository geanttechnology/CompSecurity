.class public Lcom/aio/downloader/cleaner/PhoneBoostActivity;
.super Landroid/app/Activity;
.source "PhoneBoostActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private adapter:Lcom/wjj/adapter/base/BoostPhoneAdapter;

.field private allsize:J

.field private app:Lcom/wjj/eneity/RuningApp;

.field private back:Lcom/aio/downloader/views/LImageButton;

.field private bt_clean:Landroid/widget/Button;

.field private bt_ing:Landroid/widget/Button;

.field private bt_stop:Landroid/widget/Button;

.field private deep_bt:Landroid/widget/Button;

.field private handler:Landroid/os/Handler;

.field private isover:I

.field private listdata:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RuningApp;",
            ">;"
        }
    .end annotation
.end field

.field private lv_boost_list:Landroid/widget/ListView;

.field private mainview:Landroid/view/View;

.field private manager:Lcom/wjj/manager/BoostRuningAppManager;

.field private mlistener:Lcom/wjj/manager/BoostRuningAppManager$BoostRuningAppManagerListener;

.field private num:I

.field private pb_clean_cache:Landroid/widget/ProgressBar;

.field private pb_new:Landroid/widget/ProgressBar;

.field private pop:Landroid/widget/PopupWindow;

.field private pop_baimingdan:Landroid/widget/TextView;

.field private pop_kuaijie:Landroid/widget/TextView;

.field private pop_xuanfu:Landroid/widget/TextView;

.field private rl_top:Landroid/widget/RelativeLayout;

.field private total_memory:Landroid/widget/TextView;

.field private tv_clean_cache_status:Landroid/widget/TextView;

.field private tv_danwei:Landroid/widget/TextView;

.field private tv_neicun:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 65
    new-instance v0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity$1;-><init>(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;

    .line 408
    new-instance v0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity$2;-><init>(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->mlistener:Lcom/wjj/manager/BoostRuningAppManager$BoostRuningAppManagerListener;

    .line 49
    return-void
.end method

.method private AsyncData()V
    .locals 1

    .prologue
    .line 351
    new-instance v0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$6;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity$6;-><init>(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)V

    .line 359
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity$6;->start()V

    .line 360
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/cleaner/PhoneBoostActivity;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->listdata:Ljava/util/List;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->listdata:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/cleaner/PhoneBoostActivity;Lcom/wjj/eneity/RuningApp;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->app:Lcom/wjj/eneity/RuningApp;

    return-void
.end method

.method static synthetic access$11(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->tv_clean_cache_status:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Lcom/wjj/eneity/RuningApp;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->app:Lcom/wjj/eneity/RuningApp;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)I
    .locals 1

    .prologue
    .line 57
    iget v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->isover:I

    return v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_stop:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_clean:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->total_memory:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Lcom/wjj/adapter/base/BoostPhoneAdapter;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->adapter:Lcom/wjj/adapter/base/BoostPhoneAdapter;

    return-object v0
.end method

.method static synthetic access$20(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Lcom/wjj/manager/BoostRuningAppManager;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->manager:Lcom/wjj/manager/BoostRuningAppManager;

    return-object v0
.end method

.method static synthetic access$21(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Lcom/wjj/manager/BoostRuningAppManager$BoostRuningAppManagerListener;
    .locals 1

    .prologue
    .line 408
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->mlistener:Lcom/wjj/manager/BoostRuningAppManager$BoostRuningAppManagerListener;

    return-object v0
.end method

.method static synthetic access$22(Lcom/aio/downloader/cleaner/PhoneBoostActivity;I)V
    .locals 0

    .prologue
    .line 57
    iput p1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->isover:I

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)J
    .locals 2

    .prologue
    .line 54
    iget-wide v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->allsize:J

    return-wide v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/cleaner/PhoneBoostActivity;J)V
    .locals 0

    .prologue
    .line 54
    iput-wide p1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->allsize:J

    return-void
.end method

.method static synthetic access$5(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->tv_neicun:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->tv_danwei:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)I
    .locals 1

    .prologue
    .line 62
    iget v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->num:I

    return v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/cleaner/PhoneBoostActivity;I)V
    .locals 0

    .prologue
    .line 62
    iput p1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->num:I

    return-void
.end method

.method static synthetic access$9(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_new:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method private asyPb()V
    .locals 1

    .prologue
    .line 193
    new-instance v0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;-><init>(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)V

    .line 297
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity$3;->start()V

    .line 298
    return-void
.end method

.method private initView()V
    .locals 2

    .prologue
    .line 301
    const v0, 0x7f07007f

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->deep_bt:Landroid/widget/Button;

    .line 302
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->deep_bt:Landroid/widget/Button;

    new-instance v1, Lcom/aio/downloader/cleaner/PhoneBoostActivity$4;

    invoke-direct {v1, p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity$4;-><init>(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 310
    const v0, 0x7f070076

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->rl_top:Landroid/widget/RelativeLayout;

    .line 311
    const v0, 0x7f07007b

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_clean_cache:Landroid/widget/ProgressBar;

    .line 312
    const v0, 0x7f07007c

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->pb_new:Landroid/widget/ProgressBar;

    .line 313
    const v0, 0x7f070081

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_clean:Landroid/widget/Button;

    .line 314
    const v0, 0x7f070082

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_ing:Landroid/widget/Button;

    .line 315
    const v0, 0x7f07004f

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_stop:Landroid/widget/Button;

    .line 316
    const v0, 0x7f070077

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->back:Lcom/aio/downloader/views/LImageButton;

    .line 318
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_clean:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 319
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_ing:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 320
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_stop:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 321
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->back:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 322
    const v0, 0x7f07007e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->total_memory:Landroid/widget/TextView;

    .line 323
    const v0, 0x7f07007d

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->tv_clean_cache_status:Landroid/widget/TextView;

    .line 324
    const v0, 0x7f070079

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->tv_danwei:Landroid/widget/TextView;

    .line 325
    const v0, 0x7f070078

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->tv_neicun:Landroid/widget/TextView;

    .line 326
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->listdata:Ljava/util/List;

    .line 327
    const v0, 0x7f070080

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->lv_boost_list:Landroid/widget/ListView;

    .line 328
    new-instance v0, Lcom/wjj/manager/BoostRuningAppManager;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wjj/manager/BoostRuningAppManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->manager:Lcom/wjj/manager/BoostRuningAppManager;

    .line 330
    new-instance v0, Lcom/wjj/adapter/base/BoostPhoneAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wjj/adapter/base/BoostPhoneAdapter;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->adapter:Lcom/wjj/adapter/base/BoostPhoneAdapter;

    .line 331
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->lv_boost_list:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->adapter:Lcom/wjj/adapter/base/BoostPhoneAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 332
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->lv_boost_list:Landroid/widget/ListView;

    new-instance v1, Lcom/aio/downloader/cleaner/PhoneBoostActivity$5;

    invoke-direct {v1, p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity$5;-><init>(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 347
    return-void
.end method

.method private showNorma()V
    .locals 4

    .prologue
    .line 453
    const-string v0, "Are you sure to stop scanning ?"

    .line 454
    .local v0, "message":Ljava/lang/String;
    new-instance v1, Lcom/aio/downloader/views/LAlertDialog$Builder;

    invoke-direct {v1, p0}, Lcom/aio/downloader/views/LAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 455
    const-string v2, "Notice"

    invoke-virtual {v1, v2}, Lcom/aio/downloader/views/LAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/aio/downloader/views/LAlertDialog$Builder;

    move-result-object v1

    .line 456
    invoke-virtual {v1, v0}, Lcom/aio/downloader/views/LAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/aio/downloader/views/LAlertDialog$Builder;

    move-result-object v1

    .line 457
    const-string v2, "Cancel"

    .line 458
    new-instance v3, Lcom/aio/downloader/cleaner/PhoneBoostActivity$7;

    invoke-direct {v3, p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity$7;-><init>(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)V

    .line 457
    invoke-virtual {v1, v2, v3}, Lcom/aio/downloader/views/LAlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Lcom/aio/downloader/views/LAlertDialog$Builder;

    move-result-object v1

    .line 464
    const-string v2, "Stop"

    .line 465
    new-instance v3, Lcom/aio/downloader/cleaner/PhoneBoostActivity$8;

    invoke-direct {v3, p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity$8;-><init>(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)V

    .line 464
    invoke-virtual {v1, v2, v3}, Lcom/aio/downloader/views/LAlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Lcom/aio/downloader/views/LAlertDialog$Builder;

    move-result-object v1

    .line 474
    invoke-virtual {v1}, Lcom/aio/downloader/views/LAlertDialog$Builder;->show()Lcom/aio/downloader/views/LAlertDialog;

    .line 475
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 430
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v3

    sparse-switch v3, :sswitch_data_0

    .line 450
    :goto_0
    :sswitch_0
    return-void

    .line 432
    :sswitch_1
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->finish()V

    goto :goto_0

    .line 437
    :sswitch_2
    iget-object v3, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_clean:Landroid/widget/Button;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 438
    iget-object v3, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_ing:Landroid/widget/Button;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 439
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget-object v3, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->listdata:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lt v1, v3, :cond_0

    .line 442
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-class v4, Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 443
    .local v2, "ii":Landroid/content/Intent;
    iget-wide v3, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->allsize:J

    const-wide/16 v5, 0x400

    div-long/2addr v3, v5

    long-to-int v0, v3

    .line 444
    .local v0, "a":I
    const-string v3, "juti"

    invoke-virtual {v2, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 445
    invoke-virtual {p0, v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->startActivity(Landroid/content/Intent;)V

    .line 446
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->finish()V

    goto :goto_0

    .line 440
    .end local v0    # "a":I
    .end local v2    # "ii":Landroid/content/Intent;
    :cond_0
    iget-object v4, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->manager:Lcom/wjj/manager/BoostRuningAppManager;

    iget-object v3, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->listdata:Ljava/util/List;

    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/wjj/eneity/RuningApp;

    iget-object v3, v3, Lcom/wjj/eneity/RuningApp;->packname:Ljava/lang/String;

    invoke-virtual {v4, v3}, Lcom/wjj/manager/BoostRuningAppManager;->Killprogress(Ljava/lang/String;)V

    .line 439
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 430
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f07004f -> :sswitch_0
        0x7f070077 -> :sswitch_1
        0x7f070081 -> :sswitch_2
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 167
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 168
    const v0, 0x7f03000b

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->setContentView(I)V

    .line 169
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->initView()V

    .line 181
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->AsyncData()V

    .line 182
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->asyPb()V

    .line 184
    return-void
.end method
