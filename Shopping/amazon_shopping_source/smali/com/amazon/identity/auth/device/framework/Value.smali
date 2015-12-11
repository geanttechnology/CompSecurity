.class public Lcom/amazon/identity/auth/device/framework/Value;
.super Ljava/lang/Object;
.source "Value.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/utils/PublicCloneable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/identity/auth/device/utils/PublicCloneable",
        "<",
        "Lcom/amazon/identity/auth/device/framework/Value",
        "<TT;>;>;"
    }
.end annotation


# instance fields
.field private final mValue:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 12
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<TT;>;"
    .local p1, "value":Ljava/lang/Object;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/Value;->mValue:Ljava/lang/Object;

    .line 14
    return-void
.end method


# virtual methods
.method public cloneObject()Lcom/amazon/identity/auth/device/framework/Value;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/identity/auth/device/framework/Value",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<TT;>;"
    :try_start_0
    new-instance v1, Lcom/amazon/identity/auth/device/framework/Value;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/Value;->mValue:Ljava/lang/Object;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->typeSafeClone(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/framework/Value;-><init>(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 28
    :catch_0
    move-exception v0

    .line 30
    .local v0, "e":Ljava/lang/CloneNotSupportedException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public bridge synthetic cloneObject()Lcom/amazon/identity/auth/device/utils/PublicCloneable;
    .locals 1

    .prologue
    .line 7
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/Value;->cloneObject()Lcom/amazon/identity/auth/device/framework/Value;

    move-result-object v0

    return-object v0
.end method

.method public getValue()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 18
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/Value;->mValue:Ljava/lang/Object;

    return-object v0
.end method
