.class public Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private si:Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesResponse;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSi()Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesResponse;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;->si:Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesResponse;

    return-object v0
.end method

.method public setSi(Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesResponse;)V
    .locals 0

    .prologue
    .line 20
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;->si:Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesResponse;

    .line 21
    return-void
.end method
