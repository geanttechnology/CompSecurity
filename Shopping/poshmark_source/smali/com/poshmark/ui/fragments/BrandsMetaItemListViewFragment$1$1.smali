.class Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1$1;
.super Ljava/lang/Object;
.source "BrandsMetaItemListViewFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;

.field final synthetic val$input:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 263
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1$1;->val$input:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "whichButton"    # I

    .prologue
    .line 265
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    new-instance v1, Lcom/poshmark/data_model/models/MetaItem;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1$1;->val$input:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1$1;->val$input:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v1, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    .line 266
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 267
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->hideKeyboard()V

    .line 268
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->returnData()V

    .line 269
    return-void
.end method
