.class final Loj;
.super Lol;


# instance fields
.field private final a:Loi;

.field private final b:Lpb;


# direct methods
.method public constructor <init>(Loi;Lpb;)V
    .locals 0

    invoke-direct {p0}, Lol;-><init>()V

    iput-object p1, p0, Loj;->a:Loi;

    iput-object p2, p0, Loj;->b:Lpb;

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    iget-object v0, p0, Loj;->b:Lpb;

    iget-object v1, p0, Loj;->a:Loi;

    invoke-interface {v0, v1}, Lpb;->a(Lpa;)V

    return-void
.end method

.method public a(I)V
    .locals 2

    iget-object v0, p0, Loj;->b:Lpb;

    iget-object v1, p0, Loj;->a:Loi;

    invoke-interface {v0, v1, p1}, Lpb;->a(Lpa;I)V

    return-void
.end method

.method public b()V
    .locals 2

    iget-object v0, p0, Loj;->b:Lpb;

    iget-object v1, p0, Loj;->a:Loi;

    invoke-interface {v0, v1}, Lpb;->e(Lpa;)V

    iget-object v0, p0, Loj;->b:Lpb;

    iget-object v1, p0, Loj;->a:Loi;

    invoke-interface {v0, v1}, Lpb;->b(Lpa;)V

    return-void
.end method

.method public c()V
    .locals 2

    iget-object v0, p0, Loj;->b:Lpb;

    iget-object v1, p0, Loj;->a:Loi;

    invoke-interface {v0, v1}, Lpb;->c(Lpa;)V

    return-void
.end method

.method public d()V
    .locals 2

    iget-object v0, p0, Loj;->b:Lpb;

    iget-object v1, p0, Loj;->a:Loi;

    invoke-interface {v0, v1}, Lpb;->d(Lpa;)V

    return-void
.end method
