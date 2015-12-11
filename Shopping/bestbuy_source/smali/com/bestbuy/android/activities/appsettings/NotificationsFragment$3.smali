.class Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$3;
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
    .line 121
    iput-object p1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$3;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 5

    .prologue
    const v3, 0x7f08008b

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$3;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->a(Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$3;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->b(Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;)Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0}, Llq;->a(Landroid/content/Context;)Ljava/util/ArrayList;

    move-result-object v0

    .line 126
    if-eqz p2, :cond_0

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$3;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x1

    invoke-interface {v1, v0, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 140
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$3;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f08008a

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 141
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$3;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-virtual {v0, p2}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->a(Z)V

    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$3;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->b(Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;)Landroid/app/Activity;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Llq;->a(Landroid/content/Context;Ljava/util/ArrayList;)V

    .line 144
    return-void

    .line 129
    :cond_0
    iget-object v2, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$3;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-virtual {v2}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 131
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->pushManager()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$3;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    const v4, 0x7f080388

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/exacttarget/etpushsdk/ETPush;->removeTag(Ljava/lang/String;)V

    .line 132
    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 133
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->pushManager()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/ETPush;->removeTag(Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 136
    :catch_0
    move-exception v0

    .line 137
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->printStackTrace()V

    goto :goto_0

    .line 135
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$3;->a:Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->b(Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;)Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0}, Llq;->c(Landroid/content/Context;)V
    :try_end_1
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
