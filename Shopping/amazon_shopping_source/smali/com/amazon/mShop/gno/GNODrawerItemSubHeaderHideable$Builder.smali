.class public Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;
.super Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;
.source "GNODrawerItemSubHeaderHideable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder",
        "<TT;>;>",
        "Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder",
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
    .line 45
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder<TT;>;"
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;

    invoke-direct {v0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;)V

    .line 46
    return-void
.end method


# virtual methods
.method public bridge synthetic build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;
    .locals 1

    .prologue
    .line 40
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;

    move-result-object v0

    return-object v0
.end method

.method public build()Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;
    .locals 2

    .prologue
    .line 50
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder<TT;>;"
    invoke-super {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;

    .line 52
    .local v0, "item":Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;->isHiddenCallable:Ljava/util/concurrent/Callable;

    # setter for: Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;->mIsHiddenCallable:Ljava/util/concurrent/Callable;
    invoke-static {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;->access$002(Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Callable;

    .line 53
    return-object v0
.end method

.method public withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;
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
    .line 57
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder<TT;>;"
    .local p1, "callable":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<Ljava/lang/Boolean;>;"
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;->isHiddenCallable:Ljava/util/concurrent/Callable;

    .line 58
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;->self()Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;

    return-object v0
.end method
