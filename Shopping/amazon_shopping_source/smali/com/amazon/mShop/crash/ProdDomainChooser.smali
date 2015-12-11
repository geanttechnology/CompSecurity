.class public Lcom/amazon/mShop/crash/ProdDomainChooser;
.super Ljava/lang/Object;
.source "ProdDomainChooser.java"

# interfaces
.implements Lcom/amazon/device/crashmanager/DomainChooser;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public chooseDomain()Lcom/amazon/device/crashmanager/Domain;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/amazon/device/crashmanager/Domain;->PROD:Lcom/amazon/device/crashmanager/Domain;

    return-object v0
.end method
