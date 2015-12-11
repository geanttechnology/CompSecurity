.class interface abstract Lcom/a/a/a/b/aa;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final b:Lcom/a/a/a/b/aa;

.field public static final c:Lcom/a/a/a/b/aa;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    new-instance v0, Lcom/a/a/a/b/l;

    invoke-direct {v0}, Lcom/a/a/a/b/l;-><init>()V

    sput-object v0, Lcom/a/a/a/b/aa;->b:Lcom/a/a/a/b/aa;

    .line 24
    new-instance v0, Lcom/a/a/a/b/e;

    invoke-direct {v0}, Lcom/a/a/a/b/e;-><init>()V

    sput-object v0, Lcom/a/a/a/b/aa;->c:Lcom/a/a/a/b/aa;

    return-void
.end method


# virtual methods
.method public abstract a(Ljava/io/InputStream;Z)Lcom/a/a/a/b/b;
.end method

.method public abstract a(Ljava/io/OutputStream;Z)Lcom/a/a/a/b/d;
.end method
