.class final Lcom/google/android/gms/common/images/ImageManager$b;
.super Lcom/google/android/gms/internal/hq;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/common/images/ImageManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "b"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/internal/hq",
        "<",
        "Lcom/google/android/gms/common/images/a$a;",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# virtual methods
.method protected a(Lcom/google/android/gms/common/images/a$a;Landroid/graphics/Bitmap;)I
    .locals 2

    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getRowBytes()I

    move-result v1

    mul-int/2addr v0, v1

    return v0
.end method

.method protected a(ZLcom/google/android/gms/common/images/a$a;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    .locals 0

    invoke-super {p0, p1, p2, p3, p4}, Lcom/google/android/gms/internal/hq;->entryRemoved(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    return-void
.end method

.method protected synthetic entryRemoved(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Z
    .param p2, "x1"    # Ljava/lang/Object;
    .param p3, "x2"    # Ljava/lang/Object;
    .param p4, "x3"    # Ljava/lang/Object;

    .prologue
    check-cast p2, Lcom/google/android/gms/common/images/a$a;

    .end local p2    # "x1":Ljava/lang/Object;
    check-cast p3, Landroid/graphics/Bitmap;

    .end local p3    # "x2":Ljava/lang/Object;
    check-cast p4, Landroid/graphics/Bitmap;

    .end local p4    # "x3":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/google/android/gms/common/images/ImageManager$b;->a(ZLcom/google/android/gms/common/images/a$a;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V

    return-void
.end method

.method protected synthetic sizeOf(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    check-cast p1, Lcom/google/android/gms/common/images/a$a;

    .end local p1    # "x0":Ljava/lang/Object;
    check-cast p2, Landroid/graphics/Bitmap;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/google/android/gms/common/images/ImageManager$b;->a(Lcom/google/android/gms/common/images/a$a;Landroid/graphics/Bitmap;)I

    move-result v0

    return v0
.end method
