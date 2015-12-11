.class final Lcom/a/a/a/b/e;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/a/a/a/b/aa;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 199
    return-void
.end method


# virtual methods
.method public final a(Ljava/io/InputStream;Z)Lcom/a/a/a/b/b;
    .locals 1

    .prologue
    .line 44
    new-instance v0, Lcom/a/a/a/b/f;

    invoke-direct {v0, p1}, Lcom/a/a/a/b/f;-><init>(Ljava/io/InputStream;)V

    return-object v0
.end method

.method public final a(Ljava/io/OutputStream;Z)Lcom/a/a/a/b/d;
    .locals 1

    .prologue
    .line 48
    new-instance v0, Lcom/a/a/a/b/g;

    invoke-direct {v0, p1}, Lcom/a/a/a/b/g;-><init>(Ljava/io/OutputStream;)V

    return-object v0
.end method
