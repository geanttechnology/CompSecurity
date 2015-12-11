.class public interface abstract Lcom/amazon/mShop/gno/GNOItemAdapter$HideableItem;
.super Ljava/lang/Object;
.source "GNOItemAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNOItemAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "HideableItem"
.end annotation


# virtual methods
.method public abstract getIsHiddenCallable()Ljava/util/concurrent/Callable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/Callable",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end method

.method public abstract isHidden()Z
.end method
