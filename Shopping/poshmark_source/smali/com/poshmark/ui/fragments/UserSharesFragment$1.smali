.class Lcom/poshmark/ui/fragments/UserSharesFragment$1;
.super Ljava/lang/Object;
.source "UserSharesFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/UserSharesFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/UserSharesFragment;)V
    .locals 0

    .prologue
    .line 145
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$1;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x0

    .line 148
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$1;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    # getter for: Lcom/poshmark/ui/fragments/UserSharesFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/UserSharesFragment;->access$000(Lcom/poshmark/ui/fragments/UserSharesFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 150
    instance-of v2, p1, Lcom/poshmark/ui/customviews/RoundedImageView;

    if-eqz v2, :cond_0

    .line 151
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$1;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/UserSharesFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "user"

    const-string v5, "profile_image_tapped"

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 161
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 162
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "NAME"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$1;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    # getter for: Lcom/poshmark/ui/fragments/UserSharesFragment;->userName:Ljava/lang/String;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/UserSharesFragment;->access$100(Lcom/poshmark/ui/fragments/UserSharesFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 163
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$1;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/UserSharesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 164
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-virtual {v1, v0, v2, v6}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 167
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    :cond_1
    return-void
.end method
