.class public final Lcom/a/a/a/i;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Closeable;


# instance fields
.field public final a:Ljava/lang/String;

.field public final b:J

.field public final c:[Ljava/io/InputStream;

.field public final synthetic d:Lcom/a/a/a/c;

.field private final e:[J


# direct methods
.method private constructor <init>(Lcom/a/a/a/c;Ljava/lang/String;J[Ljava/io/InputStream;[J)V
    .locals 1

    .prologue
    .line 671
    iput-object p1, p0, Lcom/a/a/a/i;->d:Lcom/a/a/a/c;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 672
    iput-object p2, p0, Lcom/a/a/a/i;->a:Ljava/lang/String;

    .line 673
    iput-wide p3, p0, Lcom/a/a/a/i;->b:J

    .line 674
    iput-object p5, p0, Lcom/a/a/a/i;->c:[Ljava/io/InputStream;

    .line 675
    iput-object p6, p0, Lcom/a/a/a/i;->e:[J

    .line 676
    return-void
.end method

.method synthetic constructor <init>(Lcom/a/a/a/c;Ljava/lang/String;J[Ljava/io/InputStream;[JB)V
    .locals 1

    .prologue
    .line 665
    invoke-direct/range {p0 .. p6}, Lcom/a/a/a/i;-><init>(Lcom/a/a/a/c;Ljava/lang/String;J[Ljava/io/InputStream;[J)V

    return-void
.end method


# virtual methods
.method public final close()V
    .locals 4

    .prologue
    .line 703
    iget-object v1, p0, Lcom/a/a/a/i;->c:[Ljava/io/InputStream;

    array-length v2, v1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    aget-object v3, v1, v0

    .line 704
    invoke-static {v3}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    .line 703
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 706
    :cond_0
    return-void
.end method
