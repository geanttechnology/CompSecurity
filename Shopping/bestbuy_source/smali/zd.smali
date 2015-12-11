.class public final Lzd;
.super Lyw;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Lpi;


# direct methods
.method public constructor <init>(Lpi;)V
    .locals 0

    invoke-direct {p0}, Lyw;-><init>()V

    iput-object p1, p0, Lzd;->a:Lpi;

    return-void
.end method


# virtual methods
.method public a(Lys;)V
    .locals 2

    iget-object v0, p0, Lzd;->a:Lpi;

    new-instance v1, Lzb;

    invoke-direct {v1, p1}, Lzb;-><init>(Lys;)V

    invoke-interface {v0, v1}, Lpi;->a(Lph;)V

    return-void
.end method

.method public a(Ljava/lang/String;)Z
    .locals 1

    iget-object v0, p0, Lzd;->a:Lpi;

    invoke-interface {v0, p1}, Lpi;->a(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
