.class public Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Image;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private altText:Ljava/lang/String;

.field private path:Ljava/lang/String;

.field private reftype:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "ref-type"
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
.method public getAltText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Image;->altText:Ljava/lang/String;

    return-object v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Image;->path:Ljava/lang/String;

    return-object v0
.end method

.method public getReftype()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Image;->reftype:Ljava/lang/String;

    return-object v0
.end method

.method public setAltText(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Image;->altText:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setPath(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Image;->path:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setReftype(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Image;->reftype:Ljava/lang/String;

    .line 56
    return-void
.end method
