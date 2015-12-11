.class public Lcom/amazon/mShop/publicurl/PublicURLActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "PublicURLActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/publicurl/PublicURLActivity$3;
    }
.end annotation


# instance fields
.field private mProcessor:Lcom/amazon/mShop/publicurl/PublicURLProcessor;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 81
    return-void
.end method

.method private processURL()V
    .locals 11

    .prologue
    const/4 v7, 0x1

    const/4 v8, 0x0

    .line 42
    invoke-virtual {p0}, Lcom/amazon/mShop/publicurl/PublicURLActivity;->getIntent()Landroid/content/Intent;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v5

    .line 44
    .local v5, "uri":Landroid/net/Uri;
    if-eqz v5, :cond_0

    .line 45
    :try_start_0
    invoke-static {v5}, Lcom/amazon/mShop/publicurl/PublicURLProcessorFactory;->getInstance(Landroid/net/Uri;)Lcom/amazon/mShop/publicurl/PublicURLProcessor;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/mShop/publicurl/PublicURLActivity;->mProcessor:Lcom/amazon/mShop/publicurl/PublicURLProcessor;

    .line 47
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/mShop/platform/Platform;->getAppStartCountForAllLocales()I

    move-result v6

    if-nez v6, :cond_1

    move v2, v7

    .line 48
    .local v2, "isFirstStart":Z
    :goto_0
    iget-object v6, p0, Lcom/amazon/mShop/publicurl/PublicURLActivity;->mProcessor:Lcom/amazon/mShop/publicurl/PublicURLProcessor;

    invoke-virtual {v6, p0}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->process(Landroid/content/Context;)V

    .line 50
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "client-Android-Amazon_URL_"

    invoke-virtual {v6, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v9, p0, Lcom/amazon/mShop/publicurl/PublicURLActivity;->mProcessor:Lcom/amazon/mShop/publicurl/PublicURLProcessor;

    invoke-virtual {v9}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->getMetricIdentity()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    if-eqz v2, :cond_2

    sget-object v6, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;->PUBLIC_URL_FIRST_START:Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    :goto_1
    invoke-static {v9, v6}, Lcom/amazon/mShop/net/StartupMetricsObserver;->logStartupMetrics(Ljava/lang/String;Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;)V

    .line 53
    .end local v2    # "isFirstStart":Z
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/publicurl/PublicURLActivity;->finish()V

    .line 84
    :goto_2
    return-void

    :cond_1
    move v2, v8

    .line 47
    goto :goto_0

    .line 50
    .restart local v2    # "isFirstStart":Z
    :cond_2
    sget-object v6, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;->PUBLIC_URL_START:Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;
    :try_end_0
    .catch Lcom/amazon/mShop/publicurl/PublicURLProcessException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 54
    .end local v2    # "isFirstStart":Z
    :catch_0
    move-exception v1

    .line 55
    .local v1, "exception":Lcom/amazon/mShop/publicurl/PublicURLProcessException;
    sget-object v6, Lcom/amazon/mShop/publicurl/PublicURLActivity$3;->$SwitchMap$com$amazon$mShop$publicurl$PublicURLProcessException$PublicURLErrorCode:[I

    invoke-virtual {v1}, Lcom/amazon/mShop/publicurl/PublicURLProcessException;->errorCode()Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    move-result-object v9

    invoke-virtual {v9}, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ordinal()I

    move-result v9

    aget v6, v6, v9

    packed-switch v6, :pswitch_data_0

    goto :goto_2

    .line 57
    :pswitch_0
    sget v6, Lcom/amazon/mShop/android/lib/R$string;->public_url_host_unavailable:I

    new-array v7, v7, [Ljava/lang/Object;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v5}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {p0, v6, v7}, Lcom/amazon/mShop/publicurl/PublicURLActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    new-instance v7, Lcom/amazon/mShop/publicurl/PublicURLActivity$1;

    invoke-direct {v7, p0}, Lcom/amazon/mShop/publicurl/PublicURLActivity$1;-><init>(Lcom/amazon/mShop/publicurl/PublicURLActivity;)V

    invoke-static {p0, v6, v7}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V

    goto :goto_2

    .line 66
    :pswitch_1
    sget v6, Lcom/amazon/mShop/android/lib/R$string;->public_url_host_unavailable:I

    new-array v7, v7, [Ljava/lang/Object;

    iget-object v9, p0, Lcom/amazon/mShop/publicurl/PublicURLActivity;->mProcessor:Lcom/amazon/mShop/publicurl/PublicURLProcessor;

    invoke-virtual {v9}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->getHost()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {p0, v6, v7}, Lcom/amazon/mShop/publicurl/PublicURLActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    new-instance v7, Lcom/amazon/mShop/publicurl/PublicURLActivity$2;

    invoke-direct {v7, p0}, Lcom/amazon/mShop/publicurl/PublicURLActivity$2;-><init>(Lcom/amazon/mShop/publicurl/PublicURLActivity;)V

    invoke-static {p0, v6, v7}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V

    goto :goto_2

    .line 77
    :pswitch_2
    const-string/jumbo v6, "country_name"

    iget-object v9, p0, Lcom/amazon/mShop/publicurl/PublicURLActivity;->mProcessor:Lcom/amazon/mShop/publicurl/PublicURLProcessor;

    invoke-virtual {v9}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->getLocaleName()Ljava/lang/String;

    move-result-object v9

    invoke-static {p0, v6, v9}, Lcom/amazon/mShop/util/ResourcesUtils;->getStringOfSpecificLocale(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 78
    .local v0, "countryName":Ljava/lang/String;
    sget v6, Lcom/amazon/mShop/android/lib/R$string;->public_url_switch_locale_message:I

    new-array v7, v7, [Ljava/lang/Object;

    aput-object v0, v7, v8

    invoke-virtual {p0, v6, v7}, Lcom/amazon/mShop/publicurl/PublicURLActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 79
    .local v4, "message":Ljava/lang/String;
    new-instance v3, Landroid/content/Intent;

    const-class v6, Lcom/amazon/mShop/publicurl/PublicURLActivity;

    invoke-direct {v3, p0, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 80
    .local v3, "launchIntent":Landroid/content/Intent;
    invoke-virtual {v3, v5}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 81
    iget-object v6, p0, Lcom/amazon/mShop/publicurl/PublicURLActivity;->mProcessor:Lcom/amazon/mShop/publicurl/PublicURLProcessor;

    invoke-virtual {v6}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->getLocaleName()Ljava/lang/String;

    move-result-object v6

    invoke-static {p0, v6, v4, v3}, Lcom/amazon/mShop/util/AppUtils;->showSwitchLocaleDialog(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V

    goto/16 :goto_2

    .line 55
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 38
    invoke-direct {p0}, Lcom/amazon/mShop/publicurl/PublicURLActivity;->processURL()V

    .line 39
    return-void
.end method
