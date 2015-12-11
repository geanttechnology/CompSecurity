.class public Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionService;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private matrix:Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;
    .locals 1

    .prologue
    .line 13
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionService;->matrix:Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    return-object v0
.end method

.method public setMatrix(Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;)V
    .locals 0

    .prologue
    .line 17
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionService;->matrix:Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    .line 18
    return-void
.end method
