.class Lcom/poshmark/ui/fragments/UserSharesFragment$9;
.super Ljava/lang/Object;
.source "UserSharesFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/UserSharesFragment;->updateProfileCard()V
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
    .line 357
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$9;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFollowClick()V
    .locals 5

    .prologue
    .line 360
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$9;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/UserSharesFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "user"

    const-string v3, "follow_tapped"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 361
    return-void
.end method

.method public onFollowingClick()V
    .locals 5

    .prologue
    .line 365
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSharesFragment$9;->this$0:Lcom/poshmark/ui/fragments/UserSharesFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/UserSharesFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "user"

    const-string v3, "unfollow_tapped"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 366
    return-void
.end method
