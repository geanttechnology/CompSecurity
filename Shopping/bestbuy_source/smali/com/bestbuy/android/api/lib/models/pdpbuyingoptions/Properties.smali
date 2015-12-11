.class public Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private freeShippingCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getFreeShippingCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;->freeShippingCode:Ljava/lang/String;

    return-object v0
.end method

.method public setFreeShippingCode(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 21
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;->freeShippingCode:Ljava/lang/String;

    .line 22
    return-void
.end method
