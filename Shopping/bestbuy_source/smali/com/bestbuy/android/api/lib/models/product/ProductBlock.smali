.class public Lcom/bestbuy/android/api/lib/models/product/ProductBlock;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private haveValue:I

.field private wantValue:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData()Lcom/bestbuy/android/api/lib/models/product/ProductBlock;
    .locals 2

    .prologue
    .line 30
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/ProductBlock;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/product/ProductBlock;-><init>()V

    .line 31
    const/4 v1, 0x1

    iput v1, v0, Lcom/bestbuy/android/api/lib/models/product/ProductBlock;->wantValue:I

    .line 32
    const/4 v1, 0x0

    iput v1, v0, Lcom/bestbuy/android/api/lib/models/product/ProductBlock;->haveValue:I

    .line 34
    return-object v0
.end method


# virtual methods
.method public getHaveValue()I
    .locals 1

    .prologue
    .line 25
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductBlock;->haveValue:I

    return v0
.end method

.method public getWantValue()I
    .locals 1

    .prologue
    .line 21
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/product/ProductBlock;->wantValue:I

    return v0
.end method
