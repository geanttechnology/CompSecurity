.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$10;
.super Ljava/lang/Object;
.source "SharingSettingsFragment.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/SharingSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V
    .locals 0

    .prologue
    .line 410
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$10;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 6
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    const/4 v5, 0x0

    const/16 v4, 0x8

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 412
    const-string v0, "fbsettings/"

    .line 413
    .local v0, "label":Ljava/lang/String;
    if-eqz p2, :cond_1

    .line 414
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "on"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 415
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v1

    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->PUBLISH_PERMISSION:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->isPermissionEnabled(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 416
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1, v3}, Lcom/poshmark/application/PMApplicationSession;->setFacebookPostToTimelineFlag(Z)V

    .line 417
    invoke-static {v3, v5}, Lcom/poshmark/http/api/PMApi;->postFacebookTimelineFlag(ZLcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 427
    :goto_0
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$10;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "user"

    const-string v4, "timeline_toggled"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 428
    return-void

    .line 419
    :cond_0
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$10;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    sget v3, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_AUTO_TIMELINE_REQUEST:I

    invoke-virtual {v1, v2, v4, v4, v3}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;III)V

    goto :goto_0

    .line 423
    :cond_1
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1, v2}, Lcom/poshmark/application/PMApplicationSession;->setFacebookPostToTimelineFlag(Z)V

    .line 424
    invoke-static {v2, v5}, Lcom/poshmark/http/api/PMApi;->postFacebookTimelineFlag(ZLcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 425
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "off"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
