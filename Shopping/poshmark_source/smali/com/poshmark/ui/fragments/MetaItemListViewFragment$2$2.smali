.class Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$2;
.super Ljava/lang/Object;
.source "MetaItemListViewFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;)V
    .locals 0

    .prologue
    .line 301
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$2;->this$1:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 303
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 304
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$2;->this$1:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->hideKeyboard()V

    .line 305
    return-void
.end method
