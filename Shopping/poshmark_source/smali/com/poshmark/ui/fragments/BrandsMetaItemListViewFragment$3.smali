.class Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$3;
.super Lcom/poshmark/ui/customviews/DrawableOnTouchListener;
.source "BrandsMetaItemListViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->setupSearchListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;Landroid/widget/EditText;)V
    .locals 0
    .param p2, "x0"    # Landroid/widget/EditText;

    .prologue
    .line 354
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$3;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-direct {p0, p2}, Lcom/poshmark/ui/customviews/DrawableOnTouchListener;-><init>(Landroid/widget/EditText;)V

    return-void
.end method


# virtual methods
.method public onDrawableTouch(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v3, 0x0

    .line 357
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$3;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchText:Ljava/lang/String;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$3;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchText:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 358
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$3;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iput-boolean v3, v1, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->itemClick:Z

    .line 359
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$3;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 360
    .local v0, "parent":Landroid/app/Activity;
    if-eqz v0, :cond_0

    .line 361
    invoke-virtual {v0}, Landroid/app/Activity;->onBackPressed()V

    .line 363
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$3;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->searchEditText:Lcom/poshmark/ui/customviews/PMEditText;

    const-string v2, ""

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setText(Ljava/lang/CharSequence;)V

    .line 364
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment$3;->this$0:Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;->hideKeyboard()V

    .line 366
    .end local v0    # "parent":Landroid/app/Activity;
    :cond_1
    return v3
.end method
