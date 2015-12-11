.class public Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/VisualPageTitle;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private Tall:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/TallName;

.field private shortName:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/ShortName;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "Short"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getShortName()Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/ShortName;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/VisualPageTitle;->shortName:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/ShortName;

    return-object v0
.end method

.method public getTall()Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/TallName;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/VisualPageTitle;->Tall:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/TallName;

    return-object v0
.end method

.method public setShortName(Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/ShortName;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/VisualPageTitle;->shortName:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/ShortName;

    .line 35
    return-void
.end method

.method public setTall(Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/TallName;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/VisualPageTitle;->Tall:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/TallName;

    .line 41
    return-void
.end method
