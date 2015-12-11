.class public Lcom/comcast/cim/utils/AppLauncher;
.super Ljava/lang/Object;
.source "AppLauncher.java"


# instance fields
.field private final androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;)V
    .locals 0
    .param p1, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/comcast/cim/utils/AppLauncher;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 18
    return-void
.end method

.method private showInMarket(Ljava/lang/String;Landroid/app/Activity;)V
    .locals 4
    .param p1, "packageName"    # Ljava/lang/String;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 45
    iget-object v2, p0, Lcom/comcast/cim/utils/AppLauncher;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isKindleOrFromAmazonStore()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 46
    invoke-virtual {p2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/comcast/cim/android/R$string;->url_amazon_market_app_url:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 51
    .local v1, "marketUriPrefix":Ljava/lang/String;
    :goto_0
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 52
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v2, 0x10000000

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 53
    invoke-virtual {p2, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 54
    return-void

    .line 48
    .end local v0    # "intent":Landroid/content/Intent;
    .end local v1    # "marketUriPrefix":Ljava/lang/String;
    :cond_0
    invoke-virtual {p2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/comcast/cim/android/R$string;->url_android_market_app_url:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "marketUriPrefix":Ljava/lang/String;
    goto :goto_0
.end method


# virtual methods
.method public startApplication(Ljava/lang/String;Landroid/app/Activity;)V
    .locals 3
    .param p1, "packageName"    # Ljava/lang/String;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 28
    :try_start_0
    invoke-virtual {p2}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 29
    .local v1, "intent":Landroid/content/Intent;
    if-eqz v1, :cond_0

    .line 30
    const/high16 v2, 0x10000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 31
    invoke-virtual {p2, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 41
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 34
    .restart local v1    # "intent":Landroid/content/Intent;
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/utils/AppLauncher;->showInMarket(Ljava/lang/String;Landroid/app/Activity;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 37
    .end local v1    # "intent":Landroid/content/Intent;
    :catch_0
    move-exception v0

    .line 38
    .local v0, "e":Ljava/lang/Exception;
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/utils/AppLauncher;->showInMarket(Ljava/lang/String;Landroid/app/Activity;)V

    goto :goto_0
.end method

.method public startUri(Landroid/net/Uri;Landroid/app/Activity;)V
    .locals 2
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 21
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 22
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x10000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 23
    invoke-virtual {p2, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 24
    return-void
.end method
