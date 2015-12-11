.class Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$1;
.super Ljava/lang/Object;
.source "SuggestedBrandsPickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setupRetryButton()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 74
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$1;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    # invokes: Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setupBrandList()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->access$000(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V

    .line 75
    return-void
.end method
