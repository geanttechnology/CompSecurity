.class public Lcom/amazon/mShop/gno/GNODrawerItemHideable;
.super Lcom/amazon/mShop/gno/GNODrawerItemSimple;
.source "GNODrawerItemHideable.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNOItemAdapter$HideableItem;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;
    }
.end annotation


# instance fields
.field private mIsHiddenCallable:Ljava/util/concurrent/Callable;
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
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 17
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 18
    return-void
.end method

.method static synthetic access$002(Lcom/amazon/mShop/gno/GNODrawerItemHideable;Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Callable;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemHideable;
    .param p1, "x1"    # Ljava/util/concurrent/Callable;

    .prologue
    .line 13
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->mIsHiddenCallable:Ljava/util/concurrent/Callable;

    return-object p1
.end method

.method public static builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 22
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    invoke-direct {v0, p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public getIsHiddenCallable()Ljava/util/concurrent/Callable;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/Callable",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->mIsHiddenCallable:Ljava/util/concurrent/Callable;

    return-object v0
.end method

.method public isHidden()Z
    .locals 1

    .prologue
    .line 28
    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->mIsHiddenCallable:Ljava/util/concurrent/Callable;

    if-eqz v0, :cond_0

    .line 29
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->mIsHiddenCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v0}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 35
    :goto_0
    return v0

    .line 31
    :catch_0
    move-exception v0

    .line 35
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setIsHiddenCallable(Ljava/util/concurrent/Callable;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/Callable",
            "<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 39
    .local p1, "callable":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<Ljava/lang/Boolean;>;"
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->mIsHiddenCallable:Ljava/util/concurrent/Callable;

    .line 40
    return-void
.end method
