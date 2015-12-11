.class public final Ltg;
.super Lto;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Lol;


# direct methods
.method public constructor <init>(Lol;)V
    .locals 0

    invoke-direct {p0}, Lto;-><init>()V

    iput-object p1, p0, Ltg;->a:Lol;

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    iget-object v0, p0, Ltg;->a:Lol;

    invoke-virtual {v0}, Lol;->c()V

    return-void
.end method

.method public a(I)V
    .locals 1

    iget-object v0, p0, Ltg;->a:Lol;

    invoke-virtual {v0, p1}, Lol;->a(I)V

    return-void
.end method

.method public b()V
    .locals 1

    iget-object v0, p0, Ltg;->a:Lol;

    invoke-virtual {v0}, Lol;->d()V

    return-void
.end method

.method public c()V
    .locals 1

    iget-object v0, p0, Ltg;->a:Lol;

    invoke-virtual {v0}, Lol;->a()V

    return-void
.end method

.method public d()V
    .locals 1

    iget-object v0, p0, Ltg;->a:Lol;

    invoke-virtual {v0}, Lol;->b()V

    return-void
.end method
