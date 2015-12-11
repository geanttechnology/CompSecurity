.class public Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private descriptors:Ljava/lang/String;

.field private rating:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDescriptors()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;->descriptors:Ljava/lang/String;

    return-object v0
.end method

.method public getRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;->rating:Ljava/lang/String;

    return-object v0
.end method

.method public setDescriptors(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 21
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;->descriptors:Ljava/lang/String;

    .line 22
    return-void
.end method

.method public setRating(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;->rating:Ljava/lang/String;

    .line 30
    return-void
.end method
