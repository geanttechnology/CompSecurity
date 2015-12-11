.class Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;
.super Ljava/lang/Object;
.source "MASHCorePlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHCorePlugin;->showAlert(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mobile/mash/api/MASHCorePlugin;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;

.field final synthetic val$cancelButtonTitle:Ljava/lang/String;

.field final synthetic val$lenOfButtonTitles:I

.field final synthetic val$message:Ljava/lang/String;

.field final synthetic val$neutralButtonTitle:Ljava/lang/String;

.field final synthetic val$positiveButtonTitle:Ljava/lang/String;

.field final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 133
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->this$0:Lcom/amazon/mobile/mash/api/MASHCorePlugin;

    iput-object p2, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$title:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$message:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$positiveButtonTitle:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$callback:Lorg/apache/cordova/CallbackContext;

    iput-object p6, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$neutralButtonTitle:Ljava/lang/String;

    iput-object p7, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$cancelButtonTitle:Ljava/lang/String;

    iput p8, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$lenOfButtonTitles:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 137
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->this$0:Lcom/amazon/mobile/mash/api/MASHCorePlugin;

    iget-object v1, v1, Lcom/amazon/mobile/mash/api/MASHCorePlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v1}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 138
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$title:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mobile/mash/util/Util;->isDefined(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 139
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 142
    :cond_0
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$message:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mobile/mash/util/Util;->isDefined(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 143
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$message:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 145
    :cond_1
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$positiveButtonTitle:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mobile/mash/util/Util;->isDefined(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 146
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$positiveButtonTitle:Ljava/lang/String;

    new-instance v2, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2$1;

    invoke-direct {v2, p0}, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2$1;-><init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 153
    :cond_2
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$neutralButtonTitle:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mobile/mash/util/Util;->isDefined(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 154
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$neutralButtonTitle:Ljava/lang/String;

    new-instance v2, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2$2;

    invoke-direct {v2, p0}, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2$2;-><init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNeutralButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 162
    :cond_3
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$cancelButtonTitle:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mobile/mash/util/Util;->isDefined(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 163
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$cancelButtonTitle:Ljava/lang/String;

    new-instance v2, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2$3;

    invoke-direct {v2, p0}, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2$3;-><init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 170
    :cond_4
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 171
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/AlertDialog;->show()V

    .line 172
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 173
    sget-object v1, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "ShowAlert is executed."

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 175
    :cond_5
    return-void
.end method
