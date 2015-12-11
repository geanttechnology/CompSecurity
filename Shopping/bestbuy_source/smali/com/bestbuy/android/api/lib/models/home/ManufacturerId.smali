.class public Lcom/bestbuy/android/api/lib/models/home/ManufacturerId;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x7c9cf0014393bc4aL


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
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/ManufacturerId;->modelNumber:Ljava/lang/String;

    return-object v0
.end method

.method public setModelNumber(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/ManufacturerId;->modelNumber:Ljava/lang/String;

    .line 31
    return-void
.end method
