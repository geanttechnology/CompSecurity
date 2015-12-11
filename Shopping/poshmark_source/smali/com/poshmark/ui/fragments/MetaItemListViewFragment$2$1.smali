.class Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$1;
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

.field final synthetic val$input:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 292
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$1;->this$1:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$1;->val$input:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "whichButton"    # I

    .prologue
    .line 294
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$1;->this$1:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$1;->val$input:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$1;->val$input:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v1, v0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 295
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 296
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$1;->this$1:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->hideKeyboard()V

    .line 297
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2$1;->this$1:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$2;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->returnData()V

    .line 298
    return-void
.end method
