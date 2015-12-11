.class Lcom/poshmark/ui/fragments/ListingEditorShareFragment$6;
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
    .line 357
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$6;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 2
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    .line 360
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/application/PMApplicationSession;->setPinterestSharingFlag(Ljava/lang/Boolean;)V

    .line 361
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$6;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    # getter for: Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->access$000(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)Lcom/poshmark/utils/ListingManager;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/poshmark/utils/ListingManager;->setPinterestShareFlag(Z)V

    .line 362
    return-void
.end method
