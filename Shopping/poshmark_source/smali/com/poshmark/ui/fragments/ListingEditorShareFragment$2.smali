.class Lcom/poshmark/ui/fragments/ListingEditorShareFragment$2;
.super Ljava/lang/Object;
.source "ListingEditorShareFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/ListingEditorShareFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)V
    .locals 0

    .prologue
    .line 287
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 290
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060190

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 291
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->share_banner_image:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 292
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->showBanner:Z

    .line 293
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getViewNameForAnalytics()Ljava/lang/String;

    move-result-object v1

    const-string v2, "user"

    const-string v3, "connect_pinterest_initiated"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 294
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-virtual {v0, v1}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->pinterestLink(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 295
    return-void
.end method
