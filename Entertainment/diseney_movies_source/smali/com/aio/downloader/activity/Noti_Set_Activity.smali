.class public Lcom/aio/downloader/activity/Noti_Set_Activity;
.super Landroid/app/Activity;
.source "Noti_Set_Activity.java"


# instance fields
.field private cb_battery_change:Landroid/widget/CheckBox;

.field private cb_battery_haodian:Landroid/widget/CheckBox;

.field private cb_battery_low:Landroid/widget/CheckBox;

.field private cb_clean_cpu:Landroid/widget/CheckBox;

.field private cb_clean_ram:Landroid/widget/CheckBox;

.field private cb_clean_slow:Landroid/widget/CheckBox;

.field private cb_clean_storage:Landroid/widget/CheckBox;

.field private cb_clean_temp:Landroid/widget/CheckBox;

.field private noti_fan:Landroid/widget/ImageView;

.field private userInfo:Landroid/content/SharedPreferences;

.field private userInfo_b_change:Landroid/content/SharedPreferences;

.field private userInfo_b_low:Landroid/content/SharedPreferences;

.field private userInfo_cpu:Landroid/content/SharedPreferences;

.field private userInfo_ram:Landroid/content/SharedPreferences;

.field private userInfo_slow:Landroid/content/SharedPreferences;

.field private userInfo_storage:Landroid/content/SharedPreferences;

.field private userInfo_temp:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/Noti_Set_Activity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/Noti_Set_Activity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_b_low:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/Noti_Set_Activity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_b_change:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/Noti_Set_Activity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_temp:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/Noti_Set_Activity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_ram:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/Noti_Set_Activity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_storage:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/Noti_Set_Activity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_slow:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/Noti_Set_Activity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_cpu:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method private click()V
    .locals 2

    .prologue
    .line 136
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_battery_haodian:Landroid/widget/CheckBox;

    .line 137
    new-instance v1, Lcom/aio/downloader/activity/Noti_Set_Activity$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/Noti_Set_Activity$1;-><init>(Lcom/aio/downloader/activity/Noti_Set_Activity;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 150
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_battery_low:Landroid/widget/CheckBox;

    .line 151
    new-instance v1, Lcom/aio/downloader/activity/Noti_Set_Activity$2;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/Noti_Set_Activity$2;-><init>(Lcom/aio/downloader/activity/Noti_Set_Activity;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 168
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_battery_change:Landroid/widget/CheckBox;

    .line 169
    new-instance v1, Lcom/aio/downloader/activity/Noti_Set_Activity$3;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/Noti_Set_Activity$3;-><init>(Lcom/aio/downloader/activity/Noti_Set_Activity;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 184
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_temp:Landroid/widget/CheckBox;

    new-instance v1, Lcom/aio/downloader/activity/Noti_Set_Activity$4;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/Noti_Set_Activity$4;-><init>(Lcom/aio/downloader/activity/Noti_Set_Activity;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 196
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_ram:Landroid/widget/CheckBox;

    new-instance v1, Lcom/aio/downloader/activity/Noti_Set_Activity$5;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/Noti_Set_Activity$5;-><init>(Lcom/aio/downloader/activity/Noti_Set_Activity;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 208
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_storage:Landroid/widget/CheckBox;

    .line 209
    new-instance v1, Lcom/aio/downloader/activity/Noti_Set_Activity$6;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/Noti_Set_Activity$6;-><init>(Lcom/aio/downloader/activity/Noti_Set_Activity;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 224
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_slow:Landroid/widget/CheckBox;

    new-instance v1, Lcom/aio/downloader/activity/Noti_Set_Activity$7;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/Noti_Set_Activity$7;-><init>(Lcom/aio/downloader/activity/Noti_Set_Activity;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 236
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_cpu:Landroid/widget/CheckBox;

    new-instance v1, Lcom/aio/downloader/activity/Noti_Set_Activity$8;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/Noti_Set_Activity$8;-><init>(Lcom/aio/downloader/activity/Noti_Set_Activity;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 249
    return-void
.end method

.method private init()V
    .locals 2

    .prologue
    .line 252
    const v0, 0x7f070328

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->noti_fan:Landroid/widget/ImageView;

    .line 253
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->noti_fan:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/activity/Noti_Set_Activity$9;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/Noti_Set_Activity$9;-><init>(Lcom/aio/downloader/activity/Noti_Set_Activity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 261
    const v0, 0x7f070329

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_battery_low:Landroid/widget/CheckBox;

    .line 262
    const v0, 0x7f07032a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_battery_change:Landroid/widget/CheckBox;

    .line 263
    const v0, 0x7f07032b

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_battery_haodian:Landroid/widget/CheckBox;

    .line 264
    const v0, 0x7f07032c

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_ram:Landroid/widget/CheckBox;

    .line 265
    const v0, 0x7f07032d

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_storage:Landroid/widget/CheckBox;

    .line 266
    const v0, 0x7f07032e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_cpu:Landroid/widget/CheckBox;

    .line 267
    const v0, 0x7f07032f

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_temp:Landroid/widget/CheckBox;

    .line 268
    const v0, 0x7f070330

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_slow:Landroid/widget/CheckBox;

    .line 269
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 22
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 41
    invoke-super/range {p0 .. p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 42
    const v19, 0x7f03008f

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/Noti_Set_Activity;->setContentView(I)V

    .line 43
    new-instance v19, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v20

    const-class v21, Lcom/aio/downloader/service/ServiceToggle;

    invoke-direct/range {v19 .. v21}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/Noti_Set_Activity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 44
    const-string v19, "downloadcomplete"

    const/16 v20, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo:Landroid/content/SharedPreferences;

    .line 45
    const-string v19, "battery_low"

    const/16 v20, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_b_low:Landroid/content/SharedPreferences;

    .line 47
    const-string v19, "app_update"

    const/16 v20, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_b_change:Landroid/content/SharedPreferences;

    .line 48
    const-string v19, "install_success"

    const/16 v20, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_ram:Landroid/content/SharedPreferences;

    .line 50
    const-string v19, "appnotdownload"

    const/16 v20, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_storage:Landroid/content/SharedPreferences;

    .line 51
    const-string v19, "clean_cpu"

    const/16 v20, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_cpu:Landroid/content/SharedPreferences;

    .line 52
    const-string v19, "battery_temp"

    const/16 v20, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_temp:Landroid/content/SharedPreferences;

    .line 53
    const-string v19, "clean_slow"

    const/16 v20, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/Noti_Set_Activity;->userInfo_slow:Landroid/content/SharedPreferences;

    .line 54
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->init()V

    .line 55
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->click()V

    .line 58
    const-string v19, "downloadcomplete"

    const/16 v20, 0x0

    .line 57
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v13

    .line 59
    .local v13, "userInfo_haodian":Landroid/content/SharedPreferences;
    const-string v19, "wycdc"

    const/16 v20, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-interface {v13, v0, v1}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v3

    .line 60
    .local v3, "show":I
    if-nez v3, :cond_8

    .line 61
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_battery_haodian:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x1

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 66
    :cond_0
    :goto_0
    const-string v19, "battery_low"

    .line 67
    const/16 v20, 0x0

    .line 66
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v14

    .line 68
    .local v14, "userInfo_low":Landroid/content/SharedPreferences;
    const-string v19, "b_low"

    const/16 v20, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-interface {v14, v0, v1}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v6

    .line 69
    .local v6, "show_low":I
    if-nez v6, :cond_9

    .line 70
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_battery_low:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x1

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 78
    :cond_1
    :goto_1
    const-string v19, "app_update"

    const/16 v20, 0x0

    .line 77
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v11

    .line 79
    .local v11, "userInfo_change":Landroid/content/SharedPreferences;
    const-string v19, "wycupdate"

    const/16 v20, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-interface {v11, v0, v1}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v4

    .line 80
    .local v4, "show_change":I
    if-nez v4, :cond_a

    .line 81
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_battery_change:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x1

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 86
    :cond_2
    :goto_2
    const-string v19, "battery_temp"

    .line 87
    const/16 v20, 0x0

    .line 86
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v18

    .line 88
    .local v18, "userInfo_temp":Landroid/content/SharedPreferences;
    const-string v19, "b_temp"

    const/16 v20, 0x0

    invoke-interface/range {v18 .. v20}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v10

    .line 89
    .local v10, "show_temp":I
    if-nez v10, :cond_b

    .line 90
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_temp:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x1

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 95
    :cond_3
    :goto_3
    const-string v19, "install_success"

    .line 96
    const/16 v20, 0x0

    .line 95
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v15

    .line 97
    .local v15, "userInfo_ram":Landroid/content/SharedPreferences;
    const-string v19, "wycis"

    const/16 v20, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-interface {v15, v0, v1}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v7

    .line 98
    .local v7, "show_ram":I
    if-nez v7, :cond_c

    .line 99
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_ram:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x1

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 105
    :cond_4
    :goto_4
    const-string v19, "appnotdownload"

    const/16 v20, 0x0

    .line 104
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v17

    .line 106
    .local v17, "userInfo_storage":Landroid/content/SharedPreferences;
    const-string v19, "wycand"

    const/16 v20, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v9

    .line 107
    .local v9, "show_storage":I
    if-nez v9, :cond_d

    .line 108
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_storage:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x1

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 114
    :cond_5
    :goto_5
    const-string v19, "clean_slow"

    .line 115
    const/16 v20, 0x0

    .line 114
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v16

    .line 116
    .local v16, "userInfo_slow":Landroid/content/SharedPreferences;
    const-string v19, "c_slow"

    const/16 v20, 0x0

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v8

    .line 117
    .local v8, "show_slow":I
    if-nez v8, :cond_e

    .line 118
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_slow:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x1

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 123
    :cond_6
    :goto_6
    const-string v19, "clean_cpu"

    .line 124
    const/16 v20, 0x0

    .line 123
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/activity/Noti_Set_Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v12

    .line 125
    .local v12, "userInfo_cpu":Landroid/content/SharedPreferences;
    const-string v19, "c_cpu"

    const/16 v20, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-interface {v12, v0, v1}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v5

    .line 126
    .local v5, "show_cpu":I
    if-nez v8, :cond_f

    .line 127
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_cpu:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x1

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 132
    :cond_7
    :goto_7
    return-void

    .line 62
    .end local v4    # "show_change":I
    .end local v5    # "show_cpu":I
    .end local v6    # "show_low":I
    .end local v7    # "show_ram":I
    .end local v8    # "show_slow":I
    .end local v9    # "show_storage":I
    .end local v10    # "show_temp":I
    .end local v11    # "userInfo_change":Landroid/content/SharedPreferences;
    .end local v12    # "userInfo_cpu":Landroid/content/SharedPreferences;
    .end local v14    # "userInfo_low":Landroid/content/SharedPreferences;
    .end local v15    # "userInfo_ram":Landroid/content/SharedPreferences;
    .end local v16    # "userInfo_slow":Landroid/content/SharedPreferences;
    .end local v17    # "userInfo_storage":Landroid/content/SharedPreferences;
    .end local v18    # "userInfo_temp":Landroid/content/SharedPreferences;
    :cond_8
    const/16 v19, 0x1

    move/from16 v0, v19

    if-ne v3, v0, :cond_0

    .line 63
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_battery_haodian:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_0

    .line 72
    .restart local v6    # "show_low":I
    .restart local v14    # "userInfo_low":Landroid/content/SharedPreferences;
    :cond_9
    const/16 v19, 0x1

    move/from16 v0, v19

    if-ne v6, v0, :cond_1

    .line 73
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_battery_low:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_1

    .line 82
    .restart local v4    # "show_change":I
    .restart local v11    # "userInfo_change":Landroid/content/SharedPreferences;
    :cond_a
    const/16 v19, 0x1

    move/from16 v0, v19

    if-ne v4, v0, :cond_2

    .line 83
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_battery_change:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_2

    .line 91
    .restart local v10    # "show_temp":I
    .restart local v18    # "userInfo_temp":Landroid/content/SharedPreferences;
    :cond_b
    const/16 v19, 0x1

    move/from16 v0, v19

    if-ne v10, v0, :cond_3

    .line 92
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_temp:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_3

    .line 100
    .restart local v7    # "show_ram":I
    .restart local v15    # "userInfo_ram":Landroid/content/SharedPreferences;
    :cond_c
    const/16 v19, 0x1

    move/from16 v0, v19

    if-ne v7, v0, :cond_4

    .line 101
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_ram:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_4

    .line 109
    .restart local v9    # "show_storage":I
    .restart local v17    # "userInfo_storage":Landroid/content/SharedPreferences;
    :cond_d
    const/16 v19, 0x1

    move/from16 v0, v19

    if-ne v9, v0, :cond_5

    .line 110
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_storage:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_5

    .line 119
    .restart local v8    # "show_slow":I
    .restart local v16    # "userInfo_slow":Landroid/content/SharedPreferences;
    :cond_e
    const/16 v19, 0x1

    move/from16 v0, v19

    if-ne v8, v0, :cond_6

    .line 120
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_slow:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_6

    .line 128
    .restart local v5    # "show_cpu":I
    .restart local v12    # "userInfo_cpu":Landroid/content/SharedPreferences;
    :cond_f
    const/16 v19, 0x1

    move/from16 v0, v19

    if-ne v5, v0, :cond_7

    .line 129
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/Noti_Set_Activity;->cb_clean_cpu:Landroid/widget/CheckBox;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual/range {v19 .. v20}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_7
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 281
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 282
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 283
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 274
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 275
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 276
    return-void
.end method
