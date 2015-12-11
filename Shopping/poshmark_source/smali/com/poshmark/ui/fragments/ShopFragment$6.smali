.class Lcom/poshmark/ui/fragments/ShopFragment$6;
.super Ljava/lang/Object;
.source "ShopFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ShopFragment;->setUpButtons()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ShopFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ShopFragment;)V
    .locals 0

    .prologue
    .line 380
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShopFragment$6;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 383
    new-instance v3, Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    invoke-direct {v3}, Lcom/poshmark/utils/meta_data/ColorPickerInfo;-><init>()V

    .line 384
    .local v3, "info":Lcom/poshmark/utils/meta_data/ColorPickerInfo;
    invoke-static {}, Lcom/poshmark/db/DbApi;->getAllColors()Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->allItems:Ljava/util/List;

    .line 385
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShopFragment$6;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ShopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 386
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 387
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "COLOR_PICKER_MODE"

    sget-object v4, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_BROWSE:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->ordinal()I

    move-result v4

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 388
    const-string v2, "RETURN_RESULT"

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 389
    const-class v2, Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShopFragment$6;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    const/4 v5, 0x3

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 390
    return-void
.end method
