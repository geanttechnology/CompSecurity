.class public Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicDetails;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private credits:Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicCredits;

.field private specifications:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicSpecifications;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCredits()Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicCredits;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicDetails;->credits:Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicCredits;

    return-object v0
.end method

.method public getSpecifications()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicSpecifications;",
            ">;"
        }
    .end annotation

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicDetails;->specifications:Ljava/util/ArrayList;

    return-object v0
.end method

.method public setCredits(Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicCredits;)V
    .locals 0

    .prologue
    .line 23
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicDetails;->credits:Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicCredits;

    .line 24
    return-void
.end method

.method public setSpecifications(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicSpecifications;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicDetails;->specifications:Ljava/util/ArrayList;

    .line 32
    return-void
.end method
