.class public Lcom/bestbuy/android/api/lib/models/search/Track;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private release:Ljava/lang/String;

.field private relevancyVersion:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getRelease()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Track;->release:Ljava/lang/String;

    return-object v0
.end method

.method public getRelevancyVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Track;->relevancyVersion:Ljava/lang/String;

    return-object v0
.end method

.method public setRelease(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Track;->release:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setRelevancyVersion(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Track;->relevancyVersion:Ljava/lang/String;

    .line 43
    return-void
.end method
