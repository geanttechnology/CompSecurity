.class public Lcom/aio/downloader/service/PhoneStateReceiver;
.super Landroid/content/BroadcastReceiver;
.source "PhoneStateReceiver.java"


# instance fields
.field private AIOCALLERAPK:Ljava/io/File;

.field private AIOCALLERDOWN:Ljava/io/File;

.field private callerInDialog:Lcom/aio/downloader/dialog/CallerInDialog;

.field private callerOutDialog:Lcom/aio/downloader/dialog/CallerOutDialog;

.field private callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;

.field private itemsOnClick:Landroid/view/View$OnClickListener;

.field private telMgr:Landroid/telephony/TelephonyManager;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 39
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 40
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->telMgr:Landroid/telephony/TelephonyManager;

    .line 42
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 43
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 44
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 45
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->AIOCALLERDOWN:Ljava/io/File;

    .line 46
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 47
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 48
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 49
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->AIOCALLERAPK:Ljava/io/File;

    .line 39
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/PhoneStateReceiver;)Lcom/aio/downloader/dialog/CallerOutDialog;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->callerOutDialog:Lcom/aio/downloader/dialog/CallerOutDialog;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/service/PhoneStateReceiver;)Ljava/io/File;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/service/PhoneStateReceiver;)Ljava/io/File;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/service/PhoneStateReceiver;)Lcom/aio/downloader/dialog/CallerOutDialog1;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;

    return-object v0
.end method

.method public static getContactNameByPhoneNumber(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "address"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 457
    const/4 v0, 0x3

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "display_name"

    aput-object v1, v2, v0

    const/4 v0, 0x1

    .line 458
    const-string v1, "photo_id"

    aput-object v1, v2, v0

    const/4 v0, 0x2

    .line 459
    const-string v1, "data1"

    aput-object v1, v2, v0

    .line 463
    .local v2, "projection":[Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 464
    sget-object v1, Landroid/provider/ContactsContract$CommonDataKinds$Phone;->CONTENT_URI:Landroid/net/Uri;

    .line 466
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v5, "data1 = \'"

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 467
    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, "\'"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 466
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move-object v5, v4

    .line 463
    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 471
    .local v6, "cursor":Landroid/database/Cursor;
    if-eqz v6, :cond_0

    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-eqz v0, :cond_0

    .line 475
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lt v7, v0, :cond_2

    .line 488
    .end local v7    # "i":I
    :cond_0
    const-string v8, ""

    :cond_1
    return-object v8

    .line 476
    .restart local v7    # "i":I
    :cond_2
    invoke-interface {v6, v7}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 479
    const-string v0, "display_name"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v9

    .line 481
    .local v9, "nameFieldColumnIndex":I
    invoke-interface {v6, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 482
    .local v8, "name":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    if-nez v8, :cond_1

    .line 475
    :cond_3
    add-int/lit8 v7, v7, 0x1

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
    .line 494
    const-wide/16 v1, 0x0

    .line 495
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 496
    const/4 v0, 0x0

    .line 497
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 498
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 502
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 500
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 58
    move-object v1, p1

    .line 61
    .local v1, "ctx":Landroid/content/Context;
    const-string v5, "phone"

    invoke-virtual {v1, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/telephony/TelephonyManager;

    .line 60
    iput-object v5, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->telMgr:Landroid/telephony/TelephonyManager;

    .line 62
    iget-object v5, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->telMgr:Landroid/telephony/TelephonyManager;

    invoke-virtual {v5}, Landroid/telephony/TelephonyManager;->getCallState()I

    move-result v5

    packed-switch v5, :pswitch_data_0

    .line 451
    :goto_0
    return-void

    .line 64
    :pswitch_0
    const/4 v5, 0x1

    sput v5, Lcom/aio/downloader/utils/Myutils;->laststate:I

    .line 65
    const-string v5, "qwer"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "laststate="

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget v7, Lcom/aio/downloader/utils/Myutils;->laststate:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 68
    :pswitch_1
    const/4 v5, 0x2

    sput v5, Lcom/aio/downloader/utils/Myutils;->laststate:I

    .line 69
    const-string v5, "qwer"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Myutils.laststate="

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget v7, Lcom/aio/downloader/utils/Myutils;->laststate:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 74
    :pswitch_2
    const-string v5, "incoming_number"

    invoke-virtual {p2, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 76
    .local v3, "number":Ljava/lang/String;
    invoke-static {p1, v3}, Lcom/aio/downloader/service/PhoneStateReceiver;->getContactNameByPhoneNumber(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 81
    .local v0, "contactNameByPhoneNumber":Ljava/lang/String;
    const-string v5, "qwer"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Myutils.laststate="

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget v7, Lcom/aio/downloader/utils/Myutils;->laststate:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "number="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 82
    sget v5, Lcom/aio/downloader/utils/Myutils;->laststate:I

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 85
    new-instance v5, Lcom/aio/downloader/service/PhoneStateReceiver$1;

    invoke-direct {v5, p0, p1}, Lcom/aio/downloader/service/PhoneStateReceiver$1;-><init>(Lcom/aio/downloader/service/PhoneStateReceiver;Landroid/content/Context;)V

    iput-object v5, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->itemsOnClick:Landroid/view/View$OnClickListener;

    .line 158
    new-instance v5, Lcom/aio/downloader/dialog/CallerOutDialog;

    .line 159
    const v6, 0x7f0c0010

    iget-object v7, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-direct {v5, p1, v6, v7, v3}, Lcom/aio/downloader/dialog/CallerOutDialog;-><init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;Ljava/lang/String;)V

    .line 158
    iput-object v5, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->callerOutDialog:Lcom/aio/downloader/dialog/CallerOutDialog;

    .line 160
    iget-object v5, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->callerOutDialog:Lcom/aio/downloader/dialog/CallerOutDialog;

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Lcom/aio/downloader/dialog/CallerOutDialog;->setCanceledOnTouchOutside(Z)V

    .line 161
    iget-object v5, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->callerOutDialog:Lcom/aio/downloader/dialog/CallerOutDialog;

    invoke-virtual {v5}, Lcom/aio/downloader/dialog/CallerOutDialog;->getWindow()Landroid/view/Window;

    move-result-object v5

    .line 162
    const/16 v6, 0x7d3

    .line 161
    invoke-virtual {v5, v6}, Landroid/view/Window;->setType(I)V

    .line 163
    const/4 v4, 0x0

    .line 165
    .local v4, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 166
    const-string v6, "com.allinone.callerid"

    const/4 v7, 0x0

    .line 165
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 174
    :goto_1
    if-nez v4, :cond_0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    invoke-static {p1}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->GetCalleroutTime(Landroid/content/Context;)J

    move-result-wide v7

    cmp-long v5, v5, v7

    if-lez v5, :cond_0

    .line 176
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/32 v7, 0x1b77400

    add-long/2addr v5, v7

    .line 175
    invoke-static {p1, v5, v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetCalleroutTime(Landroid/content/Context;J)V

    .line 178
    const-string v5, "call_state_ringing"

    invoke-static {p1, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 179
    new-instance v5, Landroid/os/Handler;

    invoke-direct {v5}, Landroid/os/Handler;-><init>()V

    new-instance v6, Lcom/aio/downloader/service/PhoneStateReceiver$2;

    invoke-direct {v6, p0}, Lcom/aio/downloader/service/PhoneStateReceiver$2;-><init>(Lcom/aio/downloader/service/PhoneStateReceiver;)V

    .line 205
    const-wide/16 v7, 0x7d0

    .line 179
    invoke-virtual {v5, v6, v7, v8}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 338
    .end local v4    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_0
    sget v5, Lcom/aio/downloader/utils/Myutils;->laststate:I

    const/4 v6, 0x2

    if-ne v5, v6, :cond_1

    .line 341
    new-instance v5, Lcom/aio/downloader/service/PhoneStateReceiver$3;

    invoke-direct {v5, p0, p1}, Lcom/aio/downloader/service/PhoneStateReceiver$3;-><init>(Lcom/aio/downloader/service/PhoneStateReceiver;Landroid/content/Context;)V

    iput-object v5, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->itemsOnClick:Landroid/view/View$OnClickListener;

    .line 414
    new-instance v5, Lcom/aio/downloader/dialog/CallerOutDialog1;

    .line 415
    const v6, 0x7f0c0010

    iget-object v7, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->itemsOnClick:Landroid/view/View$OnClickListener;

    const-string v8, "+1 813-449-2756"

    invoke-direct {v5, p1, v6, v7, v8}, Lcom/aio/downloader/dialog/CallerOutDialog1;-><init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;Ljava/lang/String;)V

    .line 414
    iput-object v5, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;

    .line 416
    iget-object v5, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Lcom/aio/downloader/dialog/CallerOutDialog1;->setCanceledOnTouchOutside(Z)V

    .line 417
    iget-object v5, p0, Lcom/aio/downloader/service/PhoneStateReceiver;->callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;

    invoke-virtual {v5}, Lcom/aio/downloader/dialog/CallerOutDialog1;->getWindow()Landroid/view/Window;

    move-result-object v5

    .line 418
    const/16 v6, 0x7d3

    .line 417
    invoke-virtual {v5, v6}, Landroid/view/Window;->setType(I)V

    .line 419
    const/4 v4, 0x0

    .line 421
    .restart local v4    # "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_1
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 422
    const-string v6, "com.allinone.callerid"

    const/4 v7, 0x0

    .line 421
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v4

    .line 429
    :goto_2
    if-nez v4, :cond_1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    invoke-static {p1}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->Getsimulate_callTime(Landroid/content/Context;)J

    move-result-wide v7

    cmp-long v5, v5, v7

    if-lez v5, :cond_1

    .line 431
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/32 v7, 0x1499700

    add-long/2addr v5, v7

    .line 430
    invoke-static {p1, v5, v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->Setsimulate_callTime(Landroid/content/Context;J)V

    .line 433
    const-string v5, "simulate_call"

    invoke-static {p1, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 434
    new-instance v5, Landroid/os/Handler;

    invoke-direct {v5}, Landroid/os/Handler;-><init>()V

    new-instance v6, Lcom/aio/downloader/service/PhoneStateReceiver$4;

    invoke-direct {v6, p0}, Lcom/aio/downloader/service/PhoneStateReceiver$4;-><init>(Lcom/aio/downloader/service/PhoneStateReceiver;)V

    .line 441
    const-wide/16 v7, 0xbb8

    .line 434
    invoke-virtual {v5, v6, v7, v8}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 447
    .end local v4    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_1
    const/4 v5, 0x0

    sput v5, Lcom/aio/downloader/utils/Myutils;->laststate:I

    goto/16 :goto_0

    .line 167
    .restart local v4    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v2

    .line 168
    .local v2, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_1

    .line 423
    .end local v2    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_1
    move-exception v2

    .line 424
    .restart local v2    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 62
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
