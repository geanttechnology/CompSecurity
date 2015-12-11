.class Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;
.super Ljava/lang/Object;
.source "AmazonChooserActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->populateItemView(Landroid/view/View;Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Landroid/content/pm/ResolveInfo;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;

.field final synthetic val$appIcon:Landroid/widget/ImageView;

.field final synthetic val$packageName:Ljava/lang/String;

.field final synthetic val$resolveInfo:Landroid/content/pm/ResolveInfo;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;Landroid/content/pm/ResolveInfo;Ljava/lang/String;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 338
    iput-object p1, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->this$1:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;

    iput-object p2, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->val$resolveInfo:Landroid/content/pm/ResolveInfo;

    iput-object p3, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->val$packageName:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->val$appIcon:Landroid/widget/ImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 341
    iget-object v1, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->val$resolveInfo:Landroid/content/pm/ResolveInfo;

    iget-object v2, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->this$1:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;

    # getter for: Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mPackManager:Landroid/content/pm/PackageManager;
    invoke-static {v2}, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->access$200(Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;)Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/pm/ResolveInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 342
    .local v0, "defaultIcon":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 343
    iget-object v1, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->this$1:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;

    iget-object v1, v1, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mPackageIconMap:Ljava/util/Map;

    iget-object v2, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->val$packageName:Ljava/lang/String;

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 347
    iget-object v1, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;->this$1:Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;

    iget-object v1, v1, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->this$0:Lcom/amazon/mShop/AmazonChooserActivity;

    new-instance v2, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1$1;

    invoke-direct {v2, p0, v0}, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1$1;-><init>(Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;Landroid/graphics/drawable/Drawable;)V

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonChooserActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 361
    :cond_0
    return-void
.end method
