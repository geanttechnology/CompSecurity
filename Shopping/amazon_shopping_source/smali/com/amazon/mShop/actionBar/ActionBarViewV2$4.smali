.class Lcom/amazon/mShop/actionBar/ActionBarViewV2$4;
.super Ljava/lang/Object;
.source "ActionBarViewV2.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/actionBar/ActionBarViewV2;->onFinishInflate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)V
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$4;->this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 127
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$4;->this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    # getter for: Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->access$100(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    const/4 v1, 0x1

    new-instance v2, Lcom/amazon/mShop/actionBar/ActionBarViewV2$4$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2$4$1;-><init>(Lcom/amazon/mShop/actionBar/ActionBarViewV2$4;)V

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/gno/GNODrawerHelper;->closeDrawerAndExecute(Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/Runnable;)V

    .line 134
    return-void
.end method
