.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private modelNumber:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getModelNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;->modelNumber:Ljava/lang/String;

    return-object v0
.end method

.method public setModelNumber(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;->modelNumber:Ljava/lang/String;

    .line 34
    return-void
.end method
