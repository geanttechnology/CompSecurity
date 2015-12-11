.class final Lok;
.super Lol;


# instance fields
.field private final a:Loi;

.field private final b:Lpd;


# direct methods
.method public constructor <init>(Loi;Lpd;)V
    .locals 0

    invoke-direct {p0}, Lol;-><init>()V

    iput-object p1, p0, Lok;->a:Loi;

    iput-object p2, p0, Lok;->b:Lpd;

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    iget-object v0, p0, Lok;->b:Lpd;

    iget-object v1, p0, Lok;->a:Loi;

    invoke-interface {v0, v1}, Lpd;->a(Lpc;)V

    return-void
.end method

.method public a(I)V
    .locals 2

    iget-object v0, p0, Lok;->b:Lpd;

    iget-object v1, p0, Lok;->a:Loi;

    invoke-interface {v0, v1, p1}, Lpd;->a(Lpc;I)V

    return-void
.end method

.method public b()V
    .locals 2

    iget-object v0, p0, Lok;->b:Lpd;

    iget-object v1, p0, Lok;->a:Loi;

    invoke-interface {v0, v1}, Lpd;->b(Lpc;)V

    return-void
.end method

.method public c()V
    .locals 2

    iget-object v0, p0, Lok;->b:Lpd;

    iget-object v1, p0, Lok;->a:Loi;

    invoke-interface {v0, v1}, Lpd;->c(Lpc;)V

    return-void
.end method

.method public d()V
    .locals 2

    iget-object v0, p0, Lok;->b:Lpd;

    iget-object v1, p0, Lok;->a:Loi;

    invoke-interface {v0, v1}, Lpd;->d(Lpc;)V

    return-void
.end method
