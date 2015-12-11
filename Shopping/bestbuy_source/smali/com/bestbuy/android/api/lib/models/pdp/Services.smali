.class public Lcom/bestbuy/android/api/lib/models/pdp/Services;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private blackTieProtection:Lcom/bestbuy/android/api/lib/models/pdp/BlackTieProtection;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBlackTieProtection()Lcom/bestbuy/android/api/lib/models/pdp/BlackTieProtection;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/Services;->blackTieProtection:Lcom/bestbuy/android/api/lib/models/pdp/BlackTieProtection;

    return-object v0
.end method

.method public setBlackTieProtection(Lcom/bestbuy/android/api/lib/models/pdp/BlackTieProtection;)V
    .locals 0

    .prologue
    .line 20
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/Services;->blackTieProtection:Lcom/bestbuy/android/api/lib/models/pdp/BlackTieProtection;

    .line 21
    return-void
.end method
