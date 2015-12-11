.class public Lcom/bestbuy/android/api/lib/models/home/Attributes;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x560ca325ff590c88L


# instance fields
.field private exclusiveBrand:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getExclusiveBrand()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Attributes;->exclusiveBrand:Ljava/lang/String;

    return-object v0
.end method

.method public setExclusiveBrand(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Attributes;->exclusiveBrand:Ljava/lang/String;

    .line 30
    return-void
.end method
