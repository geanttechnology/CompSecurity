.class Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$2;
.super Ljava/lang/Object;
.source "LocaleSwitchNotificationProcessor.java"

# interfaces
.implements Lcom/amazon/mShop/control/Cancellable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor;->doProcess(Ljava/lang/String;Landroid/content/Context;Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor;

.field final synthetic val$settingController:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor;Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$2;->this$0:Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor;

    iput-object p2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$2;->val$settingController:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$2;->val$settingController:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->cancel()V

    .line 101
    return-void
.end method
