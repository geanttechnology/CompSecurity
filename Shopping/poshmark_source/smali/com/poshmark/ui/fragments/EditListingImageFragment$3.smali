.class Lcom/poshmark/ui/fragments/EditListingImageFragment$3;
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
    .line 165
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment$3;->this$0:Lcom/poshmark/ui/fragments/EditListingImageFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 168
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment$3;->this$0:Lcom/poshmark/ui/fragments/EditListingImageFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment$3;->this$0:Lcom/poshmark/ui/fragments/EditListingImageFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditListingImageFragment;->originalImageURI:Landroid/net/Uri;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->access$100(Lcom/poshmark/ui/fragments/EditListingImageFragment;)Landroid/net/Uri;

    move-result-object v1

    # invokes: Lcom/poshmark/ui/fragments/EditListingImageFragment;->fireCameraFiltersActivity(Landroid/net/Uri;)V
    invoke-static {v0, v1}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->access$200(Lcom/poshmark/ui/fragments/EditListingImageFragment;Landroid/net/Uri;)V

    .line 169
    return-void
.end method
