.class public Lcom/bestbuy/android/api/lib/models/pdpaccessories/PDPAccessoriesParent;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private si:Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSi()Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpaccessories/PDPAccessoriesParent;->si:Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;

    return-object v0
.end method

.method public setSi(Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;)V
    .locals 0

    .prologue
    .line 21
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpaccessories/PDPAccessoriesParent;->si:Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;

    .line 22
    return-void
.end method
