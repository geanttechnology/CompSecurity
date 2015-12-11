.class Lcom/poshmark/ui/fragments/FindFriendsFragment$1;
.super Ljava/lang/Object;
.source "FindFriendsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FindFriendsFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$1;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 87
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$1;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/FindFriendsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "user"

    const-string v3, "completed_on_ramp"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$1;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->finishActivity()V

    .line 89
    return-void
.end method
