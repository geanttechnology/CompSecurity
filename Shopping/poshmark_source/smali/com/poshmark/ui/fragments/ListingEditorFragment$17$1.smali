.class Lcom/poshmark/ui/fragments/ListingEditorFragment$17$1;
.super Ljava/lang/Object;
.source "ListingEditorFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingEditorFragment$17;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/ListingEditorFragment$17;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingEditorFragment$17;)V
    .locals 0

    .prologue
    .line 1027
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$17$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorFragment$17;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;
    .param p2, "i"    # I

    .prologue
    .line 1030
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 1031
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$17$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorFragment$17;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$17;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingEditorFragment;->deleteListing()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->access$600(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    .line 1033
    :cond_0
    return-void
.end method
