.class Lcom/poshmark/ui/fragments/ListingEditorFragment$6;
.super Ljava/lang/Object;
.source "ListingEditorFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingEditorFragment;->handleBack()Z
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
    .line 504
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$6;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 507
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 508
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$6;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->finishActivity()V

    .line 509
    return-void
.end method
