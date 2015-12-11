.class public Lcom/bestbuy/android/api/lib/models/pdp/BlackTieProtection;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private linkToBlackTieProtectionPdpTab:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public isLinkToBlackTieProtectionPdpTab()Z
    .locals 1

    .prologue
    .line 16
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BlackTieProtection;->linkToBlackTieProtectionPdpTab:Z

    return v0
.end method

.method public setLinkToBlackTieProtectionPdpTab(Z)V
    .locals 0

    .prologue
    .line 20
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BlackTieProtection;->linkToBlackTieProtectionPdpTab:Z

    .line 21
    return-void
.end method
