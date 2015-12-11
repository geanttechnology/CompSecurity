.class Lcom/poshmark/ui/fragments/ClosetFragment$16;
.super Ljava/lang/Object;
.source "ClosetFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ClosetFragment;->updateProfileCard()V
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
    .line 555
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$16;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFollowClick()V
    .locals 6

    .prologue
    .line 558
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment$16;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ClosetFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "user"

    const-string v4, "follow_tapped"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 559
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$16;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/poshmark/user/UserInfoDetails;->setCallerIsFollowing(Z)V

    .line 560
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$16;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment$16;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/user/UserInfoDetails;->getFollowersCount()I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Lcom/poshmark/user/UserInfoDetails;->setFollowersCount(I)V

    .line 561
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$16;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/user/UserInfoDetails;->getFollowersCount()I

    move-result v1

    invoke-static {v1}, Lcom/poshmark/utils/StringUtils;->abbreviatedStringRepresentationOfNumber(I)Ljava/lang/String;

    move-result-object v0

    .line 562
    .local v0, "countString":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$16;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$300(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    move-result-object v1

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followerCountView:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 563
    return-void
.end method

.method public onFollowingClick()V
    .locals 6

    .prologue
    .line 567
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment$16;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ClosetFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "user"

    const-string v4, "unfollow_tapped"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 568
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$16;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/poshmark/user/UserInfoDetails;->setCallerIsFollowing(Z)V

    .line 569
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$16;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment$16;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/user/UserInfoDetails;->getFollowersCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Lcom/poshmark/user/UserInfoDetails;->setFollowersCount(I)V

    .line 570
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$16;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/user/UserInfoDetails;->getFollowersCount()I

    move-result v1

    invoke-static {v1}, Lcom/poshmark/utils/StringUtils;->abbreviatedStringRepresentationOfNumber(I)Ljava/lang/String;

    move-result-object v0

    .line 571
    .local v0, "countString":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$16;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->closetHeaderViewHolder:Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$300(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;

    move-result-object v1

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/ClosetHeaderViewHolder;->followerCountView:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 572
    return-void
.end method
