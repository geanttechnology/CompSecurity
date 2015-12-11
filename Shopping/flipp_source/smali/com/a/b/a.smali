.class abstract Lcom/a/b/a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field final a:Lcom/a/b/ad;

.field final b:Lcom/a/b/ao;

.field final c:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<TT;>;"
        }
    .end annotation
.end field

.field final d:Z

.field final e:Z

.field final f:I

.field final g:Landroid/graphics/drawable/Drawable;

.field final h:Ljava/lang/String;

.field i:Z


# direct methods
.method constructor <init>(Lcom/a/b/ad;Ljava/lang/Object;Lcom/a/b/ao;ZZILandroid/graphics/drawable/Drawable;Ljava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/a/b/ad;",
            "TT;",
            "Lcom/a/b/ao;",
            "ZZI",
            "Landroid/graphics/drawable/Drawable;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-object p1, p0, Lcom/a/b/a;->a:Lcom/a/b/ad;

    .line 47
    iput-object p3, p0, Lcom/a/b/a;->b:Lcom/a/b/ao;

    .line 48
    new-instance v0, Lcom/a/b/b;

    iget-object v1, p1, Lcom/a/b/ad;->i:Ljava/lang/ref/ReferenceQueue;

    invoke-direct {v0, p0, p2, v1}, Lcom/a/b/b;-><init>(Lcom/a/b/a;Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V

    iput-object v0, p0, Lcom/a/b/a;->c:Ljava/lang/ref/WeakReference;

    .line 49
    iput-boolean p4, p0, Lcom/a/b/a;->d:Z

    .line 50
    iput-boolean p5, p0, Lcom/a/b/a;->e:Z

    .line 51
    iput p6, p0, Lcom/a/b/a;->f:I

    .line 52
    iput-object p7, p0, Lcom/a/b/a;->g:Landroid/graphics/drawable/Drawable;

    .line 53
    iput-object p8, p0, Lcom/a/b/a;->h:Ljava/lang/String;

    .line 54
    return-void
.end method


# virtual methods
.method abstract a()V
.end method

.method abstract a(Landroid/graphics/Bitmap;Lcom/a/b/aj;)V
.end method

.method b()V
    .locals 1

    .prologue
    .line 61
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/b/a;->i:Z

    .line 62
    return-void
.end method
