.class final Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$2;
.super Ljava/lang/Object;
.source "PinterestHelper.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 211
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleNotification(Landroid/content/Intent;)V
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 214
    const-string v1, "RESULT"

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 215
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "PDKCLIENT_EXTRA_RESULT"

    const-string v2, "PDKCLIENT_EXTRA_RESULT"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 216
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getInstance()Lcom/pinterest/android/pdk/PDKClient;

    move-result-object v1

    const/16 v2, 0x2244

    const/4 v3, -0x1

    invoke-virtual {v1, v2, v3, p1}, Lcom/pinterest/android/pdk/PDKClient;->onOauthResponse(IILandroid/content/Intent;)V

    .line 217
    return-void
.end method
