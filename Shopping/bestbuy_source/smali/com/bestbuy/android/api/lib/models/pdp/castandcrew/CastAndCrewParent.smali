.class public Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewParent;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private si:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/SICastAndCrewResponse;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSi()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/SICastAndCrewResponse;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewParent;->si:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/SICastAndCrewResponse;

    return-object v0
.end method

.method public setSi(Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/SICastAndCrewResponse;)V
    .locals 0

    .prologue
    .line 20
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewParent;->si:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/SICastAndCrewResponse;

    .line 21
    return-void
.end method
