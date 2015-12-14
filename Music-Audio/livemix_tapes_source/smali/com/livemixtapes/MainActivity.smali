.class public Lcom/livemixtapes/MainActivity;
.super Landroid/app/TabActivity;
.source "MainActivity.java"


# static fields
.field public static activity:Landroid/app/Activity;

.field public static firstLoad:Z

.field public static fromWidget:Z

.field public static isPlaying:Z

.field public static logoutText:Landroid/widget/TextView;

.field public static mainActivity:Lcom/livemixtapes/MainActivity;

.field public static nowplayingbutton:Landroid/widget/ImageView;


# instance fields
.field private final mHandleMessageReceiver:Landroid/content/BroadcastReceiver;

.field mRegisterTask:Landroid/os/AsyncTask;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/AsyncTask",
            "<",
            "Ljava/lang/Void;",
            "Ljava/lang/Void;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field public tabHostListener:Lcom/livemixtapes/ui/AnimatedTabHostListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 60
    sput-boolean v0, Lcom/livemixtapes/MainActivity;->isPlaying:Z

    .line 61
    sput-boolean v0, Lcom/livemixtapes/MainActivity;->fromWidget:Z

    .line 62
    sput-boolean v0, Lcom/livemixtapes/MainActivity;->firstLoad:Z

    .line 66
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0}, Landroid/app/TabActivity;-><init>()V

    .line 447
    new-instance v0, Lcom/livemixtapes/MainActivity$1;

    invoke-direct {v0, p0}, Lcom/livemixtapes/MainActivity$1;-><init>(Lcom/livemixtapes/MainActivity;)V

    iput-object v0, p0, Lcom/livemixtapes/MainActivity;->mHandleMessageReceiver:Landroid/content/BroadcastReceiver;

    .line 56
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/MainActivity;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 358
    invoke-direct {p0, p1}, Lcom/livemixtapes/MainActivity;->gcm(Landroid/content/Context;)V

    return-void
.end method

.method private gcm(Landroid/content/Context;)V
    .locals 11
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v10, 0x3

    const/4 v7, 0x0

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 359
    invoke-static {p1}, Lcom/google/android/gcm/GCMRegistrar;->checkDevice(Landroid/content/Context;)V

    .line 360
    invoke-static {p1}, Lcom/google/android/gcm/GCMRegistrar;->checkManifest(Landroid/content/Context;)V

    .line 362
    iget-object v4, p0, Lcom/livemixtapes/MainActivity;->mHandleMessageReceiver:Landroid/content/BroadcastReceiver;

    new-instance v5, Landroid/content/IntentFilter;

    .line 363
    const-string v6, "com.livemixtapes.DISPLAY_MESSAGE"

    invoke-direct {v5, v6}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 362
    invoke-virtual {p0, v4, v5}, Lcom/livemixtapes/MainActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 364
    invoke-static {p1}, Lcom/google/android/gcm/GCMRegistrar;->getRegistrationId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 365
    .local v0, "RegistrationId":Ljava/lang/String;
    const-string v4, "PUSHTOKEN"

    .line 366
    invoke-static {p1}, Lcom/google/android/gcm/GCMRegistrar;->getRegistrationId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    .line 365
    invoke-static {p1, v4, v5}, Lcom/livemixtapes/Utils;->savePreferences(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 367
    const-string v4, "LiveMixTapes"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "retrieved registration id is :"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 369
    const-string v4, ""

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 370
    new-array v4, v9, [Ljava/lang/String;

    const-string v5, "663004151835"

    aput-object v5, v4, v8

    invoke-static {p1, v4}, Lcom/google/android/gcm/GCMRegistrar;->register(Landroid/content/Context;[Ljava/lang/String;)V

    .line 445
    :goto_0
    return-void

    .line 372
    :cond_0
    invoke-static {p1}, Lcom/google/android/gcm/GCMRegistrar;->isRegisteredOnServer(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 373
    const-string v4, "LiveMixTapes"

    const-string v5, "GCM Display Message : Already registered"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    new-array v4, v9, [Ljava/lang/Object;

    .line 377
    const-string v5, "GCM REGISTERED ALREADY"

    aput-object v5, v4, v8

    invoke-static {v4}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 378
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3, v10}, Ljava/util/ArrayList;-><init>(I)V

    .line 379
    .local v3, "nameValuePairs":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    .line 380
    const-string v5, "android_id"

    .line 379
    invoke-static {v4, v5}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 381
    .local v1, "android_id":Ljava/lang/String;
    new-instance v2, Lcom/livemixtapes/library/JSONParser;

    invoke-direct {v2}, Lcom/livemixtapes/library/JSONParser;-><init>()V

    .line 382
    .local v2, "jParser":Lcom/livemixtapes/library/JSONParser;
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "auth"

    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-array v4, v9, [Ljava/lang/Object;

    .line 383
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "AUTH IS: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v8

    invoke-static {v4}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 384
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "device_id"

    invoke-direct {v4, v5, v1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-array v4, v9, [Ljava/lang/Object;

    .line 385
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "DEVICEID IS: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v8

    invoke-static {v4}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 387
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "device_token"

    invoke-direct {v4, v5, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-array v4, v9, [Ljava/lang/Object;

    .line 388
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "REGISTRATIONID IS: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v8

    invoke-static {v4}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 390
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "device_description"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-static {}, Lcom/livemixtapes/GCMIntentService;->getDeviceName()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v7, " - "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    sget-object v7, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-array v4, v9, [Ljava/lang/Object;

    .line 391
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "DEVICEDESCRIPTION IS: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/livemixtapes/GCMIntentService;->getDeviceName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " - "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v8

    invoke-static {v4}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 393
    const-string v4, "https://api.livemixtapes.com/api/user/android_push"

    invoke-virtual {v2, v4, v3}, Lcom/livemixtapes/library/JSONParser;->postData(Ljava/lang/String;Ljava/util/List;)Lorg/json/JSONObject;

    goto/16 :goto_0

    .line 404
    .end local v1    # "android_id":Ljava/lang/String;
    .end local v2    # "jParser":Lcom/livemixtapes/library/JSONParser;
    .end local v3    # "nameValuePairs":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    :cond_1
    const-string v4, "LiveMixTapes"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "retrieved registration id is :"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 405
    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 404
    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 406
    new-instance v4, Lcom/livemixtapes/MainActivity$7;

    invoke-direct {v4, p0, p1, v0}, Lcom/livemixtapes/MainActivity$7;-><init>(Lcom/livemixtapes/MainActivity;Landroid/content/Context;Ljava/lang/String;)V

    iput-object v4, p0, Lcom/livemixtapes/MainActivity;->mRegisterTask:Landroid/os/AsyncTask;

    .line 441
    iget-object v4, p0, Lcom/livemixtapes/MainActivity;->mRegisterTask:Landroid/os/AsyncTask;

    new-array v5, v10, [Ljava/lang/Void;

    aput-object v7, v5, v8

    aput-object v7, v5, v9

    const/4 v6, 0x2

    aput-object v7, v5, v6

    invoke-virtual {v4, v5}, Landroid/os/AsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0
.end method

.method public static goBack()V
    .locals 1

    .prologue
    .line 458
    sget-object v0, Lcom/livemixtapes/MainActivity;->mainActivity:Lcom/livemixtapes/MainActivity;

    invoke-virtual {v0}, Lcom/livemixtapes/MainActivity;->onBackPressed()V

    .line 459
    return-void
.end method

.method private showDialog(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 347
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, p1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 348
    const-string v1, "OK"

    new-instance v2, Lcom/livemixtapes/MainActivity$6;

    invoke-direct {v2, p0}, Lcom/livemixtapes/MainActivity$6;-><init>(Lcom/livemixtapes/MainActivity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 353
    const v1, 0x1080027

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 354
    return-void
.end method


# virtual methods
.method public addImageToActionBar()V
    .locals 15

    .prologue
    .line 295
    invoke-virtual {p0}, Lcom/livemixtapes/MainActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v12

    const/4 v13, 0x1

    invoke-virtual {v12, v13}, Landroid/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 298
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v5

    .line 299
    .local v5, "inflater":Landroid/view/LayoutInflater;
    const v12, 0x7f030018

    const/4 v13, 0x0

    invoke-virtual {v5, v12, v13}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 303
    .local v2, "header":Landroid/view/View;
    const v12, 0x7f08005f

    invoke-virtual {v2, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/ImageView;

    .line 306
    .local v10, "tv":Landroid/widget/ImageView;
    invoke-virtual {p0}, Lcom/livemixtapes/MainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v12

    invoke-virtual {v12}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v12

    iget v0, v12, Landroid/util/DisplayMetrics;->widthPixels:I

    .line 313
    .local v0, "actionBarWidth":I
    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-virtual {v10, v12, v13}, Landroid/widget/ImageView;->measure(II)V

    .line 314
    invoke-virtual {v10}, Landroid/widget/ImageView;->getMeasuredWidth()I

    move-result v11

    .line 315
    .local v11, "tvSize":I
    const/16 v7, 0x32

    .line 318
    .local v7, "leftSpace":I
    const v12, 0x102002c

    :try_start_0
    invoke-virtual {p0, v12}, Lcom/livemixtapes/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 319
    .local v4, "homeButton":Landroid/view/View;
    invoke-virtual {v4}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    .line 321
    .local v3, "holder":Landroid/view/ViewGroup;
    const/4 v12, 0x0

    invoke-virtual {v3, v12}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 322
    .local v1, "firstChild":Landroid/view/View;
    const/4 v12, 0x1

    invoke-virtual {v3, v12}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    .line 324
    .local v9, "secondChild":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getWidth()I

    move-result v12

    invoke-virtual {v9}, Landroid/view/View;->getWidth()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v13

    add-int v7, v12, v13

    .line 328
    .end local v1    # "firstChild":Landroid/view/View;
    .end local v3    # "holder":Landroid/view/ViewGroup;
    .end local v4    # "homeButton":Landroid/view/View;
    .end local v9    # "secondChild":Landroid/view/View;
    :goto_0
    invoke-virtual {p0}, Lcom/livemixtapes/MainActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v12

    invoke-virtual {v12, v2}, Landroid/app/ActionBar;->setCustomView(Landroid/view/View;)V

    .line 330
    if-eqz v2, :cond_1

    .line 332
    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v8

    .line 331
    check-cast v8, Landroid/app/ActionBar$LayoutParams;

    .line 333
    .local v8, "params":Landroid/app/ActionBar$LayoutParams;
    const/16 v7, 0x64

    .line 334
    if-eqz v8, :cond_2

    .line 335
    div-int/lit8 v12, v0, 0x4

    add-int/lit8 v6, v12, -0x14

    .line 337
    .local v6, "leftMargin":I
    if-gtz v6, :cond_0

    const/4 v6, 0x0

    .end local v6    # "leftMargin":I
    :cond_0
    iput v6, v8, Landroid/app/ActionBar$LayoutParams;->leftMargin:I

    .line 344
    .end local v8    # "params":Landroid/app/ActionBar$LayoutParams;
    :cond_1
    :goto_1
    return-void

    .line 338
    .restart local v8    # "params":Landroid/app/ActionBar$LayoutParams;
    :cond_2
    const/4 v12, 0x1

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    .line 339
    const-string v14, "NULL PARAMS"

    aput-object v14, v12, v13

    invoke-static {v12}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    goto :goto_1

    .line 325
    .end local v8    # "params":Landroid/app/ActionBar$LayoutParams;
    :catch_0
    move-exception v12

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 23
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 113
    invoke-super/range {p0 .. p1}, Landroid/app/TabActivity;->onCreate(Landroid/os/Bundle;)V

    .line 115
    sput-object p0, Lcom/livemixtapes/MainActivity;->activity:Landroid/app/Activity;

    .line 116
    sput-object p0, Lcom/livemixtapes/MainActivity;->mainActivity:Lcom/livemixtapes/MainActivity;

    .line 117
    const/16 v20, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/livemixtapes/MainActivity;->requestWindowFeature(I)Z

    .line 119
    const v20, 0x7f030019

    move-object/from16 v0, p0

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/livemixtapes/MainActivity;->setContentView(I)V

    .line 121
    const v20, 0x7f080061

    move-object/from16 v0, p0

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/livemixtapes/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v20

    check-cast v20, Landroid/widget/ImageView;

    sput-object v20, Lcom/livemixtapes/MainActivity;->nowplayingbutton:Landroid/widget/ImageView;

    .line 132
    new-instance v8, Lcom/livemixtapes/MainActivity$2;

    move-object/from16 v0, p0

    invoke-direct {v8, v0}, Lcom/livemixtapes/MainActivity$2;-><init>(Lcom/livemixtapes/MainActivity;)V

    .line 146
    .local v8, "nowplayingListener":Landroid/view/View$OnClickListener;
    sget-object v20, Lcom/livemixtapes/MainActivity;->nowplayingbutton:Landroid/widget/ImageView;

    move-object/from16 v0, v20

    invoke-virtual {v0, v8}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 150
    new-instance v4, Lcom/livemixtapes/MainActivity$3;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/livemixtapes/MainActivity$3;-><init>(Lcom/livemixtapes/MainActivity;)V

    .line 166
    .local v4, "logoutBtnListener":Landroid/view/View$OnClickListener;
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/MainActivity;->getTabHost()Landroid/widget/TabHost;

    move-result-object v15

    .line 169
    .local v15, "tabHost":Landroid/widget/TabHost;
    const-string v20, "Explore"

    move-object/from16 v0, v20

    invoke-virtual {v15, v0}, Landroid/widget/TabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v6

    .line 171
    .local v6, "mixtapespec":Landroid/widget/TabHost$TabSpec;
    const-string v20, ""

    .line 172
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/MainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    const v22, 0x7f0200ae

    invoke-virtual/range {v21 .. v22}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v21

    .line 171
    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v6, v0, v1}, Landroid/widget/TabHost$TabSpec;->setIndicator(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;)Landroid/widget/TabHost$TabSpec;

    .line 173
    new-instance v5, Landroid/content/Intent;

    const-class v20, Lcom/livemixtapes/MixtapesActivity;

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v5, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 174
    .local v5, "mixtapesIntent":Landroid/content/Intent;
    invoke-virtual {v6, v5}, Landroid/widget/TabHost$TabSpec;->setContent(Landroid/content/Intent;)Landroid/widget/TabHost$TabSpec;

    .line 176
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/MainActivity;->getIntent()Landroid/content/Intent;

    move-result-object v20

    const-string v21, "mixtapeId"

    invoke-virtual/range {v20 .. v21}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 177
    .local v12, "pushMixtapeId":Ljava/lang/String;
    if-eqz v12, :cond_0

    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v20

    if-lez v20, :cond_0

    .line 179
    const-string v20, "mixtapeId"

    move-object/from16 v0, v20

    invoke-virtual {v5, v0, v12}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 184
    :cond_0
    const-string v20, "World"

    move-object/from16 v0, v20

    invoke-virtual {v15, v0}, Landroid/widget/TabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v19

    .line 185
    .local v19, "worldspec":Landroid/widget/TabHost$TabSpec;
    const-string v20, ""

    .line 186
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/MainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    const v22, 0x7f0200b3

    invoke-virtual/range {v21 .. v22}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v21

    .line 185
    invoke-virtual/range {v19 .. v21}, Landroid/widget/TabHost$TabSpec;->setIndicator(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;)Landroid/widget/TabHost$TabSpec;

    .line 187
    new-instance v18, Landroid/content/Intent;

    const-class v20, Lcom/livemixtapes/WorldActivity;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    move-object/from16 v2, v20

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 188
    .local v18, "worldIntent":Landroid/content/Intent;
    move-object/from16 v0, v19

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/widget/TabHost$TabSpec;->setContent(Landroid/content/Intent;)Landroid/widget/TabHost$TabSpec;

    .line 191
    const-string v20, "Player"

    move-object/from16 v0, v20

    invoke-virtual {v15, v0}, Landroid/widget/TabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v9

    .line 192
    .local v9, "playerspec":Landroid/widget/TabHost$TabSpec;
    const-string v20, ""

    move-object/from16 v0, v20

    invoke-virtual {v9, v0}, Landroid/widget/TabHost$TabSpec;->setIndicator(Ljava/lang/CharSequence;)Landroid/widget/TabHost$TabSpec;

    .line 193
    new-instance v7, Landroid/content/Intent;

    const-class v20, Lcom/livemixtapes/NowPlayingActivity;

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v7, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 194
    .local v7, "nowPlayingIntent":Landroid/content/Intent;
    invoke-virtual {v9, v7}, Landroid/widget/TabHost$TabSpec;->setContent(Landroid/content/Intent;)Landroid/widget/TabHost$TabSpec;

    .line 197
    const-string v20, "Search"

    move-object/from16 v0, v20

    invoke-virtual {v15, v0}, Landroid/widget/TabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v14

    .line 198
    .local v14, "searchspec":Landroid/widget/TabHost$TabSpec;
    const-string v20, ""

    .line 199
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/MainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    const v22, 0x7f0200b1

    invoke-virtual/range {v21 .. v22}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v21

    .line 198
    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v14, v0, v1}, Landroid/widget/TabHost$TabSpec;->setIndicator(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;)Landroid/widget/TabHost$TabSpec;

    .line 200
    new-instance v13, Landroid/content/Intent;

    const-class v20, Lcom/livemixtapes/SearchActivity;

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v13, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 201
    .local v13, "searchIntent":Landroid/content/Intent;
    invoke-virtual {v14, v13}, Landroid/widget/TabHost$TabSpec;->setContent(Landroid/content/Intent;)Landroid/widget/TabHost$TabSpec;

    .line 204
    const-string v20, "Profile"

    move-object/from16 v0, v20

    invoke-virtual {v15, v0}, Landroid/widget/TabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v11

    .line 205
    .local v11, "profilespec":Landroid/widget/TabHost$TabSpec;
    const-string v20, ""

    .line 206
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/MainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    const v22, 0x7f0200b0

    invoke-virtual/range {v21 .. v22}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v21

    .line 205
    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v11, v0, v1}, Landroid/widget/TabHost$TabSpec;->setIndicator(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;)Landroid/widget/TabHost$TabSpec;

    .line 207
    new-instance v10, Landroid/content/Intent;

    const-class v20, Lcom/livemixtapes/ProfileActivity;

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v10, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 208
    .local v10, "profileIntent":Landroid/content/Intent;
    const/high16 v20, 0x4000000

    move/from16 v0, v20

    invoke-virtual {v10, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 209
    invoke-virtual {v11, v10}, Landroid/widget/TabHost$TabSpec;->setContent(Landroid/content/Intent;)Landroid/widget/TabHost$TabSpec;

    .line 212
    invoke-virtual {v15, v6}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 213
    move-object/from16 v0, v19

    invoke-virtual {v15, v0}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 214
    invoke-virtual {v15, v9}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 215
    invoke-virtual {v15, v14}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 216
    invoke-virtual {v15, v11}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 218
    invoke-virtual {v15}, Landroid/widget/TabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v20

    const/16 v21, 0x0

    invoke-virtual/range {v20 .. v21}, Landroid/widget/TabWidget;->setStripEnabled(Z)V

    .line 220
    invoke-virtual {v15}, Landroid/widget/TabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v20

    const/16 v21, 0x2

    invoke-virtual/range {v20 .. v21}, Landroid/widget/TabWidget;->getChildTabViewAt(I)Landroid/view/View;

    move-result-object v20

    const/16 v21, 0x0

    invoke-virtual/range {v20 .. v21}, Landroid/view/View;->setEnabled(Z)V

    .line 222
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-virtual {v15}, Landroid/widget/TabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Landroid/widget/TabWidget;->getChildCount()I

    move-result v20

    move/from16 v0, v20

    if-lt v3, v0, :cond_2

    .line 272
    new-instance v20, Lcom/livemixtapes/MainActivity$5;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/livemixtapes/MainActivity$5;-><init>(Lcom/livemixtapes/MainActivity;)V

    const/16 v21, 0x0

    move/from16 v0, v21

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v21, v0

    .line 280
    invoke-virtual/range {v20 .. v21}, Lcom/livemixtapes/MainActivity$5;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 282
    invoke-static {}, Lcom/livemixtapes/User;->isLogged()Ljava/lang/Boolean;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v20

    if-nez v20, :cond_1

    .line 284
    invoke-static {}, Lcom/livemixtapes/User;->hasAuth()Ljava/lang/Boolean;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/Boolean;->booleanValue()Z

    .line 290
    :cond_1
    new-instance v20, Lcom/livemixtapes/ui/AnimatedTabHostListener;

    move-object/from16 v0, v20

    invoke-direct {v0, v15}, Lcom/livemixtapes/ui/AnimatedTabHostListener;-><init>(Landroid/widget/TabHost;)V

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/livemixtapes/MainActivity;->tabHostListener:Lcom/livemixtapes/ui/AnimatedTabHostListener;

    .line 292
    return-void

    .line 223
    :cond_2
    invoke-virtual {v15}, Landroid/widget/TabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v0, v3}, Landroid/widget/TabWidget;->getChildAt(I)Landroid/view/View;

    move-result-object v20

    .line 224
    const v21, 0x7f0200fd

    invoke-virtual/range {v20 .. v21}, Landroid/view/View;->setBackgroundResource(I)V

    .line 225
    invoke-virtual {v15}, Landroid/widget/TabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v0, v3}, Landroid/widget/TabWidget;->getChildAt(I)Landroid/view/View;

    move-result-object v20

    .line 226
    const v21, 0x1020016

    invoke-virtual/range {v20 .. v21}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v16

    .line 225
    check-cast v16, Landroid/widget/TextView;

    .line 228
    .local v16, "tv":Landroid/widget/TextView;
    const-string v20, "#ffffff"

    invoke-static/range {v20 .. v20}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v20

    move-object/from16 v0, v16

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 235
    invoke-virtual {v15}, Landroid/widget/TabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v17

    .line 236
    .local v17, "tw":Landroid/widget/TabWidget;
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/MainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    .line 237
    const v21, 0x7f020057

    .line 236
    invoke-virtual/range {v20 .. v21}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v20

    move-object/from16 v0, v17

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/widget/TabWidget;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 239
    new-instance v20, Lcom/livemixtapes/MainActivity$4;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/livemixtapes/MainActivity$4;-><init>(Lcom/livemixtapes/MainActivity;)V

    move-object/from16 v0, v20

    invoke-virtual {v15, v0}, Landroid/widget/TabHost;->setOnTabChangedListener(Landroid/widget/TabHost$OnTabChangeListener;)V

    .line 222
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_0
.end method

.method public onDestroy()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 92
    new-array v1, v4, [Ljava/lang/Object;

    const/4 v2, 0x0

    .line 72
    const-string v3, "MAIN ACTIVITY DESTORYED"

    aput-object v3, v1, v2

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 73
    const-string v1, "notification"

    invoke-virtual {p0, v1}, Lcom/livemixtapes/MainActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/NotificationManager;

    invoke-virtual {v1}, Landroid/app/NotificationManager;->cancelAll()V

    .line 74
    sget-object v1, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    .line 75
    const-string v2, "notification"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 74
    check-cast v0, Landroid/app/NotificationManager;

    .line 76
    .local v0, "mNotifyManager":Landroid/app/NotificationManager;
    invoke-virtual {v0, v4}, Landroid/app/NotificationManager;->cancel(I)V

    .line 77
    invoke-virtual {v0}, Landroid/app/NotificationManager;->cancelAll()V

    .line 81
    iget-object v1, p0, Lcom/livemixtapes/MainActivity;->mRegisterTask:Landroid/os/AsyncTask;

    if-eqz v1, :cond_0

    .line 82
    iget-object v1, p0, Lcom/livemixtapes/MainActivity;->mRegisterTask:Landroid/os/AsyncTask;

    invoke-virtual {v1, v4}, Landroid/os/AsyncTask;->cancel(Z)Z

    .line 84
    :cond_0
    :try_start_0
    iget-object v1, p0, Lcom/livemixtapes/MainActivity;->mHandleMessageReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v1}, Lcom/livemixtapes/MainActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 85
    invoke-virtual {p0}, Lcom/livemixtapes/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/google/android/gcm/GCMRegistrar;->onDestroy(Landroid/content/Context;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 90
    :goto_0
    invoke-super {p0}, Landroid/app/TabActivity;->onDestroy()V

    return-void

    .line 86
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 96
    invoke-super {p0}, Landroid/app/TabActivity;->onResume()V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    .line 98
    const-string v3, "LOGGING MAIN ACTIVITY"

    aput-object v3, v1, v2

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 99
    invoke-virtual {p0}, Lcom/livemixtapes/MainActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/App;

    .line 101
    .local v0, "application":Lcom/livemixtapes/App;
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v1

    .line 102
    const-string v2, "Image~MainActivity"

    invoke-virtual {v1, v2}, Lcom/google/android/gms/analytics/Tracker;->setScreenName(Ljava/lang/String;)V

    .line 104
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v1

    .line 105
    new-instance v2, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;

    invoke-direct {v2}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;-><init>()V

    invoke-virtual {v2}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;->build()Ljava/util/Map;

    move-result-object v2

    .line 104
    invoke-virtual {v1, v2}, Lcom/google/android/gms/analytics/Tracker;->send(Ljava/util/Map;)V

    .line 107
    invoke-static {p0}, Lcom/livemixtapes/utils/Utility;->hideKeyboard(Landroid/app/Activity;)V

    .line 108
    return-void
.end method
