.class Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$3;
.super Ljava/lang/Object;
.source "FastBrowseActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getSearchMetadata(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 321
    iput-object p1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$3;->this$0:Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    iput-object p2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$3;->val$url:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 326
    new-instance v0, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;

    new-instance v1, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$3$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$3$1;-><init>(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$3;)V

    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$3;->val$url:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;Ljava/lang/String;)V

    .line 345
    .local v0, "loader":Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;
    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;->getRefinements()V

    .line 346
    return-void
.end method
