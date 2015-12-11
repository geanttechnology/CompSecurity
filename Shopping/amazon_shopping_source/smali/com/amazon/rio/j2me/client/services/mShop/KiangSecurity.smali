.class public Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;
.super Ljava/lang/Object;
.source "KiangSecurity.java"


# instance fields
.field private corpusAlgorithm:Ljava/lang/String;

.field private nonce:Ljava/lang/String;

.field private signature:Ljava/lang/String;

.field private signingAlgorithm:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCorpusAlgorithm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;->corpusAlgorithm:Ljava/lang/String;

    return-object v0
.end method

.method public getNonce()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;->nonce:Ljava/lang/String;

    return-object v0
.end method

.method public getSignature()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;->signature:Ljava/lang/String;

    return-object v0
.end method

.method public getSigningAlgorithm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;->signingAlgorithm:Ljava/lang/String;

    return-object v0
.end method
