.class public Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;
.super Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;
.source "GNODrawerItemHideable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNODrawerItemHideable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder",
        "<TT;>;>",
        "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder",
        "<TT;>;"
    }
.end annotation


# instance fields
.field isHiddenCallable:Ljava/util/concurrent/Callable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Callable",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 51
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder<TT;>;"
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    invoke-direct {v0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemSimple;)V

    .line 52
    return-void
.end method

.method protected constructor <init>(Lcom/amazon/mShop/gno/GNODrawerItemHideable;)V
    .locals 0
    .param p1, "item"    # Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    .prologue
    .line 55
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder<TT;>;"
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemSimple;)V

    .line 56
    return-void
.end method


# virtual methods
.method public build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;
    .locals 2

    .prologue
    .line 60
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder<TT;>;"
    invoke-super {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    .line 61
    .local v0, "item":Lcom/amazon/mShop/gno/GNODrawerItemHideable;
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->isHiddenCallable:Ljava/util/concurrent/Callable;

    # setter for: Lcom/amazon/mShop/gno/GNODrawerItemHideable;->mIsHiddenCallable:Ljava/util/concurrent/Callable;
    invoke-static {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->access$002(Lcom/amazon/mShop/gno/GNODrawerItemHideable;Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Callable;

    .line 62
    return-object v0
.end method

.method public bridge synthetic build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;
    .locals 1

    .prologue
    .line 47
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    move-result-object v0

    return-object v0
.end method

.method public withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/Callable",
            "<",
            "Ljava/lang/Boolean;",
            ">;)TT;"
        }
    .end annotation

    .prologue
    .line 66
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder<TT;>;"
    .local p1, "callable":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<Ljava/lang/Boolean;>;"
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->isHiddenCallable:Ljava/util/concurrent/Callable;

    .line 67
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->self()Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    return-object v0
.end method
