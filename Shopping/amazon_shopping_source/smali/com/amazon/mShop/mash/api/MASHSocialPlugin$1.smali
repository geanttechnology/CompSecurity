.class Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;
.super Ljava/lang/Object;
.source "MASHSocialPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHSocialPlugin;->share(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mash/api/MASHSocialPlugin;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;

.field final synthetic val$imageUrl:Ljava/lang/String;

.field final synthetic val$subject:Ljava/lang/String;

.field final synthetic val$text:Ljava/lang/String;

.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/api/MASHSocialPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;)V
    .locals 0

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHSocialPlugin;

    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->val$text:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->val$subject:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->val$imageUrl:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->val$url:Ljava/lang/String;

    iput-object p6, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 64
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v4, "android.intent.action.SEND"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 65
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v4, "text/plain"

    invoke-virtual {v0, v4}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 66
    const-string/jumbo v4, "android.intent.extra.TEXT"

    iget-object v5, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->val$text:Ljava/lang/String;

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 67
    const-string/jumbo v4, "android.intent.extra.SUBJECT"

    iget-object v5, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->val$subject:Ljava/lang/String;

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 68
    const-string/jumbo v4, "imgUrl"

    iget-object v5, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->val$imageUrl:Ljava/lang/String;

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 69
    const-string/jumbo v4, "url"

    iget-object v5, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->val$url:Ljava/lang/String;

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 70
    iget-object v4, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHSocialPlugin;

    iget-object v4, v4, Lcom/amazon/mShop/mash/api/MASHSocialPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v4}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->sharing_share:I

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 71
    .local v3, "title":Ljava/lang/String;
    const-string/jumbo v4, "android.intent.extra.TITLE"

    invoke-virtual {v0, v4, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 72
    iget-object v4, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHSocialPlugin;

    iget-object v4, v4, Lcom/amazon/mShop/mash/api/MASHSocialPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v4}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-static {v4, v0}, Lcom/amazon/mShop/AmazonChooserActivity;->getIntentToStart(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v2

    .line 73
    .local v2, "selectedIntent":Landroid/content/Intent;
    iget-object v4, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHSocialPlugin;

    iget-object v4, v4, Lcom/amazon/mShop/mash/api/MASHSocialPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    iget-object v5, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHSocialPlugin;

    const/16 v6, 0xf

    invoke-interface {v4, v5, v2, v6}, Lorg/apache/cordova/CordovaInterface;->startActivityForResult(Lorg/apache/cordova/CordovaPlugin;Landroid/content/Intent;I)V

    .line 74
    new-instance v1, Lorg/apache/cordova/PluginResult;

    sget-object v4, Lorg/apache/cordova/PluginResult$Status;->NO_RESULT:Lorg/apache/cordova/PluginResult$Status;

    invoke-direct {v1, v4}, Lorg/apache/cordova/PluginResult;-><init>(Lorg/apache/cordova/PluginResult$Status;)V

    .line 75
    .local v1, "r":Lorg/apache/cordova/PluginResult;
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Lorg/apache/cordova/PluginResult;->setKeepCallback(Z)V

    .line 76
    iget-object v4, p0, Lcom/amazon/mShop/mash/api/MASHSocialPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v4, v1}, Lorg/apache/cordova/CallbackContext;->sendPluginResult(Lorg/apache/cordova/PluginResult;)V

    .line 77
    return-void
.end method
