.class Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;
.super Ljava/lang/Object;
.source "BatteryInfoService1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/BatteryInfoService1$1$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/aio/downloader/service/BatteryInfoService1$1$1;

.field private final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/BatteryInfoService1$1$1;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->this$2:Lcom/aio/downloader/service/BatteryInfoService1$1$1;

    iput-object p2, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->val$context:Landroid/content/Context;

    .line 141
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;)Lcom/aio/downloader/service/BatteryInfoService1$1$1;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->this$2:Lcom/aio/downloader/service/BatteryInfoService1$1$1;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/high16 v8, 0x10000000

    const/4 v7, 0x0

    .line 146
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v4

    packed-switch v4, :pswitch_data_0

    .line 231
    :goto_0
    return-void

    .line 148
    :pswitch_0
    iget-object v4, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->this$2:Lcom/aio/downloader/service/BatteryInfoService1$1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1$1;)Lcom/aio/downloader/service/BatteryInfoService1$1;

    move-result-object v4

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->batterylow:Lcom/aio/downloader/dialog/Batterylow;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/dialog/Batterylow;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/Batterylow;->dismiss()V

    goto :goto_0

    .line 151
    :pswitch_1
    iget-object v4, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->val$context:Landroid/content/Context;

    .line 152
    const-string v5, "batteryapp_click"

    .line 151
    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 153
    new-instance v4, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2$1;-><init>(Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;)V

    .line 163
    invoke-virtual {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2$1;->start()V

    .line 164
    const/4 v3, 0x0

    .line 166
    .local v3, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->this$2:Lcom/aio/downloader/service/BatteryInfoService1$1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1$1;)Lcom/aio/downloader/service/BatteryInfoService1$1;

    move-result-object v4

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->this$0:Lcom/aio/downloader/service/BatteryInfoService1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$4(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/service/BatteryInfoService1;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/service/BatteryInfoService1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 168
    const-string v5, "com.evzapp.cleanmaster"

    .line 169
    const/4 v6, 0x0

    .line 167
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 173
    :goto_1
    if-nez v3, :cond_2

    .line 174
    iget-object v4, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->this$2:Lcom/aio/downloader/service/BatteryInfoService1$1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1$1;)Lcom/aio/downloader/service/BatteryInfoService1$1;

    move-result-object v4

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->this$0:Lcom/aio/downloader/service/BatteryInfoService1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$4(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/service/BatteryInfoService1;

    move-result-object v4

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1;->access$2(Lcom/aio/downloader/service/BatteryInfoService1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 175
    new-instance v0, Landroid/content/Intent;

    .line 176
    const-string v4, "android.intent.action.VIEW"

    .line 175
    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 178
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 179
    iget-object v5, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->this$2:Lcom/aio/downloader/service/BatteryInfoService1$1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;
    invoke-static {v5}, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1$1;)Lcom/aio/downloader/service/BatteryInfoService1$1;

    move-result-object v5

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->this$0:Lcom/aio/downloader/service/BatteryInfoService1;
    invoke-static {v5}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$4(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/service/BatteryInfoService1;

    move-result-object v5

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1;->PRO_DIR:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/service/BatteryInfoService1;->access$3(Lcom/aio/downloader/service/BatteryInfoService1;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 180
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 181
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 178
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 182
    const-string v5, "application/vnd.android.package-archive"

    .line 177
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 183
    invoke-virtual {v0, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 184
    iget-object v4, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->this$2:Lcom/aio/downloader/service/BatteryInfoService1$1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1$1;)Lcom/aio/downloader/service/BatteryInfoService1$1;

    move-result-object v4

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->this$0:Lcom/aio/downloader/service/BatteryInfoService1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$4(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/service/BatteryInfoService1;

    move-result-object v4

    invoke-virtual {v4, v0}, Lcom/aio/downloader/service/BatteryInfoService1;->startActivity(Landroid/content/Intent;)V

    .line 228
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_0
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->this$2:Lcom/aio/downloader/service/BatteryInfoService1$1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1$1;)Lcom/aio/downloader/service/BatteryInfoService1$1;

    move-result-object v4

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->batterylow:Lcom/aio/downloader/dialog/Batterylow;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/dialog/Batterylow;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/Batterylow;->dismiss()V

    goto/16 :goto_0

    .line 170
    :catch_0
    move-exception v1

    .line 171
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 185
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->this$2:Lcom/aio/downloader/service/BatteryInfoService1$1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1$1;)Lcom/aio/downloader/service/BatteryInfoService1$1;

    move-result-object v4

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->this$0:Lcom/aio/downloader/service/BatteryInfoService1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$4(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/service/BatteryInfoService1;

    move-result-object v4

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1;->access$4(Lcom/aio/downloader/service/BatteryInfoService1;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 186
    new-instance v4, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2$2;

    invoke-direct {v4, p0}, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2$2;-><init>(Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;)V

    new-array v5, v7, [Ljava/lang/Void;

    .line 219
    invoke-virtual {v4, v5}, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_2

    .line 222
    :cond_2
    iget-object v4, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->this$2:Lcom/aio/downloader/service/BatteryInfoService1$1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1$1;)Lcom/aio/downloader/service/BatteryInfoService1$1;

    move-result-object v4

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->this$0:Lcom/aio/downloader/service/BatteryInfoService1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$4(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/service/BatteryInfoService1;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/service/BatteryInfoService1;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 224
    const-string v5, "com.evzapp.cleanmaster"

    .line 223
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 225
    .local v2, "intent":Landroid/content/Intent;
    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 226
    iget-object v4, p0, Lcom/aio/downloader/service/BatteryInfoService1$1$1$2;->this$2:Lcom/aio/downloader/service/BatteryInfoService1$1$1;

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1$1;->this$1:Lcom/aio/downloader/service/BatteryInfoService1$1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1$1;->access$0(Lcom/aio/downloader/service/BatteryInfoService1$1$1;)Lcom/aio/downloader/service/BatteryInfoService1$1;

    move-result-object v4

    # getter for: Lcom/aio/downloader/service/BatteryInfoService1$1;->this$0:Lcom/aio/downloader/service/BatteryInfoService1;
    invoke-static {v4}, Lcom/aio/downloader/service/BatteryInfoService1$1;->access$4(Lcom/aio/downloader/service/BatteryInfoService1$1;)Lcom/aio/downloader/service/BatteryInfoService1;

    move-result-object v4

    invoke-virtual {v4, v2}, Lcom/aio/downloader/service/BatteryInfoService1;->startActivity(Landroid/content/Intent;)V

    goto :goto_2

    .line 146
    nop

    :pswitch_data_0
    .packed-switch 0x7f07012f
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
