.class Lcom/poshmark/ui/fragments/MetaItemListViewFragment$4;
.super Ljava/lang/Object;
.source "MetaItemListViewFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->setupSearchListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MetaItemListViewFragment;)V
    .locals 0

    .prologue
    .line 341
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$4;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 1
    .param p1, "editable"    # Landroid/text/Editable;

    .prologue
    .line 354
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$4;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->adapter:Lcom/poshmark/data_model/adapters/MetaItemListAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/MetaItemListAdapter;->getFilter()Landroid/widget/Filter;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/Filter;->filter(Ljava/lang/CharSequence;)V

    .line 355
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$4;->this$0:Lcom/poshmark/ui/fragments/MetaItemListViewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->searchBox:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 356
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 345
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 350
    return-void
.end method
