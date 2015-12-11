.class Lcom/poshmark/ui/fragments/ListingEditorShareFragment$11;
.super Ljava/lang/Object;
.source "ListingEditorShareFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupActionBarNextActionButton()V
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
    .line 664
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 667
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    # getter for: Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->access$000(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)Lcom/poshmark/utils/ListingManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 668
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    # getter for: Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->access$000(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)Lcom/poshmark/utils/ListingManager;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ListingManager;->postListing(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 670
    :cond_0
    return-void
.end method
