.class Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;
.super Ljava/lang/Object;
.source "MASHCorePlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHCorePlugin;->showChooser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mobile/mash/api/MASHCorePlugin;

.field final synthetic val$buttonTitlesArray:[Ljava/lang/String;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;

.field final synthetic val$cancelButtonTitle:Ljava/lang/String;

.field final synthetic val$destructiveButtonTitle:Ljava/lang/String;

.field final synthetic val$lenOfButtonTitles:I

.field final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin;Ljava/lang/String;[Ljava/lang/String;Lorg/apache/cordova/CallbackContext;Ljava/lang/String;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHCorePlugin;

    iput-object p2, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$title:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$buttonTitlesArray:[Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    iput-object p5, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$cancelButtonTitle:Ljava/lang/String;

    iput p6, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$lenOfButtonTitles:I

    iput-object p7, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$destructiveButtonTitle:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 78
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHCorePlugin;

    iget-object v1, v1, Lcom/amazon/mobile/mash/api/MASHCorePlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v1}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 79
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$title:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mobile/mash/util/Util;->isDefined(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 80
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 83
    :cond_0
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$buttonTitlesArray:[Ljava/lang/String;

    new-instance v2, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1$1;

    invoke-direct {v2, p0}, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1$1;-><init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setItems([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 90
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$cancelButtonTitle:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mobile/mash/util/Util;->isDefined(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 91
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$cancelButtonTitle:Ljava/lang/String;

    new-instance v2, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1$2;

    invoke-direct {v2, p0}, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1$2;-><init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 100
    :cond_1
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$destructiveButtonTitle:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mobile/mash/util/Util;->isDefined(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 101
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$destructiveButtonTitle:Ljava/lang/String;

    new-instance v2, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1$3;

    invoke-direct {v2, p0}, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1$3;-><init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 108
    :cond_2
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 109
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/AlertDialog;->show()V

    .line 110
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 111
    sget-object v1, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "ShowChooser is executed."

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 113
    :cond_3
    return-void
.end method
