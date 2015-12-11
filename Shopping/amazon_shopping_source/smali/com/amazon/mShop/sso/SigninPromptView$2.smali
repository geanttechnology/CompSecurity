.class Lcom/amazon/mShop/sso/SigninPromptView$2;
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
    .line 55
    iput-object p1, p0, Lcom/amazon/mShop/sso/SigninPromptView$2;->this$0:Lcom/amazon/mShop/sso/SigninPromptView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/sso/SigninPromptView$2;->this$0:Lcom/amazon/mShop/sso/SigninPromptView;

    # getter for: Lcom/amazon/mShop/sso/SigninPromptView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/sso/SigninPromptView;->access$000(Lcom/amazon/mShop/sso/SigninPromptView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/sso/SigninPromptView$2;->this$0:Lcom/amazon/mShop/sso/SigninPromptView;

    # getter for: Lcom/amazon/mShop/sso/SigninPromptView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/sso/SigninPromptView;->access$000(Lcom/amazon/mShop/sso/SigninPromptView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->skipSigin(Landroid/content/Context;)V

    .line 61
    const-string/jumbo v0, "sps_skip_sign_in"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 62
    return-void
.end method
