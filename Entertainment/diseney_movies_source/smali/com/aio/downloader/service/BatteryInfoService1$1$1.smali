.class Lcom/aio/downloader/service/BatteryInfoService1$1$1;
.super Ljava/lang/Object;
.source "BatteryInfoService1.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/BatteryInfoService1$1;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;

.field private final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/BatteryInfoService1$1;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;

    iput-object p2, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->val$context:Landroid/content/Context;

    .line 106
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/BatteryInfoService1$1$1;)Lcom/aio/downloader/service/BatteryInfoService1$1;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 11

    .prologue
    .line 111
    const/4 v3, 0x0

    .line 113
    .local v3, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v6, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->val$context:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 115
    const-string v7, "com.evzapp.cleanmaster"

    const/4 v8, 0x0

    .line 114
    invoke-virtual {v6, v7, v8}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 119
    :goto_0
    if-nez v3, :cond_0

    .line 120
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 121
    iget-object v8, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->this$0:Lcom/aio/downloader/service/BatteryInfoService1;
    invoke-static {v8}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$4(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/service/BatteryInfoService1;

    move-result-object v8

    invoke-virtual {v8}, Lcom/aio/downloader/service/BatteryInfoService1;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    invoke-static {v8}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->GetPowerAPPClickTime(Landroid/content/Context;)J

    move-result-wide v8

    cmp-long v6, v6, v8

    if-lez v6, :cond_0

    .line 123
    new-instance v6, Lcom/aio/downloader/service/BatteryInfoService1$1$1$1;

    invoke-direct {v6, p0}, Lcom/aio/downloader/service/BatteryInfoService1$1$1$1;-><init>(Lcom/aio/downloader/service/BatteryInfoService1$1$1;)V

    .line 133
    invoke-virtual {v6}, Lcom/aio/downloader/service/BatteryInfoService1$1$1$1;->start()V

    .line 135
    iget-object v6, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->val$context:Landroid/content/Context;

    const-string v7, "batteryapp"

    invoke-static {v6, v7}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 137
    iget-object v6, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->this$0:Lcom/aio/downloader/service/BatteryInfoService1;
    invoke-static {v6}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$4(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/service/BatteryInfoService1;

    move-result-object v6

    invoke-virtual {v6}, Lcom/aio/downloader/service/BatteryInfoService1;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    .line 138
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    .line 139
    const-wide/32 v9, 0x1499700

    .line 138
    add-long/2addr v7, v9

    .line 136
    invoke-static {v6, v7, v8}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetPowerAPPClickTime(Landroid/content/Context;J)V

    .line 141
    iget-object v6, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;

    new-instance v7, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;

    iget-object v8, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->val$context:Landroid/content/Context;

    invoke-direct {v7, p0, v8}, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;-><init>(Lcom/aio/downloader/service/BatteryInfoService1$1$1;Landroid/content/Context;)V

    invoke-static {v6, v7}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$1(Lcom/aio/downloader/service/BatteryInfoService1$1;Landroid/view/View$OnClickListener;)V

    .line 234
    iget-object v6, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;

    new-instance v7, Lcom/aio/downloader/dialog/Batterylow;

    iget-object v8, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->val$context:Landroid/content/Context;

    .line 235
    const v9, 0x7f0c0010

    iget-object v10, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->itemsOnClick4:Landroid/view/View$OnClickListener;
    invoke-static {v10}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$2(Lcom/aio/downloader/service/BatteryInfoService1$1;)Landroid/view/View$OnClickListener;

    move-result-object v10

    invoke-direct {v7, v8, v9, v10}, Lcom/aio/downloader/dialog/Batterylow;-><init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;)V

    .line 234
    invoke-static {v6, v7}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$3(Lcom/aio/downloader/service/BatteryInfoService1$1;Lcom/aio/downloader/dialog/Batterylow;)V

    .line 236
    iget-object v6, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->batterylow:Lcom/aio/downloader/dialog/Batterylow;
    invoke-static {v6}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/dialog/Batterylow;

    move-result-object v6

    const/4 v7, 0x1

    invoke-virtual {v6, v7}, Lcom/aio/downloader/dialog/Batterylow;->setCanceledOnTouchOutside(Z)V

    .line 237
    iget-object v6, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->batterylow:Lcom/aio/downloader/dialog/Batterylow;
    invoke-static {v6}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/dialog/Batterylow;

    move-result-object v6

    .line 238
    invoke-virtual {v6}, Lcom/aio/downloader/dialog/Batterylow;->getWindow()Landroid/view/Window;

    move-result-object v6

    .line 240
    const/16 v7, 0x7d3

    .line 239
    invoke-virtual {v6, v7}, Landroid/view/Window;->setType(I)V

    .line 241
    iget-object v6, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->batterylow:Lcom/aio/downloader/dialog/Batterylow;
    invoke-static {v6}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/dialog/Batterylow;

    move-result-object v6

    invoke-virtual {v6}, Lcom/aio/downloader/dialog/Batterylow;->show()V

    .line 242
    iget-object v6, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->batterylow:Lcom/aio/downloader/dialog/Batterylow;
    invoke-static {v6}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/dialog/Batterylow;

    move-result-object v6

    invoke-virtual {v6}, Lcom/aio/downloader/dialog/Batterylow;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 244
    .local v0, "dialogWindow":Landroid/view/Window;
    invoke-virtual {v0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v2

    .line 245
    .local v2, "lp":Landroid/view/WindowManager$LayoutParams;
    const/16 v6, 0x50

    invoke-virtual {v0, v6}, Landroid/view/Window;->setGravity(I)V

    .line 246
    iget-object v6, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->val$context:Landroid/content/Context;

    .line 247
    const-string v7, "window"

    invoke-virtual {v6, v7}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    .line 246
    check-cast v5, Landroid/view/WindowManager;

    .line 249
    .local v5, "wm":Landroid/view/WindowManager;
    invoke-interface {v5}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/Display;->getWidth()I

    move-result v4

    .line 252
    .local v4, "width":I
    iput v4, v2, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 258
    invoke-virtual {v0, v2}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 260
    .end local v0    # "dialogWindow":Landroid/view/Window;
    .end local v2    # "lp":Landroid/view/WindowManager$LayoutParams;
    .end local v4    # "width":I
    .end local v5    # "wm":Landroid/view/WindowManager;
    :cond_0
    return-void

    .line 116
    :catch_0
    move-exception v1

    .line 117
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_0
.end method
