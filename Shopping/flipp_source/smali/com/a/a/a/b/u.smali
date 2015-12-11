.class public final Lcom/a/a/a/b/u;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field a:Ljava/lang/String;

.field b:Ljava/io/InputStream;

.field c:Ljava/io/OutputStream;

.field d:Lcom/a/a/a/b/h;

.field e:Lcom/a/a/a/b/aa;

.field f:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .locals 1

    .prologue
    .line 390
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 366
    sget-object v0, Lcom/a/a/a/b/h;->a:Lcom/a/a/a/b/h;

    iput-object v0, p0, Lcom/a/a/a/b/u;->d:Lcom/a/a/a/b/h;

    .line 367
    sget-object v0, Lcom/a/a/a/b/aa;->b:Lcom/a/a/a/b/aa;

    iput-object v0, p0, Lcom/a/a/a/b/u;->e:Lcom/a/a/a/b/aa;

    .line 391
    iput-object p1, p0, Lcom/a/a/a/b/u;->a:Ljava/lang/String;

    .line 392
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/b/u;->f:Z

    .line 393
    iput-object p2, p0, Lcom/a/a/a/b/u;->b:Ljava/io/InputStream;

    .line 394
    iput-object p3, p0, Lcom/a/a/a/b/u;->c:Ljava/io/OutputStream;

    .line 395
    return-void
.end method
