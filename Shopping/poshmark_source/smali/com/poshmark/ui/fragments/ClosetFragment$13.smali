.class Lcom/poshmark/ui/fragments/ClosetFragment$13;
.super Ljava/lang/Object;
.source "ClosetFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/ClosetFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ClosetFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V
    .locals 0

    .prologue
    .line 460
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$13;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x0

    .line 463
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment$13;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 465
    instance-of v2, p1, Lcom/poshmark/ui/customviews/RoundedImageView;

    if-eqz v2, :cond_0

    .line 466
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment$13;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ClosetFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "user"

    const-string v5, "profile_image_tapped"

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 468
    :cond_0
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 469
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://www.poshmark.com/mapp/users/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ClosetFragment$13;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v4}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/about_me"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 473
    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "AboutPage"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 474
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment$13;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 475
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/AboutMePageFragment;

    invoke-virtual {v0, v1, v2, v6}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 477
    .end local v0    # "activity":Lcom/poshmark/ui/PMActivity;
    .end local v1    # "b":Landroid/os/Bundle;
    :cond_1
    return-void
.end method
