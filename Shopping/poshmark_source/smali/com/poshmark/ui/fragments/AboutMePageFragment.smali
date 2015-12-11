.class public Lcom/poshmark/ui/fragments/AboutMePageFragment;
.super Lcom/poshmark/ui/fragments/MappPageFragment;
.source "AboutMePageFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public handleNotification(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 24
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PROFILE_UPDATED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 25
    const-string v0, "pmapp_profile_updated()"

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/AboutMePageFragment;->fireJSCallback(Ljava/lang/String;)V

    .line 29
    :cond_0
    :goto_0
    return-void

    .line 26
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.BRAND_FOLLOW_STATUS_CHANGED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 27
    const-string v0, "pmapp_following_brands_updated()"

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/AboutMePageFragment;->fireJSCallback(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 17
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/MappPageFragment;->onCreate(Landroid/os/Bundle;)V

    .line 18
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PROFILE_UPDATED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 19
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.BRAND_FOLLOW_STATUS_CHANGED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 20
    return-void
.end method
