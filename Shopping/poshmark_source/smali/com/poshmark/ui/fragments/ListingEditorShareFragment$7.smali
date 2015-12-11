.class Lcom/poshmark/ui/fragments/ListingEditorShareFragment$7;
.super Ljava/lang/Object;
.source "ListingEditorShareFragment.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


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
    .line 364
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 5
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    const/16 v4, 0x8

    .line 368
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v1

    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->PUBLISH_PERMISSION:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->isPermissionEnabled(Ljava/lang/String;)Z

    move-result v0

    .line 369
    .local v0, "publishOk":Z
    if-eqz v0, :cond_1

    .line 370
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/application/PMApplicationSession;->setFacebookSharingFlag(Ljava/lang/Boolean;)V

    .line 371
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    # getter for: Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->access$000(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)Lcom/poshmark/utils/ListingManager;

    move-result-object v1

    invoke-virtual {v1, p2}, Lcom/poshmark/utils/ListingManager;->setFacebookShareFlag(Z)V

    .line 375
    :cond_0
    :goto_0
    return-void

    .line 372
    :cond_1
    if-eqz p2, :cond_0

    .line 373
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    sget v3, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_PUBLISH_REQUEST:I

    invoke-virtual {v1, v2, v4, v4, v3}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;III)V

    goto :goto_0
.end method
