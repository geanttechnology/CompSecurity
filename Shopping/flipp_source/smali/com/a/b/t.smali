.class public final Lcom/a/b/t;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Ljava/io/InputStream;

.field final b:Landroid/graphics/Bitmap;

.field final c:Z


# direct methods
.method public constructor <init>(Ljava/io/InputStream;Z)V
    .locals 2

    .prologue
    .line 72
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    if-nez p1, :cond_0

    .line 74
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Stream may not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 76
    :cond_0
    iput-object p1, p0, Lcom/a/b/t;->a:Ljava/io/InputStream;

    .line 77
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/a/b/t;->b:Landroid/graphics/Bitmap;

    .line 78
    iput-boolean p2, p0, Lcom/a/b/t;->c:Z

    .line 79
    return-void
.end method
