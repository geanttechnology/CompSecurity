.class Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1$1;
.super Ljava/lang/Object;
.source "AmazonChooserActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;

.field final synthetic val$defaultIcon:Landroid/graphics/drawable/Drawable;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;Landroid/graphics/drawable/Drawable;)V
    .locals 0

    .prologue
    .line 347
    iput-object p1, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1$1;->this$2:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;

    iput-object p2, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1$1;->val$defaultIcon:Landroid/graphics/drawable/Drawable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 350
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1$1;->this$2:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;

    iget-object v0, v0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->val$appIcon:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1$1;->val$defaultIcon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 354
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1$1;->this$2:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;

    iget-object v0, v0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->this$1:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;

    # getter for: Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mNeedRedraw:Z
    invoke-static {v0}, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->access$300(Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 355
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1$1;->this$2:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;

    iget-object v0, v0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->this$1:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->notifyDataSetChanged()V

    .line 356
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1$1;->this$2:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;

    iget-object v0, v0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->this$1:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mNeedRedraw:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->access$302(Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;Z)Z

    .line 358
    :cond_0
    return-void
.end method
