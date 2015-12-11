.class Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$1;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 4

    .prologue
    const v2, 0x7f08004b

    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$1;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->a(Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 75
    if-eqz p2, :cond_0

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$1;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x1

    invoke-interface {v1, v0, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 85
    :goto_0
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$1;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->b(Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;)Landroid/app/Activity;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Llq;->a(Landroid/content/Context;Ljava/util/ArrayList;)V

    .line 87
    return-void

    .line 78
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$1;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {v1, v0, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 80
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->pushManager()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$1;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    const v3, 0x7f0802c1

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/exacttarget/etpushsdk/ETPush;->removeTag(Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 81
    :catch_0
    move-exception v0

    .line 82
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->printStackTrace()V

    goto :goto_0
.end method
