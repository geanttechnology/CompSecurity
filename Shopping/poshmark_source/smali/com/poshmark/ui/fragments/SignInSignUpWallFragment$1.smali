.class Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$1;
.super Ljava/lang/Object;
.source "SignInSignUpWallFragment.java"

# interfaces
.implements Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->setCustomBanner()V
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
    .line 135
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$1;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoadingCancelled(Ljava/lang/String;Landroid/view/View;)V
    .locals 0
    .param p1, "s"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 160
    return-void
.end method

.method public onLoadingComplete(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;)V
    .locals 4
    .param p1, "s"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 147
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$1;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->getView()Landroid/view/View;

    move-result-object v2

    const v3, 0x7f0c02d7

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 148
    .local v0, "image":Landroid/widget/ImageView;
    invoke-virtual {v0, p3}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 149
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$1;->this$0:Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    const-string v3, "nus_dl"

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->replaceTrackingLabel(Ljava/lang/String;)V

    .line 150
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 151
    .local v1, "trackingInfo":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "ev"

    const-string v3, "fbdl"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 152
    const-string v2, "s"

    const-string v3, "dlrc"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 153
    const-string v2, "lrf"

    sget-object v3, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->getDeepLinkUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 154
    invoke-static {v1}, Lcom/poshmark/http/api/PMApi;->trackDeepLink(Ljava/util/HashMap;)V

    .line 155
    return-void
.end method

.method public onLoadingFailed(Ljava/lang/String;Landroid/view/View;Lcom/nostra13/universalimageloader/core/assist/FailReason;)V
    .locals 0
    .param p1, "s"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "failReason"    # Lcom/nostra13/universalimageloader/core/assist/FailReason;

    .prologue
    .line 143
    return-void
.end method

.method public onLoadingStarted(Ljava/lang/String;Landroid/view/View;)V
    .locals 0
    .param p1, "s"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 138
    return-void
.end method
