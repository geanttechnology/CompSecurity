.class public Lcom/bestbuy/android/api/lib/models/home/SellerInfo;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x6bb6d70ae1f4ff74L


# instance fields
.field private seller:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSeller()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SellerInfo;->seller:Ljava/lang/String;

    return-object v0
.end method

.method public setSeller(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SellerInfo;->seller:Ljava/lang/String;

    .line 28
    return-void
.end method
