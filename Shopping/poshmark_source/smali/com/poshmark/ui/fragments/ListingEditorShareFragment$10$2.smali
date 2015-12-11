.class Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10$2;
.super Ljava/lang/Object;
.source "ListingEditorShareFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;->onCheckedChanged(Landroid/widget/CompoundButton;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;

.field final synthetic val$partySwitch:Landroid/widget/Switch;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;Landroid/widget/Switch;)V
    .locals 0

    .prologue
    .line 630
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10$2;->this$1:Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10$2;->val$partySwitch:Landroid/widget/Switch;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 633
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10$2;->val$partySwitch:Landroid/widget/Switch;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setChecked(Z)V

    .line 634
    return-void
.end method
