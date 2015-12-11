.class abstract Lbl;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final synthetic a:Lbk;


# direct methods
.method private constructor <init>(Lbk;)V
    .locals 0

    .prologue
    .line 207
    iput-object p1, p0, Lbl;->a:Lbk;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lbk;B)V
    .locals 0

    .prologue
    .line 207
    invoke-direct {p0, p1}, Lbl;-><init>(Lbk;)V

    return-void
.end method


# virtual methods
.method abstract a()Ljava/io/InputStream;
.end method

.method final a(Ljava/net/URLConnection;)Ljava/io/InputStream;
    .locals 2

    .prologue
    .line 212
    iget-object v0, p0, Lbl;->a:Lbk;

    invoke-virtual {v0, p1}, Lbk;->b(Ljava/net/URLConnection;)V

    .line 214
    :try_start_0
    invoke-virtual {p0}, Lbl;->a()Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 220
    if-nez v1, :cond_0

    .line 221
    const/4 v0, 0x0

    .line 224
    :goto_0
    return-object v0

    .line 215
    :catch_0
    move-exception v0

    .line 216
    iget-object v1, p0, Lbl;->a:Lbk;

    invoke-virtual {v1, p1, v0}, Lbk;->a(Ljava/net/URLConnection;Ljava/lang/Exception;)V

    .line 217
    throw v0

    .line 224
    :cond_0
    new-instance v0, Lbl$1;

    invoke-direct {v0, p0, v1, p1}, Lbl$1;-><init>(Lbl;Ljava/io/InputStream;Ljava/net/URLConnection;)V

    goto :goto_0
.end method
