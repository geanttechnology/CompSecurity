.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private longDesc:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "long"
    .end annotation
.end field

.field private shortDesc:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "short"
    .end annotation
.end field

.field private synopsis:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getLongDesc()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->longDesc:Ljava/lang/String;

    return-object v0
.end method

.method public getShortDesc()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->shortDesc:Ljava/lang/String;

    return-object v0
.end method

.method public getSynopsis()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->synopsis:Ljava/lang/String;

    return-object v0
.end method

.method public setLongDesc(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->longDesc:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setShortDesc(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->shortDesc:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setSynopsis(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->synopsis:Ljava/lang/String;

    .line 57
    return-void
.end method
