.class Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;
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
    .line 305
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 308
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060190

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 309
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    new-instance v2, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4$1;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment$4;)V

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->twitterLink(Ljava/lang/Object;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V

    .line 328
    return-void
.end method
