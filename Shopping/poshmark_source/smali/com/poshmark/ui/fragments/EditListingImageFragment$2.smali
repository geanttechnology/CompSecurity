.class Lcom/poshmark/ui/fragments/EditListingImageFragment$2;
.super Ljava/lang/Object;
.source "EditListingImageFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/EditListingImageFragment;->setupButtonHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/EditListingImageFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/EditListingImageFragment;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment$2;->this$0:Lcom/poshmark/ui/fragments/EditListingImageFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 161
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment$2;->this$0:Lcom/poshmark/ui/fragments/EditListingImageFragment;

    # invokes: Lcom/poshmark/ui/fragments/EditListingImageFragment;->fireCameraActivity()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->access$000(Lcom/poshmark/ui/fragments/EditListingImageFragment;)V

    .line 162
    return-void
.end method
