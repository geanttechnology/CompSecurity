.class public final Lyy;
.super Lyk;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Lpg;


# direct methods
.method public constructor <init>(Lpg;)V
    .locals 0

    invoke-direct {p0}, Lyk;-><init>()V

    iput-object p1, p0, Lyy;->a:Lpg;

    return-void
.end method


# virtual methods
.method public a(Lyg;)V
    .locals 2

    iget-object v0, p0, Lyy;->a:Lpg;

    new-instance v1, Lzc;

    invoke-direct {v1, p1}, Lzc;-><init>(Lyg;)V

    invoke-interface {v0, v1}, Lpg;->a(Lpf;)V

    return-void
.end method
