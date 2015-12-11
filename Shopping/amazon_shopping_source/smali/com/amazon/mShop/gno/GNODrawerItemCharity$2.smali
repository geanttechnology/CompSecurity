.class Lcom/amazon/mShop/gno/GNODrawerItemCharity$2;
.super Ljava/lang/Object;
.source "GNODrawerItemCharity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNODrawerItemCharity;->onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNODrawerItemCharity;

.field final synthetic val$callingActivity:Lcom/amazon/mShop/AmazonActivity;

.field final synthetic val$drawer:Lcom/amazon/mShop/gno/GNODrawer;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNODrawerItemCharity;Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity$2;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemCharity;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity$2;->val$callingActivity:Lcom/amazon/mShop/AmazonActivity;

    iput-object p3, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity$2;->val$drawer:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 109
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity$2;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemCharity;

    # getter for: Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mListener:Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->access$100(Lcom/amazon/mShop/gno/GNODrawerItemCharity;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity$2;->val$callingActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity$2;->val$drawer:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-interface {v0, v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;->onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V

    .line 110
    return-void
.end method
