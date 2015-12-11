.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$15;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateActionButtons(Landroid/widget/LinearLayout;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V
    .locals 0

    .prologue
    .line 897
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$15;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 901
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$15;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingDetailsFragment;->shareListing()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->access$400(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    .line 902
    return-void
.end method
