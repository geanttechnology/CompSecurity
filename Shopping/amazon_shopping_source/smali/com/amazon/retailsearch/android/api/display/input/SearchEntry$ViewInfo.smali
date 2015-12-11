.class public Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;
.super Ljava/lang/Object;
.source "SearchEntry.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/api/display/input/SearchEntry;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ViewInfo"
.end annotation


# instance fields
.field private coords:[I

.field private height:I

.field private width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCoords()[I
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;->coords:[I

    return-object v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 48
    iget v0, p0, Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;->height:I

    return v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 38
    iget v0, p0, Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;->width:I

    return v0
.end method

.method public setCoords([I)V
    .locals 0
    .param p1, "coords"    # [I

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;->coords:[I

    .line 34
    return-void
.end method

.method public setHeight(I)V
    .locals 0
    .param p1, "height"    # I

    .prologue
    .line 53
    iput p1, p0, Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;->height:I

    .line 54
    return-void
.end method

.method public setWidth(I)V
    .locals 0
    .param p1, "width"    # I

    .prologue
    .line 43
    iput p1, p0, Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;->width:I

    .line 44
    return-void
.end method
