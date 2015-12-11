.class Lcom/amazon/mShop/sso/SigninPromptView$1;
.super Ljava/lang/Object;
.source "SigninPromptView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/SigninPromptView;-><init>(Lcom/amazon/mShop/AmazonActivity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/SigninPromptView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/SigninPromptView;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/mShop/sso/SigninPromptView$1;->this$0:Lcom/amazon/mShop/sso/SigninPromptView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 13
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x1

    const/4 v5, 0x0

    const/4 v3, 0x0

    .line 42
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v0

    sget-object v1, Lcom/amazon/mShop/sso/IdentityType;->NON_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    if-eq v0, v1, :cond_0

    .line 43
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/sso/SigninPromptView$1;->this$0:Lcom/amazon/mShop/sso/SigninPromptView;

    # getter for: Lcom/amazon/mShop/sso/SigninPromptView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/sso/SigninPromptView;->access$000(Lcom/amazon/mShop/sso/SigninPromptView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    move v4, v3

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/sso/IdentityType;->handleSSOLogin(Landroid/app/Activity;ZZZLjava/lang/String;)V

    .line 50
    :goto_0
    const-string/jumbo v0, "sps_sign_in"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 51
    return-void

    .line 48
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/sso/SigninPromptView$1;->this$0:Lcom/amazon/mShop/sso/SigninPromptView;

    # getter for: Lcom/amazon/mShop/sso/SigninPromptView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/sso/SigninPromptView;->access$000(Lcom/amazon/mShop/sso/SigninPromptView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v6

    move v7, v3

    move-object v8, v5

    move v9, v3

    move v10, v2

    move v11, v3

    move-object v12, v5

    invoke-static/range {v6 .. v12}, Lcom/amazon/mShop/util/ActivityUtils;->startLoginActivityForResult(Landroid/content/Context;ILjava/lang/String;ZZZLjava/lang/String;)Z

    goto :goto_0
.end method
