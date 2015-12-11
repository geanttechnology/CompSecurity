.class Lcom/amazon/mShop/gno/GNOItemAdapter$6;
.super Ljava/lang/Object;
.source "GNOItemAdapter.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOItemAdapter;->createAppstoreCoinTabCallable()Ljava/util/concurrent/Callable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOItemAdapter;)V
    .locals 0

    .prologue
    .line 665
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$6;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Ljava/lang/Boolean;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 668
    const-string/jumbo v0, "DISABLED"

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$6;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    # getter for: Lcom/amazon/mShop/gno/GNOItemAdapter;->mCoins:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->access$900(Lcom/amazon/mShop/gno/GNOItemAdapter;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 665
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNOItemAdapter$6;->call()Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method
