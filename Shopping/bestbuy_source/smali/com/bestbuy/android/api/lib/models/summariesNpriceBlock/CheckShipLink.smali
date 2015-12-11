.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private height:J

.field private target:Ljava/lang/String;

.field private url:Ljava/lang/String;

.field private width:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getHeight()J
    .locals 2

    .prologue
    .line 28
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->height:J

    return-wide v0
.end method

.method public getTarget()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->target:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()J
    .locals 2

    .prologue
    .line 46
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->width:J

    return-wide v0
.end method

.method public setHeight(J)V
    .locals 1

    .prologue
    .line 52
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->height:J

    .line 53
    return-void
.end method

.method public setTarget(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->target:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->url:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public setWidth(J)V
    .locals 1

    .prologue
    .line 70
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CheckShipLink;->width:J

    .line 71
    return-void
.end method
