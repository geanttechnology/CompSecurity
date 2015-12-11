.class Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;
.super Ljava/lang/Object;
.source "LocaleSwitchCommonProcessor.java"

# interfaces
.implements Lcom/amazon/mShop/control/locale/LocaleSwitchSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;->doProcess(Ljava/lang/String;Landroid/content/Context;Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;

.field final synthetic val$chain:Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$localeFrom:Ljava/util/Locale;

.field final synthetic val$localeTo:Ljava/util/Locale;

.field final synthetic val$switchLocaleInCA:Z


# direct methods
.method constructor <init>(Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;Ljava/util/Locale;Landroid/content/Context;ZLjava/util/Locale;Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->this$0:Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;

    iput-object p2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->val$localeFrom:Ljava/util/Locale;

    iput-object p3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->val$context:Landroid/content/Context;

    iput-boolean p4, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->val$switchLocaleInCA:Z

    iput-object p5, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->val$localeTo:Ljava/util/Locale;

    iput-object p6, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->val$chain:Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->val$localeFrom:Ljava/util/Locale;

    invoke-virtual {v0}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/LocaleUtils;->setCurrentAppLocale(Ljava/lang/String;)V

    .line 51
    iget-object v1, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->val$context:Landroid/content/Context;

    iget-boolean v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->val$switchLocaleInCA:Z

    if-eqz v0, :cond_0

    sget v0, Lcom/amazon/mShop/android/lib/R$string;->error_message_switching_language:I

    :goto_0
    invoke-static {v1, v0}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;I)V

    .line 52
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->val$context:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 53
    return-void

    .line 51
    :cond_0
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->error_message_switching_country:I

    goto :goto_0
.end method

.method public onLocaleSwitchCompleted(Ljava/lang/String;)V
    .locals 4
    .param p1, "currentCode"    # Ljava/lang/String;

    .prologue
    .line 58
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "latestLocaleOfCanada"

    invoke-interface {v0, v1, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    invoke-static {p1}, Lcom/amazon/mShop/util/LocaleUtils;->setCurrentAppLocale(Ljava/lang/String;)V

    .line 61
    const-string/jumbo v0, "ch_lc_%1$s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->val$localeTo:Ljava/util/Locale;

    invoke-virtual {v3}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 62
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->this$0:Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;

    iget-object v1, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->val$context:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;->val$chain:Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    invoke-virtual {v2}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->getLaunchIntent()Landroid/content/Intent;

    move-result-object v2

    # invokes: Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;->localeChangedCompleted(Landroid/content/Context;Landroid/content/Intent;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;->access$000(Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;Landroid/content/Context;Landroid/content/Intent;)V

    .line 63
    return-void
.end method
