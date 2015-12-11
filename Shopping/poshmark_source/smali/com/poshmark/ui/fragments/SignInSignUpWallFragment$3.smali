.class Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;
.super Ljava/lang/Object;
.source "SignInSignUpWallFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->setupButtonHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;)V
    .locals 0

    .prologue
    .line 185
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 189
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "user"

    const-string v3, "gp_connect_click"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    new-instance v2, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3$1;-><init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;)V

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;)V

    .line 201
    return-void
.end method
