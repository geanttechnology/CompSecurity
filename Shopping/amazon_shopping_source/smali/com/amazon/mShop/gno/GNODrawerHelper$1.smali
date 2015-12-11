.class final Lcom/amazon/mShop/gno/GNODrawerHelper$1;
.super Lcom/amazon/mShop/gno/GNODrawer$SimpleGNODrawerListener;
.source "GNODrawerHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNODrawerHelper;->closeDrawerAndExecute(Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$runnable:Ljava/lang/Runnable;


# direct methods
.method constructor <init>(Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 21
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerHelper$1;->val$runnable:Ljava/lang/Runnable;

    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawer$SimpleGNODrawerListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onDrawerClosed(Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 1
    .param p1, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 24
    invoke-virtual {p1, p0}, Lcom/amazon/mShop/gno/GNODrawer;->removeListener(Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;)V

    .line 26
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerHelper$1;->val$runnable:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 27
    return-void
.end method
