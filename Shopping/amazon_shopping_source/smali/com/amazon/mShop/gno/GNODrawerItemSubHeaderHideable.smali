.class public Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;
.super Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;
.source "GNODrawerItemSubHeaderHideable.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNOItemAdapter$HideableItem;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;
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
    .line 15
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 16
    return-void
.end method

.method static synthetic access$002(Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Callable;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;
    .param p1, "x1"    # Ljava/util/concurrent/Callable;

    .prologue
    .line 10
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;->mIsHiddenCallable:Ljava/util/concurrent/Callable;

    return-object p1
.end method

.method public static builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 37
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;

    invoke-direct {v0, p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

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
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;->mIsHiddenCallable:Ljava/util/concurrent/Callable;

    return-object v0
.end method

.method public isHidden()Z
    .locals 1

    .prologue
    .line 21
    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;->mIsHiddenCallable:Ljava/util/concurrent/Callable;

    if-eqz v0, :cond_0

    .line 22
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;->mIsHiddenCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v0}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 27
    :goto_0
    return v0

    .line 24
    :catch_0
    move-exception v0

    .line 27
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
