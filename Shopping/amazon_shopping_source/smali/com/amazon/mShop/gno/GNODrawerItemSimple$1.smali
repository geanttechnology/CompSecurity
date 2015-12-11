.class Lcom/amazon/mShop/gno/GNODrawerItemSimple$1;
.super Ljava/lang/Object;
.source "GNODrawerItemSimple.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNODrawerItemSimple;->onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

.field final synthetic val$callingActivity:Lcom/amazon/mShop/AmazonActivity;

.field final synthetic val$drawer:Lcom/amazon/mShop/gno/GNODrawer;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNODrawerItemSimple;Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$1;->val$callingActivity:Lcom/amazon/mShop/AmazonActivity;

    iput-object p3, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$1;->val$drawer:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    # getter for: Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mListener:Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->access$100(Lcom/amazon/mShop/gno/GNODrawerItemSimple;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$1;->val$callingActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$1;->val$drawer:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-interface {v0, v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;->onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V

    .line 101
    return-void
.end method
