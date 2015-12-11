.class Lcom/poshmark/ui/fragments/ListingEditorFragment$17;
.super Ljava/lang/Object;
.source "ListingEditorFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingEditorFragment;->createViewHolder(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V
    .locals 0

    .prologue
    .line 1024
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$17;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1027
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$17;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$17;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const v2, 0x7f0600b8

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$17;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const v3, 0x7f0600b9

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/ListingEditorFragment$17$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$17$1;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment$17;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->showConfirmationMessage(Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    .line 1035
    return-void
.end method
