.class Lcom/poshmark/ui/fragments/MySizeFragment$3;
.super Ljava/lang/Object;
.source "MySizeFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/MySizeFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MySizeFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MySizeFragment;)V
    .locals 0

    .prologue
    .line 270
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MySizeFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizeFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 273
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 274
    .local v6, "category":Ljava/lang/String;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 275
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "MODE"

    sget-object v4, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->MY_SIZE:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->ordinal()I

    move-result v4

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 276
    const-string v2, "CATEGORY"

    invoke-virtual {v1, v2, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 277
    new-instance v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    invoke-direct {v3}, Lcom/poshmark/utils/meta_data/MySizePickerInfo;-><init>()V

    .line 279
    .local v3, "info":Lcom/poshmark/utils/meta_data/MySizePickerInfo;
    invoke-static {v6}, Lcom/poshmark/db/DbApi;->getSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    .line 280
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizeFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizeFragment;

    # invokes: Lcom/poshmark/ui/fragments/MySizeFragment;->getCurrentSelectionsListForCategory(Ljava/lang/String;)Ljava/util/List;
    invoke-static {v2, v6}, Lcom/poshmark/ui/fragments/MySizeFragment;->access$200(Lcom/poshmark/ui/fragments/MySizeFragment;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->selectedItems:Ljava/util/List;

    .line 281
    new-instance v2, Lcom/poshmark/data_model/models/MetaItem;

    invoke-direct {v2, v6, v6}, Lcom/poshmark/data_model/models/MetaItem;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 282
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MySizeFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizeFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/MySizeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 283
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MySizePickerFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/MySizeFragment$3;->this$0:Lcom/poshmark/ui/fragments/MySizeFragment;

    const/4 v5, 0x3

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 284
    return-void
.end method
