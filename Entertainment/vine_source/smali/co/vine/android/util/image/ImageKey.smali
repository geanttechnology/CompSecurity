.class public Lco/vine/android/util/image/ImageKey;
.super Ljava/lang/Object;
.source "ImageKey.java"


# instance fields
.field public final blurRadius:I

.field public final blurred:Z

.field public final circularCropped:Z

.field public desaturated:Z

.field public final height:I

.field public final requestResize:Z

.field public final url:Ljava/lang/String;

.field public final width:I


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 8
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 27
    move-object v0, p0

    move-object v1, p1

    move v3, v2

    move v4, v2

    move v5, v2

    move v6, v2

    move v7, v2

    invoke-direct/range {v0 .. v7}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;IIZZIZ)V

    .line 28
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;IIZ)V
    .locals 8
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "w"    # I
    .param p3, "h"    # I
    .param p4, "circularCropped"    # Z

    .prologue
    const/4 v5, 0x0

    .line 23
    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v6, v5

    move v7, v5

    invoke-direct/range {v0 .. v7}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;IIZZIZ)V

    .line 24
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;IIZZIZ)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .param p4, "circularCropped"    # Z
    .param p5, "blurred"    # Z
    .param p6, "blurRadius"    # I
    .param p7, "desaturated"    # Z

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object p1, p0, Lco/vine/android/util/image/ImageKey;->url:Ljava/lang/String;

    .line 42
    iput p2, p0, Lco/vine/android/util/image/ImageKey;->width:I

    .line 43
    iput p3, p0, Lco/vine/android/util/image/ImageKey;->height:I

    .line 44
    iput-boolean p4, p0, Lco/vine/android/util/image/ImageKey;->circularCropped:Z

    .line 45
    if-lez p2, :cond_0

    if-lez p3, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/util/image/ImageKey;->requestResize:Z

    .line 46
    iput-boolean p5, p0, Lco/vine/android/util/image/ImageKey;->blurred:Z

    .line 47
    iput p6, p0, Lco/vine/android/util/image/ImageKey;->blurRadius:I

    .line 48
    iput-boolean p7, p0, Lco/vine/android/util/image/ImageKey;->desaturated:Z

    .line 50
    if-nez p1, :cond_1

    .line 51
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Tried to create Image key with null url."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 45
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 53
    :cond_1
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 8
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "circularCropped"    # Z

    .prologue
    const/4 v2, 0x0

    .line 19
    move-object v0, p0

    move-object v1, p1

    move v3, v2

    move v4, p2

    move v5, v2

    move v6, v2

    move v7, v2

    invoke-direct/range {v0 .. v7}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;IIZZIZ)V

    .line 20
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZIZ)V
    .locals 8
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "blurred"    # Z
    .param p3, "blurRadius"    # I
    .param p4, "desaturated"    # Z

    .prologue
    const/4 v2, 0x0

    .line 15
    move-object v0, p0

    move-object v1, p1

    move v3, v2

    move v4, v2

    move v5, p2

    move v6, p3

    move v7, p4

    invoke-direct/range {v0 .. v7}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;IIZZIZ)V

    .line 16
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 57
    if-ne p0, p1, :cond_1

    move v2, v1

    .line 85
    :cond_0
    :goto_0
    return v2

    .line 60
    :cond_1
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-ne v3, v4, :cond_0

    move-object v0, p1

    .line 63
    check-cast v0, Lco/vine/android/util/image/ImageKey;

    .line 64
    .local v0, "imageKey":Lco/vine/android/util/image/ImageKey;
    iget v3, p0, Lco/vine/android/util/image/ImageKey;->height:I

    iget v4, v0, Lco/vine/android/util/image/ImageKey;->height:I

    if-ne v3, v4, :cond_0

    .line 67
    iget v3, p0, Lco/vine/android/util/image/ImageKey;->width:I

    iget v4, v0, Lco/vine/android/util/image/ImageKey;->width:I

    if-ne v3, v4, :cond_0

    .line 70
    iget-boolean v3, p0, Lco/vine/android/util/image/ImageKey;->blurred:Z

    iget-boolean v4, v0, Lco/vine/android/util/image/ImageKey;->blurred:Z

    if-ne v3, v4, :cond_0

    .line 73
    iget v3, p0, Lco/vine/android/util/image/ImageKey;->blurRadius:I

    iget v4, v0, Lco/vine/android/util/image/ImageKey;->blurRadius:I

    if-ne v3, v4, :cond_0

    .line 76
    iget-boolean v3, p0, Lco/vine/android/util/image/ImageKey;->circularCropped:Z

    iget-boolean v4, v0, Lco/vine/android/util/image/ImageKey;->circularCropped:Z

    if-ne v3, v4, :cond_0

    .line 79
    iget-boolean v3, p0, Lco/vine/android/util/image/ImageKey;->desaturated:Z

    iget-boolean v4, v0, Lco/vine/android/util/image/ImageKey;->desaturated:Z

    if-ne v3, v4, :cond_0

    .line 82
    iget-object v3, p0, Lco/vine/android/util/image/ImageKey;->url:Ljava/lang/String;

    if-eqz v3, :cond_2

    .line 83
    iget-object v1, p0, Lco/vine/android/util/image/ImageKey;->url:Ljava/lang/String;

    iget-object v2, v0, Lco/vine/android/util/image/ImageKey;->url:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    goto :goto_0

    .line 85
    :cond_2
    iget-object v3, v0, Lco/vine/android/util/image/ImageKey;->url:Ljava/lang/String;

    if-nez v3, :cond_3

    :goto_1
    move v2, v1

    goto :goto_0

    :cond_3
    move v1, v2

    goto :goto_1
.end method

.method public hashCode()I
    .locals 5

    .prologue
    const/4 v3, 0x1

    const/4 v1, 0x0

    .line 91
    iget-object v2, p0, Lco/vine/android/util/image/ImageKey;->url:Ljava/lang/String;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/util/image/ImageKey;->url:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 92
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    iget v4, p0, Lco/vine/android/util/image/ImageKey;->width:I

    add-int v0, v2, v4

    .line 93
    mul-int/lit8 v2, v0, 0x1f

    iget v4, p0, Lco/vine/android/util/image/ImageKey;->height:I

    add-int v0, v2, v4

    .line 94
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v2, p0, Lco/vine/android/util/image/ImageKey;->circularCropped:Z

    if-eqz v2, :cond_1

    move v2, v3

    :goto_1
    add-int v0, v4, v2

    .line 95
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v2, p0, Lco/vine/android/util/image/ImageKey;->blurred:Z

    if-eqz v2, :cond_2

    move v2, v3

    :goto_2
    add-int v0, v4, v2

    .line 96
    mul-int/lit8 v2, v0, 0x1f

    iget v4, p0, Lco/vine/android/util/image/ImageKey;->blurRadius:I

    add-int v0, v2, v4

    .line 97
    mul-int/lit8 v2, v0, 0x1f

    iget-boolean v4, p0, Lco/vine/android/util/image/ImageKey;->desaturated:Z

    if-eqz v4, :cond_3

    :goto_3
    add-int v0, v2, v3

    .line 98
    return v0

    .end local v0    # "result":I
    :cond_0
    move v0, v1

    .line 91
    goto :goto_0

    .restart local v0    # "result":I
    :cond_1
    move v2, v1

    .line 94
    goto :goto_1

    :cond_2
    move v2, v1

    .line 95
    goto :goto_2

    :cond_3
    move v3, v1

    .line 97
    goto :goto_3
.end method
